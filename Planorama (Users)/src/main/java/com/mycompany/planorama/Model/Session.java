/**
 * Session.java
 * Located at: src/main/java/com/mycompany/planorama/Model/Session.java
 */
package com.mycompany.planorama.Model;

public class Session {
    private static String currentUsername;

    public static void setCurrentUsername(String username) {
        currentUsername = username;
    }

    public static String getCurrentUsername() {
        return currentUsername;
    }
}
