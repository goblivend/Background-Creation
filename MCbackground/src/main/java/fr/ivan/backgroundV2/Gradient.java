package fr.ivan.backgroundV2;

import java.util.Random;

public class Gradient {
    Item[] items;
    int[] values;


    int minY;
    int maxY;

    public Gradient(Item[] items, int[] values) {
        this.items = items;
        this.values = values;
        this.minY = Integer.MIN_VALUE;
        this.maxY = Integer.MAX_VALUE;
        if (values.length != items.length)
            throw new RuntimeException("Gradient.Gradient(): Items and Values different sizes");
        if(values.length == 0)
            throw new RuntimeException("Gradient.Gradient(): Empty Items and Values");
    }

    public Gradient(Item[] items, int[] values, int maxY) {
        this.items = items;
        this.values = values;
        this.minY = Integer.MIN_VALUE;
        this.maxY = maxY;
        if (values.length != items.length)
            throw new RuntimeException("Gradient.Gradient(): Items and Values different sizes");
        if(values.length == 0)
            throw new RuntimeException("Gradient.Gradient(): Empty Items and Values");
    }

    public Gradient(Item[] items, int[] values, int minY, int maxY) {
        this.items = items;
        this.values = values;
        this.minY = minY;
        this.maxY = maxY;
        if (values.length != items.length)
            throw new RuntimeException("Gradient.Gradient(): Items and Values different sizes");
        if(values.length == 0)
            throw new RuntimeException("Gradient.Gradient(): Empty Items and Values");
    }

    public boolean IsConcerned(int y){
        return minY <= y && y < maxY;
    }

    public Item getItem(Random rd, int y){
        int total = 0;
        for (int i : values) {
            total += i;
        }

        int nb = rd.nextInt(total);
        for (int i = 0; i < values.length; i++) {
            if (nb < values[i])
                return items[i];
            nb -= values[i];
        }
        return items[values.length-1];
    }
}
