/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.graphics;

import com.jogamp.nativewindow.WindowClosingProtocol;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import org.engine.GameLoop;
import org.input.KeyboardInput;
import org.input.MouseInput;

/**
 *
 * @author ASUS
 */
public class Renderer {
    
//=============================== VARIABLES
    //GL profile
    private static GLProfile profile = null;
    
    //window to display
    private static GLWindow window = null;
    
    //height and width
    private static int screenWidth = 800;
    private static int screenHeight = 600;
    
    //camera coords
    private static float cameraX = 0;
    private static float cameraY = 0;
    
    //width in units
    private static int unitsWide = 20;
    

//=============================== METHODS
    public static void init(){
        GLProfile.initSingleton();
        
        //get GL2 profile
        profile = GLProfile.get(GLProfile.GL2);
        
        //get profile capabilities
        GLCapabilities caps = new GLCapabilities(profile);
        
        //set window parametrs
        window = GLWindow.create(caps);
        window.setSize(screenWidth, screenHeight);
        window.setResizable(false);
        window.addGLEventListener(new EventListener());
        window.addMouseListener(new MouseInput());
        window.addKeyListener(new KeyboardInput());
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowClosingProtocol.WindowClosingMode.DISPOSE_ON_CLOSE);    
    }
       
    //display window
    public static void render(){
        if(window == null){
            return;
        }
        float speed = 3;
        double xInput = 0;
        double yInput = 0;
        if(KeyboardInput.getKey(KeyEvent.VK_UP)){
            yInput-= speed;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_DOWN)){
            yInput+= speed;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_LEFT)){
            xInput-= speed;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_RIGHT)){
            xInput+= speed;
        }
        cameraX += xInput*GameLoop.updateDelta()*2;
        cameraY += yInput*GameLoop.updateDelta()*2;
        window.display();
    }
    
    public static float toGlobalX(float x){
        return x+getCameraX();
    }
    public static float toGlobalY(float y){
        return y+getCameraY();
    }
    
    public static float toLocalX(float x){
        return x-getCameraX();
    }
    public static float toLocalY(float y){
        return y-getCameraY();
    }
    public static MouseListener getML(){
        return window.getMouseListener(0);
    }
    
//=============================== GETTERS
    public static int getWindowWidth(){
        return window.getWidth();
    }
    public static int getWindowHeight(){
        return window.getHeight();
    }
    public static int getUnitsWide(){
        return unitsWide;
    }
    public static GLProfile getProfile(){
        return profile;
    }
    public static float getCameraX() {
        return cameraX;
    }
    public static float getCameraY() {
        return cameraY;
    }
    
}
