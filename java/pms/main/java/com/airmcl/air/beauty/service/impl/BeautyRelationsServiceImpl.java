package com.airmcl.air.beauty.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.airmcl.air.beauty.dao.BeautyRelationsMapper;
import com.airmcl.air.beauty.dao.ext.BeautyRelationsExtMapper;
import com.airmcl.air.beauty.entity.Beauty;
import com.airmcl.air.beauty.entity.BeautyRelations;
import com.airmcl.air.beauty.entity.BeautyRelationsExample;
import com.airmcl.air.beauty.entity.BeautyRelationsGoodsVO;
import com.airmcl.air.beauty.entity.BeautyRelationsServiceVO;
import com.airmcl.air.beauty.entity.OutBeautyRelationsRecord;
import com.airmcl.air.beauty.service.BeautyRelationsService;
import com.airmcl.air.goods.entity.Goods;
import com.airmcl.air.service.dao.ServiceMapper;
import com.airmcl.air.beauty.service.BeautyService;
import com.airmcl.air.goods.dao.GoodsMapper;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;

@Service("defaultBeautyRelationsService")
public class BeautyRelationsServiceImpl implements BeautyRelationsService {
	private static Logger logger = LoggerFactory.getLogger(BeautyRelationsServiceImpl.class);
    @Resource
    protected BeautyRelationsMapper beautyRelationsMapper;
    @Resource
    protected BeautyRelationsExtMapper beautyRelationsExtMapper;
    @Resource
	protected GoodsMapper goodsMapper;
    @Resource
	protected BeautyService beautyService;
    @Resource
    protected ServiceMapper serviceMapper;
    

    @CacheEvict(value={"beautyRelations"}, allEntries=true)
    @Override
    public void addObj(BeautyRelations t) {
        this.beautyRelationsMapper.insertSelective(t);
    }

    @CacheEvict(value={"beautyRelations"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beautyRelationsMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beautyRelations"}, allEntries=true)
    @Override
    public void modifyObj(BeautyRelations t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beautyRelationsMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beautyRelations", keyGenerator="redisKeyGenerator")
    @Override
    public BeautyRelations queryObjById(Integer id) {
        return this.beautyRelationsMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beautyRelations", key="'BeautyRelationsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeautyRelations> queryAllObjByExample(BeautyRelationsExample example) {
        return this.beautyRelationsMapper.selectByExample(example);
    }

    @Cacheable(value="beautyRelations", key="'BeautyRelationsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeautyRelations> queryObjByPage(BeautyRelationsExample example) {
        PageView<BeautyRelations> pageView = example.getPageView();
        pageView.setQueryResult(this.beautyRelationsMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	/**
	 * 获取门店关联服务项目
	 */
	public List<BeautyRelationsServiceVO> selectServiceByBeautyId(Map<String, Object> para) {
		return beautyRelationsExtMapper.selectServiceByBeautyId(para);
	}
	
	@Override
	/**
	 * 获取门店关联商品
	 */
	public List<BeautyRelationsGoodsVO> selectGoodsByBeautyId(Map<String, Object> para) {
		return beautyRelationsExtMapper.selectGoodsByBeautyId(para);
	}
	
	@Override
	 /**
	  * 根据id获取关联关系 
	  * @param id
	  * @return
	  */
	public  BeautyRelations selectByPrimaryKey(Integer id){
		 return beautyRelationsMapper.selectByPrimaryKey(id);
	}
	/**
	 * 查找门店关联项目记录
	 */
	@Override
	public PageView<OutBeautyRelationsRecord> findBeautyRelationsRecord(int pageNo, int pageSize) {
		BeautyRelationsExample example = new BeautyRelationsExample();
		example.setPageView(new PageView<BeautyRelations>(pageNo, pageSize));
		example.setOrderByClause("createtime desc");
		// 查询mdd_api_beauty_relations表获得主体信息
		logger.info("开始查询mdd_api_beauty_relations主表信息!");
		List<BeautyRelations> ListData = beautyRelationsMapper.selectByExampleByPage(example);
		if (ListData == null || ListData.size() < 1) {
			throw new CommonException("主表mdd_api_beauty_relations列表查询为空!");
		}
		PageView<BeautyRelations> pageView = example.getPageView();
		// 返回page实体
		PageView<OutBeautyRelationsRecord> resultData = new PageView<OutBeautyRelationsRecord>();
		
		resultData.setPageNo(pageView.getPageNo());
		resultData.setPageSize(pageView.getPageSize());
		resultData.setRowCount(pageView.getRowCount());

		ArrayList<OutBeautyRelationsRecord> outBeautyRelationsRecords = new ArrayList<OutBeautyRelationsRecord>();
		Map<String,String> map = new HashMap<String,String>();// key ： bt_id  value:bt_name
		
		for (BeautyRelations list : ListData) {
			
			logger.info("***************************************btId = "+list.getBeautyId());
			OutBeautyRelationsRecord outBeautyRelationsRecord = new OutBeautyRelationsRecord();
			Integer beautyId = list.getBeautyId();
			Integer brId = list.getRelationId();
			/**
			 * 根据关联的ServiceId 查询服务项目名称.
			 * 分两种情况,在mdd_api_beauty_relations表内有type字段，如果是1则从查询服务项目mdd_api_service表内的名称，如果是2则查询商品表mdd_api_goods
			 */
			if (list.getType() == 1) {
				com.airmcl.air.service.entity.Service services = this.serviceMapper.selectByPrimaryKey(brId);
				if(services != null) {
					outBeautyRelationsRecord.setServiceName(services.getServiceName());
				}
			}else if(list.getType() == 2) {
				Goods goods = this.goodsMapper.selectByPrimaryKey(brId);
				if(goods != null) {
					outBeautyRelationsRecord.setServiceName(goods.getGoodsName());
				}
			}
			// 判断是否存在重复的门店信息
			if(map.containsKey(beautyId+"")) {// 不存在则查找
				logger.info(" btId = "+beautyId+" btName = "+map.get(beautyId+""));
				outBeautyRelationsRecord.setBeautyName((map.get(beautyId+""))==null ? "" : map.get(beautyId+"") ); // 门店名称
			}else {
				Beauty beauty = beautyService.queryObjById(beautyId);
				outBeautyRelationsRecord.setBeautyName(beauty.getBeautyName());
				map.put(beautyId+"", beauty.getBeautyName());
				logger.info("not btId");
			}
			//Beauty beauty = beautyService.queryObjById(beautyId);  --->优化
			// 查找关联表门店主表--->获取门店名称
			outBeautyRelationsRecord.setId(list.getId()); // 门店id
			outBeautyRelationsRecord.setType(list.getType()); // 类型
			outBeautyRelationsRecord.setOperateType(list.getOperateType()); // 操作者类型
			outBeautyRelationsRecord.setOperateId(list.getOperateId()); // 操作者ID
			outBeautyRelationsRecord.setState(list.getState()); // 状态
			outBeautyRelationsRecord.setCreateTime(list.getCreatetime()); // 创建时间
			
			outBeautyRelationsRecord.setBt_id(brId);
			outBeautyRelationsRecord.setRb_id(brId);
			
		  //outBeautyRelationsRecord.setBeautyName(map.get(beautyId+"")); // 门店名称
			outBeautyRelationsRecords.add(outBeautyRelationsRecord);
		}
		resultData.setQueryResult(outBeautyRelationsRecords);
		return resultData;
	}
}