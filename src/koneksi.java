
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rahmat
 */
public class koneksi {
    private static Connection mysqlkonek;

    // Metode untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        if (mysqlkonek == null) {
            try {
                String DB = "jdbc:mysql://localhost:3306/projek_pbo"; // URL database
                String user = "root"; // Nama pengguna database
                String pass = ""; // Kata sandi database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // Driver untuk MySQL
                mysqlkonek = DriverManager.getConnection(DB, user, pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
            }
        }
        return mysqlkonek;
        }
    // Metode main untuk pengujian koneksi
    public static void main(String[] args) {
        try {
            getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
