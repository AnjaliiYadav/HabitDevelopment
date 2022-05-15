package com.yadavanjalii.habits.ui.challenges;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yadavanjalii.habits.R;
import com.yadavanjalii.habits.databinding.FragmentChallengesBinding;

public class ChallengesFragment extends Fragment {

    FragmentChallengesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChallengesBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }


}