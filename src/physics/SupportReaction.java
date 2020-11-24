/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

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
        for(Vector force : go1.getForces()){
            double cos = (radius_vector.getX()*force.getX()+radius_vector.getY()*force.getY())/(radius_vector.length()*force.length());
            System.out.println("Cos:" + cos);
            float sin = (float) Math.sin(Math.acos(cos));
            if(cos < 0){
                cos = 0;
            }
            if(sin < 0){
                sin = 0;
            }
            reactionForce = reactionForce.add(force.multy(cos, sin));
        }
        go1.addForce(reactionForce);
    }
    
}
