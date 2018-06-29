package com.gy.coolweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.gy.coolweather.db.City;
import com.gy.coolweather.db.County;
import com.gy.coolweather.db.Province;
import com.gy.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yanggao on 18/6/17.
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handlerProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray jsonArray = new JSONArray(response);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject provinceObject = jsonArray.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {

            }
        }

        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handlerCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray cityJsonArray = new JSONArray(response);
                for (int i = 0; i < cityJsonArray.length(); i++) {
                    JSONObject cityJsonObject = cityJsonArray.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityJsonObject.getString("name"));
                    city.setCityCode(cityJsonObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {

            }
        }
        return false;

    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handlerCountyResponse(String response, int cityId) {

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray countyJsonArray = new JSONArray(response);
                for (int i = 0; i < countyJsonArray.length(); i++) {
                    JSONObject countyJsonObject = countyJsonArray.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyJsonObject.getString("name"));
                    county.setWeatherId(countyJsonObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {

            }
        }

        return false;
    }

    /**
     * 将返回的json数据解析成Weather实体类
     * @param response
     * @return
     */
    public static Weather handlerWeatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
