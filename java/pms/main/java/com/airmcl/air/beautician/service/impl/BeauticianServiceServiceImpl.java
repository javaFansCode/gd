package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianServiceMapper;
import com.airmcl.air.beautician.entity.BeauticianService;
import com.airmcl.air.beautician.entity.BeauticianServiceExample;
import com.airmcl.air.beautician.service.BeauticianServiceService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeauticianServiceService")
public class BeauticianServiceServiceImpl implements BeauticianServiceService {
    @Resource
    protected BeauticianServiceMapper beauticianServiceMapper;

    @CacheEvict(value={"beauticianService"}, allEntries=true)
    @Override
    public void addObj(BeauticianService t) {
        this.beauticianServiceMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauticianService"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beauticianServiceMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauticianService"}, allEntries=true)
    @Override
    public void modifyObj(BeauticianService t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beauticianServiceMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauticianService", keyGenerator="redisKeyGenerator")
    @Override
    public BeauticianService queryObjById(Integer id) {
        return this.beauticianServiceMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauticianService", key="'BeauticianServiceService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeauticianService> queryAllObjByExample(BeauticianServiceExample example) {
        return this.beauticianServiceMapper.selectByExample(example);
    }

    @Cacheable(value="beauticianService", key="'BeauticianServiceService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeauticianService> queryObjByPage(BeauticianServiceExample example) {
        PageView<BeauticianService> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianServiceMapper.selectByExampleByPage(example));
        return pageView;
    }
    /**
     * 批量修改状态
     * @param ids
     * @param state
     */
    @Override
    public void updateState(int[] ids, Integer state) {

        this.beauticianServiceMapper.updateState(ids,state);

    }
}