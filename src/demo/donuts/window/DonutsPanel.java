/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.donuts.window;

import demo.donuts.gamestate.DonutsStateManager;
import yajge.framework.windows.GamePanel;

/**
 *
 * @author bob
 */
public class DonutsPanel extends GamePanel{

    @Override
    protected void initGSM() {
        gsm = new DonutsStateManager();
    }
    
}
