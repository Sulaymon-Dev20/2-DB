package uz.ssd.locationsender.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/16/20
 * Time: 11:35 PM
 */
@Configuration
@EnableJpaRepositories(basePackages = "uz.ssd.locationsender.repository.locsender",
        entityManagerFactoryRef = "locSenderEntityManagerFactory",
        transactionManagerRef= "locSenderTransactionManager")
public class LocSenderDSConfig {

    @Bean
    @ConfigurationProperties("app.datasource.locsender")
    public DataSourceProperties locSenderDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.locsender.configuration")
    public HikariDataSource locSenderDataSource() {
        return locSenderDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "locSenderEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean locSenderEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(locSenderDataSource())
                .packages("uz.ssd.locationsender.domain.entity.locsender")
                .build();
    }

    @Bean
    public PlatformTransactionManager locSenderTransactionManager(
            final @Qualifier("locSenderEntityManagerFactory") LocalContainerEntityManagerFactoryBean locSenderEntityManagerFactory) {
        return new JpaTransactionManager(locSenderEntityManagerFactory.getObject());
    }
}
