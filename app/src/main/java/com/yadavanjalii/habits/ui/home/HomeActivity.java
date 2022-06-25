package com.yadavanjalii.habits.ui.home;

import android.util.Log;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
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

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_dashboard)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

       /* setAppbarConfig();
        setActionToolbarToggleEvent();
        setNavController();*/
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

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setAppbarConfig() {

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
        NavController navController = navHostFragment.getNavController();
        NavigationView navView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navView, navController);

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setDrawerLayout(binding.drawerLayout)
                        .build();

       /* NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        mAppBarConfiguration = new AppBarConfiguration
                .Builder()
                .setOpenableLayout(binding.drawerLayout)
                .build();


       *//*AppBarConfiguration appBarConfiguration =
               new AppBarConfiguration.Builder(navController.getGraph()).build();
       Toolbar toolbar = findViewById(R.id.toolbar);*//*
        NavigationUI.setupWithNavController(binding.toolbar, navController, mAppBarConfiguration);*/

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
    

    private void setNavController(){

    }
}