/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danish Ali
 */
public class TeacherAddAttendance extends javax.swing.JFrame {

//    private JPanel panel;
    private JLabel[] array;
    private JButton back;
    private JButton save;
    private JComboBox[] dropdown;

    public TeacherAddAttendance() throws HeadlessException {
    }

    public TeacherAddAttendance(String course, String section) {
//        initFrame();
        initComponents();
        setSize(900, 500);
        setLocationRelativeTo(null);
//        setTitle("Add Attendance");
        int row = 20;

        dbconnectivity obj = new dbconnectivity();
        List<Student> std = new ArrayList<>();
        obj.getStudentsForAttendance_Marks(course, section, std);

        JPanel data = new JPanel();
        data.setLayout(new GridLayout(0, 2));

        back = createbutton("Back", 10, row, true);
        save = createbutton("Save", 250, row, true);
        row = row + 40;
        data.add(back);
        data.add(save);

        Date temp = new Date();
        
        JTextField date=createTextField(temp.toString(), 10, row);
        data.add(createLabel("Date:", 10, row, true));
        data.add(date);
        data.add(createLabel("", 10, row, true));
        data.add(createLabel("", 250, row, true));

        data.add(createLabel("Name", 10, row, true));
        data.add(createLabel("Status", 250, row, true));

        dropdown = new JComboBox[std.size()];
        String[] status = {"-", "A", "L"};
        array = new JLabel[std.size()];

//        for (int i = 0; i < 101; i++) {
        for (int i = 0; i < std.size(); i++) {
            array[i] = createLabel(std.get(i).fName + " " + std.get(i).lName, 50, row, true);
            data.add(array[i]);
            dropdown[i] = createCombo(status, 200, row);
            data.add(dropdown[i]);
//            data.add(createLabel(temp, 10, row, true));
            row = row + 40;
        }

        JPanel northOnlyPanel = new JPanel(new BorderLayout());
        northOnlyPanel.add(data, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(northOnlyPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        teacheraddattendance.add(scroll,BorderLayout.CENTER);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new TeacherGUI(TeacherGUI.teacherName, TeacherGUI.teacherId).setVisible(true);

            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                List<Attendance> attendanceList = new ArrayList<>();
                for (int it = 0; it < std.size(); it++) {

                    Attendance obj = new Attendance();
                    obj.studentRollno = std.get(it).rollNo;
                    obj.status = String.valueOf(dropdown[it].getSelectedItem());
                    attendanceList.add(obj);
                }
                obj.add_Attendance(attendanceList, course, section, date.getText());
                new TeacherGUI(TeacherGUI.teacherName, TeacherGUI.teacherId).setVisible(true);
            }
        });
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(400, 200, 300, 800);
        setBounds(20, 20, 600, 600);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, Boolean b) {
        JLabel label = new JLabel(text);
        if (b == true) {
            label.setFont(new java.awt.Font("Tahoma", 1, 11));
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
        //panel.add(combo);
        combo.setBounds(x, y, 100, 25);
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

    private JTextField createTextField(String text, int x, int y) {
        JTextField tf = new JTextField(text);
        tf.setBounds(x, y, 100, 40);
        return tf;
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
        sidepane3 = new javax.swing.JPanel();
        logo3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        addmarks = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        addattendance = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        viewmarks = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        viewtranscript = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        changepassword = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        teacheraddattendance = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidepane3.setBackground(new java.awt.Color(102, 102, 102));

        logo3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Webp.net-resizeimage.png"))); // NOI18N

        javax.swing.GroupLayout logo3Layout = new javax.swing.GroupLayout(logo3);
        logo3.setLayout(logo3Layout);
        logo3Layout.setHorizontalGroup(
            logo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logo3Layout.setVerticalGroup(
            logo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        addmarks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addmarksMouseClicked(evt);
            }
        });

        jLabel10.setText("Add Marks");

        javax.swing.GroupLayout addmarksLayout = new javax.swing.GroupLayout(addmarks);
        addmarks.setLayout(addmarksLayout);
        addmarksLayout.setHorizontalGroup(
            addmarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addmarksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(58, 58, 58))
        );
        addmarksLayout.setVerticalGroup(
            addmarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addmarksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        addattendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addattendanceMouseClicked(evt);
            }
        });

        jLabel11.setText("Add Attendance");

        javax.swing.GroupLayout addattendanceLayout = new javax.swing.GroupLayout(addattendance);
        addattendance.setLayout(addattendanceLayout);
        addattendanceLayout.setHorizontalGroup(
            addattendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addattendanceLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        addattendanceLayout.setVerticalGroup(
            addattendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addattendanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewmarks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewmarksMouseClicked(evt);
            }
        });

        jLabel12.setText("View Marks");

        javax.swing.GroupLayout viewmarksLayout = new javax.swing.GroupLayout(viewmarks);
        viewmarks.setLayout(viewmarksLayout);
        viewmarksLayout.setHorizontalGroup(
            viewmarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewmarksLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewmarksLayout.setVerticalGroup(
            viewmarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewmarksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        viewtranscript.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewtranscriptMouseClicked(evt);
            }
        });

        jLabel13.setText("View Attendance");

        javax.swing.GroupLayout viewtranscriptLayout = new javax.swing.GroupLayout(viewtranscript);
        viewtranscript.setLayout(viewtranscriptLayout);
        viewtranscriptLayout.setHorizontalGroup(
            viewtranscriptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewtranscriptLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(47, 47, 47))
        );
        viewtranscriptLayout.setVerticalGroup(
            viewtranscriptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewtranscriptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        changepassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepasswordMouseClicked(evt);
            }
        });

        jLabel16.setText("Change Password");

        javax.swing.GroupLayout changepasswordLayout = new javax.swing.GroupLayout(changepassword);
        changepassword.setLayout(changepasswordLayout);
        changepasswordLayout.setHorizontalGroup(
            changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changepasswordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(43, 43, 43))
        );
        changepasswordLayout.setVerticalGroup(
            changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changepasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        jLabel17.setText("Logout");

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidepane3Layout = new javax.swing.GroupLayout(sidepane3);
        sidepane3.setLayout(sidepane3Layout);
        sidepane3Layout.setHorizontalGroup(
            sidepane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addmarks, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addattendance, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewmarks, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewtranscript, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(changepassword, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logout, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepane3Layout.setVerticalGroup(
            sidepane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepane3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(logo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addmarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addattendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewmarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewtranscript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changepassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        teacheraddattendance.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sidepane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(teacheraddattendance, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sidepane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(teacheraddattendance, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void addmarksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addmarksMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToMarksTeacher(TeacherGUI.teacherId,"Teacher").setVisible(true);
            }
        });
    }//GEN-LAST:event_addmarksMouseClicked

    private void addattendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addattendanceMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToAttendanceTeacher(TeacherGUI.teacherId,"Teacher").setVisible(true);
            }
        });
    }//GEN-LAST:event_addattendanceMouseClicked

    private void viewmarksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewmarksMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //                new GoToMarks(StudentGUI.id, "Student").setVisible(true);
            }
        });
    }//GEN-LAST:event_viewmarksMouseClicked

    private void viewtranscriptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewtranscriptMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //                new ViewTranscript(StudentGUI.id, StudentGUI.name).setVisible(true);
            }
        });
    }//GEN-LAST:event_viewtranscriptMouseClicked

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
            java.util.logging.Logger.getLogger(TeacherAddAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherAddAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherAddAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherAddAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherAddAttendance("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addattendance;
    private javax.swing.JPanel addmarks;
    private javax.swing.JPanel changepassword;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logo3;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel sidepane3;
    private javax.swing.JPanel teacheraddattendance;
    private javax.swing.JPanel viewmarks;
    private javax.swing.JPanel viewtranscript;
    // End of variables declaration//GEN-END:variables
}
