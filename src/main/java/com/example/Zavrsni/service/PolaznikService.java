package com.example.Zavrsni.service;

import com.example.Zavrsni.domain.Polaznik;
import com.example.Zavrsni.dto.PolaznikDTO;
import com.example.Zavrsni.repository.PolaznikRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PolaznikService {

    private final PolaznikRepository polaznikRepository;

    public Optional<PolaznikDTO> findByID(Integer id) {
        return polaznikRepository.findById(id).map(PolaznikDTO::new);
    }

    public List<PolaznikDTO> findAll() {
        return polaznikRepository.findAll().stream().map(PolaznikDTO::new).collect(Collectors.toList());
    }

    public Optional<PolaznikDTO> save(PolaznikDTO polaznikDTO) {
        return Optional.of(new PolaznikDTO(polaznikRepository.save(new Polaznik(polaznikDTO))));
    }

    public Optional<PolaznikDTO> update(Integer id, PolaznikDTO updatedPolaznikDTO) {
        Optional<Polaznik> polaznikDTOOptional = polaznikRepository.findById(id);

        if (polaznikDTOOptional.isPresent()) {
            Polaznik polaznikToUpdate = polaznikDTOOptional.get();
            polaznikToUpdate.setIme(updatedPolaznikDTO.getIme());
            polaznikToUpdate.setPrezime(updatedPolaznikDTO.getPrezime());
            Polaznik updatedPolaznik = polaznikRepository.save(polaznikToUpdate);
            return Optional.of(new PolaznikDTO(updatedPolaznik));
        } else {
            return Optional.empty();
        }
    }

    public void deleteB(Integer id) {
        Optional<Polaznik> polaznikOptional = polaznikRepository.findById(id);
        polaznikOptional.ifPresent(polaznikRepository::delete);
    }
}

