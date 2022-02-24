package com.thales.empmgmt.model;

import com.thales.empmgmt.util.EncryptPassword;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

public class Employee {

    private String bucket;

    private String tgi;

    private String city;

    private String designation;

    private String firstName;

    private String house_number;

    private LocalDate joiningDate;

    private String lastName;

    private String locality;

    private String manager;

    private String password;

    private String phoneNumber;

    private Map<String, String> skillSet;

    private String state;

    private String yearsOfExperience;

    public Employee() {
    }

    public Employee(String bucket, String tgi, String city, String designation, String firstName, String house_number, LocalDate joiningDate, String lastName,
                    String locality, String manager, String password, String phoneNumber, Map<String, String> skillSet, String state, String yearsOfExperience) {
        this.bucket = bucket;
        this.tgi = tgi;
        this.city = city;
        this.designation = designation;
        this.firstName = firstName;
        this.house_number = house_number;
        this.joiningDate = joiningDate;
        this.lastName = lastName;
        this.locality = locality;
        this.manager = manager;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.skillSet = skillSet;
        this.state = state;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getTgi() {
        return tgi;
    }

    public void setTgi(String tgi) {
        this.tgi = tgi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPassword() {

        return password.substring(0,20);
    }

    public void setPassword(String password) {

        EncryptPassword encryptPassword = new EncryptPassword();
        this.password =  encryptPassword.encryptString(password);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Map<String, String> skillSet) {
        this.skillSet = skillSet;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}

