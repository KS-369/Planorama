package com.mycompany.planorama.view;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    public JTextField usernameField = new JTextField(15);
    public JPasswordField passwordField = new JPasswordField(15);
    public JButton loginButton = new JButton("Login");
    public JButton registerButton = new JButton("Register");
    public JLabel messageLabel = new JLabel("");
    
    public LoginUI() {
        setTitle("Login Page");
        setSize(1200, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // grid bag layout
        gbc.insets = new Insets(10, 10, 10, 10); // spacing around components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(registerButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(messageLabel, gbc);

        // Limit component preferred sizes
        usernameField.setPreferredSize(new Dimension(200, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));
        loginButton.setPreferredSize(new Dimension(100, 30));
        registerButton.setPreferredSize(new Dimension(100, 30));

        add(panel);
        setVisible(true);
    }
    
    public String getUsername() {
        return usernameField.getText();
    }
    
    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    
    public void setMessage(String msg) {
        messageLabel.setText(msg);
    }
}
