package com.example.Zavrsni.controller;

import com.example.Zavrsni.dto.UpisDTO;
import com.example.Zavrsni.service.ProgramObrazovanjaService;
import com.example.Zavrsni.service.UpisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("upis")
public class UpisController {

    private final UpisService upisService;

    public UpisController(UpisService upisService) {
        this.upisService = upisService;
    }

    @GetMapping
    public List<UpisDTO> getAll() {
        return upisService.findAll();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{code}")
    public void delete(@PathVariable Long code){
        upisService.deleteB(code);
    }

}
