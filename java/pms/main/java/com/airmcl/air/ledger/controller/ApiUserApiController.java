package com.airmcl.air.ledger.controller;

import com.airmcl.air.ledger.enter.CenterChairmanParaVO;
import com.airmcl.air.ledger.service.ApiUserService;
import com.alibaba.fastjson.JSONObject;
import com.els.base.core.entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @program: air-pms
 * @description:
 * @author: Mr.Chen
 * @create: 2018-06-14 11:17
 **/
@Controller
@RequestMapping("apiUserApi")
public class ApiUserApiController {

    @Resource
    protected ApiUserService apiUserService;

    @ApiIgnore
    @ApiOperation(httpMethod = "POST",consumes = "application/json", value = "获取指定区域运营中心主席")
    @RequestMapping("api/getCenterChairman")
    @ResponseBody
    public ResponseResult<JSONObject> getCenterChairman(@RequestBody CenterChairmanParaVO vo) {
        return ResponseResult.success(this.apiUserService.getCenterChairman(vo));
    }

    @ApiIgnore
    @ApiOperation(httpMethod = "GET", value = "根据官总的手机号获取官总信息、直推官总信息和间推官总信息")
    @RequestMapping(method = RequestMethod.GET , value = "api/getAgentRelation" )
    @ResponseBody
    public ResponseResult<JSONObject> getAgentRelation(@RequestParam(required=true) String  mobile) {
        return ResponseResult.success(this.apiUserService.getAgentRelation(mobile));
    }
}
