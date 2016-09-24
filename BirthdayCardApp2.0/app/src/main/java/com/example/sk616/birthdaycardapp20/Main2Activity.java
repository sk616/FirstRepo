package com.example.sk616.birthdaycardapp20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String bname;
    String fro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView bbname=(TextView)findViewById(R.id.text1);
        TextView from=(TextView)findViewById(R.id.text3);
        Bundle bundle=getIntent().getExtras();
        bname=bundle.getString("custom_tag1");
        fro=bundle.getString("custom_tag2");
        bbname.setText(bname);
        from.setText(fro);

    }
}
