package com.cgrahams.spellbook.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cgrahams.spellbook.Constants;
import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.model.Spell;
import com.cgrahams.spellbook.ui.SpellDetailActivity;

import java.util.ArrayList;

/**
 * Created by CGrahamS on 1/19/17.
 */

public class SpellQueryAdapter extends RecyclerView.Adapter<SpellQueryAdapter.SpellViewHolder>{
    public static final String TAG = SpellQueryAdapter.class.getSimpleName();

    private ArrayList<Spell> mSpells = new ArrayList<>();
    private Context mContext;
    private String mOrigin;

    public SpellQueryAdapter(Context context, ArrayList<Spell> spells) {
        mContext = context;
        mSpells = spells;
        mOrigin = SpellQueryAdapter.class.getSimpleName();
    }

    @Override
    public SpellQueryAdapter.SpellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spell_list_item, parent, false);
        SpellViewHolder viewHolder = new SpellViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final SpellQueryAdapter.SpellViewHolder holder, int position) {
        holder.bindSpell(mSpells.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SpellDetailActivity.class);
                intent.putExtra(Constants.ORIGIN_KEY, mOrigin);
                intent.putExtra(Constants.POSITION_KEY, holder.getAdapterPosition());
                mContext.startActivity(intent);
            }
        });
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
                spellLevelTextView.setText("Cantrip");
            } else {
                spellLevelTextView.setText("Level " + Integer.toString(spell.getLevel()));
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
