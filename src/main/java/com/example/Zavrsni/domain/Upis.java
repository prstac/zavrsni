package com.example.Zavrsni.domain;

import com.example.Zavrsni.dto.UpisDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Upis")
public class Upis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDProgramObrazovanja;
    private Long IDPolaznik;

    public Upis(UpisDTO upisDTO) {
        this.IDPolaznik = upisDTO.getIdPolaznik();
        this.IDProgramObrazovanja = upisDTO.getIdProgramObrazovanja();
    }
}
