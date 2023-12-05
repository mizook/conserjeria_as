package cl.ucn.disc.as.conserjeria.grpc;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * The gRPC service class.
 *
 * @author Arquitectura de Software.
 */
@Slf4j
public final class PersonaGrpcServiceImpl extends PersonaGrpcServiceGrpc.PersonaGrpcServiceImplBase {

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void retrieve(PersonaGrpcRequest request, StreamObserver<PersonaGrpcResponse> responseObserver) {

        log.debug("Retrieving PersonaGrpc with rut={}.", request.getRut());

        PersonaGrpc personaGrpc = PersonaGrpc.newBuilder()
                .setRut("17077744-1")
                .setNombre("Juanito")
                .setApellidos("Urrutia Astorga")
                .setEmail("jurrutia@ucn.cl")
                .setTelefono("+56 2 2355166")
                .build();

        responseObserver.onNext(PersonaGrpcResponse.newBuilder().setPersona(personaGrpc).build());

        responseObserver.onCompleted();
    }
}