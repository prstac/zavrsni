package com.example.Zavrsni.dto;

import com.example.Zavrsni.domain.Upis;
import com.example.Zavrsni.repository.PolaznikRepository;
import com.example.Zavrsni.repository.ProgramObrazovanjaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpisDTO {
    String po;
    String polaznik;

    PolaznikRepository polaznikRepository;
    ProgramObrazovanjaRepository poRepository;
    public UpisDTO(Upis upis) {

    }
}
