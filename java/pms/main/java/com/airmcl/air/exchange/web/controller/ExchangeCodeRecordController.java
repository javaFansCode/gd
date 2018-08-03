package com.airmcl.air.exchange.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.exchange.entity.ExchangeCode;
import com.airmcl.air.exchange.entity.ExchangeCodeExample;
import com.airmcl.air.exchange.entity.ExchangeCodeRecord;
import com.airmcl.air.exchange.entity.ExchangeCodeRecordExample;
import com.airmcl.air.exchange.service.ExchangeCodeRecordService;
import com.airmcl.air.exchange.service.ExchangeCodeService;
import com.airmcl.basae.utils.BaseConst;
import com.airmcl.basae.utils.DateUtil;
import com.airmcl.basae.utils.GenerateCodeUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.ResponseCode;
import com.els.base.core.utils.query.QueryParam;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="兑换码生成记录表")
@Controller
@RequestMapping("exchangeCodeRecord")
public class ExchangeCodeRecordController {
    @Resource
    protected ExchangeCodeRecordService exchangeCodeRecordService;
    @Resource
    protected ExchangeCodeService exchangeCodeService;

    @ApiOperation(httpMethod="POST", value="创建兑换码生成记录表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ExchangeCodeRecord exchangeCodeRecord) {
    	Integer createtime=Integer.valueOf(String.valueOf(DateUtil.getTimeLong()) );

    	/*****************************1创建兑换码生成记录*******************************/
         exchangeCodeRecord.setCreatetime(createtime);
    	 exchangeCodeRecord.setState((byte)1);//状态(状态 0删除 1正常 2作废)
	     this.exchangeCodeRecordService.addObj(exchangeCodeRecord);
	     
	    /*****************************2创建兑换码************************************/
    	for(int i=0;i<exchangeCodeRecord.getNumbers();i++)
    	{
    		 
    		   //String secret=BaseAir.autoCreateCode(6, 2);
               String secret = GenerateCodeUtils.generateCodeByLength(6, BaseConst.GENERATE_TYPE_ALL_NUMBER);

    		   ExchangeCode ec=new ExchangeCode();
    		   ec.setRecordId(exchangeCodeRecord.getId());
    		   
    		   ec.setSecret(secret);
    		   int num=exchangeCodeRecord.getWords()-exchangeCodeRecord.getPrefixCode().length();
     
    		   //String code=BaseAir.autoCreateCode(num, exchangeCodeRecord.getCombinationType());
    		   String code = GenerateCodeUtils.generateCodeByLength(num, exchangeCodeRecord.getCombinationType());
    		   code=exchangeCodeRecord.getPrefixCode()+code;//前缀+自动生成额编码
    		   ec.setCode(code);
    		   ec.setType(exchangeCodeRecord.getType());
    		   ec.setCreatetime(createtime);
    		   ec.setCouponId(exchangeCodeRecord.getCouponId());
    		   ec.setStarttime(exchangeCodeRecord.getStarttime());
    		   ec.setEndtime(exchangeCodeRecord.getEndtime());
    		   ec.setTimes(exchangeCodeRecord.getTimes());
    		   ec.setUsetime(exchangeCodeRecord.getUsetime());
    		   ec.setBeauticianId( 0);//未绑定美容师
    		   ec.setState((byte)1);//状态( 1正常 )
    		   exchangeCodeService.addObj(ec);
    	}
		  
        return ResponseResult.success();
    }
    
   
    /**
     * 编辑兑换码生成记录状态
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "service/editstate")
    @ResponseBody
    public ResponseResult<String> editState(Integer id,byte state) {
        if (id == null || id <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        try {
			int result =  exchangeCodeService.updateExchangeCodeById(id, state);
			if(result>0){
				 return ResponseResult.success();
			}
		} catch (RuntimeException e) {
			  e.printStackTrace();
			  return ResponseResult.fail(ResponseCode.ERROR);
		}
        throw new CommonException("没有数据被修改");
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ExchangeCodeRecord exchangeCodeRecord) {
        if (exchangeCodeRecord.getId() == null || exchangeCodeRecord.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.exchangeCodeRecordService.modifyObj(exchangeCodeRecord);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.exchangeCodeRecordService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<ExchangeCodeRecord>> findAll() {
        ExchangeCodeRecordExample example = new ExchangeCodeRecordExample();
        List<ExchangeCodeRecord> list=this.exchangeCodeRecordService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询兑换码生成记录表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ExchangeCodeRecord", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<ExchangeCodeRecord>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper,
	 @RequestParam(required=false) Integer validTimeSt,//
	 @RequestParam(required=false) Integer validTimeEt) {
        ExchangeCodeRecordExample example = new ExchangeCodeRecordExample();
        example.setOrderByClause("createtime desc");
        example.setPageView(new PageView<ExchangeCodeRecord>(pageNo, pageSize));
        ExchangeCodeRecordExample.Criteria criteria = example.createCriteria();
        boolean isNotState = true;
        if (wapper != null) {
        	List<QueryParam> queryParamList = wapper.getQueryParams();
        	if(queryParamList!=null){
        		for (QueryParam queryParam : queryParamList) {
				     if (queryParam.getProperty().contains("state")) {
				    	  isNotState = false;
				    	  break;
					  }
			    }
        	}
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        if(isNotState){
        	criteria.andStateNotEqualTo((byte)0);
        }
        if(validTimeSt!=null&&validTimeEt!=null){
        	//最大的时间
        	int maxTime = Math.max(validTimeSt, validTimeEt);
        	//最小的时间
        	int minTime = Math.min(validTimeSt, validTimeEt);
        	// maxTime >= starttime
        	// minTime <= endtime
        	criteria.andStarttimeLessThanOrEqualTo(maxTime);
        	criteria.andEndtimeGreaterThanOrEqualTo(minTime);
        	/**
        	 * (`starttime` >= '开始有效' AND `starttime` <= '截止有效') 
        	 * OR (`endtime` >= '开始有效' AND `endtime` <= '截止有效')
        	 * OR (starttime>='开始有效' AND endtime <= '截止有效') 
        	 * OR (starttime<='开始有效' AND endtime>='截止有效')
        	 */
//        	ExchangeCodeRecordExample.Criteria start = example.createCriteria();
//        	start.andStarttimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(start);
//        	
//        	ExchangeCodeRecordExample.Criteria end = example.createCriteria();
//        	end.andEndtimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(end);
//        	
//        	ExchangeCodeRecordExample.Criteria stend = example.createCriteria();
//        	stend.andStarttimeGreaterThanOrEqualTo(validTimeSt)//
//        	.andEndtimeLessThanOrEqualTo(validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(stend);
//        	
//        	ExchangeCodeRecordExample.Criteria sttend =example.createCriteria();
//	        	sttend.andStarttimeLessThanOrEqualTo(validTimeEt)//
//	        	.andEndtimeGreaterThanOrEqualTo(validTimeSt).andStateNotEqualTo((byte)0);
//	        	example.or(sttend);
        	
        }
        PageView<ExchangeCodeRecord> pageData = this.exchangeCodeRecordService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}