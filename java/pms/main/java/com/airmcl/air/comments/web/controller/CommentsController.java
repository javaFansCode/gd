package com.airmcl.air.comments.web.controller;

import com.airmcl.air.beautician.entity.StateEnum;
import com.airmcl.air.comments.entity.Comments;
import com.airmcl.air.comments.entity.CommentsExample;
import com.airmcl.air.comments.entity.CommentsExt;
import com.airmcl.air.comments.entity.CommentsExtExample;
import com.airmcl.air.comments.service.CommentsService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Api(value="订单评论主表")
@Controller
@RequestMapping("comments")
public class CommentsController {
    @Resource
    protected CommentsService commentsService;


    @ApiOperation(httpMethod="POST", value="创建订单评论主表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Comments comments) {
        this.commentsService.addObj(comments);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Comments comments) {
        if (comments.getId() == null || comments.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.commentsService.modifyObj(comments);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.commentsService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<Comments>> findAll() {
        CommentsExample example = new CommentsExample();
        List<Comments> list=this.commentsService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }


    /**
     * 批量修改state状态
     * 状态，1已审核，2未审核 0删除  3下架
     */
    @RequestMapping(method = RequestMethod.POST, value = "service/updateState",consumes ="application/json" )
    @ResponseBody
    public ResponseResult<String> updateState(@RequestParam(required=true) int[] ids,@RequestParam(required=true)  Integer state){
        if(StateEnum.fromCode(state)==null){
            throw new CommonException("不存在的状态，保存失败");
        }
         this.commentsService.updateState(ids,state);
         return  ResponseResult.success();
     }

    @ApiOperation(httpMethod="POST", value="连表查询")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),
            @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),
            @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 commentsExt", paramType = "body", dataType = "QueryParamWapper" )
    })
    @RequestMapping(method = RequestMethod.POST, value = "service/findAllByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<CommentsExt>> findByPage(
            @RequestParam(defaultValue="0") int pageNo,
            @RequestParam(defaultValue="10") int pageSize,
            @RequestBody(required=false) CommentsExt commentsParams) {
//        CommentsExtExample example = new CommentsExtExample();
//        example.setPageView(new PageView<CommentsExt>(pageNo, pageSize));
//        CommentsExtExample.Criteria criteria = example.createCriteria().andStateNotEqualTo((byte)0);
//        if (wapper != null) {
//            CriteriaUtils.addCriterion(criteria, wapper);
//        }

        PageView<CommentsExt> pageData = this.commentsService.queryCommentsByparams(commentsParams,pageNo,pageSize);
        return ResponseResult.success(pageData);
    }


    @RequestMapping(method = RequestMethod.GET, value = "service/deleteByidS",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteByIds(@RequestParam(required=true) int[] ids) {
        if(ids.length==0||null == ids){
            throw new CommonException("id不能为空");
        }
            for (int id : ids) {
                this.commentsService.deleteObjById(id);
        }
        return ResponseResult.success();
    }

}