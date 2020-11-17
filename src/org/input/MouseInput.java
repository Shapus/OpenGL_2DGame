 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.input;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import org.graphics.EventListener;
import org.graphics.Renderer;
import org.test.TestBlock;

/**
 *
 * @author ASUS
 */
public class MouseInput implements MouseListener{
    float[][] translationMatrix = {{1,0},{-Renderer.getWindowWidth()/EventListener.getUnitsWide()/2, -Renderer.getWindowHeight()/EventListener.getUnitsTall()/2}};
    //{0,0} -> {-width/unitWide/2, -width/unitTall/2}
    @Override
    public void mouseClicked(MouseEvent me) {
        float x = (me.getX()-Renderer.getWindowWidth()/2)/EventListener.getUnitsWide();
        float y = -(me.getY()-Renderer.getWindowHeight()/2)/EventListener.getUnitsTall();
        System.out.println("Pixels " + me.getX() + " : " + me.getY());
        System.out.println("Units " + x + " : " + y);
        System.out.println("Unit size " + EventListener.getUnitsWide() + " : " + EventListener.getUnitsTall());
        System.out.println("");
        new TestBlock(x,y);
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
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseWheelMoved(MouseEvent me) {
    }
    
}
