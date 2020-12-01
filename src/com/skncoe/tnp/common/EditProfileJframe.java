/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skncoe.tnp.common;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class EditProfileJframe extends javax.swing.JFrame {

    Connection conn = MySqlConnect.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    String filePath = "";
    File photoFile;
    FileInputStream photoFis;
    Integer personID, departmentID;

    public EditProfileJframe(int personID, int departmentID) throws SQLException {
        //setLocationRelativeTo(null);
        initComponents();
        setDefaultCloseOperation(EditProfileJframe.HIDE_ON_CLOSE);
        this.personID = personID;
        this.departmentID = departmentID;
        displayPerson();

    }

    public void displayPerson() throws SQLException {
        String selectSQL = "SELECT fname,lname,email,dob,phone,gender,city,"
                + "street,flat,pincode, photo from person WHERE p_id=" + personID;
        PreparedStatement ps = conn.prepareStatement(selectSQL);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                labelFirstNameValue.setText(rs.getString("fname"));
                labelLastName.setText(rs.getString("lname"));
                jTextFieldCity.setText(rs.getString("city"));
                jTextFieldEmail.setText(rs.getString("email"));
                jTextFieldFlat.setText(rs.getString("flat"));
                jTextFieldPhone.setText(rs.getString("phone"));
                jTextFieldStreet.setText(rs.getString("street"));
                jTextFieldPincode.setText(rs.getString("pincode"));
                labelDepartmentValue.setText(Utils.getDeptName(departmentID));
                byte[] image = null;
                image = rs.getBytes("photo");
                if (image != null) {
                    java.awt.Image img = Toolkit.getDefaultToolkit().createImage(image);
                    img = img.getScaledInstance(180, 190, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(img);
                    labelProfilePhoto.setIcon(icon);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
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
        jLabelDepartment = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldStreet = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldFlat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPincode = new javax.swing.JTextField();
        labelDepartmentValue = new javax.swing.JLabel();
        labelLastName = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        saveButtonPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        uploadButtonPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        textFieldFileName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        labelProfilePhoto = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        labelFirstNameValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit profile");

        jPanel2.setBackground(new java.awt.Color(37, 46, 65));
        jPanel2.setLayout(null);

        jLabelDepartment.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDepartment.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDepartment.setText("Department : ");
        jPanel2.add(jLabelDepartment);
        jLabelDepartment.setBounds(460, 30, 150, 15);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name : ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 90, 101, 24);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mobile Number : ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 140, 136, 24);

        jTextFieldPhone.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldPhone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldPhone.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPhone.setBorder(null);
        jTextFieldPhone.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldPhone);
        jTextFieldPhone.setBounds(220, 140, 210, 30);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 200, 54, 24);

        jTextFieldEmail.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldEmail);
        jTextFieldEmail.setBounds(220, 190, 210, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("City : ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 260, 46, 24);

        jTextFieldCity.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldCity.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldCity.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCity.setBorder(null);
        jTextFieldCity.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldCity);
        jTextFieldCity.setBounds(220, 260, 210, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Street :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 330, 58, 24);

        jTextFieldStreet.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldStreet.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldStreet.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldStreet.setBorder(null);
        jTextFieldStreet.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldStreet);
        jTextFieldStreet.setBounds(220, 330, 210, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Flat No.:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 400, 68, 24);

        jTextFieldFlat.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldFlat.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldFlat.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldFlat.setBorder(null);
        jTextFieldFlat.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldFlat);
        jTextFieldFlat.setBounds(220, 400, 210, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pincode : ");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 470, 80, 24);

        jTextFieldPincode.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldPincode.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldPincode.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPincode.setBorder(null);
        jTextFieldPincode.setCaretColor(java.awt.Color.white);
        jPanel2.add(jTextFieldPincode);
        jTextFieldPincode.setBounds(220, 460, 210, 30);

        labelDepartmentValue.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelDepartmentValue.setForeground(java.awt.Color.white);
        labelDepartmentValue.setText("DepartmentValue");
        jPanel2.add(labelDepartmentValue);
        labelDepartmentValue.setBounds(590, 30, 350, 24);

        labelLastName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelLastName.setForeground(java.awt.Color.white);
        labelLastName.setText("jLabel9");
        jPanel2.add(labelLastName);
        labelLastName.setBounds(210, 90, 350, 24);

        jSeparator2.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(220, 490, 210, 10);

        jSeparator3.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(220, 220, 210, 10);

        jSeparator4.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(220, 290, 210, 10);

        jSeparator5.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator5);
        jSeparator5.setBounds(220, 360, 210, 10);

        jSeparator6.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator6);
        jSeparator6.setBounds(680, 400, 210, 10);

        jSeparator7.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(220, 430, 210, 10);

        saveButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        saveButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonPanelMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 47, 65));
        jLabel4.setText("Save");

        javax.swing.GroupLayout saveButtonPanelLayout = new javax.swing.GroupLayout(saveButtonPanel);
        saveButtonPanel.setLayout(saveButtonPanelLayout);
        saveButtonPanelLayout.setHorizontalGroup(
            saveButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveButtonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        saveButtonPanelLayout.setVerticalGroup(
            saveButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saveButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel2.add(saveButtonPanel);
        saveButtonPanel.setBounds(800, 480, 90, 50);

        uploadButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        uploadButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadButtonPanelClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(36, 47, 65));
        jLabel9.setText("Upload");

        javax.swing.GroupLayout uploadButtonPanelLayout = new javax.swing.GroupLayout(uploadButtonPanel);
        uploadButtonPanel.setLayout(uploadButtonPanelLayout);
        uploadButtonPanelLayout.setHorizontalGroup(
            uploadButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadButtonPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        uploadButtonPanelLayout.setVerticalGroup(
            uploadButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(uploadButtonPanel);
        uploadButtonPanel.setBounds(540, 370, 110, 30);

        textFieldFileName.setBackground(new java.awt.Color(36, 47, 65));
        textFieldFileName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textFieldFileName.setForeground(java.awt.Color.white);
        textFieldFileName.setBorder(null);
        jPanel2.add(textFieldFileName);
        textFieldFileName.setBounds(680, 370, 210, 32);

        labelProfilePhoto.setForeground(new java.awt.Color(222, 166, 133));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelProfilePhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelProfilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(600, 130, 180, 190);

        jSeparator8.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator8);
        jSeparator8.setBounds(220, 170, 210, 10);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("First Name : ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(30, 50, 150, 15);

        labelFirstNameValue.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelFirstNameValue.setForeground(java.awt.Color.white);
        labelFirstNameValue.setText("jLabel4");
        jPanel2.add(labelFirstNameValue);
        labelFirstNameValue.setBounds(210, 50, 350, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonPanelMouseClicked
        Statement stmt;
//PreparedStatement stmt;
        try {
            /*
            String query = "UPDATE person SET phone = , email = ?, city = ?, street = ?, pincode = ?, flat = ?, photo = ? WHERE p_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, );
            stmt.setString(2, jTextFieldEmail.getText());
            stmt.setString(3, jTextFieldCity.getText());
            stmt.setString(4, jTextFieldStreet.getText());
            stmt.setString(5, jTextFieldPincode.getText());
            stmt.setString(6, jTextFieldFlat.getText());
            if (photoFile != null) {
                stmt.setBinaryStream(7, photoFis, (int) photoFile.length());
            } else {
                stmt.setBinaryStream(7, null, 0);

            }
            stmt.setInt(8, personID);
            stmt.executeUpdate(query);*/

            stmt = (Statement) conn.createStatement();
            String query = "UPDATE person SET phone='"
                    + jTextFieldPhone.getText()
                    + "', email='" + jTextFieldEmail.getText() + "', city='"
                    + jTextFieldCity.getText() + "', street='"
                    + jTextFieldStreet.getText() + "', pincode='"
                    + jTextFieldPincode.getText() + "', flat='"
                    + jTextFieldFlat.getText() + "' WHERE p_id='" + personID + "'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Profile Updated!");
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(EditProfileJframe.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_saveButtonPanelMouseClicked

    private void uploadButtonPanelClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadButtonPanelClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        photoFile = chooser.getSelectedFile();
        try {
            photoFis = new FileInputStream(photoFile);
            filePath = photoFile.getAbsolutePath();
            textFieldFileName.setText(filePath);

            //get the image from file chooser and scale it to match JLabel size
            ImageIcon ii = new ImageIcon(scaleImage(180, 190, ImageIO.read(new File(photoFile.getAbsolutePath()))));
            labelProfilePhoto.setIcon(ii);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_uploadButtonPanelClicked

    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }

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
            java.util.logging.Logger.getLogger(EditProfileJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProfileJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProfileJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProfileJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDepartment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFlat;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldPincode;
    private javax.swing.JTextField jTextFieldStreet;
    private javax.swing.JLabel labelDepartmentValue;
    private javax.swing.JLabel labelFirstNameValue;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelProfilePhoto;
    private javax.swing.JPanel saveButtonPanel;
    private javax.swing.JTextField textFieldFileName;
    private javax.swing.JPanel uploadButtonPanel;
    // End of variables declaration//GEN-END:variables
}
