package studybuddy3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages= {"PetsManagement","UserManagement"})
@EntityScan(basePackages= {"PetsManagement","UserManagement"})
@EnableJpaRepositories(basePackages= {"PetsManagement","UserManagement"})
@SpringBootApplication
public class API 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(API.class, args);
	}
}
