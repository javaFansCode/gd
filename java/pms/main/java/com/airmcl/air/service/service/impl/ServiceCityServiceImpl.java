package com.airmcl.air.service.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.service.dao.ServiceCityMapper;
import com.airmcl.air.service.dao.ext.ServiceCityExtMapper;
import com.airmcl.air.service.entity.ServiceCity;
import com.airmcl.air.service.entity.ServiceCityExample;
import com.airmcl.air.service.service.ServiceCityService;
import com.els.base.core.entity.PageView;

@Service("defaultServiceCityService")
public class ServiceCityServiceImpl implements ServiceCityService {
    @Resource
    protected ServiceCityMapper serviceCityMapper;
    @Resource
    protected ServiceCityExtMapper serviceCityExtMapper;

    @CacheEvict(value={"serviceCity"}, allEntries=true)
    @Override
    public void addObj(ServiceCity t) {
        this.serviceCityMapper.insertSelective(t);
    }

    @CacheEvict(value={"serviceCity"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.serviceCityMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"serviceCity"}, allEntries=true)
    @Override
    public void modifyObj(ServiceCity t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.serviceCityMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="serviceCity", keyGenerator="redisKeyGenerator")
    @Override
    public ServiceCity queryObjById(Integer id) {
        return this.serviceCityMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="serviceCity", key="'ServiceCityService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ServiceCity> queryAllObjByExample(ServiceCityExample example) {
        return this.serviceCityMapper.selectByExample(example);
    }

    @Cacheable(value="serviceCity", key="'ServiceCityService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ServiceCity> queryObjByPage(ServiceCityExample example) {
        PageView<ServiceCity> pageView = example.getPageView();
        pageView.setQueryResult(this.serviceCityMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public List<ServiceCity> queryOpenReserveCity() {
		return serviceCityExtMapper.selectOpenCity();
	}

	@Override
	public List<ServiceCity> queryOpenReserveCityByServiceId(Integer serviceId) {
		return serviceCityExtMapper.selectOpenCityByServiceId(serviceId);
	}

	@Transactional
	@Override
	public void addAllServiceCity(List<ServiceCity> serviceCities) throws RuntimeException {
//		for (ServiceCity serviceCity : serviceCities) {
//			serviceCity.setState((byte)1);
//		}
		serviceCityMapper.insertBatch(serviceCities);
	}
}