package com.capacitacion.api.repo;

import com.capacitacion.api.model.Persona;
import com.capacitacion.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
    Usuario findByNombre(String nombre);
}
