package com.businesstier.grpc.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: proto.proto")
public final class CreateClientConnectionGrpc {

  private CreateClientConnectionGrpc() {}

  public static final String SERVICE_NAME = "CreateClientConnection";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.businesstier.grpc.protobuf.RequestText,
      com.businesstier.grpc.protobuf.ResponseText> getCreateClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createClient",
      requestType = com.businesstier.grpc.protobuf.RequestText.class,
      responseType = com.businesstier.grpc.protobuf.ResponseText.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.businesstier.grpc.protobuf.RequestText,
      com.businesstier.grpc.protobuf.ResponseText> getCreateClientMethod() {
    io.grpc.MethodDescriptor<com.businesstier.grpc.protobuf.RequestText, com.businesstier.grpc.protobuf.ResponseText> getCreateClientMethod;
    if ((getCreateClientMethod = CreateClientConnectionGrpc.getCreateClientMethod) == null) {
      synchronized (CreateClientConnectionGrpc.class) {
        if ((getCreateClientMethod = CreateClientConnectionGrpc.getCreateClientMethod) == null) {
          CreateClientConnectionGrpc.getCreateClientMethod = getCreateClientMethod =
              io.grpc.MethodDescriptor.<com.businesstier.grpc.protobuf.RequestText, com.businesstier.grpc.protobuf.ResponseText>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.businesstier.grpc.protobuf.RequestText.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.businesstier.grpc.protobuf.ResponseText.getDefaultInstance()))
              .setSchemaDescriptor(new CreateClientConnectionMethodDescriptorSupplier("createClient"))
              .build();
        }
      }
    }
    return getCreateClientMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CreateClientConnectionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateClientConnectionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateClientConnectionStub>() {
        @java.lang.Override
        public CreateClientConnectionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateClientConnectionStub(channel, callOptions);
        }
      };
    return CreateClientConnectionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CreateClientConnectionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateClientConnectionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateClientConnectionBlockingStub>() {
        @java.lang.Override
        public CreateClientConnectionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateClientConnectionBlockingStub(channel, callOptions);
        }
      };
    return CreateClientConnectionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CreateClientConnectionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateClientConnectionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateClientConnectionFutureStub>() {
        @java.lang.Override
        public CreateClientConnectionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateClientConnectionFutureStub(channel, callOptions);
        }
      };
    return CreateClientConnectionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CreateClientConnectionImplBase implements io.grpc.BindableService {

    /**
     */
    public void createClient(com.businesstier.grpc.protobuf.RequestText request,
        io.grpc.stub.StreamObserver<com.businesstier.grpc.protobuf.ResponseText> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateClientMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateClientMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.businesstier.grpc.protobuf.RequestText,
                com.businesstier.grpc.protobuf.ResponseText>(
                  this, METHODID_CREATE_CLIENT)))
          .build();
    }
  }

  /**
   */
  public static final class CreateClientConnectionStub extends io.grpc.stub.AbstractAsyncStub<CreateClientConnectionStub> {
    private CreateClientConnectionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateClientConnectionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateClientConnectionStub(channel, callOptions);
    }

    /**
     */
    public void createClient(com.businesstier.grpc.protobuf.RequestText request,
        io.grpc.stub.StreamObserver<com.businesstier.grpc.protobuf.ResponseText> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClientMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CreateClientConnectionBlockingStub extends io.grpc.stub.AbstractBlockingStub<CreateClientConnectionBlockingStub> {
    private CreateClientConnectionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateClientConnectionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateClientConnectionBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.businesstier.grpc.protobuf.ResponseText createClient(com.businesstier.grpc.protobuf.RequestText request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClientMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CreateClientConnectionFutureStub extends io.grpc.stub.AbstractFutureStub<CreateClientConnectionFutureStub> {
    private CreateClientConnectionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateClientConnectionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateClientConnectionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.businesstier.grpc.protobuf.ResponseText> createClient(
        com.businesstier.grpc.protobuf.RequestText request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClientMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CLIENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CreateClientConnectionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CreateClientConnectionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CLIENT:
          serviceImpl.createClient((com.businesstier.grpc.protobuf.RequestText) request,
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

  private static abstract class CreateClientConnectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CreateClientConnectionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.businesstier.grpc.protobuf.Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CreateClientConnection");
    }
  }

  private static final class CreateClientConnectionFileDescriptorSupplier
      extends CreateClientConnectionBaseDescriptorSupplier {
    CreateClientConnectionFileDescriptorSupplier() {}
  }

  private static final class CreateClientConnectionMethodDescriptorSupplier
      extends CreateClientConnectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CreateClientConnectionMethodDescriptorSupplier(String methodName) {
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
      synchronized (CreateClientConnectionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CreateClientConnectionFileDescriptorSupplier())
              .addMethod(getCreateClientMethod())
              .build();
        }
      }
    }
    return result;
  }
}
