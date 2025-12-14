package com.Mystartup.BacahatBuddy.DTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderRequestDTO {
    private BigDecimal totalAmount;
    private String status;          // optional, you can default to "Pending" on server
    private Long addressId;         // which saved address user selected
    private List<OrderItemDTO> items;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    // getters and setters
}