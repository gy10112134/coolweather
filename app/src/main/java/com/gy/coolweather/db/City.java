package com.gy.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by yanggao on 18/6/17.
 */
public class City extends DataSupport {
    private int id;

    private String cityName; //市名称

    private int cityCode; //市代号

    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
