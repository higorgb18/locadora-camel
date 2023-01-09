package com.camel.locadora.routes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class AggregatorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("jetty").host("localhost").port(8081)
                .bindingMode(RestBindingMode.auto)
                .dataFormatProperty("prettyPrint", "true");

            rest("/movies")
                    .get("/")
                    .consumes("application/json").produces("application/json")
                    .to("http://localhost:8090?bridgeEndpoint=true")

                    .get("/{id}")
                    .consumes("application/json").produces("application/json")
                    .to("http://localhost:8090?bridgeEndpoint=true&?method=getMovie(${header.id})");
    }

}
