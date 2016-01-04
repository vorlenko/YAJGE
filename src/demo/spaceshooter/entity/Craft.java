/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spaceshooter.entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import yajge.framework.entity.Sprite;

/**
 *
 * @author bob
 */
public class Craft extends Sprite {

    private ArrayList<Missile> missiles;
    
    public Craft(float x, float y, BufferedImage bi) {
        super(x, y, bi);
        missiles = new ArrayList<>();
    }
    
    public ArrayList getMissiles() {
        return missiles;
    }
    
    public void fire(BufferedImage bi, int border) {
        if (missiles.size() < 30) {
            missiles.add(new Missile(getBox().getX() + getBox().getWidth(),
                    getBox().getY() + getBox().getHeight() / 2, bi, border));
        }
    }
    
}
