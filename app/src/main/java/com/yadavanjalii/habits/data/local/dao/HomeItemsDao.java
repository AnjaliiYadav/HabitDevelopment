package com.yadavanjalii.habits.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.yadavanjalii.habits.data.model.HomeItems;

import java.util.List;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 16-Jun-22 7:19 PM
 */
@Dao
public interface HomeItemsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HomeItems items);

    @Update
    void update(HomeItems items);

    @Delete
    void delete(HomeItems items);

    @Query("SELECT * FROM DASHBOARD_ITEMS")
    LiveData<List<HomeItems>> getItems();
}
