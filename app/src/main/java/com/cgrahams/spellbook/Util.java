package com.cgrahams.spellbook;

import com.cgrahams.spellbook.model.Spell;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by CGrahamS on 1/14/17.
 */

public class Util {
    public static final String TAG = Util.class.getSimpleName();
    private static Util instance;
    private static FirebaseDatabase mDatabase;
    ArrayList<Spell> mSpells = new ArrayList<>();

    public ArrayList<Spell> getSpells() {
        return mSpells;
    }

    private Util(){}

    public void setSpells(ArrayList<Spell> mSpells) {
        this.mSpells = mSpells;
    }

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }

    public static synchronized Util getInstance() {
        if(instance == null ) {
            instance=new Util();
        }
        return instance;
    }

}
