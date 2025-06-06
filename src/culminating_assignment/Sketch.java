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
    private Background background;
    private Yugong yuGong;
    private WiseMan wiseMan;
    private Villagers villager;
    private Mountain mountain1;
    private Mountain mountain2;
    private Giant giant1;
    private Giant giant2;
    
    private boolean showVillager = false;
    private boolean showWiseMan = false;
    private boolean showGiants = false;
    private boolean startMoving = false;
    int stage = 0;
    private String [][] dig;
    private static int click;
    
    
    public void settings(){
        size(938, 536);
    }
    
    public void setup(){
        background = new Background(this, "images/background.png");
        yuGong = new Yugong(this, 100, 270, "images/yugong.png");
        wiseMan = new WiseMan(this, 700, 250, "images/wiseMan.png");
        villager = new Villagers(this, 150, 280, "images/villager.png");
        mountain1 = new Mountain(this, 200, 100, "images/mountain1.png", 15);
        mountain2 = new Mountain(this, 600, 100, "images/mountain2.png", 10);
        giant1 = new Giant(this, 200, 0, "images/giant1.png");
        giant2 = new Giant(this, 600, 0, "images/giant2.png");
        
    }
    
    public void draw(){
        background.draw();
        mountain1.draw();
        mountain2.draw();
        yuGong.draw();
        
        if(showVillager){
            villager.draw();
            text("We will help you!", villager.x, villager.y - 20);
        }
        
        if(showWiseMan){
            wiseMan.draw();
            text("You are foolish. You can't do this!", wiseMan.x, wiseMan.y - 20);
        }
        
        if(showGiants){
            giant1.draw();
            giant2.draw();
            text("Lord of Heaven is moved. Giants are here to help!", 200, 100);
            if(startMoving){
                giant1.moveUp();
                giant2.moveUp();
                mountain1.moveUp();
                mountain2.moveUp();
            }
        }
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
