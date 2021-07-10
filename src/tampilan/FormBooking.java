/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.DatabaseConnection;

/**
 *
 * @author cosmo
 */
public class FormBooking extends javax.swing.JFrame {

    private Connection conn = new DatabaseConnection().connect();
    private DefaultTableModel tabmode;
    
    // Buat Combo box
    private List<String> listCbBengkel = new ArrayList<>();
    private List<String> listCbMotor = new ArrayList<>();
    private List<String> listCbJasa = new ArrayList<>();
    private List<String> listCbMekanik = new ArrayList<>();
    
    String description = null;
    Double hargaPart = 0.0;
    Double totalHargaPart = 0.0;
    String kodeBengkel = null;
    Double totalHargaJasa = 0.0;
    
    /**
     * Creates new form Form_Booking
     */
    public FormBooking() {
        initComponents();
        initTabelPart();
        initCbBengkel();
        initCbMotor();
        initCbJasa();
        setDisableField();
    }
    
    private void setDisableField() {
        tNomesin.setEditable(false);
        tCustId.setEditable(false);
        tCustName.setEditable(false);
        tJasaName.setEditable(false);
        tPartDescription.setEditable(false);
        tHargaJasa.setEditable(false);
        tHargaPart.setEditable(false);
        tTotalHarga.setEditable(false);
        
    }
    
