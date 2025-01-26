package francisco.personal.productmicroservice.repositories;

import francisco.personal.productmicroservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT p FROM Product p " +
            "WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) ")
    List<Product> findByFilters(@Param("name") String name);
}
