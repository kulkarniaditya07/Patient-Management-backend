package com.pm.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> responseObserver) {
        //
        //StreamObserver is used by both the client stubs and service implementations for sending or receiving stream messages


        log.info("createBillingAccount request received = {}", billingRequest.toString());

        //Business logic e.g- saving to db, perform calculations.


        BillingResponse response=BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();
        responseObserver.onNext(response); //this line is very important as it is used to send a response back to a client
        //in this case it is going to be the PatientService

        responseObserver.onCompleted(); //this line means the response is completed, and we are ready to end the cycle
    }

}