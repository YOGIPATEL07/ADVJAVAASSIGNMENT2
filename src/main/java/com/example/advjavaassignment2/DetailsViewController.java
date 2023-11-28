package com.example.advjavaassignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class DetailsViewController implements PokemonLoader{


    @FXML
    private Label Evolution;

    @FXML
    private Label HealthPoint;

    @FXML
    private Label Level;

    @FXML
    private Label PokemonId;

    @FXML
    private Label Type;

    @FXML
    private ImageView imageView;

    @FXML
    private Label nameLabel;

    @FXML
    void backToSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "find-view.fxml");
    }

    public void loadPokemon(String id) {
        try {
            PokemonDetails pokemon = APIUtility.getpokemonDetails(id);

            // Set the fields
            Evolution.setText(pokemon.getEvolvesFrom());
            HealthPoint.setText(pokemon.getHp());
            Level.setText(pokemon.getLevel());
            PokemonId.setText(pokemon.getId());
            Type.setText(pokemon.getTypes() != null ? String.join(", ", pokemon.getTypes()) : "No Types");
            nameLabel.setText(pokemon.getName());

            if (Evolution.getText() == null || Evolution.getText().isEmpty()) {
                Evolution.setText("Not Available");
            }

            if (Level.getText() == null || Level.getText().isEmpty()) {
                Level.setText("Not Available");
            }

            if (pokemon.getImages() != null) {
                String imageUrl = pokemon.getImages().getSmallImage();
                if (imageUrl != null && !imageUrl.isEmpty()) {
                    imageView.setImage(new Image(imageUrl));
                } else {
                    imageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.png")));
                }
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            imageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.png")));
        }
    }


}
