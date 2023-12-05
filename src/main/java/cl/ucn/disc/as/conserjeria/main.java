package cl.ucn.disc.as.conserjeria;

import cl.ucn.disc.as.conserjeria.exceptions.SistemaException;
import cl.ucn.disc.as.conserjeria.services.SistemaImpl;
import cl.ucn.disc.as.conserjeria.services.Sistema;

import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import cl.ucn.disc.as.conserjeria.grpc.PersonaGrpcServiceImpl;
import cl.ucn.disc.as.conserjeria.ui.ApiRestServer;
import cl.ucn.disc.as.conserjeria.ui.WebController;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@Slf4j
public final class main {

    public static void main(String[] args) throws SistemaException, InterruptedException, IOException {
        log.debug("Starting Main...");

        Database db = DB.getDefault();
        Sistema sistema = new SistemaImpl(db);

        sistema.populate();

        ApiRestServer.start(7070, new WebController());

        log.debug("Done...");

        log.debug("Starting the gRPC server ..");
        Server server = ServerBuilder
                .forPort(50123)
                .addService(new PersonaGrpcServiceImpl())
                .build();

        server.start();

        // shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        // wait for the stop
        server.awaitTermination();
    }
}