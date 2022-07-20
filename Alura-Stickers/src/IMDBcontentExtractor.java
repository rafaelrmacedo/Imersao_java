import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBcontentExtractor  implements ContentExtractor{

    public List<Content> contentExtractor(String json){
        
        // Pegar apenas os dados que interessam (título, poster, rating)
        var parser = new JsonParser();
        List<Map<String, String>> AttributeList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        //popular a lista de conteudos

        for (Map<String, String> attributes : AttributeList) {

            String title = attributes.get("title");
            String urlImage = attributes.get("image");
            var content = new Content(title, urlImage);

            contents.add(content);
        }

        return contents;
    }
}
