/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Database.Session;
import Database.koneksi;
import View.Main2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class Login {

    private Connection koneksi;
    private PreparedStatement psmt;
    private ResultSet dataUser;
    private String query, userID, password, pesan;

    public Login() {
        koneksi connection = new koneksi();
        try {
            koneksi = connection.getKoneksi();
        } catch (Exception ex) {
        }
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String cekLogin(String userID, String password) {
        query = "SELECT nama FROM admin WHERE id_admin=? AND password=md5(?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.setString(2, password);
            dataUser = psmt.executeQuery();
            if (dataUser.next()) {
                Session.setUserId(userID);
                Session.setNama(dataUser.getString("nama"));
                Session.setStatusLogin("AKTIF");
                query = "INSERT INTO log_login (id_admin) VALUES (?)";
                try {
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, userID);
                    psmt.executeUpdate();
                    psmt.close();
                } catch (Exception e) {
                    pesan = "Gagal Simpan Log Login";
                }
            } else {
                pesan = "Gagal Login";
            }
        } catch (Exception e) {
            pesan = "Gagal Login, Query Error";
        }
        return pesan;

    }
    
    public void LoginFrame() {
        Main2.menuData.setEnabled(true);
        Main2.menuTransaksi.setEnabled(true);
        Main2.btnBoking.setEnabled(true);
        Main2.btnLap.setEnabled(true);
        Main2.btnPenyewa.setEnabled(true);
        Main2.btnPembayaran.setEnabled(true);
        Main2.jmLogOut.setEnabled(true);
        Main2.jmLogOut.setEnabled(true);
    }
}
