package com.epam.producing.testProject.configuration;

import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.Customer;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.CustomersRepository;
import com.epam.producing.testProject.web.CustomerController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@Slf4j
public class LoadDatabase {
    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomersRepository repository, AddressRepository addressRepository){
        return args -> {
            Customer customer1 = new Customer("Bilbo", "bulgar");
            Customer customer2 = new Customer("Ivan", "bulgar");
            Customer customer3 = new Customer("Anton", "bulgar");

            log.info("PreLoading"+repository.save(customer1));
            log.info("PreLoading"+repository.save(customer2));
            log.info("PreLoading"+repository.save(customer3));

            log.info("PreLoading"+addressRepository.save(new Address("kyiv",customer1)));
            log.info("PreLoading"+addressRepository.save(new Address("lviv",customer1)));
            log.info("PreLoading"+addressRepository.save(new Address("vinnytsa",customer1)));

            log.info("PreLoading"+addressRepository.save(new Address("kyiv",customer2)));
            log.info("PreLoading"+addressRepository.save(new Address("rym",customer2)));
            log.info("PreLoading"+addressRepository.save(new Address("dnipro",customer2)));

            log.info("PreLoading"+addressRepository.save(new Address("rivne",customer3)));
            log.info("PreLoading"+addressRepository.save(new Address("kyiv",customer3)));
            log.info("PreLoading"+addressRepository.save(new Address("new york",customer3)));

        };
    }
}
