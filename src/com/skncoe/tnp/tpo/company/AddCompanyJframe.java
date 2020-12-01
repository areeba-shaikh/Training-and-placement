/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.tpo.company;

import com.skncoe.tnp.common.MySqlConnect;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AddCompanyJframe extends javax.swing.JFrame {

    Connection conn = MySqlConnect.getConnection();

    /**
     * Creates new form company
     */
    public AddCompanyJframe() {
        initComponents();
        setDefaultCloseOperation(AddCompanyJframe.HIDE_ON_CLOSE);

    }

    public void executeSQlQuery(String query, String message) {
        Statement st;
        try {
            st = conn.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                JOptionPane.showMessageDialog(null, "Company added successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Company addition failed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
        jLabel8 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldHRName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPhoneNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldStreet = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPincode = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        registerButtonPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jComboBoxCity = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register company");

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));
        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Company Name :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(40, 60, 170, 24);

        jTextFieldName.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldName.setForeground(java.awt.Color.white);
        jTextFieldName.setBorder(null);
        jTextFieldName.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldName);
        jTextFieldName.setBounds(250, 60, 151, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Type :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 120, 60, 24);

        jTextFieldType.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldType.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldType.setForeground(java.awt.Color.white);
        jTextFieldType.setBorder(null);
        jTextFieldType.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldType);
        jTextFieldType.setBounds(250, 120, 151, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("HR Name : ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(470, 70, 110, 24);

        jTextFieldHRName.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldHRName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldHRName.setForeground(java.awt.Color.white);
        jTextFieldHRName.setBorder(null);
        jTextFieldHRName.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldHRName);
        jTextFieldHRName.setBounds(640, 60, 151, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email : ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(470, 140, 59, 30);

        jTextFieldEmail.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldEmail.setForeground(java.awt.Color.white);
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldEmail);
        jTextFieldEmail.setBounds(640, 140, 151, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone number :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(470, 222, 127, 30);

        jTextFieldPhoneNo.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldPhoneNo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldPhoneNo.setForeground(java.awt.Color.white);
        jTextFieldPhoneNo.setBorder(null);
        jTextFieldPhoneNo.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldPhoneNo);
        jTextFieldPhoneNo.setBounds(640, 220, 151, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Street :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 190, 58, 24);

        jTextFieldStreet.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldStreet.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldStreet.setForeground(java.awt.Color.white);
        jTextFieldStreet.setBorder(null);
        jTextFieldStreet.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldStreet);
        jTextFieldStreet.setBounds(250, 190, 151, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("City : ");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 270, 46, 24);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pincode : ");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(40, 350, 80, 24);

        jTextFieldPincode.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldPincode.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldPincode.setForeground(java.awt.Color.white);
        jTextFieldPincode.setBorder(null);
        jTextFieldPincode.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldPincode);
        jTextFieldPincode.setBounds(250, 340, 151, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(430, 40, 10, 390);

        registerButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        registerButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonPanelMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(36, 47, 65));
        jLabel10.setText("Register");

        javax.swing.GroupLayout registerButtonPanelLayout = new javax.swing.GroupLayout(registerButtonPanel);
        registerButtonPanel.setLayout(registerButtonPanelLayout);
        registerButtonPanelLayout.setHorizontalGroup(
            registerButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerButtonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerButtonPanelLayout.setVerticalGroup(
            registerButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jPanel2.add(registerButtonPanel);
        registerButtonPanel.setBounds(390, 460, 120, 50);

        jSeparator2.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(640, 250, 150, 10);

        jSeparator3.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(250, 90, 150, 10);

        jSeparator4.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(250, 150, 150, 10);

        jSeparator5.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator5);
        jSeparator5.setBounds(250, 220, 150, 10);

        jSeparator7.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(250, 370, 150, 10);

        jSeparator8.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator8);
        jSeparator8.setBounds(640, 90, 150, 10);

        jSeparator9.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator9);
        jSeparator9.setBounds(640, 170, 150, 10);

        jComboBoxCity.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pune", "Hyderabad", "Nagpur", "Bengaluru" }));
        jComboBoxCity.setBorder(null);
        jPanel2.add(jComboBoxCity);
        jComboBoxCity.setBounds(250, 270, 150, 28);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonPanelMouseClicked
        String query1 = "INSERT INTO `company`(`co_name`,`type`,`HR_personnel`,"
                + "`email`,`phone`,`street`,`city`,`pincode`) VALUES ('"
                + jTextFieldName.getText() + "','" + jTextFieldType.getText()
                + "','" + jTextFieldHRName.getText() + "','" + jTextFieldEmail.getText()
                + "','" + jTextFieldPhoneNo.getText() + "','" + jTextFieldStreet.getText()
                + "','" + jComboBoxCity.getSelectedItem() + "','" + jTextFieldPincode.getText() + "')";
        executeSQlQuery(query1, "insert");
        this.dispose();
    }//GEN-LAST:event_registerButtonPanelMouseClicked

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
            java.util.logging.Logger.getLogger(AddCompanyJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCompanyJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCompanyJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCompanyJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCompanyJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxCity;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHRName;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPhoneNo;
    private javax.swing.JTextField jTextFieldPincode;
    private javax.swing.JTextField jTextFieldStreet;
    private javax.swing.JTextField jTextFieldType;
    private javax.swing.JPanel registerButtonPanel;
    // End of variables declaration//GEN-END:variables

////    private Connection getConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}