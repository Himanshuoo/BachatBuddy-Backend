package com.Mystartup.BacahatBuddy.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupBuyingProductDTO {

    private Long id;
    private String productName;
    private String productImage;
    private Double originalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(Double groupPrice) {
        this.groupPrice = groupPrice;
    }

    public Integer getTotalNeeded() {
        return totalNeeded;
    }

    public void setTotalNeeded(Integer totalNeeded) {
        this.totalNeeded = totalNeeded;
    }

    public Integer getCurrentJoined() {
        return currentJoined;
    }

    public void setCurrentJoined(Integer currentJoined) {
        this.currentJoined = currentJoined;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public Boolean getGroupComplete() {
        return isGroupComplete;
    }

    public void setGroupComplete(Boolean groupComplete) {
        isGroupComplete = groupComplete;
    }

    public Boolean getHasUserJoined() {
        return hasUserJoined;
    }

    public void setHasUserJoined(Boolean hasUserJoined) {
        this.hasUserJoined = hasUserJoined;
    }

    private Double groupPrice;
    private Integer totalNeeded;
    private Integer currentJoined;
    private String category;
    private String description;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    // Calculated fields
    private Double progressPercentage;
    private Boolean isGroupComplete;
    private Boolean hasUserJoined;

    // Convenience method to calculate savings
    public Double getSavingsAmount() {
        if (originalPrice != null && groupPrice != null) {
            return originalPrice - groupPrice;
        }
        return 0.0;
    }

    public Double getSavingsPercentage() {
        if (originalPrice != null && originalPrice > 0 && groupPrice != null) {
            return ((originalPrice - groupPrice) / originalPrice) * 100.0;
        }
        return 0.0;
    }
}
