package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.Loan;
import com.example.demo.dal.bean.LoanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoanDao {
    long countByExample(LoanExample example);

    int deleteByExample(LoanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Loan record);

    int insertSelective(Loan record);

    List<Loan> selectByExample(LoanExample example);

    Loan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Loan record, @Param("example") LoanExample example);

    int updateByExample(@Param("record") Loan record, @Param("example") LoanExample example);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);
}