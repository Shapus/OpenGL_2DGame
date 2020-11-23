/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.world;

import java.util.List;
import org.graphics.Animation;
import org.graphics.Graphics;
import org.graphics.Renderer;
import org.resource.ImageResource;
import physics.ForceVector;

/**
 *
 * @author pupil
 */
public abstract class GameObject{
    
//=============================== VARIABLES    
    //mass
    protected float mass;
    //coordinats
    protected float posX;
    protected float posY;
    protected float oldPosX;
    protected float oldPosY;
    //speeds
    protected float speedX = 0;
    protected float speedY = 0;
    //forces
    protected ForceVector forceSuperposition = new ForceVector(0, 0);
    //size
    protected float height;
    protected float width;
    //rotation
    protected float rotation;
    //object animation
    protected List<Animation> animations;
    //current animation
    protected int currentAnimation = 0;    
    //is collide
    protected boolean isCollide = false;
    protected boolean isReact = false;

//=============================== CONSTRUCTORS
    protected GameObject(float posX, float posY){
        this.posX = posX;
        this.posY = posY;
    }
    
//=============================== METHODS   
    public abstract void update();
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
            float deltaX = Math.abs(this.getPosX()-ob.getPosX());
            float deltaY = Math.abs(this.getPosY()-ob.getPosY());
            float deltaWidth = this.getWidth()/2+ob.getWidth()/2;
            float deltaHeight = this.getHeight()/2+ob.getHeight()/2;
            if(deltaX <= deltaWidth){
                if(deltaY <= deltaHeight){
                    isCollide = true;
                }
            }
        }
        return isCollide;
    }
    
    public boolean react(GameObject ob){
        isReact = false;
        if(ob != this){
            float deltaX = Math.abs(this.getPosX()-ob.getPosX());
            float deltaY = Math.abs(this.getPosY()-ob.getPosY());
            float deltaWidth = this.getWidth()/2+ob.getWidth()/2;
            float deltaHeight = this.getHeight()/2+ob.getHeight()/2;
            if(deltaX < deltaWidth){
                if(deltaY - deltaHeight < 0.1){
                    isReact = true;
                }
            }
        }
        return isReact;
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
    public float getMass() {
        return mass;
    }
    public float getOldPosX() {
        return oldPosX;
    }
    public float getOldPosY() {
        return oldPosY;
    }
    public float getSpeedX() {
        return speedX;
    }
    public float getSpeedY() {
        return speedY;
    }
    public ForceVector getForceSuperposition() {
        return forceSuperposition;
    }
    public List<Animation> getAnimations() {
        return animations;
    }
    public boolean isIsCollide() {
        return isCollide;
    }
    public boolean isIsReact() {
        return isReact;
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
    public void setMass(float mass) {
        this.mass = mass;
    }
    public void setForceSuperposition(ForceVector forceSuperposition) {
        this.forceSuperposition = forceSuperposition;
    }
    public void setSpeedX(float speedX){
        this.speedX = speedX;
    }
    public void setSpeedY(float speedY){
        this.speedY = speedY;
    }
    
}
