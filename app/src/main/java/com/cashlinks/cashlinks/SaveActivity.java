package com.cashlinks.cashlinks;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crowdfire.cfalertdialog.CFAlertDialog;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SaveActivity extends AppCompatActivity {

    @OnClick(R.id.btn_send)
    void addBank(View view) {

        onAccept();
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

    }

    void onAccept(){
        final CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                .setTitle("DONE")
                .setIcon(getResources().getDrawable(R.drawable.ic_complete))
                .setMessage("Saved (assumption)");
        builder.show();

//        Intent intent = new Intent(SaveActivity.this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
    }
}
