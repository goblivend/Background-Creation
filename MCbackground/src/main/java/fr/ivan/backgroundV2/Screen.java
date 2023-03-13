package fr.ivan.backgroundV2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Screen {

    Random rd;
    int imgSize;
    int sizeX;
    int sizeY;

    Gradient[] gradient;

    public Screen(Random rd, int imageSize, int sizeX, int sizeY, Gradient[] gradient){
        this.rd = rd;
        this.imgSize = imageSize;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.gradient = gradient;

        if (gradient.length == 0)
            throw new RuntimeException("Screen.Screen(): gradient : Need at least one gradient");
    }


    public BufferedImage build(){
        BufferedImage bg = new BufferedImage(sizeX * imgSize, sizeY * imgSize, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                copyImage(bg, getGradient(sizeY - y - 1).getItem(rd, sizeY - y - 1).getImg(), x, y);
            }
        }
        return bg;
    }

    Gradient getGradient(int y){
        return Arrays.stream(gradient).filter(g -> g.IsConcerned(y)).findFirst().orElseThrow();
    }

    void copyImage(BufferedImage image, BufferedImage toCopy, int x, int y) {
        for (int ix = 0; ix < imgSize; ix++) {
            for (int iy = 0; iy < imgSize; iy++) {
                image.setRGB(imgSize * x + ix, imgSize * y + iy, toCopy.getRGB(ix, iy));
            }
        }
    }
}
