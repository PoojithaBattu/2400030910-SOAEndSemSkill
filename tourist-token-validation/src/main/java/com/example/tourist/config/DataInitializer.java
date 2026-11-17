package com.example.tourist.config;

import com.example.tourist.model.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner loadSampleTourists(TouristRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Tourist("Aarav Sharma", "aarav@example.com", "India", "Goa"));
                repository.save(new Tourist("Emily Johnson", "emily@example.com", "USA", "Taj Mahal"));
                repository.save(new Tourist("Liam Brown", "liam@example.com", "UK", "Jaipur"));
            }
        };
    }
}
