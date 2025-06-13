/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
import java.io.*;
import java.util.Scanner;

/**
 * Main code that run the program
 * @author Zi Cheng Qiu
 */
public class Sketch extends PApplet{
    private Background background;
    private Yugong yuGong;
    private WiseMan wiseMan;
    private Villagers villager;
    private Mountain mountain1;
    private Mountain mountain2;
    private Giant giant1;
    private Giant giant2;
    private boolean showVillager = false;
    private boolean showWiseMan = false;
    private boolean showGiants = false;
    private boolean startMoving = false;
    private String [][] mountainDigProgress;
    private static int click = 0;
    
    /**
     * set the size of the game screen
     */
    @Override
    public void settings(){
        size(938, 536);
    }
    
    /**
     * 
     */
    @Override
    public void setup(){
        background = new Background(this, "images/background.png");
        yuGong = new Yugong(this, 100, 270, "images/yugong.png");
        wiseMan = new WiseMan(this, 700, 300, "images/wiseMan.png");
        villager = new Villagers(this, 130, 250, "images/villager.png");
        mountain1 = new Mountain(this, 200, 100, "images/mountain1.png", 15);
        mountain2 = new Mountain(this, 600, 100, "images/mountain2.png", 10);
        giant1 = new Giant(this, 130, 300, "images/giant1.png");
        giant2 = new Giant(this, 500, 300, "images/giant2.png");
        mountainDigProgress = new String[2][15];
        loadProgress();
    }
    
    /**
     * 
     */
    @Override
    public void draw(){
        background.draw();
        mountain1.draw();
        mountain2.draw();
        yuGong.draw();
        
        if(showVillager){
            villager.draw();
            fill(255);
            textSize(15);
            text("We will help you!", villager.x, villager.y - 20);
        }
        
        if(showWiseMan){
            wiseMan.draw();
            fill(255);
            textSize(15);
            text("You are foolish. You can't do this!", wiseMan.x, wiseMan.y - 5);
        }
        
        if(showGiants){
            giant1.draw();
            giant2.draw();
            fill(255, 0, 0);
            textSize(30);
            text("Lord of Heaven is moved. Giants are here to help!", 180, 110);
            if(startMoving){
                giant1.moveUp();
                giant2.moveUp();
                mountain1.moveUp();
                mountain2.moveUp();
            }
        }
        
        fill(0);
        textSize(15);
        text("Yugong: I want to move these mountains!", 20, 30);
        displayMountainHealth();
        
        for(int i = 0; i < mountainDigProgress.length; i++){
            for(int j = 0; j < mountainDigProgress[i].length; j++){
                if(mountainDigProgress[i][j] != null){
                    text("Mountain " + (i + 1) + " Health: " + j + mountainDigProgress[i][j], 400, 200 + i * 100 + j);
                }
            }
        }
        
        if(mountain1.getHealth() <= 10){
            showVillager = true;
        }
        
        if(mountain2.getHealth() <= 5){
            showWiseMan = true;
        }
        
        if(mountain1.getHealth() == 0 && mountain2.getHealth() == 0){
            showGiants = true;
            startMoving = true;
        }
    }
    
    /**
     * control YuGong movement
     */
    @Override
    public void keyPressed(){
        if(keyCode == LEFT){
            yuGong.move(-5, 0);
        }else if(keyCode == RIGHT){
            yuGong.move(5, 0);
        }else if(keyCode == UP){
            yuGong.move(0, -5);
        }else if(keyCode == DOWN){
            yuGong.move(0, 5);
        }
    }
    
    /**
     * 
     */
    @Override
    public void mousePressed(){
        if(mountain1.isClicked(mouseX, mouseY)){
            mountain1.dig();
            click++;
            updateProgress(0, mountain1.getHealth());
            saveProgress();
        }else if(mountain2.isClicked(mouseX, mouseY)){
            mountain2.dig();
            click++;
            updateProgress(1, mountain2.getHealth());
            saveProgress();
        }
    }
    
    /**
     * 
     */
    public void displayMountainHealth(){
        fill(34, 255, 0);
        textSize(20);
        text("Mountain 1 Health: " + mountain1.getHealth(), 20, 60);
        text("Mountain 2 Health: " + mountain2.getHealth(), 20, 85);
    }
    
    /**
     * 
     * @param mountainIndex
     * @param health 
     */
    public void updateProgress(int mountainIndex, int health){
        if(health >= 0 && health < 15){
            mountainDigProgress[mountainIndex][health] = "";
        }
    }
    
    /**
     * 
     */
    public void saveProgress(){
        try{
             FileWriter writer = new FileWriter("progress.txt", true);
             PrintWriter niceOutput = new PrintWriter(writer);
             niceOutput.println(click);
             niceOutput.println(mountain1.getHealth());
             niceOutput.println(mountain2.getHealth());
             niceOutput.close();
        }catch(IOException ioException){
            System.err.println(ioException);
        }
    }
    
    /**
     * 
     */
    public void loadProgress(){
        try{
            FileWriter writer = new FileWriter("progress.txt", true);
            PrintWriter niceOutput = new PrintWriter(writer);
            niceOutput.println("0");
            niceOutput.println("15");
            niceOutput.println("10");
            niceOutput.close();
            
            //This file output code is useless
            Scanner scanner = new Scanner(new File("progress.txt"));
            click = Integer.parseInt(scanner.nextLine());
            mountain1.setHealth(Integer.parseInt(scanner.nextLine()));
            mountain2.setHealth(Integer.parseInt(scanner.nextLine()));
        }catch(IOException ioException){
            System.err.println(ioException);
        }
    }
}