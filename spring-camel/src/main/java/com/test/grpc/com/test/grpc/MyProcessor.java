package com.test.grpc;

import java.io.IOException;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import io.grpc.*;

public class MyProcessor implements Processor {

	private int port;
	private Server server = null;

	MyProcessor(int port) {
		this.port = port;
	}

	public void init() {
		server = ServerBuilder.forPort(port).addService(new GreetingServiceImpl()).build();
		try {
			server.start();
		} catch (IOException e) {
			System.out.println("expection while starting server " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void process(Exchange exchange) throws Exception {
	}

	public void destroy() {
		server.shutdown();
		System.out.println("my processor bean destroyed");
	}

}
