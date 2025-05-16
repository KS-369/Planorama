package com.mycompany.planorama.view;

import javax.swing.*;
import java.awt.*;
import com.mycompany.planorama.Main;

public class LoginSuccessUI extends JFrame {
    
    public LoginSuccessUI(String message) {
        setTitle("Success");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));

        JButton continueButton = new JButton("Continue to Event Manager");
        continueButton.addActionListener(e -> {
            dispose(); // Close this window
            Main.launchEventManager();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(continueButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
