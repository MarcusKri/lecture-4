package no.kristiania.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); //Localhost:8080

        Socket clientSocket = serverSocket.accept();


        String requestLine = HttpClient.readLine(clientSocket);

        System.out.println(requestLine);

        String headerLine;
        while (!(headerLine = HttpClient.readLine(clientSocket)).isBlank()) {
            System.out.println(headerLine);
        } //18-20 Skriver ut headerLinen til porten.

        String response = "<h1>Hello world</h1>";

        clientSocket.getOutputStream().write((
                "HTTP/1.1 200 OK\r\n" +
                        "Content-Length: " + response.length() + "\r\n" +
                        "Connection: close \r\n" +
                        "\r\n" +
                        response
        ).getBytes());
    }
}
