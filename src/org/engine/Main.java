/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.engine;

import org.graphics.Renderer;
import org.resources.Loader;
import org.test.TestPlayer;

/**
 *
 * @author ASUS
 */
public class Main {
    public static TestPlayer player;
    public static void main(String[] args){
        Loader.load("wall", "/res/textures/stone_wall.png");
        String[] paths = {
            "/res/sprites/coin/image_part_000.png",
            "/res/sprites/coin/image_part_001.png",
            "/res/sprites/coin/image_part_002.png",
            "/res/sprites/coin/image_part_003.png",
            "/res/sprites/coin/image_part_004.png",
            "/res/sprites/coin/image_part_005.png",
            "/res/sprites/coin/image_part_006.png",
            "/res/sprites/coin/image_part_007.png",
            "/res/sprites/coin/image_part_008.png",
            "/res/sprites/coin/image_part_009.png" 
        };
        Loader.load("coin", paths);
        player = new TestPlayer();
        Renderer.init();
        GameLoop.start();
    }
}
