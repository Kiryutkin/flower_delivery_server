package flower_delivery_server.controller;

import flower_delivery_server.entity.BlockOrders;
import flower_delivery_server.service.BlockOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private BlockOrdersService blockOrdersService;


    @RequestMapping(value = "/blocks", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<BlockOrders> getAllBlockOrders() {
        return blockOrdersService.getAll();
    }

    @RequestMapping(value = "/blocks/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public BlockOrders getBlockOrdersByID(@PathVariable("id") long blockID) {
        return blockOrdersService.getByID(blockID);
    }

    @RequestMapping(value = "/blocks", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public BlockOrders saveBlockOrders(@RequestBody BlockOrders blockOrders){
        return blockOrdersService.save(blockOrders);
    }
}
