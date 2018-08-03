package com.airmcl.air.beauty.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.beauty.dao.BeautyExtendMapper;
import com.airmcl.air.beauty.dao.BeautyMapper;
import com.airmcl.air.beauty.dao.BeautyProfitMapper;
import com.airmcl.air.beauty.entity.Beauty;
import com.airmcl.air.beauty.entity.BeautyExample;
import com.airmcl.air.beauty.entity.BeautyExtend;
import com.airmcl.air.beauty.entity.BeautyExtendExample;
import com.airmcl.air.beauty.entity.BeautyProfit;
import com.airmcl.air.beauty.entity.EnterBeautyVO;
import com.airmcl.air.beauty.service.BeautyService;
import com.els.base.core.entity.PageView;

@Service("defaultBeautyService")
public class BeautyServiceImpl implements BeautyService {
    @Resource
    protected BeautyMapper beautyMapper;

    @Resource
    protected BeautyExtendMapper beautyExtendMapper;
    
    @Resource
    protected BeautyProfitMapper beautyProfitMapper;
    
    @Transactional
    @Override
	public void updateBeautyDetail(EnterBeautyVO enterBeautyVO) throws RuntimeException {
    	Beauty beauty = enterBeautyVO.getBeauty();
    	BeautyExtend beautyExtend= enterBeautyVO.getBeautyExtend();
    	List<BeautyProfit> beautyProfitList = enterBeautyVO.getBeautyProfitList();
    	Integer butyId = beauty.getId();
    	if(beauty!=null){
    		Beauty beautyDB = beautyMapper.selectByPrimaryKey(butyId);
    		if(beautyDB!=null){
    			beautyMapper.updateByPrimaryKeySelective(beauty);
    		}
    	}
    	BeautyExtendExample beautyExtendExample = new BeautyExtendExample();
    	beautyExtendExample.createCriteria().andBeautyIdEqualTo(butyId);
    	List<BeautyExtend> beautyExtendList = beautyExtendMapper.selectByExample(beautyExtendExample);
    	if(beautyExtendList!=null&&beautyExtendList.size()>0){
    		beautyExtendMapper.updateByPrimaryKeySelective(beautyExtend);
    	}
    	if(beautyProfitList!=null&&beautyProfitList.size()>0){
    		for (BeautyProfit beautyProfit : beautyProfitList) {
    			 beautyProfitMapper.updateByPrimaryKeySelective(beautyProfit);
			}
    	}
	}
    @Transactional
    @Override
	public void addBeautyDetail(EnterBeautyVO enterBeautyVO,final Integer createtime) throws RuntimeException {
    	Beauty beauty = enterBeautyVO.getBeauty();
    	BeautyExtend beautyExtend= enterBeautyVO.getBeautyExtend();
    	List<BeautyProfit> beautyProfitList = enterBeautyVO.getBeautyProfitList();
			if(beauty!=null){
				beauty.setCreatetime(String.valueOf(createtime));
//				beautyMapper.insert(beauty);
				beautyMapper.insertSelective(beauty);
			}
			Integer beautyId=beauty.getId();
			if(beautyExtend!=null){
				beautyExtend.setBeautyId(beautyId);
				beautyExtendMapper.insertSelective(beautyExtend);
			}
			if(!beautyProfitList.isEmpty()){
				for (BeautyProfit beautyProfit : beautyProfitList) {
					 beautyProfit.setBeautyId(beautyId);
					 beautyProfit.setCreatetime(createtime);
					 beautyProfit.setState((byte)1);
				}
				beautyProfitMapper.insertBatch(beautyProfitList);
			}
	}
    @CacheEvict(value={"beauty"}, allEntries=true)
    @Override
    public void addObj(Beauty t) {
        this.beautyMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauty"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beautyMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauty"}, allEntries=true)
    @Override
    public void modifyObj(Beauty t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beautyMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauty", keyGenerator="redisKeyGenerator")
    @Override
    public Beauty queryObjById(Integer id) {
        return this.beautyMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauty", key="'BeautyService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Beauty> queryAllObjByExample(BeautyExample example) {
        return this.beautyMapper.selectByExample(example);
    }

    @Cacheable(value="beauty", key="'BeautyService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Beauty> queryObjByPage(BeautyExample example) {
        PageView<Beauty> pageView = example.getPageView();
        pageView.setQueryResult(this.beautyMapper.selectByExampleByPage(example));
        return pageView;
    }
    
    /**
     * 根据id数组查询对应门店详情
     * @param ids
     * @return
     */
	@Override
	public List<Beauty> selectDetilByIds(String id) {
		
		List<Beauty> list = new ArrayList<Beauty>();
    	String[] strs = id.split(",");
    	for (String string : strs) {
    		Integer ids = Integer.parseInt(string);
			Beauty detilInfo =  beautyMapper.selectByPrimaryKey(ids);
			if (detilInfo != null) {
				list.add(detilInfo);
			}
		}
		return list;
	}
	
	
}