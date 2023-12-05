package cl.ucn.disc.as.conserjeria.ui;

import io.javalin.Javalin;

/**
 * The Routes Configurator.
 * @author Carlo Ignacio Ramírez González
 */
public interface RoutesConfigurator {
    /**
     * Configure the routes.
     * @param javalin to use.
     */
    void configure(Javalin javalin);
}