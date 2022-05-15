package com.yadavanjalii.habits.data.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.yadavanjalii.habits.data.model.*;

import javax.inject.Singleton;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 15/05/2022 5:23 PM
 */

@Database(entities = {Users.class}, version = 1, exportSchema = false)
public abstract class AppDb extends RoomDatabase {
    private static final String DB ="HabitDb";

    @Singleton
    public static AppDb getInstance(final Context context){
        return Room.databaseBuilder(context, AppDb.class, DB)
                .allowMainThreadQueries()
                .build();
    }
}
