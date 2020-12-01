package com.skncoe.tnp.common.registration;

import com.skncoe.tnp.common.MySqlConnect;
import com.skncoe.tnp.models.PersonalDetails;
import com.skncoe.tnp.models.TPO;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public final class RegistrationFormPage1Jframe extends javax.swing.JFrame {

    Connection conn = MySqlConnect.getConnection();

    String email = "", mobileNo = "", firstName = "", middleName = "",
            lastName = "", dateOfBirth = "", gender = "", registerAs = "", filePath = "";
    ArrayList<String> takenUsernames = new ArrayList<>();

    public RegistrationFormPage1Jframe() {
        initComponents();
        labelMiddleNameError.setVisible(false);
        labelLastNameError.setVisible(false);
        labelEmailError.setVisible(false);
        labelPhoneError.setVisible(false);
        labelFirstNameError.setVisible(false);

        getExistingUsernames();
    }

    private void getExistingUsernames() {

        String query = "SELECT username FROM  login";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String takenUsername = rs.getString("username");
                takenUsernames.add(takenUsername);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validatePhone() {
        boolean isValidPhone = mobileNo.length() == 10 && mobileNo.matches("[0-9]+");
        if (!isValidPhone) {
            if (mobileNo.length() == 0) {
                labelPhoneError.setText("Phone no is required");
            } else {
                labelPhoneError.setText("Invalid phone no");
            }
            labelPhoneError.setVisible(true);
        } else {
            labelPhoneError.setVisible(false);
        }
        return isValidPhone;
    }

    public boolean validateEmail() {
        boolean isValidEmail;

        String email_pattern = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*(\\.[A-za-z0-9]{2,})$";
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        isValidEmail = matcher.matches();

        if (!isValidEmail) {
            if (email.length() == 0) {
                labelEmailError.setText("Email is required");
            } else {
                labelEmailError.setText("Invalid email");
            }
            labelEmailError.setVisible(true);
        } else {
            labelEmailError.setVisible(false);
        }
        return isValidEmail;
    }

    public boolean validateFirstName() {
        boolean isValidName;
        String namePattern = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(firstName);

        isValidName = matcher.matches();

        if (!isValidName) {
            if (firstName.length() == 0) {
                labelFirstNameError.setText("First name is required");
            } else {
                labelFirstNameError.setText("Name can have only letters");
            }
            labelFirstNameError.setVisible(true);
        } else {
            labelFirstNameError.setVisible(false);
        }
        return isValidName;
    }

    public boolean validateMiddleName() {
        boolean isValidName;

        String namePattern = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(middleName);

        isValidName = matcher.matches() || middleName.length() == 0;

        if (!isValidName) {
            labelMiddleNameError.setVisible(true);
            labelMiddleNameError.setText("Name can have only letters");
        } else {
            labelMiddleNameError.setVisible(false);
        }
        return isValidName;
    }

    public boolean validateLastName() {
        boolean isValidName;
        String namePattern = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(lastName);

        isValidName = matcher.matches();

        if (!isValidName) {
            if (lastName.length() == 0) {
                labelLastNameError.setText("Last name is required");
            } else {
                labelLastNameError.setText("Name can have only letters");
            }
            labelLastNameError.setVisible(true);
        } else {
            labelLastNameError.setVisible(false);
        }
        return isValidName;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        labelFirstName = new javax.swing.JLabel();
        fieldFirstName = new javax.swing.JTextField();
        labelMiddleName = new javax.swing.JLabel();
        fieldMiddleName = new javax.swing.JTextField();
        labelLastName = new javax.swing.JLabel();
        fieldLastName = new javax.swing.JTextField();
        labelDateOfBirth = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        fieldGender = new javax.swing.JComboBox<>();
        fieldRegisterAs = new javax.swing.JComboBox<>();
        labelEmail = new javax.swing.JLabel();
        fieldEmail = new javax.swing.JTextField();
        labelPhone = new javax.swing.JLabel();
        fieldPhone = new javax.swing.JTextField();
        labelPhoneError = new javax.swing.JLabel();
        labelEmailError = new javax.swing.JLabel();
        labelLastNameError = new javax.swing.JLabel();
        labelFirstNameError = new javax.swing.JLabel();
        labelMiddleNameError = new javax.swing.JLabel();
        uploadButtonPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        textFieldFileName = new javax.swing.JTextField();
        nextButtonPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        labelProfilePhoto = new javax.swing.JLabel();
        fieldDateOfBirth = new datechooser.beans.DateChooserCombo();
        labelTopImage = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));
        jPanel2.setLayout(null);

        labelFirstName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelFirstName.setForeground(new java.awt.Color(255, 255, 255));
        labelFirstName.setText("First name :");
        jPanel2.add(labelFirstName);
        labelFirstName.setBounds(30, 80, 120, 24);

        fieldFirstName.setBackground(new java.awt.Color(36, 47, 65));
        fieldFirstName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldFirstName.setForeground(new java.awt.Color(255, 255, 255));
        fieldFirstName.setToolTipText("");
        fieldFirstName.setBorder(null);
        fieldFirstName.setCaretColor(java.awt.Color.white);
        fieldFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldFirstNameKeyReleased(evt);
            }
        });
        jPanel2.add(fieldFirstName);
        fieldFirstName.setBounds(190, 80, 190, 30);

        labelMiddleName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelMiddleName.setForeground(new java.awt.Color(255, 255, 255));
        labelMiddleName.setText("Middle name :");
        jPanel2.add(labelMiddleName);
        labelMiddleName.setBounds(30, 160, 140, 24);

        fieldMiddleName.setBackground(new java.awt.Color(36, 47, 65));
        fieldMiddleName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldMiddleName.setForeground(new java.awt.Color(255, 255, 255));
        fieldMiddleName.setBorder(null);
        fieldMiddleName.setCaretColor(java.awt.Color.white);
        fieldMiddleName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldMiddleNameKeyReleased(evt);
            }
        });
        jPanel2.add(fieldMiddleName);
        fieldMiddleName.setBounds(190, 160, 190, 30);

        labelLastName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelLastName.setForeground(new java.awt.Color(255, 255, 255));
        labelLastName.setText("Last name :");
        jPanel2.add(labelLastName);
        labelLastName.setBounds(30, 240, 93, 24);

        fieldLastName.setBackground(new java.awt.Color(36, 47, 65));
        fieldLastName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldLastName.setForeground(new java.awt.Color(255, 255, 255));
        fieldLastName.setBorder(null);
        fieldLastName.setCaretColor(java.awt.Color.white);
        fieldLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldLastNameKeyReleased(evt);
            }
        });
        jPanel2.add(fieldLastName);
        fieldLastName.setBounds(190, 240, 190, 30);

        labelDateOfBirth.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelDateOfBirth.setForeground(new java.awt.Color(255, 255, 255));
        labelDateOfBirth.setText("Date of birth:");
        jPanel2.add(labelDateOfBirth);
        labelDateOfBirth.setBounds(30, 320, 130, 24);

        labelGender.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelGender.setForeground(new java.awt.Color(255, 255, 255));
        labelGender.setText("Gender : ");
        jPanel2.add(labelGender);
        labelGender.setBounds(30, 390, 75, 24);

        fieldGender.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        fieldGender.setBorder(null);
        jPanel2.add(fieldGender);
        fieldGender.setBounds(190, 390, 190, 28);

        fieldRegisterAs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldRegisterAs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TPO", "Student" }));
        fieldRegisterAs.setBorder(null);
        jPanel2.add(fieldRegisterAs);
        fieldRegisterAs.setBounds(430, 20, 139, 30);

        labelEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(255, 255, 255));
        labelEmail.setText("E-mail :");
        jPanel2.add(labelEmail);
        labelEmail.setBounds(420, 320, 70, 24);

        fieldEmail.setBackground(new java.awt.Color(36, 47, 65));
        fieldEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldEmail.setForeground(new java.awt.Color(255, 255, 255));
        fieldEmail.setBorder(null);
        fieldEmail.setCaretColor(java.awt.Color.white);
        fieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldEmailKeyReleased(evt);
            }
        });
        jPanel2.add(fieldEmail);
        fieldEmail.setBounds(530, 320, 191, 30);

        labelPhone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelPhone.setForeground(new java.awt.Color(255, 255, 255));
        labelPhone.setText("Phone no :");
        jPanel2.add(labelPhone);
        labelPhone.setBounds(420, 400, 110, 24);

        fieldPhone.setBackground(new java.awt.Color(36, 47, 65));
        fieldPhone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldPhone.setForeground(new java.awt.Color(255, 255, 255));
        fieldPhone.setBorder(null);
        fieldPhone.setCaretColor(java.awt.Color.white);
        fieldPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldPhoneKeyReleased(evt);
            }
        });
        jPanel2.add(fieldPhone);
        fieldPhone.setBounds(530, 400, 191, 30);

        labelPhoneError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelPhoneError.setForeground(new java.awt.Color(230, 49, 29));
        labelPhoneError.setText("phoneError");
        jPanel2.add(labelPhoneError);
        labelPhoneError.setBounds(530, 440, 340, 24);

        labelEmailError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelEmailError.setForeground(new java.awt.Color(230, 49, 29));
        labelEmailError.setText("emailError");
        jPanel2.add(labelEmailError);
        labelEmailError.setBounds(530, 360, 340, 24);

        labelLastNameError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelLastNameError.setForeground(new java.awt.Color(230, 49, 29));
        labelLastNameError.setText("lastNameError");
        jPanel2.add(labelLastNameError);
        labelLastNameError.setBounds(190, 280, 360, 24);

        labelFirstNameError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelFirstNameError.setForeground(new java.awt.Color(230, 49, 29));
        labelFirstNameError.setText("firstNameError");
        jPanel2.add(labelFirstNameError);
        labelFirstNameError.setBounds(190, 120, 310, 24);

        labelMiddleNameError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelMiddleNameError.setForeground(new java.awt.Color(230, 49, 29));
        labelMiddleNameError.setText("middleNameError");
        jPanel2.add(labelMiddleNameError);
        labelMiddleNameError.setBounds(190, 200, 330, 24);

        uploadButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        uploadButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadButtonPanelClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 47, 65));
        jLabel4.setText("Upload");

        javax.swing.GroupLayout uploadButtonPanelLayout = new javax.swing.GroupLayout(uploadButtonPanel);
        uploadButtonPanel.setLayout(uploadButtonPanelLayout);
        uploadButtonPanelLayout.setHorizontalGroup(
            uploadButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadButtonPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        uploadButtonPanelLayout.setVerticalGroup(
            uploadButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(uploadButtonPanel);
        uploadButtonPanel.setBounds(420, 160, 110, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(550, 190, 160, 10);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(190, 270, 190, 10);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("I'm a ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(360, 20, 56, 24);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(530, 430, 190, 10);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(190, 110, 190, 10);
        jPanel2.add(jSeparator5);
        jSeparator5.setBounds(190, 190, 190, 10);

        textFieldFileName.setEditable(false);
        textFieldFileName.setBackground(new java.awt.Color(36, 47, 65));
        textFieldFileName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textFieldFileName.setForeground(java.awt.Color.white);
        textFieldFileName.setBorder(null);
        jPanel2.add(textFieldFileName);
        textFieldFileName.setBounds(550, 160, 160, 32);

        nextButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        nextButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonPanelClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 47, 65));
        jLabel5.setText("Next");

        javax.swing.GroupLayout nextButtonPanelLayout = new javax.swing.GroupLayout(nextButtonPanel);
        nextButtonPanel.setLayout(nextButtonPanelLayout);
        nextButtonPanelLayout.setHorizontalGroup(
            nextButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextButtonPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        nextButtonPanelLayout.setVerticalGroup(
            nextButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(nextButtonPanel);
        nextButtonPanel.setBounds(840, 440, 100, 50);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator6);
        jSeparator6.setBounds(394, 66, 2, 400);
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(530, 350, 190, 10);

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setForeground(java.awt.Color.white);

        labelProfilePhoto.setForeground(new java.awt.Color(222, 166, 133));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelProfilePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelProfilePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(750, 80, 180, 190);
        jPanel2.add(fieldDateOfBirth);
        fieldDateOfBirth.setBounds(190, 320, 155, 22);

        labelTopImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regStep1Top.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTopImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labelTopImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean validateForm() {
        boolean isValid = false;

        boolean isValidFirstName = validateFirstName();
        boolean isValidMiddleName = validateMiddleName();
        boolean isValidLastName = validateLastName();
        boolean isValidEmail = validateEmail();
        boolean isValidPhone = validatePhone();
        if (isValidFirstName && isValidMiddleName
                && isValidLastName && isValidEmail
                && isValidPhone) {
            isValid = true;
        }
        return isValid;
    }

    private void saveAndNext() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        dateOfBirth = formatter.format(fieldDateOfBirth.getSelectedDate().getTime());
        firstName = fieldFirstName.getText();
        lastName = fieldLastName.getText();
        email = fieldEmail.getText();
        mobileNo = fieldPhone.getText();
        gender = fieldGender.getSelectedItem().toString();
        registerAs = fieldRegisterAs.getSelectedItem().toString();

        boolean isValid = validateForm();
        if (isValid) {
            PersonalDetails personalDetails = new PersonalDetails(firstName,
                    middleName, lastName, email,
                    mobileNo, gender, dateOfBirth, filePath);
            this.dispose();
            if (registerAs.equals("TPO")) {
                new RegistrationFormPage2TPOJframe(personalDetails).setVisible(true);
            } else if (registerAs.equals("Student")) {
                new RegistrationFormPage2StudentJframe(personalDetails).setVisible(true);
            }
        }
    }

    private void fieldFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldFirstNameKeyReleased
        firstName = fieldFirstName.getText();
        validateFirstName();
    }//GEN-LAST:event_fieldFirstNameKeyReleased

    private void fieldMiddleNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldMiddleNameKeyReleased
        middleName = fieldMiddleName.getText();
        validateMiddleName();
    }//GEN-LAST:event_fieldMiddleNameKeyReleased

    private void fieldLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldLastNameKeyReleased
        lastName = fieldLastName.getText();
        validateLastName();
    }//GEN-LAST:event_fieldLastNameKeyReleased

    private void fieldEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldEmailKeyReleased
        email = fieldEmail.getText();
        validateEmail();
    }//GEN-LAST:event_fieldEmailKeyReleased

    private void fieldPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldPhoneKeyReleased
        mobileNo = fieldPhone.getText();
        validatePhone();
    }//GEN-LAST:event_fieldPhoneKeyReleased

    private void uploadButtonPanelClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadButtonPanelClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filePath = f.getAbsolutePath();
        textFieldFileName.setText(filePath);
        try {
            //get the image from file chooser and scale it to match JLabel size
            ImageIcon ii = new ImageIcon(scaleImage(180, 190, ImageIO.read(new File(f.getAbsolutePath()))));
            labelProfilePhoto.setIcon(ii);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_uploadButtonPanelClicked

    private void nextButtonPanelClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonPanelClicked
        saveAndNext();
    }//GEN-LAST:event_nextButtonPanelClicked

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
            java.util.logging.Logger.getLogger(RegistrationFormPage1Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormPage1Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormPage1Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormPage1Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrationFormPage1Jframe jframe = new RegistrationFormPage1Jframe();
                jframe.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo fieldDateOfBirth;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldFirstName;
    private javax.swing.JComboBox<String> fieldGender;
    private javax.swing.JTextField fieldLastName;
    private javax.swing.JTextField fieldMiddleName;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JComboBox<String> fieldRegisterAs;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDateOfBirth;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEmailError;
    private javax.swing.JLabel labelFirstName;
    private javax.swing.JLabel labelFirstNameError;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelLastNameError;
    private javax.swing.JLabel labelMiddleName;
    private javax.swing.JLabel labelMiddleNameError;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelPhoneError;
    private javax.swing.JLabel labelProfilePhoto;
    private javax.swing.JLabel labelTopImage;
    private javax.swing.JPanel nextButtonPanel;
    private javax.swing.JTextField textFieldFileName;
    private javax.swing.JPanel uploadButtonPanel;
    // End of variables declaration//GEN-END:variables
}
