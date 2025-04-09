package evaluation_system;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InstructorSignUpPage extends javax.swing.JFrame {
    
    //SQL Connectors
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    
    public InstructorSignUpPage() throws SQLException {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ReturnBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        FamilyNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        SignUpBtn = new javax.swing.JButton();
        ShowPasswordCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Sign-Up");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        ReturnBtn.setBackground(new java.awt.Color(51, 51, 51));
        ReturnBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ReturnBtn.setForeground(new java.awt.Color(204, 204, 204));
        ReturnBtn.setText("Return");
        ReturnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ReturnBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Firstname:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Family Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        FirstNameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FirstNameField.setForeground(new java.awt.Color(204, 204, 204));
        FirstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(FirstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 110, -1));

        FamilyNameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FamilyNameField.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(FamilyNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Username:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Password:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        UsernameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(204, 204, 204));
        UsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(UsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 110, -1));

        PasswordField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 110, -1));

        SignUpBtn.setBackground(new java.awt.Color(102, 102, 102));
        SignUpBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SignUpBtn.setForeground(new java.awt.Color(204, 204, 204));
        SignUpBtn.setText("Sign Up");
        SignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBtnActionPerformed(evt);
            }
        });
        jPanel1.add(SignUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        ShowPasswordCheckBox.setText("Show Password");
        ShowPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordCheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(ShowPasswordCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FirstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameFieldActionPerformed

    private void UsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameFieldActionPerformed

    private void ReturnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnBtnActionPerformed
        try{
            LoginPage lp = new LoginPage();
            
            lp.show();
            dispose();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_ReturnBtnActionPerformed

    private void SignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBtnActionPerformed
        try{
            String firstname = FirstNameField.getText();
            String familyname = FamilyNameField.getText();
            String username = UsernameField.getText();
            String password = new String(PasswordField.getText());
            String userType = "Instructor";
            
            st = con.prepareStatement("INSERT * INTO userlogindatabase (username, password, userType) VALUES (?, ?, ?)");
            
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, userType);
            
            if((st.executeUpdate()) == 1){
                JOptionPane.showMessageDialog(null, "Account created successfully!");
                
                //Clears Textfields  UN1AI79D
                UsernameField.setText("");
                PasswordField.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "An error has occured!");
            }
            
            st = con.prepareStatement("INSERT * INTO instructorlogindatabase (firstname, familyname) VALUES (?, ?)");
            
            st.setString(1, firstname);
            st.setString(2, familyname);
            
            if((st.executeUpdate()) == 1){
                
                //Clears Textfields
                FirstNameField.setText("");
                FamilyNameField.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "An error has occured!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_SignUpBtnActionPerformed

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
            java.util.logging.Logger.getLogger(InstructorSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InstructorSignUpPage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FamilyNameField;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton ReturnBtn;
    private javax.swing.JCheckBox ShowPasswordCheckBox;
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
