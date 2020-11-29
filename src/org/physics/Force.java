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
public abstract class Force {
    public abstract void impactOn(GameObject go);
    public abstract void react(GameObject go1, GameObject go2);
}
