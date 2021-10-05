package no.kristiania.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientTest {
    @Test
    void ShouldDoSomething() {
        assertEquals(200, 100+100);
    }

    @Test
    void shouldReturnStatusCode() {
        assertEquals(200, new HttpClient("httpbin", 80, "/html").getStatusCode());
    }
}
