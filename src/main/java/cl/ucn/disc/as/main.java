package cl.ucn.disc.as;

import cl.ucn.disc.as.model.*;
import cl.ucn.disc.as.services.SistemaImpl;
import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;
import cl.ucn.disc.as.services.Sistema;

import java.time.Instant;
import java.util.List;

@Slf4j
public final class main {

    public static void main(String[] args) {
        log.debug("Starting...");

        // Base de datos
        Database db = DB.getDefault();
        Sistema sistema = new SistemaImpl(db);

        // Crear y guardar edificio en el sistema
        Edificio edificio = Edificio.builder()
                .constructora("CHILECONSTRUYE")
                .nombre("Y1")
                .direccion("Angamos")
                .pisos(20)
                .build();

        edificio = sistema.add(edificio);
        Long idEdificio = edificio.getId(); // Suponiendo que tu clase Edificio tiene un método getId().

        // Crear persona
        Persona persona = Persona.builder()
                .rut("20504139-7")
                .nombre("Carlo")
                .apellidos("Ramirez Gonzalez")
                .email("cairamgo@gmail.com")
                .telefono("+56982221173")
                .build();

        // Guardar persona en el sistema
        sistema.add(persona);

        // Crear y guardar departamento en el sistema asociado al edificio
        Departamento depto = new Departamento(edificio, 1, 10);
        sistema.addDepartamento(depto, edificio);

        // Crear y guardar otro departamento usando el id del edificio
        Departamento otroDepto = new Departamento(edificio, 2, 15);
        sistema.addDepartamento(otroDepto, idEdificio);

        // Crear contrato con la persona y el departamento
        Instant fechaPago = Instant.now();
        Contrato contrato = sistema.realizarContrato(persona, depto, fechaPago);

        // Crear y añadir pago al contrato
        Pago pago = new Pago(contrato, fechaPago, 50000);
        sistema.addPago(contrato, pago);

        // Obtener y mostrar todos los contratos
        List<Contrato> contratos = sistema.getContratos();
        log.debug("Contratos: " + contratos);

        // Obtener y mostrar todas las personas
        List<Persona> personas = sistema.getPersonas();
        log.debug("Personas: " + personas);

        // Obtener y mostrar pagos asociados al RUT de la persona
        List<Pago> pagos = sistema.getPagos(persona.getRut());
        log.debug("Pagos de " + persona.getNombre() + ": " + pagos);

        log.debug("Done.");
    }
}
