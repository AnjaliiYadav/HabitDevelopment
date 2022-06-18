package com.yadavanjalii.habits.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.yadavanjalii.habits.data.model.HomeItems;
import com.yadavanjalii.habits.data.repos.LocalRepos;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DashboardViewModel extends ViewModel {
    private final LocalRepos localRepos;

    @Inject
    public DashboardViewModel(LocalRepos localRepos) {
        this.localRepos = localRepos;
    }


    public LiveData<List<HomeItems>> getItems(){
        return localRepos.getItems();
    }
}
