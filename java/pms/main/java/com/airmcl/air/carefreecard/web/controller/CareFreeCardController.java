package com.airmcl.air.carefreecard.web.controller;

import com.airmcl.air.carefreecard.entity.CareFreeCard;
import com.airmcl.air.carefreecard.entity.CareFreeCardExample;
import com.airmcl.air.carefreecard.service.CareFreeCardService;
import com.airmcl.basae.utils.BaseConst;
import com.airmcl.basae.utils.DateUtil;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value="分发无忧卡")
@Controller
@RequestMapping("careFreeCard")
public class CareFreeCardController {
    @Resource
    protected CareFreeCardService careFreeCardService;

    @ApiOperation(httpMethod="POST", value="创建分发无忧卡")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody CareFreeCard careFreeCard) {
        if(careFreeCard.getNum() <= 0){
            throw new CommonException("无忧卡分发数量不能为空！");
        }
        for (int i = 0; i < careFreeCard.getNum(); i++) {
            UUID uuid = UUID.randomUUID();
            String id = uuid.toString().replace("-","");
            careFreeCard.setId(id);
            String secret=String.valueOf(((int)((Math.random()*9+1)*100000)));
            careFreeCard.setSecret_key(secret);
            careFreeCard.setAction_flag(BaseConst.BEAUTICIAN_STATE_DELETE);
            StringBuilder sb = new StringBuilder();
            sb.append("W");
            sb.append(DateUtil.getDays());
            sb.append(String.valueOf(((int)((Math.random()*9+1)*1000000))));
            careFreeCard.setCard_number(sb.toString());
            careFreeCard.setIs_delete(BaseConst.BEAUTICIAN_STATE_DELETE);
            this.careFreeCardService.addObj(careFreeCard);
        }
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody CareFreeCard careFreeCard) {
        if (StringUtils.isEmpty(careFreeCard.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.careFreeCardService.modifyObj(careFreeCard);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.careFreeCardService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询分发无忧卡")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 CareFreeCard", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<CareFreeCard>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        CareFreeCardExample example = new CareFreeCardExample();
        example.setPageView(new PageView<CareFreeCard>(pageNo, pageSize));
        example.setOrderByClause("create_time desc");
        if (wapper != null) {
            CareFreeCardExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }

        PageView<CareFreeCard> pageData = this.careFreeCardService.queryObjByPage(example);
        for (int i = 0; i <pageData.getQueryResult().size() ; i++) {
            CareFreeCard careFreeCard = pageData.getQueryResult().get(i);
            long updateTime = careFreeCard.getUpdate_time().getTime()/1000;
            careFreeCard.setUpdateTime(String.valueOf(updateTime));
            long createTime = careFreeCard.getCreate_time().getTime()/1000;
            careFreeCard.setCreateTime(String.valueOf(createTime));
            if(null != careFreeCard.getActivation_time()){
                long activationTime = careFreeCard.getActivation_time().getTime()/1000;
                careFreeCard.setActivationTime(String.valueOf(activationTime));
            }
        }
        return ResponseResult.success(pageData);
    }
}