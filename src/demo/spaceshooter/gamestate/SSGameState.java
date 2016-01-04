/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spaceshooter.gamestate;

import demo.spaceshooter.entity.Alien;
import demo.spaceshooter.entity.Craft;
import demo.spaceshooter.entity.Missile;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import yajge.framework.entity.Entity;
import yajge.framework.entity.Sprite;
import yajge.framework.gamestate.GameStateManager;
import yajge.framework.physics.Collision;
import yajge.framework.utils.Graphics;
import yajge.framework.utils.ResourceLoader;
import yajge.framework.utils.TextUtility;
import yajge.framework.utils.Vector2D;
import yajge.framework.utils.geometry.Dot;

/**
 *
 * @author bob
 */
public class SSGameState extends yajge.framework.gamestate.GameState {
    
    Craft craft;
    Sprite background;
    private ArrayList<Alien> aliens;
    private boolean ingame;
    private Font fpsFont;
    
    private final int[][] pos = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };
    
    public SSGameState(GameStateManager gsm) {
        super(gsm);
        init();
    }
    
    @Override
    public void init() {
        ingame = true;
        initAliens();
        craft = new Craft(40, 60, (BufferedImage) gsm.getAttribute("CRAFT_IMG"));
        background = new Sprite((int) gsm.getAttribute("WIDTH") / 2,
                (int) gsm.getAttribute("HEIGHT") / 2,
                (BufferedImage) gsm.getAttribute("Background1"));
        background.debug = false;
        
        fpsFont = new Font(
                "Arial",
                Font.PLAIN,
                10);
    }
    
    public void initAliens() {
        aliens = new ArrayList<>();
        
        for (int[] p : pos) {
            aliens.add(new Alien(p[0], p[1],
                    (BufferedImage) gsm.getAttribute("ALIEN_IMG")));
        }
    }
    
    @Override
    public void update() {
        /**
         * *
         * Update Craft position
         */
        craft.move();
        checkCraftPos();
        /**
         * *
         * Update Missiles position and counts
         */
        ArrayList<Missile> ms = craft.getMissiles();
        
        for (int i = 0; i < ms.size(); i++) {
            
            Missile m = ms.get(i);
            
            if (m.isVisible()) {
                
                m.move();
            } else {
                
                ms.remove(i);
            }
        }
        
        for (Alien al : aliens) {
            if (al.getPos().getX() < -1) {
                al.getPos().setX((int) gsm.getAttribute("WIDTH"));
            }
            if (al.isVisible()) {
                al.move();
            } else {
                aliens.remove(al);
                if (aliens.size() == 0) {
                    ingame = false;
                }
            }
        }
        
        checkCollision();
    }
    
    @Override
    public void draw(Graphics2D g) {
        //Draw Background
        background.draw(g);
        if (ingame) {
            //Draw Craft
            craft.draw(g);
            
            ArrayList<Missile> ms = craft.getMissiles();
            
            for (Missile m1 : ms) {
                
                if (m1.isVisible()) {
                    m1.draw(g);
                }
            }
            
            for (Alien al : aliens) {
                if (al.isVisible()) {
                    al.draw(g);
                }
            }
            
            drawMoc(g);
        } else {
            
            if (aliens.size() > 0) {
                drawGameOver(g);
            } else {
                drawYouWin(g);
            }
        }
    }
    
    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_SPACE) {
            if (ingame) {
                craft.fire((BufferedImage) gsm.getAttribute("MISSILE_IMG"),
                        (int) gsm.getAttribute("WIDTH"));
            } else {
                gsm.setState("MENUSTATE");
            }
        }
        
        if (key == KeyEvent.VK_LEFT) {
            craft.getDv().setX(-1);
        }
        if (key == KeyEvent.VK_RIGHT) {
            craft.getDv().setX(1);
        }
        if (key == KeyEvent.VK_UP) {
            craft.getDv().setY(-1);
        }
        if (key == KeyEvent.VK_DOWN) {
            craft.getDv().setY(1);
        }
    }
    
    @Override
    public void keyReleased(int key) {
        
        if (key == KeyEvent.VK_LEFT) {
            craft.getDv().setX(0);
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            craft.getDv().setX(0);
        }
        
        if (key == KeyEvent.VK_UP) {
            craft.getDv().setY(0);
        }
        
        if (key == KeyEvent.VK_DOWN) {
            craft.getDv().setY(0);
        }
        
    }
    
    @Override
    public void keyTyped(int k) {
        
    }
    
    private void checkCollision() {
        for (Alien alien : aliens) {
            
            if (Collision.intersects(craft.getBox(), alien.getBox())) {
                craft.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }
        
        ArrayList<Missile> ms = craft.getMissiles();
        
        for (Missile m : ms) {
            
            for (Alien alien : aliens) {
                
                if (Collision.intersects(m.getBox(), alien.getBox())) {
                    m.setVisible(false);
                    alien.setVisible(false);
                }
            }
        }
    }
    
    private void drawMoc(Graphics2D g) {
        try {
            g.setColor(Color.gray);
            g.setFont(fpsFont);
            TextUtility.drawString(g, 20, 20, Integer.toString(aliens.size()));
        } catch (Exception e) {
        }
    }
    
    private void drawGameOver(Graphics2D g) {
        g.setColor(Color.red);
        TextUtility.drawCenteredString(g,
                (int) gsm.getAttribute("WIDTH"),
                (int) gsm.getAttribute("HEIGHT") / 2, "GAME OVER");
    }
    
    private void drawYouWin(Graphics2D g) {
        g.setColor(Color.red);
        TextUtility.drawCenteredString(g,
                (int) gsm.getAttribute("WIDTH"),
                (int) gsm.getAttribute("HEIGHT") / 2, "YOU WIN");
    }
    
    private void checkCraftPos() {
        if (craft.getBox().getX() < 0) {
            craft.setPos(craft.getPos().add(new Vector2D(1, 0)));
        }
        if (craft.getBox().getX() + craft.getBox().getWidth() 
                >= (int)gsm.getAttribute("WIDTH")) {
            craft.setPos(craft.getPos().add(new Vector2D(-1, 0)));
        }
        if (craft.getBox().getY() < 0) {
            craft.setPos(craft.getPos().add(new Vector2D(0, 1)));
        }
        if (craft.getBox().getY() + craft.getBox().getHeight()
                >= (int)gsm.getAttribute("HEIGHT")) {
            craft.setPos(craft.getPos().add(new Vector2D(0, -1)));
        }
    }
}
