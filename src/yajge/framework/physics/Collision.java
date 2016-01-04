/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.physics;

import yajge.framework.utils.geometry.Box;
import yajge.framework.utils.geometry.Circle;

/**
 * The Collision class used to: - check Collision; - check intersctions.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class Collision {

    /**
     * intersects check if two Circles intersects;
     *
     * @param c1 the first Circle
     * @param c2 the second Circle
     * @return true if circles intersects
     */
    public static boolean intersects(Circle c1, Circle c2) {

        float distance = c1.getPos().distSqr(c2.getPos());

        float totalRadius = c1.getRadius() + c2.getRadius();

        return distance < totalRadius * totalRadius;
    }

    /**
     * intersects check if two Boxes intersects;
     *
     * @param b1 the first Box
     * @param b2 the second Box
     * @return true if boxes intersects
     */
    public static boolean intersects(Box b1, Box b2) {
        /*
         return !(otherBox.x >= x+w || otherBox.x+otherBox.w <= x ||
         otherBox.y >= y+h || otherBox.y+otherBox.h <= y);
         */

        return !(b2.getX() >= b1.getX() + b1.getWidth()
                || b2.getX() + b2.getWidth() <= b1.getX()
                || b2.getY() >= b1.getY() + b1.getHeight()
                || b2.getY() + b2.getHeight()<= b1.getY());

    }
}
