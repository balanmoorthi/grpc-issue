package com.test.grpc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.JSONObject;

public class MyProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		JSONObject response = new JSONObject("{\"message\":\"Hello there\"}");;
		exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 201);
		exchange.getOut().setBody(response);
		
	}

}
