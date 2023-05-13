package com.jiker.recharge.mapper;

import com.jiker.recharge.domain.RechargeRecordEntity;

import java.util.List;

/**
 * 数据层，连接数据库处理数据类
 */
public interface RechargeRecordMapper {
    /**
     * 查询充值卡信息
     * @return
     */
    List<RechargeRecordEntity> queryAllRechargeRecord();

    /**
     * 根据卡号查询充值卡信息
     * @param cardId
     * @return
     */
    RechargeRecordEntity getRechargeRecordById(Integer cardId);

    /**
     * 新增充值卡
     * @param record
     * @return
     */
    int insert(RechargeRecordEntity record);



}