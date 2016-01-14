package com.kpit.csr.akshar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

import com.kpit.csr.akshar.R;


/**
 * Created by kpittechnologies on 1/8/16.
 */
public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this,
                        MainActivity.class);
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(
                        SplashActivity.this, R.anim.in_right_animation,
                        R.anim.out_left_animation).toBundle();
                ActivityCompat.startActivity(SplashActivity.this, i, bundle);


//                Intent i = new Intent(SplashActivity.this,
//                        MainActivity.class);
//                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
