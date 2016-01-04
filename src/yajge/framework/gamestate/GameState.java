/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.gamestate;

/**
 *
 * @author bob
 */
public abstract class GameState {

    protected GameStateManager gsm;
    protected boolean debug = true;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void init();

    public abstract void update();

    public abstract void draw(java.awt.Graphics2D g);

    public abstract void keyPressed(int k);

    public abstract void keyReleased(int k);
    public abstract void keyTyped (int k);
}
