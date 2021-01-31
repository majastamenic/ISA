package com.isa.pharmacy;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;
import rs.ac.uns.ftn.grpc.NetGrpcServiceGrpc;

@Component
public class ScheduledTasks {

    @GrpcClient("netgrpcserver")
    private NetGrpcServiceGrpc.NetGrpcServiceBlockingStub stub;

}
