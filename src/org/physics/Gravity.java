/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.physics;

import org.world.GameObject;

/**
 *
 * @author pupil
 */
public class Gravity extends Force{
    final private static float G = 0.1f;
    private static final Vector FORCE_VECTOR = new Vector(0, G);
    
    @Override
    public void impactOn(GameObject go){
        go.addForce(FORCE_VECTOR.multy(go.getMass()));
    }

    @Override
    public void react(GameObject go1, GameObject go2) {
    }
}
