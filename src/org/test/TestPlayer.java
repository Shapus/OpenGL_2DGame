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
import org.resource.ImageResource;
import org.world.GameObject;
import org.world.World;

/**
 *
 * @author pupil
 */
public class TestPlayer extends GameObject{
    double speedAlpha = 3;
    private int speed = 100;
    public TestPlayer(){
        height = 100;
        width = 100;
        posX = 500;
        posY = 400;
        
        animations = new ArrayList<Animation>();
        Animation animation = new Animation();
        animation.setFrames(new ImageResource("/res/sprites/coin/image_part_001.png"),
                            new ImageResource("/res/sprites/coin/image_part_002.png"),
                            new ImageResource("/res/sprites/coin/image_part_003.png"),
                            new ImageResource("/res/sprites/coin/image_part_004.png"),
                            new ImageResource("/res/sprites/coin/image_part_005.png"),
                            new ImageResource("/res/sprites/coin/image_part_006.png"),
                            new ImageResource("/res/sprites/coin/image_part_007.png"),
                            new ImageResource("/res/sprites/coin/image_part_008.png"),
                            new ImageResource("/res/sprites/coin/image_part_009.png"),
                            new ImageResource("/res/sprites/coin/image_part_010.png"));
        animations.add(animation);
        World.getObjectsBuffer().add(this);
    }
    @Override
    public void update(){
        double xInput = 0;
        double yInput = 0;
        if(KeyboardInput.getKey(KeyEvent.VK_W)){
            yInput-= speed;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_S)){
            yInput+= speed;;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_A)){
            xInput-= speed;;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_D)){
            xInput+= speed;;
        }
        posX += xInput*GameLoop.updateDelta()*speedAlpha;
        posY += yInput*GameLoop.updateDelta()*speedAlpha;
    }
}
