package flower_delivery_server.service;

import flower_delivery_server.entity.Order;
import flower_delivery_server.entity.Product;
import flower_delivery_server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getByID(long id) {
        return productRepository.findOne(id);
    }

//    @Override
//    public List<Product> getByOrderID(Order orderID) {
//        System.out.println("XXXXXXXXXXXXXXXXX");
//        System.out.println("OrderID = " + orderID.getId());
//        System.out.println("Product1 = "+productRepository.findProductsByOrderID(orderID).get(1).getId());
//        System.out.println("XXXXXXXXXXXXXXXXX");
//        return productRepository.findProductsByOrderID(orderID);
//    }

    @Override
    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
    }
}
