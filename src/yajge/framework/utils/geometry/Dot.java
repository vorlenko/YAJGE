/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils.geometry;

import java.awt.Graphics;
import yajge.framework.utils.Vector2D;

/**
 * The Dot class used as base class for Geometry.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class Dot {

    /**
     * Position of object.
     */
    protected Vector2D pos;

    /**
     * Construct a new Dot. The x and y position can be specified here. via
     * Vector2D value
     *
     * @param pos The Dot position.
     */
    public Dot(Vector2D pos) {
        this.pos = pos;
    }

    /**
     * Construct a new Dot. The x and y position can be specified here.
     *
     * @param x The X position.
     * @param y The Y position.
     */
    public Dot(float x, float y) {
        this(new Vector2D(x, y));
    }

    /**
     * Construct a new Dot. The x and y position set to 0.
     *
     */
    public Dot() {
        this(new Vector2D());
    }

    /**
     * Get the position of this Dot.
     *
     * @return the Dot positon
     */
    public Vector2D getPos() {
        return pos;
    }
    
    /**
     * Get the X position of this Dot.
     *
     * @return the Dot positon
     */
    public float getX() {
        return pos.getX();
    }
    
    /**
     * Get the Y position of this Dot.
     *
     * @return the Dot positon
     */
    public float getY() {
        return pos.getY();
    }

    /**
     * Set the position of this Dot.
     *
     * @param pos The Position of this attribute.
     */
    public void setPos(Vector2D pos) {
        this.pos = pos;
    }

    /**
     * Draw this Dot.
     *
     * @param g Canvas for drawing.
     */
    public void render(Graphics g) {
        g.drawOval((int)pos.getX(), (int)pos.getY(), 1, 1);
    }

}
