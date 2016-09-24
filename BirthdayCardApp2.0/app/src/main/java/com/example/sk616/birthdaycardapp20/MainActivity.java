package com.example.sk616.birthdaycardapp20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button launchButton;
    private EditText nameEditText1,nameEditText2;
    private String enteredData1,enteredData2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchButton=(Button)findViewById(R.id.button);
        nameEditText1=(EditText) findViewById(R.id.editText1);
        nameEditText2=(EditText) findViewById(R.id.editText2);
        launchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                enteredData1 = nameEditText1.getText().toString();
                enteredData2 = nameEditText2.getText().toString();
                Intent intent1=new Intent(getApplicationContext(),Main2Activity.class);
                intent1.putExtra("custom_tag1",enteredData1);
                intent1.putExtra("custom_tag2",enteredData2);
                startActivity(intent1);
            }
        });


    }
}
