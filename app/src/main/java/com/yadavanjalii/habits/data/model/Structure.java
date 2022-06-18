package com.yadavanjalii.habits.data.model;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 26-May-22 12:09 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Keep
@Entity(tableName = "structure")
public class Structure implements Serializable {
    @PrimaryKey
    @NonNull
    public String ID;
    public String tableName;
    public String version;
    public String lastUpdate;
    public Boolean active;

}
