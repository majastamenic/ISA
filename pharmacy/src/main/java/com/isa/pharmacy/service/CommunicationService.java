package com.isa.pharmacy.service;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import rs.ac.uns.ftn.grpc.MessageProto;
import rs.ac.uns.ftn.grpc.MessageResponseProto;
import rs.ac.uns.ftn.grpc.SpringGrpcServiceGrpc;

import java.util.UUID;

@GrpcService
public class CommunicationService extends SpringGrpcServiceGrpc.SpringGrpcServiceImplBase {

    @Override
    public void communicate(MessageProto request, StreamObserver<MessageResponseProto> responseObserver) {
        System.out.println("You are now communicating with hospital.");
        System.out.println("Message from Hospital: " + request.getMessage());
        String poruka = "Hello from Pharmacy, medication you asked for " + request.getMessage() + " we ";
        MessageResponseProto responseMessage = MessageResponseProto.newBuilder()
                .setResponse(poruka).setStatus("have it.").build();
        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        System.out.println(responseMessage);
    }
}
