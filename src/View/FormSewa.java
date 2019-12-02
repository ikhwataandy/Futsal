/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import CRUD.LapanganModel;
import CRUD.Sewa;
import Database.koneksi;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author asus
 */
public class FormSewa extends javax.swing.JFrame implements ActionListener {

//    PenyewaService penyewaService;
//    ItemService service;
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    private Connection connection;
    private PreparedStatement ptmt;
    private Statement stmnt;
    private ResultSet rs;
    private String query;
    private DefaultTableModel tabmode;
    private int tambahan = 0;
    Sewa sw = new Sewa();

    public FormSewa() throws SQLException {
//        penyewaService = new PenyewaServiceImp();
//        service = new ItemSerivceImp();
        initComponents();
        setLocationRelativeTo(this);
        id_sewa.setText(sw.getIdAdmin());
        komponen("awal");
//        pilihLapangan.addActionListener(this);
        loadLapangan();
        
    }
    

    public int getTambahan() {
        return tambahan;
    }

    public JButton getBtnTambahItem() {
        return btnTambahItem;
    }

    public JComboBox<String> getCbJmMain() {
        return cbJmMain;
    }

    public JComboBox<String> getCbJmSelesai() {
        return cbJmSelesai;
    }

    public JComboBox<String> getCbStatus() {
        return cbStatus;
    }

    public JTextField getHargaLapangan() {
        return hargaLapangan;
    }

    public JTextField getId_sewa() {
        return id_sewa;
    }

    public JTextField getNamaPenyewa() {
        return namaPenyewa;
    }

    public JDateChooser getTanggalMain() {
        return tanggalMain;
    }

    public JDateChooser getTanggalSewa() {
        return tanggalSewa;
    }

    public JTable getTblItemLapangan() {
        return tblItemLapangan;
    }

    public JTextField getTeleponPenyewa() {
        return teleponPenyewa;
    }

    public JTextField getUangDp() {
        return uangDp;
    }

    public void loadLapangan() {
        pilihLapangan.removeAllItems();
        List<LapanganModel> listLapangan = new ArrayList<>();
        try {
           PreparedStatement preparedStatement = koneksi.getKoneksi().prepareStatement(""
                   + "SELECT * FROM lapangan");
           ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                LapanganModel lapanganModel = new LapanganModel();
                lapanganModel.setNama(rs.getString("nama_lapangan"));
                listLapangan.add(lapanganModel);
            }
            
        } catch (Exception e) {
        }
        String[] namaLapangan = new String[listLapangan.size()];

