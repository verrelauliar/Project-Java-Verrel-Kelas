/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.verrel.main;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Verrel
 */
public class FormDeskripsi extends JDialog {
    
    public FormDeskripsi(FormUtama parent, boolean modal){
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }
    
    private void initComponents() {
        setTitle("Deskripsi Aplikasi");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(204, 255, 255));
        
        // Title Label
        JLabel titleLabel = new JLabel("Aplikasi Gaji Karyawan");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Description Text Area
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setText("Sistem manajemen penggajian berbasis desktop untuk mengelola data karyawan, "
                + "pekerjaan, dan perhitungan gaji dengan fitur autentikasi dan laporan PDF.");
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFocusable(false);
        descriptionArea.setBackground(new Color(204, 255, 255));
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        mainPanel.add(descriptionArea, BorderLayout.CENTER);
        
        // Close Button
        JButton closeButton = new JButton("Tutup");
        closeButton.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(204, 255, 255));
        buttonPanel.add(closeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        setSize(400, 200);
    }
}
