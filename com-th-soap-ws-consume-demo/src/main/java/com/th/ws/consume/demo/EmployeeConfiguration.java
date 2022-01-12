
package com.th.ws.consume.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class EmployeeConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.th.ws.consume.demo");
		return marshaller;
	}

	@Bean
	public EmployeeClient employeeClient(Jaxb2Marshaller marshaller) {
		EmployeeClient client = new EmployeeClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
