package cl.ucn.disc.as.services;

import cl.ucn.disc.as.model.*;
import java.time.Instant;
import java.util.List;

/**
 * Sistema interface.
 */
public interface Sistema {

    /**
     * Agrega un edificio al Sistema.
     *
     * @param edificio a agregar
     * @return the edificio added
     */
    Edificio add(Edificio edificio);

    /**
     * Agrega una persona al Sistema.
     *
     * @param persona a agregar
     * @return the persona added
     */
    Persona add(Persona persona);

    /**
     * Agrega un departamento al Sistema.
     *
     * @param departamento a agregar
     * @param edificio al cual pertenece el departamento
     * @return the departamento added
     */
    Departamento addDepartamento(Departamento departamento, Edificio edificio);

    /**
     * Agrega un departamento al Sistema utilizando el id del edificio.
     *
     * @param departamento a agregar
     * @param idEdificio the id of the Edificio to which the departamento belongs
     * @return the departamento added
     */
    Departamento addDepartamento(Departamento departamento, Long idEdificio);

    /**
     * Realiza un contrato en el sistema.
     *
     * @param duenio de la propiedad
     * @param departamento objeto de contrato
     * @param fechaPago fecha de pago acordada
     * @return the contrato realizado
     */
    Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago);

    /**
     * Realiza un contrato en el sistema utilizando los IDs.
     *
     * @param idDuenio ID del dueño de la propiedad
     * @param idDepartamento ID del departamento objeto de contrato
     * @param fechaPago fecha de pago acordada
     * @return the contrato realizado
     */
    Contrato realizarContrato(Long idDuenio, Long idDepartamento, Instant fechaPago);

    /**
     * @return Lista de todos los contratos en el sistema.
     */
    List<Contrato> getContratos();

    /**
     * @return Lista de todas las personas en el sistema.
     */
    List<Persona> getPersonas();

    /**
     * Obtiene la lista de pagos basado en el RUT proporcionado.
     *
     * @param rut de la persona
     * @return Lista de pagos asociados al RUT proporcionado
     */
    List<Pago> getPagos(String rut);
}