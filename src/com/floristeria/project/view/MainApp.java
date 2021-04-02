package com.floristeria.project.view;

import com.floristeria.project.application.Controller;
import com.floristeria.project.view.frames.FloristView;

public class MainApp {

    private static Controller controller=Controller.getInstance();

    public static void main(String[] args) {

        FloristView floristManagement= FloristView.getInstance(controller);
        floristManagement.setVisible(true);

    }
}

