package flower_delivery_server.service;

import flower_delivery_server.entity.BlockOrders;
import flower_delivery_server.entity.Order;
import flower_delivery_server.entity.Product;
import flower_delivery_server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;

    @Override
    public Order getByID(long id) {
        Order order = orderRepository.findOne(id);
        //List<Product> productList = productService.getByOrderID(order);
        //order.setProductList(productList);
        return order;
    }

//    @Override
//    public List<Order> getListByBlock(BlockOrders block) {
//        List<Order> orders = orderRepository.findOrderByBlock(block);
//        for(Order o : orders){
//            o.setProductList(productService.getByOrderID(o));
//        }
//        return orders;
//    }

    @Override
    public Order save(Order order) {
        return orderRepository.saveAndFlush(order);
    }
}
