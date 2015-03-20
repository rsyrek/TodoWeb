package configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@ComponentScan(value = {"controllers,entities,repositories,services"})
@EnableWebMvc
@Configuration
public class AppConfig{
	@Bean
	public DataSource dataSource() {
	    EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
	    return databaseBuilder.setType(EmbeddedDatabaseType.H2).build();
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
	    properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	    properties.setProperty("hibernate.show_sql", "true");
	    return properties;
	}
	
//	@Bean
//	public ViewResolver cnViewResolver(){
//		return new ContentNegotiatingViewResolver();
//	}
	
//	@Bean
//	public View tasks(){
//		return new MappingJackson2JsonView();
//	}
	
//	@Bean
//	public GlobalExceptionHandler exceptionHandler(){
//		return new GlobalExceptionHandler();
//	}
	/*@Bean
    public TodoController todoController() {
        return new TodoController();
    }

    @Bean
    public TaskService taskService() {
        return new TaskService();
    }*/
}
