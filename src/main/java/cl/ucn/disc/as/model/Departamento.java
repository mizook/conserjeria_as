package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * Clase Departamento.
 *
 * @author Carlo Ramírez González
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Departamento extends BaseModel {

    /**
     * ID del Edificio.
     */
    @NotNull
    private Long edificioID;

    /**
     * Número del Departamento.
     */
    @NotNull
    private Integer numero;

    /**
     * Piso del Departamento.
     */
    @NotNull
    private String piso;
}