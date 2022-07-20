import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HTTPclient {
    
    public String dataSearch(String APIurl){

        try {

            URI address = URI.create(APIurl);
            var client = HttpClient.newHttpClient(); // podemos colocar var no lugar de HttClient, o java ja identifica
            var request = HttpRequest.newBuilder(address).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;

        } catch (IOException | InterruptedException ex){

            throw new RuntimeException(ex);

        }
    }
}
