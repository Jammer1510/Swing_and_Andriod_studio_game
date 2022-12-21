
import java.io.File;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/***************************************************************  
*  file: CreditFrame1.java  
*  author: Timmy Lin, Owen Lovett, Kristine Trevino Kinoshita, Scott Lee 
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Swing Project 1  
*  date last modified: 9/26/2021  
*  
*  purpose: This program accepts creates a hangman game and a color button game 
*           in a separate window that has a title screen, main menu, game 
*           screen, high score screen, and credits.
*  
****************************************************************/

public class readFile {
    
    private Scanner x;

    //opens file
    public void openFile(){
        try{
            x = new Scanner(new File("scores.txt"));
        }
        catch(Exception e){
            System.out.println("no file found");
        }
    }
    
    //reads scores.txt and puts strings into array
    public String[] readScore(){
        String[] scores = new String[8];
        for(int i = 0; i < scores.length; i++){
            scores[i] = x.next();
        }
        return scores;
    }
    
    //closes file
    public void closeFile(){
        x.close();
    }
    
}
