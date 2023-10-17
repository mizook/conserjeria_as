package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * Clase Pago.
 *
 * @author Carlo Ramírez González
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Pago extends BaseModel {

    /**
     * Contrato al que pertenece
     */
    @Setter
    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    /**
     * Fecha de pago de gastos comunes.
     */
    @NotNull
    private Instant fechaPago;

    /**
     * Monto del pago.
     */
    @NotNull
    private Integer monto;
}