        for (int i = 0; i < listLapangan.size(); i++) {
            namaLapangan[i] = listLapangan.get(i).getNama();
        }
        pilihLapangan.setModel(new DefaultComboBoxModel(namaLapangan));
    }

    public void reset() {
//        namaPenyewa.setText("");
//        teleponPenyewa.setText("");
//        tanggalSewa.setCalendar(null);
        tanggalMain.setCalendar(null);
        pilihLapangan.setSelectedItem(null);
        hargaLapangan.setText("");
        cbJmMain.setSelectedItem(null);
        cbJmSelesai.setSelectedItem(null);
        cbStatus.setSelectedItem(null);
//        uangDp.setText("");
//        jlTotBayar1.setText("");
//        jlSisBayar.setText("");

    }

    public void komponen(String action) {
        switch (action) {
            case "awal":
                getId_sewa().setEnabled(false);
                break;
            case "":
                
        }
    }

    public void tambah() {
        Object[] ob = new Object[13];
        sw.setId_sewa(id_sewa.getText());
        sw.setPenyewa(namaPenyewa.getText());
        sw.setTelepon_penyewa(Integer.parseInt(teleponPenyewa.getText()));
        sw.setTglSewa(format.format(tanggalSewa.getDate()));
        sw.setTglMain(format.format(tanggalMain.getDate()));
//         sw.setLapangan(sw.getId_lapangan());
        sw.setLapangan(pilihLapangan.getSelectedItem().toString());
        sw.setHargaLapangan(Double.parseDouble(hargaLapangan.getText()));
        sw.setJam_mulai(cbJmMain.getSelectedItem().toString());
        sw.setJam_selesai(cbJmSelesai.getSelectedItem().toString());
        sw.setUangBoking(Double.parseDouble(uangDp.getText()));
        sw.setTotHarga(Double.parseDouble(jlTotBayar1.getText()));
        sw.setSisaBayar(Double.parseDouble(jlSisBayar.getText()));
        sw.setStatus(cbStatus.getSelectedItem().toString());

        ob[0] = sw.getId_sewa();
        ob[1] = sw.getPenyewa();
        ob[2] = sw.getTelepon_penyewa();
        ob[3] = sw.getTglSewa();
        ob[4] = sw.getTglMain();
        ob[5] = sw.getLapangan();
        ob[6] = sw.getHargaLapangan();
        ob[7] = sw.getJam_mulai();
        ob[8] = sw.getJam_selesai();
        ob[9] = sw.getUangBoking();
        ob[10] = sw.getTotHarga();
        ob[11] = sw.getSisaBayar();
        ob[12] = sw.getStatus();
        tabmode.addRow(ob);
        tambahan++;
        reset();
    }

    public void tabel() {
        Object[] baris = {"Id_sewa", "Penyewa", "Telepon", "Tgl_sewa", "Tgl_main", "Lapangan", "Harga", "jam_mulai", "jam_selesai",
            "Uang DP", "Total_harga", "Sisa_bayar","Status"};
        tabmode = new DefaultTableModel(null, baris);
        tblItemLapangan.setModel(tabmode);
        tambah();

    }

    public void hitung() {
        double harga = Double.parseDouble(hargaLapangan.getText());
        double uBoking = Double.parseDouble(uangDp.getText());

        double totbayar, sisaBayar;
        totbayar = harga;
        sisaBayar = totbayar - uBoking;

        jlTotBayar1.setText(String.valueOf(harga));

        String sAwal = String.valueOf(sisaBayar);
        jlSisBayar.setText(sAwal);
    }
    public void hapus() {
        int row = tblItemLapangan.getSelectedRow();

        if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data"
                + "ini ?", "Warning", 2) == JOptionPane.YES_OPTION) {
//            if (sw.hapusData(sw.getId_sewa())) {
//                JOptionPane.showMessageDialog(null, "Data Telah Di Hapus");
//            }
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
        }

    }
    
    public void getLapangan(){
        String cb = (String)pilihLapangan.getSelectedItem();
        query = "select harga_lapangan from lapangan where nama_lapangan ='"+cb+"'";
        System.out.println(cb);
        try{
            PreparedStatement preparedStatement = koneksi.getKoneksi().prepareStatement(
                   query);
           ResultSet rs = preparedStatement.executeQuery();
//            ptmt = connection.prepareStatement(query);
//            ptmt.setString(1, cb);
//            rs = ptmt.executeQuery();
            if (rs.next()) {
                String harga = rs.getString("harga_lapangan");
                hargaLapangan.setText(harga);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemLapangan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pilihLapangan = new javax.swing.JComboBox<>();
        btnTambahItem = new javax.swing.JButton();
        hargaLapangan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbJmMain = new javax.swing.JComboBox<>();
        cbJmSelesai = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tanggalMain = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        teleponPenyewa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tanggalSewa = new com.toedter.calendar.JDateChooser();
        namaPenyewa = new javax.swing.JTextField();
        id_sewa = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlSisBayar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlTotBayar1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        uangDp = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblItemLapangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14"
            }
        ));
        tblItemLapangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemLapanganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItemLapangan);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));

        jLabel2.setText("Pilih Lapangan :");

        pilihLapangan.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                pilihLapanganPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        pilihLapangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihLapanganActionPerformed(evt);
            }
        });

        btnTambahItem.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnTambahItem.setText("Tambah item");
        btnTambahItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahItemActionPerformed(evt);
            }
        });

        hargaLapangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaLapanganActionPerformed(evt);
            }
        });

        jLabel12.setText("Harga/jam");

        jLabel5.setText("Jam Main :");

        cbJmMain.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00" }));
        cbJmMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJmMainActionPerformed(evt);
            }
        });

        cbJmSelesai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00" }));
        cbJmSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJmSelesaiActionPerformed(evt);
            }
        });

        jLabel8.setText("Tanggal Main :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaLapangan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pilihLapangan, javax.swing.GroupLayout.Alignment.LEADING, 0, 133, Short.MAX_VALUE))
                        .addGap(18, 30, Short.MAX_VALUE)
                        .addComponent(btnTambahItem))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbJmMain, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbJmSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addComponent(tanggalMain, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilihLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(11, 11, 11)
                .addComponent(hargaLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbJmMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbJmSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)))
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel13.setBackground(new java.awt.Color(0, 153, 51));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Boking Lapangan");
        jLabel15.setToolTipText("");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));

        jLabel1.setText("ID Penyewaan :");

        jLabel11.setText("Penyewa :");

        jLabel6.setText("Telepon");

        jLabel4.setText("Tanggal Sewa :");

        namaPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPenyewaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(teleponPenyewa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaPenyewa)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tanggalSewa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id_sewa)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 100, Short.MAX_VALUE)))
                        .addGap(41, 41, 41))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(namaPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addGap(7, 7, 7)
                .addComponent(teleponPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));

        jlSisBayar.setFont(new java.awt.Font("Swis721 Cn BT", 1, 11)); // NOI18N
        jlSisBayar.setText("Rp. 0.0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlSisBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlSisBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Total Harga :");

        jLabel17.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Sisa Bayar :");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));

        jlTotBayar1.setFont(new java.awt.Font("Swis721 Cn BT", 1, 11)); // NOI18N
        jlTotBayar1.setText("Rp. 0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTotBayar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jlTotBayar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton1.setText("Batal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        jLabel13.setText("Uang Booking");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Lunas", "LUNAS" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(uangDp, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uangDp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(jButton1))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(7, 7, 7)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSimpan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnTambah)))
                    .addGap(79, 79, 79)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(btnSimpan)
                            .addComponent(btnTambah)))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pilihLapanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihLapanganActionPerformed
        getLapangan();
    }//GEN-LAST:event_pilihLapanganActionPerformed

    private void btnTambahItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahItemActionPerformed
