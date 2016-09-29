package com.example.sk616.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3;

    private TextView text1,text2;
    private int s;
    private String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.minusbutton);
        button2=(Button)findViewById(R.id.plusbutton);
        button3=(Button)findViewById(R.id.orderbutton);
        text1=(TextView)findViewById(R.id.noofCups);
        text2=(TextView)findViewById(R.id.price);
        s=0;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s>0) {
                    --s;
                    s1=Integer.toString(s);
                    text1.setText(s1);
                }


            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText(""+(++s));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(""+(10*s));
            }
        });
    }
}
