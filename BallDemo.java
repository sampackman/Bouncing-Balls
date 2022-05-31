import java.awt.Color;
import java.util.Random;
import java.util.HashSet;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;




public class BallDemo  
{
    private Canvas myCanvas;
    HashSet <Canvas >endOfLine = new HashSet <Canvas>();
   

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        
         endOfLine.add (myCanvas);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int howMany)
    {
        int noBalls = howMany;
        int ground = 400;   // position of the ground line
        int maxValue = 300;
        Random rand = new Random();
        
        myCanvas.setVisible(true);
        Dimension max = myCanvas.getSize();
        
        
        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        HashSet <BouncingBall> balls = new HashSet <BouncingBall>();
        for (int i = 0; i<noBalls;i++){
                
                BouncingBall ball = new BouncingBall(rand.nextInt(max.width/2), rand.nextInt(max.height/2), 16, Color.BLUE, ground, myCanvas);
                balls.add(ball);
                ball.draw();
        }
       
       
        // make them bounce
        
        while (!balls.isEmpty()) {
            myCanvas.wait(50);           // small delay
            for (BouncingBall bounceBalls : balls){
            bounceBalls.move();
            
            // stop once ball has travelled a certain distance on x axis
           if(bounceBalls.getXPosition() >= max.width ) 
           {
                bounceBalls.erase();
                balls.remove(bounceBalls);
            }
            
        }
        }
     
        
        
    }
    



    
    

}



