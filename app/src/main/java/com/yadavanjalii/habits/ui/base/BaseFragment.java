package com.yadavanjalii.habits.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseFragment<D extends ViewDataBinding, V extends ViewModel> extends Fragment {

    protected D dataBinding;
    protected V viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return dataBinding.getRoot();
        //viewModel = new ViewModelProvider(this).get(getViewModel());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dataBinding = null;
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract Class<V> getViewModel();
}
