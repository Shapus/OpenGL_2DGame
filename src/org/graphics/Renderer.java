/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.graphics;

import com.jogamp.nativewindow.WindowClosingProtocol;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import org.input.KeyboardInput;
import org.input.MouseInput;

/**
 *
 * @author ASUS
 */
public class Renderer {
    //GL profile
    private static GLProfile profile = null;
    
    //window to display
    private static GLWindow window = null;
    
    //height and width
    private static int screenWidth = 800;
    private static int screenHeight = 600;
    
    //width in units
    private static int unitsWide = 15;
    public static void main(String[] args){
        Renderer.init();
    }
    
    
    public static void init(){
        GLProfile.initSingleton();
        
        //get GL2 profile
        profile = GLProfile.get(GLProfile.GL2);
        
        //get profile capabilities
        GLCapabilities caps = new GLCapabilities(profile);
        
        //set window parametrs
        window = GLWindow.create(caps);
        window.setSize(screenWidth, screenHeight);
        window.setResizable(true);
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
        window.display();
    }
    
    
    //getters
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
}
