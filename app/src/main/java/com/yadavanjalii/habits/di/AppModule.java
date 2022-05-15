package com.yadavanjalii.habits.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
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
    public Context provideContext(Application application){
        return application.getApplicationContext();
    }
}
