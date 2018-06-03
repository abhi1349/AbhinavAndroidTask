package personal.system.com.dhwanitaskabhinav.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import personal.system.com.dhwanitaskabhinav.R;

import personal.system.com.dhwanitaskabhinav.app.Prefs;


public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if(Prefs.isLoggedIn())
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    else
                        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                }
            }
        });
        t.start();
    }
}
