/*
 * Created by JFormDesigner on Thu Nov 28 18:26:30 EET 2019
 */

package com.example.clinicsystem.views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

import com.example.clinicsystem.controllers.C_Appointment;
import com.example.clinicsystem.models.enums.DentistryDepartment;
import com.github.lgooddatepicker.components.DatePicker;
import com.intellij.uiDesigner.core.*;
import info.clearthought.layout.*;

/**
 * @author Dania
 */
public class V_AddAppointment extends JPanel {
    public V_AddAppointment() {
        initComponents();

        for (DentistryDepartment department : DentistryDepartment.values()) {
            comboBoxDepartment.addItem(department.getName());
        }
        comboBoxDentist.addItem("Doctor1");
        comboBoxDentist.addItem("Doctor2");
        comboBoxDentist.addItem("Doctor3");

        comboBoxAType.addItem("Phone");
        comboBoxAType.addItem("Front-desk");

        comboBoxTime.addItem("09:30 AM");
        comboBoxTime.addItem("11:00 AM");
        comboBoxTime.addItem("12:30 PM");
        comboBoxTime.addItem("01:00 PM");
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

    private void buttonReserveMouseClicked(MouseEvent e) {
        List list = new ArrayList<>();
        list.add(textFieldPatient.getText());
        list.add(comboBoxDentist.getSelectedItem().toString());
        list.add(comboBoxDepartment.getSelectedItem().toString());
        list.add(datePicker.getDate().toString());

        if(comboBoxAType.getSelectedItem().equals("Phone")){
            list.add(true);
        }
        else{
            list.add(false);
        }

        list.add(comboBoxTime.getSelectedItem().toString());
        appointmentController.request("C", list);
    }
    private void textFieldPatientFocusGained(FocusEvent e) {

        if(textFieldPatient.getText().equals("e.g. 182732")){

            textFieldPatient.setText("");
            textFieldPatient.setForeground(Color.black);
        }
    }

    private void textFieldPatientFocusLost(FocusEvent e) {

        if(textFieldPatient.getText().equals("")){

            textFieldPatient.setText("e.g. 182732");
            textFieldPatient.setForeground(Color.gray);
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
        panelAppointmentHeader = new JPanel();
        textEmpInfo = new JLabel();
        separatorEmp = new JSeparator();
        panelAppointmentBody = new JPanel();
        labelDepartment = new JLabel();
        labelType = new JLabel();
        comboBoxDepartment = new JComboBox();
        comboBoxAType = new JComboBox();
        vSpacer7 = new JPanel(null);
        labelDentist = new JLabel();
        comboBoxDentist = new JComboBox();
        hSpacer1 = new JPanel(null);
        textFieldPatient = new JTextField();
        labelFNError = new JLabel();
        labelMNError = new JLabel();
        vSpacer2 = new JPanel(null);
        labelDOR = new JLabel();
        labelTime = new JLabel();
        panelDate = new JPanel();
        comboBoxTime = new JComboBox();
        panelFooter = new JPanel();
        buttonReserve = new JButton();
        labelTooth = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(1920, 1080));
        setPreferredSize(new Dimension(1920, 1200));
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );
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
                labelAdd2.setText("Add");
                labelAdd2.setIconTextGap(30);
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
                            .addGroup(panelExpandedNavLayout.createParallelGroup()
                                .addGroup(panelExpandedNavLayout.createSequentialGroup()
                                    .addComponent(labelLogo2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                    .addComponent(labelSettings2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panelExpandedNavLayout.createSequentialGroup()
                                    .addGroup(panelExpandedNavLayout.createParallelGroup()
                                        .addComponent(labelLogout2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelView2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelAdd2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelHome2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())))
                );
                panelExpandedNavLayout.setVerticalGroup(
                    panelExpandedNavLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelExpandedNavLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(labelHome2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelAdd2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelView2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelLogout2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 796, Short.MAX_VALUE)
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
                labelAdd.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/edit.png")));
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
                    {TableLayout.FILL},
                    {92, TableLayout.PREFERRED, TableLayout.FILL}}));
                ((TableLayout)panelBody.getLayout()).setHGap(5);
                ((TableLayout)panelBody.getLayout()).setVGap(5);

                //======== panelAppointmentHeader ========
                {
                    panelAppointmentHeader.setBackground(Color.white);
                    panelAppointmentHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93, TableLayout.PREFERRED}}));
                    ((TableLayout)panelAppointmentHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelAppointmentHeader.getLayout()).setVGap(5);

                    //---- textEmpInfo ----
                    textEmpInfo.setText("Appointment info");
                    textEmpInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textEmpInfo.setForeground(Color.black);
                    panelAppointmentHeader.add(textEmpInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelAppointmentHeader.add(separatorEmp, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelAppointmentHeader, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelAppointmentBody ========
                {
                    panelAppointmentBody.setBackground(Color.white);
                    panelAppointmentBody.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, 50, TableLayout.PREFERRED, 30, TableLayout.PREFERRED, 50, TableLayout.PREFERRED, 30, TableLayout.PREFERRED, 50}}));
                    ((TableLayout)panelAppointmentBody.getLayout()).setHGap(5);
                    ((TableLayout)panelAppointmentBody.getLayout()).setVGap(5);

                    //---- labelDepartment ----
                    labelDepartment.setText("Department");
                    labelDepartment.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelDepartment.setForeground(Color.black);
                    panelAppointmentBody.add(labelDepartment, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- labelType ----
                    labelType.setText("Appointment Type");
                    labelType.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelType.setForeground(Color.black);
                    panelAppointmentBody.add(labelType, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- comboBoxDepartment ----
                    comboBoxDepartment.setBackground(Color.white);
                    comboBoxDepartment.setForeground(new Color(32, 32, 82));
                    comboBoxDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelAppointmentBody.add(comboBoxDepartment, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxAType ----
                    comboBoxAType.setBackground(Color.white);
                    comboBoxAType.setForeground(new Color(32, 32, 82));
                    comboBoxAType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelAppointmentBody.add(comboBoxAType, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer7 ----
                    vSpacer7.setBackground(Color.white);
                    vSpacer7.setPreferredSize(new Dimension(50, 10));
                    vSpacer7.setMinimumSize(new Dimension(50, 10));
                    panelAppointmentBody.add(vSpacer7, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelDentist ----
                    labelDentist.setText("Dentist");
                    labelDentist.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelDentist.setForeground(Color.black);
                    panelAppointmentBody.add(labelDentist, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- comboBoxDentist ----
                    comboBoxDentist.setBackground(Color.white);
                    comboBoxDentist.setForeground(new Color(32, 32, 82));
                    comboBoxDentist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelAppointmentBody.add(comboBoxDentist, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer1 ----
                    hSpacer1.setBackground(Color.white);
                    hSpacer1.setMinimumSize(new Dimension(30, 12));
                    hSpacer1.setPreferredSize(new Dimension(50, 10));
                    panelAppointmentBody.add(hSpacer1, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldPatient ----
                    textFieldPatient.setBackground(Color.white);
                    textFieldPatient.setForeground(Color.gray);
                    textFieldPatient.setFont(new Font("Helvetica-Normal", Font.PLAIN, 15));
                    textFieldPatient.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Patient ID", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldPatient.setText("e.g. 182732");
                    textFieldPatient.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            textFieldPatientFocusGained(e);
                        }
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldPatientFocusLost(e);
                        }
                    });
                    panelAppointmentBody.add(textFieldPatient, new TableLayoutConstraints(2, 5, 2, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelFNError ----
                    labelFNError.setForeground(new Color(191, 44, 39));
                    labelFNError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelFNError.setBackground(Color.white);
                    panelAppointmentBody.add(labelFNError, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelMNError ----
                    labelMNError.setForeground(new Color(191, 44, 39));
                    labelMNError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelMNError.setBackground(Color.white);
                    panelAppointmentBody.add(labelMNError, new TableLayoutConstraints(2, 6, 2, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer2 ----
                    vSpacer2.setBackground(Color.white);
                    vSpacer2.setPreferredSize(new Dimension(50, 10));
                    vSpacer2.setMinimumSize(new Dimension(50, 10));
                    panelAppointmentBody.add(vSpacer2, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelDOR ----
                    labelDOR.setText("Date");
                    labelDOR.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelDOR.setForeground(Color.black);
                    panelAppointmentBody.add(labelDOR, new TableLayoutConstraints(0, 8, 0, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- labelTime ----
                    labelTime.setText("Available Time");
                    labelTime.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelTime.setForeground(Color.black);
                    panelAppointmentBody.add(labelTime, new TableLayoutConstraints(2, 8, 2, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //======== panelDate ========
                    {
                        panelDate.setBackground(Color.gray);
                        panelDate.setLayout(new BorderLayout());
                    }
                    panelAppointmentBody.add(panelDate, new TableLayoutConstraints(0, 9, 0, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxTime ----
                    comboBoxTime.setBackground(Color.white);
                    comboBoxTime.setForeground(new Color(32, 32, 82));
                    comboBoxTime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelAppointmentBody.add(comboBoxTime, new TableLayoutConstraints(2, 9, 2, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelAppointmentBody, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelFooter ========
                {
                    panelFooter.setBackground(Color.white);
                    panelFooter.setLayout(null);

                    //---- buttonReserve ----
                    buttonReserve.setText("Reserve Appointment");
                    buttonReserve.setBackground(new Color(32, 32, 82));
                    buttonReserve.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    buttonReserve.setForeground(Color.white);
                    buttonReserve.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonReserveMouseClicked(e);
                        }
                    });
                    panelFooter.add(buttonReserve);
                    buttonReserve.setBounds(0, 105, 190, 35);

                    //---- labelTooth ----
                    labelTooth.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/tooth_purple.png")));
                    panelFooter.add(labelTooth);
                    labelTooth.setBounds(90, 5, 100, 144);

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
                panelBody.add(panelFooter, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.RIGHT, TableLayoutConstraints.BOTTOM));
            }
            scrollPane1.setViewportView(panelBody);
        }
        add(scrollPane1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        datePicker = new DatePicker();
        datePicker.setBackground(Color.white);
        datePicker.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
        panelDate.add(datePicker);
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
    private JPanel panelAppointmentHeader;
    private JLabel textEmpInfo;
    private JSeparator separatorEmp;
    private JPanel panelAppointmentBody;
    private JLabel labelDepartment;
    private JLabel labelType;
    private JComboBox comboBoxDepartment;
    private JComboBox comboBoxAType;
    private JPanel vSpacer7;
    private JLabel labelDentist;
    private JComboBox comboBoxDentist;
    private JPanel hSpacer1;
    private JTextField textFieldPatient;
    private JLabel labelFNError;
    private JLabel labelMNError;
    private JPanel vSpacer2;
    private JLabel labelDOR;
    private JLabel labelTime;
    private JPanel panelDate;
    private JComboBox comboBoxTime;
    private JPanel panelFooter;
    private JButton buttonReserve;
    private JLabel labelTooth;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    DatePicker datePicker;
    public static JFrame frame = new JFrame("Home Frame");
    C_Appointment appointmentController = new C_Appointment();
}
