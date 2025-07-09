package com.example.Zavrsni.controller;


import com.example.Zavrsni.dto.ProgramObrazovanjaDTO;
import com.example.Zavrsni.service.ProgramObrazovanjaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("programobrazovanja")
public class ProgramObrazovanjaController {
    private final ProgramObrazovanjaService programObrazovanjaService;

    public ProgramObrazovanjaController(ProgramObrazovanjaService programObrazovanjaService) {
        this.programObrazovanjaService = programObrazovanjaService;
    }

    @GetMapping
    public List<ProgramObrazovanjaDTO> getAll() {
        return programObrazovanjaService.findAll();
    }

    @GetMapping("{code}")
    public ProgramObrazovanjaDTO getByID(@PathVariable final Integer id) {
        return programObrazovanjaService.findByID(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ProgramObrazovanja was not found by that code")
                );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProgramObrazovanjaDTO save(@Valid @RequestBody final ProgramObrazovanjaDTO command){
        return programObrazovanjaService.save(command)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "ProgramObrazovanja with the same code already exists"));
    }

    @PutMapping("{code}")
    public ProgramObrazovanjaDTO update(@PathVariable Integer code, @Valid @RequestBody final ProgramObrazovanjaDTO updatedProgramObrazovanjaDTO){
        return programObrazovanjaService.update(code, updatedProgramObrazovanjaDTO)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ProgramObrazovanja was not found by that code")
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{code}")
    public void delete(@PathVariable Integer code){
        programObrazovanjaService.deleteB(code);
    }

}
