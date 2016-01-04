/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils.geometry;

import java.awt.Graphics;
import yajge.framework.utils.Vector2D;

/**
 * The Box class used as class for Geometry.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class Box extends Dot {

    /**
     * Size of Box.
     */
    protected Vector2D size;

    /**
     * Construct a new Box. The x and y position can be specified here via
     * Vector2D value. Size also specified via Vecor2D.
     *
     * @param pos The Box position.
     * @param size The Box size.
     */
    public Box(Vector2D pos, Vector2D size) {
        this.pos = pos;
        this.size = size;
    }

    /**
     * Construct a new Box. The x and y position can be specified here. The w
     * and h is size of box.
     *
     * @param x The Box X position.
     * @param y The Box Y position.
     * @param w The Box width.
     * @param h The Box height
     */
    public Box(float x, float y, float w, float h) {
        this(new Vector2D(x, y), new Vector2D(w, h));
    }

    /**
     * Construct a new Box. The x and y position is 0. The w and h set to 1.
     *
     */
    public Box() {
        this(new Vector2D(0, 0), new Vector2D(1, 1));
    }

    /**
     * Get the size of Box.
     *
     * @return the Box size
     */
    public Vector2D getSize() {
        return size;
    }
    
    /**
     * Get the Width of Box.
     *
     * @return the Box width
     */
    public float getWidth() {
        return this.getSize().getX();
    }
    
    /**
     * Get the Height of Box.
     *
     * @return the Box height
     */
    public float getHeight() {
        return this.getSize().getY();
    }

    /**
     * Set the size of Box.
     *
     * @param size the Box size
     */
    public void setSize(Vector2D size) {
        this.size = size;
    }

    /**
     * Draw this Box.
     *
     * @param g Canvas for drawing.
     */
    @Override
    public void render(Graphics g) {
        g.drawRect((int) pos.getX(), (int) pos.getY(),
                    (int) size.getX(), (int) size.getY());
    }

}
