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
        boolean status = true;
        String result;
        if(status)
            result = " we have it.";
        else
            result = " we don't have it.";
        String message = "Hello from Pharmacy, medication you asked for " + request.getMessage() + result;
        MessageResponseProto responseMessage = MessageResponseProto.newBuilder()
                .setResponse(message).setStatus(status).build();
        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        System.out.println(responseMessage);
    }
}
