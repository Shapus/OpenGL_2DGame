/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.world;

import java.util.List;
import org.graphics.Animation;
import org.graphics.Graphics;
import org.resource.ImageResource;

/**
 *
 * @author pupil
 */
public abstract class GameObject {
    
//=============================== VARIABLES    
    //position
    protected float posX;
    protected float posY;
    //size
    protected float height;
    protected float width;
    //rotation
    protected float rotation;
    //object animation
    protected List<Animation> animations;
    //current animation
    protected int currentAnimation = 0;

//=============================== CONSTRUCTORS
    protected GameObject(){
        
    }
    
//=============================== METHODS   
    public void update(){
        //release in subclasses
    }
    public void render(){
        animations.get(currentAnimation).play();
        ImageResource image = animations.get(currentAnimation).getCurrentFrame();
        Graphics.setRotation(rotation);
        Graphics.drawImage(image, posX, posY, width, height);
        Graphics.setRotation(0);
    }
    
//=============================== GETTERS
    public float getPosX() {
        return posX;
    }
    public float getPosY() {
        return posY;
    }
    public float getHeight() {
        return height;
    }
    public float getWidth() {
        return width;
    }
    public float getRotation() {
        return rotation;
    }
    public List<Animation> getAnimation() {
        return animations;
    }
    public int getCurrentAnimation() {
        return currentAnimation;
    }
 
//=============================== SETTERS
    public void setPosX(float posX) {
        this.posX = posX;
    }
    public void setPosY(float posY) {
        this.posY = posY;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
    public void setAnimations(List<Animation> animations) {
        this.animations = animations;
    }
    public void setCurrentAnimation(int currentAnimation) {
        this.currentAnimation = currentAnimation;
    }
    
    
}
