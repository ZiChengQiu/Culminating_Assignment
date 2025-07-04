/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Base class for Yugong
 * @author Zi Cheng Qiu
 */
public class Character {
    public int x;
    public int y;
    private PApplet app;
    private PImage image;
    
    /**
     * Constructor
     * @param p
     * @param x
     * @param y
     * @param imagePath 
     */
    public Character(PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
        // make the image smaller
        this.image.resize(image.width / 5, image.height / 5);
    }
    
    /**
     * Draw the character
     */
    public void draw(){
        app.image(image, x, y);
    }
    
    /**
     * Move the character
     * @param dx
     * @param dy 
     */
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
}