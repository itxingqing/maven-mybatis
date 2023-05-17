package com.jiker.recharge.service;

/**
 * @ClassName RechargeRecordService
 * @Description 业务层接口
 * @Author 邢庆
 * @Date 2023/4/9 14:54
 * @Version 1.0
 **/
public interface RechargeRecordService {

    /**
     * 根据卡号进行充值
     * @param cardId
     * @param money
     * @return
     */
    String recharge(int cardId, double money, boolean state);


}
