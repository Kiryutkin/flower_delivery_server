package flower_delivery_server.repository;

import flower_delivery_server.entity.BlockOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockOrdersRepository extends JpaRepository<BlockOrders, Long> {
}
