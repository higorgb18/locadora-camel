package com.camel.locadora.routes;

import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
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
    }
}
