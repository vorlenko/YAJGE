/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spaceshooter.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import yajge.framework.gamestate.GameState;
import yajge.framework.gamestate.GameStateManager;
import yajge.framework.utils.TextUtility;

/**
 *
 * @author bob
 */
public class MenuState extends GameState {

    private String[] options;
    private int currentChoice = 0;

    private Color titleColor;
    private Font titleFont;
    private Font font;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        
        init();

        titleColor = new Color(255, 255, 255);
        titleFont = new Font(
                "Century Gothic",
                Font.PLAIN,
                28);

        font = new Font("Arial", Font.PLAIN, 12);
    }

    @Override
    public void init() {
        options = new String[]{
            "Space Shooter",
            "Quit"
        };
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0,
                (int) gsm.getAttribute("WIDTH"),
                (int) gsm.getAttribute("HEIGHT"));
        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        //g.drawString("Demo Menu", 80, 70);
        TextUtility.drawCenteredString(g, (int) gsm.getAttribute("WIDTH"), 70, "Space Shooter");
        // draw menu options
        g.setFont(font);
        int y = 140;
        int fh = 0;
        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.RED);
            }
            //g.drawString(options[i], 145, 140 + i * 15);
            //fh = TextUtility.drawString(g, 145, y, options[i]);
            fh = TextUtility.drawCenteredString(g, (int) gsm.getAttribute("WIDTH"), y, options[i]);
            y = fh;
        }
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_ENTER) {
            select();
        }
        if (k == KeyEvent.VK_UP) {
            currentChoice--;
            if (currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if (k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if (currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }
    
    private void select() {
        if (currentChoice == 0) {
            gsm.setState("SPACE_SHUTER_STATE");
        }
        if (currentChoice == 1) {
            System.exit(0);
        }
    }

}
