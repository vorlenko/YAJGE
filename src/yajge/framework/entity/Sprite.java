/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import yajge.framework.utils.Vector2D;

/**
 *
 * @author bob
 */
public class Sprite extends Entity{
    
    protected Vector2D dv = new Vector2D();
    protected boolean visible;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Sprite(float x, float y, BufferedImage bi) {
        super(x, y, bi);
        visible = true;
    }

    public float getDx() {
        return dv.getX();
    }

    public void setDv(Vector2D newDv) {
        dv = newDv;
    }

    public float getDy() {
        return dv.getY();
    }

    public Vector2D getDv() {
        return dv;
    }
    
    public void move(){
        setPos(getPos().add(dv));
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.getImage(), null,
                    (int) this.getBox().getPos().getX(),
                    (int) this.getBox().getPos().getY());
        super.draw(g);
    }
    
}
