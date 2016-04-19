package org.MockitoTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("Countries found with findAll():");
		for (Country country1 : countryService.findAll()) {
			log.info(country1.toString());
		}

		Country country2 = countryService.findOne(3);
		log.info("Country found with findOne(3):");
		log.info(country2.toString());

		log.info("Country found with findByCurrency(EUR)");
		for (Country country3 : countryService.findByCurrency("EUR")) {
			log.info(country3.toString());
		}

	}
}
