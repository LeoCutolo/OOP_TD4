package com.leo.td4_tutorial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}