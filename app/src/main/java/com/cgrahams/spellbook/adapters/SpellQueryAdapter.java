package com.cgrahams.spellbook.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.model.Spell;

import java.util.ArrayList;

/**
 * Created by CGrahamS on 1/19/17.
 */

public class SpellQueryAdapter extends RecyclerView.Adapter<SpellQueryAdapter.SpellViewHolder>{
    private ArrayList<Spell> mSpells = new ArrayList<>();
    private Context mContext;

    public SpellQueryAdapter(Context context, ArrayList<Spell> spells) {
        mContext = context;
        mSpells = spells;
    }

    @Override
    public SpellQueryAdapter.SpellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spell_list_item, parent, false);
        SpellViewHolder viewHolder = new SpellViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SpellQueryAdapter.SpellViewHolder holder, int position) {
        holder.bindSpell(mSpells.get(position));
    }

    @Override
    public int getItemCount() {
        return mSpells.size();
    }

    public class SpellViewHolder extends RecyclerView.ViewHolder {

        public SpellViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
        }

        public void bindSpell(Spell spell) {
            TextView spellNameTextView = (TextView) itemView.findViewById(R.id.spellNameTextView);
            TextView spellLevelTextView = (TextView) itemView.findViewById(R.id.spellLevelTextView);
            TextView spellRitualTextView = (TextView) itemView.findViewById(R.id.spellRitualTextView);


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
    }
}
