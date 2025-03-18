package feesmanagement_system;

import java.awt.Color;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Rushikesh Sapkale
 */
public final class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public AddFees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        int recieptNo = getReceipteNo();
        txtrecipteno.setText(Integer.toString(recieptNo));

    }

    public int getId() {
        int Id = 0;
        ResultSet rs = null;
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "system");
            String sql = "select max(reciept_no) from fees_detail";

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

    public final void displayCashFirst() {
        lbldd.setVisible(false);
        lblchecque.setVisible(false);
        lblbankname.setVisible(false);
        ddno.setVisible(false);
        Chequeno.setVisible(false);
        txtbankname.setVisible(false);
    }

    public boolean validation() {
        if (txtrecivefrom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Kindly enter the Receivername");
            return false;
        }
        if (txtrecipteno.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Kindly enter the Recipte number");
            return false;
        }
        /* if(paymode.getSelectedItem().equals("")){
           JOptionPane.showMessageDialog(this,"Kindly select the payment mode");
           return false;
       }*/
 /*if(ddno.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Kindly enter the DD Number");
           return false;
       }
       if(Chequeno.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Kindly enter the Cheque number");
           return false;
       }*/
        if (jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Kindly select date");
            return false;
        }
        if (txtyear1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Kindly enter the Year");
            return false;
        }

        if (txthead.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Kindly enter the details");
            return false;
        }
        if (jTextFieldamt1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Kindly enter the Amount");
            return false;
        }
        if (paymode.getSelectedItem().toString().equalsIgnoreCase("Cheque")) {
            if (Chequeno.getText().equals((""))) {
                JOptionPane.showMessageDialog(this, "Kindly enter the Cheque number");
                return false;
            }
            if (txtbankname.getText().equals((""))) {
                JOptionPane.showMessageDialog(this, "Kindly enter the Bank name");
                return false;
            }

        }
        if (paymode.getSelectedItem().toString().equalsIgnoreCase("DD")) {
            if (ddno.getText().equals((""))) {
                JOptionPane.showMessageDialog(this, "Kindly enter the DD number");
                return false;
            }
            if (txtbankname.getText().equals((""))) {
                JOptionPane.showMessageDialog(this, "Kindly enter the Bank name");
                return false;
            }
            if (paymode.getSelectedItem().toString().equalsIgnoreCase("Card")) {
                if (ddno.getText().equals((""))) {
                    JOptionPane.showMessageDialog(this, "Kindly enter the Cheque number");
                    return false;
                }
                if (txtbankname.getText().equals((""))) {
                    JOptionPane.showMessageDialog(this, "Kindly enter the Bank name");
                    return false;
                }

            }
            if (paymode.getSelectedItem().toString().equalsIgnoreCase("Card")) {

                if (txtbankname.getText().equals((""))) {
                    JOptionPane.showMessageDialog(this, "Kindly enter the Bank name");
                    return false;
                }

            }

        }

        return true;
    }

    public int getReceipteNo() {
        int recieptNo = 0;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement smt = con.prepareStatement("select max(reciept_no) from fees_detail");
            ResultSet rs = smt.executeQuery();
            if (rs.next() == true) {
               recieptNo = rs.getInt(1);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return recieptNo + 1;

    }

    String insertData() {
        String status="";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "system");
            /* String sql = "insert into fees_detail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(sql);

            smt.setInt(1, getId());
            smt.setString(2, txtrecivefrom.getText());
            //  smt.setInt( 3,Integer.parseInt(txtroll.getText()));

            String mode;
            mode = paymode.getSelectedItem().toString();
            smt.setString(3, mode);

            smt.setString(4,Chequeno.getText());
            smt.setString(5, txtbankname.getText());
            smt.setString(6, ddno.getText());

            String course;
            course = jComboBox2Course.getSelectedItem().toString();
            smt.setString(7, course);

            smt.setString(8, gstin.getText());
            smt.setString(9,jTextFieldamt4.getText());

            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd");
            String date = dateFormat.format(jDateChooser2.getDate());
            smt.setString(10, date);

            smt.setString(11, jTextFieldamt1.getText());
            smt.setString(12, jTextFieldamt2.getText());
            smt.setString(13, jTextFieldamt3.getText());
            smt.setString(14, totalinwords.getText());
            smt.setString(15, jTextArea1remark.getText());
           smt.setString(16, txtyear1.getText());
            smt.setString(17, txtyear2.getText());
          int i = smt.executeUpdate();*/
           
            String sql = "insert into fees_detail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, getId());
            
            smt.setString(2, txtroll.getText());
            smt.setString(3, txtrecivefrom.getText());
            String mode;
            mode = paymode.getSelectedItem().toString();
            smt.setString(4, mode);
            smt.setString(5, Chequeno.getText());
            smt.setString(6, txtbankname.getText());
            smt.setString(7, ddno.getText());
            String course;
            course = jComboBox2Course.getSelectedItem().toString();
            smt.setString(8, course);
            smt.setString(9, gstin.getText());
            smt.setString(10, jTextFieldamt4.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
            String date = dateFormat.format(jDateChooser2.getDate());
            smt.setString(11, date);

            smt.setString(12, jTextFieldamt1.getText());
            smt.setString(13, jTextFieldamt2.getText());
            smt.setString(14, jTextFieldamt3.getText());
            smt.setString(15, totalinwords.getText());
            smt.setString(16, jTextArea1remark.getText());
            smt.setString(17, txtyear1.getText());
            smt.setString(18, txtyear2.getText());
            int rowcount=smt.executeUpdate();
            con.close();
            if (rowcount == 1) {
                status ="Sucess";
            }
            else{
                status="failed";
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
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
        panelParent = new javax.swing.JPanel();
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
        gstin = new javax.swing.JLabel();
        lblmodepay = new javax.swing.JLabel();
        recipteno = new javax.swing.JLabel();
        lbldd = new javax.swing.JLabel();
        lblchecque = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        txtrecipteno = new javax.swing.JTextField();
        paymode = new javax.swing.JComboBox<>();
        panelChild = new javax.swing.JPanel();
        addfeeslbl8 = new javax.swing.JLabel();
        lblroll = new javax.swing.JLabel();
        lblyear = new javax.swing.JLabel();
        txtyear2 = new javax.swing.JTextField();
        txtyear1 = new javax.swing.JTextField();
        addfeeslbl12 = new javax.swing.JLabel();
        jComboBox2Course = new javax.swing.JComboBox<>();
        addfeeslbl13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblcourse = new javax.swing.JLabel();
        addfeeslbl15 = new javax.swing.JLabel();
        addfeeslbl16 = new javax.swing.JLabel();
        totalinwords = new javax.swing.JTextField();
        jTextFieldamt4 = new javax.swing.JTextField();
        jTextFieldamt1 = new javax.swing.JTextField();
        jTextFieldamt2 = new javax.swing.JTextField();
        jTextFieldamt3 = new javax.swing.JTextField();
        txtrecivefrom = new javax.swing.JTextField();
        lblrecive = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        addfeeslbl18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1remark = new javax.swing.JTextArea();
        lblcgst = new javax.swing.JLabel();
        lblsgst = new javax.swing.JLabel();
        addfeeslbl21 = new javax.swing.JLabel();
        txthead = new javax.swing.JTextField();
        txtroll = new javax.swing.JTextField();
        Printbtn = new javax.swing.JButton();
        lblbankname = new javax.swing.JLabel();
        txtbankname = new javax.swing.JTextField();
        ddno = new javax.swing.JTextField();
        Chequeno = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        lblgstin1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelParent.setBackground(new java.awt.Color(0, 153, 153));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        panelParent.add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 440, 720));

        gstin.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        gstin.setForeground(new java.awt.Color(255, 255, 255));
        gstin.setText("TXN1323248");
        panelParent.add(gstin, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 170, -1));

        lblmodepay.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblmodepay.setForeground(new java.awt.Color(255, 255, 255));
        lblmodepay.setText("Mode of Payment");
        panelParent.add(lblmodepay, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        recipteno.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        recipteno.setForeground(new java.awt.Color(255, 255, 255));
        recipteno.setText("Recipte No. : GPP");
        panelParent.add(recipteno, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        lbldd.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lbldd.setForeground(new java.awt.Color(255, 255, 255));
        lbldd.setText("DD no. :");
        panelParent.add(lbldd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        lblchecque.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblchecque.setForeground(new java.awt.Color(255, 255, 255));
        lblchecque.setText("Cheque No.");
        panelParent.add(lblchecque, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        lbldate.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lbldate.setForeground(new java.awt.Color(255, 255, 255));
        lbldate.setText("Date :");
        panelParent.add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, -1));

        txtrecipteno.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtrecipteno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreciptenoActionPerformed(evt);
            }
        });
        panelParent.add(txtrecipteno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 220, -1));

        paymode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "CHEQUE", "CASH", "CARD" }));
        paymode.setSelectedIndex(2);
        paymode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        paymode.setName(""); // NOI18N
        paymode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymodeActionPerformed(evt);
            }
        });
        panelParent.add(paymode, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 100, -1));

        panelChild.setBackground(new java.awt.Color(0, 153, 153));
        panelChild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addfeeslbl8.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        addfeeslbl8.setForeground(new java.awt.Color(255, 255, 255));
        addfeeslbl8.setText("to");
        panelChild.add(addfeeslbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        lblroll.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblroll.setForeground(new java.awt.Color(255, 255, 255));
        lblroll.setText("Roll No. :");
        panelChild.add(lblroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        lblyear.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblyear.setForeground(new java.awt.Color(255, 255, 255));
        lblyear.setText("The following payment the collage office for the year :");
        panelChild.add(lblyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        txtyear2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtyear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyear2ActionPerformed(evt);
            }
        });
        panelChild.add(txtyear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 90, -1));

        txtyear1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtyear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyear1ActionPerformed(evt);
            }
        });
        panelChild.add(txtyear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 90, -1));

        addfeeslbl12.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        addfeeslbl12.setForeground(new java.awt.Color(255, 255, 255));
        addfeeslbl12.setText("Reciver Signature ");
        panelChild.add(addfeeslbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, -1, -1));

        jComboBox2Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2CourseActionPerformed(evt);
            }
        });
        panelChild.add(jComboBox2Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 200, -1));

        addfeeslbl13.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        addfeeslbl13.setForeground(new java.awt.Color(255, 255, 255));
        addfeeslbl13.setText("Amount");
        panelChild.add(addfeeslbl13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelChild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 950, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panelChild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 950, 20));

        lblcourse.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblcourse.setForeground(new java.awt.Color(255, 255, 255));
        lblcourse.setText("Course :");
        panelChild.add(lblcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        addfeeslbl15.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        addfeeslbl15.setForeground(new java.awt.Color(255, 255, 255));
        addfeeslbl15.setText("Sr No.");
        panelChild.add(addfeeslbl15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        addfeeslbl16.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        addfeeslbl16.setForeground(new java.awt.Color(255, 255, 255));
        addfeeslbl16.setText("Head ");
        panelChild.add(addfeeslbl16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        totalinwords.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        totalinwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalinwordsActionPerformed(evt);
            }
        });
        panelChild.add(totalinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 270, -1));

        jTextFieldamt4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextFieldamt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldamt4ActionPerformed(evt);
            }
        });
        panelChild.add(jTextFieldamt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 220, -1));

        jTextFieldamt1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextFieldamt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldamt1ActionPerformed(evt);
            }
        });
        panelChild.add(jTextFieldamt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 220, -1));

        jTextFieldamt2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextFieldamt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldamt2ActionPerformed(evt);
            }
        });
        panelChild.add(jTextFieldamt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 220, -1));

        jTextFieldamt3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextFieldamt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldamt3ActionPerformed(evt);
            }
        });
        panelChild.add(jTextFieldamt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 220, -1));

        txtrecivefrom.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtrecivefrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrecivefromActionPerformed(evt);
            }
        });
        panelChild.add(txtrecivefrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 330, -1));

        lblrecive.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblrecive.setForeground(new java.awt.Color(255, 255, 255));
        lblrecive.setText("Recieved from :");
        panelChild.add(lblrecive, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        panelChild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 280, 10));
        panelChild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 290, 10));

        addfeeslbl18.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        addfeeslbl18.setForeground(new java.awt.Color(255, 255, 255));
        addfeeslbl18.setText("Total in words :");
        panelChild.add(addfeeslbl18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, -1));

        jTextArea1remark.setColumns(20);
        jTextArea1remark.setRows(5);
        jScrollPane2.setViewportView(jTextArea1remark);

        panelChild.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 310, 80));

        lblcgst.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblcgst.setForeground(new java.awt.Color(255, 255, 255));
        lblcgst.setText("CGST 9%:");
        panelChild.add(lblcgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        lblsgst.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblsgst.setForeground(new java.awt.Color(255, 255, 255));
        lblsgst.setText("SGST  9%:");
        panelChild.add(lblsgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        addfeeslbl21.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        addfeeslbl21.setForeground(new java.awt.Color(255, 255, 255));
        addfeeslbl21.setText("Remark :");
        panelChild.add(addfeeslbl21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        txthead.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txthead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtheadActionPerformed(evt);
            }
        });
        panelChild.add(txthead, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 240, -1));

        txtroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrollActionPerformed(evt);
            }
        });
        panelChild.add(txtroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 82, 150, 30));

        Printbtn.setText("Print");
        Printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintbtnActionPerformed(evt);
            }
        });
        panelChild.add(Printbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));

        panelParent.add(panelChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 1050, 500));

        lblbankname.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblbankname.setForeground(new java.awt.Color(255, 255, 255));
        lblbankname.setText("Bank Name :");
        panelParent.add(lblbankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        txtbankname.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtbankname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbanknameActionPerformed(evt);
            }
        });
        panelParent.add(txtbankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 220, -1));

        ddno.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        ddno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddnoActionPerformed(evt);
            }
        });
        panelParent.add(ddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 220, -1));

        Chequeno.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Chequeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChequenoActionPerformed(evt);
            }
        });
        panelParent.add(Chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 220, -1));
        panelParent.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 150, -1));

        lblgstin1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblgstin1.setForeground(new java.awt.Color(255, 255, 255));
        lblgstin1.setText("GSTIN :");
        panelParent.add(lblgstin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, -1, -1));

        jScrollPane1.setViewportView(panelParent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PANELHOMEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOMEMouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME.setBackground(clr);
    }//GEN-LAST:event_PANELHOMEMouseEntered

    private void PANELHOMEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOMEMouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME.setBackground(clr);
    }//GEN-LAST:event_PANELHOMEMouseExited

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

    private void PANELHOME3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME3MouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME3.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME3MouseEntered

    private void PANELHOME3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME3MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME3.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME3MouseExited

    private void PANELHOME4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME4MouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME4.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME4MouseEntered

    private void PANELHOME4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME4MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME4.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME4MouseExited

    private void PANELHOME6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME6MouseEntered

        Color clr = new Color(0, 153, 152);
        PANELHOME6.setBackground(clr);
    }//GEN-LAST:event_PANELHOME6MouseEntered

    private void PANELHOME6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME6MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME6.setBackground(clr);
    }//GEN-LAST:event_PANELHOME6MouseExited

    private void PANELHOME5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME5MouseEntered
        Color clr = new Color(0, 153, 152);
        PANELHOME5.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME5MouseEntered

    private void PANELHOME5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME5MouseExited
        Color clr = new Color(0, 103, 103);
        PANELHOME5.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_PANELHOME5MouseExited

    private void txtreciptenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreciptenoActionPerformed
        
    }//GEN-LAST:event_txtreciptenoActionPerformed

    private void paymodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymodeActionPerformed
        if (paymode.getSelectedIndex() == 0) {
            lbldd.setVisible(true);
            ddno.setVisible(true);
            lblchecque.setVisible(false);
            Chequeno.setVisible(false);
            lblbankname.setVisible(true);
            txtbankname.setVisible(true);
        }
        if (paymode.getSelectedIndex() == 1) {
            lbldd.setVisible(false);
            ddno.setVisible(false);
            lblchecque.setVisible(true);
            Chequeno.setVisible(true);
            lblbankname.setVisible(true);
            txtbankname.setVisible(true);
        }
        if (paymode.getSelectedIndex() == 2) {
            lbldd.setVisible(false);
            ddno.setVisible(false);
            lblchecque.setVisible(false);
            Chequeno.setVisible(false);
            lblbankname.setVisible(false);
            txtbankname.setVisible(false);
        }
        if (paymode.getSelectedIndex() == 3) {
            lbldd.setVisible(false);
            ddno.setVisible(false);
            lblchecque.setVisible(false);
            Chequeno.setVisible(false);
            lblbankname.setVisible(true);
            txtbankname.setVisible(true);
        }
    }//GEN-LAST:event_paymodeActionPerformed
    public final void fillComboBox() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "system");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("Select Cname from course");
            while (rs.next()) {
                //  System.out.println(rs.getString("Cname"));
                jComboBox2Course.addItem(rs.getString("Cname"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getReceiptNo(){
        int recieptNo=0;
        
        try {
             
              Connection con=DBconnection.getConnection();
            PreparedStatement pst=con.prepareStatement("Select reciept_no from fees_detail");
            ResultSet rs=pst.executeQuery();
            
           if(rs.next()==true){
              recieptNo=rs.getInt("reciept_no");
              
               
           }  
        } catch (Exception e) {
           e.printStackTrace();
        }
        return recieptNo+1;
        
    }
    private void txtyear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyear2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyear2ActionPerformed

    private void txtyear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyear1ActionPerformed

    private void jComboBox2CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2CourseActionPerformed
        txthead.setText(jComboBox2Course.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox2CourseActionPerformed

    private void totalinwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalinwordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalinwordsActionPerformed

    private void jTextFieldamt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldamt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldamt4ActionPerformed

    private void jTextFieldamt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldamt1ActionPerformed
        float amt = Float.parseFloat(jTextFieldamt1.getText());
        Float cgst = (amt * 0.09f);
        Float sgst = (amt * 0.09f);
        jTextFieldamt2.setText(cgst.toString());
        jTextFieldamt3.setText(sgst.toString());

        float total = amt + cgst + sgst;
        jTextFieldamt4.setText(Float.toString(total));
        totalinwords.setText(NumbertoWordsConverter.convert((int) total) + " only");

    }//GEN-LAST:event_jTextFieldamt1ActionPerformed

    private void jTextFieldamt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldamt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldamt2ActionPerformed

    private void jTextFieldamt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldamt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldamt3ActionPerformed

    private void txtrecivefromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrecivefromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrecivefromActionPerformed

    private void txtheadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtheadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtheadActionPerformed

    private void txtbanknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbanknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbanknameActionPerformed

    private void ddnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddnoActionPerformed

    private void ChequenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChequenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChequenoActionPerformed

    private void txtrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrollActionPerformed

    private void PrintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintbtnActionPerformed
        if (validation() == true) {
          String result=  insertData();
          if(result.equals("Sucess")){
              JOptionPane.showMessageDialog(this,"record inserted successfully");
              PrintReceipt p=new PrintReceipt();
              p.setVisible(true);
              this.dispose();
          }
          
        } else {
            JOptionPane.showMessageDialog(this, "Record Insert Failed");
        }
    }//GEN-LAST:event_PrintbtnActionPerformed

    private void PANELHOME6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME6MouseClicked
        Home home=new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PANELHOME6MouseClicked

    private void PANELHOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOMEMouseClicked
      SearchRecord searchRecord=new SearchRecord();
      searchRecord.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_PANELHOMEMouseClicked

    private void PANELHOME1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME1MouseClicked
      EditCourse editCourse=new EditCourse();
      editCourse.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_PANELHOME1MouseClicked

    private void PANELHOME3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME3MouseClicked
       ViewAllRecords viewAllRecords=new ViewAllRecords();
       viewAllRecords.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_PANELHOME3MouseClicked

    private void PANELHOME5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME5MouseClicked
        Login login=new Login();
         login.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_PANELHOME5MouseClicked

    private void PANELHOME4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME4MouseClicked
       Home home=new Home();
       home.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_PANELHOME4MouseClicked

    private void PANELHOME2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME2MouseClicked
       UpdateFeesDetails updateFeesDetails=new UpdateFeesDetails();
       updateFeesDetails.setVisible(true);
       this.dispose();
               
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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Chequeno;
    private javax.swing.JPanel PANELHOME;
    private javax.swing.JPanel PANELHOME1;
    private javax.swing.JPanel PANELHOME2;
    private javax.swing.JPanel PANELHOME3;
    private javax.swing.JPanel PANELHOME4;
    private javax.swing.JPanel PANELHOME5;
    private javax.swing.JPanel PANELHOME6;
    private javax.swing.JButton Printbtn;
    private javax.swing.JLabel addfeeslbl12;
    private javax.swing.JLabel addfeeslbl13;
    private javax.swing.JLabel addfeeslbl15;
    private javax.swing.JLabel addfeeslbl16;
    private javax.swing.JLabel addfeeslbl18;
    private javax.swing.JLabel addfeeslbl21;
    private javax.swing.JLabel addfeeslbl8;
    private javax.swing.JTextField ddno;
    private javax.swing.JLabel gstin;
    private javax.swing.JComboBox<String> jComboBox2Course;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1remark;
    private javax.swing.JTextField jTextFieldamt1;
    private javax.swing.JTextField jTextFieldamt2;
    private javax.swing.JTextField jTextFieldamt3;
    private javax.swing.JTextField jTextFieldamt4;
    private javax.swing.JLabel lblbankname;
    private javax.swing.JLabel lblcgst;
    private javax.swing.JLabel lblchecque;
    private javax.swing.JLabel lblcourse;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldd;
    private javax.swing.JLabel lblgstin1;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblhome1;
    private javax.swing.JLabel lblhome2;
    private javax.swing.JLabel lblhome3;
    private javax.swing.JLabel lblhome4;
    private javax.swing.JLabel lblhome5;
    private javax.swing.JLabel lblhome6;
    private javax.swing.JLabel lblmodepay;
    private javax.swing.JLabel lblrecive;
    private javax.swing.JLabel lblroll;
    private javax.swing.JLabel lblsgst;
    private javax.swing.JLabel lblyear;
    private javax.swing.JPanel panelChild;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JComboBox<String> paymode;
    private javax.swing.JLabel recipteno;
    private javax.swing.JTextField totalinwords;
    private javax.swing.JTextField txtbankname;
    private javax.swing.JTextField txthead;
    private javax.swing.JTextField txtrecipteno;
    private javax.swing.JTextField txtrecivefrom;
    private javax.swing.JTextField txtroll;
    private javax.swing.JTextField txtyear1;
    private javax.swing.JTextField txtyear2;
    // End of variables declaration//GEN-END:variables
}
