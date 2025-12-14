package com.Mystartup.BacahatBuddy.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AddressRequestDTO {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;

    @NotBlank
    @Size(max = 255)
    private String line1;

    @Size(max = 255)
    private String line2;

    @NotBlank
    @Size(max = 100)
    private String city;

    @NotBlank
    @Size(max = 100)
    private String state;

    @NotBlank
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digits")
    private String pincode;

    public Boolean isDefault = false;
    private Boolean isDefaultAddress;

    public Boolean getDefaultAddress() {
        return isDefaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        isDefaultAddress = defaultAddress;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public @NotBlank @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digits") String getPincode() {
        return pincode;
    }

    public void setPincode(@NotBlank @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digits") String pincode) {
        this.pincode = pincode;
    }

    public @NotBlank @Size(max = 100) String getState() {
        return state;
    }

    public void setState(@NotBlank @Size(max = 100) String state) {
        this.state = state;
    }

    public @NotBlank @Size(max = 100) String getCity() {
        return city;
    }

    public void setCity(@NotBlank @Size(max = 100) String city) {
        this.city = city;
    }

    public @Size(max = 255) String getLine2() {
        return line2;
    }

    public void setLine2(@Size(max = 255) String line2) {
        this.line2 = line2;
    }

    public @NotBlank @Size(max = 255) String getLine1() {
        return line1;
    }

    public void setLine1(@NotBlank @Size(max = 255) String line1) {
        this.line1 = line1;
    }

    public @NotBlank @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits") String phone) {
        this.phone = phone;
    }

    public @NotBlank @Size(max = 100) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(max = 100) String name) {
        this.name = name;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }


// getters and setters
}