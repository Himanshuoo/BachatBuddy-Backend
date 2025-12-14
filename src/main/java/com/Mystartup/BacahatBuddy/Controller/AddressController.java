package com.Mystartup.BacahatBuddy.Controller;

import com.Mystartup.BacahatBuddy.DTO.AddressRequestDTO;
import com.Mystartup.BacahatBuddy.DTO.AddressResponseDTO;
import com.Mystartup.BacahatBuddy.Service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(
        originPatterns = "*",
        allowCredentials = "true"
)

public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // GET /api/users/{userId}/addresses
    @GetMapping("/users/{userId}/addresses")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(addressService.getAddressesByUser(userId));
    }

    // POST /api/users/{userId}/addresses
    @PostMapping("/users/{userId}/addresses")
    public ResponseEntity<AddressResponseDTO> addAddress(@PathVariable Long userId,
                                                         @Valid @RequestBody AddressRequestDTO dto) {
        AddressResponseDTO created = addressService.addAddress(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT /api/addresses/{id}
    @PutMapping("/addresses/{id}")
    public ResponseEntity<AddressResponseDTO> updateAddress(@PathVariable Long id,
                                                            @Valid @RequestBody AddressRequestDTO dto) {
        AddressResponseDTO updated = addressService.updateAddress(id, dto);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/addresses/{id}
    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}