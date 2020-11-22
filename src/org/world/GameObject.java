/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.world;

import java.util.List;
import org.engine.GameLoop;
import org.graphics.Animation;
import org.graphics.Graphics;
import org.graphics.Renderer;
import org.resource.ImageResource;

/**
 *
 * @author pupil
 */
public abstract class GameObject{
    
//=============================== VARIABLES    
    //position
    protected float posX;
    protected float posY;
    protected float oldPosX;
    protected float oldPosY;
    //size
    protected float height;
    protected float width;
    //rotation
    protected float rotation;
    //object animation
    protected List<Animation> animations;
    //current animation
    protected int currentAnimation = 0;
    //fall speed
    protected float g = 0.5f;
    protected float fallSpeed = 0;
    //is collide
    protected boolean isCollide = false;

//=============================== CONSTRUCTORS
    protected GameObject(float posX, float posY){
        this.posX = posX;
        this.posY = posY;
    }
    
//=============================== METHODS   
    public abstract void update();
    public abstract void fall();
    public void render(){
        try{
            animations.get(currentAnimation).play();
            ImageResource image = animations.get(currentAnimation).getCurrentFrame();
            Graphics.setRotation(rotation);
            Graphics.drawImage(image, Renderer.toLocalX(posX)-width/2, Renderer.toLocalY(posY)-height/2, width, height);
            Graphics.setRotation(0);
        }catch(Exception e){
            return;
        }
    }

    public boolean collide(GameObject ob){
        isCollide = false;
        if(ob != this){
            if(Math.abs(this.getPosX()-ob.getPosX()) < this.getWidth()/2+ob.getWidth()/2){
                if(Math.abs(this.getPosY()-ob.getPosY()) < this.getHeight()/2+ob.getHeight()/2){
                    isCollide = true;
                }
            }
        }
        return isCollide;
    }
    
    public void setPosition(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
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
