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

public class Register extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText3);//name
        e2=(EditText)findViewById(R.id.editText4);//passwd
        e3=(EditText)findViewById(R.id.editText5);//email
        e4=(EditText)findViewById(R.id.editText6);//city
        e5=(EditText)findViewById(R.id.editText7);//phone
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Register.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5=e5.getText().toString();
                if(s1.equals("") || s2.equals("")|| s3.equals("") || s4.equals("")|| s5.equals(""))
                {
                    Toast.makeText(Register.this, "Plese fill all the fields.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data= openOrCreateDatabase("projectx",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists akash (name varchar,password varchar,email varchar,city varchar,phone varchar)");
                    String s6 = "select * from akash where name ='"+s1+"'";
                    Cursor cursor = data.rawQuery(s6,null);//null is store if it doesnt run
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Register.this, "User already Exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        data.execSQL("insert into akash values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
                        Toast.makeText(Register.this, "User Registered Successfully. You can log in now.", Toast.LENGTH_SHORT).show();
                        Intent j= new Intent(Register.this,MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
}
