package by.vadim.data.spring.data.mongodb.reactive.controller;

import by.vadim.data.spring.data.mongodb.reactive.model.Customer;
import by.vadim.data.spring.data.mongodb.reactive.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customer")
    Flux<Customer> getCustomers() {
        return repository.findAll();
    }

    @GetMapping(value = "/customer", params = {"firstName"})
    Flux<Customer> getCustomersByFirstName(@RequestParam(name = "firstName") String firstName) {
        return repository.findByFirstName(Mono.just(firstName));
    }

    @GetMapping(value = "/customer", params = {"sort"})
    Flux<Customer> getCustomersSortedFirstName(@RequestParam(name = "sort") String sort) {
        if(sort.equals("ASC"))
            return repository.findAll(new Sort(Sort.Direction.ASC,"firstName"));
        return repository.findAll(new Sort(Sort.Direction.DESC,"firstName"));
    }

    @GetMapping(value = "/customer", params = {"lastName"})
    Flux<Customer> getCustomersByLastName(@RequestParam(name = "lastName") String lastName) {
        return repository.findByLastName(Mono.just(lastName));
    }

    @GetMapping(value = "/customer", params = {"age"})
    Flux<Customer> getCustomersByAge(@RequestParam(name = "age") Integer age) {
        return repository.findByAge(age);
    }

    @GetMapping(value = "/customer", params = {"firstNameStartingWith"})
    Flux<Customer> getCustomersByFirstNameStartingWith(@RequestParam(name = "firstNameStartingWith") String regexp) {
        return repository.findByFirstNameStartingWith(Mono.just(regexp));
    }

    @GetMapping(value = "/customer", params = {"firstNameEndingWith"})
    Flux<Customer> getCustomersByFirstNameEndingWith(@RequestParam(name = "firstNameEndingWith") String regexp) {
        return repository.findByFirstNameEndingWith(Mono.just(regexp));
    }

    @GetMapping(value = "/customer", params = {"ageGT","ageLT"})
    Flux<Customer> getCustomersByAgeBetween(@RequestParam(name = "ageGT") Integer ageGT,@RequestParam(name = "ageLT") Integer ageLT) {
        return repository.findByAgeBetween(ageGT,ageLT);
    }

    @GetMapping(value = "/customer", params = {"firstNameLikeOrderByAgeAsc"})
    Flux<Customer> getCustomersByFirstNameLikeOrderByAgeAsc(@RequestParam(name = "firstNameLikeOrderByAgeAsc") String firstName) {
        return repository.findByFirstNameLikeOrderByAgeAsc(Mono.just(firstName));
    }
}
