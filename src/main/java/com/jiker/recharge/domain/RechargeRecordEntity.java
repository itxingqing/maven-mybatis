package com.jiker.recharge.domain;

import java.util.Date;

/**
 * 实体类，地铁充值记录包装类
 */
public class RechargeRecordEntity {
    private Integer id;

    private String type;

    private Double preMoney;

    private Double aftMoney;

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

    public Double getPreMoney() {
        return preMoney;
    }

    public void setPreMoney(Double preMoney) {
        this.preMoney = preMoney;
    }

    public Double getAftMoney() {
        return aftMoney;
    }

    public void setAftMoney(Double aftMoney) {
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

}