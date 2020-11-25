/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.util.ArrayList;
import java.util.List;
import org.engine.GameLoop;
import org.world.GameObject;

/**
 *
 * @author ASUS
 */
public class SupportReaction extends Force{

    @Override
    public void impactOn(GameObject go) {
        //reaction_vector.setX(-go.getForceSuperposition().getX());
        //reaction_vector.setY(-go.getForceSuperposition().getY());
        //go.setForceSuperposition(go.getForceSuperposition().add(reaction_vector));
        //Vector radius_vector = new Vector(go1.getPosX()-go2.getPosX(), go1.getPosY()-go2.getPosX());
        
    }

    @Override
    public void react(GameObject go1, GameObject go2) {
        Vector radius_vector = new Vector(go2.getPosX()-go1.getPosX(), go2.getPosX()-go1.getPosY());
        Vector reactionForce = new Vector(0,0);
        List<Vector> forcesBuffer = new ArrayList<>();
        Vector normalX = new Vector(0,0);
        Vector normalY = new Vector(0,0);
            if(go1.getPosX() > go2.getPosX()){
                normalX = new Vector(1,0);
                go1.setSpeedX(0);
            }
            else if(go1.getPosX() < go2.getPosX()){
                normalX = new Vector(-1,0);
                go1.setSpeedX(0);
            }
            if(go1.getPosY() > go2.getPosY()){
                normalY = new Vector(0,1);
                go1.setSpeedY(0);
            }
            else if(go1.getPosY() < go2.getPosY()){
                normalY = new Vector(0,-1);
                go1.setSpeedY(0);
            }
            int i = 0;
        for(Vector force : go1.getForces()){
            System.out.println(i+".X: "+force.getX());
            System.out.println(i+".Y: "+force.getY());
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
