package com.rku_18fotca11001.tutorial04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{
    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edtuser);
        password = findViewById(R.id.edtpassword);
        login = findViewById(R.id.btnlogin);
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= 26)
                {
                    vibrator.vibrate(VibrationEffect.createOneShot( 50, VibrationEffect.DEFAULT_AMPLITUDE));
                   // vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                else
                {
                    vibrator.vibrate(50);
                }
                String valusername = username.getText().toString();
                String valpassword = password.getText().toString();
                if (valusername.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Username can not be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (valpassword.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Password can not be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (valpassword.length()< 4 )
                {
                    Toast.makeText(MainActivity.this,"Password length should be 6",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(valusername).matches())
                {
                    Toast.makeText(MainActivity.this,"Email-Address can't be identify",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(valusername.equals("admin@gmail.com")&& valpassword.equals("admin"))
                {
                    Intent intent = new Intent(MainActivity.this, Welcome.class);
                    intent.putExtra("Welcome",username.getText().toString());
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
                    finish();

                }else
                {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}