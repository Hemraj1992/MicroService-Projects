package com.HotelService.Config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "serviceDataSource",
		basePackages = {"com.HotelService.Repository"},
		transactionManagerRef = "serviceTransactionManager"
		)
public class ServiceDBConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean("serviceDataSource")
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		
		return dataSource;
		
	}
	
	@Bean(name = "serviceEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		
		bean.setDataSource(dataSource());
		
		Map<String, String> jpaProperties = new HashMap<String, String>();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		bean.setJpaPropertyMap(jpaProperties);
		
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
		
		bean.setPackagesToScan("com.HotelService.Entity");
		
		return bean;
		
	}
	
	@Bean(name = "serviceTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transManager = new JpaTransactionManager();
		transManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transManager;
	}

}
