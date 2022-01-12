package com.th.ws.demo.config;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		LOG.info("messageDispatcherServlet");
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "employees")
	public DefaultWsdl11Definition employeeWsdl11Definition(XsdSchema employeesSchema) {
		LOG.info("employeeWsdl11Definition");
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("EmployeesPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("https://www.torryharris.com/soap-ws-demo");
		wsdl11Definition.setSchema(employeesSchema);
		return wsdl11Definition;
	}

	@Primary
	@Bean
	public XsdSchema employeeSchema() {
		LOG.info("employeeSchema");
		return new SimpleXsdSchema(new ClassPathResource("employees.xsd"));
	}

}
