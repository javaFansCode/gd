package com.airmcl.air.red.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.basae.utils.DateUtil;
import com.airmcl.air.red.dao.RedEventGiftMapper;
import com.airmcl.air.red.dao.RedEventMapper;
import com.airmcl.air.red.dao.RedMapper;
import com.airmcl.air.red.dao.ext.RedEventExtMapper;
import com.airmcl.air.red.dao.ext.RedEventGiftExtMapper;
import com.airmcl.air.red.entity.Red;
import com.airmcl.air.red.entity.RedEvent;
import com.airmcl.air.red.entity.RedEventExample;
import com.airmcl.air.red.entity.RedEventGift;
import com.airmcl.air.red.entity.RedEventGiftExample;
import com.airmcl.air.red.entity.RedEventGiftVo;
import com.airmcl.air.red.entity.RedEventVo;
import com.airmcl.air.red.entity.RedExample;
import com.airmcl.air.red.entity.RedVo;
import com.airmcl.air.red.service.RedService;
import com.els.base.core.entity.PageView;

@Service("defaultRedService")
public class RedServiceImpl implements RedService {
    @Resource
    protected RedMapper redMapper;
    @Resource
    protected RedEventGiftExtMapper redEventGiftExtMapper;
    @Resource
    protected RedEventMapper redEventMapper;
    @Resource
    protected RedEventGiftMapper redEventGiftMapper;
    @Resource
    protected RedEventExtMapper redEventExtMapper;
    
    @CacheEvict(value={"red"}, allEntries=true)
    @Override
    public void addObj(Red t) {
        this.redMapper.insertSelective(t);
    }

    @CacheEvict(value={"red"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.redMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"red"}, allEntries=true)
    @Override
    public void modifyObj(Red t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.redMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="red", keyGenerator="redisKeyGenerator")
    @Override
    public Red queryObjById(Integer id) {
        return this.redMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="red", key="'RedService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Red> queryAllObjByExample(RedExample example) {
        return this.redMapper.selectByExample(example);
    }

