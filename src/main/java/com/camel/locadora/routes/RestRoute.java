//package com.camel.locadora.routes;
//
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.model.rest.RestBindingMode;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RestRoute extends RouteBuilder {
//
//    @Override
//    public void configure() throws Exception {
//        restConfiguration()
//                .host("0.0.0.0").port(8090)
//                .bindingMode(RestBindingMode.auto);
//
//        rest("/movies")
//                .get("/")
//                .route().routeId("rest-all-authors")
//                .to("direct:call-rest-all")
//                .endRest()
//
//                .get("/authors/{name}")
//                .route().routeId("rest-author-by-name")
//                .to("direct:call-rest-author")
//                .endRest();
//    }
//}
