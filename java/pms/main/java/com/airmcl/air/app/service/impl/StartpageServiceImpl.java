package com.airmcl.air.app.service.impl;

import com.airmcl.air.app.dao.StartpageMapper;
import com.airmcl.air.app.entity.Startpage;
import com.airmcl.air.app.entity.StartpageExample;
import com.airmcl.air.app.service.StartpageService;
import com.els.base.core.entity.PageView;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultStartpageService")
public class StartpageServiceImpl implements StartpageService {
    @Resource
    protected StartpageMapper startpageMapper;

    @CacheEvict(value={"startpage"}, allEntries=true)
    @Override
    public void addObj(Startpage t) {
        this.startpageMapper.insertSelective(t);
    }

    @CacheEvict(value={"startpage"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.startpageMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"startpage"}, allEntries=true)
    @Override
    public void modifyObj(Startpage t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.startpageMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="startpage", keyGenerator="redisKeyGenerator")
    @Override
    public Startpage queryObjById(Integer id) {
        return this.startpageMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="startpage", key="'StartpageService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Startpage> queryAllObjByExample(StartpageExample example) {
        return this.startpageMapper.selectByExample(example);
    }

    @Cacheable(value="startpage", key="'StartpageService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Startpage> queryObjByPage(StartpageExample example) {
        PageView<Startpage> pageView = example.getPageView();
        pageView.setQueryResult(this.startpageMapper.selectByExampleByPage(example));
        return pageView;
    }


    /**
     * 批量删除
     * @param ids
     */
    @Override
    public int updateStateByIds(int[] ids) {

        return startpageMapper.updateStateByIds(ids);
    }
}