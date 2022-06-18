package com.yadavanjalii.habits.ui.base;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yadavanjalii.habits.data.Resource;
import com.yadavanjalii.habits.data.model.HomeItems;
import com.yadavanjalii.habits.data.model.Structure;
import com.yadavanjalii.habits.data.repos.CommonRepos;
import com.yadavanjalii.habits.data.repos.LocalRepos;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 28-May-22 1:04 AM
 */

@HiltViewModel
public class BaseViewModel extends ViewModel {


    private final CommonRepos commonRepos;
    private final LocalRepos localRepos;
    private CompositeDisposable disposable = new CompositeDisposable();


    private MutableLiveData<Resource<List<Structure>>> structures = new MutableLiveData<>();

    @Inject
    public BaseViewModel(CommonRepos remoteRepos, LocalRepos localRepos) {
        this.commonRepos = remoteRepos;
        this.localRepos = localRepos;
        loadStructure();
        loadDashboard();
    }

    private void loadStructure() {
        commonRepos.getStructures()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Resource<List<Structure>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Resource<List<Structure>> listResource) {
                        insertStructure(listResource.data);
                        structures.postValue(listResource);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void loadDashboard(){
        commonRepos.getDashboardItems()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new Observer<Resource<List<HomeItems>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Resource<List<HomeItems>> listResource) {
                        assert listResource.data != null;
                        insertDashboardItems(listResource.data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void insertDashboardItems(List<HomeItems> data) {
        for (HomeItems item :
                data) {
            localRepos.insert(item);

        };
    }


    private void insertStructure(List<Structure> list) {
        try {
            for (Structure data :
                    list) {
                localRepos.insert(data);
            }
        } catch (Exception e) {
            Log.d("Dashboard", "insertStructure: " + e.getMessage());
        }
    }

    public MutableLiveData<Resource<List<Structure>>> getStructure() {
        return structures;
    }

    public LiveData<List<Structure>> getStructures() {
        return localRepos.getStructures();
    }




}
