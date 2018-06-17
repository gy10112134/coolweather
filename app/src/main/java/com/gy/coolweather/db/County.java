package com.gy.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by yanggao on 18/6/17.
 */
public class County extends DataSupport {

    private int id;

    private String countyName; //县名称

    private String weatherId; //县对应的天气id

    private int cityId; //市id


}
