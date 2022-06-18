package com.yadavanjalii.habits.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.yadavanjalii.habits.data.model.Structure;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import kotlinx.coroutines.flow.Flow;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 13-Jun-22 11:59 PM
 */

@Dao
public interface StructureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Structure structure);

    @Update
    void update(Structure structure);

    @Delete
    void delete(Structure structure);

    @Query("SELECT * FROM STRUCTURE")
    LiveData<List<Structure>> getAll();

    //LiveData<Structure> getByID();
}

