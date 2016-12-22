package com.cgrahams.spellbook.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.model.Spell;

/**
 * Created by CGrahamS on 12/22/16.
 */
public class SimpleViewHolder extends RecyclerView.ViewHolder {

    TextView spellNameTextView;
    TextView spellLevelTextView;

    public SimpleViewHolder(View itemView) {
        super(itemView);
        spellNameTextView = (TextView) itemView.findViewById(R.id.spellNameTextView);
        spellLevelTextView = (TextView) itemView.findViewById(R.id.spellLevelTextView);
    }

    public void bindSpell(Spell spell) {
        spellNameTextView.setText(spell.getName());
        spellLevelTextView.setText(Integer.toString(spell.getLevel()));
    }
}
