/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test;

import java.util.ArrayList;
import org.graphics.Animation;
import org.resource.ImageResource;
import org.resources.Loader;
import org.world.GameObject;
import org.world.World;

/**
 *
 * @author ASUS
 */
public class TestBlock extends GameObject{
    public TestBlock(float posX, float posY){
        super(posX, posY);
        height = 1;
        width = 1;
        setAnimations(new ArrayList<Animation>());
        Animation animation = new Animation();
        animation.setFrames(Loader.getImages("wall"));
        animations.add(animation);
        World.getObjectsBuffer().add(this);
    }
}
