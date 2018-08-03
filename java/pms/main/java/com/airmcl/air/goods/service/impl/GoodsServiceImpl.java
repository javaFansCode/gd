package com.airmcl.air.goods.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.beauty.dao.BeautyRelationsMapper;
import com.airmcl.air.beauty.entity.BeautyRelations;
import com.airmcl.air.beauty.entity.BeautyRelationsExample;
import com.airmcl.air.goods.dao.GoodsAutoShelveMapper;
import com.airmcl.air.goods.dao.GoodsExtendMapper;
import com.airmcl.air.goods.dao.GoodsFormMapper;
import com.airmcl.air.goods.dao.GoodsHomeBuyMapper;
import com.airmcl.air.goods.dao.GoodsHomeBuyRecordMapper;
import com.airmcl.air.goods.dao.GoodsMapper;
import com.airmcl.air.goods.dao.GoodsRelationsMapper;
import com.airmcl.air.goods.dao.ext.GoodsAutoShelveExtMapper;
import com.airmcl.air.goods.dao.ext.GoodsExtendExtMapper;
import com.airmcl.air.goods.dao.ext.GoodsHomeBuyExtMapper;
import com.airmcl.air.goods.dao.ext.GoodsHomeBuyRecordExtMapper;
import com.airmcl.air.goods.dao.ext.GoodsRelationsExtMapper;
import com.airmcl.air.goods.entity.Goods;
import com.airmcl.air.goods.entity.GoodsAutoShelve;
import com.airmcl.air.goods.entity.GoodsExample;
import com.airmcl.air.goods.entity.GoodsExtend;
import com.airmcl.air.goods.entity.GoodsForm;
import com.airmcl.air.goods.entity.GoodsFormExample;
import com.airmcl.air.goods.entity.GoodsHomeBuy;
import com.airmcl.air.goods.entity.GoodsHomeBuyRecord;
import com.airmcl.air.goods.entity.GoodsHomeBuyVo;
import com.airmcl.air.goods.entity.GoodsRelations;
import com.airmcl.air.goods.entity.GoodsVo;
import com.airmcl.air.goods.service.GoodsService;
import com.airmcl.air.service.dao.ext.ServiceExtMapper;
import com.airmcl.basae.utils.DateUtil;
import com.els.base.core.entity.PageView;

