package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Getter;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.List;

/**
 * Clase Contrato.
 *
 * @author Carlo Ramírez González
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Contrato extends BaseModel {

    /**
     * Departamento.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    /**
     * Persona.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    /**
     * Fecha de pago de gastos comunes.
     */
    @NotNull
    private Instant fechaPago;

    /**
     * Lista de pagos asociados a este contrato.
     */
    @OneToMany(mappedBy = "contrato")
    private List<Pago> pagos;
}