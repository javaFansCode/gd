package com.airmcl.air.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.service.dao.ServiceFormMapper;
import com.airmcl.air.service.dao.ServiceHomeBuyMapper;
import com.airmcl.air.service.dao.ServiceMapper;
import com.airmcl.air.service.dao.ServicesHomeBuyRecordMapper;
import com.airmcl.air.service.dao.ext.ServiceHomeBuyExtMapper;
import com.airmcl.air.service.entity.ServiceForm;
import com.airmcl.air.service.entity.ServiceFormExample;
import com.airmcl.air.service.entity.ServiceHomeBuy;
import com.airmcl.air.service.entity.ServiceHomeBuyExample;
import com.airmcl.air.service.entity.ServicesHomeBuyRecord;
import com.airmcl.air.service.entity.ServicesHomeBuyRecordExample;
import com.airmcl.air.service.service.ServiceHomeBuyService;
import com.airmcl.basae.utils.DateUtil;
import com.els.base.core.entity.PageView;

@Service("defaultServiceHomeBuyService")
public class ServiceHomeBuyServiceImpl implements ServiceHomeBuyService {
    @Resource
    protected ServiceHomeBuyMapper serviceHomeBuyMapper;
    @Resource
    protected ServiceHomeBuyExtMapper serviceHomeBuyExtMapper;
    @Resource
    protected ServicesHomeBuyRecordMapper servicesHomeBuyRecordMapper;
    @Resource
    protected ServiceFormMapper serviceFormMapper;
    @Resource
    protected ServiceMapper serviceMapper;
    @Transactional
    @CacheEvict(value={"serviceHomeBuy"}, allEntries=true)
    @Override
    public void addObj(ServiceHomeBuy t)  {
    	Long time =DateUtil.getTimeLong();
    	t.setCreatetime(time.intValue());
        this.serviceHomeBuyMapper.insertSelective(t);
        Integer serviceId = t.getServiceId();
        int numbersTotal = t.getNums();
        ServiceFormExample example = new ServiceFormExample();
        example.createCriteria().andServiceIdEqualTo(serviceId);
        int dbNum = serviceFormMapper.countByExample(example);
        int addNum = numbersTotal-dbNum;
        
        if(addNum>0){
        	
        	List<ServiceForm> list = new ArrayList<ServiceForm>(addNum);
        	for (int i = 0; i < addNum; i++) {
        		ServiceForm sf = new ServiceForm();
        		sf.setCreatetime(time.intValue());
        		sf.setServiceId(serviceId);
        		list.add(sf);
			}
			serviceFormMapper.insertBatch(list);
        }else if(addNum<0){
        	int limit = Math.abs(addNum);
        	ServiceFormExample example2 = new ServiceFormExample();
        	example2.createCriteria().andServiceIdEqualTo(serviceId);
        	List<ServiceForm> serviceFormList = serviceFormMapper.selectByExample(example2);
        	for(int i =0 ;i<limit;i++){
        		Integer id = serviceFormList.get(i).getId();
        		serviceFormMapper.deleteByPrimaryKey(id);
        	}
        }
        ServicesHomeBuyRecord record = new ServicesHomeBuyRecord();
        record.setAdminId(t.getAdminId());
        record.setCreatetime(t.getCreatetime());
        record.setIsPurchase(t.getIsPurchase());
        record.setPurchaseTotal(t.getPurchaseTotal());
        record.setServiceId(t.getServiceId());
        record.setType("add");
        record.setTotal(t.getTotal());
		servicesHomeBuyRecordMapper.insertSelective(record );
    }

    @CacheEvict(value={"serviceHomeBuy"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.serviceHomeBuyMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"serviceHomeBuy"}, allEntries=true)
    @Override
    @Transactional
    public void modifyObj(ServiceHomeBuy t)throws RuntimeException {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 不能为空");
        }
        Integer serviceId = t.getServiceId();
        int numbersTotal = t.getNums();
        ServiceFormExample example = new ServiceFormExample();
        example.createCriteria().andServiceIdEqualTo(serviceId);
        int dbNum = serviceFormMapper.countByExample(example);
        int addNum = numbersTotal-dbNum;
        
