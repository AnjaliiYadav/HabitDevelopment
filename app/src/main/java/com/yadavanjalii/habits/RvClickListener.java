package com.yadavanjalii.habits;

import android.view.View;

import com.yadavanjalii.habits.adapter.GlobalAdapter;


public interface RvClickListener<T> {
    void click(View view, T item, int position, GlobalAdapter<T> adapter);
}
