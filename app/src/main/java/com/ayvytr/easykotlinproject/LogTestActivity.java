package com.ayvytr.easykotlinproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ayvytr.easykotlin.log.Log;

public class LogTestActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_test);
        testLog();
    }

    private void testLog()
    {
        Log.e(1);
        Log.i(1);
        Log.d(1);
        Log.w(1);
        Log.v(1);
        Log.wtf(1);
    }
}
