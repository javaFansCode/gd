package com.airmcl.air.scheduler.service.impl;

import com.airmcl.air.scheduler.service.JobTestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author xuhui
 * @Date 2018/7/13 下午2:31
 */
@Service("defaultJobTestService")
public class JobTestServiceImpl implements JobTestService {

    @Value("#{sysConfig['db.url']}")
    public String isJobEnable;

    @Override
    public void jobOne() {
        System.out.println(this.isJobEnable);
        System.out.println("18080定时任务执行一次");
    }
}
