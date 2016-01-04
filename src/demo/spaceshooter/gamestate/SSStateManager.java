/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spaceshooter.gamestate;

import yajge.framework.gamestate.GameStateManager;
import yajge.framework.utils.ResourceLoader;

/**
 *
 * @author bob
 */
public class SSStateManager extends GameStateManager {

    final String MENU = "MENUSTATE";
    final String GAME_STATE1 = "SPACE_SHUTER_STATE";

    public SSStateManager() {
        super();
    }

    @Override
    protected final void loadState(String state) {
        switch (state) {
            case MENU:
                this.removeAttribute("Background1");
                this.removeAttribute("CRAFT_IMG");
                this.removeAttribute("MISSILE_IMG");
                hmGameState.put(state, new demo.spaceshooter.gamestate.MenuState(this));
                break;
            case GAME_STATE1:
                this.setAttribute("Background1",
                        ResourceLoader.loadSprite(SSGameState.class,
                                "/res/background/starfield.jpg",
                                true));
                this.setAttribute("CRAFT_IMG",
                        ResourceLoader.loadSprite(SSGameState.class,
                                "/res/sprites/craft.png",
                                false));
                this.setAttribute("MISSILE_IMG",
                        ResourceLoader.loadSprite(SSGameState.class,
                                "/res/sprites/missile.png",
                                false));
                this.setAttribute("ALIEN_IMG",
                        ResourceLoader.loadSprite(SSGameState.class,
                                "/res/sprites/alien.png",
                                false));
                hmGameState.put(state, new demo.spaceshooter.gamestate.SSGameState(this));
                break;
            default:
                break;
        }
    }

    protected void initStates() {
        states = new String[]{
            MENU,
            GAME_STATE1
        };
    }

}
