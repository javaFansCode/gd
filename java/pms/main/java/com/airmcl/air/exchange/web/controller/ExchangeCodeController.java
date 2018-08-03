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
import com.airmcl.air.exchange.service.ExchangeCodeService;
import com.airmcl.air.red.entity.RedExample;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParam;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="兑换码主表")
@Controller
@RequestMapping("exchangeCode")
public class ExchangeCodeController {
    @Resource
    protected ExchangeCodeService exchangeCodeService;

    @ApiOperation(httpMethod="POST", value="创建兑换码主表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ExchangeCode exchangeCode) {
        this.exchangeCodeService.addObj(exchangeCode);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ExchangeCode exchangeCode) {
        if (exchangeCode.getId() == null || exchangeCode.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.exchangeCodeService.modifyObj(exchangeCode);
        return ResponseResult.success();
    }
    /**
     * 编辑兑换码主表状态
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
        ExchangeCode   coupon=this.exchangeCodeService.queryObjById(id);
        coupon.setState(state);//状态 0删除 1正常 2作废 3已使用
        this.exchangeCodeService.modifyObj(coupon);
        return ResponseResult.success();
    }
    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.exchangeCodeService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<ExchangeCode>> findAll() {
        ExchangeCodeExample example = new ExchangeCodeExample();
        List<ExchangeCode> list=this.exchangeCodeService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询兑换码主表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ExchangeCode", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<ExchangeCode>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper,
	 @RequestParam(required=false) Integer validTimeSt,//
	 @RequestParam(required=false) Integer validTimeEt) {
        ExchangeCodeExample example = new ExchangeCodeExample();
        example.setPageView(new PageView<ExchangeCode>(pageNo, pageSize));
        boolean noStateFlag = true;
        ExchangeCodeExample.Criteria criteria = example.createCriteria();
        if (wapper != null) {
            List<QueryParam> queryParams = wapper.getQueryParams();
        	if(queryParams!=null){
        	for (QueryParam queryParam : queryParams) {
        		 String property = queryParam.getProperty();
        		 if(property.contains("state")){
        			 noStateFlag = false;
        			 break;
        		 }
			}
        	}
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        if(noStateFlag){
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
//        	ExchangeCodeExample.Criteria start = example.createCriteria();
//        	start.andStarttimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(start);
//        	
//        	ExchangeCodeExample.Criteria end = example.createCriteria();
//        	end.andEndtimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(end);
//        	
//        	ExchangeCodeExample.Criteria stend = example.createCriteria();
//        	stend.andStarttimeGreaterThanOrEqualTo(validTimeSt)//
//        	.andEndtimeLessThanOrEqualTo(validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(stend);
//        	
//        	ExchangeCodeExample.Criteria sttend =example.createCriteria();
//	        	sttend.andStarttimeLessThanOrEqualTo(validTimeEt)//
//	        	.andEndtimeGreaterThanOrEqualTo(validTimeSt).andStateNotEqualTo((byte)0);
//	        	example.or(sttend);
        	
        }
        PageView<ExchangeCode> pageData = this.exchangeCodeService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}