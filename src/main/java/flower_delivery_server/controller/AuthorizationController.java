package flower_delivery_server.controller;


import flower_delivery_server.entity.Order;
import flower_delivery_server.entity.Product;
import flower_delivery_server.entity.User;
import flower_delivery_server.service.AuthorizationService;
import flower_delivery_server.service.OrderService;
import flower_delivery_server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User createUser(@RequestHeader(value="token") String token) throws GeneralSecurityException, IOException {

        return authorizationService.createUserByToken(token);
    }

//, produces={"application/json"}

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces={"application/json"})
    @ResponseBody
    public Order getOrder(@PathVariable("id") long orderID){
        return orderService.getByID(orderID);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces={"application/json"})
    @ResponseBody
    public Product getProduct(@PathVariable("id") long productID){
        return productService.getByID(productID);
    }
}
