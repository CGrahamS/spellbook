package com.cgrahams.spellbook.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cgrahams.spellbook.Constants;
import com.cgrahams.spellbook.Util;
import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.adapters.FirebaseSpellViewHolder;
import com.cgrahams.spellbook.adapters.SpellListAdapter;
import com.cgrahams.spellbook.model.Spell;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class SpellSearchFragment extends Fragment {
    public static final String TAG = SpellSearchFragment.class.getSimpleName();

    private TextView mSearchFragmentHeaderTextView;
    private RecyclerView mSpellSearchRecyclerView;

    private View view;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Query query;
    private String queryParameter = null;
    Util mDatabaseInstance = Util.getInstance();
    FirebaseDatabase mDatabase = mDatabaseInstance.getDatabase();

    public SpellSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(getActivity());
        query = mDatabase
                .getReference(Constants.SPELL_REF_KEY);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_spell_search, container);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mSearchFragmentHeaderTextView = (TextView) view.findViewById(R.id.searchFragmentHeaderTextView);
        mSpellSearchRecyclerView = (RecyclerView) view.findViewById(R.id.spellSearchRecyclerView);
        setUpFirebaseAdapter(query);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String searchQuery) {
//                if (spell.getName() != null && spell.getName().toLowerCase().contains(queryParameter.toLowerCase())) {
//                    mSpells.add(spell);
//                    spellList.setSpells(mSpells);
//                    notifyDataSetChanged();
//                }
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Spell> spellList = mDatabaseInstance.getSpells();
                for (Spell spell : spellList) {
                    if (spell.getName() != null && spell.getName().toLowerCase().contains(newText.toLowerCase())) {
                        Log.d(TAG, "onQueryTextChange: " + spell.getName());
                    }
                }
                return false;
            }
        });
    }

    private void setUpFirebaseAdapter(final Query query) {

        mFirebaseAdapter = new SpellListAdapter(Spell.class, R.layout.spell_list_item,
                FirebaseSpellViewHolder.class, query, getActivity());
        mSpellSearchRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mSpellSearchRecyclerView.setHasFixedSize(true);
        mSpellSearchRecyclerView.setLayoutManager(mLayoutManager);
        mSpellSearchRecyclerView.setAdapter(mFirebaseAdapter);

        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                super.onItemRangeChanged(positionStart, itemCount);
                mFirebaseAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    public static SpellSearchFragment newInstance() {
        return new SpellSearchFragment();
    }
}
