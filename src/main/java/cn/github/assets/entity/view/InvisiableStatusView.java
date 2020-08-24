package cn.github.assets.entity.view;

import cn.github.assets.entity.RegularStatus;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Data
@Repository
public class InvisiableStatusView {
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
    private Date statusDate; //状态时间

    private RegularStatus regular_status; //状态
    private String remarks; //备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType;
    }

    public float getAssetsValue() {
        return assetsValue;
    }

    public void setAssetsValue(float assetsValue) {
        this.assetsValue = assetsValue;
    }

    public float getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(float depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public Integer getDepreciationPeriod() {
        return depreciationPeriod;
    }

    public void setDepreciationPeriod(Integer depreciationPeriod) {
        this.depreciationPeriod = depreciationPeriod;
    }

    public Integer getDepreciatedDate() {
        return depreciatedDate;
    }

    public void setDepreciatedDate(Integer depreciatedDate) {
        this.depreciatedDate = depreciatedDate;
    }

    public float getDepreciationMonth() {
        return depreciationMonth;
    }

    public void setDepreciationMonth(float depreciationMonth) {
        this.depreciationMonth = depreciationMonth;
    }

    public float getDepreciationAcc() {
        return depreciationAcc;
    }

    public void setDepreciationAcc(float depreciationAcc) {
        this.depreciationAcc = depreciationAcc;
    }

    public float getAssetNetValue() {
        return assetNetValue;
    }

    public void setAssetNetValue(float assetNetValue) {
        this.assetNetValue = assetNetValue;
    }

    public String getStorageLoca() {
        return storageLoca;
    }

    public void setStorageLoca(String storageLoca) {
        this.storageLoca = storageLoca;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public RegularStatus getRegular_status() {
        return regular_status;
    }

    public void setRegular_status(RegularStatus regular_status) {
        this.regular_status = regular_status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
