/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Mountain the player can dig
 * @author Zi Cheng Qiu
 */
public class Mountain {
    private int x;
    private int y;
    private int health;
    private PApplet app;
    private PImage image;
    
    /**
     * Constructor 1
     * @param p
     * @param x
     * @param y
     * @param imagePath 
     */
    public Mountain(PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.health = 50;
        this.image = app.loadImage(imagePath);
        // change the size
        this.image.resize(image.width / 2, image.height / 2);
    }
    
    /**
     * Constructor 2
     * @param p
     * @param x
     * @param y
     * @param imagePath
     * @param health This is the mountain's health
     */
    public Mountain(PApplet p, int x, int y, String imagePath, int health){
        this.app = p;
        this.x = x;
        this.y = y;
        this.health = health;
        this.image = app.loadImage(imagePath);
        this.image.resize(image.width / 2, image.height / 2);
    }
    
    /**
     * Draw the mountain
     */
    public void draw(){
        app.image(image, x, y);
    }
    
    /**
     * Return something if the player click the mountain
     * @param mouseX
     * @param mouseY
     * @return 
     */
    public boolean isClicked(int mouseX, int mouseY){
        int centerX = x + (image.width / 2);
        int centerY = y + (image.height / 2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        return d < 250;
    }
    
    /**
     * Move the mountain upward
     */
    public void moveUp(){
        y -= 1;
    }
    
    /**
     * Reduce the mountain's health by 1, to a minimum of 0
     */
    public void dig(){
        if(health > 0){
            health--;
        }
    }
    
    /**
     * Return current remaining health
     * @return It returns the health
     */
    public int getHealth(){
        return health;
    }
    
    /**
     * Set the mountain's health
     * @param h 
     */
    public void setHealth(int h){
        health = h;
    }
}