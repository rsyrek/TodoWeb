package configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@ComponentScan(value = {"controllers,entities,repositories,services"})
@EnableWebMvc
@EnableTransactionManagement
@Configuration
public class AppConfig {
//	@Bean
//	public DataSource dataSource() {
//	    EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
//	    return databaseBuilder.setType(EmbeddedDatabaseType.H2).build();
//	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataBuilder = new BasicDataSource();
		dataBuilder.setDriverClassName("org.postgresql.Driver");
		dataBuilder.setUrl("jdbc:postgresql://localhost:5432/Todo");
		dataBuilder.setUsername("postgres");
		dataBuilder.setPassword("capsql");
		return dataBuilder;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(emf);
	    return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource(dataSource());
	    em.setPackagesToScan("entities");
	    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    em.setJpaVendorAdapter(vendorAdapter);
	    em.setJpaProperties(hibernateProperties());
	    em.afterPropertiesSet();
	    return em;
	}
	
	private Properties hibernateProperties() {
	    Properties properties = new Properties();
//	    properties.setProperty("hibernate.hbm2ddl.auto", "update");
	    properties.setProperty("hibernate.show_sql", "true");
	    return properties;
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return resolver;
	}
	
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
//		configurer.enable();
//	}
}