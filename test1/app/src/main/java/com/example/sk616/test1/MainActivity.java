package com.example.sk616.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.cakebutton);
        button2=(Button)findViewById(R.id.kidsbutton);
        button3=(Button)findViewById(R.id.creedbutton);
        button1=(Button)findViewById(R.id.cakebutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent2);
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent2);
            }

        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent3);
            }

        });


    }
}
