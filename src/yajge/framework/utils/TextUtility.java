/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * The TextUtility class is set of for work with strings.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class TextUtility {

    public static int drawString(Graphics g, int x, int y, String... str) {
        FontMetrics fm = g.getFontMetrics();
        int height = fm.getAscent() + fm.getDescent() + fm.getLeading();
        for (String s : str) {
            g.drawString(s, x, y + fm.getAscent());
            y += height;
        }
        return y;
    }

    public static int drawString(Graphics g, int x, int y, String str) {
        return drawString(g, x, y, new String[]{str});
    }

    public static int drawString(Graphics g, int x, int y, List<String> str) {
        return drawString(g, x, y, str.toArray(new String[0]));
    }

    public static int drawCenteredString(Graphics g, int w, int y, String... str) {
        FontMetrics fm = g.getFontMetrics();
        int height = fm.getAscent() + fm.getDescent() + fm.getLeading();
        for (String s : str) {
            Rectangle2D bounds = g.getFontMetrics().getStringBounds(s, g);
            int x = (w - (int) bounds.getWidth()) / 2;
            g.drawString(s, x, y + fm.getAscent());
            y += height;
        }
        return y;
    }

    public static int drawCenteredString(Graphics g, int w, int y, String str) {
        return drawCenteredString(g, w, y, new String[]{str});
    }

    public static int drawCenteredString(Graphics g, int w, int y,
            List<String> str) {
        return drawCenteredString(g, w, y, str.toArray(new String[0]));
    }
}
