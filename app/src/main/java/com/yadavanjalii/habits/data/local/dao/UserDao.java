package com.yadavanjalii.habits.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yadavanjalii.habits.data.model.Users;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 13-Jun-22 11:59 PM
 */

@Dao
public interface UserDao {
    @Insert
    void insert(Users users);

    @Update
    void update(Users users);

    @Delete
    void delete (Users users);

    @Query("SELECT * FROM USERS")
    LiveData<List<Users>> getUsers();

}
