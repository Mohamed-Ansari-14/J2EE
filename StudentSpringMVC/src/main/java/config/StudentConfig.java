package config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"StudentSpringMVC"})
public class StudentConfig 
{
	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}
}
