package com.yadavanjalii.habits.adapter;


import static com.yadavanjalii.habits.utils.Constants.TAG;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.rpc.Help;
import com.squareup.picasso.Picasso;
import com.yadavanjalii.habits.BR;
import com.yadavanjalii.habits.RvClickListener;
import com.yadavanjalii.habits.utils.Helper;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

import kotlin.jvm.JvmStatic;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 14/05/2022 5:10 PM
 */
public class BindAdapters {
    @JvmStatic
    @BindingAdapter({"layout", "list", "click"})
    public static <T> void setRecyclerView(RecyclerView view, Integer layout, @Nullable ArrayList<T> list, RvClickListener click) {
        try {
            Helper.debug("*************************************************** ");
            if (list != null) {
                HashMap<Integer, RvClickListener<T>> brs = new HashMap<>();
                brs.put(BR.itemclick, click);

                GlobalAdapter<T> adapter = new GlobalAdapter<T>(layout, list, BR.model, click, brs);
                view.setAdapter(adapter);
            }
        } catch (Exception e) {
            Helper.debug(" inside error " + e.getMessage());
        }
    }

    @BindingAdapter("imageUrl")
    public static void setSrc(ImageView view, @Nullable String url) {
        Picasso.get().load(url).fit().into(view);
    }
}
