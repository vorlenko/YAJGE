/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.windows;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import yajge.framework.gamestate.GameStateManager;
//import yajge.framework.gamestate.GameStates;
import yajge.framework.utils.clock.BaseClock;
import yajge.framework.utils.clock.NanoClock;

/**
 * The GamePanel class base for Game loop.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {

    // dimensions
    /**
     * *
     * GamePanel Width
     */
    public static int WIDTH;
    /**
     * *
     * GamePanel Height
     */
    public static int HEIGHT;
    /**
     * *
     * GamePanel Scale
     */
    public static int SCALE;

    // game thread
    /**
     * *
     * Thread itself
     */
    private Thread thread;
    /**
     * *
     * If is Runig?
     */
    private boolean running;
    /**
     * *
     * FPS
     */
    private int FPS;
    /**
     * *
     * target Delay;
     */
    private long targetTime;

    // image
    private BufferedImage image;
    private Graphics2D g;

    // game clock timer
    private BaseClock gameClock;

    // game state manager
    protected GameStateManager gsm;

    public GamePanel() {
        super();
        initSize();
        initFPS();
        setPreferredSize(
                new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
        
    }

    /**
     * *
     * Init size of gamePanel May be overrided
     */
    public void initSize() {
        WIDTH = 320;
        //WIDTH = 640;
        HEIGHT = 240;
        //HEIGHT = 480;
        SCALE = 2;
        //SCALE = 1;
    }

    /**
     * *
     * Init time parameters of loop
     */
    public void initFPS() {
        FPS = 60;
        targetTime = 1000 / FPS;

        gameClock = new NanoClock();
    }

    /**
     * *
     * Makes this Component displayable by connecting it to a native screen
     * resource. This method is called internally by the toolkit and should not
     * be called directly by programs. Called when added to Parent Component.
     *
     * @see run() method
     */
    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    /**
     * *
     * Init Graphics and GameStateManager.
     *
     * @see run() method
     */
    private void init() {

        /*image = new BufferedImage(
                WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB//OR BufferedImage.TYPE_INT_ARGB
        );*/
        initImage();
        
        g = (Graphics2D) image.getGraphics();

        running = true;

        initGSM();
        
        gsm.setAttribute("WIDTH", WIDTH);
        gsm.setAttribute("HEIGHT", HEIGHT);
        gsm.setAttribute("CAMERA_X1", 0);
        gsm.setAttribute("CAMERA_Y1", 0);
        gsm.setAttribute("WORLD_X1", 0);
        gsm.setAttribute("WORLD_Y1", 0);

    }
    
    protected void initImage(){
        image = new BufferedImage(
                WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB//OR BufferedImage.TYPE_INT_ARGB
        );
    }

    @Override
    public void run() {
        init();

        //long start;
        long elapsed;
        long wait;

        // game loop
        while (running) {
            gameClock.stampTime();

            // loop processes
            update();
            draw();
            drawToScreen();

            elapsed = gameClock.getElapsedTime();
            wait = targetTime - elapsed / 1000000;
            if (wait < 0) {
                wait = 5;
            }

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * Call keyTyped() method of GameStateManager
     * @see GameStateManager.keyTyped()
     */
    @Override
    public void keyTyped(KeyEvent key) {
        gsm.keyTyped(key.getKeyCode());
    }

    /***
     * Call keyPressed() method of GameStateManager
     * @see GameStateManager.keyPressed()
     */
    @Override
    public void keyPressed(KeyEvent key) {
        gsm.keyPressed(key.getKeyCode());
    }

    /***
     * Call keyReleased() method of GameStateManager
     * @see GameStateManager.keyReleased()
     */
    @Override
    public void keyReleased(KeyEvent key) {
        gsm.keyReleased(key.getKeyCode());
    }

    /***
     * Call update() method of GameStateManager
     * @see GameStateManager.update()
     */
    private void update() {
        gsm.update();
    }

    /***
     * Draw image to screen
     */
    private void drawToScreen() {
        
        Graphics g2 = getGraphics();
                /*g2.drawImage(image, 0, 0, 
                        WIDTH * SCALE, HEIGHT * SCALE, 
                        0, 0, WIDTH, HEIGHT, 
                        this);*/
                g2.drawImage(image,
                        (int)gsm.getAttribute("CAMERA_X1"),
                        (int)gsm.getAttribute("CAMERA_Y1"),
                        (int)gsm.getAttribute("CAMERA_X1") + WIDTH*SCALE,
                        (int)gsm.getAttribute("CAMERA_Y1") + HEIGHT*SCALE,
                        (int)gsm.getAttribute("WORLD_X1"),
                        (int)gsm.getAttribute("WORLD_Y1"),
                        (int)gsm.getAttribute("WORLD_X1") + WIDTH,
                        (int)gsm.getAttribute("WORLD_Y1") + HEIGHT,
                        this);
		/*g2.drawImage(image, 0, 0,
				WIDTH * SCALE, HEIGHT * SCALE,
				null);*/
		g2.dispose();}

    /***
     * Call draw() method of GameStateManager
     * @see GameStateManager.draw()
     */
    private void draw() {
        gsm.draw(g);
    }

    /***
     * initGSM here we choose which GameStateManager we will use;
     */
    protected void initGSM() {
        gsm = new GameStateManager();}

}
