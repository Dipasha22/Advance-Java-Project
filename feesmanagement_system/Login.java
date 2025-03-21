/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Rushikesh Sapkale
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
     void userVerification(String username,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management?zeroDateTimeBehavior=CONVERT_TO_NULL","root","system");
            String sql="select * from signup where username=? and password=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, username);
             pst.setString(2, password);
             ResultSet rs=pst.executeQuery();
             if(rs.next()){
                 JOptionPane.showMessageDialog(this,"Login Sucessful");
                 Home home=new Home();
                 home.show();
                this.dispose();
             }else
             {
                 JOptionPane.showMessageDialog(this,"wrong username and password");
             }
             
        }
        catch(Exception e){
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        EXIT = new javax.swing.JButton();
        SINGUP = new javax.swing.JButton();
        lbl_login_err = new javax.swing.JLabel();
        lbl_password_err2 = new javax.swing.JLabel();
        lbl_contact_err = new javax.swing.JLabel();
        lbl_password_err3 = new javax.swing.JLabel();
        LOGIN2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\new-user.png")); // NOI18N
        jLabel2.setText("LOGIN");
        jLabel2.setMaximumSize(new java.awt.Dimension(48, 90));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 80));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

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

        EXIT.setBackground(new java.awt.Color(0, 102, 102));
        EXIT.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        EXIT.setForeground(new java.awt.Color(255, 255, 255));
        EXIT.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\exit.png")); // NOI18N
        EXIT.setText("EXIT");
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });
        jPanel2.add(EXIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 250, 100, 40));

        SINGUP.setBackground(new java.awt.Color(0, 102, 102));
        SINGUP.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        SINGUP.setForeground(new java.awt.Color(255, 255, 255));
        SINGUP.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\signup.png")); // NOI18N
        SINGUP.setText("SIGNUP");
        SINGUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SINGUPActionPerformed(evt);
            }
        });
        jPanel2.add(SINGUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 120, 40));

        lbl_login_err.setForeground(new java.awt.Color(255, 0, 0));
        lbl_login_err.setName(""); // NOI18N
        jPanel2.add(lbl_login_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 230, 40));

        lbl_password_err2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_password_err2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 230, 40));

        lbl_contact_err.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_contact_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 210, 30));

        lbl_password_err3.setForeground(new java.awt.Color(255, 0, 0));
        lbl_password_err3.setName(""); // NOI18N
        jPanel2.add(lbl_password_err3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 230, 40));

        LOGIN2.setBackground(new java.awt.Color(0, 102, 102));
        LOGIN2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        LOGIN2.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\login.png")); // NOI18N
        LOGIN2.setText("LOGIN");
        LOGIN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGIN2ActionPerformed(evt);
            }
        });
        jPanel2.add(LOGIN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 100, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 490, 320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyPressed

    }//GEN-LAST:event_PasswordKeyPressed

    private void PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordKeyReleased

    private void PasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordKeyTyped

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_EXITActionPerformed

    private void SINGUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SINGUPActionPerformed
        Signup_Page signup= new Signup_Page();
        signup.show();
        this.dispose();
    }//GEN-LAST:event_SINGUPActionPerformed

    private void LOGIN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGIN2ActionPerformed
        String username=Username.getText();
        String password=Password.getText();

        if(username.trim().equals("")||password.trim().equals("")){
            lbl_login_err.setText("Please enter Username and Password");
        }
        else
        {
             userVerification(username, password);
        }
    }//GEN-LAST:event_LOGIN2ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EXIT;
    private javax.swing.JButton LOGIN2;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton SINGUP;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact_err;
    private javax.swing.JLabel lbl_login_err;
    private javax.swing.JLabel lbl_password_err2;
    private javax.swing.JLabel lbl_password_err3;
    // End of variables declaration//GEN-END:variables
}
