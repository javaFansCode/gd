package com.airmcl.air.coupon.web.controller;

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

import com.airmcl.air.coupon.enter.EnterUserCouponParams;
import com.airmcl.air.coupon.entity.Coupon;
import com.airmcl.air.coupon.entity.CouponExample;
import com.airmcl.air.coupon.entity.CouponServiceExample;
import com.airmcl.air.coupon.entity.CouponVO;
import com.airmcl.air.coupon.out.OutUserCouponDetails;
import com.airmcl.air.coupon.service.CouponService;
import com.airmcl.air.coupon.service.CouponServiceService;
import com.airmcl.air.service.entity.Service;
import com.airmcl.air.service.service.ServiceService;
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
import jxl.write.WritableWorkbook;

@Api(value="优惠券表")
@Controller
@RequestMapping("coupon")
public class CouponController {
    @Resource
    protected CouponService couponService;
    @Resource
    protected CouponServiceService couponServiceService;
    
    @Resource
    protected ServiceService serviceService;
    

    @ApiOperation(httpMethod="POST", value="创建优惠券表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody CouponVO coupon) {
   
//    	//state
//    	coupon.setState((byte)1);//状态(0:删除,1:开启,2:关闭)|
//    	coupon.setCreatetime(String.valueOf( DateUtil.getTimeLong()) );
//    	coupon.setUpdatetime(String.valueOf( DateUtil.getTimeLong()) );
//    	coupon.setTeceiveTotal(0);//领取数
//        this.couponService.addObj(coupon);
// 
//       
//        for (String serviceId :  coupon.getServiceId().split(",")) {
//        	 com.airmcl.air.coupon.entity.CouponService cService=new com.airmcl.air.coupon.entity.CouponService();
//             cService.setCouponId(coupon.getId());
//             cService.setServiceId(Integer.valueOf(serviceId) );
//            String serviceName= "";
// 
//    		try {
//    			serviceName=serviceService.queryObjById(Integer.valueOf(serviceId)).getServiceName();
//			} catch (Exception e) {
//				serviceName="id:"+serviceId+" 服务项目可能被删除";
//			}
//			cService.setServiceName(serviceName);
//            cService.setState((byte)1);//使用情况 0删除，1正常
//             this.couponServiceService.addObj(cService);
//		}
    	int result = 0 ;
    	try {
    		result = couponService.saveCouponServiceDetail(coupon);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
    	if(result>0){
    		 return ResponseResult.success();
    	}
        return ResponseResult.fail(ResponseCode.Param_Error);
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/editstate")
    @ResponseBody
    public ResponseResult<String> editState(Integer id,byte state) {
        if (id == null || id <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        com.airmcl.air.coupon.entity.Coupon   coupon=this.couponService.queryObjById(id);
        coupon.setState(state);//状态(0:删除,1:开启,2:关闭)
        this.couponService.modifyObj(coupon);
        return ResponseResult.success();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody CouponVO coupon) {
        if (coupon.getId() == null || coupon.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        com.airmcl.air.coupon.entity.CouponServiceExample   example=new com.airmcl.air.coupon.entity.CouponServiceExample();
        CouponServiceExample.Criteria criteria=example.createCriteria();
        criteria.andCouponIdEqualTo(coupon.getId());
        criteria.andStateEqualTo((byte)1);
        
        List<com.airmcl.air.coupon.entity.CouponService> list=this.couponServiceService.queryAllObjByExample(example);
        for (com.airmcl.air.coupon.entity.CouponService cs : list) {
        	cs.setState((byte)0);//删除以前的关联
        	this.couponServiceService.modifyObj(cs);
		}
        
          String seviceIds = coupon.getServiceId();
     if(!StringUtils.isEmpty(seviceIds)){
		for (String serviceId : coupon.getServiceId().split(",")) {// 创建新的关联
			com.airmcl.air.coupon.entity.CouponService cService = new com.airmcl.air.coupon.entity.CouponService();
			cService.setCouponId(coupon.getId());
			cService.setServiceId(Integer.valueOf(serviceId));
			String serviceName = "";
			Service service= serviceService.queryObjById(Integer.valueOf(serviceId));
			if(service==null){
				continue;
			}
//			try {
//				serviceName = serviceService.queryObjById(Integer.valueOf(serviceId)).getServiceName();
//			} catch (Exception e) {
//				serviceName = "id:" + serviceId + " 服务项目可能被删除";
//			}
			cService.setServiceName(serviceName);
			cService.setState((byte) 1);// 使用情况 0删除，1正常
			this.couponServiceService.addObj(cService);
			cService = null;//释放资源
		  }
         }
        this.couponService.modifyObj(coupon);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.couponService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<Coupon>> findAll() {
        CouponExample example = new CouponExample();
        List<Coupon> list=this.couponService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询优惠券表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Coupon", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Coupon>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        CouponExample example = new CouponExample();
        example.setPageView(new PageView<Coupon>(pageNo, pageSize));
        CouponExample.Criteria criteria = example.createCriteria();
        boolean isNotState = true;
        if (wapper != null) {
        	List<QueryParam> queryParamList=wapper.getQueryParams();
        	if(queryParamList!=null){
        		for (QueryParam queryParam : queryParamList) {
          		  if(queryParam.property.contains("state")){
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
        example.setOrderByClause("createtime desc");
        PageView<Coupon> pageData = this.couponService.queryObjByPage(example);
        List<Coupon> couponList = pageData.getQueryResult();
        for (Coupon coupon : couponList) {
			CouponServiceExample couponServiceExample =new CouponServiceExample();
			couponServiceExample.createCriteria().andCouponIdEqualTo(coupon.getId())//
			.andStateEqualTo((byte)1);
			 List<com.airmcl.air.coupon.entity.CouponService> douponService= couponServiceService.queryAllObjByExample(couponServiceExample);
			 StringBuilder sb = new StringBuilder();
			 for (com.airmcl.air.coupon.entity.CouponService couponService : douponService) {
				 sb.append(couponService.getServiceId()).append(",");
			 }
			 int lastIndex = sb.lastIndexOf(",");
			 if(lastIndex>0){
				 sb.deleteCharAt(lastIndex);
				 coupon.setServiceId(sb.toString());
			 }
			 sb = null;
		 }
        return ResponseResult.success(pageData);
    }
    
    
	@ApiOperation(httpMethod="POST", value="查询用户优惠券表")
    @ApiImplicitParams({ 
   	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
   	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
   	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考mdd_api_users_coupon", paramType = "body", dataType = "EnterUserCouponParams" )  
   	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/userCouponDetails",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<OutUserCouponDetails>> findUserCouponDetails (
		@RequestParam(defaultValue="0") int pageNo,  
		@RequestParam(defaultValue="10") int pageSize, 
		@RequestBody(required=false) EnterUserCouponParams params) throws Exception{
		
			PageView<OutUserCouponDetails> pageData = this.couponService.findUserCouponDetailsByParams(pageNo,pageSize,params);
		
			return ResponseResult.success(pageData);
	}
	
	@ApiOperation(httpMethod="GET", value="导出用户优惠券excel")
	@RequestMapping(method = RequestMethod.GET, value = "service/excelUserCouponDetails")
	@ResponseBody
	public ResponseResult<String> exportExcel(HttpServletResponse response ,
		@RequestParam(required=false) Integer couponId,
		@RequestParam(required=false) String userPhone,
		@RequestParam(required=false) String nickName,
		@RequestParam(required=false) String couponTitle,
		@RequestParam(required=false) String startcreatetime,
		@RequestParam(required=false) String endcreatetime) throws Exception{
		response.setHeader("Content-disposition", "attachment; filename="+new String("用户优惠券详情记录.xls".getBytes("GB2312"), "ISO8859-1"));
        response.setContentType("application/msexcel");
        WritableWorkbook exportDataToExcel = couponService.exportDataToExcel(couponId,userPhone,couponTitle,startcreatetime,endcreatetime,response);
        exportDataToExcel.write();
        exportDataToExcel.close();
        return ResponseResult.success();
	}
    
     
}