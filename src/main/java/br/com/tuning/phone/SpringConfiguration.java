package br.com.tuning.phone;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {"br.com.tuning.phone"})
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan("br.com.tuning.phone")
public class SpringConfiguration {

	@Autowired
	private Environment env;

	  @Bean
	  @Autowired
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setShowSql(Boolean.TRUE);
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("br.com.tuning.phone");
	    
	    Properties jpaProperties = new Properties();
	    jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	    jpaProperties.put("hibernate.default_schema", env.getProperty("hibernate.default_schema"));
	    jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	    jpaProperties.put("hibernate.connection.driver_class", env.getProperty("hibernate.connection.driver_class"));
	    jpaProperties.put("hibernate.connection.url", env.getProperty("hibernate.connection.url"));
	    jpaProperties.put("hibernate.connection.username", env.getProperty("hibernate.connection.username"));
	    jpaProperties.put("hibernate.connection.password", env.getProperty("hibernate.connection.password"));
	    
	    factory.setJpaProperties(jpaProperties);
	    return factory;
	  }

	  @Bean
	  @Autowired
	  public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
	    return new JpaTransactionManager(entityManagerFactory.getObject());
	  }
}
