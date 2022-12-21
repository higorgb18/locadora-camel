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
//                .port(8090)
//                .bindingMode(RestBindingMode.auto);
//
//        rest("rest:get:movies")
//                .get("/")
//                .to("direct:http://localhost:8080/movies");
//
//    }
//}
