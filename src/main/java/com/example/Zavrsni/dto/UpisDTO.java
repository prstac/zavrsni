package com.example.Zavrsni.dto;

import com.example.Zavrsni.domain.Polaznik;
import com.example.Zavrsni.domain.ProgramObrazovanja;
import com.example.Zavrsni.domain.Upis;
import com.example.Zavrsni.repository.PolaznikRepository;
import com.example.Zavrsni.repository.ProgramObrazovanjaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpisDTO {
    Long idPolaznik;
    Long idProgramObrazovanja;
    String po;
    String polaznik;

    PolaznikRepository polaznikRepository;
    ProgramObrazovanjaRepository poRepository;
    public UpisDTO(Upis upis) {
        Optional<ProgramObrazovanja> programObrazovanjaOptional = poRepository.findById(upis.getIDProgramObrazovanja());
        if (programObrazovanjaOptional.isPresent()) {
            ProgramObrazovanja programObrazovanja = programObrazovanjaOptional.get();
            this.po = programObrazovanja.getNaziv();
            this.idProgramObrazovanja = programObrazovanja.getProgramObrazovanjaId();
        }
        Optional<Polaznik> polaznikOptional = polaznikRepository.findById(upis.getIDPolaznik());
        if (polaznikOptional.isPresent()) {
            Polaznik polaznik1 = polaznikOptional.get();
            this.polaznik = polaznik1.getIme() + " " + polaznik1.getPrezime();
        }
    }
}
