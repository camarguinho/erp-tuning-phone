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
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
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
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}
	
	  @Bean
	  @Autowired
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
	    final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setDataSource(dataSource);
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setShowSql(Boolean.TRUE);
	    factory.setDataSource(dataSource);
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("br.com.tuning.phone");
	    Properties jpaProperties = new Properties();
	    factory.setJpaProperties(jpaProperties);
	    return factory;
	  }

	  @Bean
	  @Autowired
	  public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
	    return new JpaTransactionManager(entityManagerFactory.getObject());
	  }
}
