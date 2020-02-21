package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.Entry;
import com.example.demo.dal.bean.EntryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EntryDao {
    long countByExample(EntryExample example);

    int deleteByExample(EntryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Entry record);

    int insertSelective(Entry record);

    List<Entry> selectByExample(EntryExample example);

    Entry selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Entry record, @Param("example") EntryExample example);

    int updateByExample(@Param("record") Entry record, @Param("example") EntryExample example);

    int updateByPrimaryKeySelective(Entry record);

    int updateByPrimaryKey(Entry record);
}