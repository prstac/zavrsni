package com.example.Zavrsni.service;

import com.example.Zavrsni.domain.Upis;
import com.example.Zavrsni.dto.UpisDTO;
import com.example.Zavrsni.repository.UpisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UpisService {

    private final UpisRepository upisRepository;
    
    public List<UpisDTO> findAll() {
        return upisRepository.findAll().stream().map(UpisDTO::new).collect(Collectors.toList());
    }

    public void deleteB(Integer id) {
        Optional<Upis> upisOptional = upisRepository.findById(id);
        upisOptional.ifPresent(upisRepository::delete);
    }
}

