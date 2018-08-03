package com.airmcl.air.app.dao.ext;

import java.util.List;

import com.airmcl.air.app.entity.IndexEnterColumnAndModelParams;
import com.airmcl.air.app.entity.IndexOutColumnAndModel;

public interface IndexColumnExtMapper {
	
	List<IndexOutColumnAndModel> findPageByParams(IndexEnterColumnAndModelParams enterParams);
	
	Integer countColumnAndModel(IndexEnterColumnAndModelParams enterParams);
}