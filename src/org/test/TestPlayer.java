/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test;

import java.util.ArrayList;
import org.graphics.Animation;
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
        animation.setFps(1);
        animations.add(animation);
    }
}
