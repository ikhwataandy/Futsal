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
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class Penyewa {

    private Connection connection;
    private PreparedStatement ptmt;
    private Statement stmnt;
    private ResultSet rs;
    private String query;

    public Penyewa() {
        this.connection = koneksi.getKoneksi();
    }
    
    public void hapusData(String id) {
        query = "delete from sewa where id_sewa = '" + id + "'";
        try {
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, id);
            ptmt.executeUpdate();
            ptmt.close();
//           return true
        } catch (Exception e) {
            e.printStackTrace();
//            return false;
        }
    }

    public void ubahStatus(String status, String id_sewa, int id_detail) {
        query = "update detail_sewa set detail_sewa.status = ? where id_sewa =? and id_detail_sewa =?";
        try {
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, status);
            ptmt.setString(2, id_sewa);
            ptmt.setInt(3, id_detail);
            ptmt.executeUpdate();
            ptmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet pilih(String id) {
       query = "select lapangan.nama_lapangan,sewa.uang_muka,detail_sewa.sub_total,sewa.kurang_bayar,detail_sewa.status from detail_sewa natural join sewa natural join lapangan where id_sewa = ?";
        try {
            connection = koneksi.getKoneksi();
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, id);
            rs = ptmt.executeQuery();
//            if (rs.next()) {
//                hargaLapangan.setText(rs.getString("harga_lapangan"));
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

}
