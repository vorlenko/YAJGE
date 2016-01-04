/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.windows;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * The MainWindow class base for Game.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see 
 */
public class MainWindow extends JFrame{

    public MainWindow(String title, GamePanel gp) throws HeadlessException {
        super(title);
        init(gp);
    }
    
    /***
     * init Window, may be overrided.
     * @param gp - GamePanel
     */
    public void init(GamePanel gp){
        //setContentPane(new GamePanel());
        setContentPane(gp);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	pack();
	setVisible(true);
        createBufferStrategy(2);
    }
    
}
