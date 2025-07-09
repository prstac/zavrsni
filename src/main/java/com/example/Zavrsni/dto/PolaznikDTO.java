package com.example.Zavrsni.dto;

import com.example.Zavrsni.domain.Polaznik;
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
public class PolaznikDTO {
    @NotBlank(message = "Name must not be empty")
    @Size(max = 200, message = "Name can't have more than 200 characters")
    private String Ime;

    @NotBlank(message = "Code must not be empty")
    private String prezime;

    public PolaznikDTO(Polaznik polaznik) {
        Ime = polaznik.getIme();
        prezime = polaznik.getPrezime();
    }
}
