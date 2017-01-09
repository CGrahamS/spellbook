package com.cgrahams.spellbook.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.model.Spell;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpellDetailFragment extends Fragment {
    /** ButterKnife Code **/
    TextView mSpellDetailName;
    TextView mSpellDetailLevel;
    TextView mSpellDetailSchool;
    TextView mSpellDetailRitual;
    TextView mSpellDetailCastingTime;
    TextView mSpellDetailRange;
    TextView mSpellDetailComponents;
    TextView mSpellDetailDuration;
    TextView mSpellDetailDescription;
    Button mAddToSpellbookButton;

    private Spell mSpell;

    public SpellDetailFragment() {
        // Required empty public constructor
    }

    public static SpellDetailFragment newInstance(Spell spell) {
        SpellDetailFragment spellDetailFragment = new SpellDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("spell", Parcels.wrap(spell));
        spellDetailFragment.setArguments(args);
        return spellDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSpell = Parcels.unwrap(getArguments().getParcelable("spell"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spell_detail, container, false);
    }

}
