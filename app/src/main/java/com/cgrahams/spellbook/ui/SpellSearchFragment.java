package com.cgrahams.spellbook.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.adapters.RVAdapter;
import com.cgrahams.spellbook.model.Spell;

public class SpellSearchFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;

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
        mRecyclerView = (RecyclerView) view.findViewById(R.id.spellSearchRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new RVAdapter());
    }

    public static SpellSearchFragment newInstance() {
        return new SpellSearchFragment();
    }
}
