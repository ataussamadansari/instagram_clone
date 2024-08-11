package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.LoginFilter;
import android.widget.TextView;

import com.example.instagramclone.Login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    public TextView textView;
    String a = "Instagram Clone";
    int index = 0;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textView = findViewById(R.id.appName);


        aTextTyping();

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }, 3000);
    }

    public void aTextTyping() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index < a.length()) {
                    textView.append(String.valueOf(a.charAt(index)));
                    index++;
                    aTextTyping();
                }
            }
        }, 100);
    }
}