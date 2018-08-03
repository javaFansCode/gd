package com.airmcl.air.order.web.controller;

import com.airmcl.air.order.entity.OrderAction;
import com.airmcl.air.order.entity.OrderActionExample;
import com.airmcl.air.order.service.OrderActionService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.ResponseCode;
import com.els.base.core.utils.query.QueryParamWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="mdd_api_order_action")
@Controller
@RequestMapping("orderAction")
public class OrderActionController {
    @Resource
    protected OrderActionService orderActionService;

    @ApiOperation(httpMethod="POST", value="创建mdd_api_order_action")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody OrderAction orderAction) {
        this.orderActionService.addObj(orderAction);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody OrderAction orderAction) {
        if (orderAction.getId() == null || orderAction.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.orderActionService.modifyObj(orderAction);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.orderActionService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<OrderAction>> findAll() {
        OrderActionExample example = new OrderActionExample();
        List<OrderAction> list=this.orderActionService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询mdd_api_order_action")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderAction", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<OrderAction>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderActionExample example = new OrderActionExample();
        example.setPageView(new PageView<OrderAction>(pageNo, pageSize));
        
        if (wapper != null) {
            OrderActionExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<OrderAction> pageData = this.orderActionService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    @RequestMapping(method = RequestMethod.GET, value = "service/selectByPrimaryKey")
    @ResponseBody
    public ResponseResult<OrderAction> selectByPrimaryKey(@RequestParam(required=true) int id){
        if (StringUtils.isBlank(String.valueOf(id))) {
            throw new CommonException("查询失败,id不能为空");
        }
        OrderAction oa = this.orderActionService.queryObjById(id);
        return ResponseResult.success(oa);
    }
}