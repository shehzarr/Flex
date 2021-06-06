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
public class CourseRegistrationGUI extends javax.swing.JFrame {

//    private JPanel panel;
    private JLabel[] array;
    private JButton back;
    private JButton register;

    private JComboBox[] dropdown;

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

    public CourseRegistrationGUI() {
//        initFrame();
        initComponents();
        setSize(900, 500);
        setLocationRelativeTo(null);

        register = createbutton("Register", 20, 20, true);
//        scrollpanel.getViewport().setMinimumSize(new Dimension(160, 200));
//        scrollpanel.getViewport().setPreferredSize(new Dimension(160, 200));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
//        add(panel);
//        String[] arr = {"Temp", "Babloo"};
        //JComboBox obj=createCombo(arr, 25, 100);

        back = createbutton("Back", 10, 0, true);
        register = createbutton("Register", 250, 0, true);
//        row = row + 40;
        panel.add(back);
        panel.add(register);

        panel.add(createLabel("", 0, 0, true));
        panel.add(createLabel("", 0, 0, true));

        List<Course> courses = new ArrayList<>();
        dbconnectivity obj = new dbconnectivity();

        String semNum = obj.getSemesterNumber(StudentGUI.id);
        List<String> failed = new ArrayList<String>();
        obj.getFailedCourses(failed);

        obj.getOfferedCourses(courses, semNum, failed);

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
            //System.out.println("HEllo");
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
        courseregistrationgui.add(scroll, BorderLayout.CENTER);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new StudentGUI(StudentGUI.id, StudentGUI.name, StudentGUI.batch).setVisible(true);
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //dispose();
                List<Course> register_request = new ArrayList<>();
                for (int k = 0; k < courses.size(); k++) {

                    if (String.valueOf(dropdown[k + 1].getSelectedItem()) != "-") {
//                String section = String.valueOf(dropdown[k].getSelectedItem());
                        Course temp = new Course();
                        temp.section = String.valueOf(dropdown[k + 1].getSelectedItem());
//                String nameofcourse = array[k + 1].getText();
                        temp.courseName = array[k + 1].getText();
//                        System.out.println(temp.courseName + " " + temp.section);
                        register_request.add(temp);
                    }

                }

                if (register_request.size() > 5) {
                    JOptionPane.showMessageDialog(null, "More than FIVE course registrations not allowed. Please select five courses only.");
                } else {
                    obj.registerCourses(register_request);
                }
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new StudentGUI(StudentGUI.id, StudentGUI.name, StudentGUI.batch).setVisible(true);
                    }
                });
            }
        });

    }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        courseregistrationgui = new javax.swing.JPanel();
        sidepane3 = new javax.swing.JPanel();
        logo3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        courseregistration1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        viewattendance1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        viewmarks1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        viewtranscript1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        feedback1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        viewregisteredcourses1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        changepassword1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        logout1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        viewfeechallan = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        dropCourse = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        courseregistrationgui.setLayout(new java.awt.BorderLayout());

        sidepane3.setBackground(new java.awt.Color(102, 102, 102));

        logo3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Webp.net-resizeimage.png"))); // NOI18N

        javax.swing.GroupLayout logo3Layout = new javax.swing.GroupLayout(logo3);
        logo3.setLayout(logo3Layout);
        logo3Layout.setHorizontalGroup(
            logo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logo3Layout.setVerticalGroup(
            logo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        courseregistration1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseregistration1MouseClicked(evt);
            }
        });

        jLabel17.setText("Course Registration");

        javax.swing.GroupLayout courseregistration1Layout = new javax.swing.GroupLayout(courseregistration1);
        courseregistration1.setLayout(courseregistration1Layout);
        courseregistration1Layout.setHorizontalGroup(
            courseregistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, courseregistration1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(38, 38, 38))
        );
        courseregistration1Layout.setVerticalGroup(
            courseregistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courseregistration1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewattendance1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewattendance1MouseClicked(evt);
            }
        });

        jLabel18.setText("View Attendance");

        javax.swing.GroupLayout viewattendance1Layout = new javax.swing.GroupLayout(viewattendance1);
        viewattendance1.setLayout(viewattendance1Layout);
        viewattendance1Layout.setHorizontalGroup(
            viewattendance1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewattendance1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        viewattendance1Layout.setVerticalGroup(
            viewattendance1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewattendance1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewmarks1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewmarks1MouseClicked(evt);
            }
        });

        jLabel19.setText("View Marks");

        javax.swing.GroupLayout viewmarks1Layout = new javax.swing.GroupLayout(viewmarks1);
        viewmarks1.setLayout(viewmarks1Layout);
        viewmarks1Layout.setHorizontalGroup(
            viewmarks1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewmarks1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(57, 57, 57))
        );
        viewmarks1Layout.setVerticalGroup(
            viewmarks1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewmarks1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewtranscript1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewtranscript1MouseClicked(evt);
            }
        });

        jLabel20.setText("View Transcript");

        javax.swing.GroupLayout viewtranscript1Layout = new javax.swing.GroupLayout(viewtranscript1);
        viewtranscript1.setLayout(viewtranscript1Layout);
        viewtranscript1Layout.setHorizontalGroup(
            viewtranscript1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewtranscript1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(47, 47, 47))
        );
        viewtranscript1Layout.setVerticalGroup(
            viewtranscript1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewtranscript1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        feedback1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feedback1MouseClicked(evt);
            }
        });

        jLabel21.setText("Feedback");

        javax.swing.GroupLayout feedback1Layout = new javax.swing.GroupLayout(feedback1);
        feedback1.setLayout(feedback1Layout);
        feedback1Layout.setHorizontalGroup(
            feedback1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedback1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(64, 64, 64))
        );
        feedback1Layout.setVerticalGroup(
            feedback1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedback1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewregisteredcourses1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewregisteredcourses1MouseClicked(evt);
            }
        });

        jLabel22.setText("Registered Courses");

        javax.swing.GroupLayout viewregisteredcourses1Layout = new javax.swing.GroupLayout(viewregisteredcourses1);
        viewregisteredcourses1.setLayout(viewregisteredcourses1Layout);
        viewregisteredcourses1Layout.setHorizontalGroup(
            viewregisteredcourses1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewregisteredcourses1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(38, 38, 38))
        );
        viewregisteredcourses1Layout.setVerticalGroup(
            viewregisteredcourses1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewregisteredcourses1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        changepassword1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepassword1MouseClicked(evt);
            }
        });

        jLabel23.setText("Change Password");

        javax.swing.GroupLayout changepassword1Layout = new javax.swing.GroupLayout(changepassword1);
        changepassword1.setLayout(changepassword1Layout);
        changepassword1Layout.setHorizontalGroup(
            changepassword1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changepassword1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(43, 43, 43))
        );
        changepassword1Layout.setVerticalGroup(
            changepassword1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changepassword1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout1MouseClicked(evt);
            }
        });

        jLabel24.setText("Logout");

        javax.swing.GroupLayout logout1Layout = new javax.swing.GroupLayout(logout1);
        logout1.setLayout(logout1Layout);
        logout1Layout.setHorizontalGroup(
            logout1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logout1Layout.setVerticalGroup(
            logout1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewfeechallan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewfeechallanMouseClicked(evt);
            }
        });

        jLabel25.setText("View Fee Challan");

        javax.swing.GroupLayout viewfeechallanLayout = new javax.swing.GroupLayout(viewfeechallan);
        viewfeechallan.setLayout(viewfeechallanLayout);
        viewfeechallanLayout.setHorizontalGroup(
            viewfeechallanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewfeechallanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(43, 43, 43))
        );
        viewfeechallanLayout.setVerticalGroup(
            viewfeechallanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewfeechallanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dropCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dropCourseMouseClicked(evt);
            }
        });

        jLabel26.setText("Drop Course");

        javax.swing.GroupLayout dropCourseLayout = new javax.swing.GroupLayout(dropCourse);
        dropCourse.setLayout(dropCourseLayout);
        dropCourseLayout.setHorizontalGroup(
            dropCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dropCourseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(53, 53, 53))
        );
        dropCourseLayout.setVerticalGroup(
            dropCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dropCourseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidepane3Layout = new javax.swing.GroupLayout(sidepane3);
        sidepane3.setLayout(sidepane3Layout);
        sidepane3Layout.setHorizontalGroup(
            sidepane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(courseregistration1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewattendance1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewmarks1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewtranscript1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(feedback1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewregisteredcourses1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(changepassword1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logout1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewfeechallan, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dropCourse, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepane3Layout.setVerticalGroup(
            sidepane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepane3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(logo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseregistration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewattendance1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewmarks1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewtranscript1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedback1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewregisteredcourses1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changepassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewfeechallan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(sidepane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(courseregistrationgui, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(courseregistrationgui, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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

    private void courseregistration1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseregistration1MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseRegistrationGUI().setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_courseregistration1MouseClicked

    private void viewattendance1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewattendance1MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToAttendance(StudentGUI.id, "Student").setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_viewattendance1MouseClicked

    private void viewmarks1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewmarks1MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoToMarks(StudentGUI.id, "Student").setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_viewmarks1MouseClicked

    private void viewtranscript1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewtranscript1MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTranscript(StudentGUI.id, StudentGUI.name).setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_viewtranscript1MouseClicked

    private void feedback1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feedback1MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new GoToFeedback(StudentGUI.id).setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_feedback1MouseClicked

    private void viewregisteredcourses1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewregisteredcourses1MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRegisteredCourses(StudentGUI.id, StudentGUI.name, StudentGUI.batch).setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_viewregisteredcourses1MouseClicked

    private void changepassword1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassword1MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePassword("student", StudentGUI.id).setVisible(true);
            }
        });
    }//GEN-LAST:event_changepassword1MouseClicked

    private void logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_logout1MouseClicked

    private void viewfeechallanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewfeechallanMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeeChallanGUI().setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_viewfeechallanMouseClicked

    private void dropCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dropCourseMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DropCourseGUI(StudentGUI.id).setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_dropCourseMouseClicked

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
            java.util.logging.Logger.getLogger(CourseRegistrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseRegistrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseRegistrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseRegistrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseRegistrationGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel changepassword1;
    private javax.swing.JPanel courseregistration1;
    private javax.swing.JPanel courseregistrationgui;
    private javax.swing.JPanel dropCourse;
    private javax.swing.JPanel feedback1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logo3;
    private javax.swing.JPanel logout1;
    private javax.swing.JPanel sidepane3;
    private javax.swing.JPanel viewattendance1;
    private javax.swing.JPanel viewfeechallan;
    private javax.swing.JPanel viewmarks1;
    private javax.swing.JPanel viewregisteredcourses1;
    private javax.swing.JPanel viewtranscript1;
    // End of variables declaration//GEN-END:variables
}
