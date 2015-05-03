package utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

import Bean.DailyMenuPoList;
import Bean.Ontop;
import Bean.RecommendUris;

/**
 * Created by Administrator on 2015/5/2.
 */
public class MyJsonParser {


    public static List<DailyMenuPoList> getDMP(String str) {
        ArrayList<DailyMenuPoList> dailyMenuPoLists = new ArrayList<>();
        com.alibaba.fastjson.JSONObject obj = JSON.parseObject(str);
        JSONArray arr = obj.getJSONArray("dailyMenuPoList");
        for (int i = 0; i < arr.size(); i++) {
            DailyMenuPoList dm = arr.getJSONObject(i).getObject("dailyMenuPoList", DailyMenuPoList.class);
            dailyMenuPoLists.add(dm);
        }
        return dailyMenuPoLists;
    }

    public static List<Ontop> getOP(String str) {
        ArrayList<Ontop> ontop = new ArrayList<>();


        return ontop;
    }

    public static List<RecommendUris> getRecommendUris(String str) {
        ArrayList<RecommendUris> recommendUris = new ArrayList<>();
        com.alibaba.fastjson.JSONObject obj = JSON.parseObject(str);

        JSONArray arr = obj.getJSONArray("recommendUris");
        for (int i = 0; i < arr.size(); i++) {
            RecommendUris ru = arr.getJSONObject(i).getObject("recommendUris", RecommendUris.class);
            recommendUris.add(ru);
        }
        return recommendUris;
    }


}
