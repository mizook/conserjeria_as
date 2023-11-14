package cl.ucn.disc.as;

import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.*;
import cl.ucn.disc.as.services.SistemaImpl;

import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;
import cl.ucn.disc.as.services.Sistema;

import java.time.Instant;
import java.util.List;
import com.github.javafaker.Faker;

import cl.ucn.disc.as.utils.RutGenerator;

import cl.ucn.disc.as.ui.ApiRestServer;
import cl.ucn.disc.as.ui.WebController;

@Slf4j
public final class main {

    public static void main(String[] args) throws SistemaException {
        log.debug("Starting Main...");

        Database db = DB.getDefault();
        Sistema sistema = new SistemaImpl(db);
        Faker faker = new Faker();
        RutGenerator rutGenerator = new RutGenerator();
        List<String> ruts = rutGenerator.generateRuts(20, 1000000, 25000000);

        for (int i = 0; i < 20; i++) {
            Persona persona = Persona.builder()
                    .rut(ruts.get(i))
                    .nombre(faker.name().firstName())
                    .apellidos(faker.name().lastName())
                    .email(faker.internet().emailAddress())
                    .telefono(faker.phoneNumber().phoneNumber())
                    .build();
            sistema.add(persona);
        }

        for (int i = 0; i < 5; i++) {
            Edificio edificio = Edificio.builder()
                    .constructora(faker.company().name())
                    .nombre(faker.dragonBall().character())
                    .direccion(faker.address().streetAddress())
                    .pisos(faker.number().numberBetween(10,30))
                    .build();
            sistema.add(edificio);
        }

        ApiRestServer.start(7070, new WebController());

        log.debug("Done...");

        /**
        Departamento depto = new Departamento(edificio, 1, 10);
        Departamento otroDepto = new Departamento(edificio, 2, 15);

        sistema.add(persona);
        edificio = sistema.add(edificio);
        Long idEdificio = edificio.getId();
        sistema.addDepartamento(depto, edificio);
        sistema.addDepartamento(otroDepto, idEdificio);

        Instant fechaPago = Instant.now();
        Contrato contrato = sistema.realizarContrato(persona, depto, fechaPago);
        Pago pago = new Pago(contrato, fechaPago, 50000);

        sistema.addPago(contrato, pago);
         **/
    }
}
