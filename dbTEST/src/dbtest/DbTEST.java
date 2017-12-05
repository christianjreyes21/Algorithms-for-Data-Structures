/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtest;
import java.sql.*;  

/**
 *
 * @author Christian Reyes
 */
public class DbTEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PUV_DATABASE","root","1234");
            /*CallableStatement stmt = con.prepareCall("{call setUser(?,?)}");
            stmt.setString(1,"chrissantos");
            stmt.setString(2,"456");
            stmt.execute();
            
            /*CallableStatement stmt1 = con.prepareCall("{call getUser(?)}");
            stmt1.setString(1,"hello");
            stmt1.execute();*/
            Statement stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery("SELECT user,pw FROM USERACC WHERE 'chrissantos'=user");
            rs.next();
            System.out.println(rs.getString(1)+rs.getString(2));  
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
  
System.out.println("success");  
    }
    
}
