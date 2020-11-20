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
import org.resources.Loader;
import org.world.GameObject;
import org.world.World;

/**
 *
 * @author pupil
 */
public class TestPlayer extends GameObject{
    private double speedAlpha = 1;
    private int speed = 6;
    private int jumpIteration = 0;
    private int maxJumpIterations = 10;
    private boolean isJumping = false;
    public TestPlayer(float posX, float posY){
        super(posX, posY);
        height = 1;
        width = 1;
        
        animations = new ArrayList<Animation>();
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
            yInput-= speed;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_S)){
            yInput+= speed;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_A)){
            xInput-= speed;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_D)){
            xInput+= speed;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_SPACE)){
            jump();
        }
        posX += xInput*GameLoop.updateDelta()*speedAlpha;
        posY += yInput*GameLoop.updateDelta()*speedAlpha;
        World.getObjects().forEach((ob) -> {
            if(ob.collide(this)){
                posX = oldPosX;
                posY = oldPosY;
            }
        });
        oldPosX = posX;
        oldPosY = posY;
    }

    @Override
    public void fall() {
        
    }
    
    public void jump(){

        
    }
    
}
