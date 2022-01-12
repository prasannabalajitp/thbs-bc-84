
package com.th.ws.consume.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.th.ws.consume.demo.GetEmployeeResponse;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	CommandLineRunner lookup(EmployeeClient quoteClient) {
		return args -> {
			int employeeId = 3;

//			if (args.length > 0) {
//				employeeId = Integer.parseInt(args[0]);
//			}
			GetEmployeeResponse response = quoteClient.getEmployee(employeeId);
			System.err.println(response.getEmployee().getEmployeeId());
			System.err.println(response.getEmployee().getFirstName());
			System.err.println(response.getEmployee().getSalary());

		};
	}
}
