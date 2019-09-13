package com.example.akashmishra.projectx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {
    TextView t1;
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        t1=(TextView)findViewById(R.id.textView10);
        b1=(Button)findViewById(R.id.button33);
        b2=(Button)findViewById(R.id.button30);
        b3=(Button)findViewById(R.id.button31);
        b4=(Button)findViewById(R.id.button32);
        t1.setText("Your Score is : "+Quiz1.score);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(QuizResult.this,HomePage.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Intent.ACTION_SEND);
                j.setType("text/plain");
                String sbody="Your Score is : "+Quiz1.score;
                String ssub="Online App Quiz";
                j.putExtra(Intent.EXTRA_SUBJECT,ssub);
                j.putExtra(Intent.EXTRA_TEXT,sbody);
                startActivity(Intent.createChooser(j,"Share Using : "));
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Intent.ACTION_SEND);
                k.setType("text/plain");
                String sbody="Your Score is : "+Quiz1.score;
                String ssub="Online App Quiz";
                k.putExtra(Intent.EXTRA_SUBJECT,ssub);
                k.putExtra(Intent.EXTRA_TEXT,sbody);
                startActivity(Intent.createChooser(k,"Share Using : "));
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(Intent.ACTION_SEND);
                l.setType("text/plain");
                String sbody="Your Score is : "+Quiz1.score;
                String ssub="Online App Quiz";
                l.putExtra(Intent.EXTRA_SUBJECT,ssub);
                l.putExtra(Intent.EXTRA_TEXT,sbody);
                startActivity(Intent.createChooser(l,"Share Using : "));
                finish();
            }
        });
    }
}
