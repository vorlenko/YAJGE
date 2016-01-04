/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import yajge.framework.utils.FrameRate;
import yajge.framework.utils.TextUtility;

/**
 *
 * @author bob
 */
public class GameStateManager {

    protected Font fpsFont;
    protected String[] states;
    protected String currentState;
    protected HashMap<String, GameState> hmGameState = new HashMap<String, GameState>();

    private volatile Map<String, Object> attributes = Collections.synchronizedMap(new HashMap<String, Object>());
    
    protected FrameRate frameRate = new FrameRate();

    public GameStateManager() {

        initStates();
        currentState = states[0];

        loadState(currentState);
        
        fpsFont = new Font(
                "Arial",
                Font.PLAIN,
                10);
        
        frameRate.initialize();
    }

    /**
     * *
     * Init list of acceptable states
     */
    protected void initStates() {
        states = new String[]{
            "MENUSTATE",
            "LEVEL1STATE"
        };
    }

    protected void loadState(String state) {
        switch (state) {
            case "MENUSTATE":
                hmGameState.put(state, new MenuState(this));
                break;
            case "LEVEL1STATE":
                hmGameState.put(state, new Level1State(this));
                break;
            default:
                break;
        }

    }

    public void setState(String state) {
        unloadState(currentState);
        currentState = state;
        loadState(currentState);
    }

    private void unloadState(String state) {
        hmGameState.remove(state);
    }

    public void update() {
        try {
            hmGameState.get(currentState).update();
        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D g) {
        try {
            hmGameState.get(currentState).draw(g);
            g.setColor(Color.gray);
            g.setFont(fpsFont);
            frameRate.calculate();
            TextUtility.drawString(g, 20, 0, frameRate.getFrameRate());
        } catch (Exception e) {
        }
    }

    public void keyPressed(int keyCode) {
        hmGameState.get(currentState).keyPressed(keyCode);
    }

    public void keyReleased(int keyCode) {
        hmGameState.get(currentState).keyReleased(keyCode);
    }

    public void keyTyped(int keyCode) {
        hmGameState.get(currentState).keyTyped(keyCode);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public Object removeAttribute(String name) {
        return attributes.remove(name);
    }

    public void setAttribute(String name, Object attribute) {
        attributes.put(name, attribute);
    }

    public Set<String> getAttributeNames() {
        return attributes.keySet();
    }
    
    public void replaceAttribute(String name, Object oldAttribute, Object newAttribute){
        attributes.replace(name, oldAttribute, newAttribute);
    }
    
    public void replaceAttribute(String name, Object attribute){
        attributes.replace(name, attribute);
    }
}
