/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author Zi Cheng Qiu
 */
public class Yugong {
    public int x;
    public int y;
    private int speed;
    private PApplet app;
    private PImage image;
    
    public Yugong(PApplet p, int x, int y, int speed, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = app.loadImage(imagePath);
    }
    
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    
    public void draw(){
        app.image(image, x, y);
    }
}
