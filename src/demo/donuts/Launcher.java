/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.donuts;


import java.awt.EventQueue;
import yajge.framework.windows.MainWindow;
import demo.donuts.window.DonutsPanel;

/**
 *
 * @author bob
 */
public class Launcher {
    public static void main(String[] args){
        //MainWindow mainWindow = new MainWindow("Demo Frame", new GamePanel());
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mw = new MainWindow("Demo Donuts", new DonutsPanel());
                mw.setVisible(true);
            }
        });
    }
}
