package model.manager;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Bird;
import model.BirdImp;

public class ManagerJumpImp implements ManagerJump{

    private double height;
    private String codeString;
    
    
    
     public ManagerJumpImp() {
        // TODO Auto-generated constructor stub
        // this.height = 0;
      
    }

     @Override
     public double jump(Bird b) {
         // TODO Auto-generated method stub
         
         this.height= b.getCenterY()- 1;
         return this.height;
     }
    
    private boolean pressButton(KeyEvent event) {
        
        
  //     this.codeString = event.getCode().toString();
        
        if (event.getCode() == KeyCode.SPACE) {
           
            return true;
        }
        return false; 
    }

   
    
    @Override
    public boolean checkInput(KeyEvent event) {
        // TODO Auto-generated method stub
      
        
        return pressButton(event);
    }
}
