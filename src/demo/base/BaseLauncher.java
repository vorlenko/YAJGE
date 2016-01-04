/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.base;

import java.awt.EventQueue;
import javafx.application.Application;
import yajge.framework.windows.GamePanel;
import yajge.framework.windows.MainWindow;

/**
 *
 * @author bob
 */
public class BaseLauncher {
    public static void main(String[] args){
        //MainWindow mainWindow = new MainWindow("Demo Frame", new GamePanel());
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mw = new MainWindow("Demo Frame", new GamePanel());
                mw.setVisible(true);
            }
        });
    }
}
