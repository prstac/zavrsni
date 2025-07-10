package com.example.Zavrsni.service;

import com.example.Zavrsni.domain.ProgramObrazovanja;
import com.example.Zavrsni.dto.PolaznikDTO;
import com.example.Zavrsni.dto.ProgramObrazovanjaDTO;
import com.example.Zavrsni.repository.ProgramObrazovanjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramObrazovanjaService {

    private final ProgramObrazovanjaRepository programObrazovanjaRepository;


    public Optional<ProgramObrazovanjaDTO> findByID(Long id) {
        return programObrazovanjaRepository.findById(id).map(ProgramObrazovanjaDTO::new);
    }

    public List<ProgramObrazovanjaDTO> findAll() {
        return programObrazovanjaRepository.findAll().stream().map(ProgramObrazovanjaDTO::new).collect(Collectors.toList());
    }

    public Optional<ProgramObrazovanjaDTO> save(ProgramObrazovanjaDTO programObrazovanjaDTO) {
        return Optional.of(new ProgramObrazovanjaDTO(programObrazovanjaRepository.save(new ProgramObrazovanja(programObrazovanjaDTO))));
    }

    public Optional<ProgramObrazovanjaDTO> update(Long id, ProgramObrazovanjaDTO updatedProgramOBrazovanjaDTO) {
        Optional<ProgramObrazovanja> programObrazovanjaOptional = programObrazovanjaRepository.findById(id);

        if (programObrazovanjaOptional.isPresent()) {
            ProgramObrazovanja programObrazovanjaToUpdate = programObrazovanjaOptional.get();
            programObrazovanjaToUpdate.setNaziv(updatedProgramOBrazovanjaDTO.getNaziv());
            programObrazovanjaToUpdate.setCsvet(updatedProgramOBrazovanjaDTO.getCSVET());
            ProgramObrazovanja updatedProgramObrazovanja = programObrazovanjaRepository.save(programObrazovanjaToUpdate);
            return Optional.of(new ProgramObrazovanjaDTO(updatedProgramObrazovanja));
        } else {
            return Optional.empty();
        }
    }

    public void deleteB(Long id) {
        Optional<ProgramObrazovanja> programObrazovanjaOptiona = programObrazovanjaRepository.findById(id);
        programObrazovanjaOptiona.ifPresent(programObrazovanjaRepository::delete);
    }
}

