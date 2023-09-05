package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import java.time.Instant;

import javax.persistence.Entity;

/**
 * Clase Contrato.
 *
 * @author Carlo Ramírez González
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Contrato extends BaseModel {

    /**
     * Constructora.
     */
    @NotNull
    private Long edificioId;

    /**
     * ID de la Persona.
     */
    @NotNull
    private Long personaID;

    /**
     * Fecha de pago de gastos comunes.
     */
    @NotNull
    private Instant pago;
}