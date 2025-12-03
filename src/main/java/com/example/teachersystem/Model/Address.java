package com.example.teachersystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = "varchar(30)")
    @MapsId
    private String area;

    @NotEmpty
    @Column(columnDefinition = "varchar(30)")
    private String street;

    @NotNull
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @NotNull
    @JsonIgnore
    private Teacher teacher ;
}
