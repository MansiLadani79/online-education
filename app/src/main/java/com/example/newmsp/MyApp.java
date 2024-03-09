package com.example.newmsp;

import android.app.Application;
import android.content.SharedPreferences;

public class MyApp extends Application {


    public static SharedPreferences preferences;
    public static SharedPreferences.Editor prefEditor;

    @Override
    public void onCreate() {
        super.onCreate();
        preferences = getSharedPreferences("my_pref", 0);
        prefEditor = preferences.edit();
        prefEditor.apply();
    }



    public static String getStringPrefs(String key) {
        return preferences.getString(key, null);
    }

    public static String getStringPrefs(String key, String Def) {
        return preferences.getString(key, Def);
    }

    public static void setStringPrefs(String key, String value) {
        prefEditor.putString(key, value);
        prefEditor.commit();
    }

    public static boolean getBooleanPrefs(String key) {
        return preferences.getBoolean(key, false);
    }

    public static void setBooleanPrefs(String key, boolean value) {
        prefEditor.putBoolean(key, value);
        prefEditor.commit();
    }
}
