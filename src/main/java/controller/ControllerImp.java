package controller;


import java.util.List;

import javafx.application.Platform;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Bird;
import model.Column;
import model.Model;
import model.ModelImp;
import model.file.Gamer;
import model.file.Leaderboard;
import model.file.LeaderboardManager;
import view.View;
import view.ViewImp;

public class ControllerImp implements Controller{
    
    
    

    private GameState gameState;
    public Model model;
    public View view;
    private KeyEvent event;
    
    Pane pane;
 
    public ControllerImp() {
        
        this.model = new ModelImp(this);
      //  this.view = new ViewImp();
        this.gameState = GameState.INITIALIZE;
      
    }

    @Override
    public void updateState() {
       
        System.out.println(gameState);
        switch (gameState) {
        case GAME_OVER:
            System.out.println("controll game over");
          this.view.gameOver();
            break;
        case INITIALIZE:
       //     System.out.println("ciaoo2");
            this.model.startGame();
           
            
            break;
        case PLAYING:
            this.model.updateGame();
            break;
        case READY:
            
            break;
            
        default:
            break;
        }
    }

    @Override
    public void setState(GameState state) {
        // TODO Auto-generated method stub
        System.out.println("fino a qui tutto bene");
        gameState = state;
    }
    
    public void render(List<Column> list, Integer score, Bird bird) {
       
  
       
      
           this.view.render(list,score,bird);
     
   
       
   
       
        
    }

  

   
    @Override
    public void update(View viewd) {
        // TODO Auto-generated method stub
        System.out.println("fino a qui tutto bene");
        this.view = viewd;
        this.updateState();
        
    }

    @Override
    public void start(String[] args, View view) {
        // TODO Auto-generated method stub
    
        this.updateState();
    }

    @Override
    public List<Gamer> getLeaderboard() {
        // TODO Auto-generated method stub
       return this.model.getLeaderboard();
    }

    @Override
    public void setEvent(KeyEvent e) {
        // TODO Auto-generated method stub
        this.event= e;
    }

    @Override
    public KeyEvent getEvent() {
        // TODO Auto-generated method stub
       
        return this.event;
    }

 



   


  
   
    
  
    

 
          
               
             
   
 }




   
  

   