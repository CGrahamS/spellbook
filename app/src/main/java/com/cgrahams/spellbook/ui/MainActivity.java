package com.cgrahams.spellbook.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cgrahams.spellbook.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.mainHeaderTextView)
    TextView mMainHeaderTextView;
    @Bind(R.id.mainSearchButton)
    Button mMainSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mMainSearchButton) {
            Intent intent = new Intent(MainActivity.this, SpellSearchActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}


//TODO Build MainActivity
//TODO Build SpellSearchActivity
//TODO Write testing for navigation between MainA and SearchA
//TODO Build SpellSearchFragment
//TODO Write testing for fragment to load into activity
//TODO Build database for spells
//TODO Write testing for selections in SearchA
//TODO Build SpellSavedActivity
//TODO Write testing for navigation between SpellSavedA