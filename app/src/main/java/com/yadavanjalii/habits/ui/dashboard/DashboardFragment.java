package com.yadavanjalii.habits.ui.dashboard;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.yadavanjalii.habits.R;
import com.yadavanjalii.habits.RvClickListener;
import com.yadavanjalii.habits.data.model.HomeItems;
import com.yadavanjalii.habits.data.model.HomeModel;
import com.yadavanjalii.habits.databinding.DashboardClass;
import com.yadavanjalii.habits.ui.base.BaseFragment;
import com.yadavanjalii.habits.utils.Helper;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DashboardFragment extends BaseFragment<DashboardClass, DashboardViewModel> implements
View.OnClickListener{
    HomeModel model = new HomeModel();
    private RvClickListener<HomeModel> fragmentClickListener;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        setListeners();
        setAdapters();
        displayItems();

    }


    private void displayItems() {
        viewModel.getItems().observe(getViewLifecycleOwner(), result ->{
            List<HomeItems> items =  result;
            model.items = (ArrayList<HomeItems>) items;
            Helper.debug(model.items.stream().sequential().toString());
            setAdapters();
        });
    }



    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected Class<DashboardViewModel> getViewModel() {
        return DashboardViewModel.class;
    }


    @Override
    public void onClick(View view) {

    }

    private void setAdapters(){
        try {
            dataBinding.setModel(model);
            dataBinding.setClick(this);
            dataBinding.setItemclick(fragmentClickListener);

        }catch (Exception e){
            Helper.debug(e.getMessage());
        }
    }

    private void setListeners(){
        fragmentClickListener = (view, item, position, adapter) -> {
            //todo: switch based on item clicked

        };
    }
}