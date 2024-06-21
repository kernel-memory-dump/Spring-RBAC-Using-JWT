package co.decem.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private Long totalAmmount;
    private LocalDateTime dateCreated;
    private List<CartItemDTO> cartItem;
    
}
