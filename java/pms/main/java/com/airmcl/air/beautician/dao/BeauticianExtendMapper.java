package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.BeauticianExtend;
import com.airmcl.air.beautician.entity.BeauticianExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianExtendMapper {
    int countByExample(BeauticianExtendExample example);

    int deleteByExample(BeauticianExtendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeauticianExtend record);

    int insertSelective(BeauticianExtend record);

    List<BeauticianExtend> selectByExampleWithBLOBs(BeauticianExtendExample example);

    List<BeauticianExtend> selectByExample(BeauticianExtendExample example);

    BeauticianExtend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeauticianExtend record, @Param("example") BeauticianExtendExample example);

    int updateByExampleWithBLOBs(@Param("record") BeauticianExtend record, @Param("example") BeauticianExtendExample example);

    int updateByExample(@Param("record") BeauticianExtend record, @Param("example") BeauticianExtendExample example);

    int updateByPrimaryKeySelective(BeauticianExtend record);

    int updateByPrimaryKeyWithBLOBs(BeauticianExtend record);

    int updateByPrimaryKey(BeauticianExtend record);

    void insertBatch(List<BeauticianExtend> list);

    List<BeauticianExtend> selectByExampleByPage(BeauticianExtendExample example);

    BeauticianExtend findBeauticianExtendByBtId(Integer btId);

    int deleteByIds(List list);
}