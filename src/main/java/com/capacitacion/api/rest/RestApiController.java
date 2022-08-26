package com.capacitacion.api.rest;

import com.capacitacion.api.model.Persona;
import com.capacitacion.api.repo.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class RestApiController {

    @Autowired
    private IPersonaRepo repo;

    @GetMapping
    public List<Persona> listar(){
        return repo.findAll();
    }

    @PostMapping
    public void insertar(@RequestBody Persona persona){
        repo.save(persona);
    }

    @PutMapping
    public void modificar(@RequestBody Persona persona){
        repo.save(persona);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        repo.deleteById(id);
    }
}
