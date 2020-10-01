/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.engine;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphics.Renderer;
import org.world.World;

/**
 *
 * @author ASUS
 */
public class GameLoop {
    private static boolean running = false;
    private static int updates = 0;
    private static final int MAX_UPDATES = 5;
    private static long lastUpdateTime = 0;
    
    private static int targetFPS = 60;
    private static final int targetTime = 1000000000 / targetFPS;
    
    public static void start(){
        Thread thread = new Thread(){
            public void run(){
                
                //int fps = 0;
                //long lastFpsCheck = System.nanoTime();
                
                running = true;
                lastUpdateTime = System.nanoTime();
                
                
                while(running){
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
                    
                    //fps check
                    /*
                    fps++;
                    if(System.nanoTime() - 1000000000 >= lastFpsCheck){
                        System.out.println(fps);
                        fps = 0;
                        lastFpsCheck = System.nanoTime();
                    }
                    */
                    
                    long timeTaken = System.nanoTime() - currentTime;
                    if(targetTime > timeTaken){
                        try {
                            Thread.sleep((targetTime - timeTaken)/1000000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    /*
                    long startTime = System.nanoTime();
                    
                    // Poll input
                    // Update game(moving objects, calculating phisics, game logic and etc.)
                    // If game will be complex and there is many items to update, should separate update and render
                    World.update();
                    
                    // Render(drawing objects)
                    Renderer.render();
                    
                    long timeTaken = System.nanoTime() - startTime;
                    if(timeTaken < targetTime){
                        try {
                            Thread.sleep((targetTime - timeTaken) / 1000000); //divide by 1000000 cause Thread.sleep() get time in milliseconds
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    */
                }
            }
        };
        thread.setName("GameLoop");
        thread.start();
    };
}
