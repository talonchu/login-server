package com.perficient.employee.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.perficient.employee.configration.TestMvcConfiguration;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestMvcConfiguration.class })
@WebAppConfiguration
public class ControllerTestConfig {
	@Autowired
	protected WebApplicationContext wac;

	protected MockMvc mockMvc;

	@Before
	public void before() {

		this.mockMvc = webAppContextSetup(this.wac).build();

	}

	@Test
	public void contextLoads() {
		assertNotNull(wac);
		assertNotNull(mockMvc);
	}

}
