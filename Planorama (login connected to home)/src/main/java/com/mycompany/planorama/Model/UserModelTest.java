/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planorama.Model;

/**
 *
 * @author Kalli-Ann
 */

// passes all unit tests

public class UserModelTest {
    public static void main(String[] args) {
        UserModel model = new UserModel();

        // test registration with a new user
        assert model.register("testuser1", "testpass") : "Should register new user";

        // test duplicate registration
        assert !model.register("testuser1", "testpass") : "Should fail to register duplicate user";

        // test login with correct credentials
        assert model.authenticate("testuser1", "testpass") : "Login should succeed with correct credentials";

        // test login with incorrect password
        assert !model.authenticate("testuser1", "wrongpass") : "Login should fail with incorrect password";

        // test login with non-existent user
        assert !model.authenticate("nouser", "nopass") : "Login should fail for non-existent user";

        // test empty inputs (if your model throws exceptions or rejects them)
        assert !model.authenticate("", "") : "Login should fail for empty input";

        System.out.println("All unit tests passed.");
    }
}
