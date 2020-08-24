package cn.github.assets.entity;


import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Data
@Repository
public class InvisiableAssets {
    private Integer id; //
    private String assetsName; //
    private String assetsType; //
    private Date storageDate; //入库日期
    private float assetsValue; //资产原值
    private float depreciationRate; //摊销率
    private Integer depreciationPeriod; //摊销年限
    private Integer depreciatedDate; //已摊销日期
    private float depreciationMonth; //本月摊销
    private float depreciationAcc; //累计摊销
    private float assetNetValue; //资产净值
    private String storageLoca;//存放地点
    private Integer status; //状态
    private Date statusDate; //状态
    private String remarks; //备注




}
