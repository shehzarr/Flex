/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flex;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Danish Ali
 */
public class AddCourseGUI extends javax.swing.JFrame {

    private JButton back;
    private JButton save;
    private JTextField[] entries;
    
    public AddCourseGUI() {
        initComponents();
        setSize(900, 500);
        setLocationRelativeTo(null);
//        scrollpanel.getViewport().setMinimumSize(new Dimension(160, 200));
//        scrollpanel.getViewport().setPreferredSize(new Dimension(160, 200));

        JPanel data=new JPanel();
        data.setLayout(new GridLayout(0, 2));

        back = createbutton("Back", 0, 0, true);
        save = createbutton("Save", 0, 0, true);
        data.add(back);
        data.add(save);

        JLabel temp = createLabel("", 0, 0, true);
        
        data.add(temp);
        data.add(createLabel("", 0, 0, true));
        
        entries=new JTextField[12];

        int i=0;
        data.add(createLabel("ID:", 0, 0, true));
        entries[i] = createTextField(10, 10);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Name:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Instructor ID:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Section:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Course Type:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Credit Hours:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Total Seats:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Semester:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Pre Requisite:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Semester Number:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        data.add(createLabel("Post Requisite:", 0, 0, true));
        entries[i] = createTextField(0, 0);
        data.add(entries[i]);
        i++;
        
        JPanel northOnlyPanel=new JPanel(new BorderLayout());
        northOnlyPanel.add(data,BorderLayout.NORTH);
        
        JScrollPane scroll = new JScrollPane(northOnlyPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        addcoursegui.add(scroll,BorderLayout.CENTER);
        
//                System.out.println(addcoursegui.getSize().toString());


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
//                new TeacherGUI(TeacherGUI.teacherName, TeacherGUI.teacherId).setVisible(true);
                new AdminGUI(AdminGUI.name, AdminGUI.id).setVisible(true);

            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                dbconnectivity obj=new dbconnectivity();
                obj.AddCourse(entries);
                JOptionPane.showMessageDialog(null, "Course added.");
                new AdminGUI(AdminGUI.name, AdminGUI.id).setVisible(true);
//                new TeacherGUI(TeacherGUI.teacherName, TeacherGUI.teacherId).setVisible(true);
            }
        });
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
    
    private JTextField createTextField(int x, int y) {
        JTextField tf = new JTextField();
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
        addcoursegui = new javax.swing.JPanel();
        sidepane3 = new javax.swing.JPanel();
        logo3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        registercourse = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        changepassword = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        addstudent = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        addteacher = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        addteacher1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        viewallstudents = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addcoursegui.setLayout(new java.awt.BorderLayout());

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

        registercourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registercourseMouseClicked(evt);
            }
        });

        jLabel11.setText("Register Course");

        javax.swing.GroupLayout registercourseLayout = new javax.swing.GroupLayout(registercourse);
        registercourse.setLayout(registercourseLayout);
        registercourseLayout.setHorizontalGroup(
            registercourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registercourseLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        registercourseLayout.setVerticalGroup(
            registercourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registercourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(69, 69, 69)
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

        addstudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addstudentMouseClicked(evt);
            }
        });

        jLabel18.setText("Add Student");

        javax.swing.GroupLayout addstudentLayout = new javax.swing.GroupLayout(addstudent);
        addstudent.setLayout(addstudentLayout);
        addstudentLayout.setHorizontalGroup(
            addstudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addstudentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(55, 55, 55))
        );
        addstudentLayout.setVerticalGroup(
            addstudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addstudentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addteacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addteacherMouseClicked(evt);
            }
        });

        jLabel19.setText("Add Teacher");

        javax.swing.GroupLayout addteacherLayout = new javax.swing.GroupLayout(addteacher);
        addteacher.setLayout(addteacherLayout);
        addteacherLayout.setHorizontalGroup(
            addteacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addteacherLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(54, 54, 54))
        );
        addteacherLayout.setVerticalGroup(
            addteacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addteacherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addteacher1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addteacher1MouseClicked(evt);
            }
        });

        jLabel20.setText("Add Course");

        javax.swing.GroupLayout addteacher1Layout = new javax.swing.GroupLayout(addteacher1);
        addteacher1.setLayout(addteacher1Layout);
        addteacher1Layout.setHorizontalGroup(
            addteacher1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addteacher1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(54, 54, 54))
        );
        addteacher1Layout.setVerticalGroup(
            addteacher1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addteacher1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewallstudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewallstudentsMouseClicked(evt);
            }
        });

        jLabel21.setText("View All Students");

        javax.swing.GroupLayout viewallstudentsLayout = new javax.swing.GroupLayout(viewallstudents);
        viewallstudents.setLayout(viewallstudentsLayout);
        viewallstudentsLayout.setHorizontalGroup(
            viewallstudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewallstudentsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(44, 44, 44))
        );
        viewallstudentsLayout.setVerticalGroup(
            viewallstudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewallstudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidepane3Layout = new javax.swing.GroupLayout(sidepane3);
        sidepane3.setLayout(sidepane3Layout);
        sidepane3Layout.setHorizontalGroup(
            sidepane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(changepassword, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(registercourse, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logout, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addstudent, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addteacher, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addteacher1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewallstudents, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepane3Layout.setVerticalGroup(
            sidepane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepane3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(logo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registercourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changepassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addstudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addteacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addteacher1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewallstudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(28, 28, 28)
                .addComponent(addcoursegui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(addcoursegui, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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

    private void registercourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registercourseMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToAdminRegistration().setVisible(true);
            }
        });
    }//GEN-LAST:event_registercourseMouseClicked

    private void changepasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepasswordMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePassword("admin", StudentGUI.id).setVisible(true);
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

    private void addstudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addstudentMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudentGUI().setVisible(true);
            }
        });
    }//GEN-LAST:event_addstudentMouseClicked

    private void addteacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addteacherMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTeacherGUI().setVisible(true);
            }
        });
    }//GEN-LAST:event_addteacherMouseClicked

    private void addteacher1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addteacher1MouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCourseGUI().setVisible(true);
            }
        });
    }//GEN-LAST:event_addteacher1MouseClicked

    private void viewallstudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewallstudentsMouseClicked
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToAllCourses().setVisible(true);
            }
        });
    }//GEN-LAST:event_viewallstudentsMouseClicked

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
            java.util.logging.Logger.getLogger(AddCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCourseGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addcoursegui;
    private javax.swing.JPanel addstudent;
    private javax.swing.JPanel addteacher;
    private javax.swing.JPanel addteacher1;
    private javax.swing.JPanel changepassword;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logo3;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel registercourse;
    private javax.swing.JPanel sidepane3;
    private javax.swing.JPanel viewallstudents;
    // End of variables declaration//GEN-END:variables
}
