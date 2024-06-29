package inventaris_gudang;

import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class login extends javax.swing.JFrame {

    
    public login() {
        
        initComponents();
        clear();
        setIconImage();
        
    }

    private void clear() {

        username_input.setText(null);
        password_input.setText(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("checked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        login_button = new javax.swing.JButton();
        username_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        username_input = new javax.swing.JTextField();
        password_input = new javax.swing.JPasswordField();
        error_text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventaris Gudang - PT. Slebewlity");
        setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        setName("login_frame"); // NOI18N
        setResizable(false);

        container.setBackground(new java.awt.Color(60, 60, 60));

        title.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Login");

        separator.setBackground(new java.awt.Color(60, 60, 60));
        separator.setForeground(new java.awt.Color(60, 60, 60));

        login_button.setBackground(new java.awt.Color(60, 60, 60));
        login_button.setForeground(new java.awt.Color(255, 255, 255));
        login_button.setText("Login");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        username_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        username_label.setForeground(new java.awt.Color(255, 255, 255));
        username_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username_label.setText("username");

        password_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        password_label.setForeground(new java.awt.Color(255, 255, 255));
        password_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        password_label.setText("password");

        username_input.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                username_inputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                username_inputFocusLost(evt);
            }
        });

        password_input.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_inputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                password_inputFocusLost(evt);
            }
        });

        error_text.setBackground(new java.awt.Color(255, 0, 0));
        error_text.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password_label, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(login_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(username_input)
                        .addComponent(password_input, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                    .addComponent(error_text))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_label)
                    .addComponent(username_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_label)
                    .addComponent(password_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_button)
                    .addComponent(error_text))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            
            String get_username = username_input.getText();
            char[] passwordChars = password_input.getPassword();
            String get_password = new String(passwordChars);
            
            String sql = "SELECT * FROM user WHERE username='"+ get_username +"' AND password='"+ get_password +"'";
            
            java.sql.Connection con = (Connection) db_connection.configDB();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            // Validation
            
                if (res.next()) {

                    session.set_username(res.getString("username"));
                    session.set_id(res.getInt("id_user"));
                    session.set_level(res.getInt("_userLevel"));
                    
                    new dashboard().setVisible(true);
                    this.dispose();
                    
                } else if (get_username.equals("username") || get_password.equals("password")) {
                
                    error_text.setText("* Incorrect username or password, please try again!");
                    clear();
                        
                } else if (get_username.equals("") || get_password.equals("")) {
                    
                    error_text.setText("* You need to fill out username and password!");
                    clear();
                
                } else {
                    
                    error_text.setText("* Incorrect username or password, please try again!");
                    clear();
                    
                }
        
        }
        
        catch (Exception e) {
        
            JOptionPane.showMessageDialog(this, e.getMessage());
            
        }

    }
    
    private void username_inputFocusLost(java.awt.event.FocusEvent evt) {
        
        String get_username = username_input.getText();

        if (get_username.equals("") || get_username.equals("username")) {

            username_input.setText("username");

        }

    }

    private void password_inputFocusLost(java.awt.event.FocusEvent evt) {
        
        char[] passwordChars = password_input.getPassword();
        String get_password = new String(passwordChars);

        if (get_password.equals("") || get_password.equals("password")) {

            password_input.setText("password");

        }

    }

    private void username_inputFocusGained(java.awt.event.FocusEvent evt) {
    
        String get_username = username_input.getText();

        if (get_username.equals("username")) {

            username_input.setText(null);

        }

    }

    private void password_inputFocusGained(java.awt.event.FocusEvent evt) {

        char[] passwordChars = password_input.getPassword();
        String get_password = new String(passwordChars);

        if (get_password.equals("password")) {

            password_input.setText(null);

        }
        
    }

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

            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new login().setVisible(true);

            }

        });

    }
    
    private void setIconImage() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.png")));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel error_text;
    private javax.swing.JButton login_button;
    private javax.swing.JPasswordField password_input;
    private javax.swing.JLabel password_label;
    private javax.swing.JSeparator separator;
    private javax.swing.JLabel title;
    private javax.swing.JTextField username_input;
    private javax.swing.JLabel username_label;
    // End of variables declaration//GEN-END:variables

}
