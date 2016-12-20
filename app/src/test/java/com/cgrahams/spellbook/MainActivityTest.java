package com.cgrahams.spellbook;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cgrahams.spellbook.support.ResourceLocator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.cgrahams.spellbook.support.Assert.assertViewIsVisible;
import static com.cgrahams.spellbook.support.ResourceLocator.getString;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.*;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    public static final String TAG = MainActivityTest.class.getSimpleName();

    @Bind(R.id.mainHeaderTextView)
    TextView mainHeaderTextView;

    @Bind(R.id.mainSearchButton)
    Button mainSearchButton;
    private MainActivity activity;


    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity( MainActivity.class);
        ButterKnife.bind(this, activity);
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
    public void shouldHaveWelcomeText() throws Exception {
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
