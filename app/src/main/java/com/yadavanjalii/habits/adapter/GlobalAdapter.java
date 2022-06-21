package com.yadavanjalii.habits.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.yadavanjalii.habits.utils.Constants.TAG;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.yadavanjalii.habits.RvClickListener;
import com.yadavanjalii.habits.utils.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 14/05/2022 4:23 PM
 */
public class GlobalAdapter<T> extends RecyclerView.Adapter<GlobalAdapter.ViewHolder> {
    private final int layoutID;
    private final ArrayList<T> list;
    private int br;
    private final RvClickListener<T> clickListener;
    private final HashMap<Integer, RvClickListener<T>> brs;
    private ViewDataBinding binding;

    public GlobalAdapter(int layoutID, ArrayList<T> list, int br, RvClickListener<T> clickListener, HashMap<Integer, RvClickListener<T>> brs) {
        this.layoutID = layoutID;
        this.list = list;
        this.br = br;
        this.clickListener = clickListener;
        this.brs = brs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutID, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            holder.binding.setVariable(br, list.get(holder.getAdapterPosition()));

            for (Map.Entry<Integer,  RvClickListener<T>> entry : brs.entrySet()) {
                binding.setVariable(entry.getKey(), entry.getValue());
            }

            holder.binding.setVariable(BR.click, (View.OnClickListener) view -> {
                clickListener.click(view, list.get(holder.getAdapterPosition()),
                      holder.getAdapterPosition(), this);
            });

            holder.binding.executePendingBindings();

        } catch (NullPointerException e) {
            Helper.debug("ERROR onBindViewHolder: " + e.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding= binding;

        }
    }
}
