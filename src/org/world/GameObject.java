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
import physics.Vector;

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
    protected List<Vector> forces;
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
    protected float collision_delta_x = 0;
    protected float collision_delta_y = 0;

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
                    collision_delta_x = deltaY-deltaHeight;
                    collision_delta_y = deltaY-deltaHeight;
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
    public void addForce(Vector force){
        forces.add(force);
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
    public List<Animation> getAnimations() {
        return animations;
    }
    public boolean isIsCollide() {
        return isCollide;
    }
    public float getCollisionDeltaX(){
        return collision_delta_x;
    }
    public float getCollisionDeltaY(){
        return collision_delta_y;
    }
    public List<Vector> getForces(){
        return forces;
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
    public void setSpeedX(float speedX){
        this.speedX = speedX;
    }
    public void setSpeedY(float speedY){
        this.speedY = speedY;
    }
    public void getForces(List<Vector> forces){
        this.forces = forces;
    }
    
}
