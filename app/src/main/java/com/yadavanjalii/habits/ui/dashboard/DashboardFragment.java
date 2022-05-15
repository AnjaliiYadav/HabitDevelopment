package com.yadavanjalii.habits.ui.dashboard;

import com.yadavanjalii.habits.R;
import com.yadavanjalii.habits.databinding.DashboardClass;
import com.yadavanjalii.habits.ui.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DashboardFragment extends BaseFragment<DashboardClass, DashboardViewModel> {
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected Class<DashboardViewModel> getViewModel() {
        return DashboardViewModel.class;
    }

}