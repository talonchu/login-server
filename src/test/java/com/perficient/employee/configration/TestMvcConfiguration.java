package com.perficient.employee.configration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import(value = { MockServicesConfiguration.class })
@ComponentScan(basePackages = { "com.perficient.employee.controller","com.perficient.employee.service" })
public class TestMvcConfiguration {

}
