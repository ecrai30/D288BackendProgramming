package com.example.demo.dao;

import com.example.demo.entities.Divison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Divison, Long> {
}
