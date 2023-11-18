package com.example.advjavaassignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PokemonViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}