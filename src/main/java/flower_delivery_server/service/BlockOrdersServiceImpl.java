package flower_delivery_server.service;

import flower_delivery_server.entity.BlockOrders;
import flower_delivery_server.entity.Order;
import flower_delivery_server.entity.Product;
import flower_delivery_server.repository.BlockOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlockOrdersServiceImpl implements BlockOrdersService {
    @Autowired
    private BlockOrdersRepository blockOrdersRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Override
    public BlockOrders getByID(long id) {
        BlockOrders block = blockOrdersRepository.findOne(id);
        return block;
    }

    @Override
    public List<BlockOrders> getAll() {
        return blockOrdersRepository.findAll();
    }

    @Override
    public BlockOrders save(BlockOrders blockOrders) {
        List<Product> productList;
        List<Order> orderList;

        orderList = blockOrders.getOrderList();
        BlockOrders block = blockOrdersRepository.saveAndFlush(blockOrders);

        for(Order o: orderList){
            o.setBlockOrders(block);
            o = orderService.save(o);
            productList = o.getProductList();
            for(Product p : productList){
                p.setOrder(o);
                p = productService.save(p);
            }
            o.setProductList(productList);
        }

        block.setOrderList(orderList);
        return block;
    }

    @Override
    public void remove(long id) {
        blockOrdersRepository.delete(id);
    }
}
