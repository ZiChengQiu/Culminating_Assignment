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
public class Background {
    private PImage image;
    private PApplet app;
    
    public Background(PApplet p, String imagePath){
        this.app = p;
        this.image = app.loadImage(imagePath);
        this.image.resize(938, 536);

    }
    
    public void draw(){
        app.image(image, 0, 0);
    }
}
