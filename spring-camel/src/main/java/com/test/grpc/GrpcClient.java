package com.test.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {

		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9089").usePlaintext().build();

		GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

		GreetingRequest request = GreetingRequest.newBuilder().setRequest("Hi Server").build();

		GreetingResponse response = stub.processGrpcRequest(request);

		System.out.println("Message from server " + response);

	}

}
