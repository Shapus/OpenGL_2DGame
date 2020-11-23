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
import org.input.MouseInput;
import org.resource.Loader;
import org.world.GameObject;
import org.world.World;
import physics.Collision;
import physics.ForceVector;
import physics.Gravity;
import physics.SupportReaction;

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
        
        mass = 1f;
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
        forceSuperposition.setX(0);
        forceSuperposition.setY(0);
        if(KeyboardInput.getKey(KeyEvent.VK_W)){
            setForceSuperposition(forceSuperposition.add(new ForceVector(0,-0.8f)));
        }
        if(KeyboardInput.getKey(KeyEvent.VK_S)){
            setForceSuperposition(forceSuperposition.add(new ForceVector(0,0.8f)));
        }
        if(KeyboardInput.getKey(KeyEvent.VK_A)){
            setForceSuperposition(forceSuperposition.add(new ForceVector(-0.8f,0)));
        }
        if(KeyboardInput.getKey(KeyEvent.VK_D)){
            setForceSuperposition(forceSuperposition.add(new ForceVector(0.8f,0)));
        }
        if(KeyboardInput.getKey(KeyEvent.VK_SPACE)){
            jump();
        }
        if(MouseInput.isPressed()){
            this.posX = 0;
            this.posY = 0;
            forceSuperposition.setX(0);
            forceSuperposition.setY(0);
            speedX = 0;
            speedY = 0;
        }
        Gravity g = new Gravity();
        SupportReaction sr = new SupportReaction();
        Collision c = new Collision();
        g.impactOn(this);
        for(GameObject go : World.getObjects()){
            if(go.collide(this)){
                c.impactOn(this);
                sr.impactOn(this);
                break;
            }
        } 
        speedX += forceSuperposition.getX()*GameLoop.updateDelta();
        speedY += forceSuperposition.getY()*GameLoop.updateDelta();
        posX += speedX;
        posY += speedY;
        
        oldPosX = posX;
        oldPosY = posY;
    }

    
    public void jump(){
        
    }
    
}
