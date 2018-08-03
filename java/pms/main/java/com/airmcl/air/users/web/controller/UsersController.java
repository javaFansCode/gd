package com.airmcl.air.users.web.controller;

import com.airmcl.air.coupon.service.CouponService;
import com.airmcl.air.users.enter.EnterUserRelationParams;
import com.airmcl.air.users.entity.Users;
import com.airmcl.air.users.entity.UsersEditRefereeParaVO;
import com.airmcl.air.users.entity.UsersExample;
import com.airmcl.air.users.out.OutUserRelationship;
import com.airmcl.air.users.service.UsersService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "会员用户表")
@Controller
@RequestMapping("users")
public class UsersController {
	@Resource
	protected UsersService usersService;
	@Resource
	protected CouponService couponService;

	@ApiOperation(httpMethod = "POST", value = "创建会员用户表")
	@RequestMapping(method = RequestMethod.POST, value = "service/create", consumes = "application/json")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Users users) {
		this.usersService.addObj(users);
		return ResponseResult.success();
	}

	@RequestMapping(method = RequestMethod.POST, value = "service/edit", consumes = "application/json")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Users users) {
		if (users.getId() == null || users.getId() <= 0) {
			throw new CommonException("id 为空，保存失败");
		}
		this.usersService.modifyObj(users);
		return ResponseResult.success();
	}

	/**
	 * 编辑会员受益人
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "service/editReferee", consumes = "application/json")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody UsersEditRefereeParaVO users) {
		if (users.getUserId() == null) {
			throw new CommonException("id 为空，保存失败");
		}
		this.usersService.editReferee(users);
		return ResponseResult.success();
	}

	@RequestMapping(method = RequestMethod.GET, value = "service/deleteById", consumes = "application/json")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) int id) {
		this.usersService.deleteObjById(id);
		return ResponseResult.success();
	}

	@RequestMapping(method = RequestMethod.GET, value = "service/findAll")
	@ResponseBody
	public ResponseResult<List<Users>> findAll() {
		UsersExample example = new UsersExample();
		List<Users> list = this.usersService.queryAllObjByExample(example);
		return ResponseResult.success(list);
	}

	@ApiOperation(httpMethod="POST", value="查询会员用户表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Users", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Users>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        UsersExample example = new UsersExample();
        example.setPageView(new PageView<Users>(pageNo, pageSize));
        example.setOrderByClause("createtime DESC");
        if (wapper != null) {
            UsersExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<Users> pageData = this.usersService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }

	@ApiOperation(httpMethod="POST", value="查询会员关联关系表")
    @ApiImplicitParams({ 
   	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
   	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
   	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 mdd_api_user_relationship", paramType = "body", dataType = "EnterUserRelationParams" )  
   	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findUserRelationshipPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<OutUserRelationship>> findUserRelationshipPage(
	 @RequestParam int pageNo,
	 @RequestParam int pageSize,
	 @RequestBody(required=false) EnterUserRelationParams params){
		
		PageView<OutUserRelationship> pageData = usersService.findUserRelationByPage(params,pageNo,pageSize);
		
		return ResponseResult.success(pageData);
		
	}
    		
	
		/**
		 * 手工送券
		 * 
		 */
		@ApiOperation(httpMethod="POST", value="手工送券")
		@RequestMapping(method = RequestMethod.GET, value = "service/sendCouponByHand")
		@ResponseBody
		ResponseResult<String> sendCouponByHand(@RequestParam(required=false)String mobile,String couponId) {
			
			couponService.sendCouponByHand(mobile,couponId);
			
			return ResponseResult.success();
		}
    
}