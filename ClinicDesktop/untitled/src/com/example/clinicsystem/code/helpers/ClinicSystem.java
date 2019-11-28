package com.example.clinicsystem.code.helpers;

import com.example.clinicsystem.code.views.V_LoginForm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ClinicSystem {
    public static JFrame mainFrame = new JFrame("Main Frame");
    public static List<String> governorates = new ArrayList<>();
    public static List<String> cairoCities = new ArrayList<>();
    public static List<String> alexCities = new ArrayList<>();

    public static void main(String[] args) {
        addGovernorate();
        addCities();

        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.add(new V_LoginForm());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void addGovernorate() {
        governorates.add("Cairo");
        governorates.add("Alexandria");
    }

    public static void addCities() {
        cairoCities.add("Cairo");
        cairoCities.add("6th of October");
        alexCities.add("Alexandria");
    }
}