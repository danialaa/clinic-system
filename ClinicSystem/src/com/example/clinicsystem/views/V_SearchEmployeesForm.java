/*
 * Created by JFormDesigner on Sat Nov 30 22:03:00 EET 2019
 */

package com.example.clinicsystem.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.spi.CalendarDataProvider;

import com.example.clinicsystem.controllers.C_Employee;
import com.example.clinicsystem.models.classes.M_Employee;
import com.example.clinicsystem.models.enums.DentistryDepartment;
import com.github.lgooddatepicker.components.DatePicker;
import com.intellij.uiDesigner.core.*;
import info.clearthought.layout.*;

/**
 * @author Dania
 */
public class V_SearchEmployeesForm extends JPanel {
    public V_SearchEmployeesForm() {
        initComponents();

        datePicker.setDate(LocalDate.parse(getNextDay()));

        employees = employeeController.request("R", null);
        updateTable();

        comboBoxDepartment.addItem("-");

        for (DentistryDepartment department : DentistryDepartment.values()) {
            comboBoxDepartment.addItem(department.getName());
        }

        comboBoxJobTitle.addItem("-");
    }

    private void labelHome2MouseClicked(MouseEvent e) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(new V_HomeForm());
        frame.pack();
        frame.setVisible(true);
        V_LoginForm.frame.dispose();
    }

    private void labelEdit2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void labelShrinkMouseClicked(MouseEvent e) {
        panelExpanded.setVisible(false);
        panelShrinked.setVisible(true);
    }

    private void labelExpandMouseClicked(MouseEvent e) {
        panelShrinked.setVisible(false);
        panelExpanded.setVisible(true);
    }

    private void textFieldIDFocusGained(FocusEvent e) {
        if (textFieldID.getText().equals("e.g. 180967")) {
            textFieldID.setText("");
            textFieldID.setForeground(Color.black);
        }
    }

    private void textFieldIDFocusLost(FocusEvent e) {
        if (textFieldID.getText().equals("")) {
            textFieldID.setText("e.g. 180967");
            textFieldID.setForeground(Color.gray);
        }
    }

    private void textFieldNameFocusGained(FocusEvent e) {
        if (textFieldName.getText().equals("e.g. John Doe")) {
            textFieldName.setText("");
            textFieldName.setForeground(Color.black);
        }
    }

    private void textFieldNameFocusLost(FocusEvent e) {
        if (textFieldName.getText().equals("")) {
            textFieldName.setText("e.g. John Doe");
            textFieldName.setForeground(Color.gray);
        }
    }

    private void buttonResetMouseClicked(MouseEvent e) {
        textFieldID.setText("e.g. 180967");
        textFieldID.setForeground(Color.gray);
        textFieldName.setText("e.g. John Doe");
        textFieldName.setForeground(Color.gray);

        comboBoxDepartment.setSelectedIndex(0);
        comboBoxJobTitle.setSelectedIndex(0);

        datePicker.setDate(LocalDate.parse(getNextDay()));
    }

    private void buttonSearchMouseClicked(MouseEvent e) {
        String sec = " WHERE ";

        if(textFieldID.getText() != "e.g. 180967"){

            sec += "Employee_ID = " + textFieldID.getText();
        }
        if(sec == " WHERE "){
            employees = employeeController.request("R", null);
        }
        else{
            List<String> condition = new ArrayList<>();
            condition.add(sec);
            employees = employeeController.request("R", condition);
        }

        updateTable();
    }

    private String getNextDay() {
        datePicker.setDateToToday();
        String newDate = datePicker.getDateStringOrEmptyString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.add(Calendar.DATE, 1);
        return sdf.format(calendar.getTime());
    }

    private void updateTable(){
        ((DefaultTableModel) tableEmployees.getModel()).setRowCount(0);

        for (M_Employee employee : employees) {
            ((DefaultTableModel) tableEmployees.getModel()).addRow(new Object[]{employee.getEmployeeID(),
                    employee.getFirstName() + " " + employee.getLastName(), employee.getPhoneNumber(), "Dentist", "Surgery", "H213"});
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dania
        panelExpanded = new JPanel();
        panelExpandedNav = new JPanel();
        labelHome2 = new JLabel();
        labelAdd2 = new JLabel();
        labelView2 = new JLabel();
        labelLogout2 = new JLabel();
        labelSettings2 = new JLabel();
        labelLogo2 = new JLabel();
        panelButtonContainer = new JPanel();
        panelShrink = new JPanel();
        labelShrink = new JLabel();
        panelShrinked = new JPanel();
        panelShrinkedNav = new JPanel();
        labelHome = new JLabel();
        labelAdd = new JLabel();
        labelView = new JLabel();
        labelLogout = new JLabel();
        labelSettings = new JLabel();
        labelLogo = new JLabel();
        panelButtonContainer2 = new JPanel();
        panelExpand = new JPanel();
        labelExpand = new JLabel();
        labelFake = new JLabel();
        scrollPane1 = new JScrollPane();
        panelBody = new JPanel();
        panelSearchHeader = new JPanel();
        textSearchEmp = new JLabel();
        panelSearchBy = new JPanel();
        labelRegDate = new JLabel();
        textFieldID = new JTextField();
        hSpacer3 = new JPanel(null);
        textFieldName = new JTextField();
        hSpacer4 = new JPanel(null);
        panelRegDate = new JPanel();
        vSpacer1 = new JPanel(null);
        labelJob = new JLabel();
        labelDepartment = new JLabel();
        comboBoxJobTitle = new JComboBox();
        comboBoxDepartment = new JComboBox();
        vSpacer2 = new JPanel(null);
        panelSearchButtons = new JPanel();
        hSpacer5 = new JPanel(null);
        buttonSearch = new JButton();
        hSpacer6 = new JPanel(null);
        buttonReset = new JButton();
        hSpacer7 = new JPanel(null);
        vSpacer3 = new JPanel(null);
        hSpacer8 = new JPanel(null);
        separatorSearch = new JSeparator();
        vSpacer4 = new JPanel(null);
        scrollPaneTable = new JScrollPane();
        tableEmployees = new JTable();
        hSpacer1 = new JPanel(null);
        panelFooter = new JPanel();
        buttonPrint = new JButton();
        labelTooth = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(1920, 1080));
        setPreferredSize(new Dimension(1920, 1200));
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
        (0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border
        .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
        .Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
        propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});
        setLayout(new TableLayout(new double[][] {
            {226, TableLayout.FILL},
            {TableLayout.FILL}}));
        ((TableLayout)getLayout()).setHGap(5);
        ((TableLayout)getLayout()).setVGap(5);

        //======== panelExpanded ========
        {
            panelExpanded.setBackground(Color.white);
            panelExpanded.setMinimumSize(new Dimension(246, 1200));
            panelExpanded.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), 0, 0));

            //======== panelExpandedNav ========
            {
                panelExpandedNav.setBackground(new Color(32, 32, 82));
                panelExpandedNav.setPreferredSize(new Dimension(119, 1200));
                panelExpandedNav.setMinimumSize(new Dimension(180, 394));

                //---- labelHome2 ----
                labelHome2.setBackground(new Color(32, 32, 82));
                labelHome2.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/home.png")));
                labelHome2.setHorizontalAlignment(SwingConstants.CENTER);
                labelHome2.setText("Home");
                labelHome2.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelHome2.setForeground(Color.white);
                labelHome2.setIconTextGap(20);
                labelHome2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        labelHome2MouseClicked(e);
                    }
                });

                //---- labelAdd2 ----
                labelAdd2.setBackground(new Color(32, 32, 82));
                labelAdd2.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/add.png")));
                labelAdd2.setHorizontalAlignment(SwingConstants.CENTER);
                labelAdd2.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelAdd2.setForeground(Color.white);
                labelAdd2.setIconTextGap(30);
                labelAdd2.setText("Add");
                labelAdd2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        labelEdit2MouseClicked(e);
                    }
                });

                //---- labelView2 ----
                labelView2.setBackground(new Color(32, 32, 82));
                labelView2.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/list.png")));
                labelView2.setHorizontalAlignment(SwingConstants.CENTER);
                labelView2.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelView2.setForeground(Color.white);
                labelView2.setText("Search");
                labelView2.setIconTextGap(10);

                //---- labelLogout2 ----
                labelLogout2.setBackground(new Color(32, 32, 82));
                labelLogout2.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/logout.png")));
                labelLogout2.setHorizontalAlignment(SwingConstants.CENTER);
                labelLogout2.setText("Logout");
                labelLogout2.setForeground(Color.white);
                labelLogout2.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelLogout2.setIconTextGap(10);

                //---- labelSettings2 ----
                labelSettings2.setBackground(new Color(32, 32, 82));
                labelSettings2.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/settings.png")));
                labelSettings2.setHorizontalAlignment(SwingConstants.CENTER);

                //---- labelLogo2 ----
                labelLogo2.setBackground(new Color(32, 32, 82));
                labelLogo2.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/tooth_white.png")));
                labelLogo2.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout panelExpandedNavLayout = new GroupLayout(panelExpandedNav);
                panelExpandedNav.setLayout(panelExpandedNavLayout);
                panelExpandedNavLayout.setHorizontalGroup(
                    panelExpandedNavLayout.createParallelGroup()
                        .addGroup(panelExpandedNavLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(labelLogo2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSettings2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, panelExpandedNavLayout.createSequentialGroup()
                            .addGroup(panelExpandedNavLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelLogout2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelView2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAdd2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelHome2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panelExpandedNavLayout.setVerticalGroup(
                    panelExpandedNavLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelExpandedNavLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(labelHome2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelAdd2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelView2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelLogout2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelExpandedNavLayout.createParallelGroup()
                                .addComponent(labelSettings2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelLogo2, GroupLayout.Alignment.TRAILING))
                            .addContainerGap())
                );
            }
            panelExpanded.add(panelExpandedNav, new GridConstraints(0, 0, 3, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== panelButtonContainer ========
            {
                panelButtonContainer.setBackground(Color.white);
                panelButtonContainer.setLayout(new GridBagLayout());
                ((GridBagLayout)panelButtonContainer.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panelButtonContainer.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panelButtonContainer.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panelButtonContainer.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //======== panelShrink ========
                {
                    panelShrink.setBackground(new Color(32, 32, 82));

                    //---- labelShrink ----
                    labelShrink.setBackground(new Color(32, 32, 82));
                    labelShrink.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/arrow_left.png")));
                    labelShrink.setHorizontalAlignment(SwingConstants.CENTER);
                    labelShrink.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            labelShrinkMouseClicked(e);
                            labelShrinkMouseClicked(e);
                        }
                    });

                    GroupLayout panelShrinkLayout = new GroupLayout(panelShrink);
                    panelShrink.setLayout(panelShrinkLayout);
                    panelShrinkLayout.setHorizontalGroup(
                        panelShrinkLayout.createParallelGroup()
                            .addGroup(panelShrinkLayout.createSequentialGroup()
                                .addComponent(labelShrink, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                    );
                    panelShrinkLayout.setVerticalGroup(
                        panelShrinkLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelShrinkLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelShrink, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                    );
                }
                panelButtonContainer.add(panelShrink, new GridBagConstraints(0, 5, 1, 4, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            }
            panelExpanded.add(panelButtonContainer, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        add(panelExpanded, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== panelShrinked ========
        {
            panelShrinked.setBackground(Color.white);
            panelShrinked.setMinimumSize(new Dimension(216, 1200));
            panelShrinked.setPreferredSize(new Dimension(216, 1200));
            panelShrinked.setVisible(false);
            panelShrinked.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), 0, 0));

            //======== panelShrinkedNav ========
            {
                panelShrinkedNav.setBackground(new Color(32, 32, 82));
                panelShrinkedNav.setPreferredSize(new Dimension(70, 1200));
                panelShrinkedNav.setMinimumSize(new Dimension(70, 394));

                //---- labelHome ----
                labelHome.setBackground(new Color(32, 32, 82));
                labelHome.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/home.png")));
                labelHome.setHorizontalAlignment(SwingConstants.CENTER);
                labelHome.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelHome.setForeground(Color.white);
                labelHome.setIconTextGap(20);

                //---- labelAdd ----
                labelAdd.setBackground(new Color(32, 32, 82));
                labelAdd.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/add.png")));
                labelAdd.setHorizontalAlignment(SwingConstants.CENTER);
                labelAdd.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelAdd.setForeground(Color.white);
                labelAdd.setIconTextGap(30);

                //---- labelView ----
                labelView.setBackground(new Color(32, 32, 82));
                labelView.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/list.png")));
                labelView.setHorizontalAlignment(SwingConstants.CENTER);
                labelView.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelView.setForeground(Color.white);
                labelView.setIconTextGap(10);

                //---- labelLogout ----
                labelLogout.setBackground(new Color(32, 32, 82));
                labelLogout.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/logout.png")));
                labelLogout.setHorizontalAlignment(SwingConstants.CENTER);
                labelLogout.setForeground(Color.white);
                labelLogout.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelLogout.setIconTextGap(10);

                //---- labelSettings ----
                labelSettings.setBackground(new Color(32, 32, 82));
                labelSettings.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/settings.png")));
                labelSettings.setHorizontalAlignment(SwingConstants.CENTER);

                //---- labelLogo ----
                labelLogo.setBackground(new Color(32, 32, 82));
                labelLogo.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/tooth_white.png")));
                labelLogo.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout panelShrinkedNavLayout = new GroupLayout(panelShrinkedNav);
                panelShrinkedNav.setLayout(panelShrinkedNavLayout);
                panelShrinkedNavLayout.setHorizontalGroup(
                    panelShrinkedNavLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelShrinkedNavLayout.createSequentialGroup()
                            .addGroup(panelShrinkedNavLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelSettings, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelShrinkedNavLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(panelShrinkedNavLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelView, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelAdd, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelHome, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelLogout, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap())
                );
                panelShrinkedNavLayout.setVerticalGroup(
                    panelShrinkedNavLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelShrinkedNavLayout.createSequentialGroup()
                            .addComponent(labelHome, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelAdd, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelView, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelLogout, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSettings, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            panelShrinked.add(panelShrinkedNav, new GridConstraints(0, 0, 2, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== panelButtonContainer2 ========
            {
                panelButtonContainer2.setBackground(Color.white);
                panelButtonContainer2.setLayout(new GridBagLayout());
                ((GridBagLayout)panelButtonContainer2.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panelButtonContainer2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panelButtonContainer2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panelButtonContainer2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //======== panelExpand ========
                {
                    panelExpand.setBackground(new Color(32, 32, 82));

                    //---- labelExpand ----
                    labelExpand.setBackground(new Color(32, 32, 82));
                    labelExpand.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/arrow_right.png")));
                    labelExpand.setHorizontalAlignment(SwingConstants.CENTER);
                    labelExpand.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            labelExpandMouseClicked(e);
                        }
                    });

                    GroupLayout panelExpandLayout = new GroupLayout(panelExpand);
                    panelExpand.setLayout(panelExpandLayout);
                    panelExpandLayout.setHorizontalGroup(
                        panelExpandLayout.createParallelGroup()
                            .addGroup(panelExpandLayout.createSequentialGroup()
                                .addComponent(labelExpand, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                    );
                    panelExpandLayout.setVerticalGroup(
                        panelExpandLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelExpandLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelExpand, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                    );
                }
                panelButtonContainer2.add(panelExpand, new GridBagConstraints(0, 5, 1, 5, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- labelFake ----
                labelFake.setText(" ");
                labelFake.setMinimumSize(new Dimension(120, 16));
                labelFake.setPreferredSize(new Dimension(120, 16));
                panelButtonContainer2.add(labelFake, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
            }
            panelShrinked.add(panelButtonContainer2, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        add(panelShrinked, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== scrollPane1 ========
        {
            scrollPane1.setBackground(Color.white);
            scrollPane1.setForeground(Color.white);
            scrollPane1.setBorder(null);

            //======== panelBody ========
            {
                panelBody.setBackground(Color.white);
                panelBody.setAutoscrolls(true);
                panelBody.setBorder(new EmptyBorder(0, 20, 10, 30));
                panelBody.setLayout(new TableLayout(new double[][] {
                    {TableLayout.PREFERRED, TableLayout.FILL, 20},
                    {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 20, TableLayout.FILL, TableLayout.PREFERRED}}));
                ((TableLayout)panelBody.getLayout()).setHGap(5);

                //======== panelSearchHeader ========
                {
                    panelSearchHeader.setBackground(Color.white);
                    panelSearchHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, 980},
                        {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
                    ((TableLayout)panelSearchHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelSearchHeader.getLayout()).setVGap(5);

                    //---- textSearchEmp ----
                    textSearchEmp.setText("Search Employees");
                    textSearchEmp.setFont(new Font("Alike", Font.BOLD, 26));
                    textSearchEmp.setForeground(new Color(32, 32, 82));
                    panelSearchHeader.add(textSearchEmp, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelSearchHeader, new TableLayoutConstraints(0, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelSearchBy ========
                {
                    panelSearchBy.setBackground(Color.white);
                    panelSearchBy.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, 30, TableLayout.FILL, 30, TableLayout.FILL},
                        {TableLayout.PREFERRED, 50, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 10, TableLayout.PREFERRED, 20}}));
                    ((TableLayout)panelSearchBy.getLayout()).setHGap(5);
                    ((TableLayout)panelSearchBy.getLayout()).setVGap(5);

                    //---- labelRegDate ----
                    labelRegDate.setText("Registration Date");
                    labelRegDate.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelRegDate.setForeground(Color.black);
                    panelSearchBy.add(labelRegDate, new TableLayoutConstraints(4, 0, 4, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- textFieldID ----
                    textFieldID.setBackground(Color.white);
                    textFieldID.setForeground(Color.gray);
                    textFieldID.setFont(new Font("Helvetica-Normal", Font.PLAIN, 15));
                    textFieldID.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Employee ID", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldID.setText("e.g. 180967");
                    textFieldID.setMinimumSize(new Dimension(64, 55));
                    textFieldID.setPreferredSize(new Dimension(95, 60));
                    textFieldID.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            textFieldIDFocusGained(e);
                        }
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldIDFocusLost(e);
                        }
                    });
                    panelSearchBy.add(textFieldID, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer3 ----
                    hSpacer3.setBackground(new Color(60, 63, 65, 0));
                    panelSearchBy.add(hSpacer3, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldName ----
                    textFieldName.setBackground(Color.white);
                    textFieldName.setForeground(Color.gray);
                    textFieldName.setFont(new Font("Helvetica-Normal", Font.PLAIN, 15));
                    textFieldName.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Employee Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldName.setText("e.g. John Doe");
                    textFieldName.setMinimumSize(new Dimension(64, 55));
                    textFieldName.setPreferredSize(new Dimension(95, 60));
                    textFieldName.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            textFieldNameFocusGained(e);
                        }
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldNameFocusLost(e);
                        }
                    });
                    panelSearchBy.add(textFieldName, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer4 ----
                    hSpacer4.setBackground(new Color(60, 63, 65, 0));
                    panelSearchBy.add(hSpacer4, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelRegDate ========
                    {
                        panelRegDate.setBackground(Color.gray);
                        panelRegDate.setLayout(new BorderLayout());
                    }
                    panelSearchBy.add(panelRegDate, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer1 ----
                    vSpacer1.setBackground(new Color(60, 63, 65, 0));
                    panelSearchBy.add(vSpacer1, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelJob ----
                    labelJob.setText("Job Title");
                    labelJob.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelJob.setForeground(Color.black);
                    panelSearchBy.add(labelJob, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- labelDepartment ----
                    labelDepartment.setText("Department");
                    labelDepartment.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelDepartment.setForeground(Color.black);
                    panelSearchBy.add(labelDepartment, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- comboBoxJobTitle ----
                    comboBoxJobTitle.setBackground(Color.white);
                    comboBoxJobTitle.setForeground(new Color(32, 32, 82));
                    comboBoxJobTitle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    comboBoxJobTitle.setPreferredSize(new Dimension(93, 47));
                    comboBoxJobTitle.setMinimumSize(new Dimension(99, 47));
                    panelSearchBy.add(comboBoxJobTitle, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxDepartment ----
                    comboBoxDepartment.setBackground(Color.white);
                    comboBoxDepartment.setForeground(new Color(32, 32, 82));
                    comboBoxDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    comboBoxDepartment.setPreferredSize(new Dimension(93, 47));
                    comboBoxDepartment.setMinimumSize(new Dimension(99, 47));
                    panelSearchBy.add(comboBoxDepartment, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer2 ----
                    vSpacer2.setBackground(new Color(60, 63, 65, 0));
                    panelSearchBy.add(vSpacer2, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelSearchButtons ========
                    {
                        panelSearchButtons.setBackground(new Color(60, 63, 65, 0));
                        panelSearchButtons.setLayout(new TableLayout(new double[][] {
                            {TableLayout.PREFERRED, 120, TableLayout.PREFERRED, 120, TableLayout.PREFERRED},
                            {35}}));
                        ((TableLayout)panelSearchButtons.getLayout()).setHGap(5);
                        ((TableLayout)panelSearchButtons.getLayout()).setVGap(5);

                        //---- hSpacer5 ----
                        hSpacer5.setBackground(new Color(60, 63, 65, 0));
                        panelSearchButtons.add(hSpacer5, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- buttonSearch ----
                        buttonSearch.setText("Search");
                        buttonSearch.setBackground(new Color(32, 32, 82));
                        buttonSearch.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        buttonSearch.setForeground(Color.white);
                        buttonSearch.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                buttonSearchMouseClicked(e);
                            }
                        });
                        panelSearchButtons.add(buttonSearch, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- hSpacer6 ----
                        hSpacer6.setBackground(new Color(60, 63, 65, 0));
                        panelSearchButtons.add(hSpacer6, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- buttonReset ----
                        buttonReset.setText("Reset");
                        buttonReset.setBackground(new Color(32, 32, 82));
                        buttonReset.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        buttonReset.setForeground(Color.white);
                        buttonReset.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                buttonResetMouseClicked(e);
                            }
                        });
                        panelSearchButtons.add(buttonReset, new TableLayoutConstraints(3, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- hSpacer7 ----
                        hSpacer7.setBackground(new Color(60, 63, 65, 0));
                        panelSearchButtons.add(hSpacer7, new TableLayoutConstraints(4, 0, 4, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    }
                    panelSearchBy.add(panelSearchButtons, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer3 ----
                    vSpacer3.setBackground(new Color(60, 63, 65, 0));
                    panelSearchBy.add(vSpacer3, new TableLayoutConstraints(2, 7, 2, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelSearchBy, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- hSpacer8 ----
                hSpacer8.setBackground(new Color(60, 63, 65, 0));
                panelBody.add(hSpacer8, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- separatorSearch ----
                separatorSearch.setForeground(Color.black);
                panelBody.add(separatorSearch, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));

                //---- vSpacer4 ----
                vSpacer4.setBackground(new Color(60, 63, 65, 0));
                panelBody.add(vSpacer4, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== scrollPaneTable ========
                {
                    scrollPaneTable.setBackground(Color.white);

                    //---- tableEmployees ----
                    tableEmployees.setBackground(Color.white);
                    tableEmployees.setGridColor(Color.lightGray);
                    tableEmployees.setForeground(Color.black);
                    tableEmployees.setSelectionBackground(new Color(204, 204, 255));
                    tableEmployees.setSelectionForeground(Color.black);
                    tableEmployees.setBorder(new LineBorder(Color.lightGray));
                    tableEmployees.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    tableEmployees.setRowHeight(40);
                    tableEmployees.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "ID", "Name", "Phone", "Job", "Department", "Room"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    scrollPaneTable.setViewportView(tableEmployees);
                }
                panelBody.add(scrollPaneTable, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- hSpacer1 ----
                hSpacer1.setBackground(new Color(60, 63, 65, 0));
                panelBody.add(hSpacer1, new TableLayoutConstraints(2, 0, 2, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelFooter ========
                {
                    panelFooter.setBackground(Color.white);
                    panelFooter.setLayout(null);

                    //---- buttonPrint ----
                    buttonPrint.setText("Print");
                    buttonPrint.setBackground(new Color(32, 32, 82));
                    buttonPrint.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    buttonPrint.setForeground(Color.white);
                    panelFooter.add(buttonPrint);
                    buttonPrint.setBounds(5, 45, 145, 30);

                    //---- labelTooth ----
                    labelTooth.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/tooth_purple.png")));
                    panelFooter.add(labelTooth);
                    labelTooth.setBounds(75, -55, 110, 140);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panelFooter.getComponentCount(); i++) {
                            Rectangle bounds = panelFooter.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panelFooter.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panelFooter.setMinimumSize(preferredSize);
                        panelFooter.setPreferredSize(preferredSize);
                    }
                }
                panelBody.add(panelFooter, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.RIGHT, TableLayoutConstraints.BOTTOM));
            }
            scrollPane1.setViewportView(panelBody);
        }
        add(scrollPane1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        datePicker = new DatePicker();
        datePicker.setBackground(Color.white);
        datePicker.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
        panelRegDate.add(datePicker);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for(int i=0; i < tableEmployees.getModel().getColumnCount(); i++) {
            tableEmployees.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dania
    private JPanel panelExpanded;
    private JPanel panelExpandedNav;
    private JLabel labelHome2;
    private JLabel labelAdd2;
    private JLabel labelView2;
    private JLabel labelLogout2;
    private JLabel labelSettings2;
    private JLabel labelLogo2;
    private JPanel panelButtonContainer;
    private JPanel panelShrink;
    private JLabel labelShrink;
    private JPanel panelShrinked;
    private JPanel panelShrinkedNav;
    private JLabel labelHome;
    private JLabel labelAdd;
    private JLabel labelView;
    private JLabel labelLogout;
    private JLabel labelSettings;
    private JLabel labelLogo;
    private JPanel panelButtonContainer2;
    private JPanel panelExpand;
    private JLabel labelExpand;
    private JLabel labelFake;
    private JScrollPane scrollPane1;
    private JPanel panelBody;
    private JPanel panelSearchHeader;
    private JLabel textSearchEmp;
    private JPanel panelSearchBy;
    private JLabel labelRegDate;
    private JTextField textFieldID;
    private JPanel hSpacer3;
    private JTextField textFieldName;
    private JPanel hSpacer4;
    private JPanel panelRegDate;
    private JPanel vSpacer1;
    private JLabel labelJob;
    private JLabel labelDepartment;
    private JComboBox comboBoxJobTitle;
    private JComboBox comboBoxDepartment;
    private JPanel vSpacer2;
    private JPanel panelSearchButtons;
    private JPanel hSpacer5;
    private JButton buttonSearch;
    private JPanel hSpacer6;
    private JButton buttonReset;
    private JPanel hSpacer7;
    private JPanel vSpacer3;
    private JPanel hSpacer8;
    private JSeparator separatorSearch;
    private JPanel vSpacer4;
    private JScrollPane scrollPaneTable;
    private JTable tableEmployees;
    private JPanel hSpacer1;
    private JPanel panelFooter;
    private JButton buttonPrint;
    private JLabel labelTooth;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static JFrame frame = new JFrame("Home Frame");
    private DatePicker datePicker;
    private C_Employee employeeController = new C_Employee();
    private List<M_Employee> employees = new ArrayList<>();
}