@Service("defaultGoodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    protected GoodsMapper goodsMapper;
    @Resource
    protected GoodsExtendExtMapper goodsExtendExtMapper;
    @Resource
    protected GoodsExtendMapper goodsExtendMapper;
    @Resource
    protected GoodsAutoShelveExtMapper goodsAutoShelveExtMapper;
    @Resource
    protected GoodsAutoShelveMapper goodsAutoShelveMapper;
    @Resource
    protected GoodsHomeBuyExtMapper goodsHomeBuyExtMapper;
    @Resource
    protected GoodsHomeBuyMapper goodsHomeBuyMapper;
    @Resource
    protected GoodsHomeBuyRecordMapper goodsHomeBuyRecordMapper;
    @Resource
    protected ServiceExtMapper serviceExtMapper; 
    @Resource
    protected GoodsRelationsExtMapper goodsRelationsExtMapper; 
    @Resource
    protected GoodsRelationsMapper goodsRelationsMapper;
    @Resource
    protected  GoodsHomeBuyRecordExtMapper goodsHomeBuyRecordExtMapper;
    @Resource
    protected BeautyRelationsMapper beautyRelationsMapper;
    @Resource
    protected GoodsFormMapper goodsFormMapper;
    
    @CacheEvict(value={"goods"}, allEntries=true)
    @Override
    public void addObj(Goods t) {
        this.goodsMapper.insertSelective(t);
    }

    @CacheEvict(value={"goods"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.goodsMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"goods"}, allEntries=true)
    @Override
    public void modifyObj(Goods t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.goodsMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="goods", keyGenerator="redisKeyGenerator")
    @Override
    public Goods queryObjById(Integer id) {
        return this.goodsMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="goods", key="'GoodsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Goods> queryAllObjByExample(GoodsExample example) {
        return this.goodsMapper.selectByExample(example);
    }

    @Cacheable(value="goods", key="'GoodsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Goods> queryObjByPage(GoodsExample example) {
        PageView<Goods> pageView = example.getPageView();
        pageView.setQueryResult(this.goodsMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public GoodsExtend queryGoodsExtendByGoodsId(Integer goodsId) {
		return goodsExtendExtMapper.selectGoodsExtendByGoodsId(goodsId);
	}

	@Transactional
	@Override
	public int addGoodsAndGoodsExtend(GoodsVo vo) throws RuntimeException {
		Goods goods = vo.getGoods();
		goodsMapper.insertSelective(goods);
		GoodsExtend goodsExtend= vo.getGoodsExtend();
		goodsExtend.setGoodsId(goods.getId());
		goodsExtendMapper.insertSelective(goodsExtend);
		return 1;
	}
	@Transactional
	@Override
	public int modifyGoodsAndGoodsExtend(GoodsVo vo) throws RuntimeException {
		Goods goods = vo.getGoods();
		GoodsExtend goodsExtend=vo.getGoodsExtend();
		goodsMapper.updateByPrimaryKeySelective(goods);
		goodsExtendMapper.updateByPrimaryKeySelective(goodsExtend);
		return 1;
	}

	@Override
	public GoodsAutoShelve queryGoodsAutoShelveByGoodsId(Integer goodId) {
		return goodsAutoShelveExtMapper.selectGoodsAutoShelveByGoodsId(goodId);
	}

	@Override
	public int addGoodsAutoShelve(GoodsAutoShelve goodsAutoShelve) {
		Integer id = goodsAutoShelve.getId();
		if(id!=null){
			return goodsAutoShelveMapper.updateByPrimaryKeySelective(goodsAutoShelve);
		}
		return goodsAutoShelveMapper.insertSelective(goodsAutoShelve);
	}

	@Override
	public GoodsHomeBuy queryGoodsHomeBuyByGoodsId(Integer goodsId) {
		return goodsHomeBuyExtMapper.selectGoodsHomeBuyByGoodsId(goodsId);
	}
    @Transactional
	@Override
	public int modifyGoodsHomeBuyAndGoodsHomeBuyRecord(GoodsHomeBuyVo vo) throws RuntimeException {
    	GoodsHomeBuy homeBuy = vo.getGoodsHomeBuy();
    	GoodsHomeBuyRecord record =vo.getGoodsHomeBuyRecord();
    	Long createtime = System.currentTimeMillis()/1000;
    	
    	if(homeBuy.getId()==null){
    		homeBuy.setCreatetime(createtime.intValue());
    		goodsHomeBuyMapper.insertSelective(homeBuy);
    		record.setType("add");
    	}else{
    		goodsHomeBuyMapper.updateByPrimaryKeySelective(homeBuy);
    		record.setType("edit");
    	}
    	Byte purchase =  homeBuy.getIsPurchase();
		if(purchase==2){
			Long time =DateUtil.getTimeLong();
			Integer goodsId = homeBuy.getGoodsId();
			GoodsFormExample goodsFormExample = new GoodsFormExample();
			goodsFormExample.createCriteria().andGoodsIdEqualTo(goodsId);
			Integer total = homeBuy.getTotal();
			int num=goodsFormMapper.countByExample(goodsFormExample);
			int addNum = total-num;
			if(addNum>0){
				 List<GoodsForm> goodsFormArray = new ArrayList<GoodsForm>();
				 for(int i=0;i<addNum;i++){
					 GoodsForm gf = new GoodsForm();
					 gf.setGoodsId(goodsId);
					 gf.setCreatetime(time.intValue());
					 goodsFormArray.add(gf);
				 }
				 goodsFormMapper.insertBatch(goodsFormArray);
			}else if(addNum<0){
				int limit = Math.abs(addNum);
				GoodsFormExample example = new GoodsFormExample();
				example.createCriteria().andGoodsIdEqualTo(goodsId);
				List<GoodsForm> goodsFormList = goodsFormMapper.selectByExample(example);
				for(int a = 0;a<limit;a++){
					 Integer id=goodsFormList.get(a).getId();
					 goodsFormMapper.deleteByPrimaryKey(id);
				}
			}
		}
    	record.setCreatetime(createtime.intValue());
    	goodsHomeBuyRecordMapper.insertSelective(record);
    	Goods goods = new Goods();
    	goods.setId(homeBuy.getGoodsId());
    	goods.setIsPurchase(homeBuy.getIsPurchase());
		goodsMapper.updateByPrimaryKeySelective(goods);
		return 1;
	}

	@Override
	public GoodsHomeBuyRecord queryGoodsHomeBuyRecord(Integer goodsId) {
		return goodsHomeBuyRecordExtMapper.selectGoodsHomeBuyRecordByGoodsId(goodsId);
	}

	@Override
	public List<com.airmcl.air.service.entity.Service> queryAllSingleTypeOneService() {
		return serviceExtMapper.selectAllSingleAndTypeOneService();
//		return null;
	}

	@Override
	public List<GoodsRelations> queryGoodsRelationsByGoodsId(Integer goodsId) {
		return goodsRelationsExtMapper.selectGoodsRelationsByGoodsId(goodsId);
	}

	@Transactional
	@Override
	public boolean modifyGoodsRelations(List<GoodsRelations> godsRelations,Integer goodsId)throws RuntimeException {
		List<GoodsRelations> list = goodsRelationsExtMapper.selectGoodsRelationsByGoodsId(goodsId);
		if(list!=null&&!list.isEmpty()){
			goodsRelationsExtMapper.deleteGoodsRelationsByGoodsId(goodsId);
		}
		if(godsRelations!=null&&!godsRelations.isEmpty()){
			goodsRelationsMapper.insertBatch(godsRelations);
		}
		return true;
	}

	@Transactional
	@Override
	public int modifyGoodsDetailState(Integer goodId, Byte state) throws RuntimeException {
		Goods goods = goodsMapper.selectByPrimaryKey(goodId);
		int result = 0;
		if(goods==null){
			return result;
		}
		Goods record = new Goods();
		record.setId(goodId);
		//1=正常，4=下架，0=删除
		switch (state) {
		case 1:
			//检查good_relation 有没有关联项目开始
			Byte goodType = goods.getType();
			//是月卡
			if(goodType==3){
				//TODO
				List<GoodsRelations> goodsRelationsList = goodsRelationsExtMapper.selectGoodsRelationsByGoodsId(goodId);
				if(goodsRelationsList==null||goodsRelationsList.size()==0){
					return result = -1;
				}
			}
			//检查good_relation 有没有关联项目结束
			BeautyRelationsExample example = new BeautyRelationsExample();
			example.createCriteria().andStateEqualTo((byte)0)//
			.andRelationIdEqualTo(goodId)//
			.andTypeEqualTo((byte)2);
			List<BeautyRelations> beautyRelationsList = beautyRelationsMapper.selectByExample(example);
			if(beautyRelationsList!=null&&beautyRelationsList.size()>0){
				//把状态改为正常
				BeautyRelations beautyRelationsRecord = new BeautyRelations();
				beautyRelationsRecord.setState((byte)1);
				int re = beautyRelationsMapper.updateByExampleSelective(beautyRelationsRecord, example);
				result=re+result;
			}
			record.setState(state);
			goodsMapper.updateByPrimaryKeySelective(record);
			break;
		case 4:
		case 0:
			BeautyRelationsExample example2 = new BeautyRelationsExample();
			example2.createCriteria().andStateEqualTo((byte)1)//
			.andRelationIdEqualTo(goodId)//
			.andTypeEqualTo((byte)2);
			List<BeautyRelations> beautyRelationsList2 = beautyRelationsMapper.selectByExample(example2);
			if(beautyRelationsList2!=null&&beautyRelationsList2.size()>0){
				//把状态改为删除
				BeautyRelations beautyRelationsRecord2 = new BeautyRelations();
				beautyRelationsRecord2.setState((byte)0);
				int res = beautyRelationsMapper.updateByExampleSelective(beautyRelationsRecord2, example2);
				result=res+result;
			}
			record.setState(state);
			goodsMapper.updateByPrimaryKeySelective(record);
			break;
		default:
			break;
		}
		return result;
	}

	 
}