package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * Clase Edificio.
 *
 * @author Carlo Ramírez González
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Edificio extends BaseModel {

    /**
     * Nombre de la constructora.
     */
    @Getter
    @NotNull
    private String constructora;

    /**
     * Nombre del edificio.
     */
    @Getter
    @NotNull
    private String nombre;

    /**
     * Dirección del edificio.
     */
    @Getter
    @NotNull
    private String direccion;

    /**
     * Número de pisos del edificio.
     */
    @Getter
    @NotNull
    private Integer pisos;
}