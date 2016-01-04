/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils.geometry;

import java.awt.Graphics;
import java.util.ArrayList;
import yajge.framework.utils.Vector2D;

/**
 * The Polygon class used as class for Geometry.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class Polygon extends Dot {

    /**
     * List of points.
     */
    protected ArrayList<Vector2D> list;

    /**
     * Construct a new Polygon. The x and y position can be specified here. via
     * Vector2D value. List of dots assigned too.
     *
     * @param pos The Polygon position.
     * @param list The list polygon's points
     */
    public Polygon(Vector2D pos, ArrayList<Vector2D> list) {
        this.pos = pos;
        this.list = list;
    }

    /**
     * Construct a new Polygon. The x and y position is 0 here. via Vector2D
     * value. List of dots assigned too.
     *
     * @param list The list polygon's points
     */
    public Polygon(ArrayList<Vector2D> list) {
        this(new Vector2D(), list);
    }

    /**
     * Draw this Polygon.
     *
     * @param g Canvas for drawing.
     */
    @Override
    public void render(Graphics g) {
        Vector2D v1 = list.get(list.size() - 1).add(pos);
        for (Vector2D element : list) {
            Vector2D v2 = element.add(pos);
            g.drawLine((int) v1.getX(), (int) v1.getY(), (int) v2.getX(), (int) v2.getY());
            v1 = v2;
        }
    }

    /**
     * Get the List of polygon's points.
     *
     * @return the List of polygon's points
     */
    public ArrayList<Vector2D> getList() {
        return list;
    }

}
