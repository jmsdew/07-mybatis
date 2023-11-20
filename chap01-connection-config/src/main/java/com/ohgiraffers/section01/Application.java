package com.ohgiraffers.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import java.util.Date;

public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "menu";
    private static String PASS = "menu";

    public static void main(String[] args){

        /*
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 오토 커밋
        * ------------------------
        * PooledDataSource : ConnectionPool 을 사용함
        * UnPooledDataSource : ConnectionPool 을 사용 하지 않음
        * */
        Environment environment = new Environment(                  // 환경정보 저장 객체 아이디, 트랜젝션종류, 풀 사용여부
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER,URL,USER,PASS)
        );

        Configuration config = new Configuration(environment);          // 연결할 수 있는 객체 environment 기반

        config.addMapper(Mapper.class);

        /*
        <SqlSession이란 RDB에 인증을 거친 논리적인 연결 상태를 말하는 것이다.>
         * SqlSessionFactory : sqlsession 객체를 생성하기 위한 팩토리 역할의 인터페이스
         * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 개겣를 생성하기 위한 빌드 역할
         * build() : 설정에 대한 정볼르 담고 있는 Configration 타입의 객체 혹은 외부 설정 파일과 연관된 Stream을 매개변수로
         *           전달하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
         * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);


        /*
        * openSession() : SqlSession 인터페이스 타입의 객체를 반환하는 메소드로 boolean 타입을 인자로 전달
        *  -false : Connection 인터페이스 타입 객체로 Dml(update, insert, delete) 수행 후 Auto Commit 에 대한 옵션을 false 로 저장  < 권장 >
        * - true : Connection 인터페이스 타입 객체로 Dml() 수행 후 Auto Commit 에 대한 옵션을 true 로 저장
        * */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Date date = mapper.selectSysDate();
        System.out.println(date);
        sqlSession.close();





    }
}
