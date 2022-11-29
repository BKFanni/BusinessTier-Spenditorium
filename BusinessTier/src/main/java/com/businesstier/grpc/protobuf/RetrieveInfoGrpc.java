package com.businesstier.grpc.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: proto.proto")
public final class RetrieveInfoGrpc {

  private RetrieveInfoGrpc() {}

  public static final String SERVICE_NAME = "RetrieveInfo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.businesstier.grpc.protobuf.RequestText,
      com.businesstier.grpc.protobuf.ResponseText> getRetrieveBillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "retrieveBill",
      requestType = com.businesstier.grpc.protobuf.RequestText.class,
      responseType = com.businesstier.grpc.protobuf.ResponseText.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.businesstier.grpc.protobuf.RequestText,
      com.businesstier.grpc.protobuf.ResponseText> getRetrieveBillMethod() {
    io.grpc.MethodDescriptor<com.businesstier.grpc.protobuf.RequestText, com.businesstier.grpc.protobuf.ResponseText> getRetrieveBillMethod;
    if ((getRetrieveBillMethod = RetrieveInfoGrpc.getRetrieveBillMethod) == null) {
      synchronized (RetrieveInfoGrpc.class) {
        if ((getRetrieveBillMethod = RetrieveInfoGrpc.getRetrieveBillMethod) == null) {
          RetrieveInfoGrpc.getRetrieveBillMethod = getRetrieveBillMethod =
              io.grpc.MethodDescriptor.<com.businesstier.grpc.protobuf.RequestText, com.businesstier.grpc.protobuf.ResponseText>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "retrieveBill"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.businesstier.grpc.protobuf.RequestText.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.businesstier.grpc.protobuf.ResponseText.getDefaultInstance()))
              .setSchemaDescriptor(new RetrieveInfoMethodDescriptorSupplier("retrieveBill"))
              .build();
        }
      }
    }
    return getRetrieveBillMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RetrieveInfoStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RetrieveInfoStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RetrieveInfoStub>() {
        @java.lang.Override
        public RetrieveInfoStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RetrieveInfoStub(channel, callOptions);
        }
      };
    return RetrieveInfoStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RetrieveInfoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RetrieveInfoBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RetrieveInfoBlockingStub>() {
        @java.lang.Override
        public RetrieveInfoBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RetrieveInfoBlockingStub(channel, callOptions);
        }
      };
    return RetrieveInfoBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RetrieveInfoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RetrieveInfoFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RetrieveInfoFutureStub>() {
        @java.lang.Override
        public RetrieveInfoFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RetrieveInfoFutureStub(channel, callOptions);
        }
      };
    return RetrieveInfoFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RetrieveInfoImplBase implements io.grpc.BindableService {

    /**
     */
    public void retrieveBill(com.businesstier.grpc.protobuf.RequestText request,
        io.grpc.stub.StreamObserver<com.businesstier.grpc.protobuf.ResponseText> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetrieveBillMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRetrieveBillMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.businesstier.grpc.protobuf.RequestText,
                com.businesstier.grpc.protobuf.ResponseText>(
                  this, METHODID_RETRIEVE_BILL)))
          .build();
    }
  }

  /**
   */
  public static final class RetrieveInfoStub extends io.grpc.stub.AbstractAsyncStub<RetrieveInfoStub> {
    private RetrieveInfoStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetrieveInfoStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RetrieveInfoStub(channel, callOptions);
    }

    /**
     */
    public void retrieveBill(com.businesstier.grpc.protobuf.RequestText request,
        io.grpc.stub.StreamObserver<com.businesstier.grpc.protobuf.ResponseText> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveBillMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RetrieveInfoBlockingStub extends io.grpc.stub.AbstractBlockingStub<RetrieveInfoBlockingStub> {
    private RetrieveInfoBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetrieveInfoBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RetrieveInfoBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.businesstier.grpc.protobuf.ResponseText retrieveBill(com.businesstier.grpc.protobuf.RequestText request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveBillMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RetrieveInfoFutureStub extends io.grpc.stub.AbstractFutureStub<RetrieveInfoFutureStub> {
    private RetrieveInfoFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetrieveInfoFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RetrieveInfoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.businesstier.grpc.protobuf.ResponseText> retrieveBill(
        com.businesstier.grpc.protobuf.RequestText request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveBillMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RETRIEVE_BILL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RetrieveInfoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RetrieveInfoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RETRIEVE_BILL:
          serviceImpl.retrieveBill((com.businesstier.grpc.protobuf.RequestText) request,
              (io.grpc.stub.StreamObserver<com.businesstier.grpc.protobuf.ResponseText>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RetrieveInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RetrieveInfoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.businesstier.grpc.protobuf.Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RetrieveInfo");
    }
  }

  private static final class RetrieveInfoFileDescriptorSupplier
      extends RetrieveInfoBaseDescriptorSupplier {
    RetrieveInfoFileDescriptorSupplier() {}
  }

  private static final class RetrieveInfoMethodDescriptorSupplier
      extends RetrieveInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RetrieveInfoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RetrieveInfoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RetrieveInfoFileDescriptorSupplier())
              .addMethod(getRetrieveBillMethod())
              .build();
        }
      }
    }
    return result;
  }
}
