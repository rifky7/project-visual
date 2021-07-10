/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import common.JasaType;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.DatabaseConnection;

/**
 *
 * @author cosmo
 */
public class FormJasa extends javax.swing.JFrame {
    private Connection conn= new DatabaseConnection().connect();
    private DefaultTableModel tabmode;
    
    
    /**
     * Creates new form FormJasa
     */
    public FormJasa() {
        initComponents();
        datatable();
        tipejasa.setModel(new DefaultComboBoxModel(JasaType.values()));
        kosong();
        aktif();
    }
    
    
    void aktif() {
        jasaid.setEnabled(true);
        namajasa.setEnabled(true);
        harga.setEnabled(true);
        estimasiwaktu.setEnabled(true);
        jasaid.requestFocus();
    }
    
    void kosong() {
        jasaid.setText("");
        namajasa.setText("");
        harga.setText("");
        estimasiwaktu.setText("");
        tipejasa.setSelectedIndex(0);
        tcari.setText("");
        
    }
    
    protected void datatable() {
        Object [] baris = {"Jasa Id", "Nama Jasa", "Harga", "Tipe Jasa", "Estimasi Waktu"};
        tabmode = new DefaultTableModel(null, baris);
        tabeljasa.setModel(tabmode);
        String sql = "select * from mst_jasa";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String a = hasil.getString("jasaid");
                String b = hasil.getString("namajasa");
                String c = hasil.getString("tipejasa");
                String d = hasil.getString("harga");
                String e = hasil.getString("estimasiwaktu");
                String [] data  = {a,b,c,d,e};
                tabmode.addRow(data);
                
            } 
        } catch (SQLException e){}
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jasaid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        namajasa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tipejasa = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        estimasiwaktu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bcancel = new javax.swing.JButton();
        bexit = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        bsave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeljasa = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORM JASA");

        jLabel2.setText("Jasa ID");

        jasaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jasaidActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Jasa");

        namajasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namajasaActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipe Jasa");

        tipejasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipejasaActionPerformed(evt);
            }
        });

        jLabel5.setText("Harga");

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });

        jLabel6.setText("Estimasi Waktu");

        jLabel7.setText("menit");

        bcancel.setText("Cancel");
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelActionPerformed(evt);
            }
        });

        bexit.setText("Exit");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });

        bedit.setText("Edit");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bdelete.setText("Delete");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });

        bsave.setText("Save");
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });

        tabeljasa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Jasa", "Nama Jasa", "Tipe Jasa", "Harga", "Estimasi Waktu"
            }
        ));
        tabeljasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeljasaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeljasa);

        jLabel8.setText("Kata Kunci Pencarian");

        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(220, 220, 220))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(namajasa, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jasaid, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tipejasa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(estimasiwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel7))))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(tcari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcari)
                                .addGap(44, 44, 44))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bsave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bedit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bdelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bexit)
                                .addGap(26, 26, 26))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jasaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namajasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tipejasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(estimasiwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bedit)
                    .addComponent(bdelete)
                    .addComponent(bcancel)
                    .addComponent(bexit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namajasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namajasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namajasaActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed

        dispose();
    }//GEN-LAST:event_bexitActionPerformed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        // TODO add your handling code here:
        String sql = "insert into mst_jasa values(?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, jasaid.getText());
            stat.setString(2, namajasa.getText());
            stat.setString(3, tipejasa.getSelectedItem().toString());
            stat.setString(4, harga.getText());
            stat.setString(5, estimasiwaktu.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            jasaid.requestFocus();
            datatable();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data tidak Berhasil Disimpan");
        }
    }//GEN-LAST:event_bsaveActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        String sql = "update mst_jasa set namajasa=?, tipejasa=?, harga=?, estimasiwaktu=? where jasaid=?";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namajasa.getText());
            stat.setString(2, tipejasa.getSelectedItem().toString());
            stat.setString(3, harga.getText());
            stat.setString(4, estimasiwaktu.getText());
            stat.setString(5, jasaid.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            kosong();
            jasaid.requestFocus();
            datatable();
            
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data tidak Berhasil Diubah");
        }
    }//GEN-LAST:event_beditActionPerformed

    private void tabeljasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeljasaMouseClicked
        // TODO add your handling code here:
        int bar = tabeljasa.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        
        jasaid.setText(a);
        namajasa.setText(b);
        tipejasa.setSelectedItem(JasaType.valueOf(c));
        harga.setText(d);
        estimasiwaktu.setText(e);
    }//GEN-LAST:event_tabeljasaMouseClicked

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        // TODO add your handling code here:
        String sql = "delete from mst_jasa where jasaid=?";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, jasaid.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            kosong();
            jasaid.requestFocus();
            datatable();
            
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data tidak Berhasil Dihapus");
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelActionPerformed
        // TODO add your handling code here:
        kosong();
        datatable();
    }//GEN-LAST:event_bcancelActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
        Object [] baris = {"Jasa Id", "Nama Jasa", "Harga", "Tipe Jasa", "Estimasi Waktu"};
        tabmode = new DefaultTableModel(null, baris);
        tabeljasa.setModel(tabmode);
        String sql = "select * from mst_jasa where jasaid like '%"+tcari.getText()+"%'";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String a = hasil.getString("jasaid");
                String b = hasil.getString("namajasa");
                String c = hasil.getString("tipejasa");
                String d = hasil.getString("harga");
                String e = hasil.getString("estimasiwaktu");
                String [] data  = {a,b,c,d,e};
                tabmode.addRow(data);
                
            } 
        } catch (SQLException e){}
    }//GEN-LAST:event_bcariActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed

    private void jasaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jasaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jasaidActionPerformed

    private void tipejasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipejasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipejasaActionPerformed

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
            java.util.logging.Logger.getLogger(FormJasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormJasa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcancel;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bexit;
    private javax.swing.JButton bsave;
    private javax.swing.JTextField estimasiwaktu;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jasaid;
    private javax.swing.JTextField namajasa;
    private javax.swing.JTable tabeljasa;
    private javax.swing.JTextField tcari;
    private javax.swing.JComboBox<String> tipejasa;
    // End of variables declaration//GEN-END:variables

}
