package com.yadavanjalii.habits.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.yadavanjalii.habits.R;
import com.yadavanjalii.habits.databinding.DashboardClass;
import com.yadavanjalii.habits.ui.base.BaseFragment;
import com.yadavanjalii.habits.ui.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DashboardFragment extends BaseFragment<DashboardClass, DashboardViewModel> {



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Dashboard", "onViewCreated: ");

    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected Class<DashboardViewModel> getViewModel() {
        return DashboardViewModel.class;
    }


}