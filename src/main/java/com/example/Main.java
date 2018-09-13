package com.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;


import javax.ws.rs.Path;
import javax.ws.rs.core.UriBuilder;


@Path("/")
public class Main {

    private static URI getBaseURI(String hostname, int port) {
        return UriBuilder.fromUri("http://0.0.0.0/").port(port).build();
    }

    protected static HttpServer startServer(URI uri) throws IOException {
        System.out.println("Starting grizzly...");
        ResourceConfig rc = new ResourceConfig().packages("com.example");
        return GrizzlyHttpServerFactory.createHttpServer(uri, rc);
    }

    public static void main(String[] args) throws IOException {
        String hostname = System.getenv("HOSTNAME");
        if (hostname == null) {
            hostname = "localhost";
        }

        boolean isOnLocal = false;
        String port = System.getenv("PORT");
        if (port == null) {
            isOnLocal = true;
            port = "9998";
        }

        URI uri = getBaseURI(hostname, Integer.valueOf(port));

        HttpServer httpServer = startServer(uri);
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", uri, uri));
        if (isOnLocal) {
            System.in.read();
            httpServer.stop();
        } else {
            while (true) {
                System.in.read();
            }
        }

    }
}





