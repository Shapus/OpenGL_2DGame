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
        float speedAlpha = 0.8f;
            if(go1.getPosX() > go2.getPosX()){
                normalX = new Vector(1,0);
                go1.setSpeedX(speedAlpha * Math.abs(go1.getSpeedX()));
            }
            if(go1.getPosX() < go2.getPosX()){
                normalX = new Vector(-1,0);
                go1.setSpeedX(speedAlpha * -Math.abs(go1.getSpeedX()));
            }
            if(go1.getPosY() > go2.getPosY()){
                normalY = new Vector(0,1);
                go1.setSpeedY(speedAlpha * Math.abs(go1.getSpeedY()));
            }
            if(go1.getPosY() < go2.getPosY()){
                normalY = new Vector(0,-1);
                go1.setSpeedY(speedAlpha * -Math.abs(go1.getSpeedY()));
            }
            int i = 0;
        for(Vector force : go1.getForces()){
            if(force.getX() * normalX.getX() < 0){
                forcesBuffer.add(force.scalarMulty(new Vector(-1,0)));
            }
            if(force.getY() * normalY.getY() < 0){
                forcesBuffer.add(force.scalarMulty(new Vector(0,-1)));
            }
        }
        for(Vector force : forcesBuffer){
            go1.addForce(force);
        }
    }
    
}
