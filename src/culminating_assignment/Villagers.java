/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Villagers who help Yugong
 * @author Zi Cheng Qiu
 */
public class Villagers {
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
    public Villagers(PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
        // resize the image
        this.image.resize(image.width / 3, image.height / 3);
    }
    
    /**
     * Draw the villager image
     */
    public void draw(){
        app.image(image, x, y);
    }
}