package com.airmcl.air.goods.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.goods.entity.GoodServiceVo;
import com.airmcl.air.goods.entity.Goods;
import com.airmcl.air.goods.entity.GoodsAutoShelve;
import com.airmcl.air.goods.entity.GoodsAutoShelveVo;
import com.airmcl.air.goods.entity.GoodsExample;
import com.airmcl.air.goods.entity.GoodsExtend;
import com.airmcl.air.goods.entity.GoodsHomeBuy;
import com.airmcl.air.goods.entity.GoodsHomeBuyRecord;
import com.airmcl.air.goods.entity.GoodsHomeBuyVo;
import com.airmcl.air.goods.entity.GoodsRelations;
import com.airmcl.air.goods.entity.GoodsVo;
import com.airmcl.air.goods.service.GoodsService;
import com.airmcl.air.service.entity.Service;
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

@Api(value="商品表")
@Controller
@RequestMapping("goods")  
public class GoodsController {
    @Resource
    protected GoodsService goodsService;
    
    @ApiOperation(httpMethod="POST", value="设置项目和商品关联")
    @RequestMapping(method = RequestMethod.POST, value = "service/configServieAndGood")
    @ResponseBody
    public ResponseResult<String> configServieAndGood(@RequestBody(required=true)GoodServiceVo goodServiceVo){
    	Goods goods = goodServiceVo.getGoods();
    	Integer goodsId = goods.getId();
    	Goods good = this.goodsService.queryObjById(goodsId);
   	    if(good==null){ 
    		    throw new CommonException("商品数据获取失败");
    	  }
   	    List<GoodsRelations> godsRelations = goodServiceVo.getGoodsRelations();
   	    if(godsRelations!=null&&!godsRelations.isEmpty()){
   	    	Long createTime = System.currentTimeMillis()/1000;
   	   	    for(GoodsRelations gr :godsRelations){
   	   	    	gr.setGoodsId(goodsId);
   	   	    	gr.setCreatetime(createTime.toString());
   	   	    	gr.setOperateType(Byte.valueOf("1"));
   	   	    	gr.setOperateId(1);//TODO
   	   	    }
   	    }
   	    try {
			   goodsService.modifyGoodsRelations(godsRelations,goodsId);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(ResponseCode.ERROR);
		}
   	 return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="GET", value="设置项目界面")
    @RequestMapping(method = RequestMethod.GET, value = "service/toConfigServieView")
    @ResponseBody
    public ResponseResult<GoodServiceVo> toConfigServieView(@RequestParam(required=true)Integer goodsId){
    	Goods good = this.goodsService.queryObjById(goodsId);
   	    if(good==null){ 
    		    throw new CommonException("商品数据获取失败");
    	  }
   	    List<Service> services =goodsService.queryAllSingleTypeOneService();
   	    List<GoodsRelations> goodsRelationsList = goodsService.queryGoodsRelationsByGoodsId(goodsId);
   	    GoodServiceVo vo = new GoodServiceVo();
	   	vo.setGoods(good);
	   	vo.setServices(services);
	   	if(goodsRelationsList!=null&&goodsRelationsList.size()>0){
	   	   vo.setGoodsRelations(goodsRelationsList);	
	   	}
   	   return ResponseResult.success(vo);
    }
    
