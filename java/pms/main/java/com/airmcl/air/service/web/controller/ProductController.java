package com.airmcl.air.service.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.service.entity.Product;
import com.airmcl.air.service.entity.ProductExample;
import com.airmcl.air.service.service.ProductService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="产品表")
@Controller
@RequestMapping("product")
public class ProductController {
    @Resource
    protected ProductService productService;

    @ApiOperation(httpMethod="POST", value="创建产品表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Product product) {
    	int creatTime = (int) (System.currentTimeMillis()/1000);
    	product.setCreatetime(creatTime);
        this.productService.addObj(product);
        return ResponseResult.success();
    }
    @RequestMapping(method = RequestMethod.GET, value = "service/toEditView")
    @ResponseBody
    public ResponseResult<Product> editView(@RequestParam(required=true) Integer id) {
    	if (id == null || id <=0) {
            throw new CommonException("id 为空，查询失败");
        }
    	Product product = this.productService.queryObjById(id);
    	if(product==null){
    		 throw new CommonException("id 错误，查询失败");
    	}
    	return ResponseResult.success(product);
    }
    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Product product) {
        if (product.getId() == null || product.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.productService.modifyObj(product);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) Integer id) {
        if (id==null) {
            throw new CommonException("删除失败,id不能为空");
        }
        Product product = this.productService.queryObjById(id);
    	if(product==null){
    		 throw new CommonException("id 错误，查询失败");
    	}
    	product.setState(Byte.valueOf("0"));
    	this.productService.modifyObj(product);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询产品表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Product", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Product>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        ProductExample example = new ProductExample();
        example.setPageView(new PageView<Product>(pageNo, pageSize));
        
        if (wapper != null) {
            ProductExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<Product> pageData = this.productService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}