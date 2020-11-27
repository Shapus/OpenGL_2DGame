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
    public Vector scalarMulty(Vector v){
        return new Vector(x*v.x, y*v.y);
    }
    public float length(){
        return (float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }
    public double cosWith(Vector v){
        return (this.x*v.x+this.y*v.y)/(this.length()*v.length());
    }
    public void set(float x, float y){
        this.setX(x);
        this.setY(y);
    }
    public void set(Vector v){
        this.setX(v.x());
        this.setY(v.y());
    }
    public void normalize(){
        float length = length();
        this.setX(x/length);
        this.setY(y/length);
    }
    
    
//=============================== GETTERS
    public float x() {
        return x;
    }
    public float y() {
        return y;
    }
    
    
//=============================== SETTERS   
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    
   
    
//=============================== OVERRIDDEN METHODS

    @Override    
    public String toString() {
        return x+" : "+y;
    }   
}