    @ApiOperation(httpMethod="POST", value="设置商品限购")
    @RequestMapping(method = RequestMethod.POST, value = "service/editGoodsHomeBuyVo")
    @ResponseBody
    public ResponseResult<String> editGoodsHomeBuyVo(@RequestBody(required=true)GoodsHomeBuyVo goodsHomeBuyVo){
    	Integer goodsId = goodsHomeBuyVo.getGoodsId();
    	Goods good = this.goodsService.queryObjById(goodsId);
   	    if(good==null){ 
    		    throw new CommonException("商品数据获取失败");
    	  }
   	 try {
   		GoodsHomeBuy homeBuy = goodsHomeBuyVo.getGoodsHomeBuy();
   		GoodsHomeBuyRecord record =	new GoodsHomeBuyRecord();
   		record = copyBean(homeBuy,record);
   		goodsHomeBuyVo.setGoodsHomeBuyRecord(record);
		goodsService.modifyGoodsHomeBuyAndGoodsHomeBuyRecord(goodsHomeBuyVo);
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseResult.fail(ResponseCode.Data_Error);
	}
   	    return ResponseResult.success();
    }
    private GoodsHomeBuyRecord copyBean(GoodsHomeBuy homeBuy,GoodsHomeBuyRecord record){
    	record.setAdminId(homeBuy.getAdminId());
    	record.setCreatetime(homeBuy.getCreatetime());
    	record.setGoodsId(homeBuy.getGoodsId());
    	record.setIsPurchase(homeBuy.getIsPurchase());
    	record.setPurchaseTotal(homeBuy.getPurchaseTotal().intValue());
    	record.setTotal(homeBuy.getTotal());
    	return record;
    }
    @ApiOperation(httpMethod="GET", value="设置商品限购界面")
    @RequestMapping(method = RequestMethod.GET, value = "service/toGoodsHomeBuyVoView")
    @ResponseBody
    public ResponseResult<GoodsHomeBuyVo> toGoodsHomeBuyVoView(@RequestParam(required=true)Integer goodsId){
    	Goods good = this.goodsService.queryObjById(goodsId);
   	    if(good==null){ 
    		    throw new CommonException("商品数据获取失败");
    	  }
   	   GoodsHomeBuy goodsHomeBuy = goodsService.queryGoodsHomeBuyByGoodsId(goodsId);
   	   GoodsHomeBuyVo vo = new GoodsHomeBuyVo();
   	   vo.setGoodsId(good.getId());
   	   vo.setGoodsName(good.getGoodsName());
   	   vo.setGoodsHomeBuy(goodsHomeBuy);
   	   return ResponseResult.success(vo);
    }
    @ApiOperation(httpMethod="POST", value="设置商品自动上下架") 
    @RequestMapping(method = RequestMethod.POST, value = "service/editGoodsAutoShelve")
    @ResponseBody
    public ResponseResult<String> editGoodsAutoShelve(@RequestBody(required=true)GoodsAutoShelveVo vo){
    	 Integer goodsId = vo.getGoodsId();
    	 Goods good = this.goodsService.queryObjById(goodsId);
    	 if(good==null){
     		    throw new CommonException("商品数据获取失败");
     	   }
    	 GoodsAutoShelve goodsAutoShelve = vo.getGoodsAutoShelve();
    	 goodsAutoShelve.setGoodsId(goodsId);
		 int result = goodsService.addGoodsAutoShelve(goodsAutoShelve);
		return result>0?ResponseResult.success():ResponseResult.fail(ResponseCode.Data_Error);
    }
    
    @ApiOperation(httpMethod="GET", value="设置商品自动上下架界面")
    @RequestMapping(method = RequestMethod.GET, value = "service/toGoodsAutoShelveView")
    @ResponseBody
    public ResponseResult<GoodsAutoShelveVo> toGoodsAutoShelveView(@RequestParam(required=true)Integer goodId){
    	 Goods good = this.goodsService.queryObjById(goodId);
    	 if(good==null){
   		   throw new CommonException("商品数据获取失败");
   	    }
    	 GoodsAutoShelve goodsAutoShelve =  goodsService.queryGoodsAutoShelveByGoodsId(goodId);
    	 GoodsAutoShelveVo vo = new GoodsAutoShelveVo();
    	 vo.setGoodsAutoShelve(goodsAutoShelve);
    	 vo.setGoodsId(goodId);
    	 vo.setGoodsName(good.getGoodsName());
    	 return ResponseResult.success(vo);
    }
    
