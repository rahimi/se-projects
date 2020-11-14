/*import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.verify.VerificationTimes;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
*/
public class MockTest {
 /*   @Test
    public void mockedList(){
        List mockedList = mock(List.class);
        mockedList.add("hello!");
        mockedList.clear();

        verify(mockedList).add("hello!");
        verify(mockedList).clear();
    }
    @Test
    public void mockedExistingObject(){
        List<String> stringList = new ArrayList<>(Arrays.asList("1","2","3"));
        List<String> spy = spy(stringList);
        System.out.println(spy.get(0));
        doReturn("Hello!").when(spy).get(0);
        System.out.println(spy.get(0));
    }

    @Test
    public void authenticatorMock(){
        Session sessionMock = mock(Session.class);
        when(sessionMock.isValid()).thenReturn(true);
        System.out.println(sessionMock.isValid());
        verify(sessionMock).isValid();
    }

    @Test
    public void testAuthenticationServer() throws Exception {
        String message = "What a Day!";
        mockServer.when(
          request()
                  .withMethod("POST")
                  .withPath("/login")
                  .withBody("{username: 'foo', password: 'bar'")
        ).respond(
            response()
                    .withStatusCode(200)
                    .withBody(message)
                    .withHeader("Location","hsba.de")
        );

        HttpRequest req = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8888/login"))
                .POST(HttpRequest.BodyPublishers.ofString("{username: 'foo', password: 'bar'"))
                .build();
        HttpResponse<String> res = HttpClient.newBuilder().build().send(req,HttpResponse.BodyHandlers.ofString());

        assertEquals(res.body(),message);
        mockServer.verify(
                request().withPath("/login"),
                VerificationTimes.atLeast(2)
        );
    }

    @Test
    public void testAuthenticationServerWithREST() throws Exception {
        String message = "What a Day!";
        mockServer.when(
                request()
                        .withMethod("POST")
                        .withPath("/login")
                        .withBody("{username: 'foo', password: 'bar'}")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody(message)
                        .withHeader("Location","hsba.de")
        );

        HttpRequest req = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8888/login"))
                .POST(HttpRequest.BodyPublishers.ofString("{username: 'foo', password: 'bar'}"))
                .build();
        HttpResponse<String> res = HttpClient.newBuilder().build().send(req,HttpResponse.BodyHandlers.ofString());

        RestAssured.given()
                .port(8888)
                .body("{username: 'foo', password: 'bar'}")
                    .when()
                        .post("/login")
                            .then()
                            .assertThat()
                            .statusCode(equalTo(200));

    }

    private static ClientAndServer mockServer;
    @BeforeAll
    public static void startMockServer(){
        mockServer = ClientAndServer.startClientAndServer(8888);
    }

    @AfterAll
    public static void stopServer(){
        mockServer.stop();
    }*/
}
