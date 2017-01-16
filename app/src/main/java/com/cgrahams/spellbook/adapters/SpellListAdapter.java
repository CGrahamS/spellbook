package com.cgrahams.spellbook.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.cgrahams.spellbook.Util;
import com.cgrahams.spellbook.model.Spell;
import com.cgrahams.spellbook.ui.SpellDetailActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;


import java.util.ArrayList;

/**
 * Created by CGrahamS on 1/11/17.
 */

public class SpellListAdapter extends FirebaseRecyclerAdapter<Spell, FirebaseSpellViewHolder> {
    public static final String TAG = SpellListAdapter.class.getSimpleName();
    
    private DatabaseReference mRef;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Spell> mSpells = new ArrayList<>();

    public SpellListAdapter(Class<Spell> modelClass, int modelLayout,
                                   Class<FirebaseSpellViewHolder> viewHolderClass,
                                   Query ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mContext = context;
        final Util spellList = Util.getInstance();

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mSpells.add(dataSnapshot.getValue(Spell.class));
                spellList.setSpells(mSpells);
            }

            //TODO add handler for updating spells
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    protected void populateViewHolder(final FirebaseSpellViewHolder viewHolder, Spell model, int position) {
        viewHolder.bindSpell(model);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SpellDetailActivity.class);
                intent.putExtra("position", viewHolder.getAdapterPosition());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void cleanup() {
        super.cleanup();
        mRef.removeEventListener(mChildEventListener);
    }

}
