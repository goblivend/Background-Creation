package fr.ivan.backgroundV2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public enum Item {
    BEDROCK("bedrock"),
    BLACK_WOOL("black_wool"),
    CHISELED_STONE_BRICKS("chiseled_stone_bricks"),
    CRACKED_DEEPSLATE_TILES("cracked_deepslate_tiles"),
    CRACKED_STONE_BRICKS("cracked_stone_bricks"),
    DEEPSLATE("deepslate"),
    DEEPSLATE_TILES("deepslate_tiles"),
    DIRT("dirt"),
    GRAY_WOOL("gray_wool"),
    MOSSY_STONE_BRICKS("mossy_stone_bricks"),
    STONE("stone"),
    STONE_BRICKS("stone_bricks"),
    WHITE_WOOL("white_wool"),
    ;

    String name;
    BufferedImage img;
    Item(String name)
    {
        this.name= name;
        try {
            this.img = ImageIO.read(getClass().getClassLoader().getResource(this.toString()));
        } catch (Exception e) {
            throw new RuntimeException(e + " Image not found " + this);
        }
    }

    @Override
    public String toString() {
        return "images/" + name + ".png";
    }

    public BufferedImage getImg() {
        return img;
    }
}
