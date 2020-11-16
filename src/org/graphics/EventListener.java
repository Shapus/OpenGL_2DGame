/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import java.util.Random;
import org.resource.ImageResource;
import org.world.World;

/**
 *
 * @author ASUS 
 */
public class EventListener implements GLEventListener{

//=============================== VARIABLES
    //opengl unit
    public static GL2 gl = null;

//=============================== METHODS
    //=== initialisation ===//
    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
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
        int unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth()/Renderer.getUnitsWide());
        gl.glOrtho(-Renderer.getUnitsWide()/2, Renderer.getUnitsWide()/2, -unitsTall/2, unitsTall/2, 1, -1);        
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
    
}
