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
public class Vector {
    
//=============================== VARIABLES
    private float x;
    private float y;
    
    
//=============================== CONSTRUCTORS
    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    
//=============================== METHODS
    public Vector add(Vector fv){
        return new Vector(x + fv.x, y + fv.y);
    }
    public Vector multy(float n){
        return new Vector(x*n, y*n);
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
