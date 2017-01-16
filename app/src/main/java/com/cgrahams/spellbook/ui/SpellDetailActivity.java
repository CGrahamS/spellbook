package com.cgrahams.spellbook.ui;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cgrahams.spellbook.GlobalSpellList;
import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.adapters.SpellPagerAdapter;
import com.cgrahams.spellbook.model.Spell;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

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
        GlobalSpellList spellList = GlobalSpellList.getInstance();
        mSpells = spellList.getSpells();

//        mSpells = Parcels.unwrap(getIntent().getParcelableExtra("spells"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new SpellPagerAdapter(getSupportFragmentManager(), mSpells);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
