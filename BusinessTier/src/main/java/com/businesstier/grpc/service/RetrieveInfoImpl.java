package com.businesstier.grpc.service;

import com.businesstier.grpc.protobuf.RequestText;
import com.businesstier.grpc.protobuf.ResponseText;
import com.businesstier.grpc.protobuf.RetrieveInfoGrpc;
import io.grpc.stub.StreamObserver;

public class RetrieveInfoImpl extends RetrieveInfoGrpc.RetrieveInfoImplBase {
    @Override
    public void retrieveBill(RequestText request, StreamObserver<ResponseText> responseObserver){
        System.out.println("\nReceived Request ===> "+request.toString());
        String tempRespond="The requested bill: "+request.getInputText();
        ResponseText responseText=ResponseText.newBuilder().setOutputText(tempRespond).build();
        responseObserver.onNext(responseText);
        responseObserver.onCompleted();
    }
}
