package com.airmcl.air.app.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.airmcl.basae.utils.BaseConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.app.enter.BannerEnterParams;
import com.airmcl.air.app.entity.Banner;
import com.airmcl.air.app.entity.BannerExample;
import com.airmcl.air.app.service.BannerService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="banner图")
@Controller
@RequestMapping("banner")
public class BannerController {
    @Resource
    protected BannerService bannerService;

    @ApiOperation(httpMethod="POST", value="创建banner图")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Banner banner) {
    	
        this.bannerService.insertBanner(banner);
        
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Banner banner) {
        if (banner.getId() == null || banner.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.bannerService.modifyObj(banner);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.bannerService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<Banner>> findAll() {
        BannerExample example = new BannerExample();
        BannerExample.Criteria criteria = example.createCriteria().andStateNotEqualTo(BaseConst.BEAUTY_STATE_DELETE);
        List<Banner> list=this.bannerService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询banner图")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Banner", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Banner>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) BannerEnterParams params) {
        //后台也要显示banner  要联查photo表
        PageView<Banner> pageData = bannerService.findBannerByPage(params,pageNo,pageSize);

        return ResponseResult.success(pageData);
    }


    /**
     * 修改banner状态
     * @param ids
     * @return
     */

    @RequestMapping(method  = {RequestMethod.GET}, value = "service/updateBannerState")
    @ResponseBody
    public ResponseResult<String> deleteByIds(@RequestParam(required=true) int[] ids,String state) {
        this.bannerService.updateStateByIds(ids,state);
        return ResponseResult.success();
    }

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "service/findById/{id}")
    @ResponseBody
    public ResponseResult<Banner> findById(@PathVariable("id") Integer id) {
        Banner banner = this.bannerService.queryObjById(id);
        return ResponseResult.success(banner);
    }


}