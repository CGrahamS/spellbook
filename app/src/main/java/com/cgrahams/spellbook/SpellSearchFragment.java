package com.cgrahams.spellbook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpellSearchFragment extends Fragment {


    public SpellSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spell_search, container);
        return view;
    }

    public static SpellSearchFragment newInstance() {
        return new SpellSearchFragment();
    }
}
