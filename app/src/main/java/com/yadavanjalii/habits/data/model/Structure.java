package com.yadavanjalii.habits.data.model;

import androidx.annotation.Keep;
import androidx.room.Entity;

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
public class Structure implements Serializable {
    public String ID;
    public String tableName;
    public String version;
    public String lastUpdate;
    public Boolean active;

}
