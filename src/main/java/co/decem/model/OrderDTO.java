package co.decem.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private int salesDate;
    private int totalAmmount;
    private PaymentMethod paymentMethod;
    private List<OrderLineDTO> orderLines;
}
