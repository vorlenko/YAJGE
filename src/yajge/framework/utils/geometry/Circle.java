/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils.geometry;

import java.awt.Graphics;
import yajge.framework.utils.Vector2D;

/**
 * The Circle class used as class for Geometry.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class Circle extends Dot {

    /**
     * Radius of Circle.
     */
    protected float radius;

    /**
     * Construct a new Circle. The x and y position can be specified here via
     * Vector2D value. Radius specified also.
     *
     * @param pos The Circle position.
     * @param radius The Circle radius.
     */
    public Circle(Vector2D pos, float radius) {
        this.pos = pos;
        this.radius = radius;
    }

    /**
     * Construct a new Circle. The x and y position can be specified here.
     * Radius specified also.
     *
     * @param x The Circle X position.
     * @param y The Circle Y position.
     * @param radius The Circle radius.
     */
    public Circle(float x, float y, float radius) {
        this(new Vector2D(x, y), radius);
    }

    /**
     * Get the radius of this Circle.
     *
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }
    
    
    /**
     * Draw this Circle.
     *
     * @param g Canvas for drawing.
     */
    public void render(Graphics g) {
        int diameter = (int)radius * 2;
        g.drawOval((int)pos.getX() - (int)radius, (int)pos.getY() - (int)radius, diameter, diameter);
    }

}
