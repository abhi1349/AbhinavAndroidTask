package personal.system.com.dhwanitaskabhinav.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import personal.system.com.dhwanitaskabhinav.R;


public class MyApplication extends Application {
//    private static MyApplication singleton;
    private static SharedPreferences myPreferences;
//    public static MyApplication getInstance() {
//        return singleton;
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        myPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    public static SharedPreferences getPreferences(){
        return myPreferences;
    }
}
