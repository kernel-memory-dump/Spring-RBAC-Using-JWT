package co.decem.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.decem.dao.CartItemRepository;
import co.decem.dao.CartRepository;
import co.decem.dao.ProductRepository;
import co.decem.model.Cart;
import co.decem.model.CartDTO;
import co.decem.model.CartItem;
import co.decem.model.Product;
import co.decem.service.CartService;



@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Cart> getCartWithinTimeInterval() {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(1);
        return cartRepository.findCartWithinTimeInterval(startTime, endTime);
    }

  
    @Override
    @Transactional
    public Cart addToCart(CartDTO cartDTO) {


            Cart cart = resolveCart(cartDTO);

            cart.setTotalAmmount(0L);

            List<CartItem> cartItems = cartDTO.getCartItem().stream().map(cartItemDTO -> {
                CartItem cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setQuantity(cartItemDTO.getQuantity());
                cartItem.setPrice(cartItemDTO.getPrice());
                cart.setTotalAmmount(cart.getTotalAmmount() + cartItem.getPrice() * cartItem.getQuantity());
                    
                Product product = productRepository.findById(cartItemDTO.getProduct().getId())
                            .orElseThrow(() -> new RuntimeException("Product not found"));
                cartItem.setProduct(product);
                    
                return cartItem;
                }).collect(Collectors.toList());

            cartItemRepository.saveAll(cartItems);

            cart.setCartItem(cartItems);
            cartRepository.save(cart);

            return cart;
    }

    private Cart resolveCart(CartDTO dto){

        if(dto.getId() != null) {

            return cartRepository.findById(dto.getId()).orElse(null);
        } 
        Cart cart = new Cart();
        cart.setTotalAmmount(dto.getTotalAmmount());
        cart.setDateCreated(LocalDateTime.now());
        return cartRepository.save(cart);
    }
}