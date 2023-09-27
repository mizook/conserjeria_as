package cl.ucn.disc.as;
import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.services.SistemaImpl;
import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;
import cl.ucn.disc.as.services.Sistema;


import java.util.Optional;

@Slf4j
public final class main {

    public static void main(String[] args) {
        log.debug("Starting...");

        //base de datos
        Database db = DB.getDefault();

        //crear persona
        Persona persona = Persona.builder()
                .rut("20504139-7")
                .nombre("Carlo")
                .apellidos("Ramirez Gonzalez")
                .email("cairamgo@gmail.com")
                .telefono("+56982221173")
                .build();

        //guargar persona
        db.save(persona);

        //the sistema
        Sistema sistema = new SistemaImpl(db);

        Edificio edificio = Edificio.builder()
                .constructora("UCN")
                .nombre("Y1")
                .direccion("Angamos")
                .pisos(20)
                .build();

        log.debug("Edificio before DB: " + edificio);

        edificio = sistema.add(edificio);
        log.debug("Edificio After DB: " + edificio);
    }
}