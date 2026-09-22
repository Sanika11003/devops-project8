package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        int port = 8082; 
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        server.createContext("/", exchange -> {
            // 🟢 Fixed: Both lines combined seamlessly into a single variable name 'response'
            String response = "Hello, this is devops project to automate ECS deployment!\n" +
                             "This is updated application to check automation of ECS deployment!";
                             
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        System.out.println("Web server started successfully on port " + port);
        server.start();
    }
}

