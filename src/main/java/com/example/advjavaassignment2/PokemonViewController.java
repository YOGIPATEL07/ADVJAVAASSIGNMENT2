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
    private Label msgLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private Label resultsMsgLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private VBox titlesVBox;

    @FXML
    private void initialize()
    {
        progressBar.setVisible(false);
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, pokemonSelected) -> {
            if (pokemonSelected != null) {
                selectedVBox.setVisible(true);
                Pokemon.PokemonImages images = pokemonSelected.getImages();
                if (images != null) {
                    String symbolUrl = images.getSmallImage();
                    if (symbolUrl != null && !symbolUrl.isEmpty()) {
                        try {
                            posterImageView.setImage(new Image(symbolUrl));
                        } catch (IllegalArgumentException e) {
                            posterImageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.jpg")));
                        }
                        return;
                    }
                }
                posterImageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.jpg")));
            } else {
                selectedVBox.setVisible(false);
            }
        });

    }

    @FXML
    private void searchForPokemon(ActionEvent event) throws IOException, InterruptedException {
        String pokemonName = searchTextField.getText().trim();
        ApiResponse apiResponse = APIUtility.recieveAPI(pokemonName);
        if (apiResponse.getPokemons() != null && !apiResponse.getPokemons().isEmpty()) {
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            listView.getItems().addAll(apiResponse.getPokemons());
            resultsMsgLabel.setText("Showing " + listView.getItems().size() + " of " + apiResponse.getTotalData());
        } else {
            titlesVBox.setVisible(false);
            msgLabel.setVisible(true);
            msgLabel.setText("No Pokémon found for the given name.");
        }
    }

    @FXML
    void getPokemonDetails(ActionEvent event) throws IOException {
        Pokemon pokemonSelected = listView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event, "details-view.fxml", pokemonSelected.getId());
    }
}


