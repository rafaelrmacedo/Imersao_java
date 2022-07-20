import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Fazer uma conexão HTTP e buscar os 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient(); // podemos colocar var no lugar de HttClient, o java ja identifica
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        

        // Pegar apenas os dados que interessam (título, poster, rating)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir e manipular os dados
        var geradora = new gerador();

        for (Map<String,String> filme : listaDeFilmes) { // lista para selecionar apenas o que quero

            // criação dos stickers
            String titulo = filme.get("title");
            String urlImage = filme.get("image");

            InputStream inputStream = new URL (urlImage).openStream();
            String Filename = titulo + ".png";

            geradora.cria(inputStream, Filename);

            // parte de classificação no terminal

            System.out.println();
            System.out.printf("\u001b[1m Título: \u001b[0m %s", filme.get("title")); // \u001b[0m esse tipo de código serve para decorar o terminal
            System.out.println();
            System.out.printf("\u001b[1m Poster: \u001b[0m %s", filme.get("image"));
            System.out.println();
            System.out.printf("\u001b[44m \u001b[1m Classificação: \u001b[0m \u001b[0m %s", filme.get("imDbRating"));

            int i;
            float imDbRating = Float.parseFloat(filme.get("imDbRating"));

                for (i = 0; i < imDbRating; i++){ //adição de estrelas de classificação
                    System.out.print("\u2B50"); // emoji da estrela \u2B50
                }
            System.out.println();
            System.out.println();
        }

    }
}
