package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.BeauticianService;
import com.airmcl.air.beautician.entity.BeauticianServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianServiceMapper {
    int countByExample(BeauticianServiceExample example);

    int deleteByExample(BeauticianServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeauticianService record);

    int insertSelective(BeauticianService record);

    List<BeauticianService> selectByExample(BeauticianServiceExample example);

    BeauticianService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeauticianService record, @Param("example") BeauticianServiceExample example);

    int updateByExample(@Param("record") BeauticianService record, @Param("example") BeauticianServiceExample example);

    int updateByPrimaryKeySelective(BeauticianService record);

    int updateByPrimaryKey(BeauticianService record);

    void insertBatch(List<BeauticianService> list);

    List<BeauticianService> selectByExampleByPage(BeauticianServiceExample example);

    void updateState(@Param("ids")int[] ids, @Param("status")Integer status);

}