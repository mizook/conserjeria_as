package cl.ucn.disc.as.conserjeria.exceptions;

import javax.persistence.PersistenceException;

public class SistemaException extends Throwable {
    public SistemaException(String s, PersistenceException ex) {
        super(s);
    }
}
