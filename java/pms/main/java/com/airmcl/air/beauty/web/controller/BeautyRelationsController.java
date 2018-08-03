package com.airmcl.air.beauty.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.beauty.entity.BeautyRelations;
import com.airmcl.air.beauty.entity.BeautyRelationsExample;
import com.airmcl.air.beauty.entity.BeautyRelationsGoodsPara;
import com.airmcl.air.beauty.entity.BeautyRelationsGoodsVO;
import com.airmcl.air.beauty.entity.BeautyRelationsPara;
import com.airmcl.air.beauty.entity.BeautyRelationsServicePara;
import com.airmcl.air.beauty.entity.BeautyRelationsServiceVO;
import com.airmcl.air.beauty.entity.OutBeautyRelationsRecord;
import com.airmcl.air.beauty.service.BeautyRelationsService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="门店项目关联表")
@Controller
@RequestMapping("beautyRelations")
public class BeautyRelationsController {
    @Resource
    protected BeautyRelationsService beautyRelationsService;

    @ApiOperation(httpMethod="POST", value="创建门店项目关联表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody BeautyRelations beautyRelations) {
        this.beautyRelationsService.addObj(beautyRelations);
        return ResponseResult.success();
    }
    
    
    
    
    /**
     *变更门店关联服务项目、变更门店关联商品
     * @param br
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "service/changeRelations" )
    @ResponseBody
    public ResponseResult<String> changeRelations(@RequestBody List<BeautyRelationsPara>  br) {
    	
    	if (br.size()<1) {
			throw new CommonException("输入参数集合为空！");
		}else {
			for (BeautyRelationsPara beautyRelationsPara : br) {
				if(beautyRelationsPara.getId()==null){//当id为null是表示无关联关系
		    		BeautyRelationsExample example = new BeautyRelationsExample();
		    		BeautyRelationsExample.Criteria criteria = example.createCriteria();
		    		criteria.andBeautyIdEqualTo(beautyRelationsPara.getBeautyId());
		    		criteria.andRelationIdEqualTo(beautyRelationsPara.getRelationId());
		    		criteria.andTypeEqualTo(beautyRelationsPara.getType());
		    	 
		            List<BeautyRelations> list=this.beautyRelationsService.queryAllObjByExample(example);
		             if (list.size()<1) {
//		            	 beautyId门店ID,relationId项目ID  和  type类型   三项判断唯一（防止重复添加 不存在创建，存在更新 ）
		         		BeautyRelations beautyRelations=new BeautyRelations();
		        		beautyRelations.setBeautyId(beautyRelationsPara.getBeautyId());
		        		beautyRelations.setRelationId(beautyRelationsPara.getRelationId());
		        		beautyRelations.setState(beautyRelationsPara.getState());
		        		beautyRelations.setType(beautyRelationsPara.getType());
		        		beautyRelations.setOperateId(1);
		        		beautyRelations.setOperateType((byte)1);
		        		beautyRelations.setCreatetime(String.valueOf( (new Date()).getTime()));
		        		this.beautyRelationsService.addObj(beautyRelations);
					}else{
			    		 BeautyRelations beautyRelations=list.get(0);
			    		 beautyRelations.setState(beautyRelationsPara.getState());
			    		 this.beautyRelationsService.modifyObj(beautyRelations);
					}
		    	}else{//存在关联关系只修改关联状态
		    		 BeautyRelations beautyRelations=this.beautyRelationsService.selectByPrimaryKey(beautyRelationsPara.getId());
		    		 beautyRelations.setState(beautyRelationsPara.getState());
		    		 this.beautyRelationsService.modifyObj(beautyRelations);
		    	}
			}
		}
        return ResponseResult.success();
    }
    

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody BeautyRelations beautyRelations) {
        if (beautyRelations.getId() == null || beautyRelations.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.beautyRelationsService.modifyObj(beautyRelations);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.beautyRelationsService.deleteObjById(id);
        return ResponseResult.success();
    }

    /**
     *获取门店关联服务项目
     * @param br
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "service/selectServiceByBeautyId" )
    @ResponseBody
    public ResponseResult<List<BeautyRelationsServiceVO>> selectServiceByBeautyId(@RequestBody BeautyRelationsServicePara  br) {
    	Map<String, Object> para=new HashMap<String, Object>();
    	para.put("beautyId", br.getBeautyId());//门店id
    	if(br.getServiceState()!=null)
    	{
    		para.put("serviceState", br.getServiceState());// <!--  -- 已上架 -->
    	}
    	
    	List<BeautyRelationsServiceVO> sb=this.beautyRelationsService.selectServiceByBeautyId(para);
        return ResponseResult.success(sb);
    }
    
    /**
     *获取门店关联商品
     * @param br
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "service/selectGoodsByBeautyId" )
    @ResponseBody
    public ResponseResult<List<BeautyRelationsGoodsVO>> selectGoodsByBeautyId(@RequestBody BeautyRelationsGoodsPara  br) {
    	Map<String, Object> para=new HashMap<String, Object>();
    	para.put("beautyId", br.getBeautyId());//门店id
    	if(br.getGoodsState()!=null)
    	{
    		para.put("goodsState", br.getGoodsState());  
    	}
    	
    	List<BeautyRelationsGoodsVO> sb=this.beautyRelationsService.selectGoodsByBeautyId(para);
        return ResponseResult.success(sb);
    }
    
    
    @ApiOperation(httpMethod="POST", value="查询门店项目关联表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 BeautyRelations", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<BeautyRelations>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BeautyRelationsExample example = new BeautyRelationsExample();
        example.setPageView(new PageView<BeautyRelations>(pageNo, pageSize));
        
       
        if (wapper != null) {
            BeautyRelationsExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<BeautyRelations> pageData = this.beautyRelationsService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
    /**
     * 1,无条件查询mdd_api_beauty_relations主表数据---->关联查询项目名称以及门店名称
     * 2,根据关联的ServiceId 查询服务项目名称.
	 *   分两种情况,在mdd_api_beauty_relations表内有type字段，如果是1则从查询服务项目mdd_api_service表内的名称，如果是2则查询商品表mdd_api_goods
     * 3,根据关联的bt_id查询mdd_api_beauty门店名称
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(httpMethod="POST", value="门店关联项目记录接口")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 BeautyRelations", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.GET, value = "service/findRecord")
    @ResponseBody
    public ResponseResult<PageView<OutBeautyRelationsRecord>> findRecord(
    		@RequestParam(defaultValue="0") int pageNo,  
    		 @RequestParam(defaultValue="10") int pageSize){
		
		PageView<OutBeautyRelationsRecord> resultData = beautyRelationsService.findBeautyRelationsRecord(pageNo,pageSize);
		
		return ResponseResult.success(resultData);
		
	}
}