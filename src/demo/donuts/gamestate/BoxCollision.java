/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.donuts.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import yajge.framework.gamestate.GameState;
import yajge.framework.gamestate.GameStateManager;
import yajge.framework.physics.Collision;
import yajge.framework.utils.geometry.Box;

/**
 *
 * @author bob
 */
public class BoxCollision extends GameState {

    private Box box1;
    private Box box2;

    public BoxCollision(GameStateManager gsm) {
        super(gsm);
        init();
    }

    @Override
    public void init() {
        box1 = new Box(10, 10, 50, 50);
        box2 = new Box(100, 100, 50, 50);
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

        g.setColor(Color.red);
        box1.render(g);
        if (Collision.intersects(box1, box2)) {
            g.setColor(Color.BLUE);
        }
        box2.render(g);
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_LEFT){
            box1.getPos().setX(box1.getPos().getX()-1);
        }
        if(k == KeyEvent.VK_RIGHT){
            box1.getPos().setX(box1.getPos().getX()+1);
        }
        if(k == KeyEvent.VK_UP){
            box1.getPos().setY(box1.getPos().getY()-1);
        }
        if(k == KeyEvent.VK_DOWN){
            box1.getPos().setY(box1.getPos().getY()+1);
        }
    }

    @Override
    public void keyReleased(int k) {
    }

    @Override
    public void keyTyped(int k) {
    }

}
