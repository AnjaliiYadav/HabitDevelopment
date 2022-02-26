package com.yadavanjalii.habits.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yadavanjalii.habits.R;
import com.yadavanjalii.habits.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}