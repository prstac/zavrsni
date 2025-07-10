package com.example.Zavrsni.controller;

import com.example.Zavrsni.dto.PolaznikDTO;
import com.example.Zavrsni.service.PolaznikService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("polaznik")
public class PolaznikController {

    private final PolaznikService polaznikService;

    public PolaznikController(PolaznikService polaznikService) {
        this.polaznikService = polaznikService;
    }

    @GetMapping
    public List<PolaznikDTO> getAll() {
        return polaznikService.findAll();
    }

    @GetMapping("{code}")
    public PolaznikDTO getByID(@PathVariable final Long id) {
        return polaznikService.findByID(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Polaznik was not found by that code")
                );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PolaznikDTO save(@Valid @RequestBody final PolaznikDTO command){
        return polaznikService.save(command)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Polaznik with the same code already exists"));
    }

    @PutMapping("{code}")
    public PolaznikDTO update(@PathVariable Long code, @Valid @RequestBody final PolaznikDTO updatedPolaznikDTO){
        return polaznikService.update(code, updatedPolaznikDTO)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Polaznik was not found by that code")
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{code}")
    public void delete(@PathVariable Long code){
        polaznikService.deleteB(code);
    }

}
