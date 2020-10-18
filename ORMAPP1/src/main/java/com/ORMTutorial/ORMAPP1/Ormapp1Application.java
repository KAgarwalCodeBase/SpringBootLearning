package com.ORMTutorial.ORMAPP1;

import com.ORMTutorial.ORMAPP1.Entity.Customer;
import com.ORMTutorial.ORMAPP1.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ormapp1Application {
	private static final Logger log =
			LoggerFactory.getLogger(Ormapp1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Ormapp1Application.class, args);
	}
	@Bean
	public CommandLineRunner demo (CustomerRepository repository)
	{
		final CommandLineRunner commandLineRunner = (args) -> {
			//save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brain"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Kim", "Palmer"));
			repository.save(new Customer("Michelle", "Dassler"));

			//fetch all customer
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for(Customer customer: repository.findAll()){
				log.info(customer.toString());
			}
			log.info("");

			//fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("---------------------------------");
			log.info(customer.toString());
			log.info("");

			//fetch customer by firstname
			log.info("Customer found by firstName (Kim)");
			log.info("---------------------------------");
			repository.findByFirstName("Kim").forEach(kim ->{
				log.info(kim.toString());
			});
			log.info(" ");

			//fetch customer by last name
			log.info("Customer found by lastName (Bauer)");
			log.info("----------------------------------");
			repository.findByLastName("Bauer").forEach( bauer ->{
				log.info(bauer.toString());
			});
			log.info("");

			//fetch customer by fullName
			log.info("Customer found by fullName (jack Bauer)");
			log.info("---------------------------------------");
			repository.findByFullName("Jack Bauer").forEach( name->{
				log.info(name.toString());
			});
			log.info(" ");

		};
		return commandLineRunner;

	}

}
