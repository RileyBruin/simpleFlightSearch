package simpleflightsearch.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import simpleflightsearch.demo.Repo;


@EnableMongoRepositories(basePackageClasses=Repo.class)
@Configuration
public class MongodbConfig {


}
