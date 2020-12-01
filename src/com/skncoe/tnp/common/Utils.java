/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JLabel;

/**
 *
 * @author Areeba
 */
public class Utils {

    public static Vector getCompaniesList(int departmentId) {

        String query1 = "select distinct(co_name) from schedule_company_view,TPO where TPO.d_id= '"
                + departmentId + "' and active=1 and TPO.tpo_id = schedule_company_view.tpo_id";

        Statement st;
        ResultSet rs;
        Vector companies = new Vector();
        try {
            Connection conn = MySqlConnect.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query1);

            while (rs.next()) {
                companies.add(rs.getString("co_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    public static Vector getCompaniesList() {

        String query1 = "select distinct(co_name) from company";

        Statement st;
        ResultSet rs;
        Vector companies = new Vector();
        try {
            Connection conn = MySqlConnect.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query1);

            while (rs.next()) {
                companies.add(rs.getString("co_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    public static boolean isValidCGPA(String cgpa, JLabel label) {
        boolean isValid = true;
        if (cgpa.length() == 0) {
            label.setText("CGPA is required");
            isValid = false;
        } else {
            double cgpaDouble = Double.parseDouble(cgpa);
            if (cgpaDouble < 0.0 || cgpaDouble > 10) {
                label.setText("Should be between 0 to 10");
                isValid = false;
            }
        }
        if (!isValid) {
            label.setVisible(true);
        } else {
            label.setVisible(false);
        }

        return isValid;

    }

    public static int getDeptID(String selectedDepartment) {
        String query1 = "SELECT d_id FROM department WHERE dep_name='" + selectedDepartment + "'";
        int departmentId = 0;

        Statement st;
        ResultSet rs;
        try {
            Connection conn = MySqlConnect.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query1);

            while (rs.next()) {
                departmentId = rs.getInt("d_id");
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentId;

    }

    public static String getDeptName(int deptID) {
        String query1 = "SELECT dep_name FROM department WHERE d_id='" + deptID + "'";
        String departmentName = "";

        Statement st;
        ResultSet rs;
        try {
            Connection conn = MySqlConnect.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query1);

            while (rs.next()) {
                departmentName = rs.getString("dep_name");
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentName;

    }
}
