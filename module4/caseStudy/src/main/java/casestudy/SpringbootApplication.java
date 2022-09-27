package casestudy;

import casestudy.entity.customer.Customer;
import casestudy.repository.customer.ICustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;


@EnableJpaRepositories("casestudy.repository") // path of jpa repository
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
//    @Bean
//    CommandLineRunner init(ICustomerRepository customerRepository) {
//        return args -> {
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                Customer customer = new Customer(name, name.toLowerCase() + "@domain.com");
////                customerRepository.save(customer);
//            });
//            customerRepository.findAll().forEach(System.out::println);
//        };
//    }
}