        if(addNum>0){
        	Long time =DateUtil.getTimeLong();
        	List<ServiceForm> list = new ArrayList<ServiceForm>(addNum);
        	for (int i = 0; i < addNum; i++) {
        		ServiceForm sf = new ServiceForm();
        		sf.setCreatetime(time.intValue());
        		sf.setServiceId(serviceId);
        		list.add(sf);
			}
			serviceFormMapper.insertBatch(list);
        }else if(addNum<0){
        	int limit = Math.abs(addNum);
        	ServiceFormExample example2 = new ServiceFormExample();
        	example2.createCriteria().andServiceIdEqualTo(serviceId);
        	List<ServiceForm> serviceFormList = serviceFormMapper.selectByExample(example2);
        	for(int i =0 ;i<limit;i++){
        		Integer id = serviceFormList.get(i).getId();
        		serviceFormMapper.deleteByPrimaryKey(id);
        	}
        }
        this.serviceHomeBuyMapper.updateByPrimaryKeySelective(t);
		com.airmcl.air.service.entity.Service serviceRecord = new com.airmcl.air.service.entity.Service();
		serviceRecord.setId(serviceId);
		serviceRecord.setIsPurchase(t.getIsPurchase());
		serviceMapper.updateByPrimaryKeySelective(serviceRecord);
        ServicesHomeBuyRecord record = new ServicesHomeBuyRecord();
        record.setAdminId(t.getAdminId());
        record.setCreatetime(t.getCreatetime());
        record.setIsPurchase(t.getIsPurchase());
        record.setPurchaseTotal(t.getPurchaseTotal());
        record.setServiceId(t.getServiceId());
        record.setType("edit");
        record.setTotal(t.getTotal());
		servicesHomeBuyRecordMapper.insertSelective(record );
    }

    @Cacheable(value="serviceHomeBuy", keyGenerator="redisKeyGenerator")
    @Override
    public ServiceHomeBuy queryObjById(Integer id) {
        return this.serviceHomeBuyMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="serviceHomeBuy", key="'ServiceHomeBuyService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ServiceHomeBuy> queryAllObjByExample(ServiceHomeBuyExample example) {
        return this.serviceHomeBuyMapper.selectByExample(example);
    }

    @Cacheable(value="serviceHomeBuy", key="'ServiceHomeBuyService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ServiceHomeBuy> queryObjByPage(ServiceHomeBuyExample example) {
        PageView<ServiceHomeBuy> pageView = example.getPageView();
        pageView.setQueryResult(this.serviceHomeBuyMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public ServiceHomeBuy queryObjByserviceId(Integer serviceId) {
		return serviceHomeBuyExtMapper.selectServiceHomeByServiceId(serviceId);
	}

	@Transactional
	@Override
	public int modifyServiceHomeBuyAndServiceHomeBuyRecord(ServiceHomeBuy serviceHomeBuy) throws RuntimeException {
		Long createtime = System.currentTimeMillis()/1000;
		ServicesHomeBuyRecord servicesHomeBuyRecord = new ServicesHomeBuyRecord();
		if(serviceHomeBuy.getId()==null){
			serviceHomeBuy.setCreatetime(createtime.intValue());
			serviceHomeBuyMapper.insertSelective(serviceHomeBuy);
			servicesHomeBuyRecord.setType("add");
		}else{
			serviceHomeBuyMapper.updateByPrimaryKeySelective(serviceHomeBuy);
			servicesHomeBuyRecord.setType("edit");
		}
		Byte purchase =  serviceHomeBuy.getIsPurchase();
		if(purchase==2){
			Integer total = serviceHomeBuy.getTotal();
			Integer serviceId = serviceHomeBuy.getServiceId();
 			ServiceFormExample serviceFormExample = new ServiceFormExample();
 			serviceFormExample.createCriteria().andServiceIdEqualTo(serviceId);
 			int num=serviceFormMapper.countByExample(serviceFormExample);
 			int addNum = total-num;
 			if(addNum>0){
				 List<ServiceForm> serviceFormArray = new ArrayList<ServiceForm>();
				 for(int i=0;i<addNum;i++){
					 ServiceForm serviceForm = new ServiceForm();
					 serviceForm.setServiceId(serviceId);
					 serviceForm.setCreatetime(createtime.intValue());
					 serviceFormArray.add(serviceForm);
				 }
				 serviceFormMapper.insertBatch(serviceFormArray);
			}else if(addNum<0){
				int limit = Math.abs(addNum);
				ServiceFormExample example = new ServiceFormExample();
				example.createCriteria().andServiceIdEqualTo(serviceId);
				List<ServiceForm> serviceFormFormList = serviceFormMapper.selectByExample(example);
				for(int a = 0;a<limit;a++){
					 Integer id=serviceFormFormList.get(a).getId();
					 serviceFormMapper.deleteByPrimaryKey(id);
				}
			}
		}
		servicesHomeBuyRecord.setIsPurchase(purchase);
    	servicesHomeBuyRecord.setCreatetime(createtime.intValue());
    	servicesHomeBuyRecord.setTotal(1);
    	servicesHomeBuyRecord.setServiceId(serviceHomeBuy.getServiceId());
    	servicesHomeBuyRecordMapper.insertSelective(servicesHomeBuyRecord);
        com.airmcl.air.service.entity.Service service = new com.airmcl.air.service.entity.Service();
        service.setId(serviceHomeBuy.getServiceId());
        service.setIsPurchase(serviceHomeBuy.getIsPurchase());
    	serviceMapper.updateByPrimaryKeySelective(service);
		return 1;
	}

}