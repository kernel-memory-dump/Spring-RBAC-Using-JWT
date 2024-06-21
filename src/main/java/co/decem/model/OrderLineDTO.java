package co.decem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineDTO {
    private Long id;
    private Long quantity;
    private Long price;
    private ProductDTO product;
}
