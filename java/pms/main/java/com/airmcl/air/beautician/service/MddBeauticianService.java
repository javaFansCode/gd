package com.airmcl.air.beautician.service;

import com.airmcl.air.beautician.enter.BeauticianServiceEnterParams;
import com.airmcl.air.beautician.out.BeauticianRelationsServiceOut;

import java.util.List;

/**
 * @program: air-pms
 * @description: 美容师后台特定接口
 * @author: Mr.Chen
 * @create: 2018-06-26 17:13
 **/
public interface MddBeauticianService {

    /**
     * 加载美容师关联列表信息
     * 1、获取门店关联的项目信息
     * 2、加载美容师和项目关联信息
     * 3、数据做集合输出
     * @param enterParams
     * @return
     */
    List<BeauticianRelationsServiceOut> getBeauticianAssociationProject(BeauticianServiceEnterParams enterParams);

    /**
     * 添加美容师和项目关系
     * 1、清理原先美容师关联关系
     * 2、根据id添加美容师关联
     * @param enterParams
     */
    void inserBeauticianAssociationProject(BeauticianServiceEnterParams enterParams);
}
