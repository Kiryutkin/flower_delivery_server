package flower_delivery_server.repository;

import flower_delivery_server.entity.Order;
import flower_delivery_server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("select b from Product b where b.order = :order")
//    List<Product> findProductsByOrderID(@Param("order") Order order);
}
