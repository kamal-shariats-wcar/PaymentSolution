package ir.sayar.documentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class DocumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentationApplication.class, args);
	}

}

