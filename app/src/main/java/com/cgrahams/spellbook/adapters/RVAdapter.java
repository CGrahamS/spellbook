package com.cgrahams.spellbook.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.model.Spell;

/**
 * Created by CGrahamS on 12/22/16.
 */
public class RVAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    //Sample Spells
    Spell acidSplash = new Spell("Acid Splash", 1);
    Spell aid = new Spell("Aid", 1);
    Spell alarm = new Spell("Alarm", 1);
    Spell alterSelf = new Spell("Alter Self", 1);
    Spell animalFriendship = new Spell("Animal Friendship", 1);

    //Sample spell list
    Spell[] spells = new Spell[] {acidSplash, aid, alarm, alterSelf, animalFriendship };

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spell_list_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.bindSpell(spells[position]);
    }

    @Override
    public int getItemCount() {
        return spells.length;
    }
}
