package View;

import View.FormSewa;
import View.AdminLogin;
import View.FormPenyewa;
import View.FormLapangan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import pembayaran.FormPembayaran;
//import registrasi.FormRegistrasi;

/**
 *
 * @author RobyHuzwandar
 */
public class Main2 extends javax.swing.JFrame {

    public Main2() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        aksesLogout();

    }

    public void aksesLogout() {
        menuData.setEnabled(false);
        menuTransaksi.setEnabled(false);
        Main2.btnBoking.setEnabled(false);
        Main2.btnLap.setEnabled(false);
        Main2.btnPenyewa.setEnabled(false);
        Main2.jmLogOut.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu3 = new javax.swing.JMenu();
        panelGambar1 = new Desktop.panelGambar();
        jPanel2 = new javax.swing.JPanel();
        panelGambar2 = new Desktop.panelGambar();
        jPanel3 = new javax.swing.JPanel();
        btnBeranda = new javax.swing.JButton();
        btnBoking = new javax.swing.JButton();
        btnPenyewa = new javax.swing.JButton();
        btnLap = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmLogin = new javax.swing.JMenuItem();
        jmLogOut = new javax.swing.JMenuItem();
        jmKeluar = new javax.swing.JMenuItem();
        menuData = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

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

        jMenu3.setText("jMenu3");

        javax.swing.GroupLayout panelGambar1Layout = new javax.swing.GroupLayout(panelGambar1);
        panelGambar1.setLayout(panelGambar1Layout);
        panelGambar1Layout.setHorizontalGroup(
            panelGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelGambar1Layout.setVerticalGroup(
            panelGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        btnBeranda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBeranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home-icon.png"))); // NOI18N
        btnBeranda.setText("Beranda");
        btnBeranda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBeranda.setMaximumSize(new java.awt.Dimension(79, 55));
        btnBeranda.setMinimumSize(new java.awt.Dimension(79, 55));
        btnBeranda.setPreferredSize(new java.awt.Dimension(79, 50));
        btnBeranda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBeranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerandaActionPerformed(evt);
            }
        });

        btnBoking.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBoking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Handshake_32px.png"))); // NOI18N
        btnBoking.setText("Boking");
        btnBoking.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBoking.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBoking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBokingActionPerformed(evt);
            }
        });

        btnPenyewa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPenyewa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/community-users-icon.png"))); // NOI18N
        btnPenyewa.setText("Penyewa");
        btnPenyewa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPenyewa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenyewaActionPerformed(evt);
            }
        });

        btnLap.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lapangan.png"))); // NOI18N
        btnLap.setText("Lapangan");
        btnLap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnBoking)
                .addGap(29, 29, 29)
                .addComponent(btnPenyewa)
                .addGap(18, 18, 18)
                .addComponent(btnLap)
                .addContainerGap(708, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBeranda, btnBoking, btnLap, btnPenyewa});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBoking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPenyewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGambar2Layout = new javax.swing.GroupLayout(panelGambar2);
        panelGambar2.setLayout(panelGambar2Layout);
        panelGambar2Layout.setHorizontalGroup(
            panelGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGambar2Layout.setVerticalGroup(
            panelGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGambar2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 438, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGambar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGambar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        jmLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login.png"))); // NOI18N
        jmLogin.setText("Login");
        jmLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLoginActionPerformed(evt);
            }
        });
        jMenu1.add(jmLogin);

        jmLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logout Rounded Left_25px.png"))); // NOI18N
        jmLogOut.setText("Logout");
        jmLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(jmLogOut);

        jmKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Actions-window-close-icon.png"))); // NOI18N
        jmKeluar.setText("keluar");
        jmKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmKeluarActionPerformed(evt);
            }
        });
        jMenu1.add(jmKeluar);

        jMenuBar1.add(jMenu1);

        menuData.setText("Data");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Checklist_20px.png"))); // NOI18N
        jMenuItem1.setText("Lapangan");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuData.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/penyewa.png"))); // NOI18N
        jMenuItem2.setText("Penyewa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuData.add(jMenuItem2);

        jMenuBar1.add(menuData);

        menuTransaksi.setText("Transaksi");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/boking_20px.png"))); // NOI18N
        jMenuItem8.setText("Sewa Lapangan");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        menuTransaksi.add(jMenuItem8);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cash In Hand_20px.png"))); // NOI18N
        jMenuItem7.setText("Pembayaran");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuTransaksi.add(jMenuItem7);

        jMenuBar1.add(menuTransaksi);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLoginActionPerformed
        new AdminLogin().setVisible(true);
    }//GEN-LAST:event_jmLoginActionPerformed

    private void jmLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLogOutActionPerformed
        aksesLogout();
    }//GEN-LAST:event_jmLogOutActionPerformed

    private void jmKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmKeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmKeluarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new FormLapangan().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new FormPenyewa().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            new FormSewa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
//        new FormPembayaran().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void btnBerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBerandaActionPerformed
        new Main2().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBerandaActionPerformed

    private void btnPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenyewaActionPerformed
        new FormPenyewa().setVisible(true);
    }//GEN-LAST:event_btnPenyewaActionPerformed

    private void btnLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapActionPerformed
        new FormLapangan().setVisible(true);
    }//GEN-LAST:event_btnLapActionPerformed

    private void btnBokingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBokingActionPerformed
        try {
            new FormSewa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBokingActionPerformed

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
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBeranda;
    public static javax.swing.JButton btnBoking;
    public static javax.swing.JButton btnLap;
    public static javax.swing.JButton btnPenyewa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem jmKeluar;
    public static javax.swing.JMenuItem jmLogOut;
    private javax.swing.JMenuItem jmLogin;
    public static javax.swing.JMenu menuData;
    public static javax.swing.JMenu menuTransaksi;
    private Desktop.panelGambar panelGambar1;
    private Desktop.panelGambar panelGambar2;
    // End of variables declaration//GEN-END:variables
}
