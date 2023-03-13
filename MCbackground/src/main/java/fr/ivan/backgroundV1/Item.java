package fr.ivan.backgroundV1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Item {
    BufferedImage img;
    String name;

    int minY;
    int maxY;
    int minX;
    int maxX;

    int rdMin;
    int rdMax;

    public Item(String path, int rdMin, int rdMax, int minY, int maxY, int minX, int maxX) {
        name = path;
        try {
            img = ImageIO.read(getClass().getClassLoader().getResource(path));
        } catch (Exception e) {
            throw new RuntimeException(e + " Image not found " + path);
        }
        this.minY = minY;
        this.maxY = maxY;
        this.minX = minX;
        this.maxX = maxX;
        this.rdMin = rdMin;
        this.rdMax = rdMax;
    }

    public Item(String path, int rdMin, int rdMax, int minY, int maxY) {
        name = path;

        try {
            img = ImageIO.read(getClass().getClassLoader().getResource(path));
        } catch (Exception e) {
            throw new RuntimeException(e + " Image not found " + path);
        }
        this.minY = minY;
        this.maxY = maxY;
        this.minX = 0;
        this.maxX = Integer.MAX_VALUE;
        this.rdMin = rdMin;
        this.rdMax = rdMax;
    }

    public BufferedImage getImg() {
        return img;
    }
    public int getRd(int x, int y){

        if (/*x < minX || maxX <= x ||*/ y < minY || maxY <= y)
            return 0;
        int curr = y - minY;// + (maxX == Integer.MAX_VALUE ? 0 : x- minX);

        int max = maxY - minY;// + (maxX == Integer.MAX_VALUE ? 0 : maxX- minX);

        int rdRange = rdMax - rdMin;
        return (int) (rdMax - rdRange * (curr * (1.0/max)));
    }

    @Override
    public String toString() {
        return name;
    }
}
