package com.cgrahams.spellbook.ui;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import com.cgrahams.spellbook.BuildConfig;
import com.cgrahams.spellbook.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;


import static com.cgrahams.spellbook.support.Assert.assertViewIsVisible;
import static com.cgrahams.spellbook.support.ResourceLocator.getString;
import static com.cgrahams.spellbook.support.ViewLocator.getButton;
import static com.cgrahams.spellbook.support.ViewLocator.getTextView;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.*;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    public static final String TAG = MainActivityTest.class.getSimpleName();

    private MainActivity activity;
    private TextView mainHeaderTextView;
    private Button mainSearchButton;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity( MainActivity.class);
        mainHeaderTextView = getTextView(activity, R.id.mainHeaderTextView);
        mainSearchButton = getButton(activity, R.id.mainSearchButton);
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveTitle() throws Exception {
        assertThat(activity.getTitle().toString(),
                equalTo(getString(R.string.app_name)));
    }

    @Test
    public void shouldHaveHeader() throws Exception {
        assertViewIsVisible(mainHeaderTextView);
        assertThat(mainHeaderTextView.getText().toString(), equalTo(getString(R.string.HEADER_TEXT)));
    }

    @Test
    public void shouldHaveSearchButton() throws Exception {
        assertViewIsVisible(mainSearchButton);
        assertThat( mainSearchButton.getText().toString(), equalTo(getString(R.string.MAIN_SEARCH_BUTTON)));
    }

    @Test
    public void shouldStartSpellSearchActivityWhenClicked() throws Exception {
        mainSearchButton.performClick();

        ShadowActivity shadowActivity = shadowOf(activity);
        Intent intent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf( intent );
        assertEquals(shadowIntent.getComponent().getClassName(),
                SpellSearchActivity.class.getName());
    }
}
