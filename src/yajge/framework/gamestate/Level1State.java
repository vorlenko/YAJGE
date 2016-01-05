/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import yajge.framework.utils.TextUtility;

/**
 *
 * @author bob
 */
public class Level1State extends GameState{
    private Color titleColor;
    private Font titleFont;
    private Font font;

    Level1State(GameStateManager gsm) {
        //this.gsm = gsm;
        super(gsm);
        
        titleColor = new Color(255, 255, 255);
        titleFont = new Font(
                "Century Gothic",
                Font.PLAIN,
                28);

        font = new Font("Arial", Font.PLAIN, 12);
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
        g.setColor(Color.RED);
        
        g.fillRect(0, 0, 
                (int)gsm.getAttribute("WIDTH"),
                (int)gsm.getAttribute("HEIGHT"));
        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        
        TextUtility.drawCenteredString(g, (int)gsm.getAttribute("WIDTH"), 70, "Level1");
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
