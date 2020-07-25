package com.ggs.exam.mapper;

import com.ggs.exam.pojo.Book;
import com.ggs.exam.pojo.BookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}