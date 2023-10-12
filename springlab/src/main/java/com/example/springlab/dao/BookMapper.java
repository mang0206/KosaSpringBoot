package com.example.springlab.dao;

import com.example.springlab.domain.BookDTO;
import com.example.springlab.domain.BookResultVO;
import java.util.List;
import org.apache.ibatis.annotations.*;


@Mapper
public interface BookMapper {
  @Select("SELECT ID, TITLE, PRICE, KIND FROM BOOK")
  public List<BookDTO> list();

  @Select("SELECT ID, TITLE, PRICE, KIND FROM BOOK ORDER BY PRICE DESC")
  public List<BookDTO> sortList();

  @Select("SELECT ID, TITLE, PRICE, KIND FROM BOOK WHERE PRICE >= 20000")
  public List<BookDTO> overList();

  @Select("SELECT ID, TITLE, PRICE, KIND FROM BOOK WHERE KIND='B02'")
  public List<BookDTO> webBookList();

  @Select("SELECT ID, TITLE, PRICE, KIND FROM BOOK WHERE KIND IN ('B04', 'B05')")
  public List<BookDTO> dbAndInfraList();

  @Select("SELECT ID, TITLE, PRICE, KIND FROM BOOK WHERE TITLE LIKE '%자바%'")
  public List<BookDTO> javaList();

  @Select("SELECT KIND, ROUND(AVG(PRICE),1) AVGPRICE FROM BOOK GROUP BY KIND")
  public List<BookResultVO> avgList();

  @Insert("INSERT INTO BOOK (TITLE, PRICE, KIND) VALUES (#{title}, #{price}, #{kind})")
  public boolean insert(BookDTO bookDTO);
}
