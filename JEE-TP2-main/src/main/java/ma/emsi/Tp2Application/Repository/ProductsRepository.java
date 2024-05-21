package ma.emsi.Tp2Application.Repository;

import ma.emsi.Tp2Application.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Long> {
    List<Products> findByNameContains(String mc);
    List<Products> findByPriceGreaterThan(double Price);

    @Query("select p from Products p where p.Name like :x")
    List<Products> search(@Param("x") String mc);

    @Query("select p from Products p where p.Price>:x")
    List<Products> searchByPrice(@Param("x") double Price);
}
