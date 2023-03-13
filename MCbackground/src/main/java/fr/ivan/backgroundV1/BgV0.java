package fr.ivan.backgroundV1;

import java.awt.image.*;
import java.util.Random;

public class BgV0 {
    int sizeX;
    int sizeY;
    Item[] images;

    public BgV0(int sizeX, int sizeY, Item[] images){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.images = images;
        var height = images[0].getImg().getHeight();
        var width = images[0].getImg().getWidth();
        for (var img: images) {
            if (img.getImg().getHeight() != height || img.getImg().getWidth() != width)
                throw new RuntimeException("Bg.Bg(): Invalid size not coherent");
        }
    }

    public BufferedImage build(){
        Random rd = new Random();
        BufferedImage bg = new BufferedImage(sizeX * images[0].getImg().getWidth(), sizeY * images[0].getImg().getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                copyImage(bg, getIndex(rd, x, y), x, y);
            }
        }
        return bg;
    }

    int getIndex(Random rd, int x, int y) {
        int total = 0;
        for (Item image : images) {
            total += image.getRd(x, y);
        }

        int nb = rd.nextInt(total);
        for (int i = 0; i < images.length; i++) {
            if (nb < images[i].getRd(x, y))
                return i;
            nb -= images[i].getRd(x, y);
        }
        return images.length-1;
    }

    void copyImage(BufferedImage bg, int idx, int x, int y) {
        for (int ix = 0; ix < images[idx].getImg().getWidth(); ix++) {
            for (int iy = 0; iy < images[idx].getImg().getHeight(); iy++) {
                bg.setRGB(images[0].getImg().getWidth()*x + ix, images[0].getImg().getHeight()*y + iy, images[idx].getImg().getRGB(ix, iy));
            }
        }
    }


}
