package exercitii._3._2._IntroToThymeleaf.repository;

import exercitii._3._2._IntroToThymeleaf.entity.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FlowerRepository extends JpaRepository<Flower, Integer> {

    @Query(value = """
            SELECT * FROM Flower f WHERE
             (f.name LIKE %:keyword% OR
             f.color LIKE %:keyword% OR
             f.price LIKE %:keyword%)
            """,
            nativeQuery = true)
    Page<Flower> findFlowerByKeyword(String keyword, Pageable pageable);


}
