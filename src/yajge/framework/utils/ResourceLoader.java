/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author bob
 */
public class ResourceLoader {

    public static InputStream load(Class<?> clazz, String filePath,
            String resPath) {
        // try the resource first
        InputStream in = null;
        if (!(resPath == null || resPath.isEmpty())) {
            in = clazz.getResourceAsStream(resPath);
        }
        if (in == null) {
            // try the file path
            try {
                in = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return in;
    }
    
    public static BufferedImage loadSprite(Class<?> clazz, String path) {
		InputStream stream = ResourceLoader.load(
			clazz, path, path
		);
		try {
			return ImageIO.read(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    public static BufferedImage loadSprite(Class<?> clazz, String path, boolean transparent){
        BufferedImage image = loadSprite(clazz, path);
        
        if (!transparent) {
            image = Graphics.makeColorTransparent(
                    image,
                    new Color(image.getRGB(0, 0)));
        }
        return image;
    }
}
