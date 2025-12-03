package com.example.teachersystem.Controller;

import com.example.teachersystem.DTO.AddressDTO;
import com.example.teachersystem.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddressDTO dto) {
        addressService.add(dto);
        return ResponseEntity.ok("Address added");
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> update(@PathVariable Integer teacherId, @Valid @RequestBody AddressDTO dto) {
        addressService.update(dto);
        return ResponseEntity.ok("Address updated");
    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> delete(@PathVariable Integer teacherId) {
        addressService.delete(teacherId);
        return ResponseEntity.ok("Address deleted");
    }
}
