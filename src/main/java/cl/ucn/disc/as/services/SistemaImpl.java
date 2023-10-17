package cl.ucn.disc.as.services;
import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.*;
import org.jetbrains.annotations.NotNull;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.List;


/**
 * Sistema implementation
 */
@Slf4j
public class SistemaImpl implements Sistema {

    /**
     * The database
     */
    private final Database database;

    /**
     * Constructor
     * @param database the database
     */
    public SistemaImpl(@NotNull Database database) {

        this.database = database;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Edificio add(@NotNull Edificio edificio) {
        try {
            this.database.save(edificio);
        } catch (PersistenceException ex) {
            log.error("Error", ex);
            //throw new SistemaException("Error al crear edificio.", ex);
        }

        // WARN: need to retrive the id?
        return edificio;
    }

    @Override
    public Persona add(@NotNull Persona persona) {
        try {
            this.database.save(persona);
        } catch (PersistenceException ex) {
            log.error("Error", ex);
            //throw new SistemaException("Error al agregar persona.", ex);
        }
        return persona;
    }

    @Override
    public Departamento addDepartamento(@NotNull Departamento departamento, @NotNull Edificio edificio) {
        try {
            edificio.add(departamento);
            this.database.save(departamento);
        } catch (PersistenceException ex) {
            log.error("Error", ex);
            //throw new SistemaException("Error al agregar departamento.", ex);
        }
        return departamento;
    }

    @Override
    public Departamento addDepartamento(@NotNull Departamento departamento, @NotNull Long idEdificio) {
        Edificio edificio = this.database.find(Edificio.class, idEdificio);
        if (edificio == null) {
            //throw new SistemaException("Edificio no encontrado con ID: " + idEdificio);
        }
        return addDepartamento(departamento, edificio);
    }

    @Override
    public Contrato realizarContrato(@NotNull Persona duenio, @NotNull Departamento departamento, @NotNull Instant fechaPago) {
        List<Pago> pagosVacios = new ArrayList<>();
        Contrato contrato = new Contrato(departamento, duenio, fechaPago, pagosVacios);
        try {
            this.database.save(contrato);
        } catch (PersistenceException ex) {
            log.error("Error", ex);
            //throw new SistemaException("Error al realizar contrato.", ex);
        }
        return contrato;
    }

    @Override
    public Contrato realizarContrato(@NotNull Long idDuenio, @NotNull Long idDepartamento, @NotNull Instant fechaPago) {
        Persona duenio = this.database.find(Persona.class, idDuenio);
        if (duenio == null) {
            //throw new SistemaException("Dueño no encontrado con ID: " + idDuenio);
        }

        Departamento departamento = this.database.find(Departamento.class, idDepartamento);
        if (departamento == null) {
            //throw new SistemaException("Departamento no encontrado con ID: " + idDepartamento);
        }

        return realizarContrato(duenio, departamento, fechaPago);
    }

    @Override
    public Pago addPago(Contrato contrato, Pago pago) {
        // Establecer la relación entre el contrato y el pago
        pago.setContrato(contrato);

        // Guardar el pago en la base de datos
        this.database.save(pago);

        return pago;
    }

    @Override
    public List<Contrato> getContratos() {
        return this.database.find(Contrato.class).findList();
    }

    @Override
    public List<Persona> getPersonas() {
        return this.database.find(Persona.class).findList();
    }

    @Override
    public List<Pago> getPagos(String rut) {
        Persona persona = this.database.createQuery(Persona.class).where().eq("rut", rut).findOne();
        if (persona == null) {
            //throw new SistemaException("Persona no encontrada con RUT: " + rut);
        }

        // NOTA: Esta consulta podría no funcionar si no tienes las relaciones adecuadas en la base de datos.
        return this.database.createQuery(Pago.class).where().eq("contrato.persona", persona).findList();
    }
}