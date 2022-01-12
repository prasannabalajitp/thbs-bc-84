
package com.th.ws.consume.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.th.ws.consume.demo.GetEmployeeRequest;
import com.th.ws.consume.demo.GetEmployeeResponse;

public class EmployeeClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(EmployeeClient.class);

	public GetEmployeeResponse getEmployee(int employeeId) {

		GetEmployeeRequest request = new GetEmployeeRequest();
		request.setEmployeeId(employeeId);

		log.info("Requesting ... " + employeeId);

		GetEmployeeResponse response = (GetEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8099/ws/employees", request,
				new SoapActionCallback("https://www.torryharris.com/soap-ws-demo/GetEmployeeRequest"));

		return response;
	}

}
