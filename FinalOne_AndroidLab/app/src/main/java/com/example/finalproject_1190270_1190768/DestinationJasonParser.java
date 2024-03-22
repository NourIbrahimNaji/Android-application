package com.example.finalproject_1190270_1190768;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// convert from json to java(array list)
public class DestinationJasonParser {
    public static List<Destination> getObjectFromJason(String jason) {
        List<Destination> destinations;
        try {
            JSONArray jsonArray = new JSONArray(jason);
            destinations = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject = (JSONObject) jsonArray.get(i);
                Destination destination = new Destination();
                destination.setCity(jsonObject.getString("city"));
                destination.setCountry(jsonObject.getString("country"));
                destination.setContinent(jsonObject.getString("continent"));
                destination.setLongitude(jsonObject.getDouble("longitude"));
                destination.setLatitude(jsonObject.getDouble("latitude"));
                destination.setCost(jsonObject.getInt("cost"));
                destination.setImage(jsonObject.getString("img"));
                destination.setDescription(jsonObject.getString("description"));
                // add to list
                destinations.add(destination);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return destinations;
    }
}
