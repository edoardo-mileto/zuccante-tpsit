package com.example.studente.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String PASSWORD="1234";

        TextView passwd=findViewById(R.id.passwd);


        clickListener(findViewById(R.id.uno),PASSWORD);
        clickListener(findViewById(R.id.due),PASSWORD);
        clickListener(findViewById(R.id.tre),PASSWORD);
        clickListener(findViewById(R.id.quattro),PASSWORD);
        clickListener(findViewById(R.id.cinque),PASSWORD);
        clickListener(findViewById(R.id.sei),PASSWORD);
        clickListener(findViewById(R.id.sette),PASSWORD);
        clickListener(findViewById(R.id.otto),PASSWORD);
        clickListener(findViewById(R.id.nove),PASSWORD);
        clickListener(findViewById(R.id.zero),PASSWORD);

        Button del = findViewById(R.id.del);
        del.setOnClickListener((View view) -> {
            if(passwd.getText().toString().length()!=0) {
                passwd.setText(passwd.getText().toString().substring(0, passwd.length() - 1));
                passwd.setTextColor(getResources().getColor(R.color.red));
            }
        });

        Button ok = findViewById(R.id.OK);
        Intent i = new Intent(this,ActivityTwo.class);
        ok.setOnClickListener((View view) -> {
            if(passwd.getText().toString().equals(PASSWORD))
               startActivity(i);
            else
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show();
        });

    }

    public void clickListener(Button b,String p){

        final String PASSWORD=p;

        TextView passwd=findViewById(R.id.passwd);

        b.setOnClickListener((View view) -> {
            passwd.setText(passwd.getText().toString()+b.getText());
            if(passwd.getText().toString().equals(PASSWORD))
                passwd.setTextColor(getResources().getColor(R.color.green));
            else
                passwd.setTextColor(getResources().getColor(R.color.red));
        });
    }
}
