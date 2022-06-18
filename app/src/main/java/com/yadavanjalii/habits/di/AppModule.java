package com.yadavanjalii.habits.di;

import android.app.Application;
import android.content.Context;

import com.yadavanjalii.habits.data.local.dao.HomeItemsDao;
import com.yadavanjalii.habits.data.local.dao.StructureDao;
import com.yadavanjalii.habits.data.local.dao.UserDao;
import com.yadavanjalii.habits.data.local.db.AppDb;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 14/05/2022 5:12 PM
 */
@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public Context provideContext(Application application) {
        return application.getApplicationContext();
    }


    @Provides
    public AppDb providesLocalDb(Application app) {
        return AppDb.getInstance(app);
    }

    @Provides
    public UserDao providesUserDao(AppDb db) {
        return db.userDao();
    }

    @Provides
    public StructureDao providesStructureDao(AppDb db) {
        return db.structureDao();
    }

    @Provides
    public HomeItemsDao providesHomeItemsDao(AppDb db) {
        return db.itemsDao();
    }
}
