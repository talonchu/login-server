package com.perficient.employee.configration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@Profile("test")
//@EntityScan(basePackages = { "com.perficient.employee.domin" })
@EnableJpaRepositories(basePackages = "com.perficient.employee.repository")
@EnableTransactionManagement
public class StandAloneDbConfiguration {

}
