package travel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;//used for connect JDBC
    Statement s;
    Conn(){
        
        try{
            // step-1 Resister the Driver Class by using JAR file
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step-2 Creating Connection string
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelAndTourismManagementSystem","root","MyDeb@2002");
            // step-3 Creating the statement
            s = c.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }

    
    
    private Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
