package com.vco.CustomerAndOnlineOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CustomerAndOnlineOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAndOnlineOrderApplication.class, args);
	}

}
