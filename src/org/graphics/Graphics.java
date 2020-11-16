/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import org.resource.ImageResource;

/**
 *
 * @author ASUS
 */
public class Graphics {
    
//=============================== VARIABLES    
    //color values
    static private float red = 1;
    static private float green = 1;
    static private float blue = 1;
    static private float alpha = 1;
    
    //rotation in degrees
    static private float rotation = 0;

//=============================== METHODS
    //=== draw rect ===//
    public static void fillRect(float x, float y, float width, float height){
        
        //get GL2 object
        GL2 gl = EventListener.gl;
        
        //multiply current matrix by translation matrixs
        gl.glTranslatef(x, y, 0);
        gl.glRotatef(-rotation, 0, 0, 1);
        
        //set figure to display color and vertexes
        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(x - width/2, y - height/2);
            gl.glVertex2f(x + width/2, y - height/2);
            gl.glVertex2f(x + width/2, y + height/2);
            gl.glVertex2f(x - width/2, y + height/2);
        gl.glEnd();
        
        //multiply again
        gl.glRotatef(rotation, 0, 0, 1);
        gl.glTranslatef(-x, -y, 0);
    }
    //=== draw image ===//
    public static void drawImage(ImageResource image, float x, float y, float width, float height){
        
        //get GL2 Object
        GL2 gl = EventListener.gl;
        
        //get texture from image
        Texture tex = image.getTexture();
        
        //bind texture to current OpenGL context
        gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        
        
        //set figure to display color and vertexes
        gl.glBegin(GL2.GL_QUADS);            
            gl.glTexCoord2f(0, 0);
            gl.glVertex2f(x - width/2, y - height/2);
            
            gl.glTexCoord2f(1, 0);
            gl.glVertex2f(x + width/2, y - height/2);
            
            gl.glTexCoord2f(1, 1);
            gl.glVertex2f(x + width/2, y + height/2);
            
            gl.glTexCoord2f(0, 1);
            gl.glVertex2f(x - width/2, y + height/2);
        gl.glEnd();
        gl.glFlush();
        
        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
        
    }
    public static void setColor(float r, float g, float b, float a){
        red = r;
        green = g;
        blue = b;
        alpha = a;
    }
    public static void setRotation(float angle){
        rotation = angle;
    }
    
    
    
    
    
}
