package com.cgrahams.spellbook.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cgrahams.spellbook.model.Spell;
import com.cgrahams.spellbook.ui.SpellDetailFragment;

import java.util.ArrayList;

/**
 * Created by CGrahamS on 1/9/17.
 */

public class SpellPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Spell> mSpells;

    public SpellPagerAdapter(FragmentManager fm, ArrayList<Spell> spells) {
        super(fm);
        mSpells = spells;
    }


    @Override
    public Fragment getItem(int position) {
        return SpellDetailFragment.newInstance(mSpells, position);
    }

    @Override
    public int getCount() {
        return mSpells.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSpells.get(position).getName();
    }
}
