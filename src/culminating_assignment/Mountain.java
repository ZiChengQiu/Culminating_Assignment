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
public class Mountain {
    private int x;
    private int y;
    private int health;
    private PApplet app;
    private PImage image;
    
    public Mountain(PApplet p, int x, int y, String imagePath, int health){
        this.app = p;
        this.x = x;
        this.y = y;
        this.health = health;
        this.image = app.loadImage(imagePath);
        this.image.resize(image.width / 3, image.height / 3);
    }
    
    public void draw(){
        app.image(image, x, y);
    }
    
    public boolean isClicked(int mouseX, int mouseY){
        int centerX = x + (image.width / 2);
        int centerY = y + (image.height / 2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        return 
    }
    
    public int health
}
