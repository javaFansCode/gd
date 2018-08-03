package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianExperienceMapper;
import com.airmcl.air.beautician.entity.BeauticianExperience;
import com.airmcl.air.beautician.entity.BeauticianExperienceExample;
import com.airmcl.air.beautician.service.BeauticianExperienceService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeauticianExperienceService")
public class BeauticianExperienceServiceImpl implements BeauticianExperienceService {
    @Resource
    protected BeauticianExperienceMapper beauticianExperienceMapper;

    @CacheEvict(value={"beauticianExperience"}, allEntries=true)
    @Override
    public void addObj(BeauticianExperience t) {
        this.beauticianExperienceMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauticianExperience"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beauticianExperienceMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauticianExperience"}, allEntries=true)
    @Override
    public void modifyObj(BeauticianExperience t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beauticianExperienceMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauticianExperience", keyGenerator="redisKeyGenerator")
    @Override
    public BeauticianExperience queryObjById(Integer id) {
        return this.beauticianExperienceMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauticianExperience", key="'BeauticianExperienceService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeauticianExperience> queryAllObjByExample(BeauticianExperienceExample example) {
        return this.beauticianExperienceMapper.selectByExample(example);
    }

    @Cacheable(value="beauticianExperience", key="'BeauticianExperienceService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeauticianExperience> queryObjByPage(BeauticianExperienceExample example) {
        PageView<BeauticianExperience> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianExperienceMapper.selectByExampleByPage(example));
        return pageView;
    }


    /**
     * 批量修改状态
     * @param ids
     * @param state
     */
    @Override
    public void updateState(int[] ids, Integer state) {

        this.beauticianExperienceMapper.updateState(ids,state);

    }
}