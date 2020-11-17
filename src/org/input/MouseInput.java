 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.input;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import org.engine.Main;
import org.graphics.EventListener;
import org.graphics.Renderer;
import org.test.TestBlock;

/**
 *
 * @author ASUS
 */
public class MouseInput implements MouseListener{
    @Override
    public void mouseClicked(MouseEvent me) {
        new TestBlock(me.getX(),me.getY());
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Main.player.setPosition(me.getX(), me.getY());
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseWheelMoved(MouseEvent me) {
    }
    
}
