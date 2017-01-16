package com.cgrahams.spellbook.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cgrahams.spellbook.GlobalSpellList;
import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.model.Spell;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    TextView mMainHeaderTextView;
    Button mMainSearchButton;
    GlobalSpellList spellList;
    ArrayList<Spell> mSpells = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainSearchButton = (Button) findViewById(R.id.mainSearchButton);
        mMainSearchButton.setOnClickListener(this);

//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        DatabaseReference spellsRef = FirebaseDatabase.getInstance().getReference().child("Spells");
//        spellsRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                mSpells.add(dataSnapshot.getValue(Spell.class));
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        if (v == mMainSearchButton) {
            Intent intent = new Intent(MainActivity.this, SpellSearchActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}


//TODO Build MainActivity
//TODO Build SpellSearchActivity
//TODO Write testing for navigation between MainA and SearchA
//TODO Build SpellSearchFragment
//TODO Write testing for fragment to load into activity
//TODO Build database for spells
//TODO Write testing for selections in SearchA
//TODO Build SpellSavedActivity
//TODO Write testing for navigation between SpellSavedA