package com.yadavanjalii.habits.data.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.yadavanjalii.habits.data.local.dao.HomeItemsDao;
import com.yadavanjalii.habits.data.local.dao.StructureDao;
import com.yadavanjalii.habits.data.local.dao.UserDao;
import com.yadavanjalii.habits.data.model.*;

import javax.inject.Singleton;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 15/05/2022 5:23 PM
 */

@Database(entities = {Users.class, Structure.class, HomeItems.class}, version = 1, exportSchema = false)
public abstract class AppDb extends RoomDatabase {
    private static final String DB ="HabitDb";
    public abstract UserDao userDao();
    public abstract StructureDao structureDao();
    public abstract HomeItemsDao itemsDao();

    @Singleton
    public static AppDb getInstance(final Context context){
        return Room.databaseBuilder(context, AppDb.class, DB)
                .allowMainThreadQueries()
                .build();
    }
}
