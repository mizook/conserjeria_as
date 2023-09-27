package cl.ucn.disc.as.services;
import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.Edificio;
import org.jetbrains.annotations.NotNull;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;


import javax.persistence.PersistenceException;


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
}
