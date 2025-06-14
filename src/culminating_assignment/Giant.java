/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Giants who help move the mountains
 * @author Zi Cheng Qiu
 */
public class Giant {
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
    public Giant(PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
    }
    
    /**
     * Draw the giant
     */
    public void draw(){
        app.image(image, x, y);
    }
    
    /**
     * Move the giant upward
     */
    public void moveUp(){
        y -= 1;
    }
}