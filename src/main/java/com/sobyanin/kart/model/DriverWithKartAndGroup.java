package com.sobyanin.kart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverWithKartAndGroup {

    private String driver;

    private String kartQualification;

    private String kartRace;

    private Integer group;

    public DriverWithKartAndGroup(String driver) {
        this.driver = driver;
    }
}
