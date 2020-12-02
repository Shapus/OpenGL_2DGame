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
import org.physics.Friction;
import org.physics.Vector;
import org.physics.Gravity;
import org.physics.SupportReaction;

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
        acceleration.set(0,0);
        inner_friction_coeff.set(0.02f, 0.02f);
        for(int i=0; i<isCollided.length;i++){
            isCollided[i] = false;
        }
        for(int i=0; i<borderChecked.length;i++){
            borderChecked[i] = false;
        }
        
        
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
            position.set(3.5f,3.5f);
            speed.set(0,0);
            forces.clear(); 
        }
        
        new Gravity().impactOn(this);
        for(GameObject go : World.getObjects()){
            if(collide(go)){
                //System.out.println("collide");
                //c.impactOn(this);   
                new SupportReaction().react(this, go);
            }
        }
        new Friction().impactOn(this);
        acceleration.set(getSuperposition().multy(1/mass));
        speed.set(speed.add(acceleration));
        
        forces.clear();
        World.getObjects().stream().forEach((go) -> {
            checkBorderCross(go);
        });
        acceleration.set(getSuperposition().multy(1/mass));
        speed.set(speed.add(acceleration));
        position.set(position.add(speed.multy(GameLoop.updateDelta()))); 
    }
    public void jump(){
        forces.add(new Vector(0,-1));
    }
    
}
