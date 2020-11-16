/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.graphics;

import java.util.ArrayList;
import java.util.List;
import org.resource.ImageResource;

/**
 *
 * @author pupil
 */
public class Animation {
//=============================== VARIABLES
    //framelist
    private List<ImageResource> frames;
    //current frame
    private int currentFrame = 0;
    //Animation FPS
    private int fps = 8;
    private long lastFrameTime = 0;
    //loop flag
    private boolean loop = true;

    
//=============================== CONSTRUCTORS
    public Animation(){}
    public Animation(List<ImageResource> frames){
        this.setFrames(frames);
    }
    public Animation(ImageResource ... frames){
        this.setFrames(frames);
    }
//=============================== METHODS
    //=== play animation ===//
    public void play(){
        long currentTime = System.nanoTime();
        if(currentTime > lastFrameTime + 1000000000/fps){
            currentFrame++;
            if(currentFrame >= frames.size()){
                if(loop){
                    currentFrame %= frames.size();
                }
                else{
                    currentFrame--;
                }
            }
        }
    }
    //=== get current frame ===//
    public ImageResource getFrame(){
        return frames.get(currentFrame);
    }
    
//=============================== GETTERS
    public List<ImageResource> getFrames() { return frames; }
    public int getFrameIndex() { return currentFrame; }
    public int getFps() { return fps; }
    public long getLastFrameTime() { return lastFrameTime; }
    public boolean isLoop() { return loop; }

//=============================== SETTERS
    public void setFrames(List<ImageResource> frames) { this.frames = frames; }
    public void setFrames(ImageResource ... frames) {
        if(this.frames == null){
            this.frames = new ArrayList();
        }
        for (ImageResource frame : frames) {
            this.frames.add(frame);
        }
    }
    public void setFrameIndex(int currentFrame) { this.currentFrame = currentFrame; }
    public void setFps(int fps) { this.fps = fps; }
    public void setLoop(boolean loop) { this.loop = loop; }
    
}
