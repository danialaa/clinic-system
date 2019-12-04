/*
 * Created by JFormDesigner on Sun Dec 01 23:53:22 EET 2019
 */

package com.example.clinicsystem.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.List;

import com.example.clinicsystem.controllers.C_Equipment;
import com.example.clinicsystem.models.enums.EquipmentType;
import com.github.lgooddatepicker.components.DatePicker;
import com.intellij.uiDesigner.core.*;
import info.clearthought.layout.*;

/**
 * @author Dania
 */
public class V_AddEquipmentForm extends JPanel {
    public V_AddEquipmentForm() {
        initComponents();

        for(EquipmentType equipmentType : EquipmentType.values()) {
            comboBoxEquipType.addItem(equipmentType.getName());
        }

        panels.add(panelDetailsDrug);
        panels.add(panelDetailsEngine);
        panels.add(panelDetailsOperational);
        panels.add(panelDetailsSterilization);
    }

    private void comboBoxEquipTypeItemStateChanged(ItemEvent e) {
        switch (comboBoxEquipType.getSelectedIndex()) {
            case 0:
                panelDetailsDrug.setVisible(true);

                for(JPanel panel : panels) {
                    if(panel != panelDetailsDrug && panel.isVisible()) {
                        panel.setVisible(false);
                    }
                }

                break;

            case 1:
                panelDetailsEngine.setVisible(true);

                for(JPanel panel : panels) {
                    if(panel != panelDetailsEngine && panel.isVisible()) {
                        panel.setVisible(false);
                    }
                }

                break;

            case 2:
                panelDetailsOperational.setVisible(true);

                for(JPanel panel : panels) {
                    if(panel != panelDetailsOperational && panel.isVisible()) {
                        panel.setVisible(false);
                    }
                }

                break;

            case 3:
                panelDetailsSterilization.setVisible(true);

                for(JPanel panel : panels) {
                    if(panel != panelDetailsSterilization && panel.isVisible()) {
                        panel.setVisible(false);
                    }
                }

                break;
        }

        repaint();
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

    private void radioButtonMaintainedMouseClicked(MouseEvent e) {
        if(radioButtonMaintained.isSelected()) {
            radioButtonNeeds.setSelected(false);
        } else {
            radioButtonMaintained.setSelected(true);
        }
    }

    private void radioButtonNeedsMouseClicked(MouseEvent e) {
        if(radioButtonNeeds.isSelected()) {
            radioButtonMaintained.setSelected(false);
        } else {
            radioButtonNeeds.setSelected(true);
        }
    }

    private void buttonAddEquipMouseClicked(MouseEvent e) {
        List<JTextField> textFields = new ArrayList<>();
        List<JLabel> labels = new ArrayList<>();

        textFields.add(textFieldName);
        labels.add(labelNameError);
        textFields.add(textFieldPrice);
        labels.add(labelPriceError);

        if(textFieldQuantity.isVisible()) {
            textFields.add(textFieldQuantity);
            labels.add(labelQuantityError);
        }

        if(equipmentController.isValidEquipmentData(textFields, labels)) {
            List data = new ArrayList();
            data.add(textFieldName.toString());
            data.add(textFieldPrice.toString());
            data.add(textFieldQuantity.toString());
            data.add(comboBoxEquipType.getSelectedItem().toString());

            if(radioButtonAvailable.isSelected()) {
                data.add(true);
            } else {
                data.add(false);
            }

            if(panelDetailsDrug.isVisible()) {
                data.add("drug");
                data.add(expiryDate.getDate().toString());
                data.add(productionDate.getDate().toString());
            } else if(panelDetailsEngine.isVisible()) {
                data.add("engine");

                if(radioButtonMaintained.isSelected()) {
                    data.add(true);
                } else {
                    data.add(false);
                }
                if(radioButtonOccupied.isSelected()) {
                    data.add(true);
                } else {
                    data.add(false);
                }

                data.add(comboBoxRoom.getSelectedItem().toString());
            } else if(panelDetailsOperational.isVisible()) {
                data.add("operational");

                if(radioButtonSterilized.isSelected()) {
                    data.add(true);
                } else {
                    data.add(false);
                }
                if(radioButtonReusable.isSelected()) {
                    data.add(true);
                } else {
                    data.add(false);
                }
            } else if(panelDetailsSterilization.isVisible()) {
                data.add("sterilization");
                data.add(comboBoxSterilization.getSelectedItem().toString());
            }

            equipmentController.request("C", data);
        }
    }

    private void textFieldQuantityFocusGained(FocusEvent e) {
        if (textFieldQuantity.getText().equals("e.g. 50")) {
            textFieldQuantity.setText("");
            textFieldQuantity.setForeground(Color.black);
        }
    }

    private void textFieldQuantityFocusLost(FocusEvent e) {
        if (textFieldQuantity.getText().equals("")) {
            textFieldQuantity.setText("e.g. 50");
            textFieldQuantity.setForeground(Color.gray);
        }
    }

    private void textFieldPriceFocusGained(FocusEvent e) {
        if (textFieldPrice.getText().equals("e.g. 200")) {
            textFieldPrice.setText("");
            textFieldPrice.setForeground(Color.black);
        }
    }

    private void textFieldPriceFocusLost(FocusEvent e) {
        if (textFieldPrice.getText().equals("")) {
            textFieldPrice.setText("e.g. 200");
            textFieldPrice.setForeground(Color.gray);
        }
    }

    private void textFieldNameFocusGained(FocusEvent e) {
        if (textFieldName.getText().equals("e.g. Gloves")) {
            textFieldName.setText("");
            textFieldName.setForeground(Color.black);
        }
    }

    private void textFieldNameFocusLost(FocusEvent e) {
        if (textFieldName.getText().equals("")) {
            textFieldName.setText("e.g. Gloves");
            textFieldName.setForeground(Color.gray);
        }
    }

    private void radioButtonOccupiedMouseClicked(MouseEvent e) {
        if(radioButtonOccupied.isSelected()) {
            radioButtonEmpty.setSelected(false);
        } else {
            radioButtonOccupied.setSelected(true);
        }
    }

    private void radioButtonEmptyMouseClicked(MouseEvent e) {
        if(radioButtonEmpty.isSelected()) {
            radioButtonOccupied.setSelected(false);
        } else {
            radioButtonEmpty.setSelected(true);
        }
    }

    private void radioButtonSterilizedMouseClicked(MouseEvent e) {
        if(radioButtonSterilized.isSelected()) {
            radioButtonNeedsSteri.setSelected(false);
        } else {
            radioButtonSterilized.setSelected(true);
        }
    }

    private void radioButtonNeedsSteriMouseClicked(MouseEvent e) {
        if(radioButtonNeedsSteri.isSelected()) {
            radioButtonSterilized.setSelected(false);
        } else {
            radioButtonNeedsSteri.setSelected(true);
        }
    }

    private void radioButtonReuseMouseClicked(MouseEvent e) {
        if(radioButtonReusable.isSelected()) {
            radioButtonDisposable.setSelected(false);
        } else {
            radioButtonReusable.setSelected(true);
        }
    }

    private void radioButtonDisposeMouseClicked(MouseEvent e) {
        if(radioButtonDisposable.isSelected()) {
            radioButtonReusable.setSelected(false);
        } else {
            radioButtonDisposable.setSelected(true);
        }
    }

    private void radioButtonAvailableMouseClicked(MouseEvent e) {
        if(radioButtonAvailable.isSelected()) {
            radioButtonDepleted.setSelected(false);

            textFieldQuantity.setVisible(true);
        } else {
            radioButtonAvailable.setSelected(true);
        }
    }

    private void radioButtonDepletedMouseClicked(MouseEvent e) {
        if(radioButtonDepleted.isSelected()) {
            radioButtonAvailable.setSelected(false);

            textFieldQuantity.setVisible(false);
        } else {
            radioButtonDepleted.setSelected(true);
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
        panelEquipmentHeader = new JPanel();
        textEquipInfo = new JLabel();
        separatorEquip = new JSeparator();
        panelEquipBody = new JPanel();
        labelType = new JLabel();
        textFieldName = new JTextField();
        comboBoxEquipType = new JComboBox();
        labelNameError = new JLabel();
        vSpacer7 = new JPanel(null);
        textFieldPrice = new JTextField();
        hSpacer1 = new JPanel(null);
        labelPriceError = new JLabel();
        vSpacer2 = new JPanel(null);
        panelAvailability = new JPanel();
        labelAvailability = new JLabel();
        radioButtonAvailable = new JRadioButton();
        radioButtonDepleted = new JRadioButton();
        vSpacer3 = new JPanel(null);
        textFieldQuantity = new JTextField();
        labelQuantityError = new JLabel();
        panelDetailsHeader = new JPanel();
        textDetailsInfo = new JLabel();
        separatorDetails = new JSeparator();
        panelDetailsDrug = new JPanel();
        labelProduction = new JLabel();
        labelExpiry = new JLabel();
        panelProduction = new JPanel();
        hSpacer3 = new JPanel(null);
        panelExpiry = new JPanel();
        hSpacer4 = new JPanel(null);
        panelFake = new JPanel();
        panelDetailsEngine = new JPanel();
        panelMaintainability = new JPanel();
        labelMaintainability = new JLabel();
        radioButtonMaintained = new JRadioButton();
        radioButtonNeeds = new JRadioButton();
        hSpacer5 = new JPanel(null);
        panelFake5 = new JPanel();
        hSpacer6 = new JPanel(null);
        panelFake2 = new JPanel();
        vSpacer8 = new JPanel(null);
        panelOccupation = new JPanel();
        labelOccupation = new JLabel();
        radioButtonOccupied = new JRadioButton();
        radioButtonEmpty = new JRadioButton();
        vSpacer9 = new JPanel(null);
        labelRoom = new JLabel();
        comboBoxRoom = new JComboBox();
        panelDetailsOperational = new JPanel();
        panelSterilization = new JPanel();
        labelAvailability2 = new JLabel();
        radioButtonSterilized = new JRadioButton();
        radioButtonNeedsSteri = new JRadioButton();
        hSpacer7 = new JPanel(null);
        panelFake6 = new JPanel();
        hSpacer8 = new JPanel(null);
        panelFake3 = new JPanel();
        vSpacer10 = new JPanel(null);
        panelReusability = new JPanel();
        labelReusability = new JLabel();
        radioButtonReusable = new JRadioButton();
        radioButtonDisposable = new JRadioButton();
        panelDetailsSterilization = new JPanel();
        labelSteriType = new JLabel();
        comboBoxSterilization = new JComboBox();
        hSpacer9 = new JPanel(null);
        panelFake7 = new JPanel();
        hSpacer10 = new JPanel(null);
        panelFake4 = new JPanel();
        panelFooter = new JPanel();
        buttonAddEquip = new JButton();
        labelTooth = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(1920, 1080));
        setPreferredSize(new Dimension(1920, 1200));
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );
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
                    {92, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
                ((TableLayout)panelBody.getLayout()).setHGap(5);
                ((TableLayout)panelBody.getLayout()).setVGap(5);

                //======== panelEquipmentHeader ========
                {
                    panelEquipmentHeader.setBackground(Color.white);
                    panelEquipmentHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93}}));
                    ((TableLayout)panelEquipmentHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelEquipmentHeader.getLayout()).setVGap(5);

                    //---- textEquipInfo ----
                    textEquipInfo.setText("Equipment info");
                    textEquipInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textEquipInfo.setForeground(Color.black);
                    panelEquipmentHeader.add(textEquipInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelEquipmentHeader.add(separatorEquip, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelEquipmentHeader, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelEquipBody ========
                {
                    panelEquipBody.setBackground(Color.white);
                    panelEquipBody.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED, 30, 50, TableLayout.PREFERRED}}));
                    ((TableLayout)panelEquipBody.getLayout()).setHGap(5);
                    ((TableLayout)panelEquipBody.getLayout()).setVGap(5);

                    //---- labelType ----
                    labelType.setText("Equipment Type");
                    labelType.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelType.setForeground(Color.black);
                    panelEquipBody.add(labelType, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- textFieldName ----
                    textFieldName.setBackground(Color.white);
                    textFieldName.setForeground(Color.gray);
                    textFieldName.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldName.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldName.setText("e.g. Gloves");
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
                    panelEquipBody.add(textFieldName, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxEquipType ----
                    comboBoxEquipType.setBackground(Color.white);
                    comboBoxEquipType.setForeground(new Color(32, 32, 82));
                    comboBoxEquipType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    comboBoxEquipType.addItemListener(e -> comboBoxEquipTypeItemStateChanged(e));
                    panelEquipBody.add(comboBoxEquipType, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelNameError ----
                    labelNameError.setForeground(new Color(191, 44, 39));
                    labelNameError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelNameError.setBackground(Color.white);
                    panelEquipBody.add(labelNameError, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer7 ----
                    vSpacer7.setBackground(Color.white);
                    vSpacer7.setPreferredSize(new Dimension(50, 10));
                    vSpacer7.setMinimumSize(new Dimension(50, 10));
                    panelEquipBody.add(vSpacer7, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldPrice ----
                    textFieldPrice.setBackground(Color.white);
                    textFieldPrice.setForeground(Color.gray);
                    textFieldPrice.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldPrice.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Price", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldPrice.setText("e.g. 200");
                    textFieldPrice.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            textFieldPriceFocusGained(e);
                        }
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldPriceFocusLost(e);
                        }
                    });
                    panelEquipBody.add(textFieldPrice, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer1 ----
                    hSpacer1.setBackground(Color.white);
                    hSpacer1.setMinimumSize(new Dimension(30, 12));
                    hSpacer1.setPreferredSize(new Dimension(50, 10));
                    panelEquipBody.add(hSpacer1, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelPriceError ----
                    labelPriceError.setForeground(new Color(191, 44, 39));
                    labelPriceError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelPriceError.setBackground(Color.white);
                    panelEquipBody.add(labelPriceError, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer2 ----
                    vSpacer2.setBackground(Color.white);
                    vSpacer2.setPreferredSize(new Dimension(50, 10));
                    vSpacer2.setMinimumSize(new Dimension(50, 10));
                    panelEquipBody.add(vSpacer2, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelAvailability ========
                    {
                        panelAvailability.setBackground(Color.white);
                        panelAvailability.setLayout(new TableLayout(new double[][] {
                            {TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL},
                            {50}}));
                        ((TableLayout)panelAvailability.getLayout()).setHGap(5);
                        ((TableLayout)panelAvailability.getLayout()).setVGap(5);

                        //---- labelAvailability ----
                        labelAvailability.setText("Availability");
                        labelAvailability.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        labelAvailability.setForeground(Color.black);
                        panelAvailability.add(labelAvailability, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- radioButtonAvailable ----
                        radioButtonAvailable.setText("Available");
                        radioButtonAvailable.setBackground(Color.white);
                        radioButtonAvailable.setForeground(Color.black);
                        radioButtonAvailable.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonAvailable.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonAvailableMouseClicked(e);
                            }
                        });
                        panelAvailability.add(radioButtonAvailable, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- radioButtonDepleted ----
                        radioButtonDepleted.setText("Depleted");
                        radioButtonDepleted.setBackground(Color.white);
                        radioButtonDepleted.setForeground(Color.black);
                        radioButtonDepleted.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonDepleted.setSelected(true);
                        radioButtonDepleted.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonDepletedMouseClicked(e);
                            }
                        });
                        panelAvailability.add(radioButtonDepleted, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));
                    }
                    panelEquipBody.add(panelAvailability, new TableLayoutConstraints(0, 7, 0, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer3 ----
                    vSpacer3.setBackground(Color.white);
                    vSpacer3.setPreferredSize(new Dimension(50, 10));
                    vSpacer3.setMinimumSize(new Dimension(50, 10));
                    panelEquipBody.add(vSpacer3, new TableLayoutConstraints(0, 9, 0, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- textFieldQuantity ----
                    textFieldQuantity.setBackground(Color.white);
                    textFieldQuantity.setForeground(Color.gray);
                    textFieldQuantity.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                    textFieldQuantity.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Quantity Available", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldQuantity.setVisible(false);
                    textFieldQuantity.setText("e.g. 50");
                    textFieldQuantity.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            textFieldQuantityFocusGained(e);
                        }
                        @Override
                        public void focusLost(FocusEvent e) {
                            textFieldQuantityFocusLost(e);
                        }
                    });
                    panelEquipBody.add(textFieldQuantity, new TableLayoutConstraints(0, 10, 0, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelQuantityError ----
                    labelQuantityError.setForeground(new Color(191, 44, 39));
                    labelQuantityError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    panelEquipBody.add(labelQuantityError, new TableLayoutConstraints(0, 11, 0, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelEquipBody, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelDetailsHeader ========
                {
                    panelDetailsHeader.setBackground(Color.white);
                    panelDetailsHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93}}));
                    ((TableLayout)panelDetailsHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelDetailsHeader.getLayout()).setVGap(5);

                    //---- textDetailsInfo ----
                    textDetailsInfo.setText("Equipment Details info");
                    textDetailsInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textDetailsInfo.setForeground(Color.black);
                    panelDetailsHeader.add(textDetailsInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelDetailsHeader.add(separatorDetails, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelDetailsHeader, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelDetailsDrug ========
                {
                    panelDetailsDrug.setBackground(Color.white);
                    panelDetailsDrug.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, 50}}));
                    ((TableLayout)panelDetailsDrug.getLayout()).setHGap(5);
                    ((TableLayout)panelDetailsDrug.getLayout()).setVGap(5);

                    //---- labelProduction ----
                    labelProduction.setText("Production Date");
                    labelProduction.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelProduction.setForeground(Color.black);
                    panelDetailsDrug.add(labelProduction, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- labelExpiry ----
                    labelExpiry.setText("Expiry Date");
                    labelExpiry.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelExpiry.setForeground(Color.black);
                    panelDetailsDrug.add(labelExpiry, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //======== panelProduction ========
                    {
                        panelProduction.setBackground(Color.gray);
                        panelProduction.setLayout(new BorderLayout());
                    }
                    panelDetailsDrug.add(panelProduction, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer3 ----
                    hSpacer3.setBackground(Color.white);
                    hSpacer3.setMinimumSize(new Dimension(30, 12));
                    hSpacer3.setPreferredSize(new Dimension(50, 10));
                    panelDetailsDrug.add(hSpacer3, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelExpiry ========
                    {
                        panelExpiry.setBackground(Color.gray);
                        panelExpiry.setLayout(new BorderLayout());
                    }
                    panelDetailsDrug.add(panelExpiry, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer4 ----
                    hSpacer4.setBackground(Color.white);
                    hSpacer4.setMinimumSize(new Dimension(30, 12));
                    hSpacer4.setPreferredSize(new Dimension(50, 10));
                    panelDetailsDrug.add(hSpacer4, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake ========
                    {
                        panelFake.setBackground(Color.white);

                        GroupLayout panelFakeLayout = new GroupLayout(panelFake);
                        panelFake.setLayout(panelFakeLayout);
                        panelFakeLayout.setHorizontalGroup(
                            panelFakeLayout.createParallelGroup()
                                .addGap(0, 355, Short.MAX_VALUE)
                        );
                        panelFakeLayout.setVerticalGroup(
                            panelFakeLayout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelDetailsDrug.add(panelFake, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelDetailsDrug, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelDetailsEngine ========
                {
                    panelDetailsEngine.setBackground(Color.white);
                    panelDetailsEngine.setVisible(false);
                    panelDetailsEngine.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, 50, 30, 50, 30, TableLayout.PREFERRED, 50}}));
                    ((TableLayout)panelDetailsEngine.getLayout()).setHGap(5);
                    ((TableLayout)panelDetailsEngine.getLayout()).setVGap(5);

                    //======== panelMaintainability ========
                    {
                        panelMaintainability.setBackground(Color.white);
                        panelMaintainability.setLayout(new TableLayout(new double[][] {
                            {TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL},
                            {50}}));
                        ((TableLayout)panelMaintainability.getLayout()).setHGap(5);
                        ((TableLayout)panelMaintainability.getLayout()).setVGap(5);

                        //---- labelMaintainability ----
                        labelMaintainability.setText("Maintainability");
                        labelMaintainability.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        labelMaintainability.setForeground(Color.black);
                        panelMaintainability.add(labelMaintainability, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- radioButtonMaintained ----
                        radioButtonMaintained.setText("Maintained");
                        radioButtonMaintained.setBackground(Color.white);
                        radioButtonMaintained.setForeground(Color.black);
                        radioButtonMaintained.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonMaintained.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonMaintainedMouseClicked(e);
                            }
                        });
                        panelMaintainability.add(radioButtonMaintained, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- radioButtonNeeds ----
                        radioButtonNeeds.setText("Needs Maintenance");
                        radioButtonNeeds.setBackground(Color.white);
                        radioButtonNeeds.setForeground(Color.black);
                        radioButtonNeeds.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonNeeds.setSelected(true);
                        radioButtonNeeds.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonNeedsMouseClicked(e);
                            }
                        });
                        panelMaintainability.add(radioButtonNeeds, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));
                    }
                    panelDetailsEngine.add(panelMaintainability, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer5 ----
                    hSpacer5.setBackground(Color.white);
                    hSpacer5.setMinimumSize(new Dimension(30, 12));
                    hSpacer5.setPreferredSize(new Dimension(50, 10));
                    panelDetailsEngine.add(hSpacer5, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake5 ========
                    {
                        panelFake5.setBackground(Color.white);

                        GroupLayout panelFake5Layout = new GroupLayout(panelFake5);
                        panelFake5.setLayout(panelFake5Layout);
                        panelFake5Layout.setHorizontalGroup(
                            panelFake5Layout.createParallelGroup()
                                .addGap(0, 355, Short.MAX_VALUE)
                        );
                        panelFake5Layout.setVerticalGroup(
                            panelFake5Layout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelDetailsEngine.add(panelFake5, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer6 ----
                    hSpacer6.setBackground(Color.white);
                    hSpacer6.setMinimumSize(new Dimension(30, 12));
                    hSpacer6.setPreferredSize(new Dimension(50, 10));
                    panelDetailsEngine.add(hSpacer6, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake2 ========
                    {
                        panelFake2.setBackground(Color.white);

                        GroupLayout panelFake2Layout = new GroupLayout(panelFake2);
                        panelFake2.setLayout(panelFake2Layout);
                        panelFake2Layout.setHorizontalGroup(
                            panelFake2Layout.createParallelGroup()
                                .addGap(0, 355, Short.MAX_VALUE)
                        );
                        panelFake2Layout.setVerticalGroup(
                            panelFake2Layout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelDetailsEngine.add(panelFake2, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer8 ----
                    vSpacer8.setBackground(Color.white);
                    vSpacer8.setPreferredSize(new Dimension(50, 10));
                    vSpacer8.setMinimumSize(new Dimension(50, 10));
                    panelDetailsEngine.add(vSpacer8, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelOccupation ========
                    {
                        panelOccupation.setBackground(Color.white);
                        panelOccupation.setLayout(new TableLayout(new double[][] {
                            {TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL},
                            {50}}));
                        ((TableLayout)panelOccupation.getLayout()).setHGap(5);
                        ((TableLayout)panelOccupation.getLayout()).setVGap(5);

                        //---- labelOccupation ----
                        labelOccupation.setText("Occupation");
                        labelOccupation.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        labelOccupation.setForeground(Color.black);
                        panelOccupation.add(labelOccupation, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- radioButtonOccupied ----
                        radioButtonOccupied.setText("Occupied");
                        radioButtonOccupied.setBackground(Color.white);
                        radioButtonOccupied.setForeground(Color.black);
                        radioButtonOccupied.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonOccupied.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonOccupiedMouseClicked(e);
                            }
                        });
                        panelOccupation.add(radioButtonOccupied, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- radioButtonEmpty ----
                        radioButtonEmpty.setText("Empty");
                        radioButtonEmpty.setBackground(Color.white);
                        radioButtonEmpty.setForeground(Color.black);
                        radioButtonEmpty.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonEmpty.setSelected(true);
                        radioButtonEmpty.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonEmptyMouseClicked(e);
                            }
                        });
                        panelOccupation.add(radioButtonEmpty, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));
                    }
                    panelDetailsEngine.add(panelOccupation, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer9 ----
                    vSpacer9.setBackground(Color.white);
                    vSpacer9.setPreferredSize(new Dimension(50, 10));
                    vSpacer9.setMinimumSize(new Dimension(50, 10));
                    panelDetailsEngine.add(vSpacer9, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelRoom ----
                    labelRoom.setText("Room");
                    labelRoom.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelRoom.setForeground(Color.black);
                    panelDetailsEngine.add(labelRoom, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- comboBoxRoom ----
                    comboBoxRoom.setBackground(Color.white);
                    comboBoxRoom.setForeground(new Color(32, 32, 82));
                    comboBoxRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelDetailsEngine.add(comboBoxRoom, new TableLayoutConstraints(0, 6, 0, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelDetailsEngine, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelDetailsOperational ========
                {
                    panelDetailsOperational.setBackground(Color.white);
                    panelDetailsOperational.setVisible(false);
                    panelDetailsOperational.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {50, 30, 50}}));
                    ((TableLayout)panelDetailsOperational.getLayout()).setHGap(5);
                    ((TableLayout)panelDetailsOperational.getLayout()).setVGap(5);

                    //======== panelSterilization ========
                    {
                        panelSterilization.setBackground(Color.white);
                        panelSterilization.setLayout(new TableLayout(new double[][] {
                            {TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL},
                            {50}}));
                        ((TableLayout)panelSterilization.getLayout()).setHGap(5);
                        ((TableLayout)panelSterilization.getLayout()).setVGap(5);

                        //---- labelAvailability2 ----
                        labelAvailability2.setText("Serilization");
                        labelAvailability2.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        labelAvailability2.setForeground(Color.black);
                        panelSterilization.add(labelAvailability2, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- radioButtonSterilized ----
                        radioButtonSterilized.setText("Sterilized");
                        radioButtonSterilized.setBackground(Color.white);
                        radioButtonSterilized.setForeground(Color.black);
                        radioButtonSterilized.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonSterilized.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonSterilizedMouseClicked(e);
                            }
                        });
                        panelSterilization.add(radioButtonSterilized, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- radioButtonNeedsSteri ----
                        radioButtonNeedsSteri.setText("Needs Sterilization");
                        radioButtonNeedsSteri.setBackground(Color.white);
                        radioButtonNeedsSteri.setForeground(Color.black);
                        radioButtonNeedsSteri.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonNeedsSteri.setSelected(true);
                        radioButtonNeedsSteri.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonNeedsSteriMouseClicked(e);
                            }
                        });
                        panelSterilization.add(radioButtonNeedsSteri, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));
                    }
                    panelDetailsOperational.add(panelSterilization, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer7 ----
                    hSpacer7.setBackground(Color.white);
                    hSpacer7.setMinimumSize(new Dimension(30, 12));
                    hSpacer7.setPreferredSize(new Dimension(50, 10));
                    panelDetailsOperational.add(hSpacer7, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake6 ========
                    {
                        panelFake6.setBackground(Color.white);

                        GroupLayout panelFake6Layout = new GroupLayout(panelFake6);
                        panelFake6.setLayout(panelFake6Layout);
                        panelFake6Layout.setHorizontalGroup(
                            panelFake6Layout.createParallelGroup()
                                .addGap(0, 355, Short.MAX_VALUE)
                        );
                        panelFake6Layout.setVerticalGroup(
                            panelFake6Layout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelDetailsOperational.add(panelFake6, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer8 ----
                    hSpacer8.setBackground(Color.white);
                    hSpacer8.setMinimumSize(new Dimension(30, 12));
                    hSpacer8.setPreferredSize(new Dimension(50, 10));
                    panelDetailsOperational.add(hSpacer8, new TableLayoutConstraints(3, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake3 ========
                    {
                        panelFake3.setBackground(Color.white);

                        GroupLayout panelFake3Layout = new GroupLayout(panelFake3);
                        panelFake3.setLayout(panelFake3Layout);
                        panelFake3Layout.setHorizontalGroup(
                            panelFake3Layout.createParallelGroup()
                                .addGap(0, 355, Short.MAX_VALUE)
                        );
                        panelFake3Layout.setVerticalGroup(
                            panelFake3Layout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelDetailsOperational.add(panelFake3, new TableLayoutConstraints(4, 0, 4, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- vSpacer10 ----
                    vSpacer10.setBackground(Color.white);
                    vSpacer10.setPreferredSize(new Dimension(50, 10));
                    vSpacer10.setMinimumSize(new Dimension(50, 10));
                    panelDetailsOperational.add(vSpacer10, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelReusability ========
                    {
                        panelReusability.setBackground(Color.white);
                        panelReusability.setLayout(new TableLayout(new double[][] {
                            {TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL},
                            {50}}));
                        ((TableLayout)panelReusability.getLayout()).setHGap(5);
                        ((TableLayout)panelReusability.getLayout()).setVGap(5);

                        //---- labelReusability ----
                        labelReusability.setText("Reusability");
                        labelReusability.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        labelReusability.setForeground(Color.black);
                        panelReusability.add(labelReusability, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- radioButtonReusable ----
                        radioButtonReusable.setText("Reusable");
                        radioButtonReusable.setBackground(Color.white);
                        radioButtonReusable.setForeground(Color.black);
                        radioButtonReusable.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonReusable.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonReuseMouseClicked(e);
                            }
                        });
                        panelReusability.add(radioButtonReusable, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- radioButtonDisposable ----
                        radioButtonDisposable.setText("Disposable");
                        radioButtonDisposable.setBackground(Color.white);
                        radioButtonDisposable.setForeground(Color.black);
                        radioButtonDisposable.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                        radioButtonDisposable.setSelected(true);
                        radioButtonDisposable.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                radioButtonDisposeMouseClicked(e);
                            }
                        });
                        panelReusability.add(radioButtonDisposable, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));
                    }
                    panelDetailsOperational.add(panelReusability, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelDetailsOperational, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelDetailsSterilization ========
                {
                    panelDetailsSterilization.setBackground(Color.white);
                    panelDetailsSterilization.setVisible(false);
                    panelDetailsSterilization.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, 50}}));
                    ((TableLayout)panelDetailsSterilization.getLayout()).setHGap(5);
                    ((TableLayout)panelDetailsSterilization.getLayout()).setVGap(5);

                    //---- labelSteriType ----
                    labelSteriType.setText("Sterilization Type");
                    labelSteriType.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelSteriType.setForeground(Color.black);
                    panelDetailsSterilization.add(labelSteriType, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- comboBoxSterilization ----
                    comboBoxSterilization.setBackground(Color.white);
                    comboBoxSterilization.setForeground(new Color(32, 32, 82));
                    comboBoxSterilization.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelDetailsSterilization.add(comboBoxSterilization, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer9 ----
                    hSpacer9.setBackground(Color.white);
                    hSpacer9.setMinimumSize(new Dimension(30, 12));
                    hSpacer9.setPreferredSize(new Dimension(50, 10));
                    panelDetailsSterilization.add(hSpacer9, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake7 ========
                    {
                        panelFake7.setBackground(Color.white);

                        GroupLayout panelFake7Layout = new GroupLayout(panelFake7);
                        panelFake7.setLayout(panelFake7Layout);
                        panelFake7Layout.setHorizontalGroup(
                            panelFake7Layout.createParallelGroup()
                                .addGap(0, 355, Short.MAX_VALUE)
                        );
                        panelFake7Layout.setVerticalGroup(
                            panelFake7Layout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelDetailsSterilization.add(panelFake7, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- hSpacer10 ----
                    hSpacer10.setBackground(Color.white);
                    hSpacer10.setMinimumSize(new Dimension(30, 12));
                    hSpacer10.setPreferredSize(new Dimension(50, 10));
                    panelDetailsSterilization.add(hSpacer10, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //======== panelFake4 ========
                    {
                        panelFake4.setBackground(Color.white);

                        GroupLayout panelFake4Layout = new GroupLayout(panelFake4);
                        panelFake4.setLayout(panelFake4Layout);
                        panelFake4Layout.setHorizontalGroup(
                            panelFake4Layout.createParallelGroup()
                                .addGap(0, 355, Short.MAX_VALUE)
                        );
                        panelFake4Layout.setVerticalGroup(
                            panelFake4Layout.createParallelGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                        );
                    }
                    panelDetailsSterilization.add(panelFake4, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelDetailsSterilization, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelFooter ========
                {
                    panelFooter.setBackground(Color.white);
                    panelFooter.setLayout(null);

                    //---- buttonAddEquip ----
                    buttonAddEquip.setText("ADD");
                    buttonAddEquip.setBackground(new Color(32, 32, 82));
                    buttonAddEquip.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    buttonAddEquip.setForeground(Color.white);
                    buttonAddEquip.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonAddEquipMouseClicked(e);
                        }
                    });
                    panelFooter.add(buttonAddEquip);
                    buttonAddEquip.setBounds(0, 105, 190, 35);

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
                panelBody.add(panelFooter, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.RIGHT, TableLayoutConstraints.BOTTOM));
            }
            scrollPane1.setViewportView(panelBody);
        }
        add(scrollPane1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        productionDate = new DatePicker();
        productionDate.setBackground(Color.white);
        productionDate.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
        panelProduction.add(productionDate);
        expiryDate = new DatePicker();
        expiryDate.setBackground(Color.white);
        expiryDate.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
        panelExpiry.add(expiryDate);
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
    private JPanel panelEquipmentHeader;
    private JLabel textEquipInfo;
    private JSeparator separatorEquip;
    private JPanel panelEquipBody;
    private JLabel labelType;
    private JTextField textFieldName;
    private JComboBox comboBoxEquipType;
    private JLabel labelNameError;
    private JPanel vSpacer7;
    private JTextField textFieldPrice;
    private JPanel hSpacer1;
    private JLabel labelPriceError;
    private JPanel vSpacer2;
    private JPanel panelAvailability;
    private JLabel labelAvailability;
    private JRadioButton radioButtonAvailable;
    private JRadioButton radioButtonDepleted;
    private JPanel vSpacer3;
    private JTextField textFieldQuantity;
    private JLabel labelQuantityError;
    private JPanel panelDetailsHeader;
    private JLabel textDetailsInfo;
    private JSeparator separatorDetails;
    private JPanel panelDetailsDrug;
    private JLabel labelProduction;
    private JLabel labelExpiry;
    private JPanel panelProduction;
    private JPanel hSpacer3;
    private JPanel panelExpiry;
    private JPanel hSpacer4;
    private JPanel panelFake;
    private JPanel panelDetailsEngine;
    private JPanel panelMaintainability;
    private JLabel labelMaintainability;
    private JRadioButton radioButtonMaintained;
    private JRadioButton radioButtonNeeds;
    private JPanel hSpacer5;
    private JPanel panelFake5;
    private JPanel hSpacer6;
    private JPanel panelFake2;
    private JPanel vSpacer8;
    private JPanel panelOccupation;
    private JLabel labelOccupation;
    private JRadioButton radioButtonOccupied;
    private JRadioButton radioButtonEmpty;
    private JPanel vSpacer9;
    private JLabel labelRoom;
    private JComboBox comboBoxRoom;
    private JPanel panelDetailsOperational;
    private JPanel panelSterilization;
    private JLabel labelAvailability2;
    private JRadioButton radioButtonSterilized;
    private JRadioButton radioButtonNeedsSteri;
    private JPanel hSpacer7;
    private JPanel panelFake6;
    private JPanel hSpacer8;
    private JPanel panelFake3;
    private JPanel vSpacer10;
    private JPanel panelReusability;
    private JLabel labelReusability;
    private JRadioButton radioButtonReusable;
    private JRadioButton radioButtonDisposable;
    private JPanel panelDetailsSterilization;
    private JLabel labelSteriType;
    private JComboBox comboBoxSterilization;
    private JPanel hSpacer9;
    private JPanel panelFake7;
    private JPanel hSpacer10;
    private JPanel panelFake4;
    private JPanel panelFooter;
    private JButton buttonAddEquip;
    private JLabel labelTooth;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static JFrame frame = new JFrame("Home Frame");
    private DatePicker productionDate, expiryDate;
    private List<JPanel> panels = new ArrayList<>();
    private C_Equipment equipmentController = new C_Equipment();
}
