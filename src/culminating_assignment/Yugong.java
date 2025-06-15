/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * The main character Yugong
 * @author Zi Cheng Qiu
 */
public class Yugong extends Character{
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
    public Yugong(PApplet p, int x, int y, String imagePath){
        // call parent class
        super(p, x, y, imagePath);
    }
    
    /**
     * Move Yugong
     * @param dx
     * @param dy 
     */
    @Override
    public void move(int dx, int dy){
        // call parent class
        super.move(dx, dy);
    }
    
    /**
     * Draw Yugong
     */
    @Override
    public void draw(){
        // call parent class
        super.draw();
    }
}