/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import CRUD.Penyewa;
import CRUD.Sewa;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RobyHuzwandar
 */
public class FormPenyewa extends javax.swing.JFrame {

    private DefaultTableModel tabmode;
    private ResultSet rs;
    private Connection connection;
    private PreparedStatement ptmt;
    private Statement stmnt;
    Sewa sw = new Sewa();
    Penyewa p = new Penyewa();

    public FormPenyewa() {
        initComponents();
        setLocationRelativeTo(this);
        tampil_database();
    }

    public JTextField getId_sewa() {
        return id_sewa;
    }

    public JTextField getKurangBayar() {
        return kurangBayar;
    }

    public JTextField getLapangan() {
        return lapangan;
    }

    public JTextField getTotalSewa() {
        return totalSewa;
    }

    public JTextField getUangBayar() {
        return uangBayar;
    }

    public JTextField getUangDp() {
        return uangDp;
    }

    public JTextField getUangKembali() {
        return uangKembali;
    }

    public void tampil_database() {
        Object[] baris = {"Id_sewa", "Penyewa", "Telepon", "Tgl_sewa", "Tgl_main", "Lapangan", "Harga", "jam_mulai", "jam_selesai",
            "Uang DP", "Total_harga", "Sisa_bayar", "Status", "Id_Detail"};
        tabmode = new DefaultTableModel(null, baris);

        tblItemLapangan.setModel(tabmode);
        try {
            rs = sw.tampilData();
            while (rs.next()) {
                sw.setId_sewa(rs.getString("id_sewa"));
                sw.setPenyewa(rs.getString("penyewa"));
                sw.setTelepon_penyewa(rs.getInt("telepon"));
                sw.setTglSewa(rs.getString("tanggal_sewa"));
                sw.setTglMain(rs.getString("tanggal_main"));
                sw.setLapangan(rs.getString("nama_lapangan"));
                sw.setHargaLapangan(rs.getDouble("harga_lapangan"));
                sw.setJam_mulai(rs.getString("jam_mulai"));
                sw.setJam_selesai(rs.getString("jam_selesai"));
                sw.setUangBoking(rs.getDouble("uang_muka"));
                sw.setTotHarga(rs.getDouble("sub_total"));
                sw.setSisaBayar(rs.getDouble("kurang_bayar"));
                sw.setStatus(rs.getString("status"));
                sw.setId_detail(rs.getInt("id_detail_sewa"));

                String sewa = String.valueOf(sw.getId_sewa());
                String tlp = String.valueOf(sw.getTelepon_penyewa());
                String hrgLapangan = String.valueOf(sw.getHargaLapangan());
                String uangDp = String.valueOf(sw.getUangBoking());
                String total = String.valueOf(sw.getTotHarga());
                String sisaBayar = String.valueOf(sw.getSisaBayar());
                String id_detail = String.valueOf(sw.getId_detail());
                String[] data = {sewa, sw.getPenyewa(), tlp,
                    sw.getTglSewa(), sw.getTglMain(), sw.getLapangan(), hrgLapangan,
                    sw.getJam_mulai(), sw.getJam_selesai(), uangDp, total, sisaBayar, sw.getStatus(), id_detail};
                tabmode.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormSewa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cari() {
        Object[] baris = {"Id_sewa", "Penyewa", "Telepon", "Tgl_sewa", "Tgl_main", "Lapangan", "Harga", "jam_mulai", "jam_selesai",
            "Uang DP", "Total_harga", "Sisa_bayar", "Status", "Id_Detail"};
        tabmode = new DefaultTableModel(null, baris);

        tblItemLapangan.setModel(tabmode);
        try {
            if (txt_cari.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Isi data dahulu!");

            } else {
                rs = sw.cariData(txt_cari.getText());
                while (rs.next()) {
                    sw.setId_sewa(rs.getString("id_sewa"));
                    sw.setPenyewa(rs.getString("penyewa"));
                    sw.setTelepon_penyewa(rs.getInt("telepon"));
                    sw.setTglSewa(rs.getString("tanggal_sewa"));
                    sw.setTglMain(rs.getString("tanggal_main"));
                    sw.setLapangan(rs.getString("nama_lapangan"));
                    sw.setHargaLapangan(rs.getDouble("harga_lapangan"));
                    sw.setJam_mulai(rs.getString("jam_mulai"));
                    sw.setJam_selesai(rs.getString("jam_selesai"));
                    sw.setUangBoking(rs.getDouble("uang_muka"));
                    sw.setTotHarga(rs.getDouble("sub_total"));
                    sw.setSisaBayar(rs.getDouble("kurang_bayar"));
                    sw.setStatus(rs.getString("status"));
                    sw.setId_detail(rs.getInt("id_detail_sewa"));

                    String sewa = String.valueOf(sw.getId_sewa());
                    String tlp = String.valueOf(sw.getTelepon_penyewa());
                    String hrgLapangan = String.valueOf(sw.getHargaLapangan());
                    String uangDp = String.valueOf(sw.getUangBoking());
                    String total = String.valueOf(sw.getTotHarga());
                    String sisaBayar = String.valueOf(sw.getSisaBayar());
                    String id_detail = String.valueOf(sw.getId_detail());
                    String[] data = {sewa, sw.getPenyewa(), tlp,
                        sw.getTglSewa(), sw.getTglMain(), sw.getLapangan(), hrgLapangan,
                        sw.getJam_mulai(), sw.getJam_selesai(), uangDp, total, sisaBayar, sw.getStatus(), id_detail};
                    tabmode.addRow(data);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormSewa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hapus() {
        DefaultTableModel model = (DefaultTableModel) tblItemLapangan.getModel();

        if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data"
                + "ini ?", "Warning", 2) == JOptionPane.YES_OPTION) {
            String id = "";
            try {
                sw.hapusData(id);
                int row = tblItemLapangan.getSelectedRow();
                int modelRow = tblItemLapangan.convertRowIndexToModel(row);
                model.removeRow(modelRow);
                sw.hapusData(sw.getId_sewa());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }

    public void reset() {

    }

    public void komponen(String action) {
        switch (action) {
            case "klik":
                getId_sewa().setEnabled(false);
                getLapangan().setEnabled(false);
                getUangDp().setEnabled(false);
                getTotalSewa().setEnabled(false);
                getKurangBayar().setEnabled(false);
                break;
            case "":

        }
    }

    public void hitung1() {

        double bayar = Double.parseDouble(uangBayar.getText());
        double krgBayar = Double.parseDouble(kurangBayar.getText());

        double kembali = bayar - krgBayar;
        uangKembali.setText(String.valueOf(kembali));

    }

//    public void view() {
//        tblPenyewa.setModel(penyewaService.view());
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnLunas = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemLapangan = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalSewa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        kurangBayar = new javax.swing.JTextField();
        id_sewa = new javax.swing.JTextField();
        DP1 = new javax.swing.JLabel();
        uangDp = new javax.swing.JTextField();
        pilihID1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lapangan = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnSimpan2 = new javax.swing.JButton();
        btnBatal2 = new javax.swing.JButton();
        uangKembali = new javax.swing.JTextField();
        uangBayar = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete_24px.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Plus_24px.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(0, 153, 51));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Daftar Penyewa");
        jLabel11.setToolTipText("");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        btnLunas.setText("Lunas");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tblItemLapangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ));
        tblItemLapangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemLapanganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItemLapangan);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));

        jLabel7.setText("ID :");

        jLabel8.setText("Total");

        jLabel9.setText("Kurang Bayar");

        DP1.setText("DP");

        pilihID1.setText("Pilih");
        pilihID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihIDActionPerformed(evt);
            }
        });

        jLabel1.setText("Lapangan");

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lapangan)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(totalSewa)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(kurangBayar)
                                .addComponent(DP1)
                                .addComponent(uangDp)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(id_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                    .addComponent(pilihID1)))
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihID1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DP1)
                .addGap(7, 7, 7)
                .addComponent(uangDp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kurangBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));

        jLabel10.setText("Bayar");

        jLabel12.setText("Kembali");

        btnSimpan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save_24px.png"))); // NOI18N
        btnSimpan2.setText("Simpan");
        btnSimpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan2ActionPerformed(evt);
            }
        });

        btnBatal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Synchronize_24px.png"))); // NOI18N
        btnBatal2.setText("Batal");
        btnBatal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatal2ActionPerformed(evt);
            }
        });

        uangBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uangBayarActionPerformed(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Lunas", "LUNAS" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(btnSimpan2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                            .addComponent(btnBatal2))
                        .addComponent(uangKembali)
                        .addComponent(jLabel12)
                        .addComponent(uangBayar))
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uangBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uangKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan2)
                    .addComponent(btnBatal2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLunas)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnLunas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHapus)
                            .addComponent(btnTambah)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCari)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            new FormSewa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FormPenyewa.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblItemLapanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemLapanganMouseClicked
        try {
            int row = tblItemLapangan.rowAtPoint(evt.getPoint());

            String id = tblItemLapangan.getValueAt(row, 0).toString();
            String lap = tblItemLapangan.getValueAt(row, 5).toString();
            String dp = tblItemLapangan.getValueAt(row, 9).toString();
            String total = tblItemLapangan.getValueAt(row, 10).toString();
            String kurang = tblItemLapangan.getValueAt(row, 11).toString();
            String status = tblItemLapangan.getValueAt(row, 12).toString();
            String id_detail = tblItemLapangan.getValueAt(row, 13).toString();

            id_sewa.setText(String.valueOf(id));
            lapangan.setText(String.valueOf(lap));
            uangDp.setText(String.valueOf(dp));
            totalSewa.setText(String.valueOf(total));
            kurangBayar.setText(String.valueOf(kurang));
            cbStatus.setSelectedItem(String.valueOf(status));
            this.jTextField1.setText(String.valueOf(id_detail));
            
            if (status.equals("belum lunas")) {
                cbStatus.setSelectedIndex(0);
            }else if(status.equals("lunas")){
                cbStatus.setSelectedIndex(1);
            }
            System.out.println(id);
            System.out.println(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        komponen("klik");
    }//GEN-LAST:event_tblItemLapanganMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void pilihIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihIDActionPerformed

        ResultSet rs = null;
        rs = p.pilih(id_sewa.getText());
        try {
            if (rs.next()) {
                lapangan.setText(rs.getString("nama_lapangan"));
                uangDp.setText(rs.getString("uang_muka"));
                totalSewa.setText(rs.getString("sub_total"));
                kurangBayar.setText(rs.getString("kurang_bayar"));
                cbStatus.setSelectedItem(rs.getString("status"));
            } else {
                JOptionPane.showMessageDialog(null, "No data");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pilihIDActionPerformed

    private void btnSimpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan2ActionPerformed

        try {
            sw.setStatus(cbStatus.getSelectedItem().toString());
            sw.setId_sewa(id_sewa.getText());
            sw.setId_detail(Integer.parseInt(jTextField1.getText()));
            p.ubahStatus(sw.getStatus(), sw.getId_sewa(), sw.getId_detail());
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah", "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
            tampil_database();
//            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal di ubah", "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnSimpan2ActionPerformed

    private void btnBatal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBatal2ActionPerformed

    private void uangBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uangBayarActionPerformed
        hitung1();

    }//GEN-LAST:event_uangBayarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenyewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DP1;
    private javax.swing.JButton btnBatal2;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLunas;
    private javax.swing.JButton btnSimpan2;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JTextField id_sewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField kurangBayar;
    private javax.swing.JTextField lapangan;
    private javax.swing.JButton pilihID1;
    private javax.swing.JTable tblItemLapangan;
    private javax.swing.JTextField totalSewa;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField uangBayar;
    private javax.swing.JTextField uangDp;
    private javax.swing.JTextField uangKembali;
    // End of variables declaration//GEN-END:variables
}
