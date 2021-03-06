/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.student;

import com.skncoe.tnp.common.MySqlConnect;
import com.skncoe.tnp.common.Utils;
import com.skncoe.tnp.models.Schedule;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ScheduleRegistrationJFrame extends javax.swing.JFrame {

    Connection conn = MySqlConnect.getConnection();

    int studentId, departmentId;
    boolean isEligible = false;
    String scheduleDateString;
    DefaultComboBoxModel comboModel;

    public ScheduleRegistrationJFrame(int studentId, int departmentId) {
        setDefaultCloseOperation(ScheduleRegistrationJFrame.HIDE_ON_CLOSE);
        this.studentId = studentId;
        this.departmentId = departmentId;
        
        comboModel = new DefaultComboBoxModel(Utils.getCompaniesList(departmentId));
        
        initComponents();

    }

    

    public ArrayList<Schedule> getScheduleList() {
        ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();

        String getSchedulesQuery = "select * from schedule_company_view,TPO where TPO.d_id= '"
                + departmentId + "' and active=1 and TPO.tpo_id = schedule_company_view.tpo_id";

        if (companyNameDropdown.getSelectedItem().toString().length() > 0) {
            getSchedulesQuery += " and schedule_company_view.co_name = '" + companyNameDropdown.getSelectedItem().toString() + "'";
        }

        if (searchMinSalary.getText().length() > 0) {
            getSchedulesQuery += " and min_salary >= " + Integer.parseInt(searchMinSalary.getText());
        }
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(getSchedulesQuery);
            Schedule user;
            while (rs.next()) {
                user = new Schedule(rs.getInt("sch_id"),
                        rs.getDate("sch_date").toString(),
                        rs.getInt("comp_id"), rs.getString("co_name"),
                        rs.getInt("criteria"), rs.getDouble("min_salary"));

                scheduleList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    public void showScheduleTable() {

        ArrayList<Schedule> list1 = getScheduleList();
        DefaultTableModel model = (DefaultTableModel) jTableSchedules.getModel();

        for (int index = 0; index < model.getRowCount();) {
            model.removeRow(index);
        }

        Object[] row = new Object[6];
        for (int i = 0; i < list1.size(); i++) {
            row[0] = list1.get(i).getschid();
            row[1] = list1.get(i).getschdate();
            row[2] = list1.get(i).getcompid();
            row[3] = list1.get(i).getconame();
            row[4] = list1.get(i).getcriteria();
            row[5] = list1.get(i).getminsalary();

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        scheduleIdLabel = new javax.swing.JLabel();
        searchMinSalary = new javax.swing.JTextField();
        scrollPaneScheduleTable = new javax.swing.JScrollPane();
        jTableSchedules = new javax.swing.JTable();
        jLabelSearchSchedule = new javax.swing.JLabel();
        jLabelCompanyName = new javax.swing.JLabel();
        companyNameDropdown = new javax.swing.JComboBox<>();
        jLabelMinSalary = new javax.swing.JLabel();
        textFieldSchId = new javax.swing.JTextField();
        registerButtonPanel = new javax.swing.JPanel();
        jLabelRegister = new javax.swing.JLabel();
        searchButtonPanel = new javax.swing.JPanel();
        jLabelSearch = new javax.swing.JLabel();
        jSeparatorID = new javax.swing.JSeparator();
        jSeparatorMinSalary = new javax.swing.JSeparator();
        checkButtonPanel1 = new javax.swing.JPanel();
        jLabelCheck = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register for schedule");

        jPanel2.setBackground(new java.awt.Color(37, 46, 65));
        jPanel2.setLayout(null);

        scheduleIdLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        scheduleIdLabel.setForeground(java.awt.Color.white);
        scheduleIdLabel.setText("Schedule ID :");
        jPanel2.add(scheduleIdLabel);
        scheduleIdLabel.setBounds(180, 450, 130, 30);

        searchMinSalary.setBackground(new java.awt.Color(37, 46, 65));
        searchMinSalary.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        searchMinSalary.setForeground(java.awt.Color.white);
        searchMinSalary.setBorder(null);
        searchMinSalary.setCaretColor(java.awt.Color.white);
        jPanel2.add(searchMinSalary);
        searchMinSalary.setBounds(650, 60, 145, 30);

        jTableSchedules.setBackground(new java.awt.Color(36, 47, 65));
        jTableSchedules.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableSchedules.setForeground(new java.awt.Color(255, 255, 255));
        jTableSchedules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule ID", "Schedule Date", "Company ID", "Company Name", "Criteria", "Minimum Salary"
            }
        ));
        scrollPaneScheduleTable.setViewportView(jTableSchedules);

        jPanel2.add(scrollPaneScheduleTable);
        scrollPaneScheduleTable.setBounds(30, 130, 910, 280);

        jLabelSearchSchedule.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelSearchSchedule.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSearchSchedule.setText("Search schedule:");
        jPanel2.add(jLabelSearchSchedule);
        jLabelSearchSchedule.setBounds(50, 30, 270, 24);

        jLabelCompanyName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCompanyName.setForeground(java.awt.Color.white);
        jLabelCompanyName.setText("Company name: ");
        jPanel2.add(jLabelCompanyName);
        jLabelCompanyName.setBounds(50, 60, 135, 30);

        companyNameDropdown.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        companyNameDropdown.setModel(comboModel);
        companyNameDropdown.setBorder(null);
        jPanel2.add(companyNameDropdown);
        companyNameDropdown.setBounds(220, 60, 180, 28);

        jLabelMinSalary.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelMinSalary.setForeground(java.awt.Color.white);
        jLabelMinSalary.setText("Minimum salary:");
        jPanel2.add(jLabelMinSalary);
        jLabelMinSalary.setBounds(470, 60, 129, 30);

        textFieldSchId.setBackground(new java.awt.Color(37, 46, 65));
        textFieldSchId.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textFieldSchId.setForeground(java.awt.Color.white);
        textFieldSchId.setBorder(null);
        textFieldSchId.setCaretColor(java.awt.Color.white);
        jPanel2.add(textFieldSchId);
        textFieldSchId.setBounds(330, 450, 145, 30);

        registerButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        registerButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonPanelMouseClicked(evt);
            }
        });

        jLabelRegister.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabelRegister.setForeground(new java.awt.Color(36, 47, 65));
        jLabelRegister.setText("Register");

        javax.swing.GroupLayout registerButtonPanelLayout = new javax.swing.GroupLayout(registerButtonPanel);
        registerButtonPanel.setLayout(registerButtonPanelLayout);
        registerButtonPanelLayout.setHorizontalGroup(
            registerButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerButtonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelRegister)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        registerButtonPanelLayout.setVerticalGroup(
            registerButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelRegister)
                .addContainerGap())
        );

        jPanel2.add(registerButtonPanel);
        registerButtonPanel.setBounds(350, 500, 120, 50);

        searchButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        searchButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonPanelMouseClicked(evt);
            }
        });

        jLabelSearch.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabelSearch.setForeground(new java.awt.Color(36, 47, 65));
        jLabelSearch.setText("Search");

        javax.swing.GroupLayout searchButtonPanelLayout = new javax.swing.GroupLayout(searchButtonPanel);
        searchButtonPanel.setLayout(searchButtonPanelLayout);
        searchButtonPanelLayout.setHorizontalGroup(
            searchButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchButtonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchButtonPanelLayout.setVerticalGroup(
            searchButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSearch)
                .addContainerGap())
        );

        jPanel2.add(searchButtonPanel);
        searchButtonPanel.setBounds(830, 50, 100, 50);
        jPanel2.add(jSeparatorID);
        jSeparatorID.setBounds(330, 480, 150, 10);
        jPanel2.add(jSeparatorMinSalary);
        jSeparatorMinSalary.setBounds(650, 90, 150, 10);

        checkButtonPanel1.setBackground(new java.awt.Color(97, 212, 195));
        checkButtonPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkButtonPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkButtonPanel1MouseClicked(evt);
            }
        });

        jLabelCheck.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabelCheck.setForeground(new java.awt.Color(36, 47, 65));
        jLabelCheck.setText("Check my eligibility");

        javax.swing.GroupLayout checkButtonPanel1Layout = new javax.swing.GroupLayout(checkButtonPanel1);
        checkButtonPanel1.setLayout(checkButtonPanel1Layout);
        checkButtonPanel1Layout.setHorizontalGroup(
            checkButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkButtonPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelCheck)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        checkButtonPanel1Layout.setVerticalGroup(
            checkButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkButtonPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCheck)
                .addContainerGap())
        );

        jPanel2.add(checkButtonPanel1);
        checkButtonPanel1.setBounds(500, 440, 220, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerForSchedule() {
        if (isEligible) {
            String query = "Insert into appearing(stu_id,sch_id)"
                    + " values('" + studentId + "','"
                    + textFieldSchId.getText() + "')";

            Statement st = null;
            try {
                st = conn.createStatement();
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Registration successful!");
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to register", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "You're not eligible for the schedule!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private void registerButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonPanelMouseClicked
        registerForSchedule();
    }//GEN-LAST:event_registerButtonPanelMouseClicked

    private void searchButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonPanelMouseClicked
        showScheduleTable();
    }//GEN-LAST:event_searchButtonPanelMouseClicked

    private void checkButtonPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkButtonPanel1MouseClicked
        int sch_id = Integer.parseInt(textFieldSchId.getText());
        PreparedStatement pst = null;
        ResultSet rs = null;
        CallableStatement cst = null;
        try {

//            Get schedule details
            String queryGetScheduleDetails = "SELECT criteria,sch_date from schedule where sch_id='" + sch_id + "'";
            pst = conn.prepareStatement(queryGetScheduleDetails);
            rs = pst.executeQuery(queryGetScheduleDetails);
            rs.next();
            int criteria = rs.getInt(1);
            scheduleDateString = rs.getDate(2).toString();          //taking the criteria of the schedule

//            Check whether student is eligible
            String callIsEligible = "{call IsEligible(?,?,?)}";
            cst = conn.prepareCall(callIsEligible);
            cst.setInt(1, studentId);
            cst.setInt(2, criteria);
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.execute();

            int valueReturnedFromProcedure = cst.getInt(3);

            if (valueReturnedFromProcedure == 1) {
                isEligible = true;
                JOptionPane.showMessageDialog(null, "You are eligible for the schedule");
            } else {
                isEligible = false;
                JOptionPane.showMessageDialog(null, "You're not eligible for the schedule!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleRegistrationJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkButtonPanel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScheduleRegistrationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleRegistrationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleRegistrationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleRegistrationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Register_schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel checkButtonPanel1;
    private javax.swing.JComboBox<String> companyNameDropdown;
    private javax.swing.JLabel jLabelCheck;
    private javax.swing.JLabel jLabelCompanyName;
    private javax.swing.JLabel jLabelMinSalary;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSearchSchedule;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparatorID;
    private javax.swing.JSeparator jSeparatorMinSalary;
    private javax.swing.JTable jTableSchedules;
    private javax.swing.JPanel registerButtonPanel;
    private javax.swing.JLabel scheduleIdLabel;
    private javax.swing.JScrollPane scrollPaneScheduleTable;
    private javax.swing.JPanel searchButtonPanel;
    private javax.swing.JTextField searchMinSalary;
    private javax.swing.JTextField textFieldSchId;
    // End of variables declaration//GEN-END:variables
}
