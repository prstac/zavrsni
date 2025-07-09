package com.example.Zavrsni.repository;

import java.util.Optional;

import com.example.Zavrsni.domain.Upis;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface UpisRepository extends JpaRepository<Upis, Integer> {
}
