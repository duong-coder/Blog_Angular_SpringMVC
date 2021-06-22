package com.dependency.inject.stack.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	@Autowired
	Environment environment;
//	
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(environment.getProperty("spring.datasource.dbcp2.driver"));
//		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
//		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
//		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
//
//		return dataSource;
//	}
//	@Bean
//	public LocalSessionFactoryBean sessionFactoryBean() {
//		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource());
//		sessionFactoryBean.setPackagesToScan(new String[] {"com.dependency.inject.stack.domain"});
//		
//		Properties hibernateProperties = new Properties();
//		hibernateProperties.put("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
//		hibernateProperties.put("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));
//		
//		sessionFactoryBean.setHibernateProperties(hibernateProperties);
//		return sessionFactoryBean;
//	}
//	@Bean(name="hibernateTransactionManager")
//	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//		hibernateTransactionManager.setSessionFactory(sessionFactory);
//		
//		return hibernateTransactionManager;
//	}
}
