package com.capacitacion.api.repo;

import com.capacitacion.api.model.Mutante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMutanteRepo extends JpaRepository<Mutante, Integer> {
    List<Mutante> findAll();

    List<Mutante> findByName(String name);

    List<Mutante> findByLocation(String location);


}
