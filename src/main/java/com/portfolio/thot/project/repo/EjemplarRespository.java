package com.portfolio.thot.project.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.thot.project.model.Ejemplar;

@Repository
public interface EjemplarRespository extends JpaRepository<Ejemplar, UUID>{

}
