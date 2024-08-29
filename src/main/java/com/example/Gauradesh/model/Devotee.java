package com.example.Gauradesh.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Devotee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int devoteeId;
    private String devoteeName;
    private int devoteeAge;
    private String devoteeNationality;
    private boolean isDevoteeInitiated;
    private String devoteeImageName;
    private String devoteeImageType;
    @Lob
    private byte[] devoteeImageData;

//    public Devotee(int devoteeId, String devoteeName, int devoteeAge, String devoteeNationality, boolean isDevoteeInitiated) {
//        this.devoteeId = devoteeId;
//        this.devoteeName = devoteeName;
//        this.devoteeAge = devoteeAge;
//        this.devoteeNationality = devoteeNationality;
//        this.isDevoteeInitiated = isDevoteeInitiated;
//    }
//
//    public Devotee() {
//    }
//
//    public int getDevoteeId() {
//        return devoteeId;
//    }
//
//    public void setDevoteeId(int devoteeId) {
//        this.devoteeId = devoteeId;
//    }
//
//    public String getDevoteeName() {
//        return devoteeName;
//    }
//
//    public void setDevoteeName(String devoteeName) {
//        this.devoteeName = devoteeName;
//    }
//
//    public int getDevoteeAge() {
//        return devoteeAge;
//    }
//
//    public void setDevoteeAge(int devoteeAge) {
//        this.devoteeAge = devoteeAge;
//    }
//
//    public String getDevoteeNationality() {
//        return devoteeNationality;
//    }
//
//    public void setDevoteeNationality(String devoteeNationality) {
//        this.devoteeNationality = devoteeNationality;
//    }
//
//    public boolean isDevoteeInitiated() {
//        return isDevoteeInitiated;
//    }
//
//    public void setDevoteeInitiated(boolean devoteeInitiated) {
//        isDevoteeInitiated = devoteeInitiated;
//    }
//
//    @Override
//    public String toString() {
//        return "Devotee{" +
//                "devoteeId=" + devoteeId +
//                ", devoteeName='" + devoteeName + '\'' +
//                ", devoteeAge=" + devoteeAge +
//                ", devoteeNationality='" + devoteeNationality + '\'' +
//                ", isDevoteeInitiated=" + isDevoteeInitiated +
//                '}';
//    }
}
