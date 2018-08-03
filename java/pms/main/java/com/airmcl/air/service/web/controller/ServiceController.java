package com.airmcl.air.service.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.coupon.entity.Coupon;
import com.airmcl.air.coupon.entity.CouponExample;
import com.airmcl.air.coupon.service.CouponService;
import com.airmcl.air.goods.entity.Goods;
import com.airmcl.air.goods.entity.GoodsExample;
import com.airmcl.air.goods.service.GoodsService;
import com.airmcl.air.service.entity.Service;
import com.airmcl.air.service.entity.ServiceCity;
import com.airmcl.air.service.entity.ServiceCityVo;
import com.airmcl.air.service.entity.ServiceExample;
import com.airmcl.air.service.entity.ServiceExtend;
import com.airmcl.air.service.entity.ServiceIdNameCover;
import com.airmcl.air.service.entity.ServicePackage;
import com.airmcl.air.service.entity.ServiceType;
import com.airmcl.air.service.entity.ServiceVo;
import com.airmcl.air.service.service.ServiceCityService;
import com.airmcl.air.service.service.ServiceExtendService;
import com.airmcl.air.service.service.ServiceService;
import com.airmcl.air.service.service.ServiceTypeService;
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

@Api(value="服务项目主表")
@Controller
@RequestMapping("service")
public class ServiceController {
    @Resource
    protected ServiceService serviceService;
    @Resource
    protected ServiceTypeService serviceTypeService;
    @Resource
    protected ServiceExtendService serviceExtendService;
    @Resource
    protected ServiceCityService serviceCityService;
    @Resource
    protected GoodsService goodsService;
    @Resource
    protected CouponService couponService;
    
