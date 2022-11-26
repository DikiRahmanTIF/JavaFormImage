package com.DRTIF.FormImage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame= new JFrame("Registrasi Bank");
        jFrame.setContentPane(new FormWithImage().getRootPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 480);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
