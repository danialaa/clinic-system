/*
 * Created by JFormDesigner on Thu Nov 28 18:37:00 EET 2019
 */

package com.example.clinicsystem.views;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

import com.example.clinicsystem.ClinicSystem;
import com.example.clinicsystem.controllers.C_Patient;
import com.example.clinicsystem.models.enums.DentistryDepartment;
import com.example.clinicsystem.models.enums.Gender;
import com.example.clinicsystem.models.enums.MedicalAlert;
import com.github.lgooddatepicker.components.DatePicker;
import com.intellij.uiDesigner.core.*;
import info.clearthought.layout.*;

/**
 * @author Dania
 */
public class V_AddPatientForm extends JPanel {
    public V_AddPatientForm() {
        initComponents();

        comboBoxDepartment.addItem("-");

        for (DentistryDepartment department : DentistryDepartment.values()) {
            comboBoxDepartment.addItem(department.getName());
        }
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
            for(int i=0; i< ClinicSystem.cairoCities.size(); i++) {
                comboBoxCity.addItem(ClinicSystem.cairoCities.get(i));
            }
        } else if (comboBoxGov.getSelectedItem().equals(ClinicSystem.governorates.get(1))) {
            for(int i=0; i< ClinicSystem.alexCities.size(); i++) {
                comboBoxCity.addItem(ClinicSystem.alexCities.get(i));
            }
        }
    }

    private void buttonAddPatientMouseClicked(MouseEvent e) {
        List<JTextField> textFields = new ArrayList<>();
        textFields.add(textFieldFN);
        textFields.add(textFieldMN);
        textFields.add(textFieldLN);
        textFields.add(textFieldPhone);
        textFields.add(textFieldID);
        textFields.add(textFieldStreet);
        textFields.add(textFieldApt);
        textFields.add(textFieldEmerName);
        textFields.add(textFieldEmerPhone);

        List<JLabel> labels = new ArrayList<>();
        labels.add(labelFNError);
        labels.add(labelMNError);
        labels.add(labelLNError);
        labels.add(labelPhoneError);
        labels.add(labelIDError);
        labels.add(labelStreetError);
        labels.add(labelAptError);
        labels.add(labelEmerNameError);
        labels.add(labelPhoneError);

        if(patientController.isValidPatient(textFields,labels)) {
            List data = new ArrayList<>();

            data.add(textFieldFN.getText());
            data.add(textFieldMN.getText());
            data.add(textFieldLN.getText());
            data.add(textFieldPhone.getText());
            data.add(datePicker.getDate().toString());
            data.add(textFieldID.getText());

            if(radioButtonFemale.isSelected()) {
                data.add(Gender.FEMALE);
            } else {
                data.add(Gender.MALE);
            }

            data.add(comboBoxGov.getSelectedItem().toString());
            data.add(comboBoxCity.getSelectedItem().toString());
            data.add(textFieldStreet.getText());
            data.add(textFieldApt.getText());
            data.add(textFieldEmerName.getText());
            data.add(comboBoxRelation.getSelectedItem().toString());
            data.add(textFieldEmerPhone.getText());
            data.add(comboBoxDepartment.getSelectedItem());

            if(checkBoxAllergies.isSelected()) {
                data.add(MedicalAlert.ALLERGIES);
            }
            if(checkBoxDiabetes.isSelected()) {
                data.add(MedicalAlert.DIABETES);
            }
            if(checkBoxAsthma.isSelected()) {
                data.add(MedicalAlert.ASTHMA);
            }
            if(checkBoxDrugs.isSelected()) {
                data.add(MedicalAlert.DRUGS);
            }
            if(checkBoxBP.isSelected()) {
                data.add(MedicalAlert.BLOOD_PRESSURE);
            }
            if(checkBoxAnemia.isSelected()) {
                data.add(MedicalAlert.ANEMIA);
            }
            if(checkBoxCancer.isSelected()) {
                data.add(MedicalAlert.CANCER);
            }
            if(checkBoxCardio.isSelected()) {
                data.add(MedicalAlert.CARDIOVASCULAR_DISEASES);
            }
            if(checkBoxHypertension.isSelected()) {
                data.add(MedicalAlert.HYPERTENSION);
            }
            if(checkBoxBD.isSelected()) {
                data.add(MedicalAlert.BLEEDING_DISORDERS);
            }

            patientController.request("C",data);
        }

        textFields.clear();
        labels.clear();
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
        panelPatientHeader = new JPanel();
        textPatientInfo = new JLabel();
        separatorPatient = new JSeparator();
        panelPatientBody = new JPanel();
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
        textFieldID = new JTextField();
        labelPhoneError = new JLabel();
        labelIDError = new JLabel();
        vSpacer3 = new JPanel(null);
        labelDepartment = new JLabel();
        panelGender = new JPanel();
        labelGender = new JLabel();
        radioButtonFemale = new JRadioButton();
        radioButtonMale = new JRadioButton();
        comboBoxDepartment = new JComboBox();
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
        panelEmerHeader = new JPanel();
        textEmergencyInfo = new JLabel();
        separatorAddress2 = new JSeparator();
        panelEmerBody = new JPanel();
        labelRelation = new JLabel();
        textFieldEmerName = new JTextField();
        hSpacer5 = new JPanel(null);
        comboBoxRelation = new JComboBox();
        hSpacer6 = new JPanel(null);
        panelFake2 = new JPanel();
        labelEmerNameError = new JLabel();
        vSpacer7 = new JPanel(null);
        textFieldEmerPhone = new JTextField();
        labelEmerPhoneError = new JLabel();
        panelMedHeader = new JPanel();
        textMedInfo = new JLabel();
        separatorMed = new JSeparator();
        panelMedBody = new JPanel();
        checkBoxAllergies = new JCheckBox();
        hSpacer7 = new JPanel(null);
        checkBoxDiabetes = new JCheckBox();
        hSpacer8 = new JPanel(null);
        checkBoxAsthma = new JCheckBox();
        checkBoxDrugs = new JCheckBox();
        hSpacer10 = new JPanel(null);
        checkBoxBP = new JCheckBox();
        vSpacer8 = new JPanel(null);
        checkBoxAnemia = new JCheckBox();
        checkBoxCancer = new JCheckBox();
        checkBoxCardio = new JCheckBox();
        checkBoxHypertension = new JCheckBox();
        vSpacer9 = new JPanel(null);
        checkBoxBD = new JCheckBox();
        panelFooter = new JPanel();
        buttonAddPatient = new JButton();
        labelTooth = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(1920, 1080));
        setPreferredSize(new Dimension(1920, 1200));
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
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
                    {TableLayout.FILL},
                    {92, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
                ((TableLayout)panelBody.getLayout()).setHGap(5);
                ((TableLayout)panelBody.getLayout()).setVGap(5);

                //======== panelPatientHeader ========
                {
                    panelPatientHeader.setBackground(Color.white);
                    panelPatientHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93}}));
                    ((TableLayout)panelPatientHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelPatientHeader.getLayout()).setVGap(5);

                    //---- textPatientInfo ----
                    textPatientInfo.setText("Patient info");
                    textPatientInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textPatientInfo.setForeground(Color.black);
                    panelPatientHeader.add(textPatientInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelPatientHeader.add(separatorPatient, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelPatientHeader, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelPatientBody ========
                {
                    panelPatientBody.setBackground(Color.white);
                    panelPatientBody.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {50, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED, 30, TableLayout.PREFERRED, 50}}));
                    ((TableLayout)panelPatientBody.getLayout()).setHGap(5);
                    ((TableLayout)panelPatientBody.getLayout()).setVGap(5);

                    //---- textFieldFN ----
                    textFieldFN.setBackground(Color.white);
                    textFieldFN.setForeground(Color.gray);
                    textFieldFN.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldFN.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "First Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldFN.setText("e.g. John");
                    panelPatientBody.add(textFieldFN, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer1 ----
                    hSpacer1.setBackground(new Color(255, 255, 255, 0));
                    hSpacer1.setMinimumSize(new Dimension(30, 12));
                    hSpacer1.setPreferredSize(new Dimension(50, 10));
                    panelPatientBody.add(hSpacer1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldMN ----
                    textFieldMN.setBackground(Color.white);
                    textFieldMN.setForeground(Color.gray);
                    textFieldMN.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldMN.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Middle Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldMN.setText("e.g. Ahmed");
                    panelPatientBody.add(textFieldMN, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer2 ----
                    hSpacer2.setBackground(new Color(255, 255, 255, 0));
                    hSpacer2.setMinimumSize(new Dimension(30, 12));
                    hSpacer2.setPreferredSize(new Dimension(50, 10));
                    panelPatientBody.add(hSpacer2, new TableLayoutConstraints(3, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldLN ----
                    textFieldLN.setBackground(Color.white);
                    textFieldLN.setForeground(Color.gray);
                    textFieldLN.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldLN.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Last Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldLN.setText("e.g. Doe");
                    panelPatientBody.add(textFieldLN, new TableLayoutConstraints(4, 0, 4, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelFNError ----
                    labelFNError.setForeground(new Color(191, 44, 39));
                    labelFNError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelFNError.setBackground(new Color(255, 255, 255, 0));
                    panelPatientBody.add(labelFNError, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelMNError ----
                    labelMNError.setForeground(new Color(191, 44, 39));
                    labelMNError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelMNError.setBackground(new Color(255, 255, 255, 0));
                    panelPatientBody.add(labelMNError, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelLNError ----
                    labelLNError.setForeground(new Color(191, 44, 39));
                    labelLNError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelLNError.setBackground(new Color(255, 255, 255, 0));
                    panelPatientBody.add(labelLNError, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer2 ----
                    vSpacer2.setBackground(new Color(255, 255, 255, 0));
                    vSpacer2.setPreferredSize(new Dimension(50, 10));
                    vSpacer2.setMinimumSize(new Dimension(50, 10));
                    panelPatientBody.add(vSpacer2, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelDOB ----
                    labelDOB.setText("Date of Birth");
                    labelDOB.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelDOB.setForeground(Color.black);
                    panelPatientBody.add(labelDOB, new TableLayoutConstraints(2, 2, 2, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- textFieldPhone ----
                    textFieldPhone.setBackground(Color.white);
                    textFieldPhone.setForeground(Color.gray);
                    textFieldPhone.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldPhone.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Phone Number", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldPhone.setText("e.g. +201017836584");
                    panelPatientBody.add(textFieldPhone, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelBirth ========
                    {
                        panelBirth.setBackground(Color.gray);
                        panelBirth.setLayout(new BorderLayout());
                    }
                    panelPatientBody.add(panelBirth, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldID ----
                    textFieldID.setBackground(Color.white);
                    textFieldID.setForeground(Color.gray);
                    textFieldID.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldID.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "National ID", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldID.setText("e.g. 235437659984");
                    panelPatientBody.add(textFieldID, new TableLayoutConstraints(4, 3, 4, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelPhoneError ----
                    labelPhoneError.setForeground(new Color(191, 44, 39));
                    labelPhoneError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelPhoneError.setBackground(new Color(255, 255, 255, 0));
                    panelPatientBody.add(labelPhoneError, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelIDError ----
                    labelIDError.setForeground(new Color(191, 44, 39));
                    labelIDError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelIDError.setBackground(new Color(255, 255, 255, 0));
                    panelPatientBody.add(labelIDError, new TableLayoutConstraints(4, 4, 4, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer3 ----
                    vSpacer3.setBackground(new Color(255, 255, 255, 0));
                    vSpacer3.setPreferredSize(new Dimension(50, 10));
                    vSpacer3.setMinimumSize(new Dimension(50, 10));
                    panelPatientBody.add(vSpacer3, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelDepartment ----
                    labelDepartment.setText("City");
                    labelDepartment.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelDepartment.setForeground(Color.black);
                    panelPatientBody.add(labelDepartment, new TableLayoutConstraints(2, 6, 2, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

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
                    panelPatientBody.add(panelGender, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxDepartment ----
                    comboBoxDepartment.setBackground(Color.white);
                    comboBoxDepartment.setForeground(new Color(32, 32, 82));
                    comboBoxDepartment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelPatientBody.add(comboBoxDepartment, new TableLayoutConstraints(2, 7, 2, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelPatientBody, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

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
                    comboBoxGov.setForeground(Color.black);
                    comboBoxGov.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    comboBoxGov.addItemListener(e -> comboBoxGovItemStateChanged(e));
                    panelAddBody.add(comboBoxGov, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer3 ----
                    hSpacer3.setBackground(new Color(255, 255, 255, 0));
                    hSpacer3.setMinimumSize(new Dimension(30, 12));
                    hSpacer3.setPreferredSize(new Dimension(50, 10));
                    panelAddBody.add(hSpacer3, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxCity ----
                    comboBoxCity.setBackground(Color.white);
                    comboBoxCity.setForeground(new Color(32, 32, 82));
                    comboBoxCity.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelAddBody.add(comboBoxCity, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer4 ----
                    hSpacer4.setBackground(new Color(255, 255, 255, 0));
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
                                .addGap(0, 373, Short.MAX_VALUE)
                        );
                        panelFakeLayout.setVerticalGroup(
                            panelFakeLayout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelAddBody.add(panelFake, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer5 ----
                    vSpacer5.setBackground(new Color(255, 255, 255, 0));
                    vSpacer5.setPreferredSize(new Dimension(50, 10));
                    vSpacer5.setMinimumSize(new Dimension(50, 10));
                    panelAddBody.add(vSpacer5, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldStreet ----
                    textFieldStreet.setBackground(Color.white);
                    textFieldStreet.setForeground(Color.gray);
                    textFieldStreet.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldStreet.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Street", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldStreet.setText("e.g. Tahrir St.");
                    panelAddBody.add(textFieldStreet, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelStreetError ----
                    labelStreetError.setForeground(new Color(191, 44, 39));
                    labelStreetError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelStreetError.setBackground(new Color(255, 255, 255, 0));
                    panelAddBody.add(labelStreetError, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer6 ----
                    vSpacer6.setBackground(new Color(255, 255, 255, 0));
                    vSpacer6.setPreferredSize(new Dimension(50, 10));
                    vSpacer6.setMinimumSize(new Dimension(50, 10));
                    panelAddBody.add(vSpacer6, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldApt ----
                    textFieldApt.setBackground(Color.white);
                    textFieldApt.setForeground(Color.gray);
                    textFieldApt.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldApt.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Apartment", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldApt.setText("e.g. 211");
                    panelAddBody.add(textFieldApt, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelAptError ----
                    labelAptError.setForeground(new Color(191, 44, 39));
                    labelAptError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelAptError.setBackground(new Color(255, 255, 255, 0));
                    panelAddBody.add(labelAptError, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelAddBody, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelEmerHeader ========
                {
                    panelEmerHeader.setBackground(Color.white);
                    panelEmerHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93}}));
                    ((TableLayout)panelEmerHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelEmerHeader.getLayout()).setVGap(5);

                    //---- textEmergencyInfo ----
                    textEmergencyInfo.setText("Emergency Contact info");
                    textEmergencyInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textEmergencyInfo.setForeground(Color.black);
                    panelEmerHeader.add(textEmergencyInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelEmerHeader.add(separatorAddress2, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelEmerHeader, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelEmerBody ========
                {
                    panelEmerBody.setBackground(Color.white);
                    panelEmerBody.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, 50, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED}}));
                    ((TableLayout)panelEmerBody.getLayout()).setHGap(5);
                    ((TableLayout)panelEmerBody.getLayout()).setVGap(5);

                    //---- labelRelation ----
                    labelRelation.setText("Relation");
                    labelRelation.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelRelation.setForeground(Color.black);
                    panelEmerBody.add(labelRelation, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldEmerName ----
                    textFieldEmerName.setBackground(Color.white);
                    textFieldEmerName.setForeground(Color.gray);
                    textFieldEmerName.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldEmerName.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldEmerName.setText("e.g. John Doe");
                    panelEmerBody.add(textFieldEmerName, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer5 ----
                    hSpacer5.setBackground(new Color(255, 255, 255, 0));
                    hSpacer5.setMinimumSize(new Dimension(30, 12));
                    hSpacer5.setPreferredSize(new Dimension(50, 10));
                    panelEmerBody.add(hSpacer5, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxRelation ----
                    comboBoxRelation.setBackground(Color.white);
                    comboBoxRelation.setForeground(new Color(32, 32, 82));
                    comboBoxRelation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelEmerBody.add(comboBoxRelation, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer6 ----
                    hSpacer6.setBackground(new Color(255, 255, 255, 0));
                    hSpacer6.setMinimumSize(new Dimension(30, 12));
                    hSpacer6.setPreferredSize(new Dimension(50, 10));
                    panelEmerBody.add(hSpacer6, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake2 ========
                    {
                        panelFake2.setBackground(Color.white);

                        GroupLayout panelFake2Layout = new GroupLayout(panelFake2);
                        panelFake2.setLayout(panelFake2Layout);
                        panelFake2Layout.setHorizontalGroup(
                            panelFake2Layout.createParallelGroup()
                                .addGap(0, 373, Short.MAX_VALUE)
                        );
                        panelFake2Layout.setVerticalGroup(
                            panelFake2Layout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelEmerBody.add(panelFake2, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelEmerNameError ----
                    labelEmerNameError.setForeground(new Color(191, 44, 39));
                    labelEmerNameError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelEmerNameError.setBackground(new Color(255, 255, 255, 0));
                    panelEmerBody.add(labelEmerNameError, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer7 ----
                    vSpacer7.setBackground(new Color(255, 255, 255, 0));
                    vSpacer7.setPreferredSize(new Dimension(50, 10));
                    vSpacer7.setMinimumSize(new Dimension(50, 10));
                    panelEmerBody.add(vSpacer7, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldEmerPhone ----
                    textFieldEmerPhone.setBackground(Color.white);
                    textFieldEmerPhone.setForeground(Color.gray);
                    textFieldEmerPhone.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldEmerPhone.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Phone Number", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldEmerPhone.setText("e.g. +201017836584");
                    panelEmerBody.add(textFieldEmerPhone, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelEmerPhoneError ----
                    labelEmerPhoneError.setForeground(new Color(191, 44, 39));
                    labelEmerPhoneError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelEmerPhoneError.setBackground(new Color(255, 255, 255, 0));
                    panelEmerBody.add(labelEmerPhoneError, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelEmerBody, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelMedHeader ========
                {
                    panelMedHeader.setBackground(Color.white);
                    panelMedHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93}}));
                    ((TableLayout)panelMedHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelMedHeader.getLayout()).setVGap(5);

                    //---- textMedInfo ----
                    textMedInfo.setText("Medical Alerts");
                    textMedInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textMedInfo.setForeground(Color.black);
                    panelMedHeader.add(textMedInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelMedHeader.add(separatorMed, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelMedHeader, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelMedBody ========
                {
                    panelMedBody.setBackground(Color.white);
                    panelMedBody.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED},
                        {TableLayout.PREFERRED, 30, TableLayout.PREFERRED, 30, TableLayout.PREFERRED}}));
                    ((TableLayout)panelMedBody.getLayout()).setHGap(5);
                    ((TableLayout)panelMedBody.getLayout()).setVGap(5);

                    //---- checkBoxAllergies ----
                    checkBoxAllergies.setText("Allergies");
                    checkBoxAllergies.setBackground(new Color(32, 32, 82, 0));
                    checkBoxAllergies.setForeground(Color.black);
                    checkBoxAllergies.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxAllergies, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                    //---- hSpacer7 ----
                    hSpacer7.setBackground(new Color(255, 255, 255, 0));
                    hSpacer7.setMinimumSize(new Dimension(30, 12));
                    hSpacer7.setPreferredSize(new Dimension(50, 10));
                    panelMedBody.add(hSpacer7, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- checkBoxDiabetes ----
                    checkBoxDiabetes.setText("Diabetes");
                    checkBoxDiabetes.setBackground(new Color(60, 63, 65, 0));
                    checkBoxDiabetes.setForeground(Color.black);
                    checkBoxDiabetes.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxDiabetes, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                    //---- hSpacer8 ----
                    hSpacer8.setBackground(new Color(255, 255, 255, 0));
                    hSpacer8.setMinimumSize(new Dimension(30, 12));
                    hSpacer8.setPreferredSize(new Dimension(50, 10));
                    panelMedBody.add(hSpacer8, new TableLayoutConstraints(3, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- checkBoxAsthma ----
                    checkBoxAsthma.setText("Asthma");
                    checkBoxAsthma.setBackground(new Color(60, 63, 65, 0));
                    checkBoxAsthma.setForeground(Color.black);
                    checkBoxAsthma.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxAsthma, new TableLayoutConstraints(4, 0, 4, 0, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                    //---- checkBoxDrugs ----
                    checkBoxDrugs.setText("  Drugs");
                    checkBoxDrugs.setBackground(new Color(60, 63, 65, 0));
                    checkBoxDrugs.setForeground(Color.black);
                    checkBoxDrugs.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxDrugs, new TableLayoutConstraints(5, 0, 5, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                    //---- hSpacer10 ----
                    hSpacer10.setBackground(new Color(255, 255, 255, 0));
                    hSpacer10.setMinimumSize(new Dimension(30, 12));
                    hSpacer10.setPreferredSize(new Dimension(50, 10));
                    panelMedBody.add(hSpacer10, new TableLayoutConstraints(6, 0, 6, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- checkBoxBP ----
                    checkBoxBP.setText("Blood Pressure");
                    checkBoxBP.setBackground(new Color(60, 63, 65, 0));
                    checkBoxBP.setForeground(Color.black);
                    checkBoxBP.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxBP, new TableLayoutConstraints(7, 0, 7, 0, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                    //---- vSpacer8 ----
                    vSpacer8.setBackground(new Color(255, 255, 255, 0));
                    vSpacer8.setPreferredSize(new Dimension(50, 10));
                    vSpacer8.setMinimumSize(new Dimension(50, 10));
                    panelMedBody.add(vSpacer8, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- checkBoxAnemia ----
                    checkBoxAnemia.setText("Anemia");
                    checkBoxAnemia.setBackground(new Color(60, 63, 65, 0));
                    checkBoxAnemia.setForeground(Color.black);
                    checkBoxAnemia.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxAnemia, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                    //---- checkBoxCancer ----
                    checkBoxCancer.setText("Cancer");
                    checkBoxCancer.setBackground(new Color(60, 63, 65, 0));
                    checkBoxCancer.setForeground(Color.black);
                    checkBoxCancer.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxCancer, new TableLayoutConstraints(2, 2, 2, 2, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                    //---- checkBoxCardio ----
                    checkBoxCardio.setText("  Cardiovascular Diseases");
                    checkBoxCardio.setBackground(new Color(60, 63, 65, 0));
                    checkBoxCardio.setForeground(Color.black);
                    checkBoxCardio.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxCardio, new TableLayoutConstraints(4, 2, 5, 2, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                    //---- checkBoxHypertension ----
                    checkBoxHypertension.setText("Hypertension");
                    checkBoxHypertension.setBackground(new Color(60, 63, 65, 0));
                    checkBoxHypertension.setForeground(Color.black);
                    checkBoxHypertension.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxHypertension, new TableLayoutConstraints(7, 2, 7, 2, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                    //---- vSpacer9 ----
                    vSpacer9.setBackground(new Color(255, 255, 255, 0));
                    vSpacer9.setPreferredSize(new Dimension(50, 10));
                    vSpacer9.setMinimumSize(new Dimension(50, 10));
                    panelMedBody.add(vSpacer9, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- checkBoxBD ----
                    checkBoxBD.setText("Bleeding Disorder");
                    checkBoxBD.setBackground(new Color(60, 63, 65, 0));
                    checkBoxBD.setForeground(Color.black);
                    checkBoxBD.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelMedBody.add(checkBoxBD, new TableLayoutConstraints(0, 4, 2, 4, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelMedBody, new TableLayoutConstraints(0, 8, 0, 8, TableLayoutConstraints.LEFT, TableLayoutConstraints.FULL));

                //======== panelFooter ========
                {
                    panelFooter.setBackground(Color.white);
                    panelFooter.setLayout(null);

                    //---- buttonAddPatient ----
                    buttonAddPatient.setText("ADD");
                    buttonAddPatient.setBackground(new Color(32, 32, 82));
                    buttonAddPatient.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    buttonAddPatient.setForeground(Color.white);
                    buttonAddPatient.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonAddPatientMouseClicked(e);
                        }
                    });
                    panelFooter.add(buttonAddPatient);
                    buttonAddPatient.setBounds(0, 105, 190, 35);

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
                panelBody.add(panelFooter, new TableLayoutConstraints(0, 9, 0, 9, TableLayoutConstraints.RIGHT, TableLayoutConstraints.BOTTOM));
            }
            scrollPane1.setViewportView(panelBody);
        }
        add(scrollPane1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        datePicker = new DatePicker();
        datePicker.setBackground(Color.white);
        datePicker.setDateToToday();
        panelBirth.add(datePicker);
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
    private JPanel panelPatientHeader;
    private JLabel textPatientInfo;
    private JSeparator separatorPatient;
    private JPanel panelPatientBody;
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
    private JTextField textFieldID;
    private JLabel labelPhoneError;
    private JLabel labelIDError;
    private JPanel vSpacer3;
    private JLabel labelDepartment;
    private JPanel panelGender;
    private JLabel labelGender;
    private JRadioButton radioButtonFemale;
    private JRadioButton radioButtonMale;
    private JComboBox comboBoxDepartment;
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
    private JPanel panelEmerHeader;
    private JLabel textEmergencyInfo;
    private JSeparator separatorAddress2;
    private JPanel panelEmerBody;
    private JLabel labelRelation;
    private JTextField textFieldEmerName;
    private JPanel hSpacer5;
    private JComboBox comboBoxRelation;
    private JPanel hSpacer6;
    private JPanel panelFake2;
    private JLabel labelEmerNameError;
    private JPanel vSpacer7;
    private JTextField textFieldEmerPhone;
    private JLabel labelEmerPhoneError;
    private JPanel panelMedHeader;
    private JLabel textMedInfo;
    private JSeparator separatorMed;
    private JPanel panelMedBody;
    private JCheckBox checkBoxAllergies;
    private JPanel hSpacer7;
    private JCheckBox checkBoxDiabetes;
    private JPanel hSpacer8;
    private JCheckBox checkBoxAsthma;
    private JCheckBox checkBoxDrugs;
    private JPanel hSpacer10;
    private JCheckBox checkBoxBP;
    private JPanel vSpacer8;
    private JCheckBox checkBoxAnemia;
    private JCheckBox checkBoxCancer;
    private JCheckBox checkBoxCardio;
    private JCheckBox checkBoxHypertension;
    private JPanel vSpacer9;
    private JCheckBox checkBoxBD;
    private JPanel panelFooter;
    private JButton buttonAddPatient;
    private JLabel labelTooth;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    DatePicker datePicker;
    public static JFrame frame = new JFrame("Home Frame");
    private C_Patient patientController = new C_Patient();
}
