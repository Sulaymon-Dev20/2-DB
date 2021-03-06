package uz.ssd.locationsender.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/16/20
 * Time: 11:34 PM
 */
@Configuration
@EnableJpaRepositories(basePackages = "uz.ssd.locationsender.repository.asdum",
        entityManagerFactoryRef = "asdumEntityManagerFactory",
        transactionManagerRef= "asdumTransactionManager")
public class AsdumDSConfig {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.asdum")
    public DataSourceProperties asdumDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "asdumEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean asdumEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(asdumDataSource())
                .packages("uz.ssd.locationsender.domain.entity.asdum")
                .build();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.asdum.configuration")
    public HikariDataSource asdumDataSource() {
        return asdumDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager asdumTransactionManager(
            final @Qualifier("asdumEntityManagerFactory") LocalContainerEntityManagerFactoryBean asdumEntityManagerFactory) {
        return new JpaTransactionManager(asdumEntityManagerFactory.getObject());
    }
}
