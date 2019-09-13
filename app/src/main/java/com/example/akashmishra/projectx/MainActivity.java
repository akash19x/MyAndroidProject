package com.example.akashmishra.projectx;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b2=(Button)findViewById(R.id.button2);
        b1=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,Register.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data= openOrCreateDatabase("projectx",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists akash (name varchar,password varchar,email varchar,city varchar,phone varchar)");
                    String s4 = "select * from akash where name ='"+s1+"' and password ='"+s2+"'";
                    Cursor cursor = data.rawQuery(s4,null);//null is store if it doesnt run
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(MainActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(MainActivity.this,HomePage.class);
                        startActivity(j);
                        finish();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Unsuccessful Login! Try Again.", Toast.LENGTH_SHORT).show();
                        Intent k = new Intent(MainActivity.this,Register.class);
                        startActivity(k);
                        finish();;
                    }
                }
            }
        });
    }
}
