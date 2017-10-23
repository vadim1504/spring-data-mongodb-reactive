package by.vadim.data.spring.data.mongodb.reactive.repository;

import by.vadim.data.spring.data.mongodb.reactive.model.Customer;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveSortingRepository<Customer, String> {

    Flux<Customer> findByFirstName(Mono<String> firstName);
    Flux<Customer> findByLastName(Mono<String> lastName);
    Flux<Customer> findByAge(Integer age);
    Flux<Customer> findByFirstNameStartingWith(Mono<String> regexp);
    Flux<Customer> findByFirstNameEndingWith(Mono<String> regexp);
    Flux<Customer> findByAgeBetween(Integer ageGT, Integer ageLT);
    Flux<Customer> findByFirstNameLikeOrderByAgeAsc(Mono<String> firstName);
}
