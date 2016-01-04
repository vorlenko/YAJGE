/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spaceshooter.entity;

import java.awt.image.BufferedImage;
import yajge.framework.entity.Sprite;
import yajge.framework.utils.Vector2D;

/**
 *
 * @author bob
 */
public class Alien extends Sprite{
    
    private final int ALIEN_SPEED = -1;

    public Alien(float x, float y, BufferedImage bi) {
        super(x, y, bi);
        dv.setX(ALIEN_SPEED);
    }
    
    @Override
    public void setPos(Vector2D newPos) {
        super.setPos(newPos);
    }
}