//        addItem();

    }//GEN-LAST:event_btnTambahItemActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed

        try {
//            int row = tblItemLapangan.getSelectedRow();
            sw.setId_sewa(id_sewa.getText());
            sw.setPenyewa(namaPenyewa.getText());
            sw.setTelepon_penyewa(Integer.parseInt(teleponPenyewa.getText()));
            sw.setTglSewa(tanggalSewa.getDateFormatString());
            sw.setUangBoking(Double.parseDouble(uangDp.getText()));
            sw.setSisaBayar(Double.parseDouble(jlTotBayar1.getText()));
            sw.insertSewa(sw.getId_sewa(), sw.getPenyewa(), sw.getTelepon_penyewa(), sw.getTglSewa(), sw.getUangBoking(), sw.getSisaBayar());

            for (int i = 0; i < tblItemLapangan.getRowCount(); i++) {

                sw.setTglMain(tblItemLapangan.getValueAt(i, 4).toString());
                sw.setLapangan(tblItemLapangan.getValueAt(i, 5).toString());
                sw.setHargaLapangan(Double.parseDouble(tblItemLapangan.getValueAt(i, 6).toString()));
                sw.setJam_mulai(tblItemLapangan.getValueAt(i, 7).toString());
                sw.setJam_selesai(tblItemLapangan.getValueAt(i, 8).toString());

                sw.setTotHarga(Double.parseDouble(tblItemLapangan.getValueAt(i, 10).toString()));
                sw.setStatus(tblItemLapangan.getValueAt(i,12).toString());

                sw.insertDetailSewa(sw.getTglMain(), sw.getJam_mulai(), sw.getJam_selesai(), sw.getTotHarga(), sw.getIdLapangan(tblItemLapangan.getValueAt(i, 5).toString()), sw.getId_sewa(),sw.getStatus());
                  reset();
            }
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
          

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        hitung();
    }//GEN-LAST:event_btnHitungActionPerformed

    private void pilihLapanganPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_pilihLapanganPopupMenuWillBecomeInvisible
        

    }//GEN-LAST:event_pilihLapanganPopupMenuWillBecomeInvisible

    private void tblItemLapanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemLapanganMouseClicked
        // TODO add your handling code here:
        try {
            Date date = null;
            Date date1 = null;
            int row = tblItemLapangan.rowAtPoint(evt.getPoint());
            String id = tblItemLapangan.getValueAt(row, 0).toString();
            String penyewa = tblItemLapangan.getValueAt(row, 1).toString();
            String telepon = String.valueOf(tblItemLapangan.getValueAt(row, 2).toString());
            if (sw.getTglSewa().equals("null")) {
                date = null;
            } else {
                date = new SimpleDateFormat("dd-MM-yyyy").parse(sw.getTglSewa());
            }

            if (sw.getTglMain().equals("null")) {
                date1 = null;
            } else {
                date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sw.getTglMain());
            }
            String lapangan = tblItemLapangan.getValueAt(row, 5).toString();
            String harga_lap = String.valueOf(tblItemLapangan.getValueAt(row, 6).toString());
            String jam_mulai = tblItemLapangan.getValueAt(row, 7).toString();
            String jam_selesai = tblItemLapangan.getValueAt(row, 8).toString();
            String uang_dp = String.valueOf(tblItemLapangan.getValueAt(row, 9).toString());
            String total = String.valueOf(tblItemLapangan.getValueAt(row, 10).toString());
            String sisa_bayar = String.valueOf(tblItemLapangan.getValueAt(row, 11).toString());

            id_sewa.setText(String.valueOf(id));
            namaPenyewa.setText(String.valueOf(penyewa));
            teleponPenyewa.setText(String.valueOf(telepon));
            tanggalSewa.setDate(date);
            tanggalMain.setDate(date);
            pilihLapangan.setSelectedItem(String.valueOf(lapangan));
            hargaLapangan.setText(String.valueOf(harga_lap));
            cbJmMain.setSelectedItem(String.valueOf(jam_mulai));
            cbJmSelesai.setSelectedItem(String.valueOf(jam_selesai));
            uangDp.setText(String.valueOf(uang_dp));
            jlTotBayar1.setText(String.valueOf(total));
            jlSisBayar.setText(String.valueOf(sisa_bayar));
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tblItemLapanganMouseClicked

    private void cbJmMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJmMainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJmMainActionPerformed

    private void cbJmSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJmSelesaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJmSelesaiActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (tambahan == 0) {
            tabel();
        } else {
            tambah();
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void namaPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPenyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPenyewaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        hapus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void hargaLapanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaLapanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaLapanganActionPerformed

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
            java.util.logging.Logger.getLogger(FormSewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormSewa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormSewa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTambahItem;
    private javax.swing.JComboBox<String> cbJmMain;
    private javax.swing.JComboBox<String> cbJmSelesai;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JTextField hargaLapangan;
    private javax.swing.JTextField id_sewa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlSisBayar;
    private javax.swing.JLabel jlTotBayar1;
    private javax.swing.JTextField namaPenyewa;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox<String> pilihLapangan;
    private com.toedter.calendar.JDateChooser tanggalMain;
    private com.toedter.calendar.JDateChooser tanggalSewa;
    private javax.swing.JTable tblItemLapangan;
    private javax.swing.JTextField teleponPenyewa;
    private javax.swing.JTextField uangDp;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
