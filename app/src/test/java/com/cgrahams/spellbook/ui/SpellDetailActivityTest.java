package com.cgrahams.spellbook.ui;

import android.os.Build;

import com.cgrahams.spellbook.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

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


    @Before
    public void setUp() throws Exception {
        activity = setupActivity( SpellDetailActivity.class);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);

    }
}