package com.yadavanjalii.habits.ui.base;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yadavanjalii.habits.data.Resource;
import com.yadavanjalii.habits.data.model.Structure;
import com.yadavanjalii.habits.data.repos.RemoteRepos;

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


    private final RemoteRepos remoteRepos;
    private CompositeDisposable disposable = new CompositeDisposable();


    private MutableLiveData<Resource<List<Structure>>> structures = new MutableLiveData<>();

    @Inject
    public BaseViewModel(RemoteRepos remoteRepos) {
        this.remoteRepos = remoteRepos;
        loadStructure();
    }

    private void loadStructure() {
        remoteRepos.getStructures()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Resource<List<Structure>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Resource<List<Structure>> listResource) {
                        Log.d("Dashboard", "ViewModel getStructure listResource: " + listResource.data.get(0));
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

   /* public void loadStructure() {
        Log.d("Dashboard", "loadStructure: inside viewModel");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = remoteRepos.getStructures().
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listResource -> {
                    Log.d("Dashboard", "loadStructure: 1 " + listResource);
                    getStructure().postValue(listResource);
                });

        compositeDisposable.add(disposable);
        compositeDisposable.dispose();

    }*/

    public MutableLiveData<Resource<List<Structure>>> getStructure() {
        Log.d("Dashboard", "ViewModel getStructure: " + structures);
        return structures;
    }


}
