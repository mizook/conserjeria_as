package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * Clase Departamento.
 *
 * @author Carlo Ramírez González
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Departamento extends BaseModel {

    /**
     * Edificio al que pertenece
     */
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    /**
     * Número del Departamento.
     */
    @NotNull
    private Integer numero;

    /**
     * Piso del Departamento.
     */
    @NotNull
    private Integer piso;
}