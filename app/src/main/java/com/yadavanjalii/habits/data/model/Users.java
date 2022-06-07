package com.yadavanjalii.habits.data.model;

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
 * @date 10/05/2022 12:08 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Users implements Serializable {
    private int id;
    private String uid;
    private String name;
    private String pwd;
    private String email;
    private String createdAt;
    private String photoUrl;
}
