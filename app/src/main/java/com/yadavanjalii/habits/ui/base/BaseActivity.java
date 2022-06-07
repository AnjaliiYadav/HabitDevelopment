package com.yadavanjalii.habits.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 15/05/2022 1:41 PM
 */
public abstract class BaseActivity<D extends ViewDataBinding> extends AppCompatActivity {

    protected D binding;

    void initBinding() {
        binding = getBinding();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initBinding();
        setContentView(binding.getRoot());

    }

    public abstract D getBinding();
}
