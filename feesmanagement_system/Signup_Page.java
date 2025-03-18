/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement_system;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Rushikesh Sapkale
 */
public class Signup_Page extends javax.swing.JFrame {

    String fname, lname, uname, password, con_pass, contact_no;

    public Signup_Page() {
        initComponents();
    }

    public int getId() {
        int Id = 0;
        ResultSet rs = null;
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "system");
            String sql = "select max(Id) from signup";

            Statement smt = con.createStatement();
            rs = smt.executeQuery(sql);
            while (rs.next()) {

                Id = rs.getInt(1);
                Id++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Id;
    }

    boolean validation() {

        fname = Firstname.getText();
        lname = Lastname.getText();
        uname = Username.getText();
        password = Password.getText();
        con_pass = ConfirmPassword.getText();
        contact_no = Contact_No.getText();
        if (fname.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter Firstname");
            return false;
        }
        if (lname.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter Lastname");
            return false;
        }

        if (uname.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter Username");
            return false;
        }
        if (password.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter Password");
            return false;
        }
        if (con_pass.equals("")) {
            JOptionPane.showMessageDialog(this, "please confirm Password");
            return false;
        }

        if (contact_no.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter Contact no.");
            return false;
        }
        if (!password.equals(con_pass)) {
            JOptionPane.showMessageDialog(this, "Enter correct Confirm Password");
            return false;
        }

        return true;

    }

    public void checkPassword() {
        password = Password.getText();
        if (password.length() < 8) {
            lbl_password_err.setText("Password must be more than 8 Characters");

        } else {
            lbl_password_err.setText("");
        }

    }

    public void checkContact() {
        contact_no = Contact_No.getText();
        if (contact_no.length() < 10) {
            lbl_contact_err.setText("Enter 10 Digit Contact Number");

        } else {
            lbl_contact_err.setText("");
        }

    }

    void insertDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "system");
            String sql = "insert into signup values(?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(sql);
            // smt=con.createStatement();
            smt.setInt(1, getId());
            smt.setString(2, fname);
            smt.setString(3, lname);
            smt.setString(4, uname);
            smt.setString(5, password);
            smt.setString(6, contact_no);
            int i = smt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Record inserted sucessfully");
            } else {
                JOptionPane.showMessageDialog(this, "Record not Inserted");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Contact_No = new javax.swing.JTextField();
        Firstname = new javax.swing.JTextField();
        Lastname = new javax.swing.JTextField();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        ConfirmPassword = new javax.swing.JPasswordField();
        LOGIN = new javax.swing.JButton();
        SINGUP = new javax.swing.JButton();
        lbl_password_err = new javax.swing.JLabel();
        lbl_password_err1 = new javax.swing.JLabel();
        lbl_password_err2 = new javax.swing.JLabel();
        lbl_contact_err = new javax.swing.JLabel();
        lbl_password_err3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGNUP");
        jLabel1.setMaximumSize(new java.awt.Dimension(48, 90));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 90, 41));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 60));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lastname :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 160, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Contact No. :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Firstname :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        Contact_No.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Contact_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Contact_NoActionPerformed(evt);
            }
        });
        Contact_No.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Contact_NoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Contact_NoKeyReleased(evt);
            }
        });
        jPanel2.add(Contact_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 210, 30));

        Firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstnameActionPerformed(evt);
            }
        });
        jPanel2.add(Firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 210, 30));

        Lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastnameActionPerformed(evt);
            }
        });
        jPanel2.add(Lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 210, 30));

        Username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        jPanel2.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 210, 30));

        Password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PasswordKeyTyped(evt);
            }
        });
        jPanel2.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 210, 30));

        ConfirmPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(ConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 30));

        LOGIN.setBackground(new java.awt.Color(0, 102, 102));
        LOGIN.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN.setText("LOGIN");
        LOGIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOGINMouseClicked(evt);
            }
        });
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });
        jPanel2.add(LOGIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        SINGUP.setBackground(new java.awt.Color(0, 102, 102));
        SINGUP.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        SINGUP.setForeground(new java.awt.Color(255, 255, 255));
        SINGUP.setText("SIGNUP");
        SINGUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SINGUPActionPerformed(evt);
            }
        });
        jPanel2.add(SINGUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        lbl_password_err.setForeground(new java.awt.Color(255, 0, 0));
        lbl_password_err.setName(""); // NOI18N
        jPanel2.add(lbl_password_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 230, 40));

        lbl_password_err1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_password_err1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 230, 40));

        lbl_password_err2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_password_err2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 230, 40));

        lbl_contact_err.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_contact_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 210, 30));

        lbl_password_err3.setForeground(new java.awt.Color(255, 0, 0));
        lbl_password_err3.setName(""); // NOI18N
        jPanel2.add(lbl_password_err3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 230, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 490, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Contact_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Contact_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Contact_NoActionPerformed

    private void Contact_NoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Contact_NoKeyPressed
        checkContact();        // TODO add your handling code here:
    }//GEN-LAST:event_Contact_NoKeyPressed

    private void Contact_NoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Contact_NoKeyReleased
        checkContact();
    }//GEN-LAST:event_Contact_NoKeyReleased

    private void FirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstnameActionPerformed

    private void LastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastnameActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyPressed
        checkPassword();
    }//GEN-LAST:event_PasswordKeyPressed

    private void PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyReleased
        checkPassword();        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordKeyReleased

    private void PasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyTyped
        checkPassword();        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordKeyTyped

    private void ConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmPasswordActionPerformed

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
        Login login=new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LOGINActionPerformed

    private void SINGUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SINGUPActionPerformed

        if (validation()) {
            insertDetails();
        }
    }//GEN-LAST:event_SINGUPActionPerformed

    private void LOGINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LOGINMouseClicked

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
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JTextField Contact_No;
    private javax.swing.JTextField Firstname;
    private javax.swing.JButton LOGIN;
    private javax.swing.JTextField Lastname;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton SINGUP;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact_err;
    private javax.swing.JLabel lbl_password_err;
    private javax.swing.JLabel lbl_password_err1;
    private javax.swing.JLabel lbl_password_err2;
    private javax.swing.JLabel lbl_password_err3;
    // End of variables declaration//GEN-END:variables
}
