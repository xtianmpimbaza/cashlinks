package com.cashlinks.cashlinks;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BanksActivity extends AppCompatActivity {

    @OnClick(R.id.tx_centenary)
    void addBank(View view) {
        Intent i = new Intent(BanksActivity.this, SaveActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.tx_equity)
    void addEquity(View view) {
        Intent i = new Intent(BanksActivity.this, SaveActivity.class);
        startActivity(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banks);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent i = new Intent(BanksActivity.this, AddBankActivity.class);
                startActivity(i);

            }
        });
    }

}
