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
    private float scalar;
    private float x;
    private float y;
    
    
//=============================== CONSTRUCTORS
    public ForceVector(float scalar, float x, float y){
        this.scalar = scalar;
        this.x = x;
        this.y = y;
    }
    
    
//=============================== METHODS
    public ForceVector add(ForceVector fv){
        float modul_1 = (float)Math.pow(this.length(),2);
        float modul_2 = (float)Math.pow(fv.length(),2);
        float cos = (x*y + fv.x*fv.y) / (modul_1 * modul_2);
        float newScalar = (float)Math.sqrt(modul_1 + modul_2 + modul_1 * modul_2 * cos);
        return new ForceVector(newScalar, x += fv.x, y += fv.y);
    }
    public ForceVector multy(float n){
        return new ForceVector(scalar*n, x, y);
    }
    public float length(){
        return (float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }
    
    
//=============================== GETTERS
    public float getScalar() {
        return scalar;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    
    
//=============================== SETTERS   
    public void setScalar(float scalar) {
        this.scalar = scalar;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    
}
