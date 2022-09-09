import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.*;


class ColorGradient {
    public static void main(String[] args) {
        // createGradient(512, 512, "./createGradient.png");
        AllColors();
    }

    public static void createGradient(int width, int height, String filename) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        GradientPaint gradient = new GradientPaint(0, 0, Color.RED, width, height, Color.BLUE);
        graphics.setPaint(gradient);
        graphics.fillRect(0, 0, width, height);
        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void AllColors(){
        int color = 0;
        int nb = 0;
        int delta = 0;

        int width = 1<<12;
        BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
        while (nb < 1<<10) {
            int line = nb % width;
            int col = nb / width;
            image.setRGB(line, col, color);
            if (nb % (9) == 0) {
                System.out.println("nb: " + nb + "\tline: " + line + "\t col: " + col + "\t Color: " + color + " ("+ ((color >> 16) & 255) +", "+ ((color >> 8)
                        & 255)+", "+ ((color >> 0) & 255)+")\t done");
            }
            color += 1<<delta;
            delta = (delta + 8) % 24;
            nb++;
        }
        System.out.println("nb: " + nb + "\t Color: " + color + "\t Delta: " + delta + "\t 1<<Delta: " + (1 << delta) + "\t done");

        try {
            ImageIO.write(image, "png", new File("AllColors.png"));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void RedGreenYellowGradient() {
        int width = 256;
        int height = 256;
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = x;
                int g = y;
                int b = 0;
                int a = 255;
                int argb = (a << 24) | (r << 16) | (g << 8) | b;
                pixels[y * width + x] = argb;
            }
        }
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image.setRGB(0, 0, width, height, pixels, 0, width);
        try {
            ImageIO.write(image, "png", new File("ColorGradient.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}