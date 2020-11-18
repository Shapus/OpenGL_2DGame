/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import org.world.World;

/**
 *
 * @author ASUS 
 */
public class EventListener implements GLEventListener{

//=============================== VARIABLES
    //opengl unit
    public static GL2 gl = null;
    private static float unitsTall = 0;
    private static float unitsWide = 0;

//=============================== METHODS
    //=== initialisation ===//
    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_ALPHA_TEST);
        gl.glAlphaFunc(GL2.GL_GREATER, 0.0f);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glClearColor(1,1,1,1);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }
    //=== render the world ===//
    @Override
    public void display(GLAutoDrawable drawable) {
        //get gl object
        gl = drawable.getGL().getGL2();
        
        //clear window
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        
        //render
        World.render();
    }
    
    //=== reshape unit ===//
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
       //get gl object
        gl = drawable.getGL().getGL2();
        
        //set resize window translation matrix 
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        unitsWide = Renderer.getUnitsWide();
        unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth()/unitsWide);
        
        //for units, origin == center of the window    
        gl.glOrtho(-unitsWide/2, unitsWide/2, -unitsTall/2, unitsTall/2, 1, -1);  

        //for pixels (number of units == number of pixels), origin == top left corner   
        //gl.glOrtho(0, Renderer.getWindowWidth(), Renderer.getWindowHeight(), 0, 0, 1);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
 
//=============================== GETTERS
    public static float getUnitsTall() {
        return unitsTall;
    }
    public static float getUnitsWide() {
        return unitsWide;
    }
    
}
