/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planorama;

/**
 *
 * @author Kalli-Ann
 */

import com.mycompany.Planorama_LoginPage.Controller1.AuthController;
import com.mycompany.Planorama_LoginPage.Model1.UserModel;
import com.mycompany.Planorama_LoginPage.View1.LoginUI;

public class LoginHome {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        LoginUI view = new LoginUI();
        new AuthController(model, view);
    }
}

