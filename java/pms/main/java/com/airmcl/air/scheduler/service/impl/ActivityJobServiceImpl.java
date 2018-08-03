package com.airmcl.air.scheduler.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.activitys.dao.ActivitysMapper;
import com.airmcl.air.activitys.entity.Activitys;
import com.airmcl.air.activitys.entity.ActivitysExample;
import com.airmcl.air.scheduler.service.ActivityJobService;
import com.airmcl.basae.utils.DateUtil;

@Service("defaultActivityJobService")
public class ActivityJobServiceImpl implements ActivityJobService {
	
	@Resource
	protected ActivitysMapper activitysMapper;
	@Transactional
	@Override
	public int batchUpdateState() throws RuntimeException {
		int result =0;
		ActivitysExample activitysExample = new ActivitysExample();
		List<Byte> values = new ArrayList<Byte>();
		values.add((byte)0);
		values.add((byte)3);
		activitysExample.createCriteria().andStateNotIn(values);
		activitysExample.setOrderByClause("endtime asc");
		List<Activitys> activitysList = activitysMapper.selectByExample(activitysExample);
		if(activitysList==null||activitysList.size()==0){
			return result;
		}
		int systemTime = DateUtil.getTimestamp(0);
		List<Integer> listIds = new ArrayList<Integer>();
		for (Activitys activitys : activitysList) {
			Integer entTime = activitys.getEndtime();
			if(entTime>systemTime){
				break;
			}
			listIds.add(activitys.getId());
		}
		if(listIds.size()>0){
			Activitys record = new Activitys();
			record.setState((byte)3);
			ActivitysExample example = new ActivitysExample();
			example.createCriteria().andIdIn(listIds);
		    result = activitysMapper.updateByExampleSelective(record, example);
		}
		return result;
	}
	

}
