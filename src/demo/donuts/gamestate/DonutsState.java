/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.donuts.gamestate;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import yajge.framework.gamestate.GameState;
import yajge.framework.gamestate.GameStateManager;
import yajge.framework.utils.TextUtility;

/**
 *
 * @author bob
 */
public class DonutsState extends GameState {

    public DonutsState(GameStateManager gsm) {
        super(gsm);

    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        //Clean canvas
        g.setColor(Color.BLACK);

        g.fillRect(0, 0,
                (int) gsm.getAttribute("WIDTH"),
                (int) gsm.getAttribute("HEIGHT"));
        DrawDonuts(g);
        // draw title
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.PLAIN, 12));

        TextUtility.drawCenteredString(g, (int) gsm.getAttribute("WIDTH"), 70, "Donuts");
    }

    private void DrawDonuts(Graphics2D g2d) {
        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        
        double w = (int)gsm.getAttribute("WIDTH");
        double h = (int)gsm.getAttribute("HEIGHT");

        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.RED);

        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at
                    = AffineTransform.getTranslateInstance(w / 2, h / 2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }

    @Override
    public void keyPressed(int k) {
    }

    @Override
    public void keyReleased(int k) {
    }

    @Override
    public void keyTyped(int k) {
    }

}
