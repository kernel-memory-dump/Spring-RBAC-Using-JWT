package co.decem.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;





@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int salesDate;
    private int totalAmmount;
    @ManyToOne
    private PaymentMethod paymentMethod;
    @OneToMany
    private List<OrderLine> orderLines;

    @Override
    public String toString() {
        return "Order [id=" + id + ", salesDate=" + salesDate + ", totalAmmount=" + totalAmmount + ", paymentMethod="
                + paymentMethod + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(int salesDate) {
        this.salesDate = salesDate;
    }

    public int getTotalAmmount() {
        return totalAmmount;
    }

    public void setTotalAmmount(int totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

}
