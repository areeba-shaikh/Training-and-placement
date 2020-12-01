/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.models;

public class Student {

    int studentId, isActive,
            departmentId, personId;
    double marksFirstYear, marksSecondYear, marksThirdYear;
    String username, firstName;
    String date;

    public Student(int personId, double marksFirstYear, double marksSecondYear, double marksThirdYear,
            int isActive, int departmentId, String date) {
        this.personId = personId;
        this.marksFirstYear = marksFirstYear;
        this.marksSecondYear = marksSecondYear;
        this.marksThirdYear = marksThirdYear;
        this.isActive = isActive;
        this.departmentId = departmentId;
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public Student(double marksFirstYear, double marksSecondYear, double marksThirdYear,
            int isActive, int departmentId, String date) {
        this.marksFirstYear = marksFirstYear;
        this.marksSecondYear = marksSecondYear;
        this.marksThirdYear = marksThirdYear;
        this.isActive = isActive;
        this.departmentId = departmentId;
        this.date = date;
    }

    public Student() {
        
    }
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getMarksFirstYear() {
        return marksFirstYear;
    }

    public void setMarksFirstYear(double marksFirstYear) {
        this.marksFirstYear = marksFirstYear;
    }

    public double getMarksSecondYear() {
        return marksSecondYear;
    }

    public void setMarksSecondYear(double marksSecondYear) {
        this.marksSecondYear = marksSecondYear;
    }

    public double getMarksThirdYear() {
        return marksThirdYear;
    }

    public void setMarksThirdYear(double marksThirdYear) {
        this.marksThirdYear = marksThirdYear;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
