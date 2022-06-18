package com.yadavanjalii.habits.ui.home;

import android.util.Log;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.yadavanjalii.habits.R;
import com.yadavanjalii.habits.data.model.Structure;
import com.yadavanjalii.habits.databinding.HomeClass;
import com.yadavanjalii.habits.ui.base.BaseActivity;
import com.yadavanjalii.habits.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity<HomeClass> {
    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar toolbar;
    public BaseViewModel baseViewModel;
    private NavController navController;

    @Override
    protected void onStart() {
        super.onStart();
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        setActionToolbarToggleEvent();
        setAppbarConfig();
        setNavController();
        initViewModel();

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

    private void initViewModel(){
        baseViewModel = new ViewModelProvider(this).get(BaseViewModel.class);
        baseViewModel.getStructures().observe(this, result ->{

        });
    }
    
    private void navigate(String id){
        

    }
    private void setNavController(){
        try {
            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragment_container);

            assert navHostFragment != null;
            navController = navHostFragment.getNavController();

        }catch (Exception e){

        }
    }
}