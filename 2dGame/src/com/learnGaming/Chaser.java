package com.learnGaming;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Chaser {
    private BufferedImage image;
    private Point pos;
    private static final int STEP_SIZE = 1; // Number of tiles to move per tick

    public Chaser(int x, int y) {
        loadImage();
        pos = new Point(x, y);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("E:\\EclipseDev\\2dGame\\2dGame\\resource\\img\\police.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(image, pos.x * Boards.TILE_SIZE, pos.y * Boards.TILE_SIZE, observer);
    }

    public Point getPos() {
        return pos;
    }

    public void moveTowards(Point target) {
        // Move in the direction of the target, but only one step per update
        if (pos.x < target.x) pos.x += STEP_SIZE;
        if (pos.x > target.x) pos.x -= STEP_SIZE;
        if (pos.y < target.y) pos.y += STEP_SIZE;
        if (pos.y > target.y) pos.y -= STEP_SIZE;
        
        if (pos.x < target.y) pos.x += STEP_SIZE;
        if (pos.x > target.y) pos.x -= STEP_SIZE;
        if (pos.y < target.x) pos.y += STEP_SIZE;
        if (pos.y > target.x) pos.y -= STEP_SIZE;
        
        
        // Ensure the Chaser stays within board bounds
        if (pos.x < 1) pos.x = 1;
        if (pos.x >= Boards.COLUMNS) pos.x = Boards.COLUMNS - 1;
        if (pos.y < 2) pos.y = 10;
        if (pos.y >= Boards.ROWS) pos.y = Boards.ROWS - 1;
    }
}
