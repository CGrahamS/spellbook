package com.cgrahams.spellbook.ui;

import android.app.Fragment;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.cgrahams.spellbook.BuildConfig;
import com.cgrahams.spellbook.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.cgrahams.spellbook.support.Assert.assertViewIsVisible;
import static org.junit.Assert.*;
import static org.robolectric.Robolectric.setupActivity;

/**
 * Created by CGrahamS on 1/5/17.
 */

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class SpellDetailActivityTest {
    public static final String TAG = SpellDetailActivityTest.class.getSimpleName();

    private SpellDetailActivity activity;
    private ViewPager viewPager;


    @Before
    public void setUp() throws Exception {
        activity = setupActivity( SpellDetailActivity.class);
        ViewPager viewPager = (ViewPager) activity.findViewById(R.id.spellDetailViewPager);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveViewPager() throws Exception {
        Log.d(TAG, "shouldHaveViewPager: " + viewPager);
        assertViewIsVisible(viewPager);
    }
}