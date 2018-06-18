package com.gy.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yanggao on 18/6/18.
 */
public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }

}
