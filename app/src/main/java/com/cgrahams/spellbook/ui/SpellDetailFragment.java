package com.cgrahams.spellbook.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cgrahams.spellbook.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpellDetailFragment extends Fragment {
    /** ButterKnife Code **/
    @BindView(R.id.spellDetailName)
    TextView mSpellDetailName;
    @BindView(R.id.spellDetailLevel)
    TextView mSpellDetailLevel;
    @BindView(R.id.spellDetailSchool)
    TextView mSpellDetailSchool;
    @BindView(R.id.spellDetailRitual)
    TextView mSpellDetailRitual;
    @BindView(R.id.spellDetailCastingTime)
    TextView mSpellDetailCastingTime;
    @BindView(R.id.spellDetailRange)
    TextView mSpellDetailRange;
    @BindView(R.id.spellDetailComponents)
    TextView mSpellDetailComponents;
    @BindView(R.id.spellDetailDuration)
    TextView mSpellDetailDuration;
    @BindView(R.id.spellDetailDescription)
    TextView mSpellDetailDescription;
    @BindView(R.id.addToSpellbookButton)
    Button mAddToSpellbookButton;
    /** ButterKnife Code **/


    public SpellDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spell_detail, container, false);
    }

}
