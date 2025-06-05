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
    
    public Yugong(PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
        this.image.resize(image.width / 5, image.height / 5);
    }
    
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    
    public void draw(){
        app.image(image, x, y);
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
