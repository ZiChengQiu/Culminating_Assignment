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
public class Yugong extends Character{
    public int x;
    public int y;
    private int speed;
    private PApplet app;
    private PImage image;
    
    /**
     * 
     * @param p
     * @param x
     * @param y
     * @param imagePath 
     */
    public Yugong(PApplet p, int x, int y, String imagePath){
        super(p, x, y, imagePath);
    }
    
    /**
     * 
     * @param dx
     * @param dy 
     */
    public void move(int dx, int dy){
        super.move(dx, dy);
    }
    
    /**
     * 
     */
    public void draw(){
        super.draw();
    }
}