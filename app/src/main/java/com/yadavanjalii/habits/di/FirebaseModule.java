package com.yadavanjalii.habits.di;

import static com.yadavanjalii.habits.utils.Constants.CREDITS;
import static com.yadavanjalii.habits.utils.Constants.DASHBOARD;
import static com.yadavanjalii.habits.utils.Constants.STRUCTURE;
import static com.yadavanjalii.habits.utils.Constants.USERS;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 14/05/2022 5:13 PM
 */


@Module
@InstallIn(SingletonComponent.class)
public class FirebaseModule {

    @Provides
    public FirebaseFirestore providesFirebaseFirestore() {
        return FirebaseFirestore.getInstance();
    }

    @Provides
    public FirebaseDatabase providesFirebaseDb() {
        return FirebaseDatabase.getInstance();
    }


    @Provides
    @Named(CREDITS)
    public static CollectionReference providesCredits(FirebaseFirestore db) {
        return db.collection(CREDITS);
    }

    @Provides
    @Named(STRUCTURE)
    public static CollectionReference providesStructure(FirebaseFirestore db){
        return db.collection(STRUCTURE);
    }

    @Provides
    @Named(DASHBOARD)
    public static CollectionReference providesDashBoardItems(FirebaseFirestore db) {
        return db.collection(DASHBOARD);
    }

    @Provides
    @Named(USERS)
    public static CollectionReference providesUsers(FirebaseFirestore db) {
        return db.collection(USERS);
    }


}
