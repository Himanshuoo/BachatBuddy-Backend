package com.Mystartup.BacahatBuddy.Service;

import com.Mystartup.BacahatBuddy.DTO.OrderItemDTO;
import com.Mystartup.BacahatBuddy.DTO.OrderRequestDTO;
import com.Mystartup.BacahatBuddy.DTO.OrderResponseDTO;
import com.Mystartup.BacahatBuddy.Model.Address;
import com.Mystartup.BacahatBuddy.Model.Order;
import com.Mystartup.BacahatBuddy.Model.OrderItem;
import com.Mystartup.BacahatBuddy.Model.User;
import com.Mystartup.BacahatBuddy.Repository.AddressRepository;
import com.Mystartup.BacahatBuddy.Repository.OrderRepository;
import com.Mystartup.BacahatBuddy.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository; // you already have Address entity

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        AddressRepository addressRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDTO> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public OrderResponseDTO createOrder(Long userId, OrderRequestDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Address address = null;
        if (dto.getAddressId() != null) {
            address = addressRepository.findById(dto.getAddressId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
        }

        Order order = new Order();
        order.setUser(user);
        order.setAddress(address);
        order.setTotalAmount(dto.getTotalAmount());
        order.setStatus(dto.getStatus() != null ? dto.getStatus() : "Pending");

        // Map items
        if (dto.getItems() != null) {
            List<OrderItem> items = dto.getItems().stream().map(itemDto -> {
                OrderItem item = new OrderItem();
                item.setOrder(order);
                item.setProductId(itemDto.getProductId());
                item.setProductName(itemDto.getProductName());
                item.setQuantity(itemDto.getQuantity());
                item.setPrice(itemDto.getPrice());
                return item;
            }).collect(Collectors.toList());
            order.setItems(items);
        }

        Order saved = orderRepository.save(order);
        return toResponseDTO(saved);
    }

    public OrderResponseDTO updateOrder(Long id, OrderRequestDTO dto) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));

        if (dto.getTotalAmount() != null) {
            existing.setTotalAmount(dto.getTotalAmount());
        }
        if (dto.getStatus() != null) {
            existing.setStatus(dto.getStatus());
        }
        if (dto.getAddressId() != null) {
            Address address = addressRepository.findById(dto.getAddressId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
            existing.setAddress(address);
        }

        // Optionally update items (depends on your design)
        // For now, let's keep items as is unless you want full replace logic.

        Order saved = orderRepository.save(existing);
        return toResponseDTO(saved);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
        orderRepository.deleteById(id);
    }

    private OrderResponseDTO toResponseDTO(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        dto.setDate(order.getDate());
        dto.setUserId(order.getUser() != null ? order.getUser().getId() : null);
        dto.setAddressId(order.getAddress() != null ? order.getAddress().getId() : null);

        if (order.getItems() != null) {
            List<OrderItemDTO> itemDTOs = order.getItems().stream().map(item -> {
                OrderItemDTO i = new OrderItemDTO();
                i.setProductId(item.getProductId());
                i.setProductName(item.getProductName());
                i.setQuantity(item.getQuantity());
                i.setPrice(item.getPrice());
                return i;
            }).collect(Collectors.toList());
            dto.setItems(itemDTOs);
        }

        return dto;
    }
}