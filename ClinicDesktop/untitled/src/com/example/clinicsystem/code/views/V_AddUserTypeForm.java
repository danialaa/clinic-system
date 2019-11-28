/*
 * Created by JFormDesigner on Wed Nov 27 21:29:12 EET 2019
 */

package com.example.clinicsystem.code.views;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Dania
 */
public class V_AddUserTypeForm extends JPanel {
    public V_AddUserTypeForm() {
        initComponents();
    }

    private void labelHome2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void labelEdit2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void labelShrinkMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void labelExpandMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void buttonAddTypeMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dania
        panelExpanded = new JPanel();
        panelExpandedNav = new JPanel();
        labelHome2 = new JLabel();
        labelEdit2 = new JLabel();
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
        labelEdit = new JLabel();
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
        panelTypeHeader = new JPanel();
        textTypeInfo = new JLabel();
        separatorEmp = new JSeparator();
        panelTypeBody = new JPanel();
        labelType = new JLabel();
        textFieldTypeName = new JTextField();
        comboBoxType = new JComboBox();
        labelTypeError = new JLabel();
        buttonAddPermission = new JButton();
        panel2 = new JPanel();
        labelClearTable = new JLabel();
        labelEditTable = new JLabel();
        hSpacer1 = new JPanel(null);
        panelPermissionsTable = new JPanel();
        panelTableHeader = new JPanel();
        labelTableHeader = new JLabel();
        labelDeletePermission = new JLabel();
        labelPermissionName = new JLabel();
        hSpacer2 = new JPanel(null);
        panelFooter = new JPanel();
        buttonAdd = new JButton();
        labelTooth = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(1920, 1080));
        setPreferredSize(new Dimension(1920, 1200));
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
        ,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
        ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red),
         getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
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

                //---- labelEdit2 ----
                labelEdit2.setBackground(new Color(32, 32, 82));
                labelEdit2.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/edit.png")));
                labelEdit2.setHorizontalAlignment(SwingConstants.CENTER);
                labelEdit2.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelEdit2.setForeground(Color.white);
                labelEdit2.setText("Edit");
                labelEdit2.setIconTextGap(30);
                labelEdit2.addMouseListener(new MouseAdapter() {
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
                                .addComponent(labelEdit2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelHome2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panelExpandedNavLayout.setVerticalGroup(
                    panelExpandedNavLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelExpandedNavLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(labelHome2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelEdit2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
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

                //---- labelEdit ----
                labelEdit.setBackground(new Color(32, 32, 82));
                labelEdit.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/edit.png")));
                labelEdit.setHorizontalAlignment(SwingConstants.CENTER);
                labelEdit.setFont(new Font("Helvetica-Normal", Font.PLAIN, 20));
                labelEdit.setForeground(Color.white);
                labelEdit.setIconTextGap(30);

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
                                        .addComponent(labelEdit, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelHome, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelLogout, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap())
                );
                panelShrinkedNavLayout.setVerticalGroup(
                    panelShrinkedNavLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelShrinkedNavLayout.createSequentialGroup()
                            .addComponent(labelHome, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelEdit, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
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
                    {300, TableLayout.FILL, 300},
                    {92, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL}}));
                ((TableLayout)panelBody.getLayout()).setHGap(5);
                ((TableLayout)panelBody.getLayout()).setVGap(5);

                //======== panelTypeHeader ========
                {
                    panelTypeHeader.setBackground(Color.white);
                    panelTypeHeader.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.FILL},
                        {93, TableLayout.PREFERRED}}));
                    ((TableLayout)panelTypeHeader.getLayout()).setHGap(5);
                    ((TableLayout)panelTypeHeader.getLayout()).setVGap(5);

                    //---- textTypeInfo ----
                    textTypeInfo.setText("User Type Info");
                    textTypeInfo.setFont(new Font("Alike", Font.PLAIN, 21));
                    textTypeInfo.setForeground(Color.black);
                    panelTypeHeader.add(textTypeInfo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    panelTypeHeader.add(separatorEmp, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));
                }
                panelBody.add(panelTypeHeader, new TableLayoutConstraints(0, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelTypeBody ========
                {
                    panelTypeBody.setBackground(Color.white);
                    panelTypeBody.setLayout(new TableLayout(new double[][] {
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.PREFERRED, 50, TableLayout.PREFERRED, 40}}));
                    ((TableLayout)panelTypeBody.getLayout()).setHGap(5);
                    ((TableLayout)panelTypeBody.getLayout()).setVGap(5);

                    //---- labelType ----
                    labelType.setText("Type Permissions");
                    labelType.setFont(new Font("Helvetica-Normal", Font.PLAIN, 12));
                    labelType.setForeground(Color.black);
                    panelTypeBody.add(labelType, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.BOTTOM));

                    //---- textFieldTypeName ----
                    textFieldTypeName.setBackground(Color.white);
                    textFieldTypeName.setForeground(Color.gray);
                    textFieldTypeName.setFont(new Font("Helvetica-Normal", Font.PLAIN, 15));
                    textFieldTypeName.setBorder(new TitledBorder(new EtchedBorder(new Color(66, 66, 135), new Color(139, 139, 195)), "Type Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("Helvetica-Normal", Font.PLAIN, 12), Color.black));
                    textFieldTypeName.setText("e.g. Admin");
                    panelTypeBody.add(textFieldTypeName, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- comboBoxType ----
                    comboBoxType.setBackground(Color.white);
                    comboBoxType.setForeground(new Color(32, 32, 82));
                    comboBoxType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelTypeBody.add(comboBoxType, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelTypeError ----
                    labelTypeError.setForeground(new Color(191, 44, 39));
                    labelTypeError.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelTypeError.setBackground(Color.white);
                    panelTypeBody.add(labelTypeError, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- buttonAddPermission ----
                    buttonAddPermission.setText("Add Permission");
                    buttonAddPermission.setBackground(new Color(32, 32, 82));
                    buttonAddPermission.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    buttonAddPermission.setForeground(Color.white);
                    panelTypeBody.add(buttonAddPermission, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.RIGHT, TableLayoutConstraints.TOP));
                }
                panelBody.add(panelTypeBody, new TableLayoutConstraints(0, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panel2 ========
                {
                    panel2.setBackground(new Color(60, 63, 65, 0));
                    panel2.setLayout(new TableLayout(new double[][] {
                        {TableLayout.PREFERRED, TableLayout.PREFERRED},
                        {TableLayout.FILL}}));
                    ((TableLayout)panel2.getLayout()).setHGap(5);
                    ((TableLayout)panel2.getLayout()).setVGap(5);

                    //---- labelClearTable ----
                    labelClearTable.setBackground(new Color(60, 63, 65, 0));
                    labelClearTable.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/clear.png")));
                    labelClearTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panel2.add(labelClearTable, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.RIGHT, TableLayoutConstraints.BOTTOM));

                    //---- labelEditTable ----
                    labelEditTable.setBackground(new Color(60, 63, 65, 0));
                    labelEditTable.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/edit.png")));
                    labelEditTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panel2.add(labelEditTable, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.RIGHT, TableLayoutConstraints.BOTTOM));
                }
                panelBody.add(panel2, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.RIGHT, TableLayoutConstraints.FULL));

                //---- hSpacer1 ----
                hSpacer1.setBackground(new Color(60, 63, 65, 0));
                panelBody.add(hSpacer1, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelPermissionsTable ========
                {
                    panelPermissionsTable.setBackground(Color.white);
                    panelPermissionsTable.setBorder(new LineBorder(Color.lightGray));
                    panelPermissionsTable.setLayout(new TableLayout(new double[][] {
                        {37, TableLayout.FILL},
                        {45, 35}}));
                    ((TableLayout)panelPermissionsTable.getLayout()).setHGap(5);
                    ((TableLayout)panelPermissionsTable.getLayout()).setVGap(5);

                    //======== panelTableHeader ========
                    {
                        panelTableHeader.setBackground(Color.lightGray);
                        panelTableHeader.setLayout(new BorderLayout());

                        //---- labelTableHeader ----
                        labelTableHeader.setText("Permissions");
                        labelTableHeader.setBackground(new Color(60, 63, 65, 0));
                        labelTableHeader.setForeground(Color.black);
                        labelTableHeader.setFont(new Font("Helvetica-Normal", Font.PLAIN, 16));
                        labelTableHeader.setHorizontalAlignment(SwingConstants.CENTER);
                        labelTableHeader.setBorder(new LineBorder(Color.lightGray));
                        panelTableHeader.add(labelTableHeader, BorderLayout.CENTER);
                    }
                    panelPermissionsTable.add(panelTableHeader, new TableLayoutConstraints(0, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                    //---- labelDeletePermission ----
                    labelDeletePermission.setBackground(new Color(60, 63, 65, 0));
                    labelDeletePermission.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/remove.png")));
                    labelDeletePermission.setVisible(false);
                    labelDeletePermission.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panelPermissionsTable.add(labelDeletePermission, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.CENTER, TableLayoutConstraints.CENTER));

                    //---- labelPermissionName ----
                    labelPermissionName.setText("None");
                    labelPermissionName.setBackground(new Color(60, 63, 65, 0));
                    labelPermissionName.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    labelPermissionName.setForeground(Color.black);
                    panelPermissionsTable.add(labelPermissionName, new TableLayoutConstraints(0, 1, 1, 1, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));
                }
                panelBody.add(panelPermissionsTable, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //---- hSpacer2 ----
                hSpacer2.setBackground(new Color(60, 63, 65, 0));
                panelBody.add(hSpacer2, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                //======== panelFooter ========
                {
                    panelFooter.setBackground(Color.white);
                    panelFooter.setLayout(null);

                    //---- buttonAdd ----
                    buttonAdd.setText("Add");
                    buttonAdd.setBackground(new Color(32, 32, 82));
                    buttonAdd.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
                    buttonAdd.setForeground(Color.white);
                    buttonAdd.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonAddTypeMouseClicked(e);
                        }
                    });
                    panelFooter.add(buttonAdd);
                    buttonAdd.setBounds(90, 100, 190, 35);

                    //---- labelTooth ----
                    labelTooth.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/tooth_purple.png")));
                    panelFooter.add(labelTooth);
                    labelTooth.setBounds(175, 0, 110, 143);

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
                panelBody.add(panelFooter, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.RIGHT, TableLayoutConstraints.BOTTOM));
            }
            scrollPane1.setViewportView(panelBody);
        }
        add(scrollPane1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dania
    private JPanel panelExpanded;
    private JPanel panelExpandedNav;
    private JLabel labelHome2;
    private JLabel labelEdit2;
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
    private JLabel labelEdit;
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
    private JPanel panelTypeHeader;
    private JLabel textTypeInfo;
    private JSeparator separatorEmp;
    private JPanel panelTypeBody;
    private JLabel labelType;
    private JTextField textFieldTypeName;
    private JComboBox comboBoxType;
    private JLabel labelTypeError;
    private JButton buttonAddPermission;
    private JPanel panel2;
    private JLabel labelClearTable;
    private JLabel labelEditTable;
    private JPanel hSpacer1;
    private JPanel panelPermissionsTable;
    private JPanel panelTableHeader;
    private JLabel labelTableHeader;
    private JLabel labelDeletePermission;
    private JLabel labelPermissionName;
    private JPanel hSpacer2;
    private JPanel panelFooter;
    private JButton buttonAdd;
    private JLabel labelTooth;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
