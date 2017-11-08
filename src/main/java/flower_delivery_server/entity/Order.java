package flower_delivery_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "initiatorID")
    private long initiatorID;

    @Column(name = "deliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    @Column(name = "warehouseAddress")
    private String warehouseAddress;

    @Column(name = "status")
    private String status;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<Product> productList;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "blockOrders_id")
    private BlockOrders blockOrders;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getInitiatorID() {
        return initiatorID;
    }

    public void setInitiatorID(long initiatorID) {
        this.initiatorID = initiatorID;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BlockOrders getBlockOrders() {
        return blockOrders;
    }

    public void setBlockOrders(BlockOrders blockOrders) {
        this.blockOrders = blockOrders;
    }
}
