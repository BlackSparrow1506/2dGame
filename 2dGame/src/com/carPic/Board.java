/*
 * Creation : 29 Sep 2022
 */
package com.carPic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

    private Image porsche;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        loadImage();
//      We get an Image out of the ImageIcon.
        int w = porsche.getWidth(this);
        int h = porsche.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadImage() {
        // We pain an image of a jeep car on the board. The image is drawn inside the paintComponent() method.
        ImageIcon ii = new ImageIcon("E:\\EclipseDev\\2dGame\\2dGame\\resource\\img\\porsche-8182100_1280.jpg");
        // We create an ImageIcon
        porsche = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {

//      We get an Image out of the ImageIcon.
        g.drawImage(porsche, 0, 0, null);
    }
}