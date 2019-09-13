package com.example.akashmishra.projectx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpecialFunctions extends AppCompatActivity {
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_functions);

        b1=(Button)findViewById(R.id.button22);
        b2=(Button)findViewById(R.id.button23);
        b3=(Button)findViewById(R.id.button24);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SpecialFunctions.this,HomePage.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(SpecialFunctions.this,Quiz1.class);
                startActivity(j);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(SpecialFunctions.this,MagicMusic.class);
                startActivity(j);
                finish();
            }
        });


    }
}
