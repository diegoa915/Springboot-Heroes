package com.capacitacion.api;

import com.capacitacion.api.model.Mutante;
import com.capacitacion.api.repo.IMutanteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ApiEntityTests {

    @Autowired
    private IMutanteRepo repo;
    public List<Mutante> mutanteTest1 = new ArrayList<>();
    public List<Mutante> mutanteTest2 = new ArrayList<>();
    public List<Mutante> mutanteTest3 = new ArrayList<>();
    public List<Mutante> mutanteTest4 = new ArrayList<>();

    @Test
    @Rollback(true)
    public void testInsertarMutante() {
        Mutante mutante = new Mutante("Black Widow", "Heroe", "Tierra", "Libertad", "Mental");

        mutanteTest1.add(mutante);
        Mutante mutanteGuardada = repo.save(mutante);
        Assertions.assertEquals(mutante.getName(), mutanteGuardada.getName());
        Assertions.assertEquals(mutante.getGrupo(), mutanteGuardada.getGrupo());
        Assertions.assertEquals(mutante.getLocation(), mutanteGuardada.getLocation());
        Assertions.assertEquals(mutante.getCondicion(), mutanteGuardada.getCondicion());
        Assertions.assertEquals(mutante.getPoder(), mutanteGuardada.getPoder());
    }

    @Test
    @Rollback(true)
    public void testMostarMutante() {
        Mutante mutante2 = new Mutante("Black Widow", "Heroe", "Tierra", "Libertad", "Mental");
        mutanteTest2.add(mutante2);
        repo.save(mutante2);
        Mutante mutante3 = new Mutante("Black Widow", "Heroe", "Tierra", "Libertad", "Mental");
        mutanteTest2.add(mutante3);

        repo.save(mutante3);


        List<Mutante> mutanteGuardada = repo.findAll();
        Assertions.assertEquals(mutanteTest2.size(), mutanteGuardada.size());
    }

    @Test
    @Rollback(true)
    public void getMutantByName() {
        Mutante mutante3 = new Mutante("Black Widow", "Heroe", "Tierra", "Libertad", "Mental");
        mutanteTest3.add(mutante3);
        repo.save(mutante3);


        List<Mutante> mutanteGuardada = repo.findByName("Black Widow");

        Assertions.assertEquals(mutanteTest3.size(), mutanteGuardada.size());
    }

    @Test
    @Rollback(true)
    public void getMutantByLocation() {
        Mutante mutante4 = new Mutante("Black Widow", "Heroe", "Tierra", "Libertad", "Mental");
        mutanteTest4.add(mutante4);
        repo.save(mutante4);


        List<Mutante> mutanteGuardada = repo.findByLocation("Tierra");

        Assertions.assertEquals(mutanteTest4.size(), mutanteGuardada.size());
    }


}
