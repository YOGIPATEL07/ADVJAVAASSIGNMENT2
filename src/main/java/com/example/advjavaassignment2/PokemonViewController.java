package com.example.advjavaassignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PokemonViewController {

    @FXML
    private ListView<Pokemon> listView;

    @FXML
    private Label warningLabel;

    @FXML
    private ImageView ImageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private Label resultsMessage;

    @FXML
    private TextField searchField;

    @FXML
    private VBox ImageVBox;

    @FXML
    private VBox titlesBox;

    @FXML
    private void initialize()
    {
        progressBar.setVisible(false);
        ImageVBox.setVisible(false);
        titlesBox.setVisible(false);
        warningLabel.setVisible(false);

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, pokemonSelected) -> {
            if (pokemonSelected != null) {
                ImageVBox.setVisible(true);
                Pokemon.PokemonImages images = pokemonSelected.getImages();
                if (images != null) {
                    String symbolUrl = images.getSmallImage();
                    if (symbolUrl != null && !symbolUrl.isEmpty()) {
                        try {
                            ImageView.setImage(new Image(symbolUrl));
                        } catch (IllegalArgumentException e) {
                            ImageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.jpg")));
                        }
                        return;
                    }
                }
                ImageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.jpg")));
            } else {
                ImageVBox.setVisible(false);
            }
        });

    }

    @FXML
    private void searchForPokemon(ActionEvent event) throws IOException, InterruptedException {
        String pokemonName = searchField.getText().trim();
        ApiResponse apiResponse = APIUtility.recieveAPI(pokemonName);
        if (apiResponse.getPokemons() != null && !apiResponse.getPokemons().isEmpty()) {
            titlesBox.setVisible(true);
            warningLabel.setVisible(false);
            listView.getItems().clear();
            listView.getItems().addAll(apiResponse.getPokemons());
            resultsMessage.setText("Showing " + listView.getItems().size() + " of " + apiResponse.getTotalData());
        } else {
            ImageView.setImage(null);
            ImageVBox.setVisible(false);

            titlesBox.setVisible(false);
            warningLabel.setVisible(true);
            warningLabel.setText("No Pokemon found for the given name.");
        }
    }



    @FXML
    void getPokemonDetails(ActionEvent event) throws IOException {
        Pokemon pokemonSelected = listView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event, "details-view.fxml", pokemonSelected.getId());
    }
}


