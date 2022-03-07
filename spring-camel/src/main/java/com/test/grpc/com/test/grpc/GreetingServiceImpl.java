package com.test.grpc;

import io.grpc.stub.StreamObserver;


public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

	@Override
	public void processGrpcRequest(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {

		String receivedMessage = request.getRequest();

		GreetingResponse response = GreetingResponse.newBuilder()
				.setResponse("Your message received " + receivedMessage).build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
