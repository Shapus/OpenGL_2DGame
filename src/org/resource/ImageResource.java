/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.resource;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.graphics.Renderer;

/**
 *
 * @author ASUS
 */
public class ImageResource {
    //OpenGL texture object
    private Texture texture = null;
    
    //The buffered image of this image
    private BufferedImage image = null;
    
    public ImageResource(String path){
        URL url = ImageResource.class.getResource(path);
        try {
            image = ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(ImageResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(image != null){
            image.flush();
        }
    }
    
    public Texture getTexture(){
        if(image == null){
            return null;
        } 
        if(texture == null){
            texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);
        }
        
        return texture;
    }
}
