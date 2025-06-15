/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
import java.io.*;
import java.util.Scanner;

/**
 * Main codes that run the program
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
    private String [][] mountainDigProgress; // dig progress
    private static int click = 0; // total number of click the mountains
    
    /**
     * Set the game screen's size
     */
    @Override
    public void settings(){
        size(938, 536); // same size as the background image
    }
    
    /**
     * Initialize all game objects and call the loadProgress method
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
        // initialize 2D array
        mountainDigProgress = new String[2][15];
        // load the total number of click and the two mountains' health
        loadProgress();
    }
    
    /**
     * Draw background, characters, mountains, and handles interaction 
     * and events in the story
     */
    @Override
    public void draw(){
        // draw background
        background.draw();
        // draw the first mountain
        mountain1.draw();
        // draw the second mountain
        mountain2.draw();
        // draw YuGong
        yuGong.draw();
        
        // show villagers based on the first mountain's health
        if(showVillager){
            // draw villagers
            villager.draw();
            // change color
            fill(255);
            // change size of text
            textSize(15);
            // that's what the villagers said to YuGong
            text("We will help you!", villager.x, villager.y - 20);
        }
        
        // show the wise man based on the second mountain's health
        if(showWiseMan){
            // draw the wise man
            wiseMan.draw();
            // change color
            fill(255);
            // change size
            textSize(15);
            // the wise man said this to YuGong
            text("You are foolish. You can't do this!", wiseMan.x, wiseMan.y - 5);
        }
        
        // when both mountain's health are 0, show giants and start movement
        if(showGiants){
            // draw giant one
            giant1.draw();
            // draw giant two
            giant2.draw();
            // color
            fill(255, 0, 0);
            // size
            textSize(30);
            text("Lord of Heaven is moved. Giants are here to help!", 180, 110);
            if(startMoving){
                // start moving
                giant1.moveUp();
                giant2.moveUp();
                mountain1.moveUp();
                mountain2.moveUp();
            }
        }
        
        fill(0);
        textSize(15);
        text("Yugong: I want to move these mountains!", 20, 30);
        // display the mountains' health
        displayMountainHealth();
        
        // for-loop to show mountain dig progress
        for(int i = 0; i < mountainDigProgress.length; i++){
            for(int j = 0; j < mountainDigProgress[i].length; j++){
                if(mountainDigProgress[i][j] != null){
                    text("Mountain " + (i + 1) + " Health: " + j + mountainDigProgress[i][j], 400, 200 + i * 100 + j);
                }
            }
        }
        
        // when mountain 1 health is 10, villagers come out
        if(mountain1.getHealth() <= 10){
            showVillager = true;
        }
        
        // when mountain 2 health is 5, wise man appear
        if(mountain2.getHealth() <= 5){
            showWiseMan = true;
        }
        
        // when both mountain's health is 0, giants come out and all giants and mountains start to move up
        if(mountain1.getHealth() == 0 && mountain2.getHealth() == 0){
            showGiants = true;
            startMoving = true;
        }
    }
    
    /**
     * Move Yugong using keyboard
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
     * Press mouse to dig mountains
     */
    @Override
    public void mousePressed(){
        if(mountain1.isClicked(mouseX, mouseY)){
            mountain1.dig(); // dig the mountain
            click++; // total number of click increase
            updateProgress(0, mountain1.getHealth()); // call updateProgress method
            saveProgress(); // call saveProgress method
        }else if(mountain2.isClicked(mouseX, mouseY)){
            mountain2.dig();
            click++;
            updateProgress(1, mountain2.getHealth());
            saveProgress();
        }
    }
    
    /**
     * Display the health of both mountains
     */
    public void displayMountainHealth(){
        fill(34, 255, 0);
        textSize(20);
        text("Mountain 1 Health: " + mountain1.getHealth(), 20, 60);
        text("Mountain 2 Health: " + mountain2.getHealth(), 20, 85);
    }
    
    /**
     * Add something to the array
     * @param mountainIndex this is the mountain index
     * @param health this is the health
     */
    public void updateProgress(int mountainIndex, int health){
        if(health >= 0 && health < mountainDigProgress[mountainIndex].length){
            mountainDigProgress[mountainIndex][health] = "";
        }
    }
    
    /**
     * Saves click and health info to file
     */
    public void saveProgress(){
        try{
             FileWriter writer = new FileWriter("progress.txt", true);
             PrintWriter niceOutput = new PrintWriter(writer);
             // write the information to file
             niceOutput.println(click);
             niceOutput.println(mountain1.getHealth());
             niceOutput.println(mountain2.getHealth());
             niceOutput.close(); // close niceOutput
        }catch(IOException ioException){
            System.err.println(ioException);
        }
    }
    
    /**
     * loads saved click and health info from file
     */
    public void loadProgress(){
        try{
            FileWriter writer = new FileWriter("progress.txt", true);
            PrintWriter niceOutput = new PrintWriter(writer);
            niceOutput.println("0");
            niceOutput.println("15");
            niceOutput.println("10");
            niceOutput.close(); //close niceOutput
            
            Scanner scanner = new Scanner(new File("progress.txt"));
            click = Integer.parseInt(scanner.nextLine());
            mountain1.setHealth(Integer.parseInt(scanner.nextLine()));
            mountain2.setHealth(Integer.parseInt(scanner.nextLine()));
        }catch(IOException ioException){
            System.err.println(ioException);
        }
    }
}