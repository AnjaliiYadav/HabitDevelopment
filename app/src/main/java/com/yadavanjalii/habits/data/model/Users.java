package com.yadavanjalii.habits.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 10/05/2022 12:08 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Users implements Serializable {
    @PrimaryKey
    @NonNull
    public int id;
    public String uid;
    public String name;
    public String pwd;
    public String email;
    public String createdAt;
    public String photoUrl;
}
