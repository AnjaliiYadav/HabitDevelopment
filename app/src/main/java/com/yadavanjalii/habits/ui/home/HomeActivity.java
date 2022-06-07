package com.yadavanjalii.habits.ui.home;

import android.util.Log;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
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

    @Override
    protected void onStart() {
        super.onStart();
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        Log.d("Dashboard", "onStart: Home1");
        setActionToolbarToggleEvent();
        setAppbarConfig();

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

        baseViewModel.getStructure().observe(this, result ->{

            assert result.data != null;
            List<Structure> temp = result.data;
            Log.d("Dashboard", "initViewModel: "+ temp.get(1).toString()  );

            Log.d("Dashboard", "initViewModel: "+result.data.get(0).ID);
            Log.d("Dashboard", "initViewModel: "+result.data.get(0).lastUpdate);
            Log.d("Dashboard", "initViewModel: "+result.data.get(0).tableName);
            Log.d("Dashboard", "initViewModel: "+result.data.get(0).version);
            Log.d("Dashboard", "initViewModel: "+result.data.get(0).active);

        });
    }
}