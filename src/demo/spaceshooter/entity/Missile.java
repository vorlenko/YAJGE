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
public class Missile extends Sprite{
    /***
     * Speed of missle;
     */
    private final int MISSILE_SPEED = 2;
    /***
     * BORDER_X
     */
    private int BORDER = 0;

    public Missile(float x, float y, BufferedImage bi, int border) {
        super(x, y, bi);
        dv.setX(MISSILE_SPEED);
        setBORDER(border);
    }

    public void setBORDER(int BORDER) {
        this.BORDER = BORDER;
    }

    @Override
    public void setPos(Vector2D newPos) {
        super.setPos(newPos);
        if (getPos().getX() > BORDER){
            setVisible(false);
        }
    }


    
}
