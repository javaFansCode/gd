package com.airmcl.air.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.airmcl.air.app.dao.PhotoMapper;
import com.airmcl.air.app.entity.Photo;
import com.airmcl.air.app.entity.PhotoExample;
import com.airmcl.air.app.service.PhotoService;
import com.els.base.core.entity.PageView;

@Service("defaultPhotoService")
public class PhotoServiceImpl implements PhotoService {
    @Resource
    protected PhotoMapper photoMapper;

    @CacheEvict(value={"photo"}, allEntries=true)
    @Override
    public void addObj(Photo t) {
        this.photoMapper.insertSelective(t);
    }

    @CacheEvict(value={"photo"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.photoMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"photo"}, allEntries=true)
    @Override
    public void modifyObj(Photo t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.photoMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="photo", keyGenerator="redisKeyGenerator")
    @Override
    public Photo queryObjById(Integer id) {
        return this.photoMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="photo", key="'PhotoService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Photo> queryAllObjByExample(PhotoExample example) {
        return this.photoMapper.selectByExample(example);
    }

    @Cacheable(value="photo", key="'PhotoService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Photo> queryObjByPage(PhotoExample example) {
        PageView<Photo> pageView = example.getPageView();
        pageView.setQueryResult(this.photoMapper.selectByExampleByPage(example));
        return pageView;
    }
}