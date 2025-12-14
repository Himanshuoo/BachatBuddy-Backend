package com.Mystartup.BacahatBuddy.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinGroupRequestDTO {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupBuyingProductId() {
        return groupBuyingProductId;
    }

    public void setGroupBuyingProductId(Long groupBuyingProductId) {
        this.groupBuyingProductId = groupBuyingProductId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private Long groupBuyingProductId;
    private Integer quantity = 1;
}
