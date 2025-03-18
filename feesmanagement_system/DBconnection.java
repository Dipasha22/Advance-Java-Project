/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package feesmanagement_system;
import java.sql.*;
/**
 *
 * @author Rushikesh Sapkale
 */
public class DBconnection {

    public static Connection getConnection(){
     
        Connection con=null;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           
         
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management?zeroDateTimeBehavior=CONVERT_TO_NULL","root","system");
          //smt=con.createStatement();
          //rs=smt.executeQuery("Select * from course");
          //while(rs.next()==true){
            //  System.out.println(rs.getString("Cname"));
          //}
           // con.close();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return con;
    }
    
}
