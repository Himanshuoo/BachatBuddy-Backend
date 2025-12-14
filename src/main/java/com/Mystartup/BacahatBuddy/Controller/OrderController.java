package com.Mystartup.BacahatBuddy.Controller;

import com.Mystartup.BacahatBuddy.DTO.OrderRequestDTO;
import com.Mystartup.BacahatBuddy.DTO.OrderResponseDTO;
import com.Mystartup.BacahatBuddy.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(
        originPatterns = "*",
        allowCredentials = "true"
)

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponseDTO> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PostMapping("/user/{userId}")
    public OrderResponseDTO createOrder(@PathVariable Long userId,
                                        @Valid @RequestBody OrderRequestDTO dto) {
        return orderService.createOrder(userId, dto);
    }

    @PutMapping("/{id}")
    public OrderResponseDTO updateOrder(@PathVariable Long id,
                                        @Valid @RequestBody OrderRequestDTO dto) {
        return orderService.updateOrder(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}