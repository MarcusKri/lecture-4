package no.kristiania.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;

public class HttpServer {


    private final ServerSocket serverSocket;
    private Path rootDirectory;

    public HttpServer(int serverPort) throws IOException {
        serverSocket = new ServerSocket(serverPort);

        new Thread(this::handleClients).start();
    }

    private void handleClients() {
        try {
            Socket clientSocket = serverSocket.accept();

            String[] requestLine = HttpClient.readLine(clientSocket).split(" ");
            String requestTarget = requestLine[1];

            if (requestTarget.equals("/hello")) {
                String responseText = "Hello world";

                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Length: " + responseText.length() + "\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        responseText;
                clientSocket.getOutputStream().write(response.getBytes());
            } else {
                String responseText = "File not found: " + requestTarget;

                String response = "HTTP/1.1 404 Not found\r\n" +
                        "Content-Length: " + responseText.length() + "\r\n" +
                        "\r\n" +
                        responseText;
                clientSocket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new HttpServer(1997); //localhost:1997/hello
        ////Sette opp en webserver
        ////Kommenterer ut dette siden jeg har lagd en serverSocket aka website.
//        ServerSocket serverSocket = new ServerSocket(1997);
//
//        Socket clientSocket = serverSocket.accept();
//
//        String html = "Hello World";
//        String contentType = "text/html";
//
//        String response = "HTTP/1.1 200 Det gikk bra aka OK fra sia\r\n" +
//                "Content-Length: " + html.getBytes().length + "\r\n" +
//                "Content-Type: " + contentType + "\r\n" +
//                "Connection: close\r\n" +
//                "\r\n" +
//                html;

        //clientSocket.getOutputStream().write(response.getBytes());
        ////Kommenterer ut dette siden jeg har lagd en serverSocket.
        ////Sette opp en webserver finito

//        ServerSocket serverSocket = new ServerSocket(8080); //Localhost:8080
//
//        Socket clientSocket = serverSocket.accept();
//
//
//        String requestLine = HttpClient.readLine(clientSocket);
//
//        System.out.println(requestLine);
//
//        String headerLine;
//        while (!(headerLine = HttpClient.readLine(clientSocket)).isBlank()) {
//            System.out.println(headerLine);
//        } //18-20 Skriver ut headerLinen til porten.
//
//        String response = "<h1>Hello world</h1>";
//
//        clientSocket.getOutputStream().write((
//                "HTTP/1.1 200 OK\r\n" +
//                        "Content-Length: " + response.length() + "\r\n" +
//                        "Connection: close \r\n" +
//                        "\r\n" +
//                        response
//        ).getBytes());
    }

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    public void setRoot(Path rootDirectory) {

        this.rootDirectory = rootDirectory;
    }
}
