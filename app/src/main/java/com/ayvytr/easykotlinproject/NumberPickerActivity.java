package com.ayvytr.easykotlinproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ayvytr.easykotlin.customview.NumberPickerView;

public class NumberPickerActivity extends AppCompatActivity {

    private NumberPickerView npv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);
        npv = findViewById(R.id.npv);
        npv.setDisableWrapSelectorWheelCheck(true);
        String[] values = new String[]{"aaa", "bbb"};
        npv.setDisplayedValues(values);
        npv.setMinValue(1);
        npv.setMaxValue(2);
    }
}
