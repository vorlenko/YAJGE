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
public class SpaceshooterPanel extends GamePanel{

    @Override
    protected void initGSM() {
        gsm = new SSStateManager();
    }

    @Override
    public void initSize() {
        WIDTH = 400;
        HEIGHT = 300;
        SCALE = 2;
        
    }
    
    
    
}
