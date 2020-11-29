/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.engine;

import org.graphics.Renderer;
import org.resource.Loader;
import org.test.TestBlock;
import org.test.TestPlayer;
import org.world.World;

/**
 *
 * @author ASUS
 */
public class Main {
    public static TestPlayer player;
    public static void main(String[] args){
        Loader.load("wall", "/res/textures/stone_wall.png");
        Loader.load("cat", "/res/cat.jpg");
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
        player = new TestPlayer(3f,3f);
        World.add(new TestBlock(0,1));
        World.add(new TestBlock(1,1));
        World.add(new TestBlock(2,1));
        World.add(new TestBlock(3,1));
        World.add(new TestBlock(4,1));
        World.add(new TestBlock(5,1));
        World.add(new TestBlock(6,1));
        World.add(new TestBlock(6,2));
        World.add(new TestBlock(6,3));
        World.add(new TestBlock(6,4));
        World.add(new TestBlock(6,5));
        World.add(new TestBlock(6,6));
        World.add(new TestBlock(5,6));
        World.add(new TestBlock(4,6));
        World.add(new TestBlock(3,6));
        World.add(new TestBlock(2,6));
        World.add(new TestBlock(1,6));
        World.add(new TestBlock(0,6));
        World.add(new TestBlock(0,5));
        World.add(new TestBlock(0,4));
        World.add(new TestBlock(0,3));
        World.add(new TestBlock(0,2));
        World.add(player);
        Renderer.init();
        GameLoop.start();
    }
}
