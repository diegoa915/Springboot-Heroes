package com.capacitacion.api;

import com.capacitacion.api.model.Usuario;
import com.capacitacion.api.repo.IUsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class ApiApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void crearUsuarioTYest() {
		Usuario us = new Usuario();
		us.setId(1);
		us.setNombre("Andres");
		us.setClave(encoder.encode("987654"));

		Usuario retorno = repo.save(us);

		assert (retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
