/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.util.ArrayList;
import java.util.List;
import org.world.GameObject;

/**
 *
 * @author ASUS
 */
public class SupportReaction extends Force{

    @Override
    public void impactOn(GameObject go) {
    }

    @Override
    public void react(GameObject go1, GameObject go2) {
        List<Vector> forcesBuffer = new ArrayList<>();
        Vector normalX = new Vector(0,0);
        Vector normalY = new Vector(0,0);
        Vector redius_vector = new Vector(go2.x()-go1.x(), go2.y()-go1.y());
        float height = (go1.getHeight()+go2.getHeight())/2;
        float width = (go1.getWidth()+go2.getWidth())/2;
        float speedAlpha = 0.8f;

        
        if(go1.x() > go2.x()){
            normalX = new Vector(1,0);
            System.out.println("right");
            go1.setSpeedX(0);
        }
        else if(go1.x() < go2.x()){
            normalX = new Vector(-1,0);
            System.out.println("left");
            go1.setSpeedX(0);
        }
        if(go1.y() > go2.y()){
            normalY = new Vector(0,1);
            System.out.println("top");
            go1.setSpeedY(0);
        }
        else if(go1.y() < go2.y()){
            normalY = new Vector(0,-1);
            System.out.println("bottom");
            go1.setSpeedY(0);
        }
        
        for(Vector force : go1.getForces()){
            if(force.x() * normalX.x() < 0){
                forcesBuffer.add(force.scalarMulty(new Vector(-1,0)));
            }
            if(force.y() * normalY.y() < 0){
                forcesBuffer.add(force.scalarMulty(new Vector(0,-1)));
            }
        }
        for(Vector force : forcesBuffer){
            go1.addForce(force);
        }
    }
    
}
