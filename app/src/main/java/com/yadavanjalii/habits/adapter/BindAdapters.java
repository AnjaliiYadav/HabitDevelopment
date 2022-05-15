package com.yadavanjalii.habits.adapter;


import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yadavanjalii.habits.BR;
import com.yadavanjalii.habits.RvClickListener;
import com.yadavanjalii.habits.utils.Helper;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 14/05/2022 5:10 PM
 */
public class BindAdapters {
    @BindingAdapter({"layout", "list", "click"})
    public static <T> void setRecyclerView(RecyclerView view, Integer layout, @Nullable ArrayList<T> list, RvClickListener click) {
        try {
            if (list != null) {
                HashMap<Integer, T> brs = new HashMap<>();
                brs.put(BR.itemclick, list.get(BR.itemclick));

                GlobalAdapter adapter = new GlobalAdapter(layout, list, BR.model, click, brs);
                view.setAdapter(adapter);
            }
        } catch (Exception e) {
            Helper.debug(e.getMessage());
        }
    }

    @BindingAdapter("imageUrl")
    public static void setSrc(ImageView view, @Nullable String url){
        Picasso.get().load(url).fit().into(view);
    }
}
