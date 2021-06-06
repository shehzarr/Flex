/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flex;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Shehzar
 */
public class AdminCourseRegister extends javax.swing.JFrame {

    /**
     * Creates new form AdminCourseRegister
     */
    private JLabel[] array;
    private JButton back;
    private JButton register;

    private JComboBox[] dropdown;

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(400, 200, 300, 800);
        setBounds(20, 20, 400, 700);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, Boolean b) {
        JLabel label = new JLabel(text);
        if (b == true) {
            label.setFont(new java.awt.Font("Tahoma", 1, 13));
        }
//        panel.add(label);
        label.setBounds(x, y, 375, 20);
        if (y == 0) {
            Font f = label.getFont();
            label.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        }
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    private JComboBox createCombo(String[] text, int x, int y) {
        JComboBox combo = new JComboBox(text);
//        panel.add(combo);
        combo.setBounds(x, y, 100, 30);
        // combo.setPreferredSize(new Dimension(200, 100));

        return combo;
    }

    private JButton createbutton(String text, int x, int y, Boolean var) {
        JButton but = new JButton(text);
//        panel.add(but);
        if (var == false) {
            but.setBounds(x, y, 70, 25);
        } else {
            but.setBounds(x, y, 100, 25);
        }

        return but;
    }

    public AdminCourseRegister() throws HeadlessException {
    }

    public AdminCourseRegister(String id) {
        
        
        initComponents();
        setSize(900, 500);
        setLocationRelativeTo(null);

        register = createbutton("Register", 20, 20, true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        back = createbutton("Back", 10, 0, true);
        register = createbutton("Register", 250, 0, true);

        panel.add(back);
        panel.add(register);

        panel.add(createLabel("", 0, 0, true));
        panel.add(createLabel("", 0, 0, true));

        List<Course> courses = new ArrayList<>();
        dbconnectivity obj = new dbconnectivity();

        String semNum = obj.getSemesterNumber(id);

        List<String> failed = new ArrayList<String>();
        obj.getFailedCourses( failed);

        obj.getOfferedCourses( courses, semNum, failed);

        List<String> s = new ArrayList<String>();

        int row = 10;
        dropdown = new JComboBox[courses.size() + 1];
        array = new JLabel[courses.size() + 1];
        int i = 0;
        int j = 0;
        for (j = 0; j < ((courses.size()) + 1); j++) {
            if (j == 0) {
                array[j] = createLabel("Course", 10, row, true);
                panel.add(array[j]);
                panel.add(createLabel("", 10, 10, false));
                row = row + 40;
                continue;
            }
            array[j] = createLabel(courses.get(i).courseName, 10, row, false);
            panel.add(array[j]);

            List<String> sec = new ArrayList<>();
            obj.getSections(courses.get(i), sec);
            String[] section = new String[sec.size() + 1];
            section[0] = "-";
            int z = 0;
            for (int k = 1; k < sec.size() + 1; k++) {
                section[k] = sec.get(z);
                z++;
            }
            dropdown[j] = createCombo(section, 200, row);
            panel.add(dropdown[j]);
            row = row + 40;
            i++;
        }

        JPanel northOnlyPanel = new JPanel(new BorderLayout());
        northOnlyPanel.add(panel, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(northOnlyPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        admincourseregister.add(scroll, BorderLayout.CENTER);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new StudentGUI(id, StudentGUI.name, StudentGUI.batch).setVisible(true);
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<Course> register_request = new ArrayList<>();
                for (int k = 0; k < courses.size(); k++) {

                    if (String.valueOf(dropdown[k + 1].getSelectedItem()) != "-") {
                        Course temp = new Course();
                        temp.section = String.valueOf(dropdown[k + 1].getSelectedItem());
                        temp.courseName = array[k + 1].getText();
                        register_request.add(temp);
                    }

                }

                if (register_request.size() > 5) {
                    JOptionPane.showMessageDialog(null, "More than FIVE course registrations not allowed. Please select five courses only.");
                }
                obj.registerCourses(register_request);

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        logo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        courseregistration = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        viewattendance = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        viewmarks = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        viewtranscript = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        feedback = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        viewregisteredcourses = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        changepassword = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        admincourseregister = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidepane.setBackground(new java.awt.Color(102, 102, 102));

        logo.setBackground(new java.awt.Color(102, 102, 102));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Webp.net-resizeimage.png"))); // NOI18N

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoLayout.setVerticalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        courseregistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseregistrationMouseClicked(evt);
            }
        });

        jLabel6.setText("Course Registration");

        javax.swing.GroupLayout courseregistrationLayout = new javax.swing.GroupLayout(courseregistration);
        courseregistration.setLayout(courseregistrationLayout);
        courseregistrationLayout.setHorizontalGroup(
            courseregistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, courseregistrationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(38, 38, 38))
        );
        courseregistrationLayout.setVerticalGroup(
            courseregistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courseregistrationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewattendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewattendanceMouseClicked(evt);
            }
        });

        jLabel7.setText("View Attendance");

        javax.swing.GroupLayout viewattendanceLayout = new javax.swing.GroupLayout(viewattendance);
        viewattendance.setLayout(viewattendanceLayout);
        viewattendanceLayout.setHorizontalGroup(
            viewattendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewattendanceLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        viewattendanceLayout.setVerticalGroup(
            viewattendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewattendanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewmarks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewmarksMouseClicked(evt);
            }
        });

        jLabel8.setText("View Marks");

        javax.swing.GroupLayout viewmarksLayout = new javax.swing.GroupLayout(viewmarks);
        viewmarks.setLayout(viewmarksLayout);
        viewmarksLayout.setHorizontalGroup(
            viewmarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewmarksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(57, 57, 57))
        );
        viewmarksLayout.setVerticalGroup(
            viewmarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewmarksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewtranscript.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewtranscriptMouseClicked(evt);
            }
        });

        jLabel9.setText("View Transcript");

        javax.swing.GroupLayout viewtranscriptLayout = new javax.swing.GroupLayout(viewtranscript);
        viewtranscript.setLayout(viewtranscriptLayout);
        viewtranscriptLayout.setHorizontalGroup(
            viewtranscriptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewtranscriptLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(47, 47, 47))
        );
        viewtranscriptLayout.setVerticalGroup(
            viewtranscriptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewtranscriptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        feedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feedbackMouseClicked(evt);
            }
        });

        jLabel10.setText("Feedback");

        javax.swing.GroupLayout feedbackLayout = new javax.swing.GroupLayout(feedback);
        feedback.setLayout(feedbackLayout);
        feedbackLayout.setHorizontalGroup(
            feedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedbackLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(64, 64, 64))
        );
        feedbackLayout.setVerticalGroup(
            feedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewregisteredcourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewregisteredcoursesMouseClicked(evt);
            }
        });

        jLabel11.setText("Registered Courses");

        javax.swing.GroupLayout viewregisteredcoursesLayout = new javax.swing.GroupLayout(viewregisteredcourses);
        viewregisteredcourses.setLayout(viewregisteredcoursesLayout);
        viewregisteredcoursesLayout.setHorizontalGroup(
            viewregisteredcoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewregisteredcoursesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(38, 38, 38))
        );
        viewregisteredcoursesLayout.setVerticalGroup(
            viewregisteredcoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewregisteredcoursesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        changepassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepasswordMouseClicked(evt);
            }
        });

        jLabel12.setText("Change Password");

        javax.swing.GroupLayout changepasswordLayout = new javax.swing.GroupLayout(changepassword);
        changepassword.setLayout(changepasswordLayout);
        changepasswordLayout.setHorizontalGroup(
            changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changepasswordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(43, 43, 43))
        );
        changepasswordLayout.setVerticalGroup(
            changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changepasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        jLabel13.setText("Logout");

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(courseregistration, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewattendance, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewmarks, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewtranscript, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(feedback, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewregisteredcourses, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(changepassword, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logout, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseregistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewattendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewmarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewtranscript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewregisteredcourses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changepassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        admincourseregister.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(admincourseregister, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidepane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(admincourseregister, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
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

    private void courseregistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseregistrationMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseRegistrationGUI().setVisible(true);
            }
        });
    }//GEN-LAST:event_courseregistrationMouseClicked

    private void viewattendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewattendanceMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToAttendance(StudentGUI.id, "Student").setVisible(true);
            }
        });
    }//GEN-LAST:event_viewattendanceMouseClicked

    private void viewmarksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewmarksMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToMarks(StudentGUI.id, "Student").setVisible(true);
            }
        });
    }//GEN-LAST:event_viewmarksMouseClicked

    private void viewtranscriptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewtranscriptMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTranscript(StudentGUI.id, StudentGUI.name).setVisible(true);
            }
        });
    }//GEN-LAST:event_viewtranscriptMouseClicked

    private void feedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feedbackMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new GoToFeedback(StudentGUI.id).setVisible(true);
            }
        });
    }//GEN-LAST:event_feedbackMouseClicked

    private void viewregisteredcoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewregisteredcoursesMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRegisteredCourses(StudentGUI.id, StudentGUI.name, StudentGUI.batch).setVisible(true);
            }
        });
    }//GEN-LAST:event_viewregisteredcoursesMouseClicked

    private void changepasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepasswordMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePassword("student", StudentGUI.id).setVisible(true);
            }
        });
    }//GEN-LAST:event_changepasswordMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }//GEN-LAST:event_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(AdminCourseRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminCourseRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminCourseRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminCourseRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminCourseRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel admincourseregister;
    private javax.swing.JPanel changepassword;
    private javax.swing.JPanel courseregistration;
    private javax.swing.JPanel feedback;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logo;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel sidepane;
    private javax.swing.JPanel viewattendance;
    private javax.swing.JPanel viewmarks;
    private javax.swing.JPanel viewregisteredcourses;
    private javax.swing.JPanel viewtranscript;
    // End of variables declaration//GEN-END:variables
}
