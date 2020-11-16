/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.world;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class World {
    
//=============================== VARIABLES
    //all objects
    private static List<GameObject> objects = new ArrayList<>();
    
//=============================== METHODS
    //=== update world ===//
    public static void update(){
        objects.forEach((ob) -> {
            ob.update();
        });
    }
    //=== renreder world ===//
    public static void render(){
        objects.forEach((ob) -> {
            ob.render();
        });
        
    }
    
//=============================== GETTERS
    public static List<GameObject> getObjects() {
        return objects;
    }
    
}
