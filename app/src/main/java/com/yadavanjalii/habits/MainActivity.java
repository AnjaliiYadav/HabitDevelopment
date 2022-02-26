package com.yadavanjalii.habits;

import static android.view.animation.AnimationUtils.loadAnimation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;

import com.yadavanjalii.habits.databinding.ActivityMainBinding;
import com.yadavanjalii.habits.home.HomeActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Animation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        animateRocket();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        },4000);
    }

    private void animateRocket() {
        rotateAnimation = loadAnimation(this, R.anim.rotate_animation);
        binding.logo.setAnimation(rotateAnimation);
    }
}