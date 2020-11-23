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
    private int speed = 3;
    private int jumpIteration = 0;
    private int maxJumpIterations = 10;
    private boolean isJumping = false;
    public TestPlayer(float posX, float posY){
        super(posX, posY);
        height = 1;
        width = 1;
        
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
            jump();
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
        fall();
        
        for(GameObject ob : World.getObjects()){
            if(ob.react(this)){
                float deltaY = Math.abs(this.getPosY()-ob.getPosY());
                float deltaHeight = this.getHeight()/2+ob.getHeight()/2;
                supportReaction = -(fallSpeed) - Math.abs(deltaY - deltaHeight);
            }
            if(ob.collide(this)){    
                posX = oldPosX;
                posY = oldPosY;
            }        
            if(isCollide || isReact){
                break;
            }
        };
        this.posY += fallSpeed+supportReaction+jumpSpeed;
        oldPosX = posX;
        oldPosY = posY;
    }

    @Override
    public void fall(){
        fallSpeed += Math.min((fallSpeed+g)*GameLoop.updateDelta(),0.1);
    };
    
    public void jump(){
        if(!isJumping){
            jumpSpeed = 1*GameLoop.updateDelta();
        }
        
    }
    
}
