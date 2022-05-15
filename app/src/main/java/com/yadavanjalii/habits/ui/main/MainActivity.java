package com.yadavanjalii.habits.ui.main;

import static android.view.animation.AnimationUtils.loadAnimation;

import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;

import com.yadavanjalii.habits.R;
import com.yadavanjalii.habits.databinding.MainClass;
import com.yadavanjalii.habits.ui.base.BaseActivity;
import com.yadavanjalii.habits.ui.home.HomeActivity;

import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<MainClass> {

    Animation rotateAnimation;

    @Override
    protected void onStart() {
        super.onStart();
        Objects.requireNonNull(getSupportActionBar()).hide();

        animateRocket();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }, 3000);
    }

    @Override
    public MainClass getBinding() {
        return MainClass.inflate(getLayoutInflater());
    }

    private void animateRocket() {
        rotateAnimation = loadAnimation(this, R.anim.rotate_animation);
        binding.logo.setAnimation(rotateAnimation);
    }
}