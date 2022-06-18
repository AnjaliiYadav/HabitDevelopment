package com.yadavanjalii.habits.data.model;

import androidx.room.Entity;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HomeModel implements Serializable {
    public ArrayList<HomeItems> items;

    public HomeModel() {
        this.items = new ArrayList<>();
    }

}
