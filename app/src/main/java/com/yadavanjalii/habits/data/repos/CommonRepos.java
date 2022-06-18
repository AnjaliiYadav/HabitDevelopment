package com.yadavanjalii.habits.data.repos;

import static com.yadavanjalii.habits.utils.Constants.CREDITS;
import static com.yadavanjalii.habits.utils.Constants.DASHBOARD;
import static com.yadavanjalii.habits.utils.Constants.STRUCTURE;
import static com.yadavanjalii.habits.utils.Constants.USERS;

import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.yadavanjalii.habits.data.Resource;
import com.yadavanjalii.habits.data.model.HomeItems;
import com.yadavanjalii.habits.data.model.Structure;
import com.yadavanjalii.habits.data.model.Users;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.Observable;
@Singleton
public class CommonRepos {

    public CollectionReference credits;
    public CollectionReference structure;
    public CollectionReference dashboard;
    public CollectionReference users;


    @Inject
    public CommonRepos(@Named(CREDITS) CollectionReference credits,
                       @Named(STRUCTURE) CollectionReference structure,
                       @Named(DASHBOARD) CollectionReference dashboard,
                       @Named(USERS) CollectionReference users) {
        this.credits = credits;
        this.structure = structure;
        this.dashboard = dashboard;
        this.users = users;
    }

    public Observable<Resource<Users>> getUserRecord(String uid) {
        return Observable.create(emitter -> {
            users.document(uid).get().addOnCompleteListener(task -> {
                DocumentSnapshot document = task.getResult();
                Users users = document.toObject(Users.class);
                emitter.onNext(Resource.success(users));
            }).addOnFailureListener(failed -> {
                emitter.onNext(Resource.error(failed.getMessage(), null));
            });
        });
    }

    public Observable<Resource<List<HomeItems>>> getDashboardItems() {
        return Observable.create(emitter -> {
            dashboard.get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    QuerySnapshot snapshot = task.getResult();
                    if (!snapshot.isEmpty()) {
                        List<HomeItems> model = snapshot.toObjects(HomeItems.class);
                        emitter.onNext(Resource.success(model));
                    }
                } else {
                    emitter.onNext(Resource.error(task.getException().getMessage(), null));
                }
            }).addOnFailureListener(failed -> {
                emitter.onNext(Resource.error(failed.getMessage(), null));
            });
        });

    }

    public Observable<Resource<List<Structure>>> getStructures() {
        return Observable.create(emitter -> {
            try {
                structure.get().addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot snapshot = task.getResult();
                        if (!snapshot.isEmpty()) {
                            List<Structure> result = snapshot.toObjects(Structure.class);
                            emitter.onNext(Resource.success(result));
                        }

                    }
                }).addOnFailureListener(failed -> {
                    emitter.onNext(Resource.error(failed.getMessage(), null));
                });
            } catch (Exception e) {
                emitter.onNext(Resource.error(e.getMessage(), null));
            }
        });
    }


}
