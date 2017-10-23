package by.vadim.data.spring.data.mongodb.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "by.vadim.data.spring.data.mongodb.reactive.repository")
public class SpringDataMongodbReactiveApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongodbReactiveApplication.class, args);
	}
}
