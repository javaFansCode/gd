package com.airmcl.air.oss.web.controller;

import com.airmcl.air.oss.entity.MddAttachment;
import com.airmcl.air.oss.entity.MddAttachmentExample;
import com.airmcl.air.oss.service.MddAttachmentService;
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

@Api(value="附件表")
@Controller
@RequestMapping("mddAttachment")
public class MddAttachmentController {
    @Resource
    protected MddAttachmentService mddAttachmentService;

    @ApiOperation(httpMethod="POST", value="创建附件表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody MddAttachment mddAttachment) {
        this.mddAttachmentService.addObj(mddAttachment);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody MddAttachment mddAttachment) {
        if (mddAttachment.getId() == null || mddAttachment.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.mddAttachmentService.modifyObj(mddAttachment);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        if (id <= 0) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.mddAttachmentService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询附件表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 MddAttachment", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<MddAttachment>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        MddAttachmentExample example = new MddAttachmentExample();
        example.setPageView(new PageView<MddAttachment>(pageNo, pageSize));
        
        if (wapper != null) {
            MddAttachmentExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<MddAttachment> pageData = this.mddAttachmentService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}