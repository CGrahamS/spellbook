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
    TextView mSpellName;
    TextView mSpellLevel;
    TextView mSpellSchool;
    TextView mSpellRitual;
    TextView mSpellCastingTime;
    TextView mSpellRange;
    TextView mSpellComponents;
    TextView mSpellDuration;
    TextView mSpellDescription;
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
        mSpellName = (TextView) view.findViewById(R.id.spellDetailName);
        mSpellLevel = (TextView) view.findViewById(R.id.spellDetailLevel);
        mSpellSchool = (TextView) view.findViewById(R.id.spellDetailSchool);
        mSpellRitual = (TextView) view.findViewById(R.id.spellDetailRitual);
        mSpellCastingTime = (TextView) view.findViewById(R.id.spellDetailCastingTime);
        mSpellRange = (TextView) view.findViewById(R.id.spellDetailRange);
        mSpellComponents = (TextView) view.findViewById(R.id.spellDetailComponents);
        mSpellDuration = (TextView) view.findViewById(R.id.spellDetailDuration);
        mSpellDescription = (TextView) view.findViewById(R.id.spellDetailDescription);

        mSpellName.setText(mSpell.getName());
        mSpellLevel.setText(Integer.toString(mSpell.getLevel()));
        mSpellSchool.setText(mSpell.getSchool());
        mSpellRitual.setText(Boolean.toString(mSpell.isRitual()));
        mSpellCastingTime.setText(mSpell.getCastingTime());
        mSpellRange.setText(mSpell.getRange());
        mSpellComponents.setText(mSpell.getComponents());
        mSpellDuration.setText(mSpell.getDuration());
        mSpellDescription.setText(mSpell.getDescription());
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
