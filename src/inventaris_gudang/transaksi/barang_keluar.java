package inventaris_gudang.transaksi;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import jnafilechooser.api.JnaFileChooser;

import inventaris_gudang.db_connection;
import inventaris_gudang.session;
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class barang_keluar extends javax.swing.JDialog {

    public barang_keluar(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        tgl_masuk_input.setText(dateFormat.format(cal.getTime()));

        SelectKategori();
        setIconImage();
        load_table();
        cleaner();

        // Disable button

            btn_enable(false);
            button_save.setText("Save");

            id_barang_select.hide();

    }

    public void load_table() {

        DefaultTableModel model = new DefaultTableModel();

            model.addColumn("#");
            model.addColumn("Date");
            model.addColumn("Total");
            model.addColumn("Items");

        try {

            String sql = "SELECT barang_keluar.id_barang_keluar, barang_keluar.tanggal_barang_keluar, barang_keluar.total_barang_keluar, barang.nama_barang as barang FROM barang_keluar JOIN barang ON barang.id_barang = barang_keluar.barang";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {

                model.addRow(new Object[] {

                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),

                });

            }

            table.setModel(model);

            String count_data = String.valueOf(table.getRowCount());
            jumlah_label.setText("Jumlah data : " + count_data);

        } catch (Exception e) {

            System.out.println("Error occured: " + e.getMessage());

        }

    }

    public void load_table_view() {

        int row = table.getSelectedRow();
        String row_id = (table.getModel().getValueAt(row, 0).toString());

        id_input.setText(row_id);

        btn_enable(true);

        if (row_id.equals(Integer.toString(session.get_id()))) {

            button_delete.setEnabled(false);

        }

    }

    private void btn_enable(boolean x) {

        button_delete.setEnabled(x);

    }

    private void cleaner() {
        
        total_input.setText(null);
        id_input.setText(null);
        barang_input.setSelectedItem("-- Pilih --");

    }

    private void SelectKategori() {

        try {

            String sql = "SELECT * FROM barang";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

                    barang_input.addItem("-- Pilih --");

                while (res.next()) {

                    barang_input.addItem(res.getString("nama_barang"));

                }

        } catch (Exception e) {

            System.out.println("Error occurate: " + e.getLocalizedMessage());

        }

    }
    
    private void exportToExcel(JTable table, String filePath) {
        
        try {

            TableModel model = table.getModel();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Data");

            //  Membuat header kolom

                Row headerRow = sheet.createRow(0);

                for (int i = 0; i < model.getColumnCount(); i++) {

                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(model.getColumnName(i));

                }

            // Membuat data baris

                for (int i = 0; i < model.getRowCount(); i++) {

                    Row row = sheet.createRow(i + 1);

                    for (int j = 0; j < model.getColumnCount(); j++) {

                        Cell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());

                    }

                }

                // Menyimpan file Excel

                FileOutputStream fileOut = new FileOutputStream(new File(filePath));
                workbook.write(fileOut);
                fileOut.close();

                JOptionPane.showMessageDialog(null, "Data berhasil di ekspor ke dalam file Excel");

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengekspor ke Excel: " + e.getMessage());

        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){     public boolean isCellEditable(int rowIndex, int colIndex) {         return false;     } };
        button_add = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_refresh = new javax.swing.JButton();
        form_title = new javax.swing.JLabel();
        card_form = new javax.swing.JPanel();
        tgl_masuk_label = new javax.swing.JLabel();
        tgl_masuk_input = new javax.swing.JTextField();
        total_label = new javax.swing.JLabel();
        barang_label = new javax.swing.JLabel();
        button_save = new javax.swing.JButton();
        button_cancel = new javax.swing.JButton();
        total_input = new javax.swing.JTextField();
        barang_input = new javax.swing.JComboBox<String>();
        jumlah_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        id_input = new javax.swing.JTextField();
        id_barang_select = new javax.swing.JTextField();
        button_print = new javax.swing.JButton();
        button_excel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Karyawan");
        setBackground(new java.awt.Color(60, 60, 60));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 255, 204));

        title.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Data Barang Keluar");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        content.setBackground(new java.awt.Color(102, 102, 102));
        content.setForeground(new java.awt.Color(60, 63, 65));
        content.setToolTipText("");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Date", "Total", "Items"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        button_add.setForeground(new java.awt.Color(0, 0, 0));
        button_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        button_add.setText("Add");
        button_add.setIconTextGap(8);
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_delete.setForeground(new java.awt.Color(0, 0, 0));
        button_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        button_delete.setText("Delete");
        button_delete.setIconTextGap(8);
        button_delete.setPreferredSize(new java.awt.Dimension(68, 32));
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reload.png"))); // NOI18N
        button_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_refreshActionPerformed(evt);
            }
        });

        form_title.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        form_title.setForeground(new java.awt.Color(255, 255, 255));
        form_title.setText("Tambah Data");

        card_form.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        card_form.setOpaque(false);
        card_form.setPreferredSize(new java.awt.Dimension(370, 230));
        card_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tgl_masuk_label.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        tgl_masuk_label.setForeground(new java.awt.Color(255, 255, 255));
        tgl_masuk_label.setText("Tanggal Keluar");
        card_form.add(tgl_masuk_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tgl_masuk_input.setEditable(false);
        card_form.add(tgl_masuk_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 210, -1));

        total_label.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        total_label.setForeground(new java.awt.Color(255, 255, 255));
        total_label.setText("Total Keluar");
        card_form.add(total_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        barang_label.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        barang_label.setForeground(new java.awt.Color(255, 255, 255));
        barang_label.setText("Barang");
        card_form.add(barang_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        button_save.setText("Save");
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });
        card_form.add(button_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 130, -1));

        button_cancel.setText("Cancel");
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });
        card_form.add(button_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));
        card_form.add(total_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 210, -1));

        barang_input.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                barang_inputItemStateChanged(evt);
            }
        });
        card_form.add(barang_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 210, -1));

        jumlah_label.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jumlah_label.setForeground(new java.awt.Color(255, 255, 255));
        jumlah_label.setText("Jumlah data");

        id_label.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        id_label.setForeground(new java.awt.Color(255, 255, 255));
        id_label.setText("ID");

        id_input.setEditable(false);

        button_print.setText("Print");
        button_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_printActionPerformed(evt);
            }
        });

        button_excel.setText("Excel");
        button_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_excelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244)
                        .addComponent(button_refresh))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(form_title)
                            .addComponent(card_form, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_barang_select, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addComponent(button_print, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jumlah_label)
                        .addGap(312, 312, 312)
                        .addComponent(id_label)
                        .addGap(6, 6, 6)
                        .addComponent(id_input, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(form_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card_form, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_barang_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_print)
                            .addComponent(button_excel))))
                .addGap(12, 12, 12)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jumlah_label))
                    .addComponent(id_label)
                    .addComponent(id_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, 850, 470));
        content.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_excelActionPerformed
        
        JnaFileChooser filechooser = new JnaFileChooser();
        Window window = null;
        boolean action = filechooser.showOpenDialog(window);
        
        if (action) {
            
            String fileString = filechooser.getSelectedFile() + " .xlsx";
            exportToExcel(table, fileString);
            
        }
        
    }//GEN-LAST:event_button_excelActionPerformed

    private void button_printActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            String path =  "src/report/report_barang_keluar.jasper";
            java.sql.Connection con = (Connection) db_connection.configDB();

            HashMap<String, Object> parameters = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(path, parameters, con);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
            
            this.dispose();
            
        } catch (Exception e) {
            
            System.out.println("Error occured: " + e.getMessage());
            
        }

    }


    // < Buttons >

        private void button_addActionPerformed(java.awt.event.ActionEvent evt) {
           
            form_title.setForeground(Color.white);
            form_title.setText("Tambah Data");

            table.clearSelection();
            cleaner();

            btn_enable(false);

            button_save.setText("Save");
            tgl_masuk_input.requestFocus();

        }

        private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {

            int valid = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this data?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

            if (valid == 0) {

                try {

                    String row_id = id_input.getText();
                    String sql = "DELETE FROM barang_keluar WHERE id_barang_keluar = '"+ row_id + "'";

                        java.sql.Connection con = (Connection) db_connection.configDB();
                        java.sql.Statement stm = con.createStatement();
                        stm.executeUpdate(sql);

                        JOptionPane.showMessageDialog(null, "Data has confirmed being deleted.");
                        button_add.doClick();

                        load_table();

                } catch (Exception e) {

                    System.out.println("Error occured: " + e.getMessage());

                }

            }
        
        }

        private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {

            String row_id = id_input.getText();
            String row_tanggal = tgl_masuk_input.getText();
            String row_total = total_input.getText();
            String id_barang = id_barang_select.getText();
            int row_barang = Integer.parseInt(id_barang);
            
                int code = 0;

                if (!"".equals(row_total) && !"".equals(row_barang)) {

                    try {

                        String sql = "SELECT COUNT(barang_keluar.barang) as count FROM barang_keluar WHERE barang_keluar.barang='"+ row_barang +"'";

                            java.sql.Connection con = (Connection) db_connection.configDB();
                            java.sql.Statement stm = con.createStatement();
                            java.sql.ResultSet res = stm.executeQuery(sql);

                            res.next();
                            code = res.getInt("count");

                    } catch (Exception e) {

                        System.out.println("Error occured: " + e.getMessage());

                    }

                    if ("".equals(row_id)) {

                        if (code == 0) {

                            try {

                                String sql = "INSERT INTO barang_keluar(tanggal_barang_keluar, total_barang_keluar, barang) VALUES('"+ row_tanggal +"', '"+ row_total +"', '"+ row_barang +"')";

                                    java.sql.Connection con = (Connection) db_connection.configDB();
                                    java.sql.Statement stm = con.createStatement();
                                    stm.executeUpdate(sql);

                                    JOptionPane.showMessageDialog(null, "Successfully added new data.");

                                    button_add.doClick();
                                    load_table();

                            } catch (Exception e) {

                                System.out.println("Error occured: " + e.getMessage());

                            }

                        }

                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Oops! There was an empty field.");

                }
        
        }

        private void barang_inputItemStateChanged(java.awt.event.ItemEvent evt) {

            String sl_barang = barang_input.getSelectedItem().toString();

                if (!sl_barang.equals("")) {

                    try {

                        String sql = "SELECT id_barang FROM barang WHERE nama_barang='"+ sl_barang +"'";

                            java.sql.Connection con = (Connection) db_connection.configDB();
                            java.sql.Statement stm = con.createStatement();
                            java.sql.ResultSet res = stm.executeQuery(sql);

                            if (res.next()) {

                                id_barang_select.setText(res.getString("id_barang"));

                            }

                    } catch (Exception e) {

                        System.out.println("Error occured: " + e.getMessage());

                    }

                } else {

                    id_barang_select.setText("");

                }

        }

        private void tableMouseClicked(java.awt.event.MouseEvent evt) {
            
            load_table_view();

        }

        private void tableMouseReleased(java.awt.event.MouseEvent evt) {
            
            load_table_view();

        }

        private void tableKeyReleased(java.awt.event.KeyEvent evt) {
            
            load_table_view();

        }

        private void button_refreshActionPerformed(java.awt.event.ActionEvent evt) {
            
            load_table();
            
        }

        private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {

            button_add.doClick();
        
        }
        
    // < End Buttons >

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
            java.util.logging.Logger.getLogger(barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                barang_keluar dialog = new barang_keluar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void setIconImage() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/inventaris_gudang/favicon.png")));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> barang_input;
    private javax.swing.JLabel barang_label;
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_excel;
    private javax.swing.JButton button_print;
    private javax.swing.JButton button_refresh;
    private javax.swing.JButton button_save;
    private javax.swing.JPanel card_form;
    private javax.swing.JPanel content;
    private javax.swing.JLabel form_title;
    private javax.swing.JPanel header;
    private javax.swing.JTextField id_barang_select;
    private javax.swing.JTextField id_input;
    private javax.swing.JLabel id_label;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jumlah_label;
    private javax.swing.JTable table;
    private javax.swing.JTextField tgl_masuk_input;
    private javax.swing.JLabel tgl_masuk_label;
    private javax.swing.JLabel title;
    private javax.swing.JTextField total_input;
    private javax.swing.JLabel total_label;
    // End of variables declaration//GEN-END:variables
}
