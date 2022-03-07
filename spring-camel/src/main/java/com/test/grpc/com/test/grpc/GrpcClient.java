package com.test.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {

		long cstart = System.currentTimeMillis();
		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9050").usePlaintext().build();
		long cend = System.currentTimeMillis();

		System.out.println("channel created in " + (cend - cstart) + " milliseconds ");

		long sstart = System.currentTimeMillis();
		GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
		long send = System.currentTimeMillis();

		System.out.println("stub created in {} " + (send - sstart) + " milliseconds ");

		long req1start = System.currentTimeMillis();
		GreetingRequest request = GreetingRequest.newBuilder().setRequest("Hello").build();
		GreetingResponse response = stub.processGrpcRequest(request);
		long req1end = System.currentTimeMillis();

		System.out.println("Message from server " + response);

		System.out.println("Request 1 time taken {} " + (req1end - req1start));

		long start = System.currentTimeMillis();
		request = GreetingRequest.newBuilder().setRequest("request 2 test").build();
		response = stub.processGrpcRequest(request);
		long end = System.currentTimeMillis();

		System.out.println("Message from server " + response);

		System.out.println("Request 2 time taken {} " + (end - start));
		
		
		start = System.currentTimeMillis();
		request = GreetingRequest.newBuilder().setRequest(" request 3 test").build();
		response = stub.processGrpcRequest(request);
		end = System.currentTimeMillis();

		System.out.println("Message from server " + response);

		System.out.println("Request 3 time taken {} " + (end - start));		
		
		start = System.currentTimeMillis();
		request = GreetingRequest.newBuilder().setRequest(" request 4 test").build();
		response = stub.processGrpcRequest(request);
		end = System.currentTimeMillis();

		System.out.println("Message from server " + response);

		System.out.println("Request 4 time taken {} " + (end - start));				

	}

}
