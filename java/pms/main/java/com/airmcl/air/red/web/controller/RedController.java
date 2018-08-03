package com.airmcl.air.red.web.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.red.entity.Red;
import com.airmcl.air.red.entity.RedEventGift;
import com.airmcl.air.red.entity.RedExample;
import com.airmcl.air.red.entity.RedExcelBean;
import com.airmcl.air.red.entity.RedVo;
import com.airmcl.air.red.service.RedEventGiftService;
import com.airmcl.air.red.service.RedService;
import com.airmcl.basae.utils.DateUtil;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.ResponseCode;
import com.els.base.core.utils.query.QueryParam;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.base.utils.excel.ExcelUtils;
import com.els.base.utils.excel.TitleAndModelKey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jxl.write.WritableWorkbook;

@Api(value="分享红包表")
@Controller
@RequestMapping("red")
public class RedController {
    @Resource
    protected RedService redService;
    @Resource
    protected RedEventGiftService redEventGiftService;
    
    @ApiOperation(httpMethod="POST", value="导出Excel(GET)")
    @RequestMapping(method = RequestMethod.GET, value = "service/outPutExcelGet")
    @ResponseBody
    public ResponseResult<String> outPutExcelGet(HttpServletResponse response , 
    		 @RequestParam(required=false) Integer id,//
    		 @RequestParam(required=false) String name,//
    		 @RequestParam(required=false) Byte state,//
    		 @RequestParam(required=false) Integer validTimeSt,//
    		 @RequestParam(required=false) Integer validTimeEt,//
    		 @RequestParam(required=false) Integer createtimegt, 
    		 @RequestParam(required=false) Integer createtimelt) {
    	RedExample redExampleExcelExample = new RedExample();
    	RedExample.Criteria criteria = redExampleExcelExample.createCriteria();
    	if(id!=null){
    		criteria.andIdEqualTo(id);
    	}
    	if(StringUtils.isNotEmpty(name)){
    		criteria.andNameLike(name);
    	}
    	if(state!=null){
    		criteria.andStateEqualTo(state);
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
//        	RedExample.Criteria start = redExampleExcelExample.createCriteria();
//        	start.andStarttimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	redExampleExcelExample.or(start);
//        	
//        	RedExample.Criteria end = redExampleExcelExample.createCriteria();
//        	end.andEndtimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	redExampleExcelExample.or(end);
//        	
//        	RedExample.Criteria stend = redExampleExcelExample.createCriteria();
//        	stend.andStarttimeGreaterThanOrEqualTo(validTimeSt).andStateNotEqualTo((byte)0)//
//        	.andEndtimeLessThanOrEqualTo(validTimeEt);
//        	redExampleExcelExample.or(stend);
//        	
//        	RedExample.Criteria sttend =redExampleExcelExample.createCriteria();
//	        	sttend.andStarttimeLessThanOrEqualTo(validTimeEt).andStateNotEqualTo((byte)0)//
//	        	.andEndtimeGreaterThanOrEqualTo(validTimeSt);
//	        	redExampleExcelExample.or(sttend);
        	
        }
    	if(createtimegt!=null){
    		criteria.andCreatetimeGreaterThanOrEqualTo(createtimegt);
    	}
    	if(createtimelt!=null){
    		criteria.andCreatetimeLessThanOrEqualTo(createtimelt);
    	}
		List<Red> redDbList = this.redService.queryAllObjByExample(redExampleExcelExample);
		StringBuffer sb = new StringBuffer("老带新活动导出_");
    	sb.append(DateUtil.getTime()).append(".xlsx");
    	String fileFuleName = sb.toString();
        try {
			OutputStream os = response.getOutputStream();
			response.setHeader("Content-disposition", "attachment; filename="+new String(fileFuleName.getBytes("GB2312"), "ISO8859-1"));  
	        response.setContentType("application/msexcel");
	        List<TitleAndModelKey> titleAndModelKeys = new ArrayList<TitleAndModelKey>();
			createTitleAndModelKey(titleAndModelKeys);
	        if(redDbList!=null&&redDbList.size()>0){
				List<RedExcelBean> excleData = new ArrayList<RedExcelBean>(redDbList.size());
				for (Red red : redDbList) {
					excleData.add(new RedExcelBean(red));
				}
                WritableWorkbook writableWorkbook = ExcelUtils.exportDataToExcel(os, titleAndModelKeys, excleData, "老带新活动导出", "活动列表", 0);
				writableWorkbook.write();
				writableWorkbook.close();
				return ResponseResult.success();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return ResponseResult.success();
    }
    @ApiOperation(httpMethod="POST", value="导出Excel")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Red", paramType = "body", dataType = "QueryParamWapper" )  
   }) 
    @RequestMapping(method = RequestMethod.POST, value = "service/outPutExcel",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> outPutExcel(HttpServletResponse response , 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
    	StringBuffer sb = new StringBuffer("老带新活动导出_");
    	sb.append(System.currentTimeMillis()).append(".xlsx");
    	String fileFuleName = sb.toString();
    	try {
    		
    		response.setHeader("Content-disposition", "attachment; filename="+new String(fileFuleName.getBytes("GB2312"), "ISO8859-1"));  
            response.setContentType("application/msexcel");
            OutputStream os = response.getOutputStream();
			List<TitleAndModelKey> titleAndModelKeys = new ArrayList<TitleAndModelKey>();
			createTitleAndModelKey(titleAndModelKeys);
			PageView<Red> querList = queryRedList( pageNo,pageSize,wapper,null,null);
			List<Red> data = querList.getQueryResult();
			if(data!=null&&data.size()>0){
				List<RedExcelBean> excleData = new ArrayList<RedExcelBean>(data.size());
				for (Red red : data) {
					excleData.add(new RedExcelBean(red));
				}
                WritableWorkbook writableWorkbook = ExcelUtils.exportDataToExcel(os, titleAndModelKeys, excleData, "老带新活动导出", "活动列表", 0);
				writableWorkbook.write();
				writableWorkbook.close();
				return ResponseResult.success();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(ResponseCode.Param_Error);
		}  
    	return ResponseResult.success("没有可以导出的数据");
    }
	private List<TitleAndModelKey> createTitleAndModelKey(List<TitleAndModelKey> titleAndModelKeys ) {
		TitleAndModelKey tamk = new TitleAndModelKey();
		tamk.setTitle("活动ID");
		tamk.setModelKey("id");
		titleAndModelKeys.add(tamk);
		TitleAndModelKey name = new TitleAndModelKey();
		name.setTitle("老带新活动名称");
		name.setModelKey("name");
		titleAndModelKeys.add(name);
		TitleAndModelKey state = new TitleAndModelKey();
		state.setTitle("活动状态");
		state.setModelKey("state");
		titleAndModelKeys.add(state);
		TitleAndModelKey starttime = new TitleAndModelKey();
		starttime.setTitle("活动开始时间");
		starttime.setModelKey("starttime");
		titleAndModelKeys.add(starttime);
		TitleAndModelKey endtime = new TitleAndModelKey();
		endtime.setTitle("活动结束时间");
		endtime.setModelKey("endtime");
		titleAndModelKeys.add(endtime);
		TitleAndModelKey type = new TitleAndModelKey();
		type.setTitle("活动类型");
		type.setModelKey("type");
		titleAndModelKeys.add(type);
		TitleAndModelKey createtime = new TitleAndModelKey();
		createtime.setTitle("创建时间");
		createtime.setModelKey("createtime");
		titleAndModelKeys.add(createtime);
		return titleAndModelKeys;
	}
    @ApiOperation(httpMethod="POST", value="异步修改红包礼物")
    @RequestMapping(method = RequestMethod.POST, value = "service/ajaxDeleteRedEventGiftVo")
    @ResponseBody
    public ResponseResult<String> ajaxDeleteRedEventGiftVo(@RequestParam(required=true) Integer id){
    	if(id==null||id<=0){
    		throw new CommonException("id 为空，查询失败");
    	}
    	RedEventGift redEventGift = redEventGiftService.queryObjById(id);
    	if(redEventGift==null){
    		return ResponseResult.fail(ResponseCode.Fail);
    	}
    	redEventGift.setState(Byte.valueOf("0"));
    	redEventGiftService.modifyObj(redEventGift);
    	return ResponseResult.success();
    }
    @ApiOperation(httpMethod="GET", value="修改分享红包界面")
    @RequestMapping(method = RequestMethod.GET, value = "service/toEditRedVo")
    @ResponseBody
    public ResponseResult<RedVo> toEditRedVo(@RequestParam(required=true) Integer id) {
    	if(id==null||id<=0){
    		throw new CommonException("id 为空，查询失败");
    	}
    	final Red red = redService.queryObjById(id);
    	if(red==null){
    		throw new CommonException("id 错误，查询失败");
    	}
    	RedVo redVo = redService.queryRedDetailByRedId(id);
    	redVo.setRed(red);
    	return  ResponseResult.success(redVo);
    }
    @ApiOperation(httpMethod="POST", value="创建分享红包表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody RedVo redVo) {
        try {
        	boolean isOk = redService.addRedDetailInfo(redVo);
        	return isOk == true ? ResponseResult.success():ResponseResult.fail(ResponseCode.ERROR);
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseResult.fail(ResponseCode.ERROR);
		}
    }

    
    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody RedVo redVo) {
    	Red red = redVo.getRed();
        if ( red == null || red.getId() == null) {
            throw new CommonException("id 为空，保存失败");
        }
        Integer redId = red.getId();
        Red  dbRed =  redService.queryObjById(redId);
        if(dbRed==null){
        	return ResponseResult.fail(ResponseCode.ERROR);
        }
        try {
        	boolean isOk = redService.modifyRedDetailInfo(redVo);
        	return isOk == true?ResponseResult.success():ResponseResult.fail(ResponseCode.ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(ResponseCode.ERROR);
		}
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/editRedState",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> editRedState(@RequestBody(required=true) Red red) {
    	Integer redId = red.getId();
    	if(redId==null||redId<=0){
    		 return ResponseResult.fail(ResponseCode.Fail);
    	}
    	Red dbRed = redService.queryObjById(redId);
    	if(dbRed==null){
    		 return ResponseResult.fail(ResponseCode.ERROR);
    	}
    	try {
			boolean isOk = redService.editRedStateByRed(red);
			return isOk==true?ResponseResult.success():ResponseResult.fail(ResponseCode.Fail);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(ResponseCode.ERROR);
		}
        
    }
    @ApiOperation(httpMethod="POST", value="查询分享红包表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Red", paramType = "body", dataType = "QueryParamWapper" )  
   }) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Red>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper, @RequestParam(required=false)  Integer validTimeSt,@RequestParam(required=false)  Integer validTimeEt) {
        PageView<Red> pageData = queryRedList(pageNo, pageSize, wapper,validTimeSt,validTimeEt);
        return ResponseResult.success(pageData);
    }
	private PageView<Red> queryRedList(int pageNo, int pageSize, QueryParamWapper wapper,  Integer validTimeSt,  Integer validTimeEt) {
		RedExample example = new RedExample();
        example.setPageView(new PageView<Red>(pageNo, pageSize));
        RedExample.Criteria criteria = example.createCriteria();
        boolean noStateFlag = true;
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
//        	RedExample.Criteria start = example.createCriteria();
//        	start.andStarttimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(start);
//        	
//        	RedExample.Criteria end = example.createCriteria();
//        	end.andEndtimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(end);
//        	
//        	RedExample.Criteria stend = example.createCriteria();
//        	stend.andStarttimeGreaterThanOrEqualTo(validTimeSt).andStateNotEqualTo((byte)0)//
//        	.andEndtimeLessThanOrEqualTo(validTimeEt);
//        	example.or(stend);
//        	
//        	RedExample.Criteria sttend =example.createCriteria();
//	        	sttend.andStarttimeLessThanOrEqualTo(validTimeEt).andStateNotEqualTo((byte)0)//
//	        	.andEndtimeGreaterThanOrEqualTo(validTimeSt);
//	        	example.or(sttend);
        	
        }
        example.setOrderByClause("createtime desc");
        PageView<Red> pageData = this.redService.queryObjByPage(example);
		return pageData;
	}
}