    private void initCbBengkel() {
        String sql = "SELECT namabengkel FROM mst_bengkel";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listCbBengkel.add(rs.getString("namabengkel"));
            }
            cbBengkel.setModel(new DefaultComboBoxModel(new String[]{"0"}));
            if(!listCbBengkel.isEmpty()) {
                cbBengkel.setModel(new DefaultComboBoxModel(listCbBengkel.toArray()));
            } 
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initCbMotor() {
        String sql = "SELECT motorid FROM mst_motor";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listCbMotor.add(rs.getString("motorid"));
            }
            cbMotor.setModel(new DefaultComboBoxModel(new String[]{"0"}));
            if(!listCbMotor.isEmpty()) {
                cbMotor.setModel(new DefaultComboBoxModel(listCbMotor.toArray()));
            } 
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initCbJasa() {
        String sql = "SELECT jasaid FROM mst_jasa";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listCbJasa.add(rs.getString("jasaid"));
            }
            cbJasaId.setModel(new DefaultComboBoxModel(new String[]{"0"}));
            if(!listCbJasa.isEmpty()) {
                cbJasaId.setModel(new DefaultComboBoxModel(listCbJasa.toArray()));
            } 
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initCbMekanik(String kodeBengkel) {
        String sql = "SELECT namamekanik FROM mst_mekanik ";
        if(kodeBengkel != null) {
            sql += "where kodebengkel = '"+kodeBengkel+"'";
        }
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listCbMekanik.add(rs.getString("namamekanik"));
            }
            cbMekanik.setModel(new DefaultComboBoxModel(new String[]{"0"}));
            if(!listCbMekanik.isEmpty()) {
                cbMekanik.setModel(new DefaultComboBoxModel(listCbMekanik.toArray()));
            } 
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void setKodeBengkel(String namaBengkel) {
        String sql = "SELECT kodebengkel FROM mst_bengkel where namabengkel = '"+ namaBengkel + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                kodeBengkel = rs.getString("kodebengkel");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void initTabelPart() {
        Object[] baris = {"Kode Part", "Deskripsi", "Harga", "Kuantitas"};
        tabmode = new DefaultTableModel(null, baris);
        tblPart.setModel(tabmode);
    }
    
    private void hitungTotalPart() {
        Integer size = tblPart.getRowCount();
        totalHargaPart = 0.0;
        for (int i = 0; i < size; i++) {
            Double harga = Double.parseDouble(tblPart.getValueAt(i, 2).toString());
            Integer qty = Integer.parseInt(tblPart.getValueAt(i, 3).toString());
            totalHargaPart += (harga*qty);
        }
        tHargaPart.setText(totalHargaPart.toString());
    }
    
    private void hitungTotalHarga() {
        tTotalHarga.setText(String.valueOf(totalHargaJasa+totalHargaPart));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tNoTransaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spTanggalBooking = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        cbBengkel = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tNopol = new javax.swing.JTextField();
        bCariNopol = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tCustId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tCustName = new javax.swing.JTextField();
        tNomesin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbMotor = new javax.swing.JComboBox<>();
        tKmMotor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbJasaId = new javax.swing.JComboBox<>();
        tJasaName = new javax.swing.JTextField();
        tPartCode = new javax.swing.JTextField();
        bCariPart = new javax.swing.JButton();
        bAddPart = new javax.swing.JButton();
        tPartDescription = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPart = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        tHargaPart = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tHargaJasa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbMekanik = new javax.swing.JComboBox<>();
        tQty = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        tTotalHarga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Form Booking Service");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("No. Transaksi");

        tNoTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNoTransaksiActionPerformed(evt);
            }
        });

        jLabel3.setText("Tgl. Booking");

        spTanggalBooking.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.AM_PM));

        jLabel12.setText("Bengkel");

        cbBengkel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbBengkel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBengkelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbBengkel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTanggalBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(spTanggalBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbBengkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("No. Polisi");

        bCariNopol.setText("Cari");
        bCariNopol.setMargin(new java.awt.Insets(2, 5, 2, 5));
        bCariNopol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariNopolActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Data Customer");

        jLabel6.setText("ID Cust");

        tCustId.setEditable(false);

        jLabel7.setText("Nama");

        tCustName.setEditable(false);

        jLabel8.setText("No. Mesin");

        jLabel9.setText("KM Motor");

        jLabel10.setText("Unit Motor");

        cbMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Data Service");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Data Sparepart");

        cbJasaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbJasaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJasaIdActionPerformed(evt);
            }
        });

        tJasaName.setEditable(false);

        bCariPart.setText("Cari");
        bCariPart.setMargin(new java.awt.Insets(2, 5, 2, 5));
        bCariPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariPartActionPerformed(evt);
            }
        });

        bAddPart.setText("Tambah");
        bAddPart.setMargin(new java.awt.Insets(2, 5, 2, 5));
        bAddPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddPartActionPerformed(evt);
            }
        });

        tPartDescription.setEditable(false);

        tblPart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPart);

        jLabel14.setText("Estimasi Harga Sparepart");

        tHargaPart.setEditable(false);

        jLabel15.setText("Estimasi Harga Jasa");

        tHargaJasa.setEditable(false);

        jLabel16.setText("Mekanik (Optional)");

        cbMekanik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tQty.setForeground(new java.awt.Color(153, 153, 153));
        tQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tQty.setText("qty");
        tQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tQtyFocusGained(evt);
            }
        });
        tQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tQtyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tHargaPart, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(tNopol)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bCariNopol))
                                        .addComponent(tNomesin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(53, 53, 53)
                                            .addComponent(jLabel6))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGap(62, 62, 62)
                                            .addComponent(jLabel7)))
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tCustName, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(tCustId))
                                    .addGap(50, 50, 50)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tKmMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tHargaJasa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cbJasaId, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addComponent(tJasaName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(70, 70, 70)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(tPartCode, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(2, 2, 2)
                                            .addComponent(bCariPart)
                                            .addGap(20, 20, 20)
                                            .addComponent(tPartDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(bAddPart))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(tNopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bCariNopol))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tCustId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(tKmMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(tNomesin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(cbMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJasaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tJasaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPartCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAddPart)
                    .addComponent(tPartDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCariPart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(tHargaJasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tHargaPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cbMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(349, 349, 349))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Estimasi Total Harga");

        tTotalHarga.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Submit");

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setText("Print");

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCariNopolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariNopolActionPerformed
        // TODO add your handling code here:
        if(tNopol.getText() != null) {
            String sql = "SELECT customerid, customername, nomesin FROM mst_customer where lower(nopol)= '"+tNopol.getText().toLowerCase()+"'";
            String id = null, nama = null, nomesin = null;
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    id = rs.getString("customerid");
                    nama = rs.getString("customername");
                    nomesin = rs.getString("nomesin");
                }
                if(id != null) {
                    tCustId.setText(id);
                    tCustName.setText(nama);
                    tNomesin.setText(nomesin);
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            
    }//GEN-LAST:event_bCariNopolActionPerformed

    private void bCariPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariPartActionPerformed
        // TODO add your handling code here:
        if(tPartCode.getText() != null) {
            String sql = "SELECT kodepart, description, harga FROM mst_part where lower(kodepart)= '"+tPartCode.getText().toLowerCase()+"'";
            String code = "";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    description = rs.getString("description");
                    hargaPart = rs.getDouble("harga");
                    code = rs.getString("kodepart");
                }
                if(description != null) {
                    tPartCode.setText(code);
                    tPartDescription.setText(description);
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bCariPartActionPerformed

    private void bAddPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddPartActionPerformed
        // TODO add your handling code here:
        if(description != null && tQty.getText() != null) {
            String[] data = {tPartCode.getText(), description, hargaPart.toString(), tQty.getText()};
            tabmode.addRow(data);
        }
        hitungTotalPart();
        hitungTotalHarga();
        description = null;
        hargaPart = 0.0;
        tPartCode.setText(null);
        tPartDescription.setText(null);
        tQty.setText(null);
    }//GEN-LAST:event_bAddPartActionPerformed

    private void tNoTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNoTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNoTransaksiActionPerformed

    private void tQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tQtyActionPerformed

    private void cbJasaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJasaIdActionPerformed
        // TODO add your handling code here:
        if(cbJasaId.getSelectedItem() != null) {
            String sql = "select namajasa, harga from mst_jasa where jasaid = '"+ cbJasaId.getSelectedItem().toString() +"'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    tJasaName.setText(rs.getString("namajasa"));
                    tHargaJasa.setText(String.valueOf(rs.getDouble("harga")));
                    totalHargaJasa = rs.getDouble("harga");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            hitungTotalHarga();
        }
    }//GEN-LAST:event_cbJasaIdActionPerformed

    private void cbBengkelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBengkelActionPerformed
        // TODO add your handling code here:
        setKodeBengkel(cbBengkel.getSelectedItem().toString());
        listCbMekanik = new ArrayList<>();
        initCbMekanik(kodeBengkel);
    }//GEN-LAST:event_cbBengkelActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DetailActivity menu = new DetailActivity();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tQtyFocusGained
        // TODO add your handling code here:
        if(tQty.getText().equals("qty")) {
            tQty.setText("");
        }
    }//GEN-LAST:event_tQtyFocusGained

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
            java.util.logging.Logger.getLogger(FormBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddPart;
    private javax.swing.JButton bCariNopol;
    private javax.swing.JButton bCariPart;
    private javax.swing.JComboBox<String> cbBengkel;
    private javax.swing.JComboBox<String> cbJasaId;
    private javax.swing.JComboBox<String> cbMekanik;
    private javax.swing.JComboBox<String> cbMotor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spTanggalBooking;
    private javax.swing.JTextField tCustId;
    private javax.swing.JTextField tCustName;
    private javax.swing.JTextField tHargaJasa;
    private javax.swing.JTextField tHargaPart;
    private javax.swing.JTextField tJasaName;
    private javax.swing.JTextField tKmMotor;
    private javax.swing.JTextField tNoTransaksi;
    private javax.swing.JTextField tNomesin;
    private javax.swing.JTextField tNopol;
    private javax.swing.JTextField tPartCode;
    private javax.swing.JTextField tPartDescription;
    private javax.swing.JTextField tQty;
    private javax.swing.JTextField tTotalHarga;
    private javax.swing.JTable tblPart;
    // End of variables declaration//GEN-END:variables
}
