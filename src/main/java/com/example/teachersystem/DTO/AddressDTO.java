package com.example.teachersystem.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotEmpty
    private String area;

    @NotEmpty
    private String street;

    @NotNull
    private Integer buildingNumber;

    @NotNull
    private Integer teacherId;
}
