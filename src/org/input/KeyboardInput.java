/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.input;

import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

/**
 *
 * @author ASUS
 */
public class KeyboardInput implements KeyListener{
    private static boolean[] keys = new boolean[256];
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.isAutoRepeat()){
            return;
        }
        keys[ke.getKeyCode()] = true;
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.isAutoRepeat()){
            return;
        }
        keys[ke.getKeyCode()] = false;
    }
    
    public static boolean getKey(int keyCode){
        return keys[keyCode];
    }
    
}
