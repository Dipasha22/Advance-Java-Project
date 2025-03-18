  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package feesmanagement_system;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Rushikesh Sapkale
 */
public class Report extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
        fillComboBox();

    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) jtbl_report.getModel();
        model.setRowCount(1);

    }

    public final void fillComboBox() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "system");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("Select Cname from course");
            while (rs.next()) {
                //  System.out.println(rs.getString("Cname"));
                combocourse.addItem(rs.getString("Cname"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRecords() {
        String cname = combocourse.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String fromdate = dateFormat.format(jDateChooserfrom.getDate());
        String todate = dateFormat.format(jDateChooserto.getDate());
        Float amountTotal = 0.0f;
        try {
            java.sql.Connection con = DBconnection.getConnection();
            PreparedStatement smt = con.prepareStatement("Select * from fees_detail where date  between ? and ? and course = ?");
            smt.setString(1, fromdate);
            smt.setString(2, todate);
            smt.setString(3, cname);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                int recieptno = rs.getInt("reciept_no");
                String rollno = rs.getString("rollno");
                String studentname = rs.getString("student_name");
                String course = rs.getString("course");
                float total_amount = rs.getFloat("total_amount");
                String remark = rs.getString("remark");
                amountTotal = amountTotal + total_amount;

                Object[] obj = {recieptno, rollno, studentname, course, total_amount, remark};
                model = (DefaultTableModel) jtbl_report.getModel();
                model.addRow(obj);

            }
            lbl_course.setText(cname);
            lbl_totalamt.setText(amountTotal.toString());
            lbl_totalwords.setText(NumbertoWordsConverter.convert(amountTotal.intValue()));
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportToExcel() {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet ws = wb.createSheet();
        model = (DefaultTableModel) jtbl_report.getModel();
        TreeMap<String, Object[]> map = new TreeMap<>();
        map.put("0", new Object[]{model.getColumnName(0), model.getColumnName(1), model.getColumnName(2), model.getColumnName(3), model.getColumnName(4), model.getColumnName(5)});
        for (int i = 1; i < model.getRowCount(); i++) {
            map.put(Integer.toString(i + 1), new Object[]{model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3), model.getValueAt(i, 4), model.getValueAt(i, 5)}); // Incremented row index by 1
        }
        Set<String> id = map.keySet();
        XSSFRow fRow;
        int rowId = 0;
        for (String key : id) {
            fRow = ws.createRow(rowId++);
            Object[] value = map.get(key);
            int cellId = 0;
            for (Object object : value) {
                XSSFCell cell = fRow.createCell(cellId++);
                cell.setCellValue(object == null ? "" : object.toString()); // Added null check
            }
        }
        try (FileOutputStream fos = new FileOutputStream(new File(txtfilepath.getText()))) {
            wb.write(fos);
            JOptionPane.showMessageDialog(this, "File exported successfully: " + txtfilepath.getText());
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
        jLabel1 = new javax.swing.JLabel();
        combocourse = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserfrom = new com.toedter.calendar.JDateChooser();
        jDateChooserto = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtfilepath = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_report = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_course = new javax.swing.JLabel();
        lbl_totalamt = new javax.swing.JLabel();
        lbl_totalwords = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("From Date:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        combocourse.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        combocourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocourseActionPerformed(evt);
            }
        });
        jPanel1.add(combocourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 230, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Course:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("To Date:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jDateChooserfrom.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel1.add(jDateChooserfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 160, -1));

        jDateChooserto.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel1.add(jDateChooserto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 170, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Export to Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 120, 30));

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 90, 30));

        txtfilepath.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel1.add(txtfilepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 330, -1));

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("SUBMIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 30));

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 90, 30));

        jtbl_report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Reciept No", "Roll No", "Student Name", "Course", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(jtbl_report);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 720, 390));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));

        lbl_totalamt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_totalamt.setForeground(new java.awt.Color(255, 255, 255));

        lbl_totalwords.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_totalwords.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Course Selected:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Amount Collected:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Amount in Words:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 192, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_totalwords, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbl_course, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_totalamt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel8)
                    .addContainerGap(342, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel9)
                    .addContainerGap(290, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel10)
                    .addContainerGap(293, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_course)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(lbl_totalamt)
                .addGap(47, 47, 47)
                .addComponent(lbl_totalwords)
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel8)
                    .addContainerGap(170, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(jLabel9)
                    .addContainerGap(97, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(160, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(39, 39, 39)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 10, 470, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelsidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PANELHOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOMEMouseClicked
        SearchRecord searchRecord = new SearchRecord();
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
        EditCourse editCourse = new EditCourse();
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
        ViewAllRecords viewAllRecords = new ViewAllRecords();
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
        Home home = new Home();
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
        Home home = new Home();
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
        Login login = new Login();
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exportToExcel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clearTable();
        setRecords();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String date = dateFormat.format(new Date());
        try {
            File f = fileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            path = path + "_" + date + ".xlsx";
            txtfilepath.setText(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void combocourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combocourseActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd");
        String datefrom = Date_Format.format(jDateChooserfrom.getDate());
        String dateto = Date_Format.format(jDateChooserto.getDate());

        MessageFormat header = new MessageFormat("Report From " + datefrom + " To " + dateto);
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {
            jtbl_report.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PANELHOME2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANELHOME2MouseClicked
 UpdateFeesDetails updateFeesDetails=new UpdateFeesDetails();
      updateFeesDetails.setVisible(true);
      this.dispose();      // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
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
    private javax.swing.JComboBox<String> combocourse;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooserfrom;
    private com.toedter.calendar.JDateChooser jDateChooserto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbl_report;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_totalamt;
    private javax.swing.JLabel lbl_totalwords;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblhome1;
    private javax.swing.JLabel lblhome2;
    private javax.swing.JLabel lblhome3;
    private javax.swing.JLabel lblhome4;
    private javax.swing.JLabel lblhome5;
    private javax.swing.JLabel lblhome6;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JTextField txtfilepath;
    // End of variables declaration//GEN-END:variables
}
