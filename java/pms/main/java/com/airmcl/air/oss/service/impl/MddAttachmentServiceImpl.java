package com.airmcl.air.oss.service.impl;

import com.airmcl.air.oss.dao.MddAttachmentMapper;
import com.airmcl.air.oss.entity.MddAttachment;
import com.airmcl.air.oss.entity.MddAttachmentExample;
import com.airmcl.air.oss.service.MddAttachmentService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultMddAttachmentService")
public class MddAttachmentServiceImpl implements MddAttachmentService {
    @Resource
    protected MddAttachmentMapper mddAttachmentMapper;

    @CacheEvict(value={"mddAttachment"}, allEntries=true)
    @Override
    public void addObj(MddAttachment t) {
        this.mddAttachmentMapper.insertSelective(t);
    }

    @CacheEvict(value={"mddAttachment"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.mddAttachmentMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"mddAttachment"}, allEntries=true)
    @Override
    public void modifyObj(MddAttachment t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.mddAttachmentMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="mddAttachment", keyGenerator="redisKeyGenerator")
    @Override
    public MddAttachment queryObjById(Integer id) {
        return this.mddAttachmentMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="mddAttachment", key="'MddAttachmentService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<MddAttachment> queryAllObjByExample(MddAttachmentExample example) {
        return this.mddAttachmentMapper.selectByExample(example);
    }

    @Cacheable(value="mddAttachment", key="'MddAttachmentService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<MddAttachment> queryObjByPage(MddAttachmentExample example) {
        PageView<MddAttachment> pageView = example.getPageView();
        pageView.setQueryResult(this.mddAttachmentMapper.selectByExampleByPage(example));
        return pageView;
    }
}