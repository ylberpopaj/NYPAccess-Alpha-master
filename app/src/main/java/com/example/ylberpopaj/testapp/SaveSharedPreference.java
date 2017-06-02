package com.example.ylberpopaj.testapp;

import android.content.SharedPreferences;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;

/**
 * Created by ylberpopaj on 3/28/17.
 */

public class SaveSharedPreference extends MainActivity {
    static final String PREF_USER_NAME = "username";
    static SharedPreferences getSharedPreferences(Context ctx){
        return PreferenceManager.getDefaultSharedPreferences(ctx);

    }
    public static boolean getValidity(Context ctx, String usernameRegistered, String passwordRegistered){

        return true;



    }

    public static void setUserName(Context ctx, String usernamePref)
    {
        Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, usernamePref);
        editor.commit();

    }
    public static void setAccountInfo(Context ctx, String usernamePass)
    {
        Editor editor = getSharedPreferences(ctx).edit();
        editor.putString("usernamepass", usernamePass);
        editor.commit();

    }

    public static String getUserName(Context ctx){

        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");

    }
    public static void clearUserName(Context ctx){

        Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.commit();

    }

}
