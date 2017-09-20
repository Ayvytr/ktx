package com.ayvytr.easykotlinproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Do on 2017/9/20.
 */

@RunWith(AndroidJUnit4.class)
public class JavaTest
{
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test1()
    {
        final TextView tv = (TextView) rule.getActivity().findViewById(R.id.tv);
        rule.getActivity().runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                tv.setVisibility(View.VISIBLE);
                assertEquals(tv.getVisibility(), View.VISIBLE);
                tv.setVisibility(View.INVISIBLE);
                assertEquals(tv.getVisibility(), View.INVISIBLE);
                tv.setVisibility(View.GONE);
                assertEquals(tv.getVisibility(), View.GONE);
            }
        });
    }
}
