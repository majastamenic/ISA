package com.isa.pharmacy.service;


import com.isa.pharmacy.domain.MedicinePharmacy;
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
        int quantity = medsPharmacy.hasPharmacyMedication(request.getPharmacyName(), request.getMedicationName());

        ProtoResponseAvailableMedication responseMessage = ProtoResponseAvailableMedication.newBuilder()
                .setAmount(quantity).build();

        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        System.out.println(responseMessage);
    }

    @Override
    public void communicateMedications(ProtoMedications request, StreamObserver<ProtoResponseMedications> responseObserver) {
        System.out.println("You are now communicating with hospital.");
        System.out.println("Message from Hospital to pharmacy: " + request.getPharmacyName());

        ProtoResponseMedications.Builder b = ProtoResponseMedications.newBuilder();
        for (MedicinePharmacy m: medsPharmacy.getMedicinesFromPharmacy(request.getPharmacyName())) {
            b.addMedication(ProtoMedication.newBuilder().setName(m.getMedicine().getName()).setAmount(m.getQuantity()));
        }
        ProtoResponseMedications responseMessage = b.build();
        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        System.out.println(responseMessage);
    }
}
