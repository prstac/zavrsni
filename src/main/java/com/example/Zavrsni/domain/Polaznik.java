package com.example.Zavrsni.domain;

import com.example.Zavrsni.dto.PolaznikDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data

@AllArgsConstructor
@Entity
@Table(name = "Polaznik")
public class Polaznik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PolaznikID")
    Long PolaznikID;
    String ime, prezime;

    @ManyToMany(mappedBy = "polaznici", cascade = CascadeType.ALL)
    Set<ProgramObrazovanja> programiObrazovanja = new HashSet<>();

    public Polaznik() {
    }

    public Polaznik(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public Long getPolaznikID() {
        return PolaznikID;
    }

    public void setPolaznikID(Long polaznikID) {
        this.PolaznikID = polaznikID;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Set<ProgramObrazovanja> getProgramiObrazovanja() {
        return programiObrazovanja;
    }

    public void setProgramiObrazovanja(Set<ProgramObrazovanja> programiObrazovanja) {
        this.programiObrazovanja = programiObrazovanja;
    }

    public Polaznik(PolaznikDTO polaznikDTO) {
        this.ime = polaznikDTO.getIme();
        this.prezime = polaznikDTO.getPrezime();
    }
}
