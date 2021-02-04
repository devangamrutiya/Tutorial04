package com.rku_18fotca11001.tutorial04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Bundle bundle = getIntent().getExtras();
        String  name = bundle.getString("Welcome");
        textView1 = findViewById(R.id.textView3);
        textView1.setText("Welcome , "+name);

    }
}