package com.cgrahams.spellbook.support;

import com.cgrahams.spellbook.R;

import org.robolectric.RuntimeEnvironment;

/**
 * Created by CGrahamS on 12/19/16.
 */
public class ResourceLocator {

    public static String getString( int stringId ) {
        return RuntimeEnvironment.application.getString(stringId);
    }
}
