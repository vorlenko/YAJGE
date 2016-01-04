/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils;

import yajge.framework.utils.clock.StandardClock;

/**
 *
 * @author bob
 */
public class FrameRate {

    private String frameRate;
    private long lastTime;
    private long delta;
    private int frameCount;
    
    private StandardClock sc;

    public FrameRate() {
        sc = new StandardClock();
    }
    
    

    public void initialize() {
        //lastTime = System.currentTimeMillis();
        sc.stampTime();
        frameRate = "FPS 0";
    }

    public void calculate() {
        //long current = System.currentTimeMillis();
        //delta += current - lastTime;
        delta += sc.getElapsedTime();
        //lastTime = current;
        sc.stampTime();
        frameCount++;
        if (delta > 1000) {
            delta -= 1000;
            frameRate = String.format("FPS %s", frameCount);
            frameCount = 0;
        }
    }

    public String getFrameRate() {
        return frameRate;
    }
}
