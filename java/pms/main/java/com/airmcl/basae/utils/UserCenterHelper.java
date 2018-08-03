package com.airmcl.basae.utils;

import com.airmcl.uc.base.model.AppsToken;
import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.common.json.ParseException;
import com.els.base.utils.http.HttpGetClient;
import org.apache.commons.httpclient.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xuhui
 * @Date 2018/6/14 下午2:32
 */
public class UserCenterHelper {

    protected static Logger logger = LoggerFactory.getLogger(UserCenterHelper.class);

    /**
     * 根据手机号获取用户信息
     * @param mobile
     * @param appsToken
     * @return
     */
    public static JSONObject getUserInfoByMobile(String mobile, AppsToken appsToken){

        String url = BaseConst.UC_HOST + BaseConst.UC_MEMBER_QUERY_URL;

        if (appsToken == null){
            return null;
        }

        NameValuePair[] params = {
            new NameValuePair("token", appsToken.getToken()),
            new NameValuePair("timestamp", appsToken.getTimestamp().toString()),
            new NameValuePair("appId", appsToken.getAppId()),
            new NameValuePair("selKey", "mobile"),
            new NameValuePair("selValue", mobile)
        };

        try {
            String response = HttpGetClient.send(url, params);
            logger.debug("用户中心返回数据："+response);
            return (JSONObject) JSON.parse(response);
        } catch (ParseException e){
            logger.error("请求用户中心获取用户信息数据转换异常：", e);
            return null;
        } catch (IOException e) {
            logger.error("请求用户中心获取用户信息接口异常：", e);
            return null;
        }
    }

    /**
     * 根据用户中心id获取用户信息
     * @param ucopenid
     * @param appsToken
     * @return
     */
    public static JSONObject getUserInfoByUcOpenId(String ucopenid, AppsToken appsToken) {

        String url = BaseConst.UC_HOST + BaseConst.UC_MEMBER_QUERY_URL;

        if (appsToken == null){
            return null;
        }

        NameValuePair[] params = {
            new NameValuePair("token", appsToken.getToken()),
            new NameValuePair("timestamp", appsToken.getTimestamp().toString()),
            new NameValuePair("appId", appsToken.getAppId()),
            new NameValuePair("selKey", "openid"),
            new NameValuePair("selValue", ucopenid)
        };

        try {
            String response = HttpGetClient.send(url, params);
            logger.debug("用户中心返回数据："+response);
            return (JSONObject) JSON.parse(response);
        } catch (ParseException e){
            logger.error("请求用户中心获取用户信息数据转换异常：", e);
            return null;
        } catch (IOException e) {
            logger.error("请求用户中心获取用户信息接口异常：", e);
            return null;
        }
    }

    /**
     * 根据手机号批量获取用户信息
     * @param mobiles
     * @param appsToken
     * @return
     */
    public static JSONObject getUserInfoListByMobile(List<String> mobiles, AppsToken appsToken) {

        String url = BaseConst.UC_HOST + BaseConst.UC_MEMBER_QUERY_URL;

        if (appsToken == null){
            return null;
        }

        List<NameValuePair> list = new ArrayList<>();
        list.add(new NameValuePair("token", appsToken.getToken()));
        list.add(new NameValuePair("timestamp", appsToken.getTimestamp().toString()));
        list.add(new NameValuePair("appId", appsToken.getAppId()));
        list.add(new NameValuePair("selKey", "mobile"));

        for (String mobile: mobiles) {
            list.add(new NameValuePair("selValue", mobile));
        }

        NameValuePair[] params = list.toArray(new NameValuePair[0]);

        try {
            String response = HttpGetClient.send(url, params);
            logger.debug("用户中心返回数据："+response);
            return (JSONObject) JSON.parse(response);
        } catch (ParseException e){
            logger.error("请求用户中心获取用户信息数据转换异常：", e);
            return null;
        } catch (IOException e) {
            logger.error("请求用户中心获取用户信息接口异常：", e);
            return null;
        }
    }

    /**
     * 根据用户中心id批量获取用户信息
     * @param ucopenids
     * @param appsToken
     * @return
     */
    public static JSONObject getUserInfoListByUcOpenId(List<String> ucopenids, AppsToken appsToken) {

        String url = BaseConst.UC_HOST + BaseConst.UC_MEMBER_QUERY_URL;

        if (appsToken == null){
            return null;
        }

        List<NameValuePair> list = new ArrayList<>();
        list.add(new NameValuePair("token", appsToken.getToken()));
        list.add(new NameValuePair("timestamp", appsToken.getTimestamp().toString()));
        list.add(new NameValuePair("appId", appsToken.getAppId()));
        list.add(new NameValuePair("selKey", "openid"));

        for (String ucopenid: ucopenids) {
            list.add(new NameValuePair("selValue", ucopenid));
        }

        NameValuePair[] params = list.toArray(new NameValuePair[0]);

        try {
            String response = HttpGetClient.send(url, params);
            logger.debug("用户中心返回数据："+response);
            return (JSONObject) JSON.parse(response);
        } catch (ParseException e){
            logger.error("请求用户中心获取用户信息数据转换异常：", e);
            return null;
        } catch (IOException e) {
            logger.error("请求用户中心获取用户信息接口异常：", e);
            return null;
        }
    }

}
