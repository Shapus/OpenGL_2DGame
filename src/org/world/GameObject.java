/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.world;

import java.util.ArrayList;
import java.util.List;
import org.engine.GameLoop;
import org.graphics.Animation;
import org.graphics.Graphics;
import org.graphics.Renderer;
import org.resource.ImageResource;
import org.physics.Vector;

/**
 *
 * @author pupil
 */
public abstract class GameObject{
    
//=============================== VARIABLES    
    //mass
    protected float mass;
    //coordinats
    protected Vector position;
    protected Vector oldPosition;
    //speeds
    protected Vector speed;
    //acceleration
    protected Vector acceleration;
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
    //collide variables
    protected boolean[] isCollide;                      //contains info which side this object is collided by (top - right - bottom - left)
    public boolean[] isCollided;                        //have this object collided by the side?
    public boolean[] borderChecked;                     //have border collision checked?
    //friction
    protected Vector inner_friction_coeff;
    protected Vector outer_friction_coeff;

//=============================== CONSTRUCTORS
    protected GameObject(float x, float y){
        this.position = new Vector(x,y);
        this.oldPosition = new Vector(x,y);
        this.speed = new Vector(0,0);
        this.acceleration = new Vector(0,0);
        this.inner_friction_coeff = new Vector(0.01f,0.01f);
        this.outer_friction_coeff = new Vector(0.2f,0.2f);
        isCollide = new boolean[4];
        isCollided = new boolean[4];
        borderChecked = new boolean[4];
        for(int i=0; i<isCollided.length;i++){
            isCollided[i] = false;
        }
        for(int i=0; i<isCollide.length;i++){
            isCollide[i] = false;
        }
        for(int i=0; i<borderChecked.length;i++){
            borderChecked[i] = false;
        }
    }
    
//=============================== METHODS   
    public abstract void update();
    
    public void render(){
        try{
            animations.get(currentAnimation).play();
            ImageResource image = animations.get(currentAnimation).getCurrentFrame();
            Graphics.setRotation(rotation);
            Graphics.drawImage(image, Renderer.toLocalX(position.x()), Renderer.toLocalY(position.y()), width, height);
            Graphics.setRotation(0);
        }catch(Exception e){
        }
    }

    public boolean collide(GameObject ob){
        for(int i=0; i<isCollide.length;i++){
            isCollide[i] = false;
        }
        if(ob != this){
            Vector radius_vector = new Vector(ob.x()-x(), ob.y()-y());
            float min_width = this.getWidth()/2+ob.getWidth()/2;
            float min_height = this.getHeight()/2+ob.getHeight()/2;
            if(Math.abs(radius_vector.x()) <= min_width && Math.abs(radius_vector.y()) <= min_height){
                //barrier to the top
                if(radius_vector.y() < 0 && Math.abs(radius_vector.x()) < min_width){
                    //System.out.println("barrier to the top");
                    isCollide[0] = true;
                }
                //barrier to the right
                if(radius_vector.x() > 0 && Math.abs(radius_vector.y()) < min_height){
                    isCollide[1] = true;
                }
                //barrier to the bottom
                if(radius_vector.y() > 0 && Math.abs(radius_vector.x()) < min_width){
                    //System.out.println("barrier to the bottom");
                    isCollide[2] = true;
                }
                //barrier to the left
                if(radius_vector.x() < 0 && Math.abs(radius_vector.y()) < min_height){
                    //System.out.println("barrier to the left");
                    isCollide[3] = true;
                }
            }
        }
        return isCollide[0] || isCollide[1] || isCollide[2] || isCollide[3];
    }
    
