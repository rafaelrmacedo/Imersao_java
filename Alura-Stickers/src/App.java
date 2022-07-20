import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Fazer uma conexão HTTP e buscar os 250 filmes

        //String APIurl = "https://api.mocki.io/v2/549a5d8b/Top250Movies";

        String APIurl = "api.nasa.gov/planetary/apod?api_key=3WWIXgnZQTfWH6ax8ORltuWNr0ullwJ1areMBXGm&start_date=2022-07-12&end_date=2022-07-19";
        ContentExtractor extractor = new NasaContentExtractor();
        
        var http = new HTTPclient();
        String json = http.dataSearch(APIurl);

        //exibir e manipular os dados
        
        List<Content> contents = extractor.contentExtractor(json);

        // Exibir e manipular os dados
        var geradora = new gerador();

        for (int i = 0; i < 3; i++){

            Content content = contents.get(i); // lista para selecionar apenas o que quero
    
                InputStream inputStream = new URL (content.getUrlImage()).openStream();
                String Filename = "Alura-Stickers/saida/" + content.getTitle() + ".png";
    
                geradora.cria(inputStream, Filename);
    
                System.out.println(content.getTitle());
                System.out.println();
        }
    }
}
