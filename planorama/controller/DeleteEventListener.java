package com.mycompany.planorama.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.planorama.model.Event;
import com.mycompany.planorama.view.EventManagementUI;

public class DeleteEventListener implements ActionListener {
    private Event event;
    private EventController controller;
    private EventManagementUI ui;    

    public DeleteEventListener(Event event, EventController controller, EventManagementUI ui) {
        this.event = event;
        this.controller = controller;
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.deleteEvent(event.getTitle());
        ui.refreshEventList();
    }
}
