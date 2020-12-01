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
public class Friction extends Force{

    @Override
    public void impactOn(GameObject go) {
        go.addForce(new Vector(go.speed()).multy(go.inner_friction_coeff()).multy(-1));
    }

    @Override
    public void react(GameObject go1, GameObject go2) {}
    
}
