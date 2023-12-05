package cl.ucn.disc.as.conserjeria.services;
import cl.ucn.disc.as.conserjeria.exceptions.SistemaException;
import cl.ucn.disc.as.conserjeria.model.*;
import cl.ucn.disc.as.utils.RutGenerator;
import cl.ucn.disc.as.utils.ValidationUtils;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.jetbrains.annotations.NotNull;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.Locale;
import java.util.Optional;


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
     * Initialize
     */
    @Override
    public void populate() {
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
            this.database.save(persona);
        }

        for (int i = 0; i < 5; i++) {
            Edificio edificio = Edificio.builder()
                    .constructora(faker.company().name())
                    .nombre(faker.dragonBall().character())
                    .direccion(faker.address().streetAddress())
                    .pisos(faker.number().numberBetween(10,30))
                    .build();
            this.database.save(edificio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Edificio add(@NotNull Edificio edificio) throws SistemaException {
        try {
            this.database.save(edificio);
        } catch (PersistenceException ex) {
            throw new SistemaException("Error al crear edificio.", ex);
        }

        // WARN: need to retrive the id?
        return edificio;
    }

    @Override
    public Persona add(@NotNull Persona persona) throws SistemaException {
        try {
            this.database.save(persona);
        } catch (PersistenceException ex) {
            log.error("Error ", ex);
            throw new SistemaException("Error al agregar persona.", ex);
        }
        return persona;
    }

    @Override
    public Departamento addDepartamento(@NotNull Departamento departamento, @NotNull Edificio edificio) throws SistemaException {
        try {
            edificio.add(departamento);
            this.database.save(departamento);
        } catch (PersistenceException ex) {
            throw new SistemaException("Error al agregar departamento.", ex);
        }
        return departamento;
    }

    @Override
    public Departamento addDepartamento(@NotNull Departamento departamento, @NotNull Long idEdificio) throws NullPointerException, SistemaException {
        Edificio edificio = this.database.find(Edificio.class, idEdificio);
        if (edificio == null) {
            throw new NullPointerException("Edificio no encontrado");
        }
        return addDepartamento(departamento, edificio);
    }

    @Override
    public Contrato realizarContrato(@NotNull Persona duenio, @NotNull Departamento departamento, @NotNull Instant fechaPago) throws SistemaException {
        List<Pago> pagosVacios = new ArrayList<>();
        Contrato contrato = new Contrato(departamento, duenio, fechaPago, pagosVacios);
        try {
            this.database.save(contrato);
        } catch (PersistenceException ex) {
            throw new SistemaException("Error al intentar crear el contrato", ex);
        }
        return contrato;
    }

    @Override
    public Contrato realizarContrato(@NotNull Long idDuenio, @NotNull Long idDepartamento, @NotNull Instant fechaPago) throws NullPointerException, SistemaException {
        Persona duenio = this.database.find(Persona.class, idDuenio);
        if (duenio == null) {
            throw new NullPointerException("Dueño no encontrado");
        }

        Departamento departamento = this.database.find(Departamento.class, idDepartamento);
        if (departamento == null) {
            throw new NullPointerException("Departamento no encontrado");
        }

        return realizarContrato(duenio, departamento, fechaPago);
    }

    @Override
    public Pago addPago(Contrato contrato, Pago pago) {
        pago.setContrato(contrato);

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
    public List<Edificio> getEdificios() {
        return this.database.find(Edificio.class).findList();
    }

    @Override
    public Optional<Persona> getPersonaByRut(String rut) {
        return Optional.ofNullable(this.database.find(Persona.class).where().eq("rut", rut).findOne());
    }

    @Override
    public List<Pago> getPagos(String rut) {
        Persona persona = this.database.createQuery(Persona.class).where().eq("rut", rut).findOne();
        if (persona == null) {
            throw new NullPointerException("Persona no encontrada con RUT: " + rut);
        }
        return this.database.createQuery(Pago.class).where().eq("contrato.persona", persona).findList();
    }
}