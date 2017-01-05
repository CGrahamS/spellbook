package com.cgrahams.spellbook.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.model.Spell;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by CGrahamS on 1/3/17.
 */

public class FirebaseSpellViewHolder extends RecyclerView.ViewHolder {

    private View mView;
    private Context mContext;

    public FirebaseSpellViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindSpell(Spell spell) {
        TextView spellNameTextView = (TextView) mView.findViewById(R.id.spellNameTextView);
        TextView spellLevelTextView = (TextView) mView.findViewById(R.id.spellLevelTextView);
        TextView spellRitualTextView = (TextView) mView.findViewById(R.id.spellRitualTextView);

        spellNameTextView.setText(spell.getName());

        //Add spell level if not a cantrip
        if (spell.getLevel() == 0) {
            spellLevelTextView.setText("| Cantrip");
        } else {
            spellLevelTextView.setText("| Level " + Integer.toString(spell.getLevel()));
        }

        //Add ritual text if ritual
        if (spell.isRitual() == true) {
            spellRitualTextView.setText("| Ritual");
        } else {
            spellRitualTextView.setText(null);
        }
    }

//    @Override
//    public void onClick(View view) {
//        final ArrayList<Spell> spells = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Spells");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot spellSnapshot :
//                        dataSnapshot.getChildren()) {
//                    spells.add(spellSnapshot.getValue(Spell.class));
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }

}
