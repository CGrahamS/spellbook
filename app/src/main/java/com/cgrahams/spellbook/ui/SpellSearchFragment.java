package com.cgrahams.spellbook.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.model.Spell;

public class SpellSearchFragment extends Fragment {
    private ListView mListView;
    private View view;

    //Sample Spells
    Spell acidSplash = new Spell("Acid Splash", 1);
    Spell aid = new Spell("Aid", 1);
    Spell alarm = new Spell("Alarm", 1);
    Spell alterSelf = new Spell("Alter Self", 1);
    Spell animalFriendship = new Spell("Animal Friendship", 1);

    //Sample spell list
    Spell[] spells = new Spell[] {acidSplash, aid, alarm, alterSelf, animalFriendship };
    String[] spellNames = new String[] {acidSplash.getName(), aid.getName(), alarm.getName(), alterSelf.getName(), animalFriendship.getName()};

    public SpellSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_spell_search, container);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView = (ListView) view.findViewById(R.id.spellSearchListView);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, spellNames);
        mListView.setAdapter(adapter);
    }

    public static SpellSearchFragment newInstance() {
        return new SpellSearchFragment();
    }
}