    @RequestMapping(method = RequestMethod.GET, value = "service/getServiceInfo")
    @ResponseBody
    public ResponseResult<List<ServiceIdNameCover>> queryServiceInfo(@RequestParam(required=true) String ids,String type){
    	List<ServiceIdNameCover> result = new ArrayList<ServiceIdNameCover>();
    	if(ids==null||StringUtils.isEmpty(ids)){
    		return ResponseResult.fail(ResponseCode.Param_Error, result);
    	}
        String[] idLen = ids.split(",");
        List<Integer> idList = new ArrayList<Integer>();
    	for (String string : idLen) {
    		idList.add(Integer.valueOf(string));
		 }
         try {
        	 if("service".equals(type)){
        		 result = serviceService.queryServiceInfo(idList);
        	 }else if("goods".equals(type)){
        		 GoodsExample goodsExample = new GoodsExample();
        		 goodsExample.createCriteria().andIdIn(idList);
        		 List<Goods> goods = goodsService.queryAllObjByExample(goodsExample);
        		 for (Goods good : goods) {
        			 ServiceIdNameCover sc = new ServiceIdNameCover();
        			 sc.setId(good.getId());
        			 sc.setServiceCover(good.getGoodsCover());
        			 sc.setServiceName(good.getGoodsName());
        			 result.add(sc);
				}
        	 }else if("coupon".equals(type)){
        		 CouponExample couponExample = new CouponExample();
        		 couponExample.createCriteria().andIdIn(idList);
        		 List<Coupon>  couponList =  couponService.queryAllObjByExample(couponExample);
        		  for (Coupon coupon : couponList) {
        			  ServiceIdNameCover sc = new ServiceIdNameCover();
        			  sc.setId(coupon.getId());
         			  sc.setServiceName(coupon.getCouponTitle());
        			  result.add(sc);
				}
        	 }
			
			 return ResponseResult.success(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
         return ResponseResult.fail(ResponseCode.Param_Error, result);
    }
    @ApiOperation(httpMethod="POST", value="设置城市价格界")
    @RequestMapping(method = RequestMethod.POST, value = "service/editCityPrice")
    @ResponseBody
    public ResponseResult<String> editCityPrice(@RequestBody ServiceCityVo serviceCityVo){
    	Integer serviceId = serviceCityVo.getServiceId();
    	Service service = serviceService.queryObjById(serviceId);
    	if(service==null){
    		throw new CommonException("数据有误！");
    	}
    	List<ServiceCity> cities = serviceCityVo.getServiceCities();
    	if(cities==null||cities.isEmpty()){
    		throw new CommonException("数据有误！");
    	}
    	for (ServiceCity serviceCity : cities) {
    		serviceCity.setServiceId(serviceId);
		}
    	//已经设置了的城市
    	List<ServiceCity> citys = serviceCityService.queryOpenReserveCityByServiceId(serviceId);
    	//第一次设置的逻辑
    	if(citys==null||citys.isEmpty()){
    		try {
    			List<ServiceCity> temp = new ArrayList<ServiceCity>();
    			for (ServiceCity serviceCity : cities) {
    				 boolean lessPrice = BigDecimal.ZERO.compareTo(serviceCity.getPrice())==1;
    				 boolean memberPrice = BigDecimal.ZERO.compareTo(serviceCity.getMemberPrice())==1;
//    				 boolean state = serviceCity.getState()!=1;
					 if(lessPrice||memberPrice){
						 continue;
					 }
					 temp.add(serviceCity); 
				}
    			if(temp.size()>0){
    				serviceCityService.addAllServiceCity(temp);
    				return ResponseResult.success(); 
    			}
    			return ResponseResult.fail(ResponseCode.Donot_Exists);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseResult.fail(ResponseCode.ERROR);
			}
    	}
    	//第多次设置的逻辑
    	Map<Integer,ServiceCity> newCityMap = new HashMap<Integer,ServiceCity>();
    	for(ServiceCity city:cities){
    		newCityMap.put(city.getCityId(), city);
    	}
    	cities = null;
    	Map<Integer,ServiceCity> oldCityMap = new HashMap<Integer,ServiceCity>();
    	for(ServiceCity cy:citys){
    		oldCityMap.put(cy.getCityId(), cy);
    	}
    	citys = null;
    	List<ServiceCity> addCitys = new ArrayList<ServiceCity>();
    	List<ServiceCity> updateCitys = new ArrayList<ServiceCity>();
    	for(Map.Entry<Integer, ServiceCity> cityMap:newCityMap.entrySet()){
    		Integer key = cityMap.getKey();
    		ServiceCity value = cityMap.getValue();
    		if(oldCityMap.containsKey(key)){
    			ServiceCity oldValue = oldCityMap.get(key);
    			if(value.getState()==2||(priceIsNotSame(value, oldValue))){
    				updateCitys.add(value);
    			} 
    		}else{
    			addCitys.add(value);
    		}
    	}
    	try {
			serviceService.modifyServiceCities(addCitys, updateCitys);
			addCitys = null;
	    	updateCitys = null;
			return ResponseResult.success();
		} catch (Exception e1) {
			e1.printStackTrace();
			return ResponseResult.fail(ResponseCode.ERROR);
		}
    }

	private boolean priceIsNotSame(ServiceCity newCity, ServiceCity oldCity) {
		if (!newCity.getPrice().equals(oldCity.getPrice())) {
			return true;
		}
		if (!newCity.getMemberPrice().equals(oldCity.getMemberPrice())) {
			return true;
		}
		if (!newCity.getOriginalPrice().equals(oldCity.getOriginalPrice())) {
			return true;
		}
		return false;
	}
    @ApiOperation(httpMethod="GET", value="设置城市价格界面主界面")
    @RequestMapping(method = RequestMethod.GET, value = "service/toEditCityPrice")
    @ResponseBody
    public ResponseResult<ServiceCityVo> toEditCityPrice(@RequestParam(required=true)Integer serviceId){
    	if(serviceId==null||serviceId<0){
    		throw new CommonException("传入的id有错误");
    	}
    	Service service =serviceService.queryObjById(serviceId);
    	if(service==null){
    		throw new CommonException("传入的id有错误");
    	}
    	ServiceCityVo vo = new ServiceCityVo();
    	//所有开放的城市
    	List<ServiceCity> openReserveCities = serviceCityService.queryOpenReserveCity();
    	if(openReserveCities==null||openReserveCities.isEmpty()){
			throw new CommonException("目前没有开放的城市");
		}
    	//已经设置了的城市
    	List<ServiceCity> citys = serviceCityService.queryOpenReserveCityByServiceId(serviceId);
    	BigDecimal price = service.getPrice();
		BigDecimal memberPrice = service.getMemberPrice();
		BigDecimal originalPrice =service.getOriginalPrice();
		//不是第一次设置
    	if(citys!=null&&!citys.isEmpty()){
    		List<ServiceCity> newCitys = new ArrayList<ServiceCity>();
    		Map<Integer,ServiceCity> alreadySetPriceMap = new HashMap<Integer, ServiceCity>();
    		for(ServiceCity city:citys){
    			//下架
//    			if(city.getState()==2){
//    				city.setOriginalPrice(originalPrice);
//    				city.setPrice(price);
//    				city.setMemberPrice(memberPrice);
//    			}
    			alreadySetPriceMap.put(city.getCityId(), city);
    		}
    		for (ServiceCity serviceCity : openReserveCities) {
    			Integer cityId = serviceCity.getCityId();
    			if(alreadySetPriceMap.containsKey(cityId)){
    				newCitys.add(alreadySetPriceMap.get(cityId));
    			}else{
    				serviceCity.setOriginalPrice(originalPrice);
    				serviceCity.setPrice(price);
    				serviceCity.setMemberPrice(memberPrice);
    				newCitys.add(serviceCity);
    			}
    			
			 }
    		vo.setServiceCities(newCitys);
    	}else{
    		//第一次设置
    		for(ServiceCity city:openReserveCities){
    			city.setOriginalPrice(originalPrice);
				city.setPrice(price);
				city.setMemberPrice(memberPrice);	
				city.setServiceId(service.getId());
    		}
    		vo.setServiceCities(openReserveCities);	
    	}
    	vo.setServiceId(service.getId());
    	vo.setServiceName(service.getServiceName());
    	return ResponseResult.success(vo);
    }
    
    @ApiOperation(httpMethod="GET", value="修改或创建服务项目主表的主界面")
    @RequestMapping(method = RequestMethod.GET, value = "service/toEditOrSaveView")
    @ResponseBody
    public ResponseResult<ServiceVo> toEditOrSaveView(@RequestParam(required=false)Integer serviceId,Integer pakage){
    	ServiceVo vo = new ServiceVo();
    	List<ServiceType> serviceTypes = serviceTypeService.queryAllServiceType();
    	//添加套餐
    	if(pakage!=null&&pakage==2){
    		List<Service> allSingleService = serviceService.querySingleService();
    	    vo.setAllSingleService(allSingleService);
    	}
    	//新增
    	if(serviceId==null||serviceId<=0){
    		vo.setServiceTypes(serviceTypes);
    		return ResponseResult.success(vo);
    	}
    	//下面是修改逻辑
    	Service service  =	serviceService.queryObjById(serviceId);
    	Byte  delState = new Byte("0");
    	if(service==null||delState.equals(service.getState())){
    		throw new CommonException("传入的id有错误"); 
    	}
    	if(service.getIsPackage()==2){
    		List<ServicePackage> servicePackages= serviceService.queryServicePackageByServiceId(serviceId);
    		vo.setAllSelectService(servicePackages);
    		List<Service> allSingleService = serviceService.querySingleService();
    	    vo.setAllSingleService(allSingleService);
    	}
    	ServiceExtend serviceExtend =	serviceExtendService.queryServiceExtendByServiceId(serviceId);
    	vo.setService(service);
    	vo.setServiceExtend(serviceExtend);
    	vo.setServiceTypes(serviceTypes);
    	return ResponseResult.success(vo);
    }
    @ApiOperation(httpMethod="POST", value="创建服务项目主表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ServiceVo serviceVo) {
    	try {
			 serviceService.saveServiceDetail(serviceVo);
			 return ResponseResult.success();
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseResult.fail(ResponseCode.ERROR);
		}
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ServiceVo serviceVo) {
    	 Service service= serviceVo.getService();
        if (service.getId() == null || service.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        Integer serviceId = service.getId();
        Service oldService =  this.serviceService.queryObjById(serviceId);
        if(oldService==null){
        	throw new CommonException("传入的ID有错");
        }
        try {
        	boolean  isOk = this.serviceService.modifyServiceDetail(serviceVo, oldService);
            return	isOk==true?ResponseResult.success():ResponseResult.fail(ResponseCode.ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(ResponseCode.ERROR);
		}
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/updateServiceStateById")
    @ResponseBody
    public ResponseResult<String> updateServiceStateById(@RequestParam(required=true) Integer id,@RequestParam(required=true)Byte state) {
    	 if(id==null||id<=0||state==null){
    		 throw new CommonException("数据错误");
    	 }
    	 boolean stateIsNotRight = true;
    	 switch (state) {
    	 case 0:
 			stateIsNotRight = false;
 			break;
		 case 1:
			stateIsNotRight = false;
			break;
		 case 2:
			stateIsNotRight = false;
			break;
		default:
			break;
		}
    	 if(stateIsNotRight){
    		 throw new CommonException("服务项目状态错误！");
    	 }
    	 Service service = this.serviceService.queryObjById(id);
    	 if(service==null){
    		 throw new CommonException("数据错误");
    	 }
    	 Service tempService = new Service();
    	 tempService.setId(id);
    	 tempService.setState(state);
    	 this.serviceService.updateService(tempService);
        return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="查询服务项目主表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Service", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Service>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        ServiceExample example = new ServiceExample();
        example.setPageView(new PageView<Service>(pageNo, pageSize));
        ServiceExample.Criteria criteria = example.createCriteria();
        boolean isNotState = true;
        if (wapper != null) {
        	 List<QueryParam> queryParamList =  wapper.getQueryParams();
        	 if(queryParamList!=null){
        		 for (QueryParam queryParam : queryParamList) {
            		 String property = queryParam.getProperty();
            		 if(property.contains("state")){
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
        PageView<Service> pageData = this.serviceService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
    
}