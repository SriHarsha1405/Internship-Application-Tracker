package dao;
import java.sql.*;

public class DBConnection {
    static Connection con = null;
    public static Connection getConnection(){
        try{
            String URL = "jdbc:mysql://localhost:3306/internship_db";
            String USER = "root";
            String PASSWORD = "MyAdmin@123";
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}