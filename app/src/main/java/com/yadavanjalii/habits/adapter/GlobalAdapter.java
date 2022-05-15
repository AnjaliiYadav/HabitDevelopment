package com.yadavanjalii.habits.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.yadavanjalii.habits.RvClickListener;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 14/05/2022 4:23 PM
 */
public class GlobalAdapter<T> extends RecyclerView.Adapter<GlobalAdapter.ViewHolder> {
    private final int layoutID;
    private final ArrayList<T> list;
    private final int br;
    private final RvClickListener<T> clickListener;
    private final HashMap<Integer, T> brs;
    private ViewDataBinding binding;

    public GlobalAdapter(int layoutID, ArrayList<T> list, int br, RvClickListener<T> clickListener, HashMap<Integer, T> brs) {
        this.layoutID = layoutID;
        this.list = list;
        this.br = br;
        this.clickListener = clickListener;
        this.brs = brs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),layoutID, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setVariable(br, list.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());

        }
    }
}
