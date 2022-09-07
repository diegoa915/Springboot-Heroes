package com.capacitacion.api.service;

import com.capacitacion.api.model.Mutante;


import java.util.List;

public interface UsuarioService {

    List<Mutante> findAll();

    List<Mutante> findByName(String name);

    List<Mutante> findByLocation(String location);


    void save(Mutante mutante);


}
