/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.physics;

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
    }

    @Override
    public void react(GameObject go1, GameObject go2) {   
        List<Vector> forcesBuffer = new ArrayList<>();
        Vector normal = new Vector(0,0);
        //barrier to the top
        if(go1.isCollide()[0] && !go1.isCollided[0]){
            normal.set(0, 1);
            go1.isCollided[0] = true;
            go1.setSpeedY(0);
        }
        //barrier to the bottom
        if(go1.isCollide()[2] && !go1.isCollided[2]){
            normal.set(0, -1);
            go1.isCollided[2] = true;
            go1.setSpeedY(0);
        }
        //barrier to the right
        if(go1.isCollide()[1] && !go1.isCollided[1]){
            normal.set(-1, 0);
            go1.isCollided[1] = true;
            go1.setSpeedX(0);
        }       
        //barrier to the left
        if(go1.isCollide()[3] && !go1.isCollided[3]){
            normal.set(1,0);
            go1.isCollided[3] = true;
            go1.setSpeedX(0);
        }
        
        
        for(Vector force : go1.getForces()){
            if(force.x() * normal.x() < 0){
                forcesBuffer.add(force.multy(-1, 0));
            }
            if(force.y() * normal.y() < 0){
                forcesBuffer.add(force.multy(0, -1));
            }
        }
        forcesBuffer.forEach(force -> {
            go1.addForce(force);
        });
    }
    
}
