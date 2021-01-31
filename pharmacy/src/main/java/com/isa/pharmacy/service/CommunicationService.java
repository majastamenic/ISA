package com.isa.pharmacy.service;


import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.grpc.*;


@GrpcService
public class CommunicationService extends SpringGrpcServiceGrpc.SpringGrpcServiceImplBase {

    @Autowired
    private PharmacyService pharmacyService;

    @Override
    public void communicate(ProtoAvailableMedication request, StreamObserver<ProtoResponseAvailableMedication> responseObserver) {
        System.out.println("You are now communicating with hospital.");
        System.out.println("Message from Hospital: " + request.getPharmacyName());
        int quantity = pharmacyService.hasPharmacyMedication(request.getPharmacyName(), request.getMedicationName());

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

        ProtoResponseMedications.Builder builder = ProtoResponseMedications.newBuilder();
        for (MedicineDto medicineDto: pharmacyService.getMedicineListFromPharmacy(request.getPharmacyName()))
            builder.addMedication(ProtoMedication.newBuilder().setName(medicineDto.getName()).setAmount(medicineDto.getAmount()));
        ProtoResponseMedications responseMessage = builder.build();
        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        System.out.println(responseMessage);
    }
}
