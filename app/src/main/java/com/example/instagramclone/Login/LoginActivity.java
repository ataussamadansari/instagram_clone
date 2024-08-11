package com.example.instagramclone.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instagramclone.MainActivity;
import com.example.instagramclone.R;
import com.example.instagramclone.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    String a = "Instagram Clone", b = "from Atappsy";
    int index = 0;
    Handler handler;
    boolean isInstText = true;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        handler = new Handler();

        Animation animation;
        animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        binding.blinkLine.setAnimation(animation);

        aTextTyping();

        //button
        binding.button.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }


    private void aTextTyping() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index < a.length()) {
                    binding.marqueeTV.append(String.valueOf(a.charAt(index)));
                    index++;
                    aTextTyping();
                } else {
                    removeTyping();
                }
            }
        }, 100);
    }

    private void bTextTyping() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index < b.length()) {
                    binding.marqueeTV.append(String.valueOf(b.charAt(index)));
                    index++;
                    bTextTyping();
                } else {
                    removeTyping();
                }
            }
        }, 100);
    }


    private void removeTyping() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isInstText) {
                    if (index > 0) {
                        binding.marqueeTV.setText(a.substring(0, index-1));
                        index--;
                        removeTyping();
                    } else {
                        bTextTyping();
                        isInstText = false;
                    }
                } else {
                    if (index > 0) {
                        binding.marqueeTV.setText(b.substring(0, index-1));
                        index--;
                        removeTyping();
                    } else {
                        aTextTyping();
                        isInstText = true;
                    }
                }

            }
        }, 100);

    }

}