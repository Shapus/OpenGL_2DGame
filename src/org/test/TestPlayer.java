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
import physics.Vector;
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
        forces = new ArrayList<>();
        Animation animation = new Animation();
        animation.setFrames(Loader.getImages("cat"));
        animations.add(animation);
    }
    @Override
    public void update(){
        forces.clear();
        if(KeyboardInput.getKey(KeyEvent.VK_W)){
            forces.add(new Vector(0,-0.8f));
        }
        if(KeyboardInput.getKey(KeyEvent.VK_S)){
            forces.add(new Vector(0,0.8f));
        }
        if(KeyboardInput.getKey(KeyEvent.VK_A)){
            forces.add(new Vector(-0.8f,0));
        }
        if(KeyboardInput.getKey(KeyEvent.VK_D)){
            forces.add(new Vector(0.8f,0));
        }
        if(KeyboardInput.getKey(KeyEvent.VK_SPACE)){
            jump();
        }
        if(MouseInput.isPressed()){
            position.set(3,3);
            speed.set(0,0);
            forces.clear(); 
        }
        Gravity g = new Gravity();
        SupportReaction sr = new SupportReaction();
        Collision c = new Collision();
        
        g.impactOn(this);
        for(GameObject go : World.getObjects()){
            if(collide(go)){
                //position.set(position.add(collision_delta).multy(GameLoop.updateDelta()));
                c.impactOn(this);
                sr.react(this, go);  
                System.out.println(collision_delta);
                
            }
        } 
        speed.set(speed.add(getSuperposition().multy(1/mass)));
        oldPosition.set(position);
        position.set(position.add(speed.multy(GameLoop.updateDelta()))); 
    }
    public void jump(){
        forces.add(new Vector(0,-1));
    }
    
}
