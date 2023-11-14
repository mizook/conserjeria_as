package cl.ucn.disc.as.ui;


import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.services.Sistema;
import cl.ucn.disc.as.services.SistemaImpl;
import io.ebean.DB;
import io.javalin.Javalin;

import java.util.Optional;

public final class WebController implements RoutesConfigurator {

    /**
     * The Sistema
     */
    private final Sistema sistema;

    public WebController() {
        this.sistema = new SistemaImpl(DB.getDefault());
    }

    @Override
    public void configure(final Javalin app) {
        app.get("/", ctx -> {
            ctx.result("Welcome to Conserjeria API REST");
        });

        app.get("/personas", ctx -> {
            ctx.json(this.sistema.getPersonas());
        });
    }
}