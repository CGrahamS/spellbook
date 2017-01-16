package com.cgrahams.spellbook.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cgrahams.spellbook.Util;
import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.adapters.SpellPagerAdapter;
import com.cgrahams.spellbook.model.Spell;

import java.util.ArrayList;

public class SpellDetailActivity extends AppCompatActivity {
    public static final String TAG = SpellDetailActivity.class.getSimpleName();

    ViewPager mViewPager;
    private SpellPagerAdapter adapterViewPager;
    ArrayList<Spell> mSpells = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_detail);
        mViewPager = (ViewPager) findViewById(R.id.spellDetailViewPager);
        Util spellList = Util.getInstance();
        mSpells = spellList.getSpells();

        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new SpellPagerAdapter(getSupportFragmentManager(), mSpells);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
