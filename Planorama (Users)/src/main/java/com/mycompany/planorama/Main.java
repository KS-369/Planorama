/**
 * Main.java
 * Located at: src/main/java/com/mycompany/planorama/Main.java
 */
package com.mycompany.planorama;

import com.mycompany.planorama.Controller.AuthController;
import com.mycompany.planorama.Model.UserModel;
import com.mycompany.planorama.Model.Session;
import com.mycompany.planorama.View.LoginUI;
import com.mycompany.planorama_EventsManager.Controller.Controller;
import com.mycompany.planorama_EventsManager.Model.DBconnector;
import com.mycompany.planorama_EventsManager.View.EventManagementUI;

public class Main {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        LoginUI view = new LoginUI();
        new AuthController(model, view);
    }
    
    // Method to launch event management after successful login
    public static void launchEventManager() {
        String username = Session.getCurrentUsername();
        if (username != null && !username.isEmpty()) {
            DBconnector db = new DBconnector("events.db");
            EventManagementUI ui = new EventManagementUI(null);
            Controller controller = new Controller(db, ui);
            ui.setController(controller);
            
            // Load events for this specific user
            controller.loadEvents(username);
        }
    }
}
