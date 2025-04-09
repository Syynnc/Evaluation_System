package evaluation_system;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {
    
    //SQL Connectors
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    
    public LoginPage() throws SQLException {
        initComponents();
        Connect();
    }
    
    public void Connect() throws SQLException{
        try {
            //load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            //establish connection between app and database
            con = DriverManager.getConnection("jdbc:mysql://localhost/evaluation_system", "root", "");  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ShowPasswordCheckBox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        LoginBtn = new javax.swing.JButton();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 21, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Username:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 71, -1, -1));

        ShowPasswordCheckBox.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ShowPasswordCheckBox.setForeground(new java.awt.Color(204, 204, 204));
        ShowPasswordCheckBox.setText("Show Password");
        ShowPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ShowPasswordCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 128, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Sign-Up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 198, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        LoginBtn.setBackground(new java.awt.Color(51, 153, 0));
        LoginBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(204, 204, 204));
        LoginBtn.setText("Login");
        LoginBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        UsernameField.setBackground(new java.awt.Color(102, 102, 102));
        UsernameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(204, 204, 204));
        UsernameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        PasswordField.setBackground(new java.awt.Color(102, 102, 102));
        PasswordField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(204, 204, 204));
        PasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addComponent(LoginBtn)
                .addGap(60, 60, 60))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        try {
            // Assign text field values to variables
            String username = UsernameField.getText();
            String password = PasswordField.getText();

            // Prepare SQL statement to verify login credentials
            st = con.prepareStatement("SELECT userType FROM userlogindatabase WHERE username = ? AND password = ?");
            st.setString(1, username);
            st.setString(2, password);

            rs = st.executeQuery();

            if (rs.next()) {
                String userType = rs.getString("userType"); // Get user type

                if ("Instructor".equalsIgnoreCase(userType)) {
                    InstructorPage ip = new InstructorPage();
                    ip.show();
                } else if ("Student".equalsIgnoreCase(userType)) {
                    StudentPage sp = new StudentPage();
                    sp.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Unknown user type!", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    return; // Stop execution if userType is invalid
                }

                dispose(); // Close login page after successful login
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void ShowPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordCheckBoxActionPerformed
        if (ShowPasswordCheckBox.isSelected()){
            //Shows the inputted password
            PasswordField.setEchoChar((char)0);
        }
        else{
            //Displays the '*'
            PasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_ShowPasswordCheckBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserType up = new UserType();
        
        up.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginPage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JCheckBox ShowPasswordCheckBox;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
