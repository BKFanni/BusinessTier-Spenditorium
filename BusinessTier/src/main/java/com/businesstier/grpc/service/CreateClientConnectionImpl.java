package com.businesstier.grpc.service;

import com.businesstier.grpc.protobuf.CreateClientConnectionGrpc;
import com.businesstier.grpc.protobuf.RequestText;
import com.businesstier.grpc.protobuf.ResponseText;
import io.grpc.stub.StreamObserver;


public class CreateClientConnectionImpl extends CreateClientConnectionGrpc.CreateClientConnectionImplBase {
    @Override
    public void createClient(RequestText request, StreamObserver<ResponseText> responseObserver){
        System.out.println("\nReceived Request ===> "+request.toString());
        String tempRespond="Connection between tier2 and tier3 is working. Message from tier3: "+request.getInputText();
        ResponseText responseText=ResponseText.newBuilder().setOutputText(tempRespond).build();
        responseObserver.onNext(responseText);
        responseObserver.onCompleted();
    }
}
