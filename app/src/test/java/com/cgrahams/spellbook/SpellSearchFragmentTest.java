package com.cgrahams.spellbook;

import android.os.Build;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowListView;
import org.robolectric.shadows.ShadowLog;

import static com.cgrahams.spellbook.support.Assert.assertViewIsVisible;
import static com.cgrahams.spellbook.support.ResourceLocator.getString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;


@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class SpellSearchFragmentTest {
    private final SpellSearchFragment fragment = new SpellSearchFragment();
    TextView searchHeaderTextView;
    ListView spellSearchListView;

    @Before
    public void setUp() throws Exception {
        startFragment(fragment);
        searchHeaderTextView = (TextView) fragment.getView().findViewById(R.id.searchFragmentHeaderTextView);
        spellSearchListView = (ListView) fragment.getView().findViewById(R.id.spellSearchListView);
        ShadowLog.stream = System.out;
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
    public void shouldHaveListView() throws Exception {
        assertNotNull(spellSearchListView);
        ShadowListView shadowListView = shadowOf(spellSearchListView);
        shadowListView.populateItems();
        shadowListView.getHeaderViews();
        assertViewIsVisible(spellSearchListView);
    }


}