    public void checkBorderCross(GameObject ob){
        Vector radius_vector = new Vector(ob.x()-x(), ob.y()-y());
        float min_width = this.getWidth()/2+ob.getWidth()/2;
        float min_height = this.getHeight()/2+ob.getHeight()/2;
        
        
        if(Math.abs(radius_vector.x()) < min_width && 
           Math.abs(radius_vector.y()) < min_height+Math.abs(speed.y()*GameLoop.updateDelta()) &&
           Math.abs(radius_vector.y()) > min_height){
            Vector force;
            if(radius_vector.y() < 0 && speed.y()<0 && !borderChecked[0]){
                borderChecked[0] = true;
                force = new Vector(0, -speed.y()+(radius_vector.y()+ob.getHeight())*(1/GameLoop.updateDelta()));
                addForce(force.multy(mass));
            }
            if(radius_vector.y() > 0 && speed.y()>0 && !borderChecked[2]){
                borderChecked[2] = true;
                force = new Vector(0, -speed.y()+(radius_vector.y()-ob.getHeight())*(1/GameLoop.updateDelta()));
                addForce(force.multy(mass));
            }
        }
        if(Math.abs(radius_vector.y()) < min_height && 
           Math.abs(radius_vector.x()) < min_width+Math.abs(speed.x()*GameLoop.updateDelta()) &&
           Math.abs(radius_vector.x()) > min_width){
            Vector force;
            if(radius_vector.x() > 0 && speed.x()>0 && !borderChecked[3]){
                borderChecked[3] = true;
                force = new Vector(-speed.x()+(radius_vector.x()-ob.getWidth())*(1/GameLoop.updateDelta()), 0);
                addForce(force.multy(mass));
            }
            if(radius_vector.x() < 0 && speed.x()<0 && !borderChecked[1]){
                borderChecked[1] = true;
                force = new Vector(-speed.x()+(radius_vector.x()+ob.getWidth())*(1/GameLoop.updateDelta()), 0);
                addForce(force.multy(mass));
            } 
        }
    }
    
    
    public void setPosition(float posX, float posY) {
        position.set(posX, posY);
    }
    public void setPosition(Vector newPosition) {
        position.set(newPosition);
    }
    public void setSpeed(float x, float y) {
        position.set(x, y);
    }
    public void setSpeed(Vector newSpeed) {
        position.set(newSpeed);
    }
    
    
    public void addForce(Vector force){
        forces.add(force);
    }
    public Vector getSuperposition(){
        Vector superposition = new Vector(0,0);
        for(Vector force : forces){
            superposition = superposition.add(force);
        }
        return superposition;
    }
    
//=============================== GETTERS
    public float x() {
        return position.x();
    }
    public float y() {
        return position.y();
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
    public float oldX() {
        return oldPosition.x();
    }
    public float oldY() {
        return oldPosition.y();
    }
    public Vector speed() {
        return speed;
    }
    public float speedX() {
        return speed.x();
    }
    public float speedY() {
        return speed.y();
    }
    public boolean[] isCollide() {
        return isCollide;
    }
    public List<Animation> getAnimations() {
        return animations;
    }
    public List<Vector> getForces(){
        return forces;
    }
    public Vector acceleration(){
        return getSuperposition().multy(1/mass);
    }
    public Vector innerFictionCoeff(){
        return inner_friction_coeff;
    }
    public Vector outerFrictionCoeff(){
        return outer_friction_coeff;
    }
    
 
//=============================== SETTERS
    public void setX(float x) {
        this.position.setX(x);
    }
    public void setY(float y) {
        this.position.setY(y);
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
        this.speed.setX(speedX);
    }
    public void setSpeedY(float speedY){
        this.speed.setY(speedY);
    }
    public void setForces(List<Vector> forces){
        this.forces = forces;
    }
    public void setInnerFictionCoeff(float x, float y){
        inner_friction_coeff.set(x, y);
    }
    public void setOuterFrictionCoeff(float x, float y){
        outer_friction_coeff.set(x, y);
    }
    public void setInnerFictionCoeff(Vector v){
        inner_friction_coeff.set(v);
    }
    public void setOuterFrictionCoeff(Vector v){
        outer_friction_coeff.set(v);
    }
    public void setInnerFictionCoeffX(float x){
        inner_friction_coeff.setX(x);
    }
    public void setOuterFrictionCoeffX(float x){
        outer_friction_coeff.setX(x);
    }
    public void setInnerFictionCoeffY(float y){
        inner_friction_coeff.setY(y);
    }
    public void setOuterFrictionCoeffY(float y){
        outer_friction_coeff.setY(y);
    }
    
}
