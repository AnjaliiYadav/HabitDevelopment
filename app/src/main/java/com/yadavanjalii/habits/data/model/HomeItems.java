package com.yadavanjalii.habits.data.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HomeItems implements Serializable {
    private String title;
    private String iconUrl;
    private String description;
    private String sequence;
    private Boolean active;
    private String id;
    private String status;
}
