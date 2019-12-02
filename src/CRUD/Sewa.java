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
public class Sewa {

    private String penyewa, status,tglSewa, tglMain, jam_mulai, jam_selesai, lapangan, id_sewa,id_lapangan;
    private int telepon_penyewa,id_detail;
    private double hargaLapangan, totHarga, uangBoking, sisaBayar;
    private Connection connection;
    private PreparedStatement ptmt;
    private Statement stmnt;
    private ResultSet rs;
    private String query;

    public Sewa() {
        koneksi conn = new koneksi();
        connection = conn.getKoneksi();

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }
    

    public String getId_lapangan() {
        return id_lapangan;
    }

    public void setId_lapangan(String id_lapangan) {
        this.id_lapangan = id_lapangan;
    }
    
    public String getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(String jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public String getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(String jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public String getId_sewa() {
        return id_sewa;
    }

    public void setId_sewa(String id_sewa) {
        this.id_sewa = id_sewa;
    }

    public String getPenyewa() {
        return penyewa;
    }

    public void setPenyewa(String penyewa) {
        this.penyewa = penyewa;
    }

    public int getTelepon_penyewa() {
        return telepon_penyewa;
    }

    public void setTelepon_penyewa(int telepon_penyewa) {
        this.telepon_penyewa = telepon_penyewa;
    }

    public String getTglSewa() {
        return tglSewa;
    }

    public void setTglSewa(String tglSewa) {
        this.tglSewa = tglSewa;
    }

    public String getTglMain() {
        return tglMain;
    }

    public void setTglMain(String tglMain) {
        this.tglMain = tglMain;
    }

    public double getHargaLapangan() {
        return hargaLapangan;
    }

    public void setHargaLapangan(double hargaLapangan) {
        this.hargaLapangan = hargaLapangan;
    }

    public double getTotHarga() {
        return totHarga;
    }

    public void setTotHarga(double totHarga) {
        this.totHarga = totHarga;
    }

    public double getUangBoking() {
        return uangBoking;
    }

    public void setUangBoking(double uangBoking) {
        this.uangBoking = uangBoking;
    }

    public double getSisaBayar() {
        return sisaBayar;
    }

    public void setSisaBayar(double sisaBayar) {
        this.sisaBayar = sisaBayar;
    }

    public String getLapangan() {
        return lapangan;
    }

    public void setLapangan(String lapangan) {
        this.lapangan = lapangan;
    }

    public ResultSet tampilData() throws SQLException {
        query = "select sewa.id_sewa,sewa.penyewa,sewa.telepon,sewa.kurang_bayar,sewa.tanggal_sewa,detail_sewa.tanggal_main,lapangan.nama_lapangan,lapangan.harga_lapangan,detail_sewa.jam_mulai,detail_sewa.jam_selesai,sewa.uang_muka,detail_sewa.sub_total,sewa.uang_muka,detail_sewa.status,detail_sewa.id_detail_sewa from detail_sewa natural join lapangan natural join sewa where detail_sewa.id_lapangan = lapangan.id_lapangan and detail_sewa.id_sewa = sewa.id_sewa;";
        try {
            stmnt = connection.createStatement();
            rs = stmnt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public String getIdAdmin() throws SQLException {
        String id_admin = "0";
        query = "select id_sewa from sewa order by id_sewa desc limit 1";
        try {
            stmnt = connection.createStatement();
            rs = stmnt.executeQuery(query);

            String hasil = "";
            if (rs.next()) {
                hasil = rs.getString("id_sewa");
            }

            char[] hasil_sementara = hasil.toLowerCase().toCharArray();
            for (int i = 1; i < hasil_sementara.length; i++) {
                id_admin += hasil_sementara[i];
            }
            int id_angka = Integer.parseInt(id_admin);
            id_angka++;
            id_admin = "s" + id_angka;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_admin;

    }
    
    public String getIdLapangan(String Lapangan){
        query = "select id_lapangan from lapangan where nama_lapangan = '"+Lapangan+"'";
        String id = "";
        try{
            stmnt = connection.createStatement(); 
            rs = stmnt.executeQuery(query);   
            if (rs.next()) {
                id = rs.getString("id_lapangan");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id;
    }
    
    public void insertSewa(String id_sewa,String penyewa,int telepon,String tanggal_sewa,double dp,double kurang_bayar){
        query = "insert into sewa values (?,?,?,sysdate(),?,?)";
        
        try{
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, id_sewa);
            ptmt.setString(2, penyewa);
            ptmt.setInt(3, telepon);
            ptmt.setDouble(4, dp);
            ptmt.setDouble(5, kurang_bayar);
            ptmt.executeUpdate();
            ptmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void insertDetailSewa(String tanggal_main,String jam_mulai,String jam_selesai,double sub_total,String id_lapangan,String id_sewa,String status){
        query = "insert into detail_sewa values (null,?,?,?,?,?,?,?)";
        try{
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, tanggal_main);
            ptmt.setString(2, jam_mulai);
            ptmt.setString(3, jam_selesai);
            ptmt.setDouble(4, sub_total);
            ptmt.setString(5, id_lapangan);
            ptmt.setString(6, id_sewa);
            ptmt.setString(7, status);
            ptmt.executeUpdate();
            ptmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String id_sewa){
        query = "delete from sewa where id_sewa =?";
        try{
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, id_sewa);
            ptmt.executeUpdate();
            ptmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ResultSet cariData(String id_sewa){
        query = "select id_sewa,penyewa,telepon,tanggal_sewa,tanggal_main,nama_lapangan,harga_lapangan,jam_mulai,jam_selesai,uang_muka,sub_total,kurang_bayar,status from sewa s natural join detail_sewa d natural join lapangan l where s.id_sewa = d.id_sewa and d.id_lapangan = l.id_lapangan and s.id_sewa = ?";
        try{
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1, id_sewa);
            rs = ptmt.executeQuery();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
}
