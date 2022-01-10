package mahasiswa;
import java.sql.*;
import java.text.SimpleDateFormat;
import mahasiswa.koneksi;
import java.util.Date;
import javax.swing.JOptionPane;
import java.lang.Exception;
import javax.swing.table.DefaultTableModel;

public class Mahasiswa extends javax.swing.JFrame {
    koneksi con;
    private Object [][]tbl_input = null;
    private String []label = {"NPM", "NAMA", "TANGGAL LAHIR", "JURUSAN", "ALAMAT"};
        
    public Mahasiswa() {
        initComponents();
        con = new koneksi();
              
    }
    
    private void BacaTabel(){
        try {
            con.ss = (Statement) con.cc.createStatement();
            String sql = "Select * From mahasiswa ";
            con.rr = con.ss.executeQuery(sql);
            ResultSetMetaData m = con.rr.getMetaData();
            int kolom = m.getColumnCount();
            int baris = 0;
            while (con.rr.next()){
                baris = con.rr.getRow();
            }
            tbl_input = new Object[baris][kolom];
            int x = 0;
            con.rr.beforeFirst();            
            while (con.rr.next()){
                tbl_input [x][0] = con.rr.getString("npm");
                tbl_input [x][1] = con.rr.getString("nama");
                tbl_input [x][2] = con.rr.getString("tgllahir");
                tbl_input [x][3] = con.rr.getString("jurusan");
                tbl_input [x][4] = con.rr.getString("alamat");
                x++;
            }
            txttabel.setModel(new DefaultTableModel(tbl_input, label));                    
        } catch (SQLException e) {    
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setTabel(){
        int row = txttabel.getSelectedRow();
        txtnpm.setText((String)txttabel.getValueAt(row, 0));
        txtnama.setText((String)txttabel.getValueAt(row, 1));        
        txttgllahir.setText((String)txttabel.getValueAt(row, 2)); ;
        txtjurusan.setText((String)txttabel.getValueAt(row, 3));
        txtalamat.setText((String)txttabel.getValueAt(row, 4));
    }
    
    private void simpan(){
        String npm = this.txtnpm.getText();
        String nama = this.txtnama.getText();       
        String tgllahir = this.txttgllahir.getText();
        String jurusan = this.txtjurusan.getText();
        String alamat = this.txtalamat.getText();
        try {
          String sql= "Insert into mahasiswa values (?,?,?,?,?)";
          PreparedStatement p;
            p = (PreparedStatement) con.cc.prepareStatement(sql);
            p.setString(1, npm);
            p.setString(2, nama);
            p.setString(3, tgllahir);
            p.setString(4, jurusan);
            p.setString(5, alamat);
            p.executeUpdate();
            
            BacaTabel();
            JOptionPane.showMessageDialog(this, "Data sukses di input");
                        
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    
    private void edit(){
        String npm = this.txtnpm.getText();
        String nama = this.txtnama.getText();
        String tgllahir= this.txttgllahir.getText();
        String jurusan = this.txtjurusan.getText();
        String alamat = this.txtalamat.getText();
        
        try {
          String sql= "Update mahasiswa Set nama=?, tgllahir=?, jurusan=?, alamat=? Where npm=?";
          PreparedStatement p = (PreparedStatement) con.cc.prepareStatement(sql);
            p.setString(5, npm);
            p.setString(1, nama);
            p.setString(2, tgllahir);
            p.setString(3, jurusan);
            p.setString(4, alamat);
            p.executeUpdate();
            
            BacaTabel();
            JOptionPane.showMessageDialog(this, "Data sukses di edit");
                        
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    
    private void hapus(){
        try {
            String sql = "Delete From mahasiswa Where npm = '"+txtnpm.getText()+"'";
            con.ss.executeUpdate(sql);
            con.ss.close();
            JOptionPane.showMessageDialog(null, " Data berhasil dihapus");
            BacaTabel();
            txtnpm.requestFocus();
                       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
    private  void baru (){
        txtnpm.setText("");
        txtnama.setText("");
        txttgllahir.setText("");
        txtjurusan.setText(""); 
        txtalamat.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txttabel = new javax.swing.JTable();
        txtnama = new javax.swing.JTextField();
        txtnpm = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtjurusan = new javax.swing.JTextArea();
        Fsimpan = new javax.swing.JButton();
        Fedit = new javax.swing.JButton();
        Fhapus = new javax.swing.JButton();
        Fbaru = new javax.swing.JButton();
        Fkeluar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txttgllahir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NAMA");

        jLabel2.setText("NPM");

        jLabel4.setText("DATA MAHASISWA");

        jLabel6.setText("JURUSAN");

        txttabel.setModel(new javax.swing.table.DefaultTableModel(
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
        txttabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txttabel);

        txtnama.setText("annisa");
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        txtnpm.setText("2009010082");

        txtjurusan.setColumns(20);
        txtjurusan.setRows(5);
        txtjurusan.setText("sistem informasi");
        txtjurusan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtjurusanAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(txtjurusan);

        Fsimpan.setText("SIMPAN");
        Fsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FsimpanActionPerformed(evt);
            }
        });

        Fedit.setText("EDIT");
        Fedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeditActionPerformed(evt);
            }
        });

        Fhapus.setText("HAPUS");
        Fhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FhapusActionPerformed(evt);
            }
        });

        Fbaru.setText("BARU");
        Fbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FbaruActionPerformed(evt);
            }
        });

        Fkeluar.setText("KELUAR");
        Fkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FkeluarActionPerformed(evt);
            }
        });

        jLabel7.setText("TANGGAL LAHIR");

        txttgllahir.setText("19 maret 2000");

        jLabel8.setText("ALAMAT");

        txtalamat.setText("medan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtnpm, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txttgllahir, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(17, 17, 17)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Fsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Fedit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Fhapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fbaru)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Fkeluar))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtnpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttgllahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fsimpan)
                    .addComponent(Fedit)
                    .addComponent(Fhapus)
                    .addComponent(Fbaru)
                    .addComponent(Fkeluar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FkeluarActionPerformed
        dispose();
    }//GEN-LAST:event_FkeluarActionPerformed

    private void FbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FbaruActionPerformed
        baru();
    }//GEN-LAST:event_FbaruActionPerformed

    private void FhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FhapusActionPerformed
        hapus();
    }//GEN-LAST:event_FhapusActionPerformed

    private void FeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeditActionPerformed
        edit();
    }//GEN-LAST:event_FeditActionPerformed

    private void FsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FsimpanActionPerformed
        simpan();
    }//GEN-LAST:event_FsimpanActionPerformed

    private void txttabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttabelMouseClicked
        setTabel();
    }//GEN-LAST:event_txttabelMouseClicked

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtjurusanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtjurusanAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjurusanAncestorAdded

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Mahasiswa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Fbaru;
    private javax.swing.JButton Fedit;
    private javax.swing.JButton Fhapus;
    private javax.swing.JButton Fkeluar;
    private javax.swing.JButton Fsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextArea txtjurusan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnpm;
    private javax.swing.JTable txttabel;
    private javax.swing.JTextField txttgllahir;
    // End of variables declaration//GEN-END:variables

    
}
