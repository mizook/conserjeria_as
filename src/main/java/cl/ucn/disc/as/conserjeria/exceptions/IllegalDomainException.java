package cl.ucn.disc.as.conserjeria.exceptions;

/**
 * Invalid RUT Exception.
 * @author Arquitectura de Software.
 */
public class IllegalDomainException extends RuntimeException {
    public IllegalDomainException(String message) {
        super(message);
    }
}