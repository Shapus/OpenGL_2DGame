/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import org.world.GameObject;

/**
 *
 * @author ASUS
 */
public class Collision extends Force{

    @Override
    public void impactOn(GameObject go) {
        go.setSpeedY(-go.getSpeedY());
    }

    @Override
    public void react(GameObject go1, GameObject go2) {
    }
    
}
