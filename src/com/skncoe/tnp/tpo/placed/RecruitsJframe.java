package com.skncoe.tnp.tpo.placed;

import com.skncoe.tnp.models.PlacedStudent;
import com.skncoe.tnp.common.MySqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class RecruitsJframe extends javax.swing.JFrame {

    Connection conn = MySqlConnect.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    int year;
    String year1;
    int tpo_id;
    int dep_id;

    public RecruitsJframe(Integer tpo) {
        initComponents();
        setDefaultCloseOperation(RecruitsJframe.HIDE_ON_CLOSE);
        tpo_id = tpo;
    }

    public ArrayList<PlacedStudent> getAlumniList(String year) {
        ArrayList<PlacedStudent> alumniList = new ArrayList<PlacedStudent>();

        String query = "select cand_id,fname,schedule_company_view.co_name,"
                + "designation,package,candidate.sch_id,candidate.stu_id "
                + "from candidate,student,person,schedule_company_view"
                + " where candidate.stu_id=student.stu_id and"
                + " schedule_company_view.sch_id=candidate.sch_id and"
                + " person.p_id=student.p_id "
                + "and student.academic_year='" + year + "'";

        Statement st;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            String selectedYear = jComboBoxAcademicYear.getSelectedItem().toString();

            rs = st.executeQuery(query);

            PlacedStudent alumni;
            while (rs.next()) {
                alumni = new PlacedStudent(rs.getInt("cand_id"), rs.getString("fname"),
                        rs.getString("co_name"), rs.getString("designation"),
                        rs.getString("package"), rs.getInt("sch_id"),
                        rs.getInt("stu_id"));

                alumniList.add(alumni);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumniList;
    }

    public void ShowAlumniByYear(String year) {
        ArrayList<PlacedStudent> list1 = getAlumniList(year);
        DefaultTableModel model = (DefaultTableModel) jTable_alumni.getModel();
        Object[] row = new Object[7];
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (int i = 0; i < list1.size(); i++) {
            row[0] = list1.get(i).getCandidateID();
            row[1] = list1.get(i).getName();
            row[2] = list1.get(i).getCompany();
            row[3] = list1.get(i).getDesignation();
            row[4] = list1.get(i).getPackageOffered();
            row[5] = list1.get(i).getScheduleID();
            row[6] = list1.get(i).getStudentID();

            model.addRow(row);
        }
    }

    public ArrayList<PlacedStudent> getAllAlumniList() throws SQLException {
        ArrayList<PlacedStudent> alumniList = new ArrayList<PlacedStudent>();

        String query1 = "select cand_id,fname,schedule_company_view.co_name,"
                + "designation,package,candidate.sch_id,candidate.stu_id "
                + "from candidate,student,person,schedule_company_view where "
                + "candidate.stu_id=student.stu_id and "
                + "schedule_company_view.sch_id=candidate.sch_id and"
                + " person.p_id=student.p_id order by cand_id";

        Statement st;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query1);
            PlacedStudent alumni;
            while (rs.next()) {
                alumni = new PlacedStudent(rs.getInt("cand_id"),
                        rs.getString("fname"), rs.getString("co_name"),
                        rs.getString("designation"), rs.getString("package"),
                        rs.getInt("sch_id"), rs.getInt("stu_id"));//

                alumniList.add(alumni);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumniList;
    }

    public void ShowAlumniInJtable() throws SQLException {
        ArrayList<PlacedStudent> list1 = getAllAlumniList();
        DefaultTableModel model = (DefaultTableModel) jTable_alumni.getModel();
        Object[] row = new Object[7];
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (int i = 0; i < list1.size(); i++) {
            row[0] = list1.get(i).getCandidateID();
            row[1] = list1.get(i).getName();
            row[2] = list1.get(i).getCompany();
            row[3] = list1.get(i).getDesignation();
            row[4] = list1.get(i).getPackageOffered();
            row[5] = list1.get(i).getScheduleID();
            row[6] = list1.get(i).getStudentID();

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
        jLabel1 = new javax.swing.JLabel();
        jComboBoxAcademicYear = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_alumni = new javax.swing.JTable();
        showButtonPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Placed students");

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Academic Year : ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(210, 30, 230, 32);

        jComboBoxAcademicYear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxAcademicYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
        jComboBoxAcademicYear.setToolTipText("");
        jComboBoxAcademicYear.setBorder(null);
        jComboBoxAcademicYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAcademicYearActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxAcademicYear);
        jComboBoxAcademicYear.setBounds(420, 30, 216, 30);

        jTable_alumni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTable_alumni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Candidate ID", "First Name", "Company", "Designation", "Package", "Schedule ID", "Student ID"
            }
        ));
        jTable_alumni.setRowHeight(20);
        jScrollPane1.setViewportView(jTable_alumni);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(40, 80, 880, 390);

        showButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        showButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showButtonPanelMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 47, 65));
        jLabel3.setText("Show all");

        javax.swing.GroupLayout showButtonPanelLayout = new javax.swing.GroupLayout(showButtonPanel);
        showButtonPanel.setLayout(showButtonPanelLayout);
        showButtonPanelLayout.setHorizontalGroup(
            showButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showButtonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showButtonPanelLayout.setVerticalGroup(
            showButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel2.add(showButtonPanel);
        showButtonPanel.setBounds(430, 490, 120, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxAcademicYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAcademicYearActionPerformed
        year = Integer.parseInt(jComboBoxAcademicYear.getSelectedItem().toString());
        year1 = (jComboBoxAcademicYear.getSelectedItem().toString());
        ShowAlumniByYear(year1);
    }//GEN-LAST:event_jComboBoxAcademicYearActionPerformed

    private void showButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonPanelMouseClicked
        try {
            ShowAlumniInJtable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_showButtonPanelMouseClicked

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
            java.util.logging.Logger.getLogger(RecruitsJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecruitsJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecruitsJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecruitsJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new alumni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxAcademicYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_alumni;
    private javax.swing.JPanel showButtonPanel;
    // End of variables declaration//GEN-END:variables
}
