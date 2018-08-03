package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianOperationMapper;
import com.airmcl.air.beautician.entity.BeauticianOperation;
import com.airmcl.air.beautician.entity.BeauticianOperationExample;
import com.airmcl.air.beautician.service.BeauticianOperationService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeauticianOperationService")
public class BeauticianOperationServiceImpl implements BeauticianOperationService {
    @Resource
    protected BeauticianOperationMapper beauticianOperationMapper;

    @CacheEvict(value={"beauticianOperation"}, allEntries=true)
    @Override
    public void addObj(BeauticianOperation t) {
        this.beauticianOperationMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauticianOperation"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beauticianOperationMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauticianOperation"}, allEntries=true)
    @Override
    public void modifyObj(BeauticianOperation t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beauticianOperationMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauticianOperation", keyGenerator="redisKeyGenerator")
    @Override
    public BeauticianOperation queryObjById(Integer id) {
        return this.beauticianOperationMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauticianOperation", key="'BeauticianOperationService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeauticianOperation> queryAllObjByExample(BeauticianOperationExample example) {
        return this.beauticianOperationMapper.selectByExample(example);
    }

    @Cacheable(value="beauticianOperation", key="'BeauticianOperationService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeauticianOperation> queryObjByPage(BeauticianOperationExample example) {
        PageView<BeauticianOperation> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianOperationMapper.selectByExampleByPage(example));
        return pageView;
    }
}