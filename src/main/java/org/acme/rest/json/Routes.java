package org.acme.rest.json;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.client.MongoClient;
import io.quarkus.mongodb.MongoClientName;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class Routes extends RouteBuilder {

    @Inject
    @MongoClientName(value="mongoClient1")
    MongoClient mongoClient1;

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .to("mongodb:mongoClient1?database=myDb&collection=myCollection&operation=findAll");
    }

}
