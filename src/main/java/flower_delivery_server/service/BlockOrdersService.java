package flower_delivery_server.service;

import flower_delivery_server.entity.BlockOrders;

import java.util.List;

public interface BlockOrdersService {

    BlockOrders getByID(long id);
    List<BlockOrders> getAll();
    BlockOrders save(BlockOrders blockOrders);
    void remove(long id);
}
