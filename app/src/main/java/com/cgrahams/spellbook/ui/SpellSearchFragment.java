package com.cgrahams.spellbook.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cgrahams.spellbook.R;
import com.cgrahams.spellbook.adapters.FirebaseSpellViewHolder;
import com.cgrahams.spellbook.model.Spell;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SpellSearchFragment extends Fragment {
    public static final String TAG = SpellSearchFragment.class.getSimpleName();

    private TextView mSearchFragmentHeaderTextView;
    private RecyclerView mSpellSearchRecyclerView;

    private View view;
    private DatabaseReference mSpellRef;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public SpellSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_spell_search, container);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSearchFragmentHeaderTextView = (TextView) view.findViewById(R.id.searchFragmentHeaderTextView);
        mSpellSearchRecyclerView = (RecyclerView) view.findViewById(R.id.spellSearchRecyclerView);
        //Added in order To pass robolectric tests
        FirebaseApp.initializeApp(getActivity());

        mSpellRef = FirebaseDatabase.getInstance().getReference().child("Spells");
        mSpellRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot spellSnapshot :
                        dataSnapshot.getChildren()) {
                    String spell = spellSnapshot.getValue().toString();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Spell, FirebaseSpellViewHolder>
                (Spell.class, R.layout.spell_list_item, FirebaseSpellViewHolder.class, mSpellRef) {
            @Override
            protected void populateViewHolder(FirebaseSpellViewHolder viewHolder, Spell model, int position) {
                viewHolder.bindSpell(model);
            }
        };
        mSpellSearchRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mSpellSearchRecyclerView.setHasFixedSize(true);
        mSpellSearchRecyclerView.setLayoutManager(mLayoutManager);
        mSpellSearchRecyclerView.setAdapter(mFirebaseAdapter);
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
