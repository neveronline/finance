package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.Bucket;
import com.example.demo.dal.bean.BucketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BucketDao {
    long countByExample(BucketExample example);

    int deleteByExample(BucketExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bucket record);

    int insertSelective(Bucket record);

    List<Bucket> selectByExample(BucketExample example);

    Bucket selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bucket record, @Param("example") BucketExample example);

    int updateByExample(@Param("record") Bucket record, @Param("example") BucketExample example);

    int updateByPrimaryKeySelective(Bucket record);

    int updateByPrimaryKey(Bucket record);
}