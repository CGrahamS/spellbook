package com.cgrahams.spellbook;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    public static final String TAG = MainActivityTest.class.getSimpleName();

    private MainActivity activity;
    @Bind(R.id.mainHeaderTextView)
    TextView mainHeaderTextView;

    @Bind(R.id.mainSearchButton)
    Button mainSearchButton;


    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        ButterKnife.bind(this, activity);
    }

    @Test
    public void validateTextViewContent() {
        assertTrue("Spellbook".equals(mainHeaderTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted() {
        mainSearchButton.performClick();
        Intent expectedIntent = new Intent(activity, SpellSearchActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
