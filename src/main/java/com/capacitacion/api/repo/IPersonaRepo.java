package com.capacitacion.api.repo;

import com.capacitacion.api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
