package com.example.mvpsample.Model;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPrefs {
private static SharedPreferences sharedPreferences;
private static final String PREF_FILE = "prefs";

private static final String USER_NAME = "user_name";
private static final String PASSWORD = "pass";

public static void init(Context context) {
sharedPreferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
}

public static String getUserName() {
return sharedPreferences.getString(USER_NAME, "");
}

public static String getPassword() {
return sharedPreferences.getString(PASSWORD, "");
}

public static void setUserName(String uName) {
sharedPreferences.edit().putString(USER_NAME, uName).apply();
}

public static void setPassword(String pass) {
sharedPreferences.edit().putString(PASSWORD, pass).apply();
}

}