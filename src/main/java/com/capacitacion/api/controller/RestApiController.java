package com.capacitacion.api.controller;

import com.capacitacion.api.model.Mutante;
import com.capacitacion.api.repo.IMutanteRepo;
import com.capacitacion.api.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutante")
public class RestApiController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    private IMutanteRepo repo;
    @Autowired


    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @GetMapping()
    public List<Mutante> listar() {

        return usuarioService.findAll();
    }

    @GetMapping("/name")
    public ResponseEntity<List<Mutante>> getMutanteByName(@RequestParam String name) {


        return new ResponseEntity<List<Mutante>>(usuarioService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity<List<Mutante>> getMutanteByLocation(@RequestParam String location) {


        return new ResponseEntity<List<Mutante>>(usuarioService.findByLocation(location), HttpStatus.OK);
    }


    @PostMapping("/insertar")
    public void insertar(@RequestBody Mutante mutante) {

        usuarioService.save(mutante);
    }


}
