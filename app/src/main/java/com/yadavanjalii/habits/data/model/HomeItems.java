package com.yadavanjalii.habits.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(tableName = "dashboard_items")
public class HomeItems implements Serializable {
    public String title;
    public String iconUrl;
    public String description;
    public String sequence;
    public Boolean active;

    @PrimaryKey
    @NonNull
    public String id;
    public String status;
}
