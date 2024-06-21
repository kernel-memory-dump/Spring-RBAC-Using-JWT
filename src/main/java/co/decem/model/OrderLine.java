package co.decem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderline")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Order order;
    @OneToOne
    private Product product;
    private Long quantity;
    private Long price;

    @Override
    public String toString() {
        return "OrderLine id=" + id + ", quantity=" + quantity + ", price=" + price + ", order id=" + order.getId() + ", order sale date=" + order.getSalesDate() + ", order total ammount=" + order.getTotalAmmount() + ", product name=" + product.getName() + ", product quantity=" + product.getQuantity() + ", product description=" + product.getDescription()+ ", product price=" + product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
