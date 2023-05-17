package com.jiker.recharge.service.impl;

import com.jiker.recharge.domain.RechargeRecordEntity;
import com.jiker.recharge.mapper.RechargeRecordMapper;
import com.jiker.recharge.service.RechargeRecordService;


/**
 * @ClassName RechargeRecordServiceImpl
 * @Description 业务层实现
 * @Author 邢庆
 * @Date 2023/4/9 14:54
 * @Version 1.0
 **/

public class RechargeRecordServiceImpl implements RechargeRecordService {

    private static final String RESULT = "当前账户余额为：";


    private RechargeRecordMapper rechargeRecordMapper;

    /**
     * 外部控制器初始化RechargeRecordMapper后，通过构造器传给service实现类
     * @param rechargeRecordMapper
     */
    public RechargeRecordServiceImpl(RechargeRecordMapper rechargeRecordMapper) {
        this.rechargeRecordMapper = rechargeRecordMapper;
    }

    /**
     * 根据卡号进行充值
     *
     * @param cardId
     * @param money
     * @param state true为充值 false为刷卡
     * @return
     */
    @Override
    public String recharge(int cardId, double money, boolean state) {

        if(cardId <= 0) {
            return "充值失败，请联系客服";
        }
        RechargeRecordEntity rechargeRecordEntity = rechargeRecordMapper.getRechargeRecordById(cardId);

        // 首次充值
        if(rechargeRecordEntity == null) {

            try{
                rechargeRecordEntity = RechargeRecordEntity.to(cardId, money);
                rechargeRecordMapper.insert(rechargeRecordEntity);

                return RESULT + String.valueOf(money);
            }catch (Exception e) {
                return "充值失败，请联系客服";
            }

        }
        try{
            // 非首次充值
            RechargeRecordEntity updateMoneyEntity = rechargeRecordEntity.updateMoneyEntity(money, state);
            rechargeRecordMapper.updateByPrimaryKey(updateMoneyEntity);
            return RESULT + String.valueOf(updateMoneyEntity.getAftMoney());
        }catch (Exception e) {
            return "充值失败，请联系客服";
        }
    }


}
