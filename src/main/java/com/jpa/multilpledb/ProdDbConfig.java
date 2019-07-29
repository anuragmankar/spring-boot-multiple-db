package com.jpa.multilpledb;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "prodEntityManagerFactory",
		transactionManagerRef = "prodTransactionManager",
		basePackages = {"com.jpa.multilpledb.prod.repo"}
		)
public class ProdDbConfig {

	
	@Bean(name = "prodDataSource")
	@ConfigurationProperties(prefix = "prod.datasource")
	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean(name = "prodEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean prodEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("prodDataSource") DataSource prodDataSource)
	{ 
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.jdbc.lob.non_contextual_creation", true);
		return builder
				.dataSource(prodDataSource)
				.properties(properties)
				.packages("com.jpa.multilpledb.prod.domain")
				.persistenceUnit("prod")
				.build();
	}
	
	
	@Bean(name = "prodTransactionManager")
	public PlatformTransactionManager prodTransactionManager(
			@Qualifier("prodEntityManagerFactory") EntityManagerFactory prodEntityManagerFactory)
	{
		return new JpaTransactionManager(prodEntityManagerFactory);
	}
}

