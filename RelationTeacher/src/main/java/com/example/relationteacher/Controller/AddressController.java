package com.example.relationteacher.Controller;

import com.example.relationteacher.DTO.AddressDTO;
import com.example.relationteacher.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @PostMapping("/add")
    public ResponseEntity addAddressToTeacher(@RequestBody @Valid AddressDTO dto){
        addressService.addAddress(dto);
        return ResponseEntity.status(200).body("Address added To Teacher");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAddressToTeacher(@RequestBody @Valid AddressDTO dto){
        addressService.updateAddress(dto);
        return ResponseEntity.status(200).body("Address Update To Teacher");
    }
}
