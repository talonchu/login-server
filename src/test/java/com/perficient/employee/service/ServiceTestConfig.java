package com.perficient.employee.service;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestMvcConfiguration.class })
@WebAppConfiguration
public class ServiceTestConfig {
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
