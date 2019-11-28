/*
 * Created by JFormDesigner on Tue Nov 26 19:38:24 EET 2019
 */

package com.example.clinicsystem.code.views;

import com.example.clinicsystem.code.controllers.C_User;
import com.example.clinicsystem.code.helpers.ClinicSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Dania
 */
public class V_LoginForm extends JPanel {
    public V_LoginForm() {
        initComponents();
    }

    private void textFieldUsernameFocusGained(FocusEvent e) {
        String username = textFieldUsername.getText().toString();

        if(username.equals("ID")) {
            textFieldUsername.setText("");
            textFieldUsername.setForeground(new Color(0, 0, 0));
        }
    }

    private void textFieldUsernameFocusLost(FocusEvent e) {
        String username = textFieldUsername.getText().toString();

        if(username.equals("")) {
            textFieldUsername.setText("ID");
            textFieldUsername.setForeground(new Color(128, 128, 128));
        }
    }

    private void buttonSignInMouseClicked(MouseEvent e) {
        String username = textFieldUsername.getText();
        String password = passwordField.getText();

        if (!userController.ifUserExist(username, password)) {
            JOptionPane.showMessageDialog(null, "Incorrect Information, User Not Found");
        } else {
            JOptionPane.showMessageDialog(null, "Welcome Back");

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.add(new V_HomeForm());
            frame.pack();
            frame.setVisible(true);
            ClinicSystem.mainFrame.dispose();
        }
    }

    private void passwordFieldFocusGained(FocusEvent e) {
        String password = passwordField.getText().toString();

        if(password.equals("Password")) {
            passwordField.setText("");
            passwordField.setForeground(new Color(0, 0, 0));
        }
    }

    private void passwordFieldFocusLost(FocusEvent e) {
        String password = passwordField.getText().toString();

        if(password.equals("")) {
            passwordField.setText("Password");
            passwordField.setForeground(new Color(128, 128, 128));
        }
    }

