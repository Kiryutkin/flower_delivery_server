package flower_delivery_server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "block_orders")
public class BlockOrders {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "deliveryType")
    private String deliveryType;

    @Column(name = "executorID")
    private long executorID;

    @OneToMany(mappedBy = "blockOrders", fetch = FetchType.EAGER)
    private List<Order> orderList;

    public BlockOrders() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public long getExecutorID() {
        return executorID;
    }

    public void setExecutorID(long executorID) {
        this.executorID = executorID;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
