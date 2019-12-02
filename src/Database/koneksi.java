package Database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class koneksi {

    private static Connection connec;

    public static Connection getKoneksi(){
        if (connec == null) {
            try {
                String DB = "jdbc:mysql://localhost:3306/futsal"; //database futsal
                String user = "root"; // user database
                String pass = ""; // password database
                connec = (Connection) DriverManager.getConnection(DB, user, pass);
                System.out.println("Berhasil Terhubung");
            } catch (SQLException e) {
                System.out.println("Gagal Terhubung");
            }
        }

        return connec;
    }

    public static void main(String[] args) {
           getKoneksi();
    }

}
