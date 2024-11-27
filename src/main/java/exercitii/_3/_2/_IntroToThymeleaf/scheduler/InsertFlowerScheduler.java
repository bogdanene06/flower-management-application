/*
Author: Ene Bogdan
Country: Romania
*/
package exercitii._3._2._IntroToThymeleaf.scheduler;

import com.github.javafaker.Faker;
import exercitii._3._2._IntroToThymeleaf.entity.Flower;
import exercitii._3._2._IntroToThymeleaf.repository.FlowerRepository;
import exercitii._3._2._IntroToThymeleaf.utils.FlowerNameGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Log
public class InsertFlowerScheduler {

    @Autowired
    private FlowerRepository flowerRepository;

    @Scheduled(cron = "0/10 * * * * *")
    public void insertFlowerIntoDatabase() {
        Faker faker = new Faker();
        Flower flower = new Flower();
        FlowerNameGenerator generator = new FlowerNameGenerator();
        String flowerName = generator.generateFlowerName();
        flower.setName(flowerName);
        flower.setColor(faker.color().name());
        flower.setPrice((float) faker.number().numberBetween(1, 100));
        log.info("Insert flower: " + flower);
        flowerRepository.save(flower);
    }


}
