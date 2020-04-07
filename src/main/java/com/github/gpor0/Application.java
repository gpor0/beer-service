package com.github.gpor0;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ResourceConfig {

    public Application() {
        packages("com.github.gpor0.beer.rest.api");
    }

}
