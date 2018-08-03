package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.JobTitleMapper;
import com.airmcl.air.beautician.entity.JobTitle;
import com.airmcl.air.beautician.entity.JobTitleExample;
import com.airmcl.air.beautician.service.JobTitleService;
import com.els.base.core.entity.PageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.els.base.core.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultJobTitleService")
public class JobTitleServiceImpl implements JobTitleService {
    @Resource
    protected JobTitleMapper jobTitleMapper;

    @CacheEvict(value={"jobTitle"}, allEntries=true)
    @Override
    public void addObj(JobTitle t) {

        Integer createtime =Double.valueOf((new Date().getTime()/1000)).intValue();
        t.setCreatetime(createtime);
        this.jobTitleMapper.insertSelective(t);
    }

    @CacheEvict(value={"jobTitle"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.jobTitleMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"jobTitle"}, allEntries=true)
    @Override
    public void modifyObj(JobTitle t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.jobTitleMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="jobTitle", keyGenerator="redisKeyGenerator")
    @Override
    public JobTitle queryObjById(Integer id) {
        return this.jobTitleMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="jobTitle", key="'JobTitleService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<JobTitle> queryAllObjByExample(JobTitleExample example) {
        return this.jobTitleMapper.selectByExample(example);
    }

    @Cacheable(value="jobTitle", key="'JobTitleService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<JobTitle> queryObjByPage(JobTitleExample example) {
        PageView<JobTitle> pageView = example.getPageView();
        pageView.setQueryResult(this.jobTitleMapper.selectByExampleByPage(example));
        return pageView;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int deleteByIds(int[] ids) {

      List<Integer> list=new ArrayList();
       for (int i:ids){
         list.add(i);
       }
      return jobTitleMapper.deleteByIds(list);
    }

    /**
     * 批量修改状态
     * @param ids
     * @param state
     */
    @Override
    public void updateState(int[] ids, Integer state) {

        this.jobTitleMapper.updateState(ids,state);

    }
}