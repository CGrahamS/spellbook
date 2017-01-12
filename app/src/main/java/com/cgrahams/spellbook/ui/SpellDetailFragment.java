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
import org.w3c.dom.Text;

import java.util.ArrayList;

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
    private ArrayList<Spell> mSpells;
    private int mPosition;

    public SpellDetailFragment() {
        // Required empty public constructor
    }

    public static SpellDetailFragment newInstance(ArrayList<Spell> spells, Integer position) {
        SpellDetailFragment spellDetailFragment = new SpellDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("spells", Parcels.wrap(spells));
        args.putInt("position", position);
        spellDetailFragment.setArguments(args);
        return spellDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSpells = Parcels.unwrap(getArguments().getParcelable("spells"));
        mPosition = getArguments().getInt("position");
        mSpell = mSpells.get(mPosition);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spell_detail, container, false);
        mSpellDetailName = (TextView) getActivity().findViewById(R.id.spellDetailName);
        mSpellDetailName.setText(mSpell.getName());
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static SpellDetailFragment newInstance() {
        return new SpellDetailFragment();
    }

}
