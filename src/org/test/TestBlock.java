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
import org.world.World;

/**
 *
 * @author ASUS
 */
public class TestBlock extends GameObject{
    double speedAlpha = 3;
    public TestBlock(float posX, float posY){
        this.posX = posX;
        this.posY = posY;
        height = 100;
        width = 100;
        setAnimations(new ArrayList<Animation>());
        Animation animation = new Animation();
        animation.setFrames(new ImageResource("/res/textures/stone_wall.png"));
        animations.add(animation);
        World.getObjectsBuffer().add(this);
    }
}
