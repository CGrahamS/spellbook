package com.cgrahams.spellbook;

import android.app.Application;
import android.util.Log;

import com.cgrahams.spellbook.model.Spell;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by CGrahamS on 1/14/17.
 */

public class GlobalSpellList {
    public static final String TAG = GlobalSpellList.class.getSimpleName();
    private static GlobalSpellList instance;
    ArrayList<Spell> mSpells = new ArrayList<>();

    public ArrayList<Spell> getSpells() {
        return mSpells;
    }

    private GlobalSpellList(){}

    public void setSpells(ArrayList<Spell> mSpells) {
        this.mSpells = mSpells;
    }

    public static synchronized GlobalSpellList getInstance() {
        if(instance == null ) {
            instance=new GlobalSpellList();
        }
        return instance;
    }

}