    @Cacheable(value="red", key="'RedService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Red> queryObjByPage(RedExample example) {
        PageView<Red> pageView = example.getPageView();
        pageView.setQueryResult(this.redMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public RedVo queryRedDetailByRedId(Integer redId) {
		RedVo redVo = new RedVo();
		RedEventExample example = new RedEventExample();
		RedEventExample.Criteria criteriaRedEventExample = example.createCriteria();
		criteriaRedEventExample.andRedIdEqualTo(redId);
		criteriaRedEventExample.andStateEqualTo(Byte.valueOf("1"));
		List<RedEvent> redEventList = redEventMapper.selectByExample(example);
		if(redEventList!=null&&redEventList.size()>0){
			//红包触发事件集合
			List<RedEventVo> redEventVoList = new ArrayList<RedEventVo>();
			//红包发送的礼物集合
			List<RedEventGiftVo> redEventGiftVoList = redEventGiftExtMapper.selectRedEventGiftsByRedId(redId);
			//单层for循环转换成为 RedEventVo
			for (RedEvent redEvent : redEventList) {
				 RedEventVo v = new RedEventVo();
				 v.setCreatetime(redEvent.getCreatetime());
				 v.setId(redEvent.getId());
				 v.setRedId(redEvent.getRedId());
				 v.setType(redEvent.getType());
				 v.setState(redEvent.getState());
				 redEventVoList.add(v);
			   } 
			  //对红包发送的礼物集合进行分类
			  if(redEventGiftVoList!=null&&!redEventGiftVoList.isEmpty()){
				  Map<Integer,List<RedEventGiftVo>> redEventGiftVoMaps = new HashMap<Integer,List<RedEventGiftVo>>();
				  for (RedEventGiftVo redEventGiftVo : redEventGiftVoList) {
					     Integer redEventId = redEventGiftVo.getRedEventId();
					     if(redEventGiftVoMaps.containsKey(redEventId)){
					    	 redEventGiftVoMaps.get(redEventId).add(redEventGiftVo);
					      }else{
					    	  List<RedEventGiftVo> temps = new ArrayList<RedEventGiftVo>();
					    	  temps.add(redEventGiftVo);
					    	  redEventGiftVoMaps.put(redEventId, temps);
					    	  temps = null;
					      }
				   }
				  //把触发事件和礼物关联起来
				  for (RedEventVo redEventVo : redEventVoList) {
					   final Integer redEventVoId = redEventVo.getId();
					    if(redEventGiftVoMaps.containsKey(redEventVoId)){
							redEventVo.setRedEventGiftVoList(redEventGiftVoMaps.get(redEventVoId));
					    }
				    }
				  redEventGiftVoMaps = null;
			  }
			  redVo.setRedEventVoList(redEventVoList);
			  redEventList = null;
			  redEventVoList = null;
		}
		return redVo;
	}

	@Transactional
	@Override
	public boolean modifyRedDetailInfo(RedVo vo) throws RuntimeException {
		Red newRed = vo.getRed();
		List<RedEventVo> newRedEventVoList = vo.getRedEventVoList();
		Byte newRedType = newRed.getType();
		if(newRedType==null){
			return false;
		}
		//1 红包类型的修改
		Integer redId = newRed.getId();
		Red dbRed = redMapper.selectByPrimaryKey(redId);
		if(dbRed==null){
			return false;
		}
		if(newRedEventVoList!=null&&newRedEventVoList.size()>0){
			Long val = (DateUtil.getTimeLong()/1000);
			Integer createTime = val.intValue();
			RedEventExample redEventExample = new RedEventExample();
			redEventExample.createCriteria()//
			.andRedIdEqualTo(redId)//
			.andStateEqualTo((byte)1);
			List<RedEvent> redEventList = redEventMapper.selectByExample(redEventExample);
			 for (RedEvent redEvent : redEventList) {
				 RedEventGiftExample redEventGiftExample = new RedEventGiftExample();
				 redEventGiftExample.createCriteria()//
				 .andRedEventIdEqualTo(redEvent.getId())//
				 .andStateEqualTo((byte)1);
				 List<RedEventGift> redEventGiftList =  redEventGiftMapper.selectByExample(redEventGiftExample);
				 for (RedEventGift redEventGift : redEventGiftList) {
					 redEventGift.setState((byte)0);
					 redEventGiftMapper.updateByPrimaryKeySelective(redEventGift);
				  }
//				 redEvent.setState((byte)0);
//				 redEventMapper.updateByPrimaryKeySelective(redEvent);
			 }
			  for (RedEventVo redEventVo : newRedEventVoList) {
				   RedEvent redEvent = new RedEvent();
				   BeanUtils.copyProperties(redEventVo, redEvent);
				   redEvent.setCreatetime(createTime);
				   redEvent.setRedId(redId);
				   if(redEvent.getId()==null){
					   redEventMapper.insertSelective(redEvent);
				   }else{
					   RedEvent  redEvent2 = redEventMapper.selectByPrimaryKey(redEvent.getId());
					   if(redEvent2.getState()==0){
						   redEvent2.setState((byte)1);
						   redEventMapper.updateByPrimaryKey(redEvent2);
					   }
				   }
				   List<RedEventGiftVo> giftList = redEventVo.getRedEventGiftVoList();
				   if(giftList!=null){
					   for (RedEventGiftVo redEventGiftVo : giftList) {
						    RedEventGift gitf = new RedEventGift();
						    BeanUtils.copyProperties(redEventGiftVo, gitf);
						    gitf.setRedEventId(redEvent.getId());
						    gitf.setType((byte)1);
						    redEventGiftMapper.insertSelective(gitf);
					  }
				   }
				  
			    }
		}
		redMapper.updateByPrimaryKeySelective(newRed);
		return true;
	}

	@Transactional
	@Override
	public boolean editRedStateByRed(Red red) throws RuntimeException {
		Byte redState = red.getState();
		switch (redState) {
		//删除
		 case 0:
			 RedEventExample example = new RedEventExample();
		   	 RedEventExample.Criteria criteriaRedEventExample = example.createCriteria();
		   	 Integer redId = red.getId();
			 criteriaRedEventExample.andRedIdEqualTo(redId);
		   	 criteriaRedEventExample.andStateEqualTo(Byte.valueOf("1"));
		   	 List<RedEvent> redEventList =  redEventMapper.selectByExample(example);
		   	 if(redEventList!=null&&redEventList.size()>0){
		   		for(int i =0;i<redEventList.size();i++){
		       		 RedEvent record = redEventList.get(i);
		       		 Integer redEventId = record.getId();
						 redEventGiftExtMapper.updateRedEventGiftsByRedEventId(redEventId);
		       	     }
		   	   redEventExtMapper.updateRedEventByRedId(redId);
		   	 }
		   	redMapper.updateByPrimaryKeySelective(red);
			break;
			//开启
         case 1:
			//停用
         case 2:
        		redMapper.updateByPrimaryKeySelective(red);
 		  break;
		default:
			return false;
		}
		return true;
	}

	@Transactional
	@Override
	public boolean addRedDetailInfo(RedVo redVo) throws RuntimeException {
		Long time = System.currentTimeMillis()/1000;
   	    Integer createtime = time.intValue();
		Red newRed = redVo.getRed();
		newRed.setCreatetime(createtime);
		redMapper.insertSelective(newRed);
		List<RedEventVo> newRedEventVoList = redVo.getRedEventVoList();
		Integer newRedId = newRed.getId();
   	 for (RedEventVo redEventVo : newRedEventVoList) {
   		      RedEvent  redEvent = new RedEvent();
			  redEvent.setCreatetime(createtime);
			  redEvent.setRedId(newRedId);
			  redEvent.setType(redEventVo.getType());
   		 redEventMapper.insertSelective(redEvent);
   		 List<RedEventGiftVo> redEventGiftVoList =  redEventVo.getRedEventGiftVoList();
   		 if(redEventGiftVoList!=null&&redEventGiftVoList.size()>0){
   			   List<RedEventGift> redEventGiftList = new ArrayList<RedEventGift>();
   			   for (RedEventGiftVo redEventGiftVo : redEventGiftVoList) {
   				    RedEventGift reg =  new RedEventGift();
   				    reg.setDiscount(redEventGiftVo.getDiscount()==null?new BigDecimal(0):redEventGiftVo.getDiscount());
   				    reg.setGiftId(redEventGiftVo.getGiftId());
   				    reg.setNum(redEventGiftVo.getNum()==null?1:redEventGiftVo.getNum());
   				    reg.setState(Byte.valueOf("1"));
   				    reg.setRedEventId(redEvent.getId());
   				    reg.setType(redEventGiftVo.getType());
   				    redEventGiftList.add(reg);
				    }
   			   redEventGiftMapper.insertBatch(redEventGiftList);
   			   redEventGiftList = null;
   		 }
   		 redEvent = null;
		  }
		return true;
	}

}