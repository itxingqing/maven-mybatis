package com.jiker.recharge.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 实体类，地铁充值记录包装类
 */
public class RechargeRecordEntity {
    private Integer id;

    private String type;

    private BigDecimal preMoney;

    private BigDecimal aftMoney;

    private String line;

    private String dotName;

    private Integer dotNumber;

    private String equipmentName;

    private Integer equipmentNumber;

    private Date transactionTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPreMoney() {
        return preMoney;
    }

    public void setPreMoney(BigDecimal preMoney) {
        this.preMoney = preMoney;
    }

    public BigDecimal getAftMoney() {
        return aftMoney;
    }

    public void setAftMoney(BigDecimal aftMoney) {
        this.aftMoney = aftMoney;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDotName() {
        return dotName;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
    }

    public Integer getDotNumber() {
        return dotNumber;
    }

    public void setDotNumber(Integer dotNumber) {
        this.dotNumber = dotNumber;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Integer getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(Integer equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(", 卡号：").append(id);
        sb.append(", 类型：").append(type);
        sb.append(", 卡余额：").append(aftMoney);
        sb.append(", 交易时间：").append(transactionTime);
        return sb.toString();
    }

    /**
     * 封装数据库实体
     * @return
     */
    public static RechargeRecordEntity to(int cardId, double money) {

        RechargeRecordEntity rechargeRecordEntity = new RechargeRecordEntity();
        rechargeRecordEntity.setId(cardId);
        rechargeRecordEntity.setType("普通充值卡");
        rechargeRecordEntity.setPreMoney(BigDecimal.valueOf(0));
        rechargeRecordEntity.setAftMoney(BigDecimal.valueOf(money));
        rechargeRecordEntity.setLine("16号线");
        rechargeRecordEntity.setDotName("极客学院网点");
        rechargeRecordEntity.setDotNumber(2005486);
        rechargeRecordEntity.setEquipmentName("自助充值机");
        rechargeRecordEntity.setEquipmentNumber(15864525);
        rechargeRecordEntity.setTransactionTime(new Timestamp(System.currentTimeMillis()));

        return rechargeRecordEntity;

    }

    /**
     * 转换为更新数据实体
     * @param money 此次变动的金额
     * @param state true为充值，false为刷卡
     * @return
     */
    public RechargeRecordEntity updateMoneyEntity(double money, boolean state) {

        RechargeRecordEntity rechargeRecordEntity = new RechargeRecordEntity();
        rechargeRecordEntity.setId(this.getId());
        rechargeRecordEntity.setPreMoney(this.aftMoney);
        rechargeRecordEntity.setAftMoney(state==true ? this.aftMoney.add(BigDecimal.valueOf(money)) : this.aftMoney.subtract(BigDecimal.valueOf(money)));
        rechargeRecordEntity.setTransactionTime(new Timestamp(System.currentTimeMillis()));

        return rechargeRecordEntity;

    }

}