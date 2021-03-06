package com.cgrahams.spellbook.ui;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.cgrahams.spellbook.BuildConfig;
import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.ui.SpellSearchFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.cgrahams.spellbook.support.Assert.assertViewIsVisible;
import static com.cgrahams.spellbook.support.ResourceLocator.getString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class SpellSearchFragmentTest {
    private final SpellSearchFragment fragment = new SpellSearchFragment();
    private TextView searchHeaderTextView;
    private RecyclerView spellSearchRecyclerView;

    @Before
    public void setUp() throws Exception {
        startFragment(fragment);
        searchHeaderTextView = (TextView) fragment.getView().findViewById(R.id.searchFragmentHeaderTextView);
        spellSearchRecyclerView = (RecyclerView) fragment.getView().findViewById(R.id.spellSearchRecyclerView);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(fragment);
    }

    @Test
    public void shouldHaveHeader() throws Exception {
        assertViewIsVisible(searchHeaderTextView);
        assertThat(searchHeaderTextView.getText().toString(), equalTo(getString(R.string.SEARCH_HEADER)));
    }

    @Test
    public void shouldHaveRecyclerView() throws Exception {
        assertViewIsVisible(spellSearchRecyclerView);
    }
}