package com.mycompany.planorama;

import com.mycompany.planorama.controller.AuthController;
import com.mycompany.planorama.controller.EventController;
import com.mycompany.planorama.model.DBConnector;
import com.mycompany.planorama.model.Session;
import com.mycompany.planorama.model.UserModel;
import com.mycompany.planorama.view.EventManagementUI;
import com.mycompany.planorama.view.LoginUI;

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
            DBConnector db = new DBConnector("events.db");
            EventManagementUI ui = new EventManagementUI(null);
            EventController controller = new EventController(db, ui);
            ui.setController(controller);
            
            // Load events for this specific user
            controller.loadEvents(username);
        }
    }
}
