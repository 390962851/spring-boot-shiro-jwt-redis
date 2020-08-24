package cn.github.assets.entity;


import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Data
@Repository
public class RegularAssets {
    private Integer id; //
    private String assetsName; //
    private String assetsType; //
    private String type; //
    private String unit; //
    private Integer quantity; //
    private Date storageDate; //入库日期
    private String recipients; //领取人
    private float assetsValue; //资产原值
    private float depreciationRate; //折旧率
    private Integer depreciationPeriod; //折旧年限
    private Integer depreciatedDate; //已折旧日期
    private float depreciationMonth; //本月折旧
    private float depreciationAcc; //累计折旧
    private float assetNetValue; //资产净值
    private String storageLoca;//存放地点
    private Integer status; //状态
    private Date statusDate; //状态
//    private RegularStatus regular_status; //状态
    private String remarks; //备注




}
