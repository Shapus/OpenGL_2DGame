/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

/**
 *
 * @author pupil
 */
public class ForceVector {
    
//=============================== VARIABLES
    private float x;
    private float y;
    
    
//=============================== CONSTRUCTORS
    public ForceVector(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    
//=============================== METHODS
    public ForceVector add(ForceVector fv){
        return new ForceVector(x + fv.x, y + fv.y);
    }
    public ForceVector multy(float n){
        return new ForceVector(x*n, y*n);
    }
    public float length(){
        return (float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }
    
    
//=============================== GETTERS
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    
    
//=============================== SETTERS   
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    
}