    @ApiOperation(httpMethod="GET", value="修改商品界面")
    @RequestMapping(method = RequestMethod.GET, value = "service/toEditGoodsView")
    @ResponseBody
    public ResponseResult<GoodsVo> toEditGoodsView(@RequestParam(required=true)Integer goodId){
    	if(goodId==null||goodId<=0){
    		  throw new CommonException("goodId 为空，获取数据失败");
    	  }
    	  Goods good = this.goodsService.queryObjById(goodId);
    	  if(good==null){
    		  throw new CommonException("商品数据获取失败");
    	  }
    	  GoodsVo vo = new GoodsVo();
    	  Integer goodsId = good.getId();
    	  GoodsExtend goodsExtend =  goodsService.queryGoodsExtendByGoodsId(goodsId);
    	  vo.setGoods(good);
    	  vo.setGoodsExtend(goodsExtend);
    	  return ResponseResult.success(vo);
    }
    
    @ApiOperation(httpMethod="POST", value="修改商品状态")
    @RequestMapping(method = RequestMethod.POST, value = "service/modifyGoodsState")
    @ResponseBody
    public ResponseResult<String> modifyGoodsState(@RequestParam(required=true)Integer goodId,@RequestParam(required=true)Byte type) {
    	 int result = 0;
    	try {
		    result = goodsService.modifyGoodsDetailState(goodId, type);
		  if(result>0){
			  return ResponseResult.success();
		  } 
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseResult.fail(ResponseCode.ERROR);
		}
    	if(result==-1){
    		throw new CommonException("请关联服务项目后上架");
    	}
    	return ResponseResult.success();
        
    }
    
    @ApiOperation(httpMethod="POST", value="创建商品表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody GoodsVo vo) {
    	Goods goods = vo.getGoods();
    	if(goods==null){
    		throw new CommonException("数据错误");
    	}
    	Byte type = goods.getType();
    	Long systemTime = System.currentTimeMillis();
    	Long createTime = systemTime/1000;
    	String cardNumber = createCardNumber(type,  systemTime);
    	goods.setCardNumber(cardNumber);
    	goods.setCreatetime(createTime.intValue());
    	GoodsExtend extend = vo.getGoodsExtend();
    	extend.setCreatetime(createTime.intValue());
        try {
			this.goodsService.addGoodsAndGoodsExtend(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(ResponseCode.Data_Error);
		}
        return ResponseResult.success();
    }
    private String createCardNumber(Byte type,Long createTime){
    	//type 1=会员卡，2=储蓄卡 , 3=月卡
    	StringBuilder sb = new StringBuilder();
    	 switch (type) {
		case 1:
			sb.append("V");
			break;
		case 2:
			sb.append("M");
			break;
		case 3:
			sb.append("Y");
			break;
		default:
			break;
		}
    	return sb.append(createTime).toString();
    }
    @ApiOperation(httpMethod="POST", value="修改商品表")
    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody GoodsVo vo) {
    	Goods goods = vo.getGoods();
        if (goods.getId() == null || goods.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        Integer goodsId = goods.getId();
        Goods tempGoods =  this.goodsService.queryObjById(goodsId);
        if(tempGoods==null){
        	throw new CommonException("数据问题");
        }
        try {
			this.goodsService.modifyGoodsAndGoodsExtend(vo);
		} catch (Exception e) {
			  e.printStackTrace();
			  return ResponseResult.fail(ResponseCode.Data_Error);
		}
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) Integer id) {
        if (id==null||id<=0) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.goodsService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询商品表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Goods", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Goods>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        GoodsExample example = new GoodsExample();
        example.setPageView(new PageView<Goods>(pageNo, pageSize));
        GoodsExample.Criteria criteria = example.createCriteria();
        boolean isNotState = true;
        if (wapper != null) {
        	List<QueryParam> queryParamList = wapper.getQueryParams();
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
        example.setOrderByClause(" createtime desc");
        PageView<Goods> pageData = this.goodsService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}