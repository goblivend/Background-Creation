package fr.ivan;

import fr.ivan.backgroundV2.Gradient;
import fr.ivan.backgroundV2.Item;
import fr.ivan.backgroundV2.Screen;

import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Random rd = new Random();

//        Screen deepslate = new Screen(rd, 64, 16, 9,
//                new Gradient[]{
//                        new Gradient(new Item[]{Item.DEEPSLATE_TILES, Item.CRACKED_DEEPSLATE_TILES}, new int[]{1, 1}, 0, 9),
//                });
//        var img = deepslate.build();

//        Screen stone = new Screen(rd, 64, 16, 9,
//                new Gradient[]{
//                        new Gradient(new Item[]{Item.STONE_BRICKS, Item.CRACKED_STONE_BRICKS, Item.MOSSY_STONE_BRICKS}, new int[]{1, 1, 1}, 0, 9),
//                });
//        var img = stone.build();

        int stoneMaxLevel = 60;
        int stoneMinLevel = 30;

        Screen wool = new Screen(rd, 64, 128, 72,
                new Gradient[]{
                        new Gradient(new Item[]{Item.BEDROCK}, new int[]{1}, 1),
                        new Gradient(new Item[]{Item.BEDROCK, Item.DEEPSLATE}, new int[]{9, 2}, 2),
                        new Gradient(new Item[]{Item.BEDROCK, Item.DEEPSLATE}, new int[]{9, 9}, 3),
                        new Gradient(new Item[]{Item.BEDROCK, Item.DEEPSLATE}, new int[]{6, 9}, 4),
                        new Gradient(new Item[]{Item.BEDROCK, Item.DEEPSLATE}, new int[]{5, 9}, 5),
                        new Gradient(new Item[]{Item.DEEPSLATE}, new int[]{1},  stoneMinLevel - 10),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{9, 1}, stoneMinLevel - 9),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{9, 2}, stoneMinLevel - 8),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{9, 4}, stoneMinLevel - 7),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{9, 6}, stoneMinLevel - 6),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{9, 9}, stoneMinLevel - 5),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{6, 9}, stoneMinLevel - 4),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{4, 9}, stoneMinLevel - 3),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{2, 9}, stoneMinLevel - 2),
                        new Gradient(new Item[]{Item.DEEPSLATE, Item.STONE}, new int[]{1, 9}, stoneMinLevel - 1),
                        new Gradient(new Item[]{Item.STONE}, new int[]{1}, stoneMaxLevel),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{9, 1}, stoneMaxLevel + 1),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{9, 2}, stoneMaxLevel + 2),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{9, 4}, stoneMaxLevel + 3),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{9, 6}, stoneMaxLevel + 4),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{9, 9}, stoneMaxLevel + 5),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{6, 9}, stoneMaxLevel + 6),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{4, 9}, stoneMaxLevel + 7),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{2, 9}, stoneMaxLevel + 8),
                        new Gradient(new Item[]{Item.STONE, Item.DIRT}, new int[]{1, 9}, stoneMaxLevel + 9),
                        new Gradient(new Item[]{Item.DIRT}, new int[]{1}),
                });

        var img = wool.build();

        try {
            ImageIO.write(img, "png", new File("output.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Map<String, Integer> gradient = new HashMap<>();
        System.out.println(gradient.get("tete"));

    }
}