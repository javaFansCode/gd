package com.airmcl.air.area.web.controller;

import com.airmcl.air.area.entity.OpenCity;
import com.airmcl.air.area.entity.OpenCityExample;
import com.airmcl.air.area.service.OpenCityService;
import com.airmcl.air.area.vo.AddStreetVO;
import com.airmcl.air.area.vo.CreateOpenCityVO;
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

@Api(value="服务开通城市表")
@Controller
@RequestMapping("openCity")
public class OpenCityController {
    @Resource
    protected OpenCityService openCityService;

    @ApiOperation(httpMethod="POST", value="创建服务开通城市表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody OpenCity openCity) {
        this.openCityService.addObj(openCity);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody OpenCity openCity) {
        if (openCity.getId() == null || openCity.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.openCityService.modifyObj(openCity);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        if (id <=0) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.openCityService.deleteStreetById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询服务开通城市表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OpenCity", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<OpenCity>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OpenCityExample example = new OpenCityExample();
        example.setPageView(new PageView<OpenCity>(pageNo, pageSize));
        OpenCityExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo((byte)1);

        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<OpenCity> pageData = this.openCityService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }

    @ApiOperation(httpMethod = "GET", value = "获取所有开通城市列表，参数父级id，不分页，未删除")
    @RequestMapping(method = RequestMethod.GET, value = "service/openCityListByParentId")
    @ResponseBody
    public ResponseResult<List<OpenCity>> openCityListByParentId(@RequestParam(required = false) Integer parentId){

        if (parentId == null){
            throw new CommonException("参数不能为空");
        }

        OpenCityExample example = new OpenCityExample();
        OpenCityExample.Criteria criteria = example.createCriteria();

        //父级ID
        criteria.andParent_idEqualTo(parentId);
        //是否开放预约1开放预约 2此城市所有美容师都不可以被预约
        criteria.andOpen_reserveEqualTo((byte)1);
        //并且状态为正常的数据
        criteria.andStateEqualTo((byte)1);

        List<OpenCity> openCityList = this.openCityService.queryAllObjByExample(example);
        return ResponseResult.success(openCityList);
    }

    @Deprecated
    @ApiOperation(httpMethod = "GET", value = "获取所有开通城市列表，不分页，未删除")
    @RequestMapping(method = RequestMethod.GET, value = "service/openCityList")
    @ResponseBody
    public ResponseResult<List<OpenCity>> openCityList(){
        /**
         * 方法已废弃
         */

        OpenCityExample example = new OpenCityExample();
        OpenCityExample.Criteria criteria = example.createCriteria();
        //开通城市列表，只获取level为2的数据
        criteria.andLevelEqualTo((byte)2);
        //并且状态为正常的数据
        criteria.andStateEqualTo((byte)1);

        List<OpenCity> openCityList = this.openCityService.queryAllObjByExample(example);
        return ResponseResult.success(openCityList);
    }

    @ApiOperation(httpMethod = "GET", value = "根据城市ID获取区数据列表，不分页")
    @RequestMapping(method = RequestMethod.GET, value = "service/openCityAreaList")
    @ResponseBody
    public ResponseResult<List<OpenCity>> openCityAreaList(@RequestParam int cityId){
        OpenCityExample example = new OpenCityExample();

        OpenCityExample.Criteria criteria = example.createCriteria();
        //开通城市列表，只获取level为2的数据
        criteria.andLevelEqualTo((byte)3);
        //父级城市ID
        criteria.andParent_idEqualTo(cityId);
        //并且状态为正常的数据
        criteria.andStateEqualTo((byte)1);

        List<OpenCity> openCityList = this.openCityService.queryAllObjByExample(example);
        return ResponseResult.success(openCityList);
    }

    @ApiOperation(httpMethod = "POST", value = "创建开通城市")
    @RequestMapping(method = RequestMethod.POST, value = "service/createOpenCity",consumes ="application/json")
    @ResponseBody
    public ResponseResult<OpenCity> createOpenCity(@RequestBody CreateOpenCityVO createOpenCityVO){
        if (createOpenCityVO.getProvinceId() <=0){
            throw new CommonException("参数provinceId不能为空");
        }
        if (createOpenCityVO.getCityId() <=0){
            throw new CommonException("参数cityId不能为空");
        }
        return ResponseResult.success(this.openCityService.createOpenCity(createOpenCityVO));
    }

    @ApiOperation(httpMethod = "POST", value = "给区添加街道数据，支持批量")
    @RequestMapping(method = RequestMethod.POST, value = "service/addStreetToArea",consumes ="application/json")
    @ResponseBody
    public ResponseResult<OpenCity> addStreetToArea(@RequestBody AddStreetVO streetVO){
        if (streetVO.getAreaId() <= 0){
            throw new CommonException("参数areaId不能为空");
        }
        if (streetVO.getStreets().size() <= 0){
            throw new CommonException("参数street不能为空");
        }
        return ResponseResult.success(this.openCityService.addStreetToArea(streetVO));
    }

}