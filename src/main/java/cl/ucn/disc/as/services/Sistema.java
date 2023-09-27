package cl.ucn.disc.as.services;
import cl.ucn.disc.as.model.Edificio;

/**
 * Sistema interface
 */
public interface Sistema {

    /**
     * Agrega un edificio al Sistema.
     * @param edificio a agregar
     */
    Edificio add(Edificio edificio);
}
