package com.example.mixazp.utilitysubmitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.mixazp.utilitysubmitter.model.ElectricityDataModel;
import com.example.mixazp.utilitysubmitter.model.GazDataModel;
import com.example.mixazp.utilitysubmitter.model.WaterDataModel;
import com.google.gson.Gson;


public class DataManager {
    private static DataManager ourInstance = new DataManager();
    private static final String PREFS_NAME = "PRODUCT_APP";
    private static final String WATER_DATA_ITEMS = "Water_Data_Items";
    private static final String GAZ_DATA_ITEMS = "Gaz_Data_Items";
    private static final String ELECTRICITY_DATA_ITEMS = "Electricity_Data_Items";

    public static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
    }

    public void saveWaterDataModelItems(Context context, List<WaterDataModel> item) {
        SharedPreferences settings;
        Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonItems = gson.toJson(item);
        editor.putString(WATER_DATA_ITEMS, jsonItems);
        editor.commit();
    }

    public void saveGazDataModelItems(Context context, List<GazDataModel> item) {
        SharedPreferences settings;
        Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(item);
        editor.putString(GAZ_DATA_ITEMS, jsonFavorites);
        editor.commit();
    }

    public void saveElectricityDataModelItems(Context context, List<ElectricityDataModel> item) {
        SharedPreferences settings;
        Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(item);
        editor.putString(ELECTRICITY_DATA_ITEMS, jsonFavorites);
        editor.commit();
    }
    //  ----------------------------------------------------------------------------------------------------
    public void addWaterDataModelItem(Context context, WaterDataModel item) {
        List<WaterDataModel> favorites = getWaterDataModelItems(context);
        if (favorites == null)
            favorites = new ArrayList<WaterDataModel>();
        favorites.add(item);
        saveWaterDataModelItems(context, favorites);
    }

    public void addGazDataModelItem(Context context, GazDataModel item) {
        List<GazDataModel> favorites = getGazDataModelItems(context);
        if (favorites == null)
            favorites = new ArrayList<GazDataModel>();
        favorites.add(item);
        saveGazDataModelItems(context, favorites);
    }

    public void addElectricityDataModelItem(Context context, ElectricityDataModel item) {
        List<ElectricityDataModel> favorites = getElectricityDataModelItems(context);
        if (favorites == null)
            favorites = new ArrayList<ElectricityDataModel>();
        favorites.add(item);
        saveElectricityDataModelItems(context, favorites);
    }

    //    _------------------------------------------------------------------------------------------------
    public void removeWaterDataModelItem(Context context, WaterDataModel item) {
        ArrayList<WaterDataModel> favorites = getWaterDataModelItems(context);
        if (favorites != null) {
            favorites.remove(item);
            saveWaterDataModelItems(context, favorites);
        }
    }

    public void removeGazDataModelItem(Context context, GazDataModel item) {
        ArrayList<GazDataModel> favorites = getGazDataModelItems(context);
        if (favorites != null) {
            favorites.remove(item);
            saveGazDataModelItems(context, favorites);
        }
    }

    public void removeElectricityDataModelItem(Context context, ElectricityDataModel item) {
        ArrayList<ElectricityDataModel> favorites = getElectricityDataModelItems(context);
        if (favorites != null) {
            favorites.remove(item);
            saveElectricityDataModelItems(context, favorites);
        }
    }

    //    ------------------------------------------------------------------------------------------------

    public ArrayList<WaterDataModel> getWaterDataModelItems(Context context) {

        SharedPreferences settings;
        List<WaterDataModel> items;
        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(WATER_DATA_ITEMS)) {

            String jsonFavorites = settings.getString(WATER_DATA_ITEMS, null);
            Gson gson = new Gson();
            WaterDataModel[] favoriteItems = gson.fromJson(jsonFavorites,
                    WaterDataModel[].class);
            items = Arrays.asList(favoriteItems);
            items = new ArrayList<WaterDataModel>(items);

        } else

            return null;
        return (ArrayList<WaterDataModel>) items;

    }

    public ArrayList<GazDataModel> getGazDataModelItems(Context context) {

        SharedPreferences settings;
        List<GazDataModel> items;
        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(GAZ_DATA_ITEMS)) {

            String jsonFavorites = settings.getString(GAZ_DATA_ITEMS, null);
            Gson gson = new Gson();
            GazDataModel[] favoriteItems = gson.fromJson(jsonFavorites,
                    GazDataModel[].class);
            items = Arrays.asList(favoriteItems);
            items = new ArrayList<GazDataModel>(items);

        } else

            return null;
        return (ArrayList<GazDataModel>) items;

    }

    public ArrayList<ElectricityDataModel> getElectricityDataModelItems(Context context) {

        SharedPreferences settings;
        List<ElectricityDataModel> items;
        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(ELECTRICITY_DATA_ITEMS)) {

            String jsonFavorites = settings.getString(ELECTRICITY_DATA_ITEMS, null);
            Gson gson = new Gson();
            ElectricityDataModel[] favoriteItems = gson.fromJson(jsonFavorites,
                    ElectricityDataModel[].class);
            items = Arrays.asList(favoriteItems);
            items = new ArrayList<ElectricityDataModel>(items);

        } else

            return null;
        return (ArrayList<ElectricityDataModel>) items;

    }

}