package com.camel.locadora.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.springframework.stereotype.Component;

@Component
public class AgregatorRouter extends RouteBuilder {
    private static final int OK_CODE = 200;
    private static final int APP_RESPONSE_CODE = 204;

    @Override
    public void configure() throws Exception {
        from("direct:calRestMovie")
                .routeId("callRestService")
                .to("direct:movieService")
                .choice()
                .when(header(Exchange.HTTP_RESPONSE_CODE).isEqualTo(OK_CODE));

        from("direct:callRestAll")
                .routeId("allService")
                .removeHeaders("CamelHttp*")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("http://localhost:8090/movies");

//
//        from("direct:movieService")
//                .routeId("movieService")
//                .removeHeaders("CamelHttp*")
//                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
//                .toD("http://localhost:8090/movies/${id}");

    }
}
