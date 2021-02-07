package com.isa.pharmacy.service;


import com.isa.pharmacy.controller.dto.medicine.MedicineDto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.grpc.*;


@GrpcService
public class CommunicationService extends SpringGrpcServiceGrpc.SpringGrpcServiceImplBase {

    private final Logger logger = LoggerFactory.getLogger(CommunicationService.class);

    @Autowired
    private PharmacyService pharmacyService;

    @Override
    public void communicate(ProtoAvailableMedication request, StreamObserver<ProtoResponseAvailableMedication> responseObserver) {
        logger.info("You are now communicating with hospital.");
        logger.info("Message from Hospital: %s", request.getPharmacyName());
        int quantity = pharmacyService.hasPharmacyMedication(request.getPharmacyName(), request.getMedicationName());

        ProtoResponseAvailableMedication responseMessage = ProtoResponseAvailableMedication.newBuilder()
                .setAmount(quantity).build();

        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        logger.info("Response message: %s", responseMessage.toString());
    }

    @Override
    public void communicateMedications(ProtoMedications request, StreamObserver<ProtoResponseMedications> responseObserver) {
        logger.info("You are now communicating with hospital.");
        logger.info("Message from Hospital to pharmacy: %s" , request.getPharmacyName());

        ProtoResponseMedications.Builder builder = ProtoResponseMedications.newBuilder();

        for (MedicineDto medicineDto: pharmacyService.getMedicineListFromPharmacy(request.getPharmacyName()))
            builder.addMedication(ProtoMedication.newBuilder().setName(medicineDto.getName()).setAmount(medicineDto.getAmount()));

        ProtoResponseMedications responseMessage = builder.build();
        responseObserver.onNext(responseMessage);
        responseObserver.onCompleted();
        logger.info("Response message: %s", responseMessage.toString());
    }
}
