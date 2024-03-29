package br.com.alura.linguagensAPI;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mainLanguages") //pega as informações do banco de dados
public class Language {
    
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

    public Language(){
        
    }

    public Language(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }
    public String getTitle() {
        
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRanking() {
        return ranking;
    }

}
