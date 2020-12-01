package com.skncoe.tnp.models;

public class PlacedStudent {

    private Integer candidateID;
    private Integer studentID;
    private String company;
    private String designation;
    private String packageOffered;
    private Integer scheduleID;
    private String name;

    public PlacedStudent(int candidateID, String fullName, String companyName,
            String designation, String packageOffered, int scheduleID,
            int studentID) {
        this.candidateID = candidateID;
        this.company = companyName;
        this.studentID = studentID;
        this.designation = designation;
        this.packageOffered = packageOffered;
        this.scheduleID = scheduleID;
        this.name = fullName;

    }

    public Integer getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Integer candidateID) {
        this.candidateID = candidateID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPackageOffered() {
        return packageOffered;
    }

    public void setPackageOffered(String packageOffered) {
        this.packageOffered = packageOffered;
    }

    public Integer getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
