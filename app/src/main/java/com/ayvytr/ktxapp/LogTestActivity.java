package com.ayvytr.ktxapp;

import android.os.Bundle;

import com.ayvytr.logger.L;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

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
        L.e(1);
        L.i(1);
        L.d(1);
        L.w(1);
        L.v(1);
        L.wtf(1);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("AA");
        strings.add("BB");
        L.e(strings);

        L.e();
    }
}
