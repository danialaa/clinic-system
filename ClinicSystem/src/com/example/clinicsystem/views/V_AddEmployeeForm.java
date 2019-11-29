/*
 * Created by JFormDesigner on Thu Nov 28 18:41:15 EET 2019
 */

package com.example.clinicsystem.views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

import com.example.clinicsystem.ClinicSystem;
import com.example.clinicsystem.controllers.C_Employee;
import com.github.lgooddatepicker.components.DatePicker;
import com.intellij.uiDesigner.core.*;
import info.clearthought.layout.*;

/**
 * @author Dania
 */
public class V_AddEmployeeForm extends JPanel {
    public V_AddEmployeeForm() {
        initComponents();
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

    private void radioButtonFemaleMouseClicked(MouseEvent e) {
        if(radioButtonFemale.isSelected()) {
            radioButtonMale.setSelected(false);
        }
    }

    private void radioButtonMaleMouseClicked(MouseEvent e) {
        if(radioButtonMale.isSelected()) {
            radioButtonFemale.setSelected(false);
        }
    }

    private void comboBoxGovItemStateChanged(ItemEvent e) {
        comboBoxCity.removeAllItems();

        if(comboBoxGov.getSelectedItem().equals(ClinicSystem.governorates.get(0))) {
            for(int i = 0; i< ClinicSystem.cairoCities.size(); i++) {
                comboBoxCity.addItem(ClinicSystem.cairoCities.get(i));
            }
        } else if (comboBoxGov.getSelectedItem().equals(ClinicSystem.governorates.get(1))) {
            for(int i=0; i< ClinicSystem.alexCities.size(); i++) {
                comboBoxCity.addItem(ClinicSystem.alexCities.get(i));
            }
        }
    }

    private void buttonAddEmpMouseClicked(MouseEvent e) {
        List<JTextField> textFieldList = new ArrayList<>();
        textFieldList.add(textFieldWID);
        textFieldList.add(textFieldFN);
        textFieldList.add(textFieldMN);
        textFieldList.add(textFieldLN);
        textFieldList.add(textFieldPhone);
        textFieldList.add(textFieldLEmail);
        textFieldList.add(textFieldID);
        textFieldList.add(textFieldApt);
        textFieldList.add(textFieldStreet);

        List<JLabel> labelList = new ArrayList<>();
        labelList.add(labelWIDError);
        labelList.add(labelFNError);
        labelList.add(labelMNError);
        labelList.add(labelLNError);
        labelList.add(labelPhoneError);
        labelList.add(labelEmailError);
        labelList.add(labelIDError);
        labelList.add(labelAptError);
        labelList.add(labelStreetError);

        if(employeeController.isValidEmployeeData(textFieldList, labelList)) {
            List<String> data = new ArrayList<>();

            data.add(textFieldApt.getText());
            data.add(comboBoxCity.getSelectedItem().toString());
            data.add(comboBoxGov.getSelectedItem().toString());
            data.add(textFieldStreet.getText());
            data.add(datePicker.getDate().toString());
            data.add(textFieldFN.getText());
            data.add(textFieldMN.getText());
            data.add(textFieldLN.getText());
            data.add(textFieldPhone.getText());
            data.add(textFieldID.getText());

            if(radioButtonFemale.isSelected()) {
                data.add("Female");
            } else {
                data.add("Male");
            }

            data.add(textFieldWID.getText());
            data.add(textFieldLEmail.getText());

            employeeController.request("C", data);
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
        panelEmployeeHeader = new JPanel();
        textEmpInfo = new JLabel();
        separatorEmp = new JSeparator();
        panelEmpBody = new JPanel();
        textFieldWID = new JTextField();
        labelWIDError = new JLabel();
        vSpacer7 = new JPanel(null);
        textFieldFN = new JTextField();
        hSpacer1 = new JPanel(null);
        textFieldMN = new JTextField();
        hSpacer2 = new JPanel(null);
        textFieldLN = new JTextField();
        labelFNError = new JLabel();
        labelMNError = new JLabel();
        labelLNError = new JLabel();
        vSpacer2 = new JPanel(null);
        labelDOB = new JLabel();
        textFieldPhone = new JTextField();
        panelBirth = new JPanel();
        textFieldLEmail = new JTextField();
        labelPhoneError = new JLabel();
        labelEmailError = new JLabel();
        vSpacer3 = new JPanel(null);
        labelJob = new JLabel();
        labelDepartment = new JLabel();
        textFieldID = new JTextField();
        comboBoxJob = new JComboBox();
        comboBoxDepartment = new JComboBox();
        labelIDError = new JLabel();
        vSpacer4 = new JPanel(null);
        panelGender = new JPanel();
        labelGender = new JLabel();
        radioButtonFemale = new JRadioButton();
        radioButtonMale = new JRadioButton();
        panelAddressHeader = new JPanel();
        textAddressInfo = new JLabel();
        separatorAddress = new JSeparator();
        panelAddBody = new JPanel();
        labelGov = new JLabel();
        labelCity = new JLabel();
        comboBoxGov = new JComboBox();
        hSpacer3 = new JPanel(null);
        comboBoxCity = new JComboBox();
        hSpacer4 = new JPanel(null);
        panelFake = new JPanel();
        vSpacer5 = new JPanel(null);
        textFieldStreet = new JTextField();
        labelStreetError = new JLabel();
        vSpacer6 = new JPanel(null);
        textFieldApt = new JTextField();
        labelAptError = new JLabel();
        panelFooter = new JPanel();
        buttonAddEmp = new JButton();
        labelTooth = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(1920, 1080));
        setPreferredSize(new Dimension(1920, 1200));
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
        EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing
        . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
        java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
        { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )
        throw new RuntimeException( ) ;} } );
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
                    {92, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL}}));
                ((TableLayout)panelBody.getLayout()).setHGap(5);
                ((TableLayout)panelBody.getLayout()).setVGap(5);

                //======== panelEmployeeHeader ========
                {
                    panelEmployeeHeader.setBackground(Color.white);
                    panelEmployeeHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93}}));
                    ((TableLayout)panelEmployeeHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelEmployeeHeader.getLayout()).setVGap(5);

                    //---- textEmpInfo ----
                    textEmpInfo.setText("Empolyee info");
                    textEmpInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textEmpInfo.setForeground(Color.black);
                    panelEmployeeHeader.add(textEmpInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelEmployeeHeader.add(separatorEmp, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelEmployeeHeader, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelEmpBody ========
                {
                    panelEmpBody.setBackground(Color.white);
                    panelEmpBody.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED, 30, 50}}));
                    ((TableLayout)panelEmpBody.getLayout()).setHGap(5);
                    ((TableLayout)panelEmpBody.getLayout()).setVGap(5);

                    //---- textFieldWID ----
                    textFieldWID.setBackground(Color.white);
                    textFieldWID.setForeground(Color.black);
                    textFieldWID.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldWID.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Employee ID", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelEmpBody.add(textFieldWID, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelWIDError ----
                    labelWIDError.setForeground(new Color(191, 44, 39));
                    labelWIDError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelWIDError.setBackground(Color.white);
                    panelEmpBody.add(labelWIDError, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer7 ----
                    vSpacer7.setBackground(Color.white);
                    vSpacer7.setPreferredSize(new Dimension(50, 10));
                    vSpacer7.setMinimumSize(new Dimension(50, 10));
                    panelEmpBody.add(vSpacer7, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldFN ----
                    textFieldFN.setBackground(Color.white);
                    textFieldFN.setForeground(Color.black);
                    textFieldFN.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldFN.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "First Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelEmpBody.add(textFieldFN, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer1 ----
                    hSpacer1.setBackground(Color.white);
                    hSpacer1.setMinimumSize(new Dimension(30, 12));
                    hSpacer1.setPreferredSize(new Dimension(50, 10));
                    panelEmpBody.add(hSpacer1, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldMN ----
                    textFieldMN.setBackground(Color.white);
                    textFieldMN.setForeground(Color.black);
                    textFieldMN.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldMN.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Middle Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelEmpBody.add(textFieldMN, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer2 ----
                    hSpacer2.setBackground(Color.white);
                    hSpacer2.setMinimumSize(new Dimension(30, 12));
                    hSpacer2.setPreferredSize(new Dimension(50, 10));
                    panelEmpBody.add(hSpacer2, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldLN ----
                    textFieldLN.setBackground(Color.white);
                    textFieldLN.setForeground(Color.black);
                    textFieldLN.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldLN.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Last Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelEmpBody.add(textFieldLN, new TableLayoutConstraints(4, 3, 4, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelFNError ----
                    labelFNError.setForeground(new Color(191, 44, 39));
                    labelFNError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelFNError.setBackground(Color.white);
                    panelEmpBody.add(labelFNError, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelMNError ----
                    labelMNError.setForeground(new Color(191, 44, 39));
                    labelMNError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelMNError.setBackground(Color.white);
                    panelEmpBody.add(labelMNError, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelLNError ----
                    labelLNError.setForeground(new Color(191, 44, 39));
                    labelLNError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelLNError.setBackground(Color.white);
                    panelEmpBody.add(labelLNError, new TableLayoutConstraints(4, 4, 4, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer2 ----
                    vSpacer2.setBackground(Color.white);
                    vSpacer2.setPreferredSize(new Dimension(50, 10));
                    vSpacer2.setMinimumSize(new Dimension(50, 10));
                    panelEmpBody.add(vSpacer2, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelDOB ----
                    labelDOB.setText("Date of Birth");
                    labelDOB.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelDOB.setForeground(Color.black);
                    panelEmpBody.add(labelDOB, new TableLayoutConstraints(2, 5, 2, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- textFieldPhone ----
                    textFieldPhone.setBackground(Color.white);
                    textFieldPhone.setForeground(Color.black);
                    textFieldPhone.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldPhone.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Phone Number", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelEmpBody.add(textFieldPhone, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelBirth ========
                    {
                        panelBirth.setBackground(Color.gray);
                        panelBirth.setLayout(new BorderLayout());
                    }
                    panelEmpBody.add(panelBirth, new TableLayoutConstraints(2, 6, 2, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldLEmail ----
                    textFieldLEmail.setBackground(Color.white);
                    textFieldLEmail.setForeground(Color.black);
                    textFieldLEmail.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldLEmail.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "E-mail", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelEmpBody.add(textFieldLEmail, new TableLayoutConstraints(4, 6, 4, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelPhoneError ----
                    labelPhoneError.setForeground(new Color(191, 44, 39));
                    labelPhoneError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelEmpBody.add(labelPhoneError, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelEmailError ----
                    labelEmailError.setForeground(new Color(191, 44, 39));
                    labelEmailError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelEmpBody.add(labelEmailError, new TableLayoutConstraints(4, 7, 4, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer3 ----
                    vSpacer3.setBackground(Color.white);
                    vSpacer3.setPreferredSize(new Dimension(50, 10));
                    vSpacer3.setMinimumSize(new Dimension(50, 10));
                    panelEmpBody.add(vSpacer3, new TableLayoutConstraints(0, 8, 0, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelJob ----
                    labelJob.setText("Job Title");
                    labelJob.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelJob.setForeground(Color.black);
                    panelEmpBody.add(labelJob, new TableLayoutConstraints(2, 8, 2, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- labelDepartment ----
                    labelDepartment.setText("Department");
                    labelDepartment.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelDepartment.setForeground(Color.black);
                    panelEmpBody.add(labelDepartment, new TableLayoutConstraints(4, 8, 4, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- textFieldID ----
                    textFieldID.setBackground(Color.white);
                    textFieldID.setForeground(Color.black);
                    textFieldID.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldID.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "National ID", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelEmpBody.add(textFieldID, new TableLayoutConstraints(0, 9, 0, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxJob ----
                    comboBoxJob.setBackground(Color.white);
                    comboBoxJob.setForeground(new Color(32, 32, 82));
                    comboBoxJob.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelEmpBody.add(comboBoxJob, new TableLayoutConstraints(2, 9, 2, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxDepartment ----
                    comboBoxDepartment.setBackground(Color.white);
                    comboBoxDepartment.setForeground(new Color(32, 32, 82));
                    comboBoxDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelEmpBody.add(comboBoxDepartment, new TableLayoutConstraints(4, 9, 4, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelIDError ----
                    labelIDError.setForeground(new Color(191, 44, 39));
                    labelIDError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelEmpBody.add(labelIDError, new TableLayoutConstraints(0, 10, 0, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer4 ----
                    vSpacer4.setBackground(Color.white);
                    vSpacer4.setPreferredSize(new Dimension(50, 10));
                    vSpacer4.setMinimumSize(new Dimension(50, 10));
                    panelEmpBody.add(vSpacer4, new TableLayoutConstraints(0, 11, 0, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelGender ========
                    {
                        panelGender.setBackground(Color.white);
                        panelGender.setLayout(new TableLayout(new double[][] {
                            {TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL},
                            {50}}));
                        ((TableLayout)panelGender.getLayout()).setHGap(5);
                        ((TableLayout)panelGender.getLayout()).setVGap(5);

                        //---- labelGender ----
                        labelGender.setText("Gender");
                        labelGender.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                        labelGender.setForeground(Color.black);
                        panelGender.add(labelGender, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- radioButtonFemale ----
                        radioButtonFemale.setText("Female");
                        radioButtonFemale.setBackground(Color.white);
                        radioButtonFemale.setForeground(Color.black);
                        radioButtonFemale.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                        radioButtonFemale.setSelected(true);
                        radioButtonFemale.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonFemaleMouseClicked(e);
                            }
                        });
                        panelGender.add(radioButtonFemale, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- radioButtonMale ----
                        radioButtonMale.setText("Male");
                        radioButtonMale.setBackground(Color.white);
                        radioButtonMale.setForeground(Color.black);
                        radioButtonMale.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                        radioButtonMale.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonMaleMouseClicked(e);
                            }
                        });
                        panelGender.add(radioButtonMale, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));
                    }
                    panelEmpBody.add(panelGender, new TableLayoutConstraints(0, 12, 0, 12, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelEmpBody, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelAddressHeader ========
                {
                    panelAddressHeader.setBackground(Color.white);
                    panelAddressHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93}}));
                    ((TableLayout)panelAddressHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelAddressHeader.getLayout()).setVGap(5);

                    //---- textAddressInfo ----
                    textAddressInfo.setText("Address info");
                    textAddressInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textAddressInfo.setForeground(Color.black);
                    panelAddressHeader.add(textAddressInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelAddressHeader.add(separatorAddress, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelAddressHeader, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelAddBody ========
                {
                    panelAddBody.setBackground(Color.white);
                    panelAddBody.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, 50, 30, 50, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED}}));
                    ((TableLayout)panelAddBody.getLayout()).setHGap(5);
                    ((TableLayout)panelAddBody.getLayout()).setVGap(5);

                    //---- labelGov ----
                    labelGov.setText("Governorate");
                    labelGov.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelGov.setForeground(Color.black);
                    panelAddBody.add(labelGov, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- labelCity ----
                    labelCity.setText("City");
                    labelCity.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelCity.setForeground(Color.black);
                    panelAddBody.add(labelCity, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxGov ----
                    comboBoxGov.setBackground(Color.white);
                    comboBoxGov.setForeground(new Color(32, 32, 82));
                    comboBoxGov.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    comboBoxGov.addItemListener(e -> comboBoxGovItemStateChanged(e));
                    panelAddBody.add(comboBoxGov, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer3 ----
                    hSpacer3.setBackground(Color.white);
                    hSpacer3.setMinimumSize(new Dimension(30, 12));
                    hSpacer3.setPreferredSize(new Dimension(50, 10));
                    panelAddBody.add(hSpacer3, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxCity ----
                    comboBoxCity.setBackground(Color.white);
                    comboBoxCity.setForeground(new Color(32, 32, 82));
                    comboBoxCity.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelAddBody.add(comboBoxCity, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer4 ----
                    hSpacer4.setBackground(Color.white);
                    hSpacer4.setMinimumSize(new Dimension(30, 12));
                    hSpacer4.setPreferredSize(new Dimension(50, 10));
                    panelAddBody.add(hSpacer4, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake ========
                    {
                        panelFake.setBackground(Color.white);

                        GroupLayout panelFakeLayout = new GroupLayout(panelFake);
                        panelFake.setLayout(panelFakeLayout);
                        panelFakeLayout.setHorizontalGroup(
                            panelFakeLayout.createParallelGroup()
                                .addGap(0, 280, Short.MAX_VALUE)
                        );
                        panelFakeLayout.setVerticalGroup(
                            panelFakeLayout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelAddBody.add(panelFake, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer5 ----
                    vSpacer5.setBackground(Color.white);
                    vSpacer5.setPreferredSize(new Dimension(50, 10));
                    vSpacer5.setMinimumSize(new Dimension(50, 10));
                    panelAddBody.add(vSpacer5, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldStreet ----
                    textFieldStreet.setBackground(Color.white);
                    textFieldStreet.setForeground(Color.black);
                    textFieldStreet.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldStreet.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Street", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelAddBody.add(textFieldStreet, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelStreetError ----
                    labelStreetError.setForeground(new Color(191, 44, 39));
                    labelStreetError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelStreetError.setBackground(Color.white);
                    panelAddBody.add(labelStreetError, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer6 ----
                    vSpacer6.setBackground(Color.white);
                    vSpacer6.setPreferredSize(new Dimension(50, 10));
                    vSpacer6.setMinimumSize(new Dimension(50, 10));
                    panelAddBody.add(vSpacer6, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldApt ----
                    textFieldApt.setBackground(Color.white);
                    textFieldApt.setForeground(Color.black);
                    textFieldApt.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldApt.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Apartment", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    panelAddBody.add(textFieldApt, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelAptError ----
                    labelAptError.setForeground(new Color(191, 44, 39));
                    labelAptError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelAptError.setBackground(Color.white);
                    panelAddBody.add(labelAptError, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelAddBody, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelFooter ========
                {
                    panelFooter.setBackground(Color.white);
                    panelFooter.setLayout(null);

                    //---- buttonAddEmp ----
                    buttonAddEmp.setText("ADD");
                    buttonAddEmp.setBackground(new Color(32, 32, 82));
                    buttonAddEmp.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    buttonAddEmp.setForeground(Color.white);
                    buttonAddEmp.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonAddEmpMouseClicked(e);
                        }
                    });
                    panelFooter.add(buttonAddEmp);
                    buttonAddEmp.setBounds(0, 105, 190, 35);

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
                panelBody.add(panelFooter, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.RIGHT, TableLayoutConstraints.BOTTOM));
            }
            scrollPane1.setViewportView(panelBody);
        }
        add(scrollPane1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        datePicker = new DatePicker();
        datePicker.setDateToToday();
        datePicker.setBackground(Color.white);
        datePicker.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
        panelBirth.add(datePicker);

        for(int i=0; i<ClinicSystem.governorates.size(); i++) {
            comboBoxGov.addItem(ClinicSystem.governorates.get(i));
        }

        for(int i=0; i<ClinicSystem.cairoCities.size(); i++) {
            comboBoxCity.addItem(ClinicSystem.cairoCities.get(i));
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
    private JPanel panelEmployeeHeader;
    private JLabel textEmpInfo;
    private JSeparator separatorEmp;
    private JPanel panelEmpBody;
    private JTextField textFieldWID;
    private JLabel labelWIDError;
    private JPanel vSpacer7;
    private JTextField textFieldFN;
    private JPanel hSpacer1;
    private JTextField textFieldMN;
    private JPanel hSpacer2;
    private JTextField textFieldLN;
    private JLabel labelFNError;
    private JLabel labelMNError;
    private JLabel labelLNError;
    private JPanel vSpacer2;
    private JLabel labelDOB;
    private JTextField textFieldPhone;
    private JPanel panelBirth;
    private JTextField textFieldLEmail;
    private JLabel labelPhoneError;
    private JLabel labelEmailError;
    private JPanel vSpacer3;
    private JLabel labelJob;
    private JLabel labelDepartment;
    private JTextField textFieldID;
    private JComboBox comboBoxJob;
    private JComboBox comboBoxDepartment;
    private JLabel labelIDError;
    private JPanel vSpacer4;
    private JPanel panelGender;
    private JLabel labelGender;
    private JRadioButton radioButtonFemale;
    private JRadioButton radioButtonMale;
    private JPanel panelAddressHeader;
    private JLabel textAddressInfo;
    private JSeparator separatorAddress;
    private JPanel panelAddBody;
    private JLabel labelGov;
    private JLabel labelCity;
    private JComboBox comboBoxGov;
    private JPanel hSpacer3;
    private JComboBox comboBoxCity;
    private JPanel hSpacer4;
    private JPanel panelFake;
    private JPanel vSpacer5;
    private JTextField textFieldStreet;
    private JLabel labelStreetError;
    private JPanel vSpacer6;
    private JTextField textFieldApt;
    private JLabel labelAptError;
    private JPanel panelFooter;
    private JButton buttonAddEmp;
    private JLabel labelTooth;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    DatePicker datePicker;
    public static JFrame frame = new JFrame("Home Frame");
    private C_Employee employeeController = new C_Employee();
}
