package com.cgrahams.spellbook;

import android.os.Build;
import android.support.v4.app.Fragment;

import com.cgrahams.spellbook.ui.SpellSearchActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.cgrahams.spellbook.support.Assert.assertViewIsVisible;
import static com.cgrahams.spellbook.support.ResourceLocator.getString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class SpellSearchActivityTest {
    private SpellSearchActivity activity;
    private Fragment fragment;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity( SpellSearchActivity.class);
        fragment = activity.getSupportFragmentManager().findFragmentById( R.id.spellSearchFragment );
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveTitle() throws Exception {
        assertThat(activity.getTitle().toString(),
                equalTo(getString(R.string.app_name)));
    }

    //Find Fragment
    @Test
    public void shouldHaveListFragment() throws Exception {
        assertViewIsVisible(fragment.getView());
    }
}