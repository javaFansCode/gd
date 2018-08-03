package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianDataMapper;
import com.airmcl.air.beautician.entity.BeauticianData;
import com.airmcl.air.beautician.entity.BeauticianDataExample;
import com.airmcl.air.beautician.service.BeauticianDataService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeauticianDataService")
public class BeauticianDataServiceImpl implements BeauticianDataService {
    @Resource
    protected BeauticianDataMapper beauticianDataMapper;

    @CacheEvict(value={"beauticianData"}, allEntries=true)
    @Override
    public void addObj(BeauticianData t) {
        this.beauticianDataMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauticianData"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beauticianDataMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauticianData"}, allEntries=true)
    @Override
    public void modifyObj(BeauticianData t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beauticianDataMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauticianData", keyGenerator="redisKeyGenerator")
    @Override
    public BeauticianData queryObjById(Integer id) {
        return this.beauticianDataMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauticianData", key="'BeauticianDataService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeauticianData> queryAllObjByExample(BeauticianDataExample example) {
        return this.beauticianDataMapper.selectByExample(example);
    }

    @Cacheable(value="beauticianData", key="'BeauticianDataService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeauticianData> queryObjByPage(BeauticianDataExample example) {
        PageView<BeauticianData> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianDataMapper.selectByExampleByPage(example));
        return pageView;
    }
}