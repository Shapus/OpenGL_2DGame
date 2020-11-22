/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.engine;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphics.Renderer;
import org.input.MouseInput;
import org.world.World;

/**
 *
 * @author ASUS
 */
public class GameLoop {
//=============================== VARIABLES    
    //is game loop running
    private static boolean running = false;
    //how many times world was updated per target time
    private static int updates = 0;
    //how many times world can update per target time
    private static final int MAX_UPDATES = 5;
    //last update world time
    private static long lastUpdateTime = 0;
    
    //fps
    private static int targetFPS = 60;
    // 1/fps time
    private static final int targetTime = 1000000000 / targetFPS;

//=============================== METHODS
    
    //===start game loop in new thread ===//
    public static void start(){
        Thread thread = new Thread(){
            @Override
            public void run(){
                running = true;
                lastUpdateTime = System.nanoTime(); 
                while(running){
                    World.loadObjectsFromBuffer();
                    long currentTime = System.nanoTime();
                    updates = 0;
                    while(currentTime - lastUpdateTime >= targetTime){
                        World.update();
                        lastUpdateTime += targetTime;
                        updates++;
                        if(updates>MAX_UPDATES){
                            break;
                        }
                    }
                    Renderer.render();
                    MouseInput.create();
                    long timeTaken = System.nanoTime() - currentTime;
                    if(targetTime > timeTaken){
                        try {
                            Thread.sleep((targetTime - timeTaken)/1000000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MouseInput.updatePosition();
                }
            }
        };
        thread.setName("GameLoop");
        thread.start();
    };
    public static float updateDelta(){
        return 1.0f/1000000000 * targetTime;
    }
}
