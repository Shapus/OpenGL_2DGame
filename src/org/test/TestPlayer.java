/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test;

import com.jogamp.newt.event.KeyEvent;
import java.util.ArrayList;
import org.engine.GameLoop;
import org.graphics.Animation;
import org.input.KeyboardInput;
import org.resource.Loader;
import org.world.GameObject;
import org.world.World;

/**
 *
 * @author pupil
 */
public class TestPlayer extends GameObject{
    
    private boolean isJumping = false;
    
    public TestPlayer(float posX, float posY){
        super(posX, posY);
        height = 1;
        width = 1;
        
        mass = 0.001f;
        animations = new ArrayList<>();
        Animation animation = new Animation();
        animation.setFrames(Loader.getImages("cat"));
        animations.add(animation);
        setPosX(posX+width/2);
        setPosY(posY+height/2);
    }
    @Override
    public void update(){
        double xInput = 0;
        double yInput = 0;
        if(KeyboardInput.getKey(KeyEvent.VK_W)){
            yInput-= speedY;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_S)){
            yInput+= speedY;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_A)){
            xInput-= speedX;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_D)){
            xInput+= speedX;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_SPACE)){
            jump();
        }
        float cos = forceSuperposition.getX()/forceSuperposition.length();
        float sin = forceSuperposition.getY()/forceSuperposition.length();
        posX += forceSuperposition.getScalar()*cos*GameLoop.updateDelta();
        posY += forceSuperposition.getScalar()*sin*yInput*GameLoop.updateDelta();
        
        oldPosX = posX;
        oldPosY = posY;
    }

    
    public void jump(){
        
    }
    
}
