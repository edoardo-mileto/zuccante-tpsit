package com.example.andreadattero.tris;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Match extends Activity {

    protected TextView vittoriaText;
    private Tris tris;
    protected boolean vittoria=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        vittoriaText=findViewById(R.id.testo);
        tris = new Tris(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void buttonTris(View view){
        if(!vittoria) {
            tris.clickPlayer(view);
            view.setEnabled(false);
            ((ImageButton) view).setImageResource(R.drawable.circle);
            tris.checkPlayerVictory(new Intent(this,Match.class));
        }
    }



    public void home(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

}