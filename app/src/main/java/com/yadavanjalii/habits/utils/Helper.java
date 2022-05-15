package com.yadavanjalii.habits.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 10/05/2022 4:25 PM
 */
public class Helper {

    public static void toastLong(String message, Context context){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void toast(String message, Context context){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void debug(String message){
        Log.d(Constants.TAG, message);
    }
}
