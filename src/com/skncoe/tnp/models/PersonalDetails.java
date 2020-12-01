/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.models;

public class PersonalDetails {

    String email = "", mobileNo = "", firstName = "", middleName = "",
            lastName = "", dateOfBirth = "", gender = "", username = "", absolutePathPhoto;

    public PersonalDetails(String firstName, String middleName, String lastName,
            String email, String mobileNo, String gender,
            String dateOfBirth, String absolutePathPhoto) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.absolutePathPhoto = absolutePathPhoto;
    }

    public String getAbsolutePathPhoto() {
        return absolutePathPhoto;
    }

    public void setAbsolutePathPhoto(String absolutePathPhoto) {
        this.absolutePathPhoto = absolutePathPhoto;
    }

    public PersonalDetails() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
