/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.tpo;

import com.skncoe.tnp.tpo.company.AddCompanyJframe;
import com.skncoe.tnp.tpo.placed.UpdatePlacedStudentsJframe;
import com.skncoe.tnp.tpo.students.AppearingStudentsScheduleListJframe;
import com.skncoe.tnp.tpo.students.StudentsListJframe;
import com.skncoe.tnp.tpo.schedule.DeleteScheduleJframe;
import com.skncoe.tnp.tpo.schedule.CreateScheduleJframe;
import com.skncoe.tnp.models.Schedule;
import com.skncoe.tnp.tpo.placed.RecruitsJframe;
import com.skncoe.tnp.models.Company;
import com.skncoe.tnp.common.MySqlConnect;
import com.skncoe.tnp.tpo.report.ReportDepartmentWise;
import com.skncoe.tnp.tpo.report.ReportCompanywiseJframe;
import com.skncoe.tnp.common.EditProfileJframe;
import com.skncoe.tnp.common.LoginJframe;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class TPOHomePageJframe extends javax.swing.JFrame {

    String username;
    int tpoId;
    int personId;
    int deptId;

    public TPOHomePageJframe(String Username) throws SQLException {
        initComponents();
        username = Username;
        String gender = "";
        String getTPOPersonIdFromUsernameQuery = "select * from tpo_person_view where username='" + username + "'";
        ResultSet rs = MySqlConnect.executeSelectSQlQuery(getTPOPersonIdFromUsernameQuery);
        if (rs != null) {
            rs.next();
            tpoId = rs.getInt(2);
            personId = rs.getInt(3);
            deptId = rs.getInt(4);
            gender = rs.getString(5);
        }
        setDefaultCloseOperation(TPOHomePageJframe.HIDE_ON_CLOSE);
        labelTitle.setText("Welcome " + username + "!");
        panelTableCompanies.setVisible(false);
        panelTableSchedules.setVisible(false);
        if (gender.equals("Female")) {
            try {
                //labelWelcomeIcon.setIcon(new ImageIcon(ImageIO.read(new File("images/femaleHomeTPO.png"))));
                labelWelcomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/femaleHomeTPO.png")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        labelWelcomeIcon.setVisible(true);

    }

    public ArrayList<Company> getCompanyList() {
        ArrayList<Company> companiesList = new ArrayList<Company>();

        String getCompaniesQuery = "SELECT * FROM  `company` ";
        ResultSet rs = MySqlConnect.executeSelectSQlQuery(getCompaniesQuery);
        try {
            if (rs != null) {
                Company company;
                while (rs.next()) {
                    company = new Company(rs.getInt("comp_id"),
                            rs.getString("co_name"),
                            rs.getString("type"));
                    companiesList.add(company);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companiesList;
    }

    public void showCompanyInJTable() {
        ArrayList<Company> list = getCompanyList();
        DefaultTableModel model = (DefaultTableModel) jTableCompany.getModel();

        for (int index = 0; index < model.getRowCount();) {
            model.removeRow(index);
        }

        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getcompid();
            row[1] = list.get(i).getcompname();
            row[2] = list.get(i).gettype();

            model.addRow(row);
        }
    }

    public ArrayList<Schedule> getScheduleList() {
        ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();

        String query = "SELECT * FROM  `schedule_company_view` "
                + "where tpo_id='" + tpoId + "' and active=1";
        ResultSet rs = MySqlConnect.executeSelectSQlQuery(query);
        try {
            Schedule schedule;
            while (rs.next()) {
                schedule = new Schedule(rs.getInt("sch_id"),
                        rs.getDate("sch_date").toString(),
                        rs.getInt("comp_id"), rs.getString("co_name"),
                        rs.getInt("criteria"), rs.getDouble("min_salary"));

                scheduleList.add(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    public void showScheduleInJTable() {
        ArrayList<Schedule> list1 = getScheduleList();
        DefaultTableModel model = (DefaultTableModel) jTableSchedule.getModel();

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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelTableCompanies = new javax.swing.JPanel();
        jScrollPaneCompany = new javax.swing.JScrollPane();
        jTableCompany = new javax.swing.JTable();
        labelWelcomeIcon = new javax.swing.JLabel();
        panelTableSchedules = new javax.swing.JPanel();
        jScrollPaneSchedule = new javax.swing.JScrollPane();
        jTableSchedule = new javax.swing.JTable();
        labelTitle = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCompany = new javax.swing.JMenu();
        menuItemCompanyDetail = new javax.swing.JMenuItem();
        menuItemRegisterCompany = new javax.swing.JMenuItem();
        menuSchedule = new javax.swing.JMenu();
        menuItemScheduleDetails = new javax.swing.JMenuItem();
        menuItemCreateSchedule = new javax.swing.JMenuItem();
        menuItemDeleteSchedule = new javax.swing.JMenuItem();
        menuStudent = new javax.swing.JMenu();
        menuItemStudentDetails = new javax.swing.JMenuItem();
        jmenuItemRegisteredStudents = new javax.swing.JMenuItem();
        menuRecruits = new javax.swing.JMenu();
        menuItemViewRecruitedStudents = new javax.swing.JMenuItem();
        jMenuItemUpdateRecruits = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        menuItemDepartmentWise = new javax.swing.JMenuItem();
        menuItemCompanyWise = new javax.swing.JMenuItem();
        menuItemYearWise = new javax.swing.JMenuItem();
        menuProfile = new javax.swing.JMenu();
        menuItemEdit = new javax.swing.JMenuItem();
        menuMore = new javax.swing.JMenu();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        jPanel1.setBackground(new java.awt.Color(37, 46, 65));

        panelTableCompanies.setBackground(new java.awt.Color(37, 46, 65));
        panelTableCompanies.setLayout(null);

        jTableCompany.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableCompany.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company ID", "Company Name", "Type"
            }
        ));
        jTableCompany.setRowHeight(20);
        jScrollPaneCompany.setViewportView(jTableCompany);

        panelTableCompanies.add(jScrollPaneCompany);
        jScrollPaneCompany.setBounds(20, 30, 890, 280);

        labelWelcomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regStepSideTPO.png"))); // NOI18N

        panelTableSchedules.setBackground(new java.awt.Color(37, 46, 65));
        panelTableSchedules.setLayout(null);

        jTableSchedule.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule ID", "Schedule Date", "Company ID", "Company", "Criteria", "Min Salary"
            }
        ));
        jTableSchedule.setRowHeight(22);
        jScrollPaneSchedule.setViewportView(jTableSchedule);

        panelTableSchedules.add(jScrollPaneSchedule);
        jScrollPaneSchedule.setBounds(10, 20, 890, 280);

        jLayeredPane1.setLayer(panelTableCompanies, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(labelWelcomeIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelTableSchedules, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addComponent(labelWelcomeIcon)
                .addGap(321, 321, 321))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTableCompanies, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(22, Short.MAX_VALUE)
                    .addComponent(panelTableSchedules, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(labelWelcomeIcon)
                .addGap(55, 55, 55))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTableCompanies, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(panelTableSchedules, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );

        labelTitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelTitle.setText("Title");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(114, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(464, Short.MAX_VALUE)))
        );

        jMenuBar1.setBackground(new java.awt.Color(97, 212, 195));
        jMenuBar1.setForeground(new java.awt.Color(97, 212, 195));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(493, 50));

        menuCompany.setForeground(new java.awt.Color(37, 46, 65));
        menuCompany.setText("Company");
        menuCompany.setToolTipText("");

        menuItemCompanyDetail.setText("View");
        menuItemCompanyDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCompanyDetailActionPerformed(evt);
            }
        });
        menuCompany.add(menuItemCompanyDetail);

        menuItemRegisterCompany.setText("Add");
        menuItemRegisterCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegisterCompanyActionPerformed(evt);
            }
        });
        menuCompany.add(menuItemRegisterCompany);

        jMenuBar1.add(menuCompany);

        menuSchedule.setForeground(new java.awt.Color(37, 46, 65));
        menuSchedule.setText("Schedule");

        menuItemScheduleDetails.setText("View");
        menuItemScheduleDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemScheduleDetailsActionPerformed(evt);
            }
        });
        menuSchedule.add(menuItemScheduleDetails);

        menuItemCreateSchedule.setText("Create");
        menuItemCreateSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCreateScheduleActionPerformed(evt);
            }
        });
        menuSchedule.add(menuItemCreateSchedule);

        menuItemDeleteSchedule.setText("Delete");
        menuItemDeleteSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDeleteScheduleActionPerformed(evt);
            }
        });
        menuSchedule.add(menuItemDeleteSchedule);

        jMenuBar1.add(menuSchedule);

        menuStudent.setForeground(new java.awt.Color(37, 46, 65));
        menuStudent.setText("Students");

        menuItemStudentDetails.setText("All students in my department");
        menuItemStudentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemStudentDetailsActionPerformed(evt);
            }
        });
        menuStudent.add(menuItemStudentDetails);

        jmenuItemRegisteredStudents.setText("Students registered for schedules");
        jmenuItemRegisteredStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemRegisteredStudentsActionPerformed(evt);
            }
        });
        menuStudent.add(jmenuItemRegisteredStudents);

        jMenuBar1.add(menuStudent);

        menuRecruits.setForeground(new java.awt.Color(37, 46, 65));
        menuRecruits.setText("Placed");

        menuItemViewRecruitedStudents.setText("View");
        menuItemViewRecruitedStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemViewRecruitedStudentsActionPerformed(evt);
            }
        });
        menuRecruits.add(menuItemViewRecruitedStudents);

        jMenuItemUpdateRecruits.setText("Update");
        jMenuItemUpdateRecruits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUpdateRecruitsActionPerformed(evt);
            }
        });
        menuRecruits.add(jMenuItemUpdateRecruits);

        jMenuBar1.add(menuRecruits);

        menuReport.setForeground(new java.awt.Color(37, 46, 65));
        menuReport.setText("Report");

        menuItemDepartmentWise.setText("Departmentwise");
        menuItemDepartmentWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDepartmentWiseActionPerformed(evt);
            }
        });
        menuReport.add(menuItemDepartmentWise);

        menuItemCompanyWise.setText("Companywise");
        menuItemCompanyWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCompanyWiseActionPerformed(evt);
            }
        });
        menuReport.add(menuItemCompanyWise);

        menuItemYearWise.setText("Yearwise");
        menuItemYearWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemYearWiseActionPerformed(evt);
            }
        });
        menuReport.add(menuItemYearWise);

        jMenuBar1.add(menuReport);

        menuProfile.setForeground(new java.awt.Color(37, 46, 65));
        menuProfile.setText("Profile");

        menuItemEdit.setText("Edit");
        menuItemEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditActionPerformed(evt);
            }
        });
        menuProfile.add(menuItemEdit);

        jMenuBar1.add(menuProfile);

        menuMore.setForeground(new java.awt.Color(37, 46, 65));
        menuMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/180477.gif"))); // NOI18N
        menuMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMoreMouseClicked(evt);
            }
        });
        menuMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMoreActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuMore);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditActionPerformed
        try {
            new EditProfileJframe(personId, deptId).setVisible(true);
            this.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TPOHomePageJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemEditActionPerformed

    private void menuItemRegisterCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegisterCompanyActionPerformed
        this.setVisible(true);
        new AddCompanyJframe().setVisible(true);
    }//GEN-LAST:event_menuItemRegisterCompanyActionPerformed

    private void menuItemCompanyDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCompanyDetailActionPerformed
        showCompanyInJTable();
        labelTitle.setVisible(false);
        panelTableCompanies.setVisible(true);
        panelTableSchedules.setVisible(false);

        labelWelcomeIcon.setVisible(false);
    }//GEN-LAST:event_menuItemCompanyDetailActionPerformed

    private void menuItemCreateScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCreateScheduleActionPerformed
        this.setVisible(true);
        new CreateScheduleJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemCreateScheduleActionPerformed

    private void menuItemScheduleDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemScheduleDetailsActionPerformed
        showScheduleInJTable();
        labelTitle.setVisible(false);
        panelTableSchedules.setVisible(true);
        panelTableCompanies.setVisible(false);

        labelWelcomeIcon.setVisible(false);
    }//GEN-LAST:event_menuItemScheduleDetailsActionPerformed

    private void menuItemStudentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemStudentDetailsActionPerformed
        this.setVisible(true);
        new StudentsListJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemStudentDetailsActionPerformed

    private void jmenuItemRegisteredStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemRegisteredStudentsActionPerformed
        this.setVisible(true);
        new AppearingStudentsScheduleListJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_jmenuItemRegisteredStudentsActionPerformed

    private void menuMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMoreActionPerformed
        logout();
    }//GEN-LAST:event_menuMoreActionPerformed
    public void logout() {
        this.dispose();
        try {
            new LoginJframe().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(TPOHomePageJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void menuItemViewRecruitedStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemViewRecruitedStudentsActionPerformed
        new RecruitsJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemViewRecruitedStudentsActionPerformed

    private void menuItemDepartmentWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDepartmentWiseActionPerformed
        new ReportDepartmentWise().setVisible(true);
    }//GEN-LAST:event_menuItemDepartmentWiseActionPerformed

    private void menuItemCompanyWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCompanyWiseActionPerformed
        new ReportCompanywiseJframe().setVisible(true);
    }//GEN-LAST:event_menuItemCompanyWiseActionPerformed

    private void menuItemYearWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemYearWiseActionPerformed
        new RecruitsJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemYearWiseActionPerformed

    private void menuMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMoreMouseClicked
        logout();
    }//GEN-LAST:event_menuMoreMouseClicked

    private void menuItemDeleteScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDeleteScheduleActionPerformed
        this.setVisible(true);
        new DeleteScheduleJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemDeleteScheduleActionPerformed

    private void jMenuItemUpdateRecruitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUpdateRecruitsActionPerformed
        // TODO add your handling code here:
        new UpdatePlacedStudentsJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_jMenuItemUpdateRecruitsActionPerformed

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
            java.util.logging.Logger.getLogger(TPOHomePageJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPOHomePageJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPOHomePageJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPOHomePageJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemUpdateRecruits;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneCompany;
    private javax.swing.JScrollPane jScrollPaneSchedule;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableCompany;
    private javax.swing.JTable jTableSchedule;
    private javax.swing.JMenuItem jmenuItemRegisteredStudents;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelWelcomeIcon;
    private javax.swing.JMenu menuCompany;
    private javax.swing.JMenuItem menuItemCompanyDetail;
    private javax.swing.JMenuItem menuItemCompanyWise;
    private javax.swing.JMenuItem menuItemCreateSchedule;
    private javax.swing.JMenuItem menuItemDeleteSchedule;
    private javax.swing.JMenuItem menuItemDepartmentWise;
    private javax.swing.JMenuItem menuItemEdit;
    private javax.swing.JMenuItem menuItemRegisterCompany;
    private javax.swing.JMenuItem menuItemScheduleDetails;
    private javax.swing.JMenuItem menuItemStudentDetails;
    private javax.swing.JMenuItem menuItemViewRecruitedStudents;
    private javax.swing.JMenuItem menuItemYearWise;
    private javax.swing.JMenu menuMore;
    private javax.swing.JMenu menuProfile;
    private javax.swing.JMenu menuRecruits;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenu menuSchedule;
    private javax.swing.JMenu menuStudent;
    private javax.swing.JPanel panelTableCompanies;
    private javax.swing.JPanel panelTableSchedules;
    // End of variables declaration//GEN-END:variables
}
