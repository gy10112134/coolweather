package com.gy.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yanggao on 18/6/18.
 */
public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }

}
