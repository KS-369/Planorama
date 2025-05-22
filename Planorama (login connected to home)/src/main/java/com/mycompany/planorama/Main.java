/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planorama;

/**
 *
 * @author Kalli-Ann
 */

import com.mycompany.planorama.Controller.AuthController;
import com.mycompany.planorama.Model.UserModel;
import com.mycompany.planorama.View.LoginUI;

public class Main {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        LoginUI view = new LoginUI();
        new AuthController(model, view);
    }
}

