package com.capacitacion.api.controller;


import com.capacitacion.api.model.Persona;
import com.capacitacion.api.repo.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//controller calse del modelo  mvc redireciona la peticion hacia alguna logica de negocio
@Controller
public class ApiController {
    @Autowired
    private IPersonaRepo repo;
    @GetMapping("/insertar")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        Persona p = new Persona();
        p.setIdPersona(2);
        p.setNombre("Andres");
        repo.save(p);

        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/consultar")
    public String greeting(Model model) {

        model.addAttribute("personas", repo.findAll());
        return "greeting";
    }

}