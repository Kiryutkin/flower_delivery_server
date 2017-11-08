package flower_delivery_server.service;

import flower_delivery_server.entity.BlockOrders;
import flower_delivery_server.entity.Order;

import java.util.List;

public interface OrderService {
    Order getByID(long id);
//    List<Order> getListByBlock (BlockOrders block);
    Order save(Order order);
}
