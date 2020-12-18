package com.isa.pharmacy.service;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.grpc.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@GrpcService
public class CommunicationService extends SpringGrpcServiceGrpc.SpringGrpcServiceImplBase {

    @Autowired
    private MedicinePharmacyService medsPharmacy;

    @Override
    public void communicate(ProtoAvailableMedication request, StreamObserver<ProtoResponseAvailableMedication> responseObserver) {
        System.out.println("You are now communicating with hospital.");
        System.out.println("Message from Hospital: " + request.getPharmacyName());
        String result;
        String name = "Jankovic";        //ispraviti
        boolean status = medsPharmacy.hasPharmacyMedication(name, request.getMedicationName());
        if(status)
            result = " we have it.";
        else
            result = " we do not have it.";
        String message = "Hello from Pharmacy, medication you asked for " + request.getMedicationName() + result;
        ProtoResponseAvailableMedication responseMessage = ProtoResponseAvailableMedication.newBuilder()
                .setResponse(message).setStatus(status).build();
        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        System.out.println(responseMessage);
    }

    /*@Override
    public void communicateMedications(ProtoMedications request, StreamObserver<ProtoResponseMedications> responseObserver) {
        System.out.println("You are now communicating with hospital.");
        System.out.println("Message from Hospital to pharmacy: " + request.getPharmacyName());
        List<String> medications = new ArrayList<>();
        ProtoResponseMedications responseMessage = ProtoResponseMedications.newBuilder()
                .build();
        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        System.out.println(responseMessage);
    }*/
}
