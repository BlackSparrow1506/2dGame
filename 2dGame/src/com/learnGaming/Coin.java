/*
 * Creation : 29 Sep 2022
 */
package com.learnGaming;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Coin {
    // image that represents the coin's position on the board
    private BufferedImage image;
    // current position of the coin on the board grid
    private Point pos;

    public Coin(int x, int y) {
        // load the assets
        loadImage();

        // initialize the state
        pos = new Point(x, y);
    }

    private void loadImage() {
        try {
            // to provide the file path.
            image = ImageIO.read(new File("E:\\EclipseDev\\2dGame\\2dGame\\resource\\img\\gold.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        // with the Point class, note that pos.getX() returns a double, but
        // pos.x reliably returns an int. https://stackoverflow.com/a/30220114/4655368
        // this is also where we translate board grid position into a canvas pixel
        // position by multiplying by the tile size.
        g.drawImage(image, pos.x * Boards.TILE_SIZE, pos.y * Boards.TILE_SIZE, observer);
    }

    public Point getPos() {
        return pos;
    }

    public static void removeAll(ArrayList collectedCoins) {
        // TODO Auto-generated method stub

    }

}