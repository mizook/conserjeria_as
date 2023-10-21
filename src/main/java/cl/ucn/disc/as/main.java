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

@Slf4j
public final class main {

    public static void main(String[] args) throws SistemaException {
        Database db = DB.getDefault();
        Sistema sistema = new SistemaImpl(db);

        Persona persona = Persona.builder()
                .rut("23864911-0")
                .nombre("Fulanito")
                .apellidos("Perez Const")
                .email("fulatino@dev.com")
                .telefono("+56965552273")
                .build();
        Edificio edificio = Edificio.builder()
                .constructora("CHILECONSTRUYE")
                .nombre("Y1")
                .direccion("Angamos")
                .pisos(20)
                .build();

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
    }
}
