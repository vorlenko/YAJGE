/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils;

/**
 * The Vector2D class used for Math operations.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class Vector2D {

    private float x;
    private float y;

    /**
     * Construct a new Vector2D. The x and y position can be specified here.
     *
     * @param x The X position.
     * @param y The Y position.
     */
    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Construct a new Vector2D. The x and y position by defult is 0.
     *
     */
    public Vector2D() {
        this(0, 0);
    }

    /**
     * Get Vector X
     *
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * Set vector X
     *
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Get Vector Y
     *
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * Set Vector Y
     *
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Get distance between 2 points
     *
     * @param v2 the second point
     * @return distance between 2 points
     */
    public float dist(Vector2D v2) {
        float xDiff = x - v2.getX();
        float yDiff = y - v2.getY();
        return (float) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    /**
     * Get sqr(distance) between 2 points
     *
     * @param v2 the second point
     * @return Sqr(distance) between 2 points
     */
    public float distSqr(Vector2D v2) {
        float xDiff = x - v2.getX();
        float yDiff = y - v2.getY();
        return xDiff * xDiff + yDiff * yDiff;
    }

    /**
     * Add 2 Vectors
     *
     * @param v the second point
     * @return New Vector2D as sum of two vectors
     */
    public Vector2D add(Vector2D v) {
        return new Vector2D(x + v.x, y + v.y);
    }
}
