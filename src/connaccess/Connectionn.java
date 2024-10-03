package connaccess;

//import java.io.File;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Connectionn {
//    private static File dbFile = new File("src/DB/KAT.accdb");
//    private static String path = dbFile.getAbsolutePath();//Взимане на абсолютния път
//    static Connection conn;
//    static private Statement s;
// 
//
//    public Connectionn() throws SQLException {
//        this.conn =     DriverManager.getConnection("jdbc:ucanaccess://" + path);//указваме пътя до базата данни. Има и възможност да вземете "абсолютния" път на файла.
//        this.s = conn.createStatement();   
//
//    }
//
//    // Getters and Setters
//    public static Statement getS() { return s; }
//}
import com.mysql.cj.jdbc.MysqlDataSource;
//import com.sun.jdi.connect.spi.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;

/**
 *
 * @author aleksph
 */
public class Connectionn {
    public static Connection getConn(){

            Connection conn = null;

            try{

                Class.forName("com.mysql.cj.jdbc.Driver");            

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/kat","root","Npmg2022!");

                System.out.println("conn="+conn);

            } catch (Exception ex){

                ex.printStackTrace();

            }       

            return conn;

    }

}
