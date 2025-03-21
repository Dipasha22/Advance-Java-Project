/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement_system;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Rushikesh Sapkale
 */

public class ViewAllRecords extends javax.swing.JFrame {
DefaultTableModel model;
    /**
     * Creates new form ViewAllRecords
     */
    public ViewAllRecords() {
    
        initComponents();
            setRecords();
        
    }
     public void setRecords() {
        try {
            java.sql.Connection con = DBconnection.getConnection();
            PreparedStatement smt = con.prepareStatement("Select * from fees_detail");
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
           int recieptno = rs.getInt("reciept_no");
                String rollno = rs.getString("rollno");
                String  studentname = rs.getString("student_name");
                 String  paymentmode = rs.getString("payment_mode");
                  String  course = rs.getString("course");
                   String  total_amount = rs.getString("total_amount");
                String  remark = rs.getString("remark");
                   
                   Object[] obj={recieptno,rollno,studentname,paymentmode,course,total_amount,remark};
                  model=(DefaultTableModel) jtbl_data.getModel();
                  model.addRow(obj);
               
               
        }

            
        } catch (Exception e) {
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

        panelsidebar = new javax.swing.JPanel();
        PANELHOME = new javax.swing.JPanel();
        lblhome = new javax.swing.JLabel();
        PANELHOME1 = new javax.swing.JPanel();
        lblhome1 = new javax.swing.JLabel();
        PANELHOME2 = new javax.swing.JPanel();
        lblhome2 = new javax.swing.JLabel();
        PANELHOME3 = new javax.swing.JPanel();
        lblhome3 = new javax.swing.JLabel();
        PANELHOME4 = new javax.swing.JPanel();
        lblhome4 = new javax.swing.JLabel();
        PANELHOME6 = new javax.swing.JPanel();
        lblhome6 = new javax.swing.JLabel();
        PANELHOME5 = new javax.swing.JPanel();
        lblhome5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_data = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1301, 748));

        panelsidebar.setBackground(new java.awt.Color(0, 102, 102));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PANELHOME.setBackground(new java.awt.Color(0, 102, 102));
        PANELHOME.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        PANELHOME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANELHOMEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PANELHOMEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PANELHOMEMouseExited(evt);
            }
        });
        PANELHOME.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhome.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        lblhome.setForeground(new java.awt.Color(255, 255, 255));
        lblhome.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\search2.png")); // NOI18N
        lblhome.setText("Search Record");
        PANELHOME.add(lblhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 70));

        panelsidebar.add(PANELHOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 330, 70));

        PANELHOME1.setBackground(new java.awt.Color(0, 102, 102));
        PANELHOME1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        PANELHOME1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANELHOME1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PANELHOME1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PANELHOME1MouseExited(evt);
            }
        });
        PANELHOME1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhome1.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        lblhome1.setForeground(new java.awt.Color(255, 255, 255));
        lblhome1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\edit2.png")); // NOI18N
        lblhome1.setText("Edit Course");
        PANELHOME1.add(lblhome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 70));

        panelsidebar.add(PANELHOME1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 330, 70));

        PANELHOME2.setBackground(new java.awt.Color(0, 102, 102));
        PANELHOME2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        PANELHOME2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANELHOME2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PANELHOME2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PANELHOME2MouseExited(evt);
            }
        });
        PANELHOME2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhome2.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        lblhome2.setForeground(new java.awt.Color(255, 255, 255));
        lblhome2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\list_1.png")); // NOI18N
        lblhome2.setText("Edit Details");
        PANELHOME2.add(lblhome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 70));

        panelsidebar.add(PANELHOME2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 330, 70));

        PANELHOME3.setBackground(new java.awt.Color(0, 102, 102));
        PANELHOME3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        PANELHOME3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANELHOME3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PANELHOME3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PANELHOME3MouseExited(evt);
            }
        });
        PANELHOME3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhome3.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        lblhome3.setForeground(new java.awt.Color(255, 255, 255));
        lblhome3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\view all record.png")); // NOI18N
        lblhome3.setText("View All Records");
        PANELHOME3.add(lblhome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 70));

        panelsidebar.add(PANELHOME3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 330, 70));

        PANELHOME4.setBackground(new java.awt.Color(0, 102, 102));
        PANELHOME4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        PANELHOME4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANELHOME4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PANELHOME4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PANELHOME4MouseExited(evt);
            }
        });
        PANELHOME4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhome4.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        lblhome4.setForeground(new java.awt.Color(255, 255, 255));
        lblhome4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\left-arrow.png")); // NOI18N
        lblhome4.setText("Back");
        PANELHOME4.add(lblhome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 70));

        panelsidebar.add(PANELHOME4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 330, 70));

        PANELHOME6.setBackground(new java.awt.Color(0, 102, 102));
        PANELHOME6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        PANELHOME6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANELHOME6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PANELHOME6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PANELHOME6MouseExited(evt);
            }
        });
        PANELHOME6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhome6.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        lblhome6.setForeground(new java.awt.Color(255, 255, 255));
        lblhome6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\home.png")); // NOI18N
        lblhome6.setText("Home");
        PANELHOME6.add(lblhome6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 70));

        panelsidebar.add(PANELHOME6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 330, 70));

        PANELHOME5.setBackground(new java.awt.Color(0, 102, 102));
        PANELHOME5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        PANELHOME5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANELHOME5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PANELHOME5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PANELHOME5MouseExited(evt);
            }
        });
        PANELHOME5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhome5.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        lblhome5.setForeground(new java.awt.Color(255, 255, 255));
        lblhome5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rushikesh Sapkale\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\com\\mycompany\\fees_management_system\\images\\logout.png")); // NOI18N
        lblhome5.setText("Logout");
        PANELHOME5.add(lblhome5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 70));

        panelsidebar.add(PANELHOME5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 330, 70));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jtbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reciept No", "Roll no", "Student Name", "Payment Mode", "Course", "Total Amount", "Remark"
            }
        ));
        jtbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_data);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelsidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelsidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PANELHOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOMEMouseClicked
        SearchRecord searchRecord =new SearchRecord();
        searchRecord.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PANELHOMEMouseClicked

    private void PANELHOMEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOMEMouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME.setBackground(clr);
    }//GEN-LAST:event_PANELHOMEMouseEntered

    private void PANELHOMEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOMEMouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME.setBackground(clr);
    }//GEN-LAST:event_PANELHOMEMouseExited

    private void PANELHOME1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME1MouseClicked
        EditCourse editCourse =new EditCourse();
        editCourse.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PANELHOME1MouseClicked

    private void PANELHOME1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME1MouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME1.setBackground(clr); // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME1MouseEntered

    private void PANELHOME1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME1MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME1.setBackground(clr); // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME1MouseExited

    private void PANELHOME2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME2MouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME2.setBackground(clr); // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME2MouseEntered

    private void PANELHOME2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME2MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME2.setBackground(clr); // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME2MouseExited

    private void PANELHOME3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME3MouseClicked
        ViewAllRecords viewAllRecords=new ViewAllRecords();
        viewAllRecords.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PANELHOME3MouseClicked

    private void PANELHOME3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME3MouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME3.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME3MouseEntered

    private void PANELHOME3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME3MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME3.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME3MouseExited

    private void PANELHOME4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME4MouseClicked
        Home home =new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PANELHOME4MouseClicked

    private void PANELHOME4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME4MouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME4.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME4MouseEntered

    private void PANELHOME4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME4MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME4.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME4MouseExited

    private void PANELHOME6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME6MouseClicked
        Home home =new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PANELHOME6MouseClicked

    private void PANELHOME6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME6MouseEntered

        Color clr = new Color(0, 153, 152);
        PANELHOME6.setBackground(clr);
    }//GEN-LAST:event_PANELHOME6MouseEntered

    private void PANELHOME6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME6MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME6.setBackground(clr);
    }//GEN-LAST:event_PANELHOME6MouseExited

    private void PANELHOME5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME5MouseClicked
        Login login =new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PANELHOME5MouseClicked

    private void PANELHOME5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME5MouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME5.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME5MouseEntered

    private void PANELHOME5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME5MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME5.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME5MouseExited

    private void jtbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_dataMouseClicked
      
        TableModel model= jtbl_data.getModel();
        
       
        
    }//GEN-LAST:event_jtbl_dataMouseClicked

    private void PANELHOME2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME2MouseClicked
  UpdateFeesDetails updateFeesDetails=new UpdateFeesDetails();
      updateFeesDetails.setVisible(true);
      this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME2MouseClicked

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
            java.util.logging.Logger.getLogger(ViewAllRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANELHOME;
    private javax.swing.JPanel PANELHOME1;
    private javax.swing.JPanel PANELHOME2;
    private javax.swing.JPanel PANELHOME3;
    private javax.swing.JPanel PANELHOME4;
    private javax.swing.JPanel PANELHOME5;
    private javax.swing.JPanel PANELHOME6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbl_data;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblhome1;
    private javax.swing.JLabel lblhome2;
    private javax.swing.JLabel lblhome3;
    private javax.swing.JLabel lblhome4;
    private javax.swing.JLabel lblhome5;
    private javax.swing.JLabel lblhome6;
    private javax.swing.JPanel panelsidebar;
    // End of variables declaration//GEN-END:variables
}
