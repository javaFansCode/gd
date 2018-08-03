package com.airmcl.air.ledger.controller;

import com.airmcl.air.ledger.entity.LedgerRuleDetail;
import com.airmcl.air.ledger.entity.LedgerRuleDetailExample;
import com.airmcl.air.ledger.service.LedgerRuleDetailService;
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
@Api(value="分账规则明细")
@Controller
@RequestMapping("ledgerRuleDetail")
public class LedgerRuleDetailController {
    @Resource
    protected LedgerRuleDetailService ledgerRuleDetailService;

    @ApiOperation(httpMethod="POST", value="创建分账规则明细")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody LedgerRuleDetail ledgerRuleDetail) {
        this.ledgerRuleDetailService.addObj(ledgerRuleDetail);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody LedgerRuleDetail ledgerRuleDetail) {
        if (StringUtils.isBlank(ledgerRuleDetail.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.ledgerRuleDetailService.modifyObj(ledgerRuleDetail);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.ledgerRuleDetailService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询分账规则明细")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 LedgerRuleDetail", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<LedgerRuleDetail>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        LedgerRuleDetailExample example = new LedgerRuleDetailExample();
        example.setPageView(new PageView<LedgerRuleDetail>(pageNo, pageSize));
        
        if (wapper != null) {
            LedgerRuleDetailExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<LedgerRuleDetail> pageData = this.ledgerRuleDetailService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}