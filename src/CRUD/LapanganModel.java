/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Database.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class LapanganModel {

    private String id;
    private String nama;
    private String harga;
    private Connection connection;
    private PreparedStatement ptmt;
    private Statement stmnt;
    private ResultSet rs;
    private String query;

    public LapanganModel() {
        koneksi conn = new koneksi();
        connection = conn.getKoneksi();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public ResultSet tampilData() throws SQLException {
        query = "select * from lapangan";
        try {
            stmnt = connection.createStatement();
            rs = stmnt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public void insertLapangan(String id_lapangan, String nama_lapangan, int harga_lapangan) {
        query = "insert into lapangan values (?,?,?)";

        try {
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, id_lapangan);
            ptmt.setString(2, nama_lapangan);
            ptmt.setInt(3, harga_lapangan);
            ptmt.executeUpdate();
            ptmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ubahLapangan(String id, String nama, int harga) {
        query = "update lapangan set nama_lapangan=?, harga_lapangan=? where id_lapangan=?";
        try {
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, nama);
            ptmt.setInt(2, harga);
            ptmt.setString(3, id);
            ptmt.executeUpdate();
            ptmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hapusLapangan(String id) {
        query = "delete from lapangan where id_lapangan=?";
         try {
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, id);
            ptmt.executeUpdate();
            ptmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
