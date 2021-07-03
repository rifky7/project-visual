/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author winda
 */
public class DatabaseConnection {
    private Connection koneksi;
    
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil terkoneksi");
        } catch (ClassNotFoundException e) {
            System.out.println("Gagal terkoneksi"+e);
        }
        String url = "jdbc:mysql://localhost/pvisual";
        try {
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil koneksi Database");
        } catch (SQLException e) {
            System.out.println("Gagal koneksi Database");
        }
        return koneksi;
    }
}
