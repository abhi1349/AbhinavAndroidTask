package personal.system.com.dhwanitaskabhinav.app;

import android.content.SharedPreferences;

public class Prefs {
    private static  String IS_LOGIN="is_login";
    private static SharedPreferences sharedPref = MyApplication.getPreferences();

    public static boolean isLoggedIn() {
        return sharedPref.getBoolean(IS_LOGIN,false);
    }

    public static void setLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(IS_LOGIN, loggedIn);
        editor.commit();
    }
    public static void logOut(){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(IS_LOGIN, false);
        editor.putString("TOKEN","");
        editor.clear();
        editor.commit();
    }


    public static void  saveToken(String token) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("TOKEN", token);
        editor.commit();

    }
    public static String getToken(){
        return sharedPref.getString("TOKEN","");
    }

}
