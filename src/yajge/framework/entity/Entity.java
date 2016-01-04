/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import yajge.framework.utils.Vector2D;
import yajge.framework.utils.geometry.Box;
import yajge.framework.utils.geometry.Dot;

/**
 *
 * @author bob
 */
public class Entity {

    /**
     * *
     * Entity posityon
     */
    private Vector2D pos;
    /**
     * *
     * Entity Image
     */
    private BufferedImage image;
    /**
     * List of points.
     */
    protected Box box = new Box();
    /**
     * If draw in debug mode
     */
    public boolean debug = true;

    public Entity(float x, float y, BufferedImage bi) {
        pos = new Vector2D(x, y);
        setImage(bi);
    }

    public BufferedImage getImage() {

        return image;
    }

    public void setImage(BufferedImage image) {
        int transparency = image.getColorModel().getTransparency();
        /*Graphics2D g = image.createGraphics();
         g.setBackground(new Color(0, 0, 0, 0));
         g.clearRect(0, 0, image.getWidth(), image.getHeight());*/

        this.image = image;
        //this.image = makeTransparent(image);
        //this.image = image;
        //this.image = gc.createCompatibleImage(image.getWidth(), image.getHeight(), transparency);

        box.setPos(pos.add(new Vector2D((-1) * getImage().getWidth() / 2,
                (-1) * getImage().getHeight() / 2)));
        box.setSize(new Vector2D(getImage().getWidth(), getImage().getHeight()));
    }

    public Vector2D getPos() {
        return pos;
    }

    public void setPos(Vector2D newPos) {
        pos = newPos;
        box.setPos(pos.add(new Vector2D((-1) * getImage().getWidth() / 2,
                (-1) * getImage().getHeight() / 2)));
        box.setSize(new Vector2D(getImage().getWidth(), getImage().getHeight()));
    }

    public Box getBox() {
        return box;
    }

    public void draw(Graphics2D g) {
        if (debug) {
            //Draw this border
            g.setColor(Color.red);
            this.getBox().render(g);
            //Draw this POS
            g.setColor(Color.red);
            Dot dot = new Dot(this.getPos());
            dot.render(g);
        }
    }

}
