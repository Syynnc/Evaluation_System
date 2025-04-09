package evaluation_system;

import java.sql.*;
import java.util.*;
import java.util.Vector;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentPage extends javax.swing.JFrame {
    
    //SQL Connectors
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    ResultSetMetaData rmd;
    String StudentID;
    
    public StudentPage() throws SQLException {
        initComponents();
        Connect();
        setAccountDetails();
        DisplaySubjects();
        DisplayStudyLoad();
    }
    
    public void DisplayStudyLoad(){
        if(CourseComboBox.getSelectedItem().equals("BSIT") && YearLevelComboBox.getSelectedItem().equals("1") && SemesterComboBox.getSelectedItem().equals("1st") &&YearProspectusComboBox.getSelectedItem().equals("2023-2024")){
            try{
            st = con.prepareStatement("SELECT * FROM studyloaddatabase");
            rs = st.executeQuery();
            rmd = rs.getMetaData();
            
            //retrieves number of columns
            int j = rmd.getColumnCount();
            
            DefaultTableModel tblm = (DefaultTableModel)StudyLoadTable.getModel();
            tblm.setRowCount(0);
            
            //checks if the databse has an element or not
            while(rs.next()){
                
                //vector is a growable array of objects
                Vector v = new Vector();
                
                //data will be retrieved from database
                for(int i = 1; i <= j; i++){

                    v.add(rs.getString("EDPCode"));
                    v.add(rs.getString("CourseCode"));
                    v.add(rs.getString("DescriptiveTitle"));
                    v.add(rs.getString("SubjectType"));
                    v.add(rs.getString("Units"));
                    v.add(rs.getString("PreRequisite"));
                    v.add(rs.getDouble("Grade"));
                    v.add(rs.getString("Remarks"));
                }
                
                //adds string arrayy into table
                tblm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
        }else{
            JOptionPane.showMessageDialog(null, "No subjects found for this year and semester");
            DefaultTableModel tblm = (DefaultTableModel)ProspectusTable.getModel();
            tblm.setRowCount(0);
        }
    }
    
    public void DisplaySubjects(){
        if (CourseComboBox.getSelectedItem().equals("BSIT") 
                && YearLevelComboBox.getSelectedItem().equals("1") 
                && SemesterComboBox.getSelectedItem().equals("1st") 
                && YearProspectusComboBox.getSelectedItem().equals("2023-2024")) {
            try {
                // Query to select subjects based on course, year level, semester, and prospectus year
                st = con.prepareStatement("SELECT * FROM pospectusdatabase WHERE yearLevel = ? AND semester = ?");
                st.setString(1, "1");
                st.setString(2, "1st");

                rs = st.executeQuery();
                rmd = rs.getMetaData();
                int j = rmd.getColumnCount();

                DefaultTableModel tblm = (DefaultTableModel) ProspectusTable.getModel();
                tblm.setRowCount(0); // Clear table before adding new data

                // Check if there are subjects to display
                boolean hasData = false;

                while (rs.next()) {
                    Vector<String> v = new Vector<>();

                    v.add(rs.getString("EDPCode"));
                    v.add(rs.getString("CourseCode"));
                    v.add(rs.getString("DescriptiveTitle"));
                    v.add(rs.getString("SubjectType"));
                    v.add(rs.getString("Units"));
                    v.add(rs.getString("PreRequisite"));

                    tblm.addRow(v);
                    hasData = true;
                }

                // Show message if no subjects found
                if (!hasData) {
                    JOptionPane.showMessageDialog(null, "No subjects found for this year and semester", "No Data", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error retrieving subjects!", "Database Error", JOptionPane.ERROR_MESSAGE);
            }    
        } else if (CourseComboBox.getSelectedItem().equals("BSIT") 
                && YearLevelComboBox.getSelectedItem().equals("1") 
                && SemesterComboBox.getSelectedItem().equals("2nd") 
                && YearProspectusComboBox.getSelectedItem().equals("2023-2024")) {

            try {
                st = con.prepareStatement("SELECT * FROM pospectusdatabase WHERE yearLevel = ? AND semester = ?");
                st.setString(1, "1");
                st.setString(2, "2nd");

                rs = st.executeQuery();
                rmd = rs.getMetaData();
                int j = rmd.getColumnCount();

                DefaultTableModel tblm = (DefaultTableModel) ProspectusTable.getModel();
                tblm.setRowCount(0); // Clear table before adding new data

                boolean hasData = false;

                while (rs.next()) {
                    Vector<String> v = new Vector<>();

                    v.add(rs.getString("EDPCode"));
                    v.add(rs.getString("CourseCode"));
                    v.add(rs.getString("DescriptiveTitle"));
                    v.add(rs.getString("SubjectType"));
                    v.add(rs.getString("Units"));
                    v.add(rs.getString("PreRequisite"));

                    tblm.addRow(v);
                    hasData = true;
                }

                if (!hasData) {
                    JOptionPane.showMessageDialog(null, "No subjects found for this year and semester", "No Data", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error retrieving subjects!", "Database Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No subjects found for this year and semester", "No Data", JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel tblm = (DefaultTableModel) StudyLoadTable.getModel();
            tblm.setRowCount(0);
        }
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
    
    public void setAccountDetails() {
        try {
            int id = 1;
            // Prepare SQL statement to fetch student details
            st = con.prepareStatement("SELECT id, firstname, middleinitial, familyname, email, age, phonenumber, gender, month, day, year FROM studentdatabase WHERE id = ?");

            // Assuming `loggedInFirstName` stores the first name of the logged-in student
            st.setInt(1, id);  // Set the parameter for the query

            // Execute the query
            ResultSet rs = st.executeQuery();

            // Check if data is found
            if (rs.next()) {
                
                // Retrieve data from result set and set it to labels
                IDLabel.setText("ID: " + rs.getString("id"));
                StudentID = rs.getString("id");
                FirstNameLabel.setText(rs.getString("firstname") + " "  + rs.getString("middleinitial") + ". " + rs.getString("familyname"));
                EmailLabel.setText(rs.getString("email"));
                AgeLabel.setText(rs.getString("age"));
                PhoneLabel.setText(rs.getString("phonenumber"));
                GenderLabel.setText(rs.getString("gender"));
                BirthdayLabel.setText(rs.getString("month") + "/" + rs.getString("day") + "/" + rs.getString("year"));
            } else {
                // If no data found, show an error message
                JOptionPane.showMessageDialog(null, "No account details found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean isDuplicate(String EDPCode) {
        try {
            st = con.prepareStatement("SELECT * FROM studyloaddatabase WHERE id = ? AND EDPCode = ?");

            st.setString(1, StudentID);
            st.setString(2, EDPCode);

            ResultSet rs = st.executeQuery();
            boolean exists = rs.next(); // If there's a result, subject exists

            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        FirstNameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        AgeLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PhoneLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        GenderLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BirthdayLabel = new javax.swing.JLabel();
        ExitBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        CourseComboBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        YearLevelComboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        YearProspectusComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProspectusTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        SemesterComboBox = new javax.swing.JComboBox<>();
        AddStudyLoadBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudyLoadTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        RecommendSubjectBtn = new javax.swing.JButton();
        ChangeProspectusBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FirstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FirstNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        FirstNameLabel.setText("jLabel2");
        jPanel1.add(FirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Contact Information");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Personal Information");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        EmailLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(204, 204, 204));
        EmailLabel.setText("jLabel4");
        jPanel1.add(EmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        AgeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AgeLabel.setForeground(new java.awt.Color(204, 204, 204));
        AgeLabel.setText("jLabel4");
        jPanel1.add(AgeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Age:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(204, 204, 204));
        IDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IDLabel.setText("jLabel5");
        jPanel1.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Phone No.:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Name:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        PhoneLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PhoneLabel.setForeground(new java.awt.Color(204, 204, 204));
        PhoneLabel.setText("jLabel8");
        jPanel1.add(PhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Gender:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        GenderLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        GenderLabel.setForeground(new java.awt.Color(204, 204, 204));
        GenderLabel.setText("jLabel9");
        jPanel1.add(GenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Birthday:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        BirthdayLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BirthdayLabel.setForeground(new java.awt.Color(204, 204, 204));
        BirthdayLabel.setText("jLabel10");
        jPanel1.add(BirthdayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        ExitBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ExitBtn.setForeground(new java.awt.Color(51, 51, 51));
        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 60, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empty_profile.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 550));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Course:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        CourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT", "BSIS", "BSIT-SE", "Animation" }));
        jPanel2.add(CourseComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 60, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Year Level:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        YearLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        jPanel2.add(YearLevelComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 50, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Prospectus Year:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        YearProspectusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023-2024" }));
        YearProspectusComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YearProspectusComboBoxMouseClicked(evt);
            }
        });
        jPanel2.add(YearProspectusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        ProspectusTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ProspectusTable.setForeground(new java.awt.Color(51, 51, 51));
        ProspectusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EDP Code", "Course Code", "Descriptive Title", "Units", "Subject Type", "Pre-requisite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ProspectusTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 920, 140));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Semester:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        SemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        jPanel2.add(SemesterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 60, -1));

        AddStudyLoadBtn.setBackground(new java.awt.Color(102, 102, 102));
        AddStudyLoadBtn.setForeground(new java.awt.Color(51, 51, 51));
        AddStudyLoadBtn.setText("Add To Study Load");
        AddStudyLoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudyLoadBtnActionPerformed(evt);
            }
        });
        jPanel2.add(AddStudyLoadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        StudyLoadTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StudyLoadTable.setForeground(new java.awt.Color(51, 51, 51));
        StudyLoadTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "EDP Code", "Course Code", "Descriptive Title", "Subject Type", "Units", "Pre-requisite", "Grade", "Remarks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(StudyLoadTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 920, 210));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Study Load");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        RecommendSubjectBtn.setBackground(new java.awt.Color(102, 102, 102));
        RecommendSubjectBtn.setForeground(new java.awt.Color(51, 51, 51));
        RecommendSubjectBtn.setText("Check Recommended Subjects");
        RecommendSubjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommendSubjectBtnActionPerformed(evt);
            }
        });
        jPanel2.add(RecommendSubjectBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, -1, -1));

        ChangeProspectusBtn.setBackground(new java.awt.Color(102, 102, 102));
        ChangeProspectusBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ChangeProspectusBtn.setForeground(new java.awt.Color(51, 51, 51));
        ChangeProspectusBtn.setText("Change Prospectus");
        ChangeProspectusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeProspectusBtnActionPerformed(evt);
            }
        });
        jPanel2.add(ChangeProspectusBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 970, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void YearProspectusComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YearProspectusComboBoxMouseClicked
        
    }//GEN-LAST:event_YearProspectusComboBoxMouseClicked

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        try{
            LoginPage lp = new LoginPage();
            
            lp.show();
            dispose();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void AddStudyLoadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudyLoadBtnActionPerformed
        int selectedRow = ProspectusTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a subject first!", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String EDPCode = ProspectusTable.getValueAt(selectedRow, 0).toString();
        String CourseCode = ProspectusTable.getValueAt(selectedRow, 1).toString();
        String DescriptiveTitle = ProspectusTable.getValueAt(selectedRow, 2).toString();
        String SubjectType = ProspectusTable.getValueAt(selectedRow, 3).toString();
        String Units = ProspectusTable.getValueAt(selectedRow, 4).toString();
        String PreRequisite = ProspectusTable.getValueAt(selectedRow, 5).toString();
        String id = JOptionPane.showInputDialog("Input your ID");
        double Grade = 0.0;
        String Remarks = "-";
        
        // Check if the student has already added this subject
        if (isDuplicate(EDPCode)) {
            JOptionPane.showMessageDialog(this, "Subject is already in Study Load!", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Insert into database
        try {
            st = con.prepareStatement("INSERT INTO studyloaddatabase (id, EDPCode, CourseCode, DescriptiveTitle, SubjectType, Units, PreRequisite, Grade, Remarks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            st.setString(1, id);
            st.setString(2, EDPCode);
            st.setString(3, CourseCode);
            st.setString(4, DescriptiveTitle);
            st.setString(5, SubjectType);
            st.setString(6, Units);
            st.setString(7, PreRequisite);
            st.setDouble(8, Grade);
            st.setString(9, Remarks);
            
            if((st.executeUpdate()) == 1){
                JOptionPane.showMessageDialog(this, "Subject added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                //Refreshes the study load
                DisplayStudyLoad();
            }else{
                JOptionPane.showMessageDialog(this, "An error has occured!", "Success", JOptionPane.ERROR_MESSAGE);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding subject!", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AddStudyLoadBtnActionPerformed

    private void RecommendSubjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommendSubjectBtnActionPerformed
        try {
            // Get the student's ID from the text field
            String studentID = JOptionPane.showInputDialog("Input your student ID: ");

            // StringBuilder to store failed and recommended subjects
            StringBuilder failedSubjects = new StringBuilder();
            StringBuilder recommendedSubjects = new StringBuilder();

            //1. Fetch subjects the student needs to retake (Grade > 3.0)
            st = con.prepareStatement("SELECT CourseCode, DescriptiveTitle FROM studyloaddatabase WHERE id = ? AND Grade > 3.0");
            st.setString(1, studentID);
            rs = st.executeQuery();

            while (rs.next()) {
                failedSubjects.append("➤ ").append(rs.getString("CourseCode"))
                        .append(" - ").append(rs.getString("DescriptiveTitle")).append("\n");
            }

            //2. Fetch all passed subjects (Grade ≥ 3.0)
            st = con.prepareStatement("SELECT CourseCode FROM studyloaddatabase WHERE id = ? AND Grade <= 3.0");
            st.setString(1, studentID);
            rs = st.executeQuery();

            // Store passed CourseCodes in a list
            List<String> passedSubjects = new ArrayList<>();
            while (rs.next()) {
                passedSubjects.add(rs.getString("CourseCode"));
            }

            //3. Fetch next recommended subjects based on passed subjects
            if (!passedSubjects.isEmpty()) {
                StringBuilder query = new StringBuilder(
                    "SELECT CourseCode, DescriptiveTitle FROM pospectusdatabase WHERE PreRequisite IN ("
                );

                // Add placeholders for SQL query
                for (int i = 0; i < passedSubjects.size(); i++) {
                    query.append("?");
                    if (i < passedSubjects.size() - 1) {
                        query.append(", ");
                    }
                }
                query.append(")");

                // Prepare statement with dynamic number of passed subjects
                st = con.prepareStatement(query.toString());
                for (int i = 0; i < passedSubjects.size(); i++) {
                    st.setString(i + 1, passedSubjects.get(i));
                }

                rs = st.executeQuery();
                while (rs.next()) {
                    recommendedSubjects.append("➤ ").append(rs.getString("CourseCode"))
                            .append(" - ").append(rs.getString("DescriptiveTitle")).append("\n");
                }
            }

            //4. Create message to display in JOptionPane
            String message = "📌 Subjects to Retake (Failed):\n";
            message += failedSubjects.length() > 0 ? failedSubjects.toString() : "✅ No subjects to retake!\n";

            message += "\n📌 Recommended Subjects to Take Next:\n";
            message += recommendedSubjects.length() > 0 ? recommendedSubjects.toString() : "❌ No available subjects found!\n";

            //5. Display the result in a single JOptionPane
            JOptionPane.showMessageDialog(this, message, "Recommended Subjects", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving recommendations!", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RecommendSubjectBtnActionPerformed

    private void ChangeProspectusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeProspectusBtnActionPerformed
        DisplaySubjects();
    }//GEN-LAST:event_ChangeProspectusBtnActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLaf Dark".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StudentPage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddStudyLoadBtn;
    private javax.swing.JLabel AgeLabel;
    private javax.swing.JLabel BirthdayLabel;
    private javax.swing.JButton ChangeProspectusBtn;
    private javax.swing.JComboBox<String> CourseComboBox;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JTable ProspectusTable;
    private javax.swing.JButton RecommendSubjectBtn;
    private javax.swing.JComboBox<String> SemesterComboBox;
    private javax.swing.JTable StudyLoadTable;
    private javax.swing.JComboBox<String> YearLevelComboBox;
    private javax.swing.JComboBox<String> YearProspectusComboBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
