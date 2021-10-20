package view;

import javax.swing.Renderer;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ViewMenu {

    Pane pane;
    
    public ViewMenu(Pane p) {
        // TODO Auto-generated constructor stub
        pane= p;
    }

    public void render() {
        
        Button startButton= new Button();
        startButton.setLayoutX(400);
        startButton.setLayoutY(200);
        startButton.setTextAlignment(TextAlignment.CENTER);
     
        startButton.setText("START");
        startButton.setFont(new Font("Arial", 12));
        
        Button scoreButton= new Button();
        scoreButton.setLayoutX(400);
        scoreButton.setLayoutY(250);
       
        scoreButton.setTextAlignment(TextAlignment.CENTER);
        scoreButton.setText("SCORE");
        scoreButton.setFont(new Font("Arial", 12));
        
        Button exitButton= new Button();
        exitButton.setLayoutX(400);
        exitButton.setLayoutY(300);
        
        exitButton.setTextAlignment(TextAlignment.CENTER);
        exitButton.setText("EXIT");
        exitButton.setFont(new Font("Arial", 12));
        
        Button playerButton= new Button();
        playerButton.setLayoutX(400);
        playerButton.setLayoutY(350);
       
        playerButton.setTextAlignment(TextAlignment.CENTER);
        playerButton.setText("SCEGLI IL PERSONAGGIO");
        playerButton.setFont(new Font("Arial", 12));
        
        
        ImageView img = new ImageView();
        img.setImage(new Image("background.png"));
        img.setFitHeight(600);
        img.setFitWidth(800);
        
        pane.getChildren().add(img);
        pane.getChildren().add(startButton);
        pane.getChildren().add(scoreButton);
        pane.getChildren().add(playerButton);
        pane.getChildren().add(exitButton);
        
        
    }

  
}