/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import org.world.GameObject;

/**
 *
 * @author pupil
 */
public class Gravity extends Force{
    final private static float G = 1;
    private static final ForceVector FORCE_VECTOR = new ForceVector(G, 0, 1);
    
    
    @Override
    public void impactOn(GameObject go){
        go.setForceSuperposition(go.getForceSuperposition().add(FORCE_VECTOR.multy(go.getMass())));
    }
}
