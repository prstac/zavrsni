package com.example.Zavrsni.dto;

import com.example.Zavrsni.domain.ProgramObrazovanja;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProgramObrazovanjaDTO {
    @NotBlank(message = "Naziv must not be empty")
    @Size(max = 200, message = "Naziv can't have more than 200 characters")
    private String Naziv;

    @PositiveOrZero(message = "CSVET must be positive or zero")
    @Max(value = 10000, message = "CSVET can't be above 10000")
    private Integer CSVET;
    public ProgramObrazovanjaDTO(ProgramObrazovanja programObrazovanja) {
        Naziv = programObrazovanja.getNaziv();
        CSVET = programObrazovanja.getCsvet();
    }
}

