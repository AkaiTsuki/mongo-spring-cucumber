package me.msc.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by jiachiliu on 2/12/15.
 */
@Configuration
@EnableMongoRepositories(basePackages = {"me.msc"})
public class PersistanceConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "mydb";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }

}
