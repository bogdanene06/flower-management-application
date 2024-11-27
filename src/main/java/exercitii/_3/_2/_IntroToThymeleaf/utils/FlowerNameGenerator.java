/*
Author: Ene Bogdan
Country: Romania
*/
package exercitii._3._2._IntroToThymeleaf.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FlowerNameGenerator {

    private List<String> flowerNames;
    private Random random;

    public FlowerNameGenerator() {
        this.flowerNames = Arrays.asList(
                "Rose",
                "Tulip",
                "Daffodil",
                "Sunflower",
                "Lily",
                "Daisy",
                "Orchid",
                "Marigold",
                "Lavender",
                "Chrysanthemum"
        );
        this.random = new Random();
    }

    public String generateFlowerName() {
        int index = random.nextInt(flowerNames.size());
        return flowerNames.get(index);
    }

}
