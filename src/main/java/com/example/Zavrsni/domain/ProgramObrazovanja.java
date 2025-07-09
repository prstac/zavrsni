package com.example.Zavrsni.domain;

import com.example.Zavrsni.dto.ProgramObrazovanjaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "ProgramObrazovanja")
public class ProgramObrazovanja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProgramObrazovanjaId")
    Long ProgramObrazovanjaId;
    String naziv;
    int csvet;

    public ProgramObrazovanja() {
    }

    @ManyToMany
    @JoinTable(
            name = "Upis",
            joinColumns=@JoinColumn(name = "IDProgramObrazovanja", referencedColumnName = "ProgramObrazovanjaId"),
            inverseJoinColumns = @JoinColumn(name = "IDPolaznik", referencedColumnName = "PolaznikID")
    )
    Set<Polaznik> polaznici = new HashSet<>();


    public ProgramObrazovanja(String naziv, int csvet) {
        this.naziv = naziv;
        this.csvet = csvet;
    }

    public Long getProgramObrazovanjaId() {
        return ProgramObrazovanjaId;
    }

    public void setProgramObrazovanjaId(Long programObrazovanjaId) {
        this.ProgramObrazovanjaId = programObrazovanjaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCsvet() {
        return csvet;
    }

    public void setCsvet(int csvet) {
        this.csvet = csvet;
    }

    public Set<Polaznik> getPolaznici() {
        return polaznici;
    }

    public void setPolaznici(Set<Polaznik> polaznici) {
        this.polaznici = polaznici;
    }

    public void addPolaznik(Polaznik polaznik) {
        polaznici.add(polaznik);
        polaznik.programiObrazovanja.add(this);
    }

    public void addPolaznici(List<Polaznik> polaznici) {
        for (Polaznik polaznik : polaznici) {
            this.addPolaznik(polaznik);
        }
    }

    public ProgramObrazovanja(ProgramObrazovanjaDTO programObrazovanjaDTO) {
        this.naziv = programObrazovanjaDTO.getNaziv();
        this.csvet = programObrazovanjaDTO.getCSVET();
    }
}
