package inventaris_gudang.master;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import inventaris_gudang.db_connection;


public class kategori extends javax.swing.JDialog {

    public kategori(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();

        setIconImage();
        load_table();
        cleaner();

        // Disable button

            btn_enable(false);
            button_save.setText("Save");

    }

    public void load_table() {

        DefaultTableModel model = new DefaultTableModel();

            model.addColumn("#");
            model.addColumn("Nama");
            model.addColumn("No. Rak");

        try {

            String sql = "SELECT * FROM kategori";

                java.sql.Connection con = (Connection) db_connection.configDB();
                java.sql.Statement stm = con.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {

                model.addRow(new Object[] {

                    res.getString(1),
                    res.getString(2),
                    res.getString(3),

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

    }

    private void btn_enable(boolean x) {

        button_edit.setEnabled(x);
        button_delete.setEnabled(x);

    }

    private void cleaner() {

        nama_input.setText(null);
        no_rak_input.setText(null);

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
        button_edit = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_refresh = new javax.swing.JButton();
        form_title = new javax.swing.JLabel();
        card_form = new javax.swing.JPanel();
        kode_label = new javax.swing.JLabel();
        nama_input = new javax.swing.JTextField();
        nama_label = new javax.swing.JLabel();
        no_rak_input = new javax.swing.JTextField();
        button_save = new javax.swing.JButton();
        button_cancel = new javax.swing.JButton();
        jumlah_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        id_input = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kategori Barang");
        setBackground(new java.awt.Color(60, 60, 60));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 255, 204));

        title.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Data Pelanggan");

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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nama", "No. Rak"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        button_edit.setForeground(new java.awt.Color(0, 0, 0));
        button_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        button_edit.setText("Edit");
        button_edit.setIconTextGap(8);
        button_edit.setPreferredSize(new java.awt.Dimension(68, 32));
        button_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_editActionPerformed(evt);
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

        kode_label.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        kode_label.setForeground(new java.awt.Color(255, 255, 255));
        kode_label.setText("Nama Barang");
        card_form.add(kode_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        card_form.add(nama_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 210, -1));

        nama_label.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        nama_label.setForeground(new java.awt.Color(255, 255, 255));
        nama_label.setText("No. Rak");
        card_form.add(nama_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        card_form.add(no_rak_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 210, -1));

        button_save.setText("Save");
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });
        card_form.add(button_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 130, -1));

        button_cancel.setText("Cancel");
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });
        card_form.add(button_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jumlah_label.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jumlah_label.setForeground(new java.awt.Color(255, 255, 255));
        jumlah_label.setText("Jumlah data");

        id_label.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        id_label.setForeground(new java.awt.Color(255, 255, 255));
        id_label.setText("ID");

        id_input.setEditable(false);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(button_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(button_refresh))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jumlah_label)
                        .addGap(312, 312, 312)
                        .addComponent(id_label)
                        .addGap(6, 6, 6)
                        .addComponent(id_input, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(form_title)
                            .addComponent(card_form, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(form_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card_form, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
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


    // < Buttons >

        private void button_addActionPerformed(java.awt.event.ActionEvent evt) {
           
            form_title.setForeground(Color.white);
            form_title.setText("Tambah Data");

            table.clearSelection();
            cleaner();

            btn_enable(false);

            button_save.setText("Save");
            nama_input.requestFocus();

        }

        private void button_editActionPerformed(java.awt.event.ActionEvent evt) {
        
            String row_id = id_input.getText();

            if (!"0".equals(row_id)) {

                try {

                    button_save.setText("Save Change");

                    String sql = "SELECT * FROM kategori WHERE kategori.id_kategori='"+ row_id +"'";

                        java.sql.Connection con = (Connection) db_connection.configDB();
                        java.sql.Statement stm = con.createStatement();
                        java.sql.ResultSet res = stm.executeQuery(sql);

                    if (res.next()) {
                        
                        String code_name = res.getString("nama_kategori");

                        form_title.setForeground(Color.white);
                        form_title.setText("Editing Data | " + code_name);
                        id_input.setText(res.getString("id_kategori"));
                        nama_input.setText(code_name);
                        no_rak_input.setText(res.getString("no_rak"));
                        nama_input.requestFocus();

                    }

                } catch (Exception e) {

                    System.out.println("Error occured: " + e.getMessage());

                }

            }
        
        }

        private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {

            int valid = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this data?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

            if (valid == 0) {

                try {

                    String row_id = id_input.getText();
                    String sql = "DELETE FROM kategori WHERE id_kategori = '"+ row_id + "'";

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
            String row_nama = nama_input.getText();
            String no_rak = no_rak_input.getText();
            int row_rak = Integer.parseInt(no_rak);
            
                int code = 0;

                if (!"".equals(row_nama) && !"".equals(no_rak)) {

                    try {

                        String sql = "SELECT COUNT(kategori.id_kategori) as count FROM kategori WHERE kategori.nama_kategori='"+ row_nama +"'";

                            java.sql.Connection con = (Connection) db_connection.configDB();
                            java.sql.Statement stm = con.createStatement();
                            java.sql.ResultSet res = stm.executeQuery(sql);

                            res.next();
                            code = res.getInt("count");

                    } catch (Exception e) {

                        System.out.println("Error occurred: " + e.getMessage());

                    }

                    if ("".equals(row_id)) {

                        if (code == 0) {

                            try {

                                String sql = "INSERT INTO kategori(nama_kategori, no_rak) VALUES('"+ row_nama +"', '"+ row_rak +"')";

                                    java.sql.Connection con = (Connection) db_connection.configDB();
                                    java.sql.Statement stm = con.createStatement();
                                    stm.executeUpdate(sql);

                                    JOptionPane.showMessageDialog(null, "Successfully added new data.");

                                    button_add.doClick();
                                    load_table();

                            } catch (Exception e) {

                                System.out.println("Error occurred: " + e.getMessage());

                            }

                        } else {

                            JOptionPane.showMessageDialog(null, "Items name have ever been stored before.", "Failed to attempt", JOptionPane.ERROR_MESSAGE);
                            
                        }

                    } else {

                        if (code == 0 || row_id.equals(row_id)) {

                            try {

                                String sql = "UPDATE kategori SET nama_kategori='"+ row_nama +"', no_rak='"+ row_rak +"' WHERE id_kategori = '"+ row_id +"' ";

                                    java.sql.Connection con = (Connection) db_connection.configDB();
                                    java.sql.Statement stm = con.createStatement();
                                    stm.executeUpdate(sql);

                                    JOptionPane.showMessageDialog(null, "Successfully edited data.");

                                    button_add.doClick();
                                    load_table();

                            } catch (Exception e) {

                                System.out.println("Error occurred: " + e);

                            }

                        } else {

                            JOptionPane.showMessageDialog(null, "Items name have ever been stored before.", "Failed to attempt", JOptionPane.ERROR_MESSAGE);

                        }

                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Oops! there was an empty field.");
                    
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
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                kategori dialog = new kategori(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_edit;
    private javax.swing.JButton button_refresh;
    private javax.swing.JButton button_save;
    private javax.swing.JPanel card_form;
    private javax.swing.JPanel content;
    private javax.swing.JLabel form_title;
    private javax.swing.JPanel header;
    private javax.swing.JTextField id_input;
    private javax.swing.JLabel id_label;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jumlah_label;
    private javax.swing.JLabel kode_label;
    private javax.swing.JTextField nama_input;
    private javax.swing.JLabel nama_label;
    private javax.swing.JTextField no_rak_input;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
