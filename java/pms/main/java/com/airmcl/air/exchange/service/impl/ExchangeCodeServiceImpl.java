package com.airmcl.air.exchange.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.exchange.dao.ExchangeCodeMapper;
import com.airmcl.air.exchange.dao.ExchangeCodeRecordMapper;
import com.airmcl.air.exchange.entity.ExchangeCode;
import com.airmcl.air.exchange.entity.ExchangeCodeExample;
import com.airmcl.air.exchange.entity.ExchangeCodeRecord;
import com.airmcl.air.exchange.service.ExchangeCodeService;
import com.els.base.core.entity.PageView;

@Service("defaultExchangeCodeService")
public class ExchangeCodeServiceImpl implements ExchangeCodeService {
    @Resource
    protected ExchangeCodeMapper exchangeCodeMapper;
    @Resource
    protected ExchangeCodeRecordMapper exchangeCodeRecordMapper;
    
    @CacheEvict(value={"exchangeCode"}, allEntries=true)
    @Override
    public void addObj(ExchangeCode t) {
        this.exchangeCodeMapper.insertSelective(t);
    }

    @CacheEvict(value={"exchangeCode"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.exchangeCodeMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"exchangeCode"}, allEntries=true)
    @Override
    public void modifyObj(ExchangeCode t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.exchangeCodeMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="exchangeCode", keyGenerator="redisKeyGenerator")
    @Override
    public ExchangeCode queryObjById(Integer id) {
        return this.exchangeCodeMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="exchangeCode", key="'ExchangeCodeService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ExchangeCode> queryAllObjByExample(ExchangeCodeExample example) {
        return this.exchangeCodeMapper.selectByExample(example);
    }

    @Cacheable(value="exchangeCode", key="'ExchangeCodeService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ExchangeCode> queryObjByPage(ExchangeCodeExample example) {
        PageView<ExchangeCode> pageView = example.getPageView();
        pageView.setQueryResult(this.exchangeCodeMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Transactional
	@Override
	public int updateExchangeCodeById(Integer id, byte state) throws RuntimeException {
    	 int result = 0;
    	 //状态(状态 0删除 1正常 2作废)
    	 ExchangeCodeRecord   exchangeCodeRecord = this.exchangeCodeRecordMapper.selectByPrimaryKey(id);
    	 Byte dbState = exchangeCodeRecord.getState();
    	 if(exchangeCodeRecord==null||dbState==null||dbState.equals(state)){
    		 return result;
    	 }
         ExchangeCodeExample exchangeCodeExample = new ExchangeCodeExample();
 		 exchangeCodeExample.createCriteria().andRecordIdEqualTo(id).andStateNotEqualTo((byte)3);
         List<ExchangeCode> exchangeCodeList = this.exchangeCodeMapper.selectByExample(exchangeCodeExample);
         if(exchangeCodeList!=null&&exchangeCodeList.size()>0){
        	 ExchangeCode exchangeCode = new ExchangeCode();
        	 exchangeCode.setState(state);
         	 int re =  this.exchangeCodeMapper.updateByExampleSelective(exchangeCode, exchangeCodeExample);
         	 result = result+re;
 		}
         ExchangeCodeRecord record = new ExchangeCodeRecord();
         record.setId(id);
         record.setState(state);
		 int re2 = this.exchangeCodeRecordMapper.updateByPrimaryKeySelective(record);
		 result += re2;
		 return result;
	}
}