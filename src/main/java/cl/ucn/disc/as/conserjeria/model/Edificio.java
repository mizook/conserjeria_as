package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

/**
 * Clase Edificio.
 *
 * @author Carlo Ramírez González
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Edificio extends BaseModel {

    /**
     * Nombre de la constructora.
     */
    @NotNull
    private String constructora;

    /**
     * Nombre del edificio.
     */
    @NotNull
    private String nombre;

    /**
     * Dirección del edificio.
     */
    @NotNull
    private String direccion;

    /**
     * Número de pisos del edificio.
     */
    @NotNull
    private Integer pisos;

    /**
     * Lista de departamentos en el edificio.
     */
    @NotNull
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Departamento> departamentos;

    /**
     * Método para añadir un departamento a la lista.
     *
     * @param departamento el departamento a añadir.
     */
    public void add(Departamento departamento) {
        if (departamento != null) {
            departamentos.add(departamento);
        }
    }
}