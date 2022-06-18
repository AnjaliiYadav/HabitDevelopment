package com.yadavanjalii.habits.data.repos;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yadavanjalii.habits.data.local.db.AppDb;
import com.yadavanjalii.habits.data.model.HomeItems;
import com.yadavanjalii.habits.data.model.Structure;
import com.yadavanjalii.habits.data.model.Users;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class LocalRepos {

    private final AppDb db;

    @Inject
    public LocalRepos(AppDb appDb) {
        this.db = appDb;
    }

    public void insert(Users data){
        db.userDao().insert(data);
    }

    public void update(Users data){
        db.userDao().update(data);
    }

    public void delete(Users data){
        db.userDao().delete(data);
    }

    public LiveData<List<Users>> getUsers(){
       return db.userDao().getUsers();
    }

    public void insert(Structure data){
        db.structureDao().insert(data);
    }

    public void update(Structure data){
        db.structureDao().update(data);
    }

    public void delete(Structure data){
        db.structureDao().delete(data);
    }

    public LiveData<List<Structure>> getStructures(){
        return db.structureDao().getAll();
    }

    public void insert(HomeItems data){
        db.itemsDao().insert(data);
    }

    public void update(HomeItems data){
        db.itemsDao().update(data);
    }

    public void delete(HomeItems data){
        db.itemsDao().delete(data);
    }

    public LiveData<List<HomeItems>> getItems(){
        return db.itemsDao().getItems();
    }
}
