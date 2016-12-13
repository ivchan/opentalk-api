/**
 * Created by ivanchan on 3/11/2016.
 */

package opentalk.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages={"opentalk.web","opentalk.service"})
//@EnableJpaRepositories(basePackages="opentalk.dao")
@EnableMongoRepositories(basePackages = "opentalk.dao")
@EntityScan(basePackages="opentalk.domainmodel")
public class ApplicationConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }
}
