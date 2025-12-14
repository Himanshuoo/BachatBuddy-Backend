package com.Mystartup.BacahatBuddy.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JoinGroupResponseDTO {

    private Boolean success;
    private String message;
    private Integer currentJoined;
    private Integer totalNeeded;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCurrentJoined() {
        return currentJoined;
    }

    public void setCurrentJoined(Integer currentJoined) {
        this.currentJoined = currentJoined;
    }

    public Integer getTotalNeeded() {
        return totalNeeded;
    }

    public void setTotalNeeded(Integer totalNeeded) {
        this.totalNeeded = totalNeeded;
    }

    public Boolean getGroupComplete() {
        return isGroupComplete;
    }

    public void setGroupComplete(Boolean groupComplete) {
        isGroupComplete = groupComplete;
    }

    public Double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    private Boolean isGroupComplete;
    private Double progressPercentage;
}
