package com.yadavanjalii.habits.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.yadavanjalii.habits.data.model.HomeModel;
import com.yadavanjalii.habits.data.model.Users;
/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 14/05/2022 4:13 PM
 */
@Dao
public interface HomeDao {
    @Insert
    void insert(HomeModel model);

    @Update
    void update(HomeModel model);

    @Delete
    void delete(HomeModel model);

}
