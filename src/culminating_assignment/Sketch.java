/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating_assignment;
import processing.core.PApplet;
/**
 *
 * @author Zi Cheng Qiu
 */
public class Sketch extends PApplet{
    private Yugong yuGong;
    private WiseMan wiseMan;
    private Villager villager;
    private Mountain mountain1;
    private Mountain mountain2;
    private Giant giant1;
    private Giant giant2;
    int stage = 0;
    String [][] mountainDigging = new String[2][6];
    
    public void settings(){
        size(938, 536);
    }
    
    public void setup(){
        background
        yuGong = new Yugong(this, 300, 200, "images/yugong.png");
        wiseMan = new WiseMan(this, 800, 200, "images/wiseMan.png");
        villager = new Villager(this, 250, 100, "images/villager.png");
        mountain1 = new Mountain(this, 300, 150, "images/mountain1.png", 15);
        mountain2 = new Mountain(this, 600, 150, "images/mountain2.png", 10);
        giant1 = new Giant(this, 300, 0, "images/giant1.png");
        giant2 = new Giant(this, 600, 0, "images/giant2.png");
        
    }
    
    public void draw(){
        if(keyPressed){
            if(keyCode == LEFT){
                yuGong.move(-2, 0);
            }else if(keyCode == RIGHT){
                yuGong.move(2, 0);
            }else if(keyCode == UP){
                yuGong.move(0, -2);
            }else if(keyCode == DOWN){
                yuGong.move(0, 2);
            }
        }
        if(stage == 0){
            
        }
        
    }
    
    public void mousePressed(){
        
    }
    
}
