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

/**
 *
 * @author pupil
 */
public class TestPlayer extends GameObject{
    public TestPlayer(){
        height = 2;
        width = 2;
        animations = new ArrayList<Animation>();
        Animation animation = new Animation();
        animation.setFrames(new ImageResource("/res/image_part_001.png"),
                            new ImageResource("/res/image_part_002.png"),
                            new ImageResource("/res/image_part_003.png"),
                            new ImageResource("/res/image_part_004.png"),
                            new ImageResource("/res/image_part_005.png"),
                            new ImageResource("/res/image_part_006.png"),
                            new ImageResource("/res/image_part_007.png"),
                            new ImageResource("/res/image_part_008.png"),
                            new ImageResource("/res/image_part_009.png"),
                            new ImageResource("/res/image_part_010.png"));
        animations.add(animation);
    }
    @Override
    public void update(){
        double xInput = 0;
        double yInput = 0;
        if(KeyboardInput.getKey(KeyEvent.VK_W)){
            xInput--;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_S)){
            xInput++;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_A)){
            yInput--;
        }
        if(KeyboardInput.getKey(KeyEvent.VK_D)){
            yInput++;
        }
        posX += xInput*GameLoop.updateDelta();
        posY += yInput*GameLoop.updateDelta();
    }
}
