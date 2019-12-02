package View;

import CRUD.LapanganModel;
import javax.swing.JOptionPane;
//import lapangan.Lapangan;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RobyHuzwandar
 */
public class FormLapangan extends javax.swing.JFrame {

//    LapanganService service;
//    int tag = 0;
//    int index;
//    int a;
    LapanganModel lapangan = new LapanganModel();
       private DefaultTableModel tabmode;
       private ResultSet rs;

    public FormLapangan() {
//        service = new LapanganServiceImp();
        initComponents();
        setLocationRelativeTo(this);
        tampil_database();

//        view();
    }
    
    public void tampil_database(){
        Object[]baris = {"ID","Nama Lapangan","Harga"};
        tabmode = new DefaultTableModel(null,baris);
        tblLapangan.setModel(tabmode);
        try{
            rs =lapangan.tampilData();
            while(rs.next()){
                lapangan.setId(rs.getString("id_lapangan"));
                lapangan.setNama(rs.getString("nama_lapangan"));
                lapangan.setHarga(rs.getString("harga_lapangan"));
                String[]data = {lapangan.getId(),lapangan.getNama(),lapangan.getHarga()};
                tabmode.addRow(data);
            }
        }catch(Exception e){
            
        }
    }

//    public void view() {
//        tblLapangan.setModel(service.view());
//        a = tblLapangan.getRowCount();
//        id_lapangan.setText(String.valueOf(a + 1));
//    }
//    public void save() {
//        try {
//
//            Lapangan l = new Lapangan();
//            l.setId(Integer.valueOf(id_lapangan.getText()));
//            l.setNmLapangan(namaLapangan.getText());
//            l.setJenisLapangan(cbJLap.getSelectedItem().toString());
//
//            if (tag == 0) {
//                service.insert(l);
//            } else if (tag == 1) {
//                service.update(tblLapangan.getSelectedRow(), l);
//            }
//
//            view();
//            id_lapangan.setText(String.valueOf(a + 1));
//            reset();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, "Isi Data Dengan Lengkap");
//        }
//    }
//
//    public void getData() {
//        int record = tblLapangan.getRowCount();
//
//        if (record > 0) {
//            int selected = tblLapangan.getSelectedRowCount();
//            if (selected > 0) {
//                tag = 1;
//                index = tblLapangan.getSelectedRow();
//                id_lapangan.setText(tblLapangan.getValueAt(index, 0).toString());
//                namaLapangan.setText(tblLapangan.getValueAt(index, 1).toString());
//
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "PIlih Data Terlebih Dahulu");
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Data Lapangan Tidak Ada");
//        }
//    }
//
//    public void reset() {
//        tag = 0;
//        namaLapangan.setText("");
//        cbJLap.setSelectedIndex(0);
//    }
//    public void delete() {
//        int record = tblLapangan.getRowCount();
//
//        if (record > 0) {
//            int selected = tblLapangan.getSelectedRowCount();
//            if (selected > 0) {
//                int confirm = JOptionPane.showConfirmDialog(rootPane,
//                        "Menghapus Data Akan Menghilangkan Data Secara Permanen" + "\n"
//                        + "Yakin Akan Menghapus Data ?", "Hapus Data", JOptionPane.YES_NO_OPTION);
//                if (confirm == JOptionPane.YES_OPTION) {
//                    service.delete(tblLapangan.getSelectedRow());
//                    view();
//                }
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Pilih Data terlebih dahulu");
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Data Lapangan Tidak Ada");
//        }
//    }
    public void reset() {
        id_lapangan.setText("");
        namaLapangan.setText("");
        hargaLapangan.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        namaLapangan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hargaLapangan = new javax.swing.JTextField();
        id_lapangan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLapangan = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(1071, 491));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));

        jLabel1.setText("ID :");

        jLabel2.setText("Nama Lapangan :");

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save_24px.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Synchronize_24px.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel3.setText("Harga");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnBatal))
                    .addComponent(namaLapangan)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(hargaLapangan)
                    .addComponent(id_lapangan))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_lapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(namaLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargaLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        tblLapangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblLapangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLapanganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLapangan);

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Maintenance_24px.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete_24px.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel8.setBackground(new java.awt.Color(0, 153, 51));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Lapangan");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (id_lapangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf id belum di isi");
            id_lapangan.requestFocus();
        } else if (namaLapangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf nama lapangan belum di isi");
            id_lapangan.requestFocus();
        } else if (hargaLapangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf harga belum di isi");
            id_lapangan.requestFocus();
        } else {
            try {
                lapangan.setId(id_lapangan.getText());
                lapangan.setNama(namaLapangan.getText());
                lapangan.setHarga(hargaLapangan.getText());
                lapangan.insertLapangan(lapangan.getId(), lapangan.getNama(), Integer.parseInt(lapangan.getHarga()));
                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
                tampil_database();
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal tersimpan", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
    if (id_lapangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf id belum di isi");
            id_lapangan.requestFocus();
        } else if (namaLapangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf nama lapangan belum di isi");
            id_lapangan.requestFocus();
        } else if (hargaLapangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf harga belum di isi");
            id_lapangan.requestFocus();
        } else {
            try {
                lapangan.setId(id_lapangan.getText());
                lapangan.setNama(namaLapangan.getText());
                lapangan.setHarga(hargaLapangan.getText());
                lapangan.ubahLapangan(lapangan.getId(), lapangan.getNama(), Integer.parseInt(lapangan.getHarga()));
                JOptionPane.showMessageDialog(null, "Data berhasil di ubah", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
                
                tampil_database();
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di ubah", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (id_lapangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf id belum di isi");
            id_lapangan.requestFocus();
        }else{
            if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ini ?",
            "Warning",2) == JOptionPane.YES_OPTION){
                String id = "";
                try{
                    lapangan.setId(id_lapangan.getText());
                    lapangan.hapusLapangan(lapangan.getId());
                    JOptionPane.showMessageDialog(null, "Data Berhasil di hapus",
            "Informasi",JOptionPane.INFORMATION_MESSAGE);
                    tampil_database();
                    reset();
                }catch(Exception e){
                       JOptionPane.showMessageDialog(null, "Data gagal di hapus",
            "Informasi",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        reset();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tblLapanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLapanganMouseClicked
        try{
           int row = tblLapangan.rowAtPoint(evt.getPoint());
           String id = tblLapangan.getValueAt(row, 0).toString();
           String nama = tblLapangan.getValueAt(row,1).toString();
           String harga = tblLapangan.getValueAt(row,2).toString();
           
           id_lapangan.setText(String.valueOf(id));
           namaLapangan.setText(String.valueOf(nama));
           hargaLapangan.setText(String.valueOf(harga));
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblLapanganMouseClicked

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
            java.util.logging.Logger.getLogger(FormLapangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLapangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLapangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLapangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLapangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField hargaLapangan;
    private javax.swing.JTextField id_lapangan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namaLapangan;
    private javax.swing.JTable tblLapangan;
    // End of variables declaration//GEN-END:variables
}
