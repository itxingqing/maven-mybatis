package com.jiker;

import com.jiker.recharge.domain.RechargeRecordEntity;
import com.jiker.recharge.mapper.RechargeRecordMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2. 获取SqlSession对象，用它来执行sql
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //3. 执行sql
            //3.1 获取RechargeRecordMapper接口的代理对象
            RechargeRecordMapper rechargeRecordMapper = sqlSession.getMapper(RechargeRecordMapper.class);
            List<RechargeRecordEntity> rechargeRecordEntityList = rechargeRecordMapper.queryAllRechargeRecord();

            rechargeRecordEntityList.stream().forEach(rechargeRecordEntity -> {
                System.out.println(rechargeRecordEntity);
            });
            //4. 释放资源
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}