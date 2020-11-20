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
import org.world.GameObject;
import org.world.World;

/**
 *
 * @author ASUS
 */
public class MouseInput implements MouseListener{
    
//=============================== VARIABLES    
    private static float x = 0;
    private static float y = 0;
    private static float oldX = 0;
    private static float oldY = 0;
    private static boolean isPressed = false;

 
    
//=============================== METHODS    
    public static float unitsX(){
        return EventListener.getUnitsWide()/Renderer.getWindowWidth()*(x);
    }
    public static float unitsY(){
        return EventListener.getUnitsTall()/Renderer.getWindowHeight()*(y);
    }
    public static boolean isMoved(){
        return x!=oldX || y!=oldY;
    }
    public static void updatePosition(){
        oldX = x;
        oldY = y;
    }
    public static void create(){
        if(isMoved() && isPressed){
            GameObject block = new TestBlock(Renderer.toGlobalX(unitsX()), Renderer.toGlobalY(unitsY()));
            World.add(block);
        }
    }
    
//=============================== OVERRIDE METHODS    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.isAutoRepeat()){
            return;
        }
        this.x = me.getX();
        this.y = me.getY();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.x = me.getX();
        this.y = me.getY();  
    }

    @Override
    public void mouseExited(MouseEvent me) {
        this.x = me.getX();
        this.y = me.getY();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if(me.isAutoRepeat()){
            return;
        }
        isPressed = true;
        this.x = me.getX();
        this.y = me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.isAutoRepeat()){
            return;
        }
        isPressed = false;
        this.x = me.getX();
        this.y = me.getY();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        this.x = me.getX();
        this.y = me.getY();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        this.x = me.getX();
        this.y = me.getY();
    }

    @Override
    public void mouseWheelMoved(MouseEvent me) {
        this.x = me.getX();
        this.y = me.getY();
    }
   
//=============================== GETTERS
    public static float getX() {
        return x;
    }
    public static float getY() {
        return y;
    }
    public static float getOldX() {
        return oldX;
    }
    public static float getOldY() {
        return oldY;
    }

//=============================== SETTERS    
    public static void setOldX(float oldX) {
        MouseInput.oldX = oldX;
    }
    public static void setOldY(float oldY) {
        MouseInput.oldY = oldY;
    }
    
    
}
