package com.example.Zavrsni.repository;

import com.example.Zavrsni.domain.ProgramObrazovanja;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface ProgramObrazovanjaRepository extends JpaRepository<ProgramObrazovanja, Long> {
}
