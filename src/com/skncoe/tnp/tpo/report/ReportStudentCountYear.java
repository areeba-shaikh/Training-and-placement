/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.tpo.report;

public class ReportStudentCountYear {

    private Integer studentCount;
    private String year;

    public ReportStudentCountYear(Integer cnt, String acad) {
        this.studentCount = cnt;
        this.year = acad;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public String getyear() {
        return year;
    }
}