    private void labelContactMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dania
        panelHeader = new JPanel();
        labelTooth = new JLabel();
        labelMSA = new JLabel();
        panelBody = new JPanel();
        labelLogin = new JLabel();
        labelInvisible1 = new JLabel();
        vSpacer1 = new JPanel(null);
        labelInvisible2 = new JLabel();
        textFieldUsername = new JTextField();
        hSpacer1 = new JPanel(null);
        vSpacer4 = new JPanel(null);
        buttonSignIn = new JButton();
        vSpacer2 = new JPanel(null);
        passwordField = new JPasswordField();
        vSpacer3 = new JPanel(null);
        labelForgot = new JLabel();
        labelContact = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(1200, 1080));
        setPreferredSize(new Dimension(1920, 1200));
        setBackground(new Color(32, 32, 82));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //======== panelHeader ========
        {
            panelHeader.setBackground(Color.white);

            //---- labelTooth ----
            labelTooth.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/tooth_purple.png")));
            labelTooth.setHorizontalAlignment(SwingConstants.LEFT);

            //---- labelMSA ----
            labelMSA.setText("text");
            labelMSA.setIcon(new ImageIcon(getClass().getResource("/com/example/clinicsystem/pictures/msa_logo.jpg")));
            labelMSA.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
            panelHeader.setLayout(panelHeaderLayout);
            panelHeaderLayout.setHorizontalGroup(
                panelHeaderLayout.createParallelGroup()
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(labelTooth)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 837, Short.MAX_VALUE)
                        .addComponent(labelMSA, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panelHeaderLayout.setVerticalGroup(
                panelHeaderLayout.createParallelGroup()
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTooth)
                            .addComponent(labelMSA))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panelBody ========
        {
            panelBody.setBackground(new Color(32, 32, 82));
            panelBody.setLayout(new GridBagLayout());

            //---- labelLogin ----
            labelLogin.setText("Login");
            labelLogin.setFont(new Font("Alike", Font.PLAIN, 26));
            labelLogin.setForeground(Color.white);
            labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
            panelBody.add(labelLogin, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- labelInvisible1 ----
            labelInvisible1.setText("Contact the Admin");
            labelInvisible1.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
            labelInvisible1.setForeground(new Color(32, 32, 82));
            panelBody.add(labelInvisible1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- vSpacer1 ----
            vSpacer1.setBackground(new Color(32, 32, 82));
            vSpacer1.setPreferredSize(new Dimension(10, 50));
            panelBody.add(vSpacer1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- labelInvisible2 ----
            labelInvisible2.setText("Forgot Your Password?");
            labelInvisible2.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
            labelInvisible2.setForeground(new Color(32, 32, 82));
            panelBody.add(labelInvisible2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- textFieldUsername ----
            textFieldUsername.setBackground(Color.white);
            textFieldUsername.setForeground(Color.gray);
            textFieldUsername.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
            textFieldUsername.setText("ID");
            textFieldUsername.setPreferredSize(new Dimension(85, 36));
            textFieldUsername.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    textFieldUsernameFocusGained(e);
                }
                @Override
                public void focusLost(FocusEvent e) {
                    textFieldUsernameFocusLost(e);
                }
            });
            panelBody.add(textFieldUsername, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- hSpacer1 ----
            hSpacer1.setPreferredSize(new Dimension(150, 10));
            hSpacer1.setBackground(new Color(32, 32, 82));
            panelBody.add(hSpacer1, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- vSpacer4 ----
            vSpacer4.setBackground(new Color(32, 32, 82));
            vSpacer4.setPreferredSize(new Dimension(10, 30));
            panelBody.add(vSpacer4, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- buttonSignIn ----
            buttonSignIn.setText("Sign In");
            buttonSignIn.setBackground(Color.white);
            buttonSignIn.setForeground(new Color(32, 32, 82));
            buttonSignIn.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
            buttonSignIn.setPreferredSize(new Dimension(78, 36));
            buttonSignIn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonSignInMouseClicked(e);
                }
            });
            panelBody.add(buttonSignIn, new GridBagConstraints(5, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- vSpacer2 ----
            vSpacer2.setBackground(new Color(32, 32, 82));
            vSpacer2.setPreferredSize(new Dimension(10, 20));
            panelBody.add(vSpacer2, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- passwordField ----
            passwordField.setForeground(Color.black);
            passwordField.setBackground(Color.white);
            passwordField.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
            passwordField.setPreferredSize(new Dimension(17, 36));
            passwordField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    passwordFieldFocusGained(e);
                }
                @Override
                public void focusLost(FocusEvent e) {
                    passwordFieldFocusLost(e);
                }
            });
            panelBody.add(passwordField, new GridBagConstraints(0, 4, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- vSpacer3 ----
            vSpacer3.setBackground(new Color(32, 32, 82));
            vSpacer3.setPreferredSize(new Dimension(10, 30));
            panelBody.add(vSpacer3, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- labelForgot ----
            labelForgot.setText("Forgot Your Password?");
            labelForgot.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
            labelForgot.setForeground(Color.white);
            panelBody.add(labelForgot, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- labelContact ----
            labelContact.setText("Contact the Admin");
            labelContact.setFont(new Font("Helvetica-Normal", Font.PLAIN, 14));
            labelContact.setForeground(new Color(223, 172, 55));
            labelContact.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    labelContactMouseClicked(e);
                }
            });
            panelBody.add(labelContact, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(panelHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 1075, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dania
    private JPanel panelHeader;
    private JLabel labelTooth;
    private JLabel labelMSA;
    private JPanel panelBody;
    private JLabel labelLogin;
    private JLabel labelInvisible1;
    private JPanel vSpacer1;
    private JLabel labelInvisible2;
    private JTextField textFieldUsername;
    private JPanel hSpacer1;
    private JPanel vSpacer4;
    private JButton buttonSignIn;
    private JPanel vSpacer2;
    private JPasswordField passwordField;
    private JPanel vSpacer3;
    private JLabel labelForgot;
    private JLabel labelContact;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static JFrame frame = new JFrame("Home Frame");
    private C_User userController = new C_User();
}
