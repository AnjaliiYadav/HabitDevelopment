package com.yadavanjalii.habits.ui.home;

import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;

import com.yadavanjalii.habits.R;
import com.yadavanjalii.habits.databinding.HomeClass;
import com.yadavanjalii.habits.ui.base.BaseActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity<HomeClass> {
    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar toolbar;

    @Override
    protected void onStart() {
        super.onStart();
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        setActionToolbarToggleEvent();
        setAppbarConfig();
    }

    @Override
    public HomeClass getBinding() {
        return HomeClass.inflate(getLayoutInflater());
    }

    private void setActionToolbarToggleEvent() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    private void setAppbarConfig() {
        mAppBarConfiguration = new AppBarConfiguration.Builder()
                .setOpenableLayout(binding.drawerLayout)
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}