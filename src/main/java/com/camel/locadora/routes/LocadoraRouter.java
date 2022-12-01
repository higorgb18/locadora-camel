package com.camel.locadora.routes;

import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LocadoraRouter extends RouteBuilder {

    public static final String ROUTE_GET = "direct:movieRouter";
    public static final String ROUTE_GET_BY_ID = "direct:movieRouterById";
    public static final String ROUTE_POST = "direct:movieRouterPost";
    public static final String ROUTE_PUT = "direct:movieRouterPut";
    public static final String ROUTE_DELETE = "direct:movieRouterDelete";

    public void configure() throws Exception {

//            from("direct:dbInput")
//                    .to("log:?level=INFO&showBody=true")
//                    .process(new InsertProcessor())
//                    .to("jdbc:myDataSource");

//        from(ROUTE_GET)
//                .bean("a", "findAll");

//        from("timer://test?period=5000")
//                .log("log:test");
//
//        from("timer://timer1?period=2s")
//                .to("sql:select * from tb_movies");

//        from("direct:moviesAll").routeId("moviesAll").to("http://localhost:8090/movies").log("${body}");

//        from("direct:moviesAll").setHeader(Exchange.HTTP_METHOD, simple("GET"))
//                .to("http://localhost:8090/movies").log("${body}");

//        rest().path("/rest").consumes("application/json").produces("application/json")
//                .get().to("http://localhost:8090/movies");
//        from("http://localhost:8090/movies").transform().constant("${body}");

//        from("timer://movieAll?repeatCount=1")
//                .setBody(constant("SELECT * FROM tb_movies LIMIT 10"))
//                .to("jdbc:postgresql")
//                .log("${body}");

        restConfiguration().host("localhost").port(8090)
                .bindingMode(RestBindingMode.auto);

        //inicia delaração dos serviços REST
        rest("/movies")
                //Endpoint que consulta todos os filmes
                .get("/")
                .routeId("restAllMovies")
                .to("direct:callRestAll");

        from("direct:callRestAll")
                .routeId("allService")
                .removeHeaders("CamelHttp*")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("http:/localhost:8080/movies");


    }
}
