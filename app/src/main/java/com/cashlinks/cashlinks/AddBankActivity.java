package com.cashlinks.cashlinks;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crowdfire.cfalertdialog.CFAlertDialog;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddBankActivity extends AppCompatActivity {

    @OnClick(R.id.btn_save_bank)
    void bankTxs(View view) {
        confirm();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Create new bank", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    void confirm(){
        final CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                .setTitle("Error")
                .setIcon(getResources().getDrawable(R.drawable.ic_failed))
                .setMessage("This is a demo. Bank cant be added")
                .addButton("Retry", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        onAccept();
                    }
                })
                .addButton("Cancel", -1, -1, CFAlertDialog.CFAlertActionStyle.NEGATIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        onReject();
                    }
                });
        builder.show();
    }

    void onAccept(){
        final CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                .setTitle("DONE")
                .setIcon(getResources().getDrawable(R.drawable.ic_complete))
                .setMessage("Bank saved (assumption)");
        builder.show();
    }

    void onReject(){
        final CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                .setTitle("Canceled")
                .setIcon(getResources().getDrawable(R.drawable.ic_failed))
                .setMessage("Bank creation canceled");
        builder.show();
    }


}
