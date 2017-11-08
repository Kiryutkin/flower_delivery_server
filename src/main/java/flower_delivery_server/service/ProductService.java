package flower_delivery_server.service;

import flower_delivery_server.entity.Order;
import flower_delivery_server.entity.Product;

import java.util.List;

public interface ProductService {
    Product getByID(long id);
//    List<Product> getByOrderID(Order orderID);
    Product save(Product product);
}
