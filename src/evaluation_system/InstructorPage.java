package evaluation_system;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InstructorPage extends javax.swing.JFrame {
    
    //SQL Connectors
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    ResultSetMetaData rmd;
    
    public InstructorPage() throws SQLException {
        initComponents();
        Connect();
        DisplaySubjects();
        DisplayStudyLoad();
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
    
    public void DisplayStudyLoad(){
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
                    
                    v.add(rs.getString("id"));
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
    }
    
    public void DisplaySubjects(){
        try{
            st = con.prepareStatement("SELECT * FROM pospectusdatabase");
            rs = st.executeQuery();
            rmd = rs.getMetaData();
            
            //retrieves number of columns
            int j = rmd.getColumnCount();
            
            DefaultTableModel tblm = (DefaultTableModel)ProspectusTable.getModel();
            tblm.setRowCount(0);
            
            //checks if the databse has an element or not
            while(rs.next()){
                
                //vector is a growable array of objects
                Vector v = new Vector();
                
                //data will be retrieved from database
                for(int i = 1; i <= j; i++){
                    v.add(rs.getString("yearLevel"));
                    v.add(rs.getString("semester"));
                    v.add(rs.getString("EDPCode"));
                    v.add(rs.getString("CourseCode"));
                    v.add(rs.getString("DescriptiveTitle"));
                    v.add(rs.getString("SubjectType"));
                    v.add(rs.getString("Units"));
                    v.add(rs.getString("PreRequisite"));
                }
                
                //adds string arrayy into table
                tblm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProspectusTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudyLoadTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AddSubjectBtn = new javax.swing.JButton();
        PreRequisiteField = new javax.swing.JTextField();
        UnitsField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Lecture = new javax.swing.JRadioButton();
        Laboratory = new javax.swing.JRadioButton();
        DescriptiveTitleField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CourseCodeField = new javax.swing.JTextField();
        EDPCodeField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FirstSemRadioBtn = new javax.swing.JRadioButton();
        SecondSemRadioBtn = new javax.swing.JRadioButton();
        ThirdYear = new javax.swing.JRadioButton();
        FourthYear = new javax.swing.JRadioButton();
        SecondYear = new javax.swing.JRadioButton();
        FirstYear = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        IDField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SEDPCodeField = new javax.swing.JTextField();
        GradeField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        SubmitGradesBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProspectusTable.setForeground(new java.awt.Color(51, 51, 51));
        ProspectusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Year Level", "Semester", "EDP Code", "Course Code", "Descriptive Title", "Subject Type", "Units", "Pre-requisite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(ProspectusTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 910, 200));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        DeleteBtn.setForeground(new java.awt.Color(51, 51, 51));
        DeleteBtn.setText(" Delete Subject");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Subjects");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        StudyLoadTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StudyLoadTable.setForeground(new java.awt.Color(51, 51, 51));
        StudyLoadTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "EDP Code", "Course Code", "Descriptive Title", "Subject Type", "Units", "Pre-requisite", "Grades", "Remarks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(StudyLoadTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 910, 200));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Students");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddSubjectBtn.setForeground(new java.awt.Color(51, 51, 51));
        AddSubjectBtn.setText("Add Subject");
        AddSubjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSubjectBtnActionPerformed(evt);
            }
        });
        jPanel2.add(AddSubjectBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));
        jPanel2.add(PreRequisiteField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 125, -1));
        jPanel2.add(UnitsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 125, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Units:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Pre-requisite:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Subject Type:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        buttonGroup3.add(Lecture);
        Lecture.setForeground(new java.awt.Color(204, 204, 204));
        Lecture.setText("LEC");
        jPanel2.add(Lecture, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        buttonGroup3.add(Laboratory);
        Laboratory.setForeground(new java.awt.Color(204, 204, 204));
        Laboratory.setText("LAB");
        jPanel2.add(Laboratory, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));
        jPanel2.add(DescriptiveTitleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 125, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Descriptive Title:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Course Code:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel2.add(CourseCodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 125, -1));

        EDPCodeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EDPCodeFieldKeyTyped(evt);
            }
        });
        jPanel2.add(EDPCodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 125, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("EDP Code:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Semester:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        buttonGroup2.add(FirstSemRadioBtn);
        FirstSemRadioBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FirstSemRadioBtn.setForeground(new java.awt.Color(204, 204, 204));
        FirstSemRadioBtn.setText("1st");
        jPanel2.add(FirstSemRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        buttonGroup2.add(SecondSemRadioBtn);
        SecondSemRadioBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SecondSemRadioBtn.setForeground(new java.awt.Color(204, 204, 204));
        SecondSemRadioBtn.setText("2nd");
        jPanel2.add(SecondSemRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        buttonGroup1.add(ThirdYear);
        ThirdYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ThirdYear.setForeground(new java.awt.Color(204, 204, 204));
        ThirdYear.setText("3");
        jPanel2.add(ThirdYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        buttonGroup1.add(FourthYear);
        FourthYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FourthYear.setForeground(new java.awt.Color(204, 204, 204));
        FourthYear.setText("4");
        jPanel2.add(FourthYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        buttonGroup1.add(SecondYear);
        SecondYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SecondYear.setForeground(new java.awt.Color(204, 204, 204));
        SecondYear.setText("2");
        jPanel2.add(SecondYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        buttonGroup1.add(FirstYear);
        FirstYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FirstYear.setForeground(new java.awt.Color(204, 204, 204));
        FirstYear.setText("1");
        jPanel2.add(FirstYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Year Level:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 260, 310));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IDField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IDField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDFieldKeyTyped(evt);
            }
        });
        jPanel3.add(IDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 120, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Student ID:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("EDP Code:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        SEDPCodeField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SEDPCodeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SEDPCodeFieldKeyTyped(evt);
            }
        });
        jPanel3.add(SEDPCodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 120, -1));

        GradeField.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(GradeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 120, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Grades:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        SubmitGradesBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SubmitGradesBtn.setForeground(new java.awt.Color(51, 51, 51));
        SubmitGradesBtn.setText("Submit Grades");
        SubmitGradesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitGradesBtnActionPerformed(evt);
            }
        });
        jPanel3.add(SubmitGradesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 110, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 260, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddSubjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSubjectBtnActionPerformed
        try{
            String yearLevel = "";
            String semester = "";
            String EDPCode = EDPCodeField.getText();
            String CourseCode = CourseCodeField.getText();
            String DescriptiveTitle = DescriptiveTitleField.getText();
            String SubjectType = "";
            String Units = UnitsField.getText();
            String PreRequisite = PreRequisiteField.getText();
            
            //Checks the year-level selected
            if(FirstYear.isSelected()){
                yearLevel = "1";
            }else if(SecondYear.isSelected()){
                yearLevel = "2";
            }else if(ThirdYear.isSelected()){
                yearLevel = "3";
            }else if(FourthYear.isSelected()){
                yearLevel = "4";
            }else{
                JOptionPane.showMessageDialog(null, "No Year Level Selected");
                return;
            }
            
            //Checks the semester selected
            if(FirstSemRadioBtn.isSelected()){
                semester = "1st";
            }else if(SecondSemRadioBtn.isSelected()){
                semester = "2nd";
            }else{
                JOptionPane.showMessageDialog(null, "No Semester Selected");
                return;
            }
            
            //Checks the Sebject Type selected
            if(Lecture.isSelected()){
                SubjectType = "LEC";
            }else if(Laboratory.isSelected()){
                SubjectType = "LAB";
            }else{
                JOptionPane.showMessageDialog(null, "No Subject Type Selected");
                return;
            }
            
            // Check if the student is already registered
            String checkQuery = "SELECT COUNT(*) FROM pospectusdatabase WHERE EDPCode = ?";
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setString(1, EDPCode);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                // Student is already registered
                JOptionPane.showMessageDialog(null, "This subject is already added.");
                return; // Skip the insertion
            }
            
            st = con.prepareStatement(
                    "INSERT INTO pospectusdatabase (yearLevel, semester, EDPCode, CourseCode, DescriptiveTitle, SubjectType, Units, PreRequisite) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, yearLevel);
            st.setString(2, semester);
            st.setString(3, EDPCode);
            st.setString(4, CourseCode);
            st.setString(5, DescriptiveTitle);
            st.setString(6, SubjectType);
            st.setString(7, Units);
            st.setString(8, PreRequisite);

            if (st.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Subject Added successfully!");
                DisplaySubjects();

                // Clears the text fields for re-entering new data
                EDPCodeField.setText("");
                CourseCodeField.setText("");
                DescriptiveTitleField.setText("");
                UnitsField.setText("");
                PreRequisiteField.setText("");
                buttonGroup1.clearSelection();
                buttonGroup2.clearSelection();
                buttonGroup3.clearSelection();
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid inputs!");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_AddSubjectBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        try {
            // Prompt the user to input a student ID
            String EDPCode = JOptionPane.showInputDialog("Input EDP Code: ");

            // Prepare an SQL DELETE statement
            st = con.prepareStatement("DELETE FROM pospectusdatabase WHERE EDPCode = ?");

            // Set the ID parameter
            st.setString(1, EDPCode);

            // Execute the DELETE statement and check if any row was affected
            if ((st.executeUpdate()) == 1) {
                // If a record was deleted
                JOptionPane.showMessageDialog(null, "Deleted successfully!");
                DisplaySubjects();
                
            } else {
                // If no record was deleted
                JOptionPane.showMessageDialog(null, "Subject not found");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Invalid input");
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            LoginPage lp = new LoginPage();
            
            lp.show();
            dispose();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SubmitGradesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitGradesBtnActionPerformed
       try{
           double Grade = Double.parseDouble(GradeField.getText());
           String EDPCode = SEDPCodeField.getText();
           String id = IDField.getText();
           String Remarks = "";
           
        if (Grade >= 1 && Grade <= 3) {
            Remarks = "PASSED";
        } else if (Grade > 3) {
            Remarks = "FAILED";
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Grade");
            return;
        }
        
        if (EDPCode.isEmpty()) {
            JOptionPane.showMessageDialog(null, "EDP Code cannot be empty!");
            Exception e;
            return;
        }
        
           st = con.prepareStatement("UPDATE studyloaddatabase SET Grade = ?, Remarks = ? WHERE id = ? AND EDPCode = ?");
           
           st.setDouble(1, Grade);
           st.setString(2, Remarks);
           st.setString(3, id);
           st.setString(4, EDPCode);
           
           if((st.executeUpdate()) == 1){
                JOptionPane.showMessageDialog(this, "Grades submitted succesfully!");
                DisplayStudyLoad();
                
                //clears the textbox for re-enter
                IDField.setText("");
                GradeField.setText("");            
            }else{
                JOptionPane.showMessageDialog(this, "An error has occured");
            }
       }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_SubmitGradesBtnActionPerformed

    private void EDPCodeFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EDPCodeFieldKeyTyped
        char c = evt.getKeyChar();
        // Allow only digits
        if (!Character.isDigit(c)) {
            evt.consume(); // Block invalid input
        }
    }//GEN-LAST:event_EDPCodeFieldKeyTyped

    private void IDFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDFieldKeyTyped
        char c = evt.getKeyChar();
        // Allow only digits
        if (!Character.isDigit(c)) {
            evt.consume(); // Block invalid input
        }
    }//GEN-LAST:event_IDFieldKeyTyped

    private void SEDPCodeFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SEDPCodeFieldKeyTyped
        char c = evt.getKeyChar();
        // Allow only digits
        if (!Character.isDigit(c)) {
            evt.consume(); // Block invalid input
        }
    }//GEN-LAST:event_SEDPCodeFieldKeyTyped

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
            java.util.logging.Logger.getLogger(InstructorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InstructorPage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSubjectBtn;
    private javax.swing.JTextField CourseCodeField;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTextField DescriptiveTitleField;
    private javax.swing.JTextField EDPCodeField;
    private javax.swing.JRadioButton FirstSemRadioBtn;
    private javax.swing.JRadioButton FirstYear;
    private javax.swing.JRadioButton FourthYear;
    private javax.swing.JTextField GradeField;
    private javax.swing.JTextField IDField;
    private javax.swing.JRadioButton Laboratory;
    private javax.swing.JRadioButton Lecture;
    private javax.swing.JTextField PreRequisiteField;
    private javax.swing.JTable ProspectusTable;
    private javax.swing.JTextField SEDPCodeField;
    private javax.swing.JRadioButton SecondSemRadioBtn;
    private javax.swing.JRadioButton SecondYear;
    private javax.swing.JTable StudyLoadTable;
    private javax.swing.JButton SubmitGradesBtn;
    private javax.swing.JRadioButton ThirdYear;
    private javax.swing.JTextField UnitsField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
