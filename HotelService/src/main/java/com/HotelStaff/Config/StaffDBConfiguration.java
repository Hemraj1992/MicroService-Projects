//package com.HotelStaff.Config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//		entityManagerFactoryRef = "staffEntityManagerFactoryBean",
//		basePackages = {"com.HotelStaff.Repository"},
//		transactionManagerRef = "staffTransactionManager"
//		)
//public class StaffDBConfiguration {
//	
//	
//	// this is used to get properties from property file
//	@Autowired
//	private Environment environment;
//	
//	
//	@Bean("staffDataSource")
////	@Primary
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		
//		System.out.println("URL value: "+ environment.getProperty("spring.staff-datasource.url"));
//		
//		dataSource.setUrl(environment.getProperty("spring.staff-datasource.url"));
//		dataSource.setUsername(environment.getProperty("spring.staff-datasource.username"));
//		dataSource.setPassword(environment.getProperty("spring.staff-datasource.password"));
//		
//		return dataSource;
//	}
//	
////	Have to create three beans: 1. Data source, 2. EntityManagerFactory, 3. PlateFormTransactionManager
//	
//	
//	@Bean(name = "staffEntityManagerFactoryBean")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//		
//		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//		
//		bean.setDataSource(dataSource());
//		
//		Map<String, String> jpaProperties = new HashMap<String, String>();
//		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//		jpaProperties.put("hibernate.show_sql", "true");
//		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
//		bean.setJpaPropertyMap(jpaProperties);
//		
//		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		bean.setJpaVendorAdapter(adapter);
//		
//		bean.setPackagesToScan("com.HotelStaff.Entity");
//		
//		return bean;
//		
//	}
//	
//	
//	@Bean(name = "staffTransactionManager")
////	@Primary
//	public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager transManager = new JpaTransactionManager();
//		transManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//		return transManager;
//	}
//	
//
//}
