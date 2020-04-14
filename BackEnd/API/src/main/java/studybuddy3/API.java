package studybuddy3;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages= {"PetsManagement","UserManagement","timerManagement","friendManagement","websocket"})
@EntityScan(basePackages= {"PetsManagement","UserManagement","timerManagement","friendManagement"})
@EnableJpaRepositories(basePackages= {"PetsManagement","UserManagement","timerManagement","friendManagement"})
@SpringBootApplication
@EnableSwagger2
public class API 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(API.class, args);
	}
	
	@Bean
	public Docket swaggerConfigure()
	{
		return new Docket(DocumentationType.SWAGGER_2).select().build().apiInfo(new ApiInfo(
				"StudyBuddy", 
				"REST API for the StudyBuddy Application",
				"1.0",
				"",
				new Contact("VB_5", "", ""),
				"",
				"",
				Collections.emptyList()
				));
	}
}
