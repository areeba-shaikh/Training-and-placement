/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.models;

public class AppearingStudent {
    private Integer applicationID;
    private Integer scheduleID;
    private String company;
    private String studentFullName;
    private String date;

    public AppearingStudent(Integer applicationID, Integer scheduleID, String company, String studentFullName, String date) {
        this.applicationID = applicationID;
        this.scheduleID = scheduleID;
        this.company = company;
        this.studentFullName = studentFullName;
        this.date = date;
    }

    public Integer getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Integer applicationID) {
        this.applicationID = applicationID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }
    
    
    
        

    
}
