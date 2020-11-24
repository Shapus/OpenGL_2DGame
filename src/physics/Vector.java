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
    private double x;
    private double y;
    
    
//=============================== CONSTRUCTORS
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    
//=============================== METHODS
    public Vector add(Vector fv){
        return new Vector(x + fv.x, y + fv.y);
    }
    public Vector multy(double n){
        return new Vector(x*n, y*n);
    }
    public Vector multy(double n1, double n2){
        return new Vector(x*n1, y*n2);
    }
    public float length(){
        return (float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }
    
    
//=============================== GETTERS
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    
    
//=============================== SETTERS   
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    
}
