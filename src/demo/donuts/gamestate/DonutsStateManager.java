/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.donuts.gamestate;

import java.awt.Font;
import yajge.framework.gamestate.GameStateManager;

/**
 *
 * @author bob
 */
public class DonutsStateManager extends GameStateManager {

    public DonutsStateManager() {
        super();
    }

    @Override
    protected final void loadState(String state) {
        switch (state) {
            case "MENUSTATE":
                hmGameState.put(state, new demo.donuts.gamestate.MenuState(this));
                break;
            case "DONUTSSTATE":
                hmGameState.put(state, new demo.donuts.gamestate.DonutsState(this));
                break;
            case "BOXCOLLISION":
                hmGameState.put(state, new demo.donuts.gamestate.BoxCollision(this));
                break;
            default:
                break;
        }
    }

    protected void initStates() {
        states = new String[]{
            "MENUSTATE",
            "DONUTSSTATE",
            "BOXCOLLISION"
        };
    }

}
