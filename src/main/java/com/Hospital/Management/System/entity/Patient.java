package com.Hospital.Management.System.entity;

import jakarta.persistence.*;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name")
    private String name;
    @Column(name = "age")
    private String age;
    @Column(name = "blood_group")
    private String blood;
    @Column(name = "prescription")
    private String prescription;
    @Column(name = "dose")
    private String dose;
    @Column(name = "fees")
    private String fees;
    @Column(name = "urgency")
    private String urgency;

    public Patient() {
        super();
    }

    public Patient(long id, String name, String age, String blood, String prescription, String dose, String fees, String urgency) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.blood = blood;
        this.prescription = prescription;
        this.dose = dose;
        this.fees = fees;
        this.urgency = urgency;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getBlood() {
        return blood;
    }

    public String getPrescription() {
        return prescription;
    }

    public String getDose() {
        return dose;
    }

    public String getFees() {
        return fees;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
}
