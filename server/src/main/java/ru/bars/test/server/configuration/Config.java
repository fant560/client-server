package ru.bars.test.server.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class Config {

    @Bean
    FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
        return new FlywayMigrationInitializer(flyway, f -> {
            //пропускаем
        });
    }


    /**
     * Не нашел другого адекватного решения запускать flyway после hibernate
     *
     * @param flyway
     * @return
     */
    @Bean
    @DependsOn("entityManagerFactory")
    FlywayMigrationInitializer delayedFlywayInitializer(Flyway flyway) {
        return new FlywayMigrationInitializer(flyway, strategy -> {
            flyway.repair();
            flyway.migrate();
        });
    }

}
