/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flex;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Danish Ali
 */
public class AddEvaluation extends javax.swing.JFrame {

    private JPanel panel;
    private JLabel[] array;
    private JButton back;
    private JButton save;
    private JTextField[] marks;

    public AddEvaluation() {
        initComponents();
    }

    public AddEvaluation(String name, String num, String weightage, String totalNum, String course, String sec) {
//        initFrame();
        initComponents();
        setSize(900,500);
        setLocationRelativeTo(null);
//        scrollpanel.getViewport().setMinimumSize(new Dimension(160, 200));
//        scrollpanel.getViewport().setPreferredSize(new Dimension(160, 200));
        setTitle("Add Evaluation " + name + " " + num);

        dbconnectivity obj = new dbconnectivity();
        List<Student> std = new ArrayList<>();
        obj.getStudentsForAttendance_Marks(course, sec, std);

        JPanel data = new JPanel();
//        data.setPreferredSize(new Dimension(100, 2000));
        data.setLayout(new GridLayout(0, 2));

        int row = 20;
        back = createbutton("Back", 10, row, true);
        save = createbutton("Save", 250, row, true);
        row = row + 40;
        data.add(back);
        data.add(save);

        data.add(createLabel("", 10, row, true));
        data.add(createLabel("", 250, row, true));

        data.add(createLabel("Name", 10, row, true));
        data.add(createLabel("Marks", 250, row, true));

        array = new JLabel[std.size()];
        marks = new JTextField[std.size()];

        for (int i = 0; i < std.size(); i++) {
            array[i] = createLabel(std.get(i).fName + " " + std.get(i).lName, 50, row, true);
            data.add(array[i]);
            marks[i] = createTextField(200, row);
            data.add(marks[i]);
            row = row + 60;
        }
        JPanel northOnlyPanel = new JPanel(new BorderLayout());
        northOnlyPanel.add(data, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(northOnlyPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        addevaluationgui.add(scroll,BorderLayout.CENTER);
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
                List<Evaluation> marksList = new ArrayList<>();
                for (int it = 0; it < std.size(); it++) {

                    Evaluation obj = new Evaluation();
                    obj.studentRollno = std.get(it).rollNo;
                    obj.obtainedMarks = Float.valueOf(marks[it].getText());
                    marksList.add(obj);
                }
                obj.add_marks(name, num, weightage, totalNum, course, sec, marksList);
                new TeacherGUI(TeacherGUI.teacherId, TeacherGUI.teacherName).setVisible(true);
            }
        });
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(400, 200, 300, 800);
        setBounds(20, 20, 500, 400);
        setVisible(true);
    }

    private JTextField createTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 100, 40);
        return tf;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addevaluationgui = new javax.swing.JPanel();
        sidepane3 = new javax.swing.JPanel();
        logo3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        addmarks = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        addattendance = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        updatemarks = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        updateattendance = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        changepassword = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        addgrade = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addevaluationgui.setLayout(new java.awt.BorderLayout());

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

        updatemarks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatemarksMouseClicked(evt);
            }
        });

        jLabel12.setText("Update Marks");

        javax.swing.GroupLayout updatemarksLayout = new javax.swing.GroupLayout(updatemarks);
        updatemarks.setLayout(updatemarksLayout);
        updatemarksLayout.setHorizontalGroup(
            updatemarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatemarksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(53, 53, 53))
        );
        updatemarksLayout.setVerticalGroup(
            updatemarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatemarksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        updateattendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateattendanceMouseClicked(evt);
            }
        });

        jLabel13.setText("Update Attendance");

        javax.swing.GroupLayout updateattendanceLayout = new javax.swing.GroupLayout(updateattendance);
        updateattendance.setLayout(updateattendanceLayout);
        updateattendanceLayout.setHorizontalGroup(
            updateattendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateattendanceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(39, 39, 39))
        );
        updateattendanceLayout.setVerticalGroup(
            updateattendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateattendanceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
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

        addgrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addgradeMouseClicked(evt);
            }
        });

        jLabel14.setText("    Add Grade");

        javax.swing.GroupLayout addgradeLayout = new javax.swing.GroupLayout(addgrade);
        addgrade.setLayout(addgradeLayout);
        addgradeLayout.setHorizontalGroup(
            addgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addgradeLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        addgradeLayout.setVerticalGroup(
            addgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addgradeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidepane3Layout = new javax.swing.GroupLayout(sidepane3);
        sidepane3.setLayout(sidepane3Layout);
        sidepane3Layout.setHorizontalGroup(
            sidepane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addmarks, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addattendance, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(updatemarks, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(updateattendance, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(changepassword, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logout, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addgrade, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(addgrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatemarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateattendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changepassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sidepane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(addevaluationgui, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(addevaluationgui, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
            .addComponent(sidepane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void updatemarksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatemarksMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //                new GoToMarks(StudentGUI.id, "Student").setVisible(true);
                new GoToAttendanceTeacher(TeacherGUI.teacherId, "updatemarks").setVisible(true);
            }
        });
    }//GEN-LAST:event_updatemarksMouseClicked

    private void updateattendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateattendanceMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //                new ViewTranscript(StudentGUI.id, StudentGUI.name).setVisible(true);
                new GoToAttendanceTeacher(TeacherGUI.teacherId, "update").setVisible(true);
            }
        });
    }//GEN-LAST:event_updateattendanceMouseClicked

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

    private void addgradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addgradeMouseClicked
        // TODO add your handling code here:

        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToAttendanceTeacher(TeacherGUI.teacherId,"Grade").setVisible(true);
            }
        });

    }//GEN-LAST:event_addgradeMouseClicked

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
            java.util.logging.Logger.getLogger(AddEvaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEvaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEvaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEvaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEvaluation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addattendance;
    private javax.swing.JPanel addevaluationgui;
    private javax.swing.JPanel addgrade;
    private javax.swing.JPanel addmarks;
    private javax.swing.JPanel changepassword;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logo3;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel sidepane3;
    private javax.swing.JPanel updateattendance;
    private javax.swing.JPanel updatemarks;
    // End of variables declaration//GEN-END:variables
}
