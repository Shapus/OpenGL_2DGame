/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.engine;

import org.graphics.Renderer;
import org.test.TestPlayer;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args){
        TestPlayer player = new TestPlayer();
        System.out.println(player.getAnimation());
        Renderer.init();
        GameLoop.start();
    }
}
