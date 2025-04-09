package evaluation_system;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class StudentSignUpPage extends javax.swing.JFrame {
    
    //SQL Connectors
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    
    public StudentSignUpPage() throws SQLException{
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FemaleRadioBtn = new javax.swing.JRadioButton();
        MaleRadioBtn = new javax.swing.JRadioButton();
        FirstNameField = new javax.swing.JTextField();
        MiddleInitialField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AddressField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        MonthField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DayField = new javax.swing.JTextField();
        YearField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        AgeField = new javax.swing.JTextField();
        PhoneNoField = new javax.swing.JTextField();
        EmailField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        ShowPasswordCheckBox = new javax.swing.JCheckBox();
        SignUpBtn = new javax.swing.JButton();
        ReturnBtn = new javax.swing.JButton();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Sign-Up");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("First Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Middle Initial:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Last name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Gender:");

        buttonGroup1.add(FemaleRadioBtn);
        FemaleRadioBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FemaleRadioBtn.setForeground(new java.awt.Color(204, 204, 204));
        FemaleRadioBtn.setText("Female");
        FemaleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleRadioBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(MaleRadioBtn);
        MaleRadioBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MaleRadioBtn.setForeground(new java.awt.Color(204, 204, 204));
        MaleRadioBtn.setText("Male");

        FirstNameField.setBackground(new java.awt.Color(204, 204, 204));
        FirstNameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FirstNameField.setForeground(new java.awt.Color(102, 102, 102));
        FirstNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        FirstNameField.setCaretColor(new java.awt.Color(102, 102, 102));

        MiddleInitialField.setBackground(new java.awt.Color(204, 204, 204));
        MiddleInitialField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MiddleInitialField.setForeground(new java.awt.Color(102, 102, 102));
        MiddleInitialField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        MiddleInitialField.setCaretColor(new java.awt.Color(102, 102, 102));

        LastNameField.setBackground(new java.awt.Color(204, 204, 204));
        LastNameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LastNameField.setForeground(new java.awt.Color(102, 102, 102));
        LastNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        LastNameField.setCaretColor(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Address:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Birthday:");

        AddressField.setBackground(new java.awt.Color(204, 204, 204));
        AddressField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AddressField.setForeground(new java.awt.Color(102, 102, 102));
        AddressField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        AddressField.setCaretColor(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Month:");

        MonthField.setBackground(new java.awt.Color(204, 204, 204));
        MonthField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MonthField.setForeground(new java.awt.Color(102, 102, 102));
        MonthField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        MonthField.setCaretColor(new java.awt.Color(102, 102, 102));
        MonthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthFieldActionPerformed(evt);
            }
        });
        MonthField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MonthFieldKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Day:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Year:");

        DayField.setBackground(new java.awt.Color(204, 204, 204));
        DayField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DayField.setForeground(new java.awt.Color(102, 102, 102));
        DayField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        DayField.setCaretColor(new java.awt.Color(102, 102, 102));
        DayField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DayFieldKeyTyped(evt);
            }
        });

        YearField.setBackground(new java.awt.Color(204, 204, 204));
        YearField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        YearField.setForeground(new java.awt.Color(102, 102, 102));
        YearField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        YearField.setCaretColor(new java.awt.Color(102, 102, 102));
        YearField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                YearFieldKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("--------------------------------------------------------------------------------------------");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Phone Number:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Email:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Age:");

        AgeField.setBackground(new java.awt.Color(204, 204, 204));
        AgeField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AgeField.setForeground(new java.awt.Color(102, 102, 102));
        AgeField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        AgeField.setCaretColor(new java.awt.Color(102, 102, 102));
        AgeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AgeFieldKeyTyped(evt);
            }
        });

        PhoneNoField.setBackground(new java.awt.Color(204, 204, 204));
        PhoneNoField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PhoneNoField.setForeground(new java.awt.Color(102, 102, 102));
        PhoneNoField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        PhoneNoField.setCaretColor(new java.awt.Color(102, 102, 102));

        EmailField.setBackground(new java.awt.Color(204, 204, 204));
        EmailField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EmailField.setForeground(new java.awt.Color(102, 102, 102));
        EmailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        EmailField.setCaretColor(new java.awt.Color(102, 102, 102));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("--------------------------------------------------------------------------------------------");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Username:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Password:");

        UsernameField.setBackground(new java.awt.Color(204, 204, 204));
        UsernameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(102, 102, 102));
        UsernameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        UsernameField.setCaretColor(new java.awt.Color(102, 102, 102));

        PasswordField.setBackground(new java.awt.Color(204, 204, 204));
        PasswordField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(102, 102, 102));
        PasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        PasswordField.setCaretColor(new java.awt.Color(102, 102, 102));

        ShowPasswordCheckBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ShowPasswordCheckBox.setForeground(new java.awt.Color(204, 204, 204));
        ShowPasswordCheckBox.setText("Show Password");
        ShowPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordCheckBoxActionPerformed(evt);
            }
        });

        SignUpBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SignUpBtn.setForeground(new java.awt.Color(51, 51, 51));
        SignUpBtn.setText("Sign Up");
        SignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBtnActionPerformed(evt);
            }
        });

        ReturnBtn.setBackground(new java.awt.Color(51, 51, 51));
        ReturnBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ReturnBtn.setForeground(new java.awt.Color(51, 51, 51));
        ReturnBtn.setText("Return");
        ReturnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FemaleRadioBtn)
                                    .addComponent(MaleRadioBtn)
                                    .addComponent(FirstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(MiddleInitialField)
                                    .addComponent(LastNameField)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(AddressField)
                            .addComponent(DayField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(YearField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AgeField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PhoneNoField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MonthField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ReturnBtn)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(UsernameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(PasswordField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShowPasswordCheckBox)
                        .addGap(15, 15, 15))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SignUpBtn)
                .addGap(160, 160, 160))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(ReturnBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(MiddleInitialField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FemaleRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaleRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(MonthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(DayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(YearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(AgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(PhoneNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowPasswordCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SignUpBtn)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MonthFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MonthFieldKeyTyped
        char c = evt.getKeyChar();
        // Allow only digits
        if (!Character.isDigit(c)) {
            evt.consume(); // Block invalid input
        }
        
        //Blocks Numbers that are not within the months
        if(c > 12 && c < 1){
            evt.consume();
        }
    }//GEN-LAST:event_MonthFieldKeyTyped

    private void DayFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DayFieldKeyTyped
        char c = evt.getKeyChar();
        // Allow only digits
        if (!Character.isDigit(c)) {
            evt.consume(); // Block invalid input
        }
    }//GEN-LAST:event_DayFieldKeyTyped

    private void YearFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YearFieldKeyTyped
        char c = evt.getKeyChar();
        // Allow only digits
        if (!Character.isDigit(c)) {
            evt.consume(); // Block invalid input
        }
    }//GEN-LAST:event_YearFieldKeyTyped

    private void FemaleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleRadioBtnActionPerformed

    private void SignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBtnActionPerformed
        try{
            String firstname = FirstNameField.getText();
            String middleinitial = MiddleInitialField.getText().toUpperCase();
            String familyname = LastNameField.getText();
            String address = AddressField.getText();
            int age = Integer.parseInt(AgeField.getText());
            String phonenumber = PhoneNoField.getText();
            String email = EmailField.getText();
            String username = UsernameField.getText();
            String password = new String(PasswordField.getText());
            String userType = "Student";
            
            //Checks if gender is selected
            String gender = "";
            if(FemaleRadioBtn.isSelected()){
                gender = "Female";
            }else if(MaleRadioBtn.isSelected()){
                gender = "male";
            }else{
                JOptionPane.showMessageDialog(null, "No gender selected.");
                return;
            }
            
            //Assigns teh textFields into variables
            int month = Integer.parseInt(MonthField.getText());
            int day = Integer.parseInt(DayField.getText());
            int year = Integer.parseInt(YearField.getText());
            
            //Checks if the numbers inputted in the months, days and year are valid
            if(month < 1 && month > 12){
                JOptionPane.showMessageDialog(null, "Invalid month number.");
                return;
            }
            
            // Handle months with 31 days
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day >= 1 && day <= 31) {

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid day. Please enter a valid day for the month");
                    return;
                }
            }
            // Handle months with 30 days
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day >= 1 && day <= 30) {

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid day. Please enter a valid date for the month.");
                    return;
                }
            }
            // Handle February
            else if (month == 2) {
                if (day >= 1 && day <= 28) {

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid day. February has only 28 days.");
                    return;
                }
            }
            
            // Prepare the insert statement
            st = con.prepareStatement(
                    "INSERT INTO studentdatabase (firstname, middleinitial, familyname, gender, month, day, year, age, address, phonenumber, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, firstname);
            st.setString(2, middleinitial);
            st.setString(3, familyname);
            st.setString(4, gender);
            st.setInt(5, month);
            st.setInt(6, day);
            st.setInt(7, year);
            st.setInt(8, age);
            st.setString(9, address);
            st.setString(10, phonenumber);
            st.setString(11, email);
            
            if ((st.executeUpdate()) == 1) {
                JOptionPane.showMessageDialog(null, "Student registered successfully!");

                // Clears the text fields for re-entering new data
                FirstNameField.setText("");
                MiddleInitialField.setText("");
                LastNameField.setText("");
                MonthField.setText("");
                DayField.setText("");
                YearField.setText("");
                AgeField.setText("");
                AddressField.setText("");
                PhoneNoField.setText("");
                EmailField.setText("");
                buttonGroup1.clearSelection();
            } else { 
                JOptionPane.showMessageDialog(null, "Invalid inputs!");
                return;
            }
            
            st = con.prepareStatement("INSERT INTO userlogindatabase (username, password, userType) VALUES (?, ?, ?)");
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, userType);
            if((st.executeUpdate()) == 1){
                JOptionPane.showMessageDialog(null, "Student account created successfully!");
                
                //Clears the text fields for re-entering new data
                UsernameField.setText("");
                PasswordField.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Invalid inputs!");
                return;
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

    private void MonthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonthFieldActionPerformed

    private void AgeFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AgeFieldKeyTyped
        char c = evt.getKeyChar();
        // Allow only digits
        if (!Character.isDigit(c)) {
            evt.consume(); // Block invalid input
        }
    }//GEN-LAST:event_AgeFieldKeyTyped

    private void ReturnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnBtnActionPerformed
        try {
            LoginPage lp = new LoginPage();
            
            lp.show();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(StudentSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReturnBtnActionPerformed

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
            java.util.logging.Logger.getLogger(StudentSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StudentSignUpPage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JTextField AgeField;
    private javax.swing.JTextField DayField;
    private javax.swing.JTextField EmailField;
    private javax.swing.JRadioButton FemaleRadioBtn;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JRadioButton MaleRadioBtn;
    private javax.swing.JTextField MiddleInitialField;
    private javax.swing.JTextField MonthField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField PhoneNoField;
    private javax.swing.JButton ReturnBtn;
    private javax.swing.JCheckBox ShowPasswordCheckBox;
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JTextField YearField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
