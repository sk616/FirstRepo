package com.example.sk616.magicbutton;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button magicButton;
    private TextView text;
    private EditText enterText;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        magicButton=(Button)findViewById(R.id.magicButton);
        enterText=(EditText)findViewById(R.id.enterText);
        text=(TextView)findViewById(R.id.text);
        magicButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                input = enterText.getText().toString();
                text.setText(input);
            }
    });




    }
}