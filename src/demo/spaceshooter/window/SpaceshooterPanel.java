/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spaceshooter.window;

import demo.spaceshooter.gamestate.SSStateManager;
import yajge.framework.windows.GamePanel;

/**
 *
 * @author bob
 */
public class SpaceshooterPanel extends GamePanel {

    @Override
    protected void initGSM() {
        gsm = new SSStateManager();
        gsm.setAttribute("WIDTH", WIDTH);
        gsm.setAttribute("HEIGHT", HEIGHT);
        gsm.setAttribute("CAMERA_X1", 0);
        gsm.setAttribute("CAMERA_Y1", 0);
        gsm.setAttribute("WORLD_X1", 0);
        gsm.setAttribute("WORLD_Y1", 0);
    }

    @Override
    public void initSize() {
        WIDTH = 400;
        HEIGHT = 300;
        SCALE = 2;

    }

}
