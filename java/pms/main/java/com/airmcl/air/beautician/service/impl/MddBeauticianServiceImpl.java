package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianRelationsMapper;
import com.airmcl.air.beautician.enter.BeauticianServiceEnterParams;
import com.airmcl.air.beautician.entity.BeauticianRelations;
import com.airmcl.air.beautician.entity.BeauticianRelationsExample;
import com.airmcl.air.beautician.out.BeauticianRelationsServiceOut;
import com.airmcl.air.beautician.service.MddBeauticianService;
import com.airmcl.air.beauty.dao.BeautyRelationsMapper;
import com.airmcl.air.beauty.entity.BeautyRelations;
import com.airmcl.air.beauty.entity.BeautyRelationsExample;
import com.airmcl.air.goods.dao.GoodsMapper;
import com.airmcl.air.goods.entity.Goods;
import com.airmcl.air.service.dao.ServiceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: air-pms
 * @description: 美容师后台特定接口
 * @author: Mr.Chen
 * @create: 2018-06-26 17:13
 **/

@Service("defaultMddBeauticianService")
public class MddBeauticianServiceImpl implements MddBeauticianService {

    @Resource
    protected BeauticianRelationsMapper beauticianRelationsMapper;
    @Resource
    protected BeautyRelationsMapper beautyRelationsMapper;
    @Resource
    protected GoodsMapper goodsMapper;
    @Resource
    protected ServiceMapper serviceMapper;



    /**
     * 1、获取门店关联的项目信息
     * 2、加载美容师和项目关联信息
     * 3、数据做集合输出
     * @param enterParams
     * @return
     */
    @Override
    public List<BeauticianRelationsServiceOut> getBeauticianAssociationProject(BeauticianServiceEnterParams enterParams) {
        List<BeauticianRelationsServiceOut> result = new ArrayList<>();
        Map<Integer,Object> map = new HashMap<>();
        // 1、获取门店关联项目信息
        BeautyRelationsExample beautyRelationsExample = new BeautyRelationsExample();
        beautyRelationsExample.createCriteria().andBeautyIdEqualTo(enterParams.getBeautyId()).andStateEqualTo((byte)1).andTypeEqualTo((byte)1);
        List<BeautyRelations> beautyRelations = this.beautyRelationsMapper.selectByExample(beautyRelationsExample);
        //  1.1、若门店没有关联项目信息。则直接返回
        if(beautyRelations == null || beautyRelations.size() < 1){
            return result;
        }

        // 2、加载美容师和项目关系信息
        BeauticianRelationsExample bExample = new BeauticianRelationsExample();
        bExample.createCriteria().andBeautyIdEqualTo(enterParams.getBeautyId()).andBtIdEqualTo(enterParams.getBeauticianId())
                .andStateEqualTo((byte)1);
        List<BeauticianRelations> beauticianRelations = this.beauticianRelationsMapper.selectByExample(bExample);

        if(!(beauticianRelations == null || beauticianRelations.size() < 1)){
            for (int i = 0; i < beauticianRelations.size(); i++) {
                map.put(beauticianRelations.get(i).getServiceId(),beauticianRelations.get(i));
            }
        }

        for (int i = 0; i < beautyRelations.size(); i++) {
            BeauticianRelationsServiceOut resultOut = new BeauticianRelationsServiceOut();
            resultOut.setBeautyId(beautyRelations.get(i).getBeautyId());
            if(1 == beautyRelations.get(i).getType()){
                com.airmcl.air.service.entity.Service service = this.serviceMapper.selectByPrimaryKey(beautyRelations.get(i).getRelationId());
                resultOut.setId(service.getId());
                resultOut.setServiceCover(service.getServiceCover());
                resultOut.setServiceName(service.getServiceName());
                if(map.containsKey(beautyRelations.get(i).getRelationId())){
                    resultOut.setState(1);
                }else{
                    resultOut.setState(0);
                }
            }else if(2 == beautyRelations.get(i).getType()){
                Goods goods = this.goodsMapper.selectByPrimaryKey(beautyRelations.get(i).getRelationId());
                resultOut.setId(goods.getId());
                resultOut.setServiceCover(goods.getGoodsCover());
                resultOut.setServiceName(goods.getGoodsName());
                if(map.containsKey(beautyRelations.get(i).getRelationId())){
                    resultOut.setState(1);
                }else{
                    resultOut.setState(0);
                }
            }else{
                
            }
            result.add(resultOut);
        }

        return result;
    }

    /**
     * 添加美容师和项目关系
     * 1、清理原先美容师关联关系
     * 2、根据id添加美容师关联
     * @param enterParams
     */
    @Override
    public void inserBeauticianAssociationProject(BeauticianServiceEnterParams enterParams) {
        BeauticianRelationsExample bExample = new BeauticianRelationsExample();
        bExample.createCriteria().andBeautyIdEqualTo(enterParams.getBeautyId()).andBtIdEqualTo(enterParams.getBeauticianId())
                .andStateEqualTo((byte)1);
        // 1、清理原先美容师关系
        this.beauticianRelationsMapper.deleteByExample(bExample);

        // 1.1、若用户取消所有的关系。则返回即可
        if(enterParams.getServiceId() == null || enterParams.getServiceId().size() < 1){
            return ;
        }
        List<BeauticianRelations> result = new ArrayList<>();
        // TODO:这里后面在优化成批量新增。现在id自增批量插入有问题。
        for (int i = 0; i < enterParams.getServiceId().size(); i++) {
            BeauticianRelations beauticianRelations = new BeauticianRelations();
            beauticianRelations.setBtId(enterParams.getBeauticianId());
            beauticianRelations.setBeautyId(enterParams.getBeautyId());
            beauticianRelations.setServiceId(enterParams.getServiceId().get(i));
            // 操作者类型。后台
            beauticianRelations.setOperateType((byte)1);
            // 操作者id默认为1
            beauticianRelations.setOperateId(1);
            beauticianRelations.setCreatetime((System.currentTimeMillis()/1000)+"");
            // 删除状态默认为1
            beauticianRelations.setState((byte)1);
            result.add(beauticianRelations);
            this.beauticianRelationsMapper.insertSelective(beauticianRelations);
        }
    }
}
