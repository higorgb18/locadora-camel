package com.camel.locadora.routes;

import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AggregatorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("jetty").host("localhost").port(8081)
                .bindingMode(RestBindingMode.auto)
                .dataFormatProperty("prettyPrint", "true");

            rest("/movies")
                    .get("/")
                    .produces("application/json")
                    .consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
                    .to("http://localhost:8090?bridgeEndpoint=true");

    }

}
