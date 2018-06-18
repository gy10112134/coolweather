package com.gy.coolweather.gson;

/**
 * Created by yanggao on 18/6/18.
 */
public class AQI {

    public AQICity city;

    public class AQICity {
        public String aqi;

        public String pm25;
    }
}
