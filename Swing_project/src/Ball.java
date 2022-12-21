/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/***************************************************************  
*  file: Ball.java  
*  author: Timmy Lin, Owen Lovett, Kristine Trevino Kinoshita, Scott Lee 
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Swing Project 1  
*  date last modified: 10/23/2021  
*  
*  purpose: This program accepts creates a hangman game and a color button game 
*           in a separate window that has a title screen, main menu, game 
*           screen, high score screen, and credits.
*  
****************************************************************/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Ball extends Rectangle{
    
    // generate random number for ball movement
    private Random rand;
    // set ball's x and y velocities
    private int xVelocity;
    private int yVelocity;
    // speed of ball
    private final int speed = 2;
    
    // initialize Ball object
    public Ball(int xLoc, int yLoc, int diameter) {
        super(xLoc, yLoc, diameter, diameter);
        rand = new Random();
        // figure out if ball moves left (-) or right (+)
        int randomXDirection = rand.nextInt(2);
        if (randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection * speed);
        // figure out if ball moves up (-) or down (+)
        int randomYDirection = rand.nextInt(2);
        if (randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection * speed);
    }
    
    // indicate the x direction of ball movement
    public void setXDirection(int xValue) {
        xVelocity = xValue;
    }
    
    // indicate the y direction of ball movement
    public void setYDirection(int yValue) {
        yVelocity = yValue;
    }
    
    // moves the ball in x and y direction
    public void move() {
        x = x + xVelocity;
        y = y + yVelocity;
        
    }
    
    // paints ball onto panel
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
    
    // get x velocity variable
    public int getXVelocity() {
        return xVelocity;
    }
    
    // get y velocity variable
    public int getYVelocity() {
        return yVelocity;
    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            move();
        }
    }
    
}
