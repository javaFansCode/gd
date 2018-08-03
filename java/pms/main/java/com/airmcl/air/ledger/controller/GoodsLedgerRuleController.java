package com.airmcl.air.ledger.controller;

import com.airmcl.air.ledger.entity.GoodsLedgerRule;
import com.airmcl.air.ledger.service.GoodsLedgerRuleService;
import com.airmcl.air.ledger.entity.GoodsLedgerRuleExample;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Deprecated
@Api(value="商品与分账规则对应关系")
@Controller
@RequestMapping("goodsLedgerRule")
public class GoodsLedgerRuleController {
    @Resource
    protected GoodsLedgerRuleService goodsLedgerRuleService;

    @ApiOperation(httpMethod="POST", value="创建商品与分账规则对应关系")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody GoodsLedgerRule goodsLedgerRule) {
        this.goodsLedgerRuleService.addObj(goodsLedgerRule);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody GoodsLedgerRule goodsLedgerRule) {
        if (StringUtils.isBlank(goodsLedgerRule.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.goodsLedgerRuleService.modifyObj(goodsLedgerRule);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.goodsLedgerRuleService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询商品与分账规则对应关系")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 GoodsLedgerRule", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<GoodsLedgerRule>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        GoodsLedgerRuleExample example = new GoodsLedgerRuleExample();
        example.setPageView(new PageView<GoodsLedgerRule>(pageNo, pageSize));
        
        if (wapper != null) {
            GoodsLedgerRuleExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<GoodsLedgerRule> pageData = this.goodsLedgerRuleService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}