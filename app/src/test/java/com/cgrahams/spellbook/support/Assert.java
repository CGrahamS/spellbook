package com.cgrahams.spellbook.support;

import android.view.View;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by CGrahamS on 12/19/16.
 */
public class Assert {

    public static void assertViewIsVisible(View view) {
        assertNotNull(view);
        assertThat(view.getVisibility(), equalTo(View.VISIBLE));
    }
}
