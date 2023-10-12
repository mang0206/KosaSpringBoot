package com.example.springedu.dao;

import com.example.springedu.domain.EmpVO;
import com.example.springedu.domain.MytableVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface ETCMapper {
    @Select("select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') hiredate, sal  from ${t} order by ${c}")
    public List<EmpVO> list1(@Param("t") String t, @Param("c") String c );

    @Select("select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') hiredate, sal  from emp where  ${colname} like  concat('%',#{key},'%')")
    public List<EmpVO> list2(@Param("colname") String cn, @Param("key") String key );

    @Select("select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') "+
            "hiredate, sal  from emp where  empno in (${datalist})")
    public List<EmpVO> list3(String datalist );

    @Select("<script> select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') hiredate, sal  from emp " +
            "<where> " +
            "<if test='ename != null'> ename  like  concat('%',#{ename},'%')</if>" +
            "<if test='sal gt 0'> and  sal > #{sal}</if>" +
            "</where></script>")
    public List<EmpVO> list4(EmpVO vo );

    @SelectProvider(type = EmpSqlBuilder.class, method = "buildGetEmpsByName")
    List<EmpVO> list5(String name);

    class EmpSqlBuilder {
        public static String buildGetEmpsByName(final String name) {
            return new SQL(){{
                SELECT("empno, ename, job, hiredate, sal");
                FROM("emp");
                if (name != null) {
                    WHERE("ename like concat(#{name}, '%')");
                }
                ORDER_BY("sal");
            }}.toString();
        }
    }

    @Select({"select real_name, ",
            "nic_name from",
            "mytable"})
    public List<MytableVO> list6( );
}

/*
[ 애노테이션으로 매퍼파일 만들기 ]
Mybatis 3.0 부터 XML 로 작성하는 매퍼파일 대신 자바 클래스 또는 인터페이스에 작성되는 애노테이션으로 대신할 수 있다.
매퍼를 애노테이션으로 처리하려는 경우에는 스프링 부트 애플리케이션 기동 프로그램(SpringeduApplication.java)
@MapperScan 에 대한 정보를 작성해야 한다.
	@MapperScan(value={"com.example.springedu.dao"})

구현 방법은
   애노테이션과 SQL 이 정의된 인터페이스(매퍼 인터페이스)
   애노테이션이 정의된 인터페이스+SQL이 정의된 XML 매퍼파일
   애노테이션이 정의된 인터페이스+SQL과 애노테이션이 정의된 매퍼 클래스
   등 다양하다. 우리는 매퍼 인터페이스 방법으로 만 학습하였다.
   다른 구현 방법들은
   https://mybatis.org/mybatis-3/java-api.html 을 참고한다.

 */