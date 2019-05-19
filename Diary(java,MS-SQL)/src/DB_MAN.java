import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_MAN {
    String strDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String strURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Diary";
    String strUser ="sa";
    String strPWD = "inha1958";
    
    Connection DB_con; //DB Connection
    Statement DB_stmt; //To store statement for DB Connection
    ResultSet DB_rs; //To store result of SQL Execution
    
    public void dbOpen() throws IOException{
        try {
            Class.forName(strDriver); //Load JDBC-ODBC bridge driver
            DB_con = DriverManager.getConnection(strURL, strUser, strPWD); //Setting DSN Prooerties in driver
            DB_stmt = DB_con.createStatement(); //To create statement for DB Connection
        } catch (Exception e) {
            System.out.println("SQLException : "+e.getMessage());
        }
    }
    
    public void dbClose() throws IOException{
        try {
            DB_stmt.close(); //Exit Statement Connection
            DB_con.close(); //exit DB Connection
        } catch (Exception e) {
            System.out.println("SQLException : "+e.getMessage());
        }
    }
}
