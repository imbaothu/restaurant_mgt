package com.example.SeftOrderingRestaurant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeftOrderingRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeftOrderingRestaurantApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(JdbcTemplate jdbcTemplate) {
		return args -> {
			try {
				int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'SeftOrderingRestaurant'", Integer.class);
				System.out.println("✅ Database Connected! Number of tables: " + count);
			} catch (Exception e) {
				System.err.println("❌ Database Connection Failed: " + e.getMessage());
			}
		};
	}
}