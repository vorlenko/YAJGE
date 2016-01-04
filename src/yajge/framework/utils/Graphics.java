/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

/**
 *
 * @author bob
 */
public class Graphics {
    public static BufferedImage makeTransparent(BufferedImage image) {
        // Some preliminaries and setup
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();

        int transparency = image.getColorModel().getTransparency();
        BufferedImage copy = gc.createCompatibleImage(image.getWidth(),
                image.getHeight(),
                transparency);
        // buffered, optimized copy of bi made
        Graphics2D g2d = copy.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        // bi drawn
        g2d.dispose();
        return copy;
    }

    public static BufferedImage makeColorTransparent(BufferedImage image, Color color) {
        BufferedImage dimg = new BufferedImage(image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dimg.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.drawImage(image, null, 0, 0);
        g.dispose();
        for (int i = 0; i < dimg.getHeight(); i++) {
            for (int j = 0; j < dimg.getWidth(); j++) {
                if (dimg.getRGB(j, i) == color.getRGB()) {
                    dimg.setRGB(j, i, 0x00000000);
                }
            }
        }
        return dimg;
    }
}
