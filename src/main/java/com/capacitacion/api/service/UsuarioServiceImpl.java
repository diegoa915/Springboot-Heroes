package com.capacitacion.api.service;

import com.capacitacion.api.model.Mutante;
import com.capacitacion.api.repo.IMutanteRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    IMutanteRepo PersonaRepository;

    @Override
    public List<Mutante> findAll() {
        return PersonaRepository.findAll();
    }

    @Override

    public List<Mutante> findByName(String name) {
        List<Mutante> opt = PersonaRepository.findByName(name);
        if (opt.isEmpty()) {
            throw new NoSuchElementException("No existe un personaje con el nombre de : " + name);
        } else {
            return opt;
        }
    }

    @Override
    public List<Mutante> findByLocation(String location) {
        List<Mutante> opt2 = PersonaRepository.findByLocation(location);
        if (opt2.isEmpty()) {
            throw new NoSuchElementException("No existe un personaje con la ubicacion : " + location);

        } else {
            return opt2;
        }
    }

    @Override
    public void save(Mutante mutante) {

    }

    public Mutante insertar(@RequestBody Mutante mutante) {

        Mutante usuarioExample = new Mutante(mutante.getName());
        if (PersonaRepository.exists(Example.of(usuarioExample))) {
            throw new DuplicateKeyException("Ya existe personaje con ese nombre: " + mutante.getName());
        }
        return PersonaRepository.save(mutante);
    }